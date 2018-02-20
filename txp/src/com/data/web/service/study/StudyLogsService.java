package com.data.web.service.study;


import net.sf.json.JSONObject;



/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:23:07
 */
public interface StudyLogsService {

	public JSONObject getStudyLogsList(JSONObject postJson) throws Exception;

	public JSONObject addStudyLogs(JSONObject postJson) throws Exception;

	public JSONObject updateStudyLogs(JSONObject postJson) throws Exception;

	public JSONObject delStudyLogs(JSONObject postJson) throws Exception;

}
