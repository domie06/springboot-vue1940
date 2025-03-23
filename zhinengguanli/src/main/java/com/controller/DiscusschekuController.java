package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusschekuEntity;
import com.entity.view.DiscusschekuView;

import com.service.DiscusschekuService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;


/**
 * 车库评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-11 18:11:06
 */
@RestController
@RequestMapping("/discusscheku")
public class DiscusschekuController {
    @Autowired
    private DiscusschekuService discusschekuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusschekuEntity discusscheku,
		HttpServletRequest request){

        EntityWrapper<DiscusschekuEntity> ew = new EntityWrapper<DiscusschekuEntity>();
    	PageUtils page = discusschekuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusscheku), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscusschekuEntity discusscheku, HttpServletRequest request){
        EntityWrapper<DiscusschekuEntity> ew = new EntityWrapper<DiscusschekuEntity>();
    	PageUtils page = discusschekuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusscheku), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusschekuEntity discusscheku){
       	EntityWrapper<DiscusschekuEntity> ew = new EntityWrapper<DiscusschekuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusscheku, "discusscheku")); 
        return R.ok().put("data", discusschekuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusschekuEntity discusscheku){
        EntityWrapper<DiscusschekuEntity> ew = new EntityWrapper<DiscusschekuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusscheku, "discusscheku")); 
		DiscusschekuView discusschekuView =  discusschekuService.selectView(ew);
		return R.ok("查询车库评论表成功").put("data", discusschekuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusschekuEntity discusscheku = discusschekuService.selectById(id);
        return R.ok().put("data", discusscheku);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusschekuEntity discusscheku = discusschekuService.selectById(id);
        return R.ok().put("data", discusscheku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusschekuEntity discusscheku, HttpServletRequest request){
    	discusscheku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusscheku);

        discusschekuService.insert(discusscheku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusschekuEntity discusscheku, HttpServletRequest request){
    	discusscheku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusscheku);

        discusschekuService.insert(discusscheku);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusschekuEntity discusscheku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusscheku);
        discusschekuService.updateById(discusscheku);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusschekuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscusschekuEntity> wrapper = new EntityWrapper<DiscusschekuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusschekuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
