package com.asiainfo.api;


import com.asiainfo.entity.SysInterfaceLog;

/**
 * 接口日志表
 * 
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-04-30 16:06:15
 */
public interface ISysInterfaceLogService {

    /**
     * 保存请求日志
     * @param sysInterfaceLog
     */
    Integer saveReqLog(SysInterfaceLog sysInterfaceLog);

    /**
     * 根据主键查询
     * @param key
     * @return
     */
    SysInterfaceLog  queryByPrimaryKey(Integer key);

    /**
     * 根据主键更新
     * @param sysInterfaceLog
     */
    void updateByPrimaryKey(SysInterfaceLog sysInterfaceLog);
}
