package com.data.api.controller;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.data.web.model.classes.ClassesModel;
import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;
import com.data.web.service.classes.ClassesService;
import com.data.web.util.ApiUtil;
import com.data.web.util.ResponseUtil;
import com.data.web.util.ResultUtil;
import com.data.web.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/class")
public class ClassesController {
    @Resource
    private ClassesService classesService;

    
    @RequestMapping("/loadClasses")
    @ResponseBody
    public JSONObject listAll()  {
    	JSONObject result = new JSONObject();
    	try {
    		result = classesService.getClasessList();
    	}catch(Exception e){
    		e.printStackTrace();
    		result = ResultUtil.getErrorMsg(false, 11, "加载失败");
    	}
        return result;
    }

    
    /**
     * 删除书籍
     *
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/setClass", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject setClass(
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
    	if(postJson.has("operationType") ){
    		Integer operationType = postJson.getInt("operationType");
    		try {
	    		switch (operationType){
	    		case 0://新增
	    			result = classesService.addClasses(postJson);
	    			break;
	    		case 1://修改
	    			result = classesService.updateClasses(postJson);
	    			break;
	    		case 2://删除
	    			result = classesService.delClasses(postJson);
	    			break;
	    		}
    		} catch (Exception e) {
				e.printStackTrace();
				result = ResultUtil.getErrorMsg(false, 13, "操作失败");
			}
    	}else{
    		result = ResultUtil.getErrorMsg(false, 14, "参数有误");
    	}
        return result;
    }
}
