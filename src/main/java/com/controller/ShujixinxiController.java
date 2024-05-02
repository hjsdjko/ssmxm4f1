package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShujixinxiEntity;
import com.entity.view.ShujixinxiView;

import com.service.ShujixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 书籍信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-27 10:50:35
 */
@RestController
@RequestMapping("/shujixinxi")
public class ShujixinxiController {
    @Autowired
    private ShujixinxiService shujixinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShujixinxiEntity shujixinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			shujixinxi.setMaijiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShujixinxiEntity> ew = new EntityWrapper<ShujixinxiEntity>();
		PageUtils page = shujixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujixinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShujixinxiEntity shujixinxi, 
		HttpServletRequest request){
        EntityWrapper<ShujixinxiEntity> ew = new EntityWrapper<ShujixinxiEntity>();
		PageUtils page = shujixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShujixinxiEntity shujixinxi){
       	EntityWrapper<ShujixinxiEntity> ew = new EntityWrapper<ShujixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shujixinxi, "shujixinxi")); 
        return R.ok().put("data", shujixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShujixinxiEntity shujixinxi){
        EntityWrapper< ShujixinxiEntity> ew = new EntityWrapper< ShujixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shujixinxi, "shujixinxi")); 
		ShujixinxiView shujixinxiView =  shujixinxiService.selectView(ew);
		return R.ok("查询书籍信息成功").put("data", shujixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShujixinxiEntity shujixinxi = shujixinxiService.selectById(id);
		shujixinxi.setClicknum(shujixinxi.getClicknum()+1);
		shujixinxi.setClicktime(new Date());
		shujixinxiService.updateById(shujixinxi);
        return R.ok().put("data", shujixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShujixinxiEntity shujixinxi = shujixinxiService.selectById(id);
		shujixinxi.setClicknum(shujixinxi.getClicknum()+1);
		shujixinxi.setClicktime(new Date());
		shujixinxiService.updateById(shujixinxi);
        return R.ok().put("data", shujixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShujixinxiEntity shujixinxi, HttpServletRequest request){
    	shujixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shujixinxi);

        shujixinxiService.insert(shujixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShujixinxiEntity shujixinxi, HttpServletRequest request){
    	shujixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shujixinxi);

        shujixinxiService.insert(shujixinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShujixinxiEntity shujixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shujixinxi);
        shujixinxiService.updateById(shujixinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shujixinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ShujixinxiEntity> wrapper = new EntityWrapper<ShujixinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			wrapper.eq("maijiazhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = shujixinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShujixinxiEntity shujixinxi, HttpServletRequest request,String pre){
        EntityWrapper<ShujixinxiEntity> ew = new EntityWrapper<ShujixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = shujixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujixinxi), params), params));
        return R.ok().put("data", page);
    }


}
