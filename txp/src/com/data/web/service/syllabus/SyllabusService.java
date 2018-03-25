package com.data.web.service.syllabus;


import net.sf.json.JSONObject;



/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:23:07
 */
public interface SyllabusService {

	public JSONObject getSyllabusList(JSONObject postJson) throws Exception;

	public JSONObject addSyllabus(JSONObject postJson) throws Exception;

	public JSONObject updateSyllabus(JSONObject postJson) throws Exception;

	public JSONObject delSyllabus(JSONObject postJson) throws Exception;

	public JSONObject getSyllabusDetailList(JSONObject postJson) throws Exception;

	public JSONObject addSyllabusDetail(JSONObject postJson) throws Exception;

	public JSONObject updateSyllabusDetail(JSONObject postJson) throws Exception;

	public JSONObject delSyllabusDetail(JSONObject postJson) throws Exception;
}
