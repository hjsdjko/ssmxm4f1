package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShujixinxiDao;
import com.entity.ShujixinxiEntity;
import com.service.ShujixinxiService;
import com.entity.vo.ShujixinxiVO;
import com.entity.view.ShujixinxiView;

@Service("shujixinxiService")
public class ShujixinxiServiceImpl extends ServiceImpl<ShujixinxiDao, ShujixinxiEntity> implements ShujixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShujixinxiEntity> page = this.selectPage(
                new Query<ShujixinxiEntity>(params).getPage(),
                new EntityWrapper<ShujixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShujixinxiEntity> wrapper) {
		  Page<ShujixinxiView> page =new Query<ShujixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShujixinxiVO> selectListVO(Wrapper<ShujixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShujixinxiVO selectVO(Wrapper<ShujixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShujixinxiView> selectListView(Wrapper<ShujixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShujixinxiView selectView(Wrapper<ShujixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
