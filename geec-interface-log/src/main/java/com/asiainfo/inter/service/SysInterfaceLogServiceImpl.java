package com.asiainfo.service;

import com.asiainfo.api.ISysInterfaceLogService;
import com.asiainfo.entity.SysInterfaceLog;
import com.asiainfo.mapper.SysInterfaceLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("sysInterfaceLogService")
public class SysInterfaceLogServiceImpl implements ISysInterfaceLogService {

	@Autowired
	private SysInterfaceLogMapper sysInterfaceLogMapper;

    @Override
    public Integer saveReqLog(SysInterfaceLog sysInterfaceLog) {
        return sysInterfaceLogMapper.insertLog(sysInterfaceLog);
    }

    @Override
    public SysInterfaceLog queryByPrimaryKey(Integer key) {
        return sysInterfaceLogMapper.selectByPrimaryKey(key);
    }

    @Override
    public void updateByPrimaryKey(SysInterfaceLog sysInterfaceLog) {
        sysInterfaceLogMapper.updateLog(sysInterfaceLog);
    }
}
