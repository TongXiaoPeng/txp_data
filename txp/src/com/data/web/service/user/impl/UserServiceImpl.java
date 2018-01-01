package com.data.web.service.user.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.data.web.dao.user.UserDao;
import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;
import com.data.web.service.user.UserService;


/**
 * 
 * @author txp
 * @date 2017-10-29 ÉÏÎç1:25:15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserModel login(UserModel user)throws Exception {
        return userDao.login(user);
    }

    @Override
    public List<UserModel> listJson(Page<UserModel> page)throws Exception {
        return userDao.listJson(page);
    }

    @Override
    public int updateUser(UserModel user)throws Exception {
        return userDao.update(user);
    }

    @Override
    public Long getTotalUser(Map<String, Object> map)throws Exception {
        return userDao.getTotalUser(map);
    }

    @Override
    public UserModel addUser(UserModel user)throws Exception {
    	userDao.add(user);
		return user;
    }

    @Override
    public int deleteUser(String id)throws Exception {
        return userDao.delete(id);
    }

	@Override
	public UserModel findByUserName(UserModel user) {
		return userDao.findByUserName(user);
	}

	@Override
	public UserModel register(UserModel user) {
		userDao.add(user);
		return user;
	}

}
