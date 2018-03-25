package com.data.web.service.syllabus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.data.web.dao.classes.ClassesDao;
import com.data.web.dao.syllabus.SyllabusDao;
import com.data.web.dao.syllabus.SyllabusDetailDao;
import com.data.web.dao.user.UserDao;
import com.data.web.model.classes.ClassesModel;
import com.data.web.model.syllabus.SyllabusDetailModel;
import com.data.web.model.syllabus.SyllabusModel;
import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;
import com.data.web.util.ResultUtil;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:25:15
 */
@Service("syllabusService")
public class SyllabusServiceImpl implements SyllabusService {

    @Resource
    private SyllabusDao syllabusDao;

    @Resource
    private SyllabusDetailDao syllabusDetailDao;
    
    @Resource
    private ClassesDao classesDao;
    
    @Resource
    private UserDao userDao;

    @Override
    public JSONObject updateSyllabus(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("syllabusId")){
    		String logId = postObj.getString("syllabusId");
    		SyllabusModel syllabus = syllabusDao.findById(logId);
    		if(syllabus != null){
    			if(postObj.has("syllabusName")){
    				syllabus.setSyllabusName(postObj.getString("syllabusName"));
    			}
    			syllabus.setModified(new Date());
    			syllabusDao.update(syllabus);
        		
        		result = ResultUtil.getErrorMsg(true, 11, "修改成功");
        		JSONObject data = new JSONObject();
        		data.put("syllabusId", syllabus.getId());
            	data.put("userId", syllabus.getUserId());
            	data.put("syllabusName", syllabus.getSyllabusName());
            	result.put("data", data);
    		}else{
    			result = ResultUtil.getErrorMsg(false, 14, "记录不存在");
    		}
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
    	
        return result;
    }


    @Override
    public JSONObject addSyllabus(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("syllabusName") && postObj.has("userId")){
    		String userId = postObj.getString("userId");
    		String syllabusName = postObj.getString("syllabusName");
    		SyllabusModel syllabus = new SyllabusModel();
    		syllabus.setUserId(userId);
    		syllabus.setSyllabusName(syllabusName);
    		syllabus.setCreated(new Date());
    		syllabus.setIsDelete(0);
    		syllabusDao.add(syllabus);
        	result = ResultUtil.getErrorMsg(true, 10, "添加成功");
        	JSONObject data = new JSONObject();
    		data.put("syllabusId", syllabus.getId());
        	data.put("userId", syllabus.getUserId());
        	data.put("syllabusName", syllabus.getSyllabusName());
        	result.put("data", data);
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
		return result;
    }

    @Override
    public JSONObject delSyllabus(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("syllabusId")){
    		String syllabusId = postObj.getString("syllabusId");
    		syllabusDao.delete(syllabusId);
    		result = ResultUtil.getErrorMsg(true, 12, "删除成功");
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
    	return result;
    }

	@Override
	public JSONObject getSyllabusList(JSONObject postJson) throws Exception {
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
			Page<SyllabusModel> page = new Page<SyllabusModel>();
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
			page.setPageStart(pageStart);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", userId);
			page.setParams(params);
			List<SyllabusModel> syllabuses = syllabusDao.listJson(page);
			List<JSONObject> syllabusList = new ArrayList<JSONObject>();
			if(syllabuses.size()>0){
				for(SyllabusModel syllabus : syllabuses){
					JSONObject syllabusData = new JSONObject();
					syllabusData.put("syllabusId", syllabus.getId());
					syllabusData.put("userId", syllabus.getUserId());
					syllabusData.put("syllabusName", syllabus.getSyllabusName());
					syllabusList.add(syllabusData);
				}
			}
			result = ResultUtil.getErrorMsg(true, 10, "加载成功");
			JSONObject data = new JSONObject();
			data.put("syllabusList", syllabusList);
			result.put("data", data);
		}else{
			result = ResultUtil.getErrorMsg(false, 12, "参数有误");
		}
		return result;
	}


	@Override
    public JSONObject updateSyllabusDetail(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("detailId")){
    		String detailId = postObj.getString("detailId");
    		SyllabusDetailModel syllabusDetail = syllabusDetailDao.findById(detailId);
    		if(syllabusDetail != null){
    			if(postObj.has("sourceName")){
    				syllabusDetail.setSourceName(postObj.getString("sourceName"));
    			}
    			if(postObj.has("weekType")){
    				syllabusDetail.setWeekType(postObj.getInt("weekType"));
    			}
    			if(postObj.has("serial")){
    				syllabusDetail.setSerial(postObj.getInt("serial"));
    			}
    			if(postObj.has("isSingle")){
    				syllabusDetail.setIsSingle(postObj.getInt("isSingle"));
    			}
    			if(postObj.has("teacherId")){
    				syllabusDetail.setTeacherId(postObj.getString("teacherId"));
    			}
    			if(postObj.has("classId")){
    				syllabusDetail.setClassId(postObj.getString("classId"));
    			}
    			syllabusDetail.setModified(new Date());
    			syllabusDetailDao.update(syllabusDetail);
        		
        		result = ResultUtil.getErrorMsg(true, 11, "修改成功");
        		JSONObject data = new JSONObject();
        		data.put("detailId", syllabusDetail.getId());
        		data.put("syllabusId", syllabusDetail.getSyllabusId());
        		data.put("sourceName", syllabusDetail.getSourceName());
            	data.put("weekType", syllabusDetail.getWeekType());
            	data.put("serial", syllabusDetail.getSerial());
            	data.put("isSingle", syllabusDetail.getIsSingle());
            	data.put("teacherId", syllabusDetail.getTeacherId());
            	UserModel user = userDao.findById(syllabusDetail.getTeacherId());
            	data.put("teacherName", user.getUserName());
            	data.put("classId", syllabusDetail.getClassId());
            	ClassesModel classes = classesDao.findById(syllabusDetail.getClassId());
            	data.put("className", classes.getClassName());
            	result.put("data", data);
    		}else{
    			result = ResultUtil.getErrorMsg(false, 14, "记录不存在");
    		}
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
    	
        return result;
    }


    @Override
    public JSONObject addSyllabusDetail(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("syllabusId") && postObj.has("sourceName") && postObj.has("weekType") && postObj.has("serial")){
    		String syllabusId = postObj.getString("syllabusId");
    		String sourceName = postObj.getString("sourceName");
    		Integer weekType = postObj.getInt("weekType");
    		Integer serial = postObj.getInt("serial");
    		SyllabusDetailModel detail = new SyllabusDetailModel();
    		detail.setSyllabusId(syllabusId);
    		detail.setSourceName(sourceName);
    		detail.setWeekType(weekType);
    		detail.setSerial(serial);
    		if(postObj.has("teacherId")){
    			detail.setTeacherId(postObj.getString("teacherId"));
    		}
    		if(postObj.has("classId")){
    			detail.setClassId(postObj.getString("classId"));
    		}
    		if(postObj.has("isSingle")){
    			detail.setIsSingle(postObj.getInt("isSingle"));
    		}
    		detail.setCreated(new Date());
    		detail.setIsDelete(0);
    		syllabusDetailDao.add(detail);
        	result = ResultUtil.getErrorMsg(true, 10, "添加成功");
        	JSONObject data = new JSONObject();
        	data.put("detailId", detail.getId());
    		data.put("syllabusId", detail.getSyllabusId());
    		data.put("sourceName", detail.getSourceName());
        	data.put("weekType", detail.getWeekType());
        	data.put("serial", detail.getSerial());
        	data.put("isSingle", detail.getIsSingle());
        	data.put("teacherId", detail.getTeacherId());
        	UserModel user = userDao.findById(detail.getTeacherId());
        	data.put("teacherName", user.getUserName());
        	data.put("classId", detail.getClassId());
        	ClassesModel classes = classesDao.findById(detail.getClassId());
        	data.put("className", classes.getClassName());
        	result.put("data", data);
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
		return result;
    }

    @Override
    public JSONObject delSyllabusDetail(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("detailId")){
    		String detailId = postObj.getString("detailId");
    		syllabusDetailDao.delete(detailId);
    		result = ResultUtil.getErrorMsg(true, 12, "删除成功");
    	}else{
    		result = ResultUtil.getErrorMsg(false, 15, "参数有误");
    	}
    	return result;
    }

	@Override
	public JSONObject getSyllabusDetailList(JSONObject postJson) throws Exception {
		JSONObject result = new JSONObject();
		
		if(postJson.has("syllabusId")){
			String syllabusId = postJson.getString("syllabusId");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("syllabusId", syllabusId);
			List<SyllabusDetailModel> detailList = syllabusDetailDao.getList(params);
			result = ResultUtil.getErrorMsg(true, 10, "加载成功");
			JSONObject data = new JSONObject();
			data.put("detailList", detailList);
			result.put("data", data);
		}else{
			result = ResultUtil.getErrorMsg(false, 12, "参数有误");
		}
		return result;
	}

} 