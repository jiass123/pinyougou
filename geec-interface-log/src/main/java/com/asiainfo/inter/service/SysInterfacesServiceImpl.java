package com.asiainfo.inter.service;

import com.asiainfo.inter.api.ISysInterfacesService;
import com.asiainfo.inter.mapper.SysInterfacesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysInterfacesService")
public class SysInterfacesServiceImpl implements ISysInterfacesService {

	@Autowired
	private SysInterfacesMapper sysInterfacesMapper;

	@Override
	public String queryInterfaceNoByUrl(String url) {
		return sysInterfacesMapper.selectInterfaceNoByUrl(url);
	}

    @Override
    public void createTable() {
		sysInterfacesMapper.createTable();
    }
}
