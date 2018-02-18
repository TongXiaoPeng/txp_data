package com.data.web.service.classes;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.data.web.model.classes.ClassesModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 下午1:23:07
 */
public interface ClassesService {


    /**
     * 查询班级
     *
     * @param map
     * @return
     */
    public List<ClassesModel> listJson(Page<ClassesModel> page)throws Exception;
    /**
     * 查询班级数量
     *
     * @param map
     * @return
     */
    public Long getTotalClasses(Map<String, Object> map)throws Exception;


    /**
     * 修改班级
     *
     * @param user
     * @return
     */
    public JSONObject updateClasses(JSONObject postJson)throws Exception;

    /**
     * 新增班级
     *
     * @return
     */
    public JSONObject addClasses(JSONObject postObj)throws Exception;

    /**
     * 删除班级
     *
     * @param id
     * @return
     */
    public JSONObject delClasses(JSONObject postObj)throws Exception;
    
	public JSONObject getClasessList()throws Exception;

}
