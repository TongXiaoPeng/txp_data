package com.data.web.service.user;

import java.util.List;
import java.util.Map;

import com.data.web.model.system.Page;
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
     * @param user
     * @return
     */
    public UserModel login(UserModel user)throws Exception;

    /**
     * 查询用户
     *
     * @param map
     * @return
     */
    public List<UserModel> listJson(Page<UserModel> page)throws Exception;

    /**
     * 获取用户数量
     *
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map)throws Exception;

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    public int updateUser(UserModel user)throws Exception;

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    public UserModel addUser(UserModel user)throws Exception;

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteUser(String id)throws Exception;

	public UserModel findByUserName(UserModel user);

	public UserModel register(UserModel user);
}
