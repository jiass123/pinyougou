package com.asiainfo.sys.service;

import com.asiainfo.common.service.BaseServiceImpl;
import com.asiainfo.sys.api.UserService;
import com.asiainfo.sys.entity.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

}
