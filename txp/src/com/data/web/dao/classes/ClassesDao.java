package com.data.web.dao.classes;

import java.util.List;
import java.util.Map;

import com.data.web.model.classes.ClassesModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:28:24
 */
public interface ClassesDao {


    /**
     * ��ѯ
     *
     * @param map
     * @return
     */
    public List<ClassesModel> listJson(Page<ClassesModel> page);

    /**
     * @param map
     * @return
     */
    public Long getTotalClass(Map<String, Object> map);

    /**
     * ����
     *
     * @param classes
     * @return
     */
    public int update(ClassesModel classes);

    /**
     * ����
     *
     * @param classes
     * @return
     */
    public int add(ClassesModel classes);

    /**
     * ɾ��
     *
     * @param id
     * @return
     */
    public int delete(String id);

	public ClassesModel findById(String id);

	public List<ClassesModel> list();

}
