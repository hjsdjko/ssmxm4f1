package com.entity.vo;

import com.entity.ShujixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 书籍信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-04-27 10:50:35
 */
public class ShujixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 书籍分类
	 */
	
	private String shujifenlei;
		
	/**
	 * 作者
	 */
	
	private String zuozhe;
		
	/**
	 * 出版社
	 */
	
	private String chubanshe;
		
	/**
	 * 书籍详情
	 */
	
	private String shujixiangqing;
		
	/**
	 * 卖家账号
	 */
	
	private String maijiazhanghao;
		
	/**
	 * 卖家姓名
	 */
	
	private String maijiaxingming;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 价格
	 */
	
	private Float price;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：书籍分类
	 */
	 
	public void setShujifenlei(String shujifenlei) {
		this.shujifenlei = shujifenlei;
	}
	
	/**
	 * 获取：书籍分类
	 */
	public String getShujifenlei() {
		return shujifenlei;
	}
				
	
	/**
	 * 设置：作者
	 */
	 
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	
	/**
	 * 获取：作者
	 */
	public String getZuozhe() {
		return zuozhe;
	}
				
	
	/**
	 * 设置：出版社
	 */
	 
	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}
	
	/**
	 * 获取：出版社
	 */
	public String getChubanshe() {
		return chubanshe;
	}
				
	
	/**
	 * 设置：书籍详情
	 */
	 
	public void setShujixiangqing(String shujixiangqing) {
		this.shujixiangqing = shujixiangqing;
	}
	
	/**
	 * 获取：书籍详情
	 */
	public String getShujixiangqing() {
		return shujixiangqing;
	}
				
	
	/**
	 * 设置：卖家账号
	 */
	 
	public void setMaijiazhanghao(String maijiazhanghao) {
		this.maijiazhanghao = maijiazhanghao;
	}
	
	/**
	 * 获取：卖家账号
	 */
	public String getMaijiazhanghao() {
		return maijiazhanghao;
	}
				
	
	/**
	 * 设置：卖家姓名
	 */
	 
	public void setMaijiaxingming(String maijiaxingming) {
		this.maijiaxingming = maijiaxingming;
	}
	
	/**
	 * 获取：卖家姓名
	 */
	public String getMaijiaxingming() {
		return maijiaxingming;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
	}
			
}
