package com.data.web.dao.user;

import java.util.List;
import java.util.Map;

import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:28:24
 */
public interface UserDao {

    /**
     * ��¼
     *
     * @param user
     * @return
     */
    public UserModel login(UserModel user);

    /**
     * ��ѯ
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

    /**
     * ɾ��
     *
     * @param id
     * @return
     */
    public int delete(String id);
}
