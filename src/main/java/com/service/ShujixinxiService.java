package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShujixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShujixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujixinxiView;


/**
 * 书籍信息
 *
 * @author 
 * @email 
 * @date 2021-04-27 10:50:35
 */
public interface ShujixinxiService extends IService<ShujixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShujixinxiVO> selectListVO(Wrapper<ShujixinxiEntity> wrapper);
   	
   	ShujixinxiVO selectVO(@Param("ew") Wrapper<ShujixinxiEntity> wrapper);
   	
   	List<ShujixinxiView> selectListView(Wrapper<ShujixinxiEntity> wrapper);
   	
   	ShujixinxiView selectView(@Param("ew") Wrapper<ShujixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShujixinxiEntity> wrapper);
   	
}

