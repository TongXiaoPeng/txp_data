package com.data.web.dao.classes;

import java.util.List;
import java.util.Map;

import com.data.web.model.classes.ClassesModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 上午1:28:24
 */
public interface ClassesDao {


    /**
     * 查询
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
     * 更新
     *
     * @param classes
     * @return
     */
    public int update(ClassesModel classes);

    /**
     * 新增
     *
     * @param classes
     * @return
     */
    public int add(ClassesModel classes);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delete(String id);

	public ClassesModel findById(String id);

	public List<ClassesModel> list();

}
