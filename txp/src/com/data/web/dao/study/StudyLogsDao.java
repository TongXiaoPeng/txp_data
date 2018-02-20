package com.data.web.dao.study;

import java.util.List;
import java.util.Map;

import com.data.web.model.study.StudyLogsModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:28:24
 */
public interface StudyLogsDao {


    /**
     * 分页列表
     *
     * @param map
     * @return
     */
    public List<StudyLogsModel> listJson(Page<StudyLogsModel> page);

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
    public int update(StudyLogsModel logs);

    /**
     * 新增
     * @param classes
     * @return
     */
    public int add(StudyLogsModel logs);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);

	public StudyLogsModel findById(String id);


}
