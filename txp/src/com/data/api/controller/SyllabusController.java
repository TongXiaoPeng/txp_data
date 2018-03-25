package com.data.api.controller;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.web.service.syllabus.SyllabusService;
import com.data.web.util.ApiUtil;
import com.data.web.util.ResultUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/api/syllabus")
public class SyllabusController {
    @Resource
    private SyllabusService syllabusService;

    /**
     * 加载课程表列表
     * @return
     */
    @RequestMapping("/loadSyllabus")
    @ResponseBody
    public JSONObject loadSyllabus(HttpServletRequest request)  {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
    	try {
    		result = syllabusService.getSyllabusList(postJson);
    	}catch(Exception e){
    		e.printStackTrace();
    		result = ResultUtil.getErrorMsg(false, 11, "加载失败");
    	}
        return result;
    }

    
    /**
     * 添加&修改&删除课程表
     *
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/setSyllabus", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject setSyllabus(
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
    	if(postJson.has("operationType") ){
    		Integer operationType = postJson.getInt("operationType");
    		try {
	    		switch (operationType){
	    		case 0://添加
	    			result = syllabusService.addSyllabus(postJson);
	    			break;
	    		case 1://修改
	    			result = syllabusService.updateSyllabus(postJson);
	    			break;
	    		case 2://删除
	    			result = syllabusService.delSyllabus(postJson);
	    			break;
	    		}
    		} catch (Exception e) {
				e.printStackTrace();
				result = ResultUtil.getErrorMsg(false, 13, "操作失败");
			}
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
        return result;
    }
    
    /**
     * 添加&修改&删除课程表明细
     *
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/setSyllabusDetail", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject setSyllabusDetail(
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
    	if(postJson.has("operationType") ){
    		Integer operationType = postJson.getInt("operationType");
    		try {
	    		switch (operationType){
	    		case 0://添加
	    			result = syllabusService.addSyllabusDetail(postJson);
	    			break;
	    		case 1://修改
	    			result = syllabusService.updateSyllabusDetail(postJson);
	    			break;
	    		case 2://删除
	    			result = syllabusService.delSyllabusDetail(postJson);
	    			break;
	    		}
    		} catch (Exception e) {
				e.printStackTrace();
				result = ResultUtil.getErrorMsg(false, 13, "操作失败");
			}
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
        return result;
    }
    
    /**
     * 加载课程表明细
     * @return
     */
    @RequestMapping("/loadSyllabusDetail")
    @ResponseBody
    public JSONObject loadSyllabusDetail(HttpServletRequest request)  {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
    	try {
    		result = syllabusService.getSyllabusDetailList(postJson);
    	}catch(Exception e){
    		e.printStackTrace();
    		result = ResultUtil.getErrorMsg(false, 11, "加载失败");
    	}
        return result;
    }
}
