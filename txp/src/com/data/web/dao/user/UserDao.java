package com.data.web.dao.user;


import java.util.List;

import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:28:24
 */
public interface UserDao {


    /**
     * ����
     *
     * @param user
     * @return
     */
    public int update(UserModel user);

    /**
     * ����
     *
     * @param user
     * @return
     */
    public int add(UserModel user);

	public UserModel findByUserName(String userName);

	public UserModel findById(String userId);

	/**
	 * 分页加载教师列表
	 * @param page
	 * @return
	 */
	public List<UserModel> getTeacherList(Page<UserModel> page);
}
