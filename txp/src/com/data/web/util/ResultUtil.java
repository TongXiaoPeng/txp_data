package com.data.web.util;

import net.sf.json.JSONObject;

public class ResultUtil {

	public static JSONObject getErrorMsg(boolean success, int code, String msg) {
		JSONObject result = new JSONObject();
		result.put("success", success);
		result.put("code", code);
		result.put("alertMsg", msg);
		JSONObject data = new JSONObject();
		result.put("data", data);
		return result;
	}

}
