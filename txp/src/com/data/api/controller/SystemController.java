package com.data.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.web.service.user.UserService;
import com.data.web.util.ApiUtil;
import com.data.web.util.ResultUtil;

@Controller
@RequestMapping(value="/api/system")
public class SystemController {
	
	@Resource
    private UserService userService;
	
	/**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(HttpServletRequest request) {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
        try {
        	result = userService.login(postJson);
        } catch (Exception e) {
        	e.printStackTrace();
        	result = ResultUtil.getErrorMsg(false, 14, "登录失败");
        }
        return result;
    }
    
   /**
     * 注册
     * @return
     */
    @RequestMapping("/signup")
    @ResponseBody
    public JSONObject signup(HttpServletRequest request) {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
        try {
        	result = userService.signup(postJson);
        } catch (Exception e) {
        	e.printStackTrace();
        	result = ResultUtil.getErrorMsg(false, 14, "注册失败");
        }
        return result;
    }
    
    /**
     * 修改密码
     *
     * @param user
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/modifyPassword")
    @ResponseBody
    public JSONObject modifyPassword(HttpServletRequest request) throws Exception {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
        try {
        	result = userService.modifyPassword(postJson);
        } catch (Exception e) {
        	e.printStackTrace();
        	result = ResultUtil.getErrorMsg(false, 12, "修改失败");
        }
        return result;
    }

    /**
     * 加载教师列表
     *
     * @param user
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/loadTeachers")
    @ResponseBody
    public JSONObject loadTeachers(HttpServletRequest request) throws Exception {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
        try {
        	result = userService.getTeacherList(postJson);
        } catch (Exception e) {
        	e.printStackTrace();
        	result = ResultUtil.getErrorMsg(false, 11, "加载失败");
        }
        return result;
    }

   
}
