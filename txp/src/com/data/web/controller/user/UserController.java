package com.data.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;
import com.data.web.service.user.UserService;
import com.data.web.util.MD5Util;
import com.data.web.util.ResponseUtil;
import com.data.web.util.StringUtil;

@Controller
@RequestMapping(value="user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="userManage")
	public ModelAndView userManage(){
		ModelAndView mView = new ModelAndView("user/userManage");
		return mView;
	}
	
	 /**
     * @param page
     * @param rows
     * @param s_user
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(
    		@RequestParam(value = "page",defaultValue="1")int pageNo,
    		@RequestParam(value = "rows",defaultValue="20")int pageSize,
    		UserModel user,
    		HttpServletResponse response) throws Exception {
        Page<UserModel> page = new Page<UserModel>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", StringUtil.formatLike(user.getUserName()));
        page.setParams(map);
        page.setList( userService.listJson(page));
        
        Map<String,Object> result = new HashMap<String,Object>();
//        result.put("pageNo", page.getPageNo());
        result.put("rows", page.getList());
        result.put("total", page.getTotalRecord());
//        JSONObject result = new JSONObject();
//        JSONArray jsonArray = JSONArray.fromObject(page.getList());
//        result.put("rows", jsonArray);
//        result.put("total", page.getTotalPage());
//        log.info("request: user/list , map: " + map.toString());
//        ResponseUtil.write(response, result);
        return result;
    }

    /**
     * 添加或修改管理员
     *
     * @param response
     * @return
     * @throws Exception
     */
//    @RequestMapping("/save")
//    public String save(UserModel user, HttpServletResponse response) throws Exception {
//        int resultTotal = 0;
//        String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
//        user.setPassword(MD5pwd);
//        if (user.getId() == null) {
//            resultTotal = userService.addUser(user);
//        } else {
//            resultTotal = userService.updateUser(user);
//        }
//        JSONObject result = new JSONObject();
//        if (resultTotal > 0) {
//            result.put("success", true);
//        } else {
//            result.put("success", false);
//        }
//        log.info("request: user/save , user: " + user.toString());
//        ResponseUtil.write(response, result);
//        return null;
//    }

    /**
     * 删除管理员
     *
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
//    @RequestMapping("/delete")
//    public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
//        JSONObject result = new JSONObject();
//        String[] idsStr = ids.split(",");
//        for (int i = 0; i < idsStr.length; i++) {
//            userService.deleteUser(Integer.parseInt(idsStr[i]));
//        }
//        result.put("success", true);
//        log.info("request: user/delete , ids: " + ids);
//        ResponseUtil.write(response, result);
//        return null;
//    }
}
