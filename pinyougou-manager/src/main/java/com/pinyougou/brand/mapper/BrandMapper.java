package com.pinyougou.brand.mapper;

import com.pinyougou.brand.api.vo.BrandVO;
import com.pinyougou.brand.entity.Brand;
import com.pinyougou.common.entity.QueryQO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-02-23 23:37:05
 */
public interface BrandMapper extends Mapper<Brand> {

    List<BrandVO> selectByQO(QueryQO queryQO);
}
