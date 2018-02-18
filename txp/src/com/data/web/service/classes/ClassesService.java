package com.data.web.service.classes;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.data.web.model.classes.ClassesModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:23:07
 */
public interface ClassesService {


    /**
     * ��ѯ�༶
     *
     * @param map
     * @return
     */
    public List<ClassesModel> listJson(Page<ClassesModel> page)throws Exception;
    /**
     * ��ѯ�༶����
     *
     * @param map
     * @return
     */
    public Long getTotalClasses(Map<String, Object> map)throws Exception;


    /**
     * �޸İ༶
     *
     * @param user
     * @return
     */
    public JSONObject updateClasses(JSONObject postJson)throws Exception;

    /**
     * �����༶
     *
     * @return
     */
    public JSONObject addClasses(JSONObject postObj)throws Exception;

    /**
     * ɾ���༶
     *
     * @param id
     * @return
     */
    public JSONObject delClasses(JSONObject postObj)throws Exception;
    
	public JSONObject getClasessList()throws Exception;

}
