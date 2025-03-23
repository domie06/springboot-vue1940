package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.YonghuEntity;
import com.entity.YuyvejiluEntity;
import com.service.YonghuService;
import com.service.YuyvejiluService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ChekuEntity;

import com.service.ChekuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 洗衣机
 * 后端接口
 * @author
 * @email
 * @date 2021-03-16
*/
@RestController
@Controller
@RequestMapping("/cheku")
public class ChekuController {
    private static final Logger logger = LoggerFactory.getLogger(ChekuController.class);

    @Autowired
    private ChekuService chekuService;

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private YuyvejiluService yuyvejiluService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = null;
        if(request.getSession().getAttribute("role").equals("车库主人")){
            params.put("ryTypes",request.getSession().getAttribute("userId"));
        }
        page = chekuService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ChekuEntity cheku = chekuService.selectById(id);
        if(cheku!=null){
            return R.ok().put("data", cheku);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChekuEntity cheku, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ChekuEntity> queryWrapper = new EntityWrapper<ChekuEntity>()
            .eq("name", cheku.getName())
            .eq("location", cheku.getLocation())
            .eq("ry_types", cheku.getRyTypes())
            .eq("garageSize", cheku.getGarageSize())
            .eq("money", cheku.getMoney())
            .eq("ckzt_types", cheku.getCkztTypes())
            .eq("matter_content", cheku.getMatterContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChekuEntity chekuEntity = chekuService.selectOne(queryWrapper);
        if("".equals(cheku.getImgPhoto()) || "null".equals(cheku.getImgPhoto())){
            cheku.setImgPhoto(null);
        }
        if(chekuEntity==null){
            cheku.setCkztTypes(2);
            chekuService.insert(cheku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChekuEntity cheku, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ChekuEntity> queryWrapper = new EntityWrapper<ChekuEntity>()
            .notIn("id",cheku.getId())
            .eq("name", cheku.getName())
            .eq("location", cheku.getLocation())
            .eq("ry_types", cheku.getRyTypes())
            .eq("garageSize", cheku.getGarageSize())
            .eq("money", cheku.getMoney())
            .eq("ckzt_types", cheku.getCkztTypes())
            .eq("matter_content", cheku.getMatterContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChekuEntity chekuEntity = chekuService.selectOne(queryWrapper);
        if("".equals(cheku.getImgPhoto()) || "null".equals(cheku.getImgPhoto())){
                cheku.setImgPhoto(null);
        }
        if(chekuEntity==null){
            chekuService.updateById(cheku);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/renting")
    public R renting(Integer id,Integer day, HttpServletRequest request){
        Long u = (Long) request.getSession().getAttribute("userId");
        Integer userId = Integer.parseInt(String.valueOf(u));
        if(day == null){
            return R.error("使用时间不能为空");
        }
        if(day > 30){
            return R.error("使用时间不能大于30天");
        }
        ChekuEntity cheku = chekuService.selectById(id);
        if(cheku == null){
            return R.error();
        }
        if(cheku.getCkztTypes() == 1){
            return R.error("这个车库已经出租");
        }
        //算账
        YonghuEntity yonghu = yonghuService.selectById(userId);
        YonghuEntity user = yonghuService.selectById(cheku.getRyTypes());
        if(user == null){
            return R.error();
        }
        if(yonghu == null){
            return R.error();
        }
        YuyvejiluEntity yuyvejilu = new YuyvejiluEntity();
        yuyvejilu.setCreateTime(new Date());
        yuyvejilu.setCkTypes(id);
        yuyvejilu.setYhTypes(userId);
        yuyvejilu.setRyTypes(cheku.getRyTypes());
        yuyvejilu.setDay(day);
        yuyvejilu.setLocation(cheku.getLocation());
        Integer max = day * cheku.getMoney();
        yuyvejilu.setDayMax(max);
        if(yonghu.getMoney() < max){
            return R.error("余额不足请充值");
        }
        yonghu.setMoney(yonghu.getMoney()-max);
        user.setMoney(user.getMoney()+max);
        Wrapper<YuyvejiluEntity> queryWrapper = new EntityWrapper<YuyvejiluEntity>()
                .eq("ck_types", yuyvejilu.getCkTypes())
                .eq("yh_types", yuyvejilu.getYhTypes())
                .eq("ry_types", yuyvejilu.getRyTypes())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyvejiluEntity yuyvejiluEntity = yuyvejiluService.selectOne(queryWrapper);
        if(yuyvejiluEntity==null){
            cheku.setCkztTypes(1);
            chekuService.updateById(cheku);
            yonghuService.updateById(yonghu);
            yonghuService.updateById(user);
            yuyvejiluService.insert(yuyvejilu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/thumbsupnumClick")
    public R thumbsupnumClick(Integer ids){
        ChekuEntity cheku = chekuService.selectById(ids);
        if(cheku == null){
           return R.error();
        }
        if(cheku.getThumbsupnum() < 0 || cheku.getThumbsupnum()== null){
            cheku.setThumbsupnum(0);
        }
        cheku.setThumbsupnum(cheku.getThumbsupnum()+1);
        chekuService.updateById(cheku);
        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/crazilynumClick")
    public R crazilynumClick(Integer ids){
        ChekuEntity cheku = chekuService.selectById(ids);
        if(cheku == null){
            return R.error();
        }
        if(cheku.getCrazilynum() < 0 || cheku.getCrazilynum()== null){
            cheku.setCrazilynum(0);
        }
        cheku.setCrazilynum(cheku.getCrazilynum()+1);
        chekuService.updateById(cheku);
        return R.ok();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        chekuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

