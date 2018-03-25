package com.data.web.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.data.web.dao.classes.ClassesDao;
import com.data.web.dao.user.UserDao;
import com.data.web.model.classes.ClassesModel;
import com.data.web.model.study.StudyLogsModel;
import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;
import com.data.web.service.user.UserService;
import com.data.web.util.MD5Util;
import com.data.web.util.ResultUtil;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:25:15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private ClassesDao classesDao;
    
    @Override
    public JSONObject login(JSONObject postJson)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postJson.has("userName") && postJson.has("passWord") ){
    		String userName = postJson.getString("userName");
    		String passWord = postJson.getString("passWord");
    		passWord = MD5Util.MD5Encode(passWord, "UTF-8");
    		UserModel user = userDao.findByUserName(userName);
    		if(user!=null){
	    		if(passWord.equals(user.getPassWord())){
	    			result = ResultUtil.getErrorMsg(true, 10, "登录成功");
	    			JSONObject data = new JSONObject();
					data.put("userId", user.getId());
					data.put("userName", user.getUserName());
					data.put("roleType", user.getRoleType());
					String classId = "";
					if(user.getClassId() != null){
						classId = user.getClassId();
					}
					data.put("classId", classId);
					result.put("data", data);
	    		}else{
	    			result = ResultUtil.getErrorMsg(false, 11, "用户名或密码错误");
	    		}
    		}else{
    			result = ResultUtil.getErrorMsg(false, 12, "用户不存在");
    		}
    	}else{
    		result = ResultUtil.getErrorMsg(false, 13, "用户名或密码不能为空");
    	}
        return result;
    }


    @Override
    public int updateUser(UserModel user)throws Exception {
        return userDao.update(user);
    }

	@Override
	public JSONObject signup(JSONObject postJson) {
		JSONObject result = new JSONObject();
		if(postJson.has("userName") && postJson.has("passWord") && postJson.has("roleType")){
			String userName = postJson.getString("userName");
			String passWord = postJson.getString("passWord");
			passWord = MD5Util.MD5Encode(passWord, "UTF-8");
			Integer roleType = postJson.getInt("roleType");
			UserModel user = userDao.findByUserName(userName);
			if(user == null){
				user = new UserModel();
				user.setUserName(userName);
				user.setPassWord(passWord);
				user.setCreated(new Date());
				user.setIsDelete(0);
				user.setRoleType(roleType);
				
				switch (roleType){
				case 0:
					if(postJson.has("classId")){
						String classId = postJson.getString("classId");
						ClassesModel classes = classesDao.findById(classId);
						if(classes != null){
							user.setClassId(classId);
							userDao.add(user);
							result = ResultUtil.getErrorMsg(true, 10, "注册成功");
							JSONObject data = new JSONObject();
							data.put("userId", user.getId());
							data.put("userName", userName);
							data.put("roleType", roleType);
							data.put("classId", classId);
							result.put("data", data);
						}else{
							result = ResultUtil.getErrorMsg(false, 12, "班级不存在");
						}
					}else{
						result = ResultUtil.getErrorMsg(false, 13, "参数有误");
					}
					break;
				case 1:
					userDao.add(user);
					result = ResultUtil.getErrorMsg(true, 10, "注册成功");
					JSONObject data = new JSONObject();
					data.put("userId", user.getId());
					data.put("userName", userName);
					data.put("roleType", roleType);
					data.put("classId", "");
					result.put("data", data);
					break;
				}
			}else{
				result = ResultUtil.getErrorMsg(false, 11, "用户名已存在");
			}
		}else{
			result = ResultUtil.getErrorMsg(false, 13, "参数有误");
		}
		return result;
	}


	@Override
	public JSONObject modifyPassword(JSONObject postJson) {
		JSONObject result = new JSONObject();
    	if(postJson.has("userName") && postJson.has("oldPwd") && postJson.has("newPwd")){
    		String userName = postJson.getString("userName");
    		String oldPwd = postJson.getString("oldPwd");
    		oldPwd = MD5Util.MD5Encode(oldPwd, "UTF-8");
    		
    		UserModel user = userDao.findByUserName(userName);
    		if(user!=null){
	    		if(oldPwd.equals(user.getPassWord())){
	    			String newPwd = postJson.getString("newPwd");
	        		newPwd = MD5Util.MD5Encode(newPwd, "UTF-8");
	        		user.setPassWord(newPwd);
	        		user.setModified(new Date());
	        		userDao.update(user);
	        		
	    			result = ResultUtil.getErrorMsg(true, 10, "修改成功");
	    		}else{
	    			result = ResultUtil.getErrorMsg(false, 11, "用户名或密码错误");
	    		}
    		}else{
    			result = ResultUtil.getErrorMsg(false, 14, "用户不存在");
    		}
    	}else{
    		result = ResultUtil.getErrorMsg(false, 13, "参数有误");
    	}
        return result;
	}


	@Override
	public JSONObject getTeacherList(JSONObject postJson) {
		JSONObject result = new JSONObject();
		int pageNo = 1;
		int pageStart = 0;
		int pageSize = 10;
		if(postJson.has("pageNo")){
			pageNo = postJson.getInt("pageNo");
			
		}
		if(postJson.has("pageSize")){
			pageSize = postJson.getInt("pageSize");
		}
		pageStart = (pageNo-1)*pageSize;
		
		Page<UserModel> page = new Page<UserModel>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setPageStart(pageStart);
		Map<String, Object> params = new HashMap<String, Object>();
		if(postJson.has("teacherName")){
			String teacherName = postJson.getString("teacherName");
			params.put("teacherName", teacherName);
		}
		page.setParams(params);
		List<UserModel> dataList = userDao.getTeacherList(page);
		
		List<JSONObject> userList = new ArrayList<JSONObject>();
		if(dataList.size()>0){
			for(UserModel user : dataList){
				JSONObject userData = new JSONObject();
				userData.put("teacherId", user.getId());
				userData.put("teacherName", user.getUserName());
				userList.add(userData);
			}
		}
		result = ResultUtil.getErrorMsg(true, 10, "加载成功");
		JSONObject data = new JSONObject();
		data.put("teacherList", userList);
		result.put("data", data);
		return result;
	}

}
