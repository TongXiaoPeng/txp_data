package com.data.web.service.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.data.web.dao.classes.ClassesDao;
import com.data.web.model.classes.ClassesModel;
import com.data.web.model.system.Page;
import com.data.web.service.classes.ClassesService;
import com.data.web.util.ResultUtil;


/**
 * 
 * @author txp
 * @date 2017-10-29 上午1:25:15
 */
@Service("classesService")
public class ClassesServiceImpl implements ClassesService {

    @Resource
    private ClassesDao classesDao;


    @Override
    public List<ClassesModel> listJson(Page<ClassesModel> page)throws Exception {
        return classesDao.listJson(page);
    }

    @Override
    public JSONObject updateClasses(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("classLevel") && postObj.has("className") && postObj.has("classId")){
    		String classId = postObj.getString("classId");
    		String className = postObj.getString("className");
    		Integer classLevel = postObj.getInt("classLevel");
    		ClassesModel classes = classesDao.findById(classId);
    		classes.setClassLevel(classLevel);
    		classes.setClassName(className);
    		classes.setModified(new Date());
    		classesDao.update(classes);
    		
    		result = ResultUtil.getErrorMsg(true, 11, "修改成功");
    		JSONObject data = new JSONObject();
    		data.put("classId", classes.getId());
        	data.put("className", classes.getClassName());
        	data.put("classLevel", classes.getClassLevel());
        	result.put("data", data);
        	
    	}else{
    		result = ResultUtil.getErrorMsg(false, 14, "参数有误");
    	}
    	
        return result;
    }

    @Override
    public Long getTotalClasses(Map<String, Object> map)throws Exception {
        return classesDao.getTotalClass(map);
    }

    @Override
    public JSONObject addClasses(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("classLevel") && postObj.has("className")){
    		String className = postObj.getString("className");
    		Integer classLevel = postObj.getInt("classLevel");
    		ClassesModel classes = new ClassesModel();
    		classes.setClassLevel(classLevel);
    		classes.setClassName(className);
        	classes.setCreated(new Date());
        	classes.setIsDelete(0);
        	classesDao.add(classes);
        	result = ResultUtil.getErrorMsg(true, 10, "新增成功");
        	JSONObject data = new JSONObject();
        	data.put("classId", classes.getId());
        	data.put("className", classes.getClassName());
        	data.put("classLevel", classes.getClassLevel());
        	result.put("data", data);
    	}else{
    		result = ResultUtil.getErrorMsg(false, 14, "参数有误");
    	}
		return result;
    }

    @Override
    public JSONObject delClasses(JSONObject postObj)throws Exception {
    	JSONObject result = new JSONObject();
    	if(postObj.has("classId")){
    		String classId = postObj.getString("classId");
    		classesDao.delete(classId);
    		result = ResultUtil.getErrorMsg(true, 12, "删除成功");
    	}else{
    		result = ResultUtil.getErrorMsg(false, 14, "参数有误");
    	}
    	return result;
    }

	@Override
	public JSONObject getClasessList() throws Exception {
		JSONObject result = new JSONObject();
		List<ClassesModel> dataList = classesDao.list();
		List<JSONObject> classList = new ArrayList<JSONObject>();
		if(dataList.size()>0){
			for(ClassesModel classes : dataList){
				JSONObject classData = new JSONObject();
				classData.put("classId", classes.getId());
				classData.put("className", classes.getClassName());
				classData.put("classLevel", classes.getClassLevel());
				classList.add(classData);
			}
		}
		result = ResultUtil.getErrorMsg(true, 10, "加载成功");
		JSONObject data = new JSONObject();
		data.put("classList", classList);
		result.put("data", data);
		return result;
	}



}