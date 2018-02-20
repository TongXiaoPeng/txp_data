package com.data.api.controller;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.web.service.study.StudyLogsService;
import com.data.web.util.ApiUtil;
import com.data.web.util.ResultUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/api/study")
public class StudyController {
    @Resource
    private StudyLogsService studyLogsService;

    /**
     * 加载学习记录
     * @return
     */
    @RequestMapping("/loadLogs")
    @ResponseBody
    public JSONObject loadLogs(HttpServletRequest request)  {
    	String postContent = ApiUtil.getRequestContent(request);
    	JSONObject postJson = JSONObject.fromObject(postContent);
    	JSONObject result = new JSONObject();
    	try {
    		result = studyLogsService.getStudyLogsList(postJson);
    	}catch(Exception e){
    		e.printStackTrace();
    		result = ResultUtil.getErrorMsg(false, 12, "加载失败");
    	}
        return result;
    }

    
    /**
     * 添加&修改&删除学习记录
     *
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/setLogs", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject setLogs(
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
	    			result = studyLogsService.addStudyLogs(postJson);
	    			break;
	    		case 1://修改
	    			result = studyLogsService.updateStudyLogs(postJson);
	    			break;
	    		case 2://删除
	    			result = studyLogsService.delStudyLogs(postJson);
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
}
