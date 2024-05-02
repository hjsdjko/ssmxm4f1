package com.entity.view;

import com.entity.ShujixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 书籍信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-27 10:50:35
 */
@TableName("shujixinxi")
public class ShujixinxiView  extends ShujixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShujixinxiView(){
	}
 
 	public ShujixinxiView(ShujixinxiEntity shujixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, shujixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
