package com.data.web.dao.user;

import java.util.List;
import java.util.Map;

import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;


/**
 * 
 * @author txp
 * @date 2017-10-29 上午1:28:24
 */
public interface UserDao {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public UserModel login(UserModel user);

    /**
     * 查询
     *
     * @param map
     * @return
     */
    public List<UserModel> listJson(Page<UserModel> page);

    /**
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map);

    /**
     * 更新
     *
     * @param user
     * @return
     */
    public int update(UserModel user);

    /**
     * 新增
     *
     * @param user
     * @return
     */
    public int add(UserModel user);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delete(String id);
}
