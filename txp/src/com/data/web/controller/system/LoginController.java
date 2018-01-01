package com.data.web.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.data.web.model.user.UserModel;
import com.data.web.service.user.UserService;
import com.data.web.util.MD5Util;
import com.data.web.util.ResponseUtil;

@Controller
@RequestMapping(value="system")
public class LoginController {
	
	@Resource
    private UserService userService;
	
//    private static final Logger log = Logger.getLogger(UserController.class);// 日志文件
    
	@RequestMapping(value="loginView")
	public ModelAndView loginView(){
		ModelAndView mView = new ModelAndView("login");
		return mView;
	}
	@RequestMapping(value="registerView")
	public ModelAndView registerView(){
		ModelAndView mView = new ModelAndView("register");
		return mView;
	}
//	
	/**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(UserModel user, HttpServletRequest request) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassWord(), "UTF-8");
//            System.out.println(MD5pwd);
            user.setPassWord(MD5pwd);
        	UserModel resultUser = userService.login(user);
        
//        log.info("request: user/login , user: " + user.toString());
	        if (resultUser == null) {
	            request.setAttribute("user", user);
	            request.setAttribute("errorMsg", "请认真核对账号、密码！");
	            return new ModelAndView("login");
	        } else {
	            HttpSession session = request.getSession();
	            session.setAttribute("currentUser", resultUser);
	//            MDC.put("userName", user.getUserName());
	            return new ModelAndView("main");
	        }
        } catch (Exception e) {
        	e.printStackTrace();
        	request.setAttribute("user", user);
            request.setAttribute("errorMsg", "网络出错！");
            return new ModelAndView("login");
        }
    }
    
    /**
     * 注册
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register(UserModel user, HttpServletRequest request) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassWord(), "UTF-8");
//            System.out.println(MD5pwd);
            user.setPassWord(MD5pwd);
            UserModel hasUser = userService.findByUserName(user);
        	
        
//        log.info("request: user/login , user: " + user.toString());
	        if (hasUser != null) {
	            request.setAttribute("errorMsg", "该用户名已存在");
	            return new ModelAndView("login");
	        } else {
	        	UserModel resultUser = userService.register(user);
	            HttpSession session = request.getSession();
	            session.setAttribute("currentUser", resultUser);
	//            MDC.put("userName", user.getUserName());
	            return new ModelAndView("main");
	        }
        } catch (Exception e) {
        	e.printStackTrace();
        	request.setAttribute("user", user);
            request.setAttribute("errorMsg", "网络出错！");
            return new ModelAndView("login");
        }
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
    public String modifyPassword(UserModel user, HttpServletResponse response) throws Exception {
        String MD5pwd = MD5Util.MD5Encode(user.getPassWord(), "UTF-8");
        user.setPassWord(MD5pwd);
        int resultTotal = userService.updateUser(user);
        JSONObject result = new JSONObject();
        if (resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
//        log.info("request: user/modifyPassword , user: " + user.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 退出系统
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) throws Exception {
        session.invalidate();
//        log.info("request: user/logout");
        ModelAndView mView = new ModelAndView("login");
		return mView;
    }

   
}
