package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.ChekuEntity;
import com.entity.YonghuEntity;
import com.service.ChekuService;
import com.service.YonghuService;
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

import com.entity.YuyvejiluEntity;

import com.service.YuyvejiluService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 预约记录
 * 后端接口
 * @author
 * @email
 * @date 2021-03-16
*/
@RestController
@Controller
@RequestMapping("/yuyvejilu")
public class YuyvejiluController {
    private static final Logger logger = LoggerFactory.getLogger(YuyvejiluController.class);

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
        }else if(request.getSession().getAttribute("role").equals("用户")){
            params.put("yhTypes",request.getSession().getAttribute("userId"));
        }
        page = yuyvejiluService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        YuyvejiluEntity yuyvejilu = yuyvejiluService.selectById(id);
        if(yuyvejilu!=null){
            return R.ok().put("data", yuyvejilu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuyvejiluEntity yuyvejilu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<YuyvejiluEntity> queryWrapper = new EntityWrapper<YuyvejiluEntity>()
            .eq("ck_types", yuyvejilu.getCkTypes())
            .eq("yh_types", yuyvejilu.getYhTypes())
            .eq("ry_types", yuyvejilu.getRyTypes())
            .eq("location", yuyvejilu.getLocation())
            .eq("day", yuyvejilu.getDay())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyvejiluEntity yuyvejiluEntity = yuyvejiluService.selectOne(queryWrapper);
        if(yuyvejiluEntity==null){
            yuyvejiluService.insert(yuyvejilu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuyvejiluEntity yuyvejilu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<YuyvejiluEntity> queryWrapper = new EntityWrapper<YuyvejiluEntity>()
            .notIn("id",yuyvejilu.getId())
            .eq("ck_types", yuyvejilu.getCkTypes())
            .eq("yh_types", yuyvejilu.getYhTypes())
            .eq("ry_types", yuyvejilu.getRyTypes())
            .eq("location", yuyvejilu.getLocation())
            .eq("day", yuyvejilu.getDay())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyvejiluEntity yuyvejiluEntity = yuyvejiluService.selectOne(queryWrapper);
        if(yuyvejiluEntity==null){
            yuyvejiluService.updateById(yuyvejilu);//根据id更新
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
            return R.error("续租时间不能为空");
        }
        if(day > 30){
            return R.error("续租时间不能大于30天");
        }
        YuyvejiluEntity yuyvejilu = yuyvejiluService.selectById(id);
        if(yuyvejilu == null){
            return R.error();
        }
        YonghuEntity yonghu = yonghuService.selectById(userId);
        YonghuEntity user = yonghuService.selectById(yuyvejilu.getRyTypes());
        int i = (yuyvejilu.getDayMax() / yuyvejilu.getDay())*day;
        yuyvejilu.setDayMax(yuyvejilu.getDayMax() +(day*i));
        yuyvejilu.setDay(yuyvejilu.getDay() + day);
        if(yonghu.getMoney() < (day*i)){
            return R.error("余额不足请充值");
        }
        yonghu.setMoney(yonghu.getMoney()-(day*i));
        user.setMoney(user.getMoney()+(day*i));
        yuyvejiluService.updateById(yuyvejilu);
        yonghuService.updateById(yonghu);
        yonghuService.updateById(user);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(Integer ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        YuyvejiluEntity yuyvejilu = yuyvejiluService.selectById(ids);
        ChekuEntity cheku = chekuService.selectById(yuyvejilu.getCkTypes());
        cheku.setCkztTypes(2);
        chekuService.updateById(cheku);
        yuyvejiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

