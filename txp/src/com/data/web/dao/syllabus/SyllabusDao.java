package com.data.web.dao.syllabus;

import java.util.List;
import java.util.Map;

import com.data.web.model.syllabus.SyllabusModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:28:24
 */
public interface SyllabusDao {


    /**
     * 分页列表
     *
     * @param map
     * @return
     */
    public List<SyllabusModel> listJson(Page<SyllabusModel> page);

    /**
     * 总记录数
     * @param map
     * @return
     */
    public Long getTotalClass(Map<String, Object> map);

    /**
     * 修改
     * @param classes
     * @return
     */
    public int update(SyllabusModel logs);

    /**
     * 新增
     * @param classes
     * @return
     */
    public int add(SyllabusModel logs);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);

	public SyllabusModel findById(String id);


}
