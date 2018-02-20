package com.data.web.service.study;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.data.web.dao.study.StudyLogsDao;
import com.data.web.model.study.StudyLogsModel;
import com.data.web.model.system.Page;
import com.data.web.util.ResultUtil;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:25:15
 */
@Service("studyLogsService")
public class StudyLogsServiceImpl implements StudyLogsService {

    @Resource
    private StudyLogsDao studyLogsDao;


//    @Override
//    public List<ClassesModel> listJson(Page<ClassesModel> page)throws Exception {
//        return classesDao.listJson(page);
//    }

    @Override
    public JSONObject updateStudyLogs(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("logId")){
    		String logId = postObj.getString("logId");
    		StudyLogsModel logs = studyLogsDao.findById(logId);
    		if(logs != null){
    			if(postObj.has("logTitle")){
    				logs.setLogTitle(postObj.getString("logTitle"));
    			}
    			if(postObj.has("logContent")){
    				logs.setLogContent(postObj.getString("logContent"));
    			}
        		logs.setModified(new Date());
        		studyLogsDao.update(logs);
        		
        		result = ResultUtil.getErrorMsg(true, 11, "修改成功");
        		JSONObject data = new JSONObject();
        		data.put("logId", logs.getId());
            	data.put("userId", logs.getUserId());
            	data.put("logTitle", logs.getLogTitle());
            	data.put("logContent", logs.getLogContent());
            	result.put("data", data);
    		}else{
    			result = ResultUtil.getErrorMsg(false, 14, "记录不存在");
    		}
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
    	
        return result;
    }

//    @Override
//    public Long getTotalStudyLogs(Map<String, Object> map)throws Exception {
//        return classesDao.getTotalClass(map);
//    }

    @Override
    public JSONObject addStudyLogs(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("logTitle") && postObj.has("logContent") && postObj.has("userId")){
    		String userId = postObj.getString("userId");
    		String logTitle = postObj.getString("logTitle");
    		String logContent = postObj.getString("logContent");
    		StudyLogsModel logs = new StudyLogsModel();
    		logs.setUserId(userId);
    		logs.setLogTitle(logContent);
    		logs.setLogContent(logContent);
    		logs.setCreated(new Date());
    		logs.setIsDelete(0);
    		studyLogsDao.add(logs);
        	result = ResultUtil.getErrorMsg(true, 10, "添加成功");
        	JSONObject data = new JSONObject();
        	data.put("logId", logs.getId());
        	data.put("userId", userId);
        	data.put("logTitle", logTitle);
        	data.put("logContent", logContent);
        	result.put("data", data);
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
		return result;
    }

    @Override
    public JSONObject delStudyLogs(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("logId")){
    		String logId = postObj.getString("logId");
    		studyLogsDao.delete(logId);
    		result = ResultUtil.getErrorMsg(true, 12, "删除成功");
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
    	return result;
    }

	@Override
	public JSONObject getStudyLogsList(JSONObject postJson) throws Exception {
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
		
		if(postJson.has("userId")){
			String userId = postJson.getString("userId");
			Page<StudyLogsModel> page = new Page<StudyLogsModel>();
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
			page.setPageStart(pageStart);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", userId);
			page.setParams(params);
			List<StudyLogsModel> logs = studyLogsDao.listJson(page);
			List<JSONObject> logList = new ArrayList<JSONObject>();
			if(logs.size()>0){
				for(StudyLogsModel log : logs){
					JSONObject logData = new JSONObject();
					logData.put("logId", log.getId());
					logData.put("userId", log.getUserId());
					logData.put("logTitle", log.getLogTitle());
					logData.put("logContent", log.getLogContent());
					logList.add(logData);
				}
			}
			result = ResultUtil.getErrorMsg(true, 10, "加载成功");
			JSONObject data = new JSONObject();
			data.put("logList", logList);
			result.put("data", data);
		}else{
			result = ResultUtil.getErrorMsg(false, 11, "参数有误");
		}
		return result;
	}



} 