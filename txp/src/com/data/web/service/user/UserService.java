package com.data.web.service.user;


import net.sf.json.JSONObject;

import com.data.web.model.user.UserModel;


/**
 * 
 * @author txp
 * @date 2017-10-29 上午1:23:07
 */
public interface UserService {

    /**
     * 登录
     *
     * @param postJson
     * @return
     */
    public JSONObject login(JSONObject postJson)throws Exception;


    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    public int updateUser(UserModel user)throws Exception;


	public JSONObject signup(JSONObject postJson);


	public JSONObject modifyPassword(JSONObject postJson);

	/**
	 * 加载教师列表
	 * @param postJson
	 * @return
	 */
	public JSONObject getTeacherList(JSONObject postJson);
}
