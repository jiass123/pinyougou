package com.pinyougou.brand.service;

import com.pinyougou.brand.api.BrandService;
import com.pinyougou.brand.api.vo.BrandVO;
import com.pinyougou.brand.entity.Brand;
import com.pinyougou.brand.mapper.BrandMapper;
import com.pinyougou.common.entity.QueryQO;
import com.pinyougou.common.service.BaseServiceImpl;
import com.pinyougou.common.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("brandService")
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService , QueryService {

	@Autowired
	private BrandMapper brandMapper;

	@Override
	public List<BrandVO> queryList(QueryQO queryQO) {
		return brandMapper.selectByQO(queryQO);
	}

    @Override
    public Integer queryCount(QueryQO queryQO) {
        return brandMapper.selectCountByQO(queryQO);
    }
}
