package com.data.web.dao.user;


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
}
