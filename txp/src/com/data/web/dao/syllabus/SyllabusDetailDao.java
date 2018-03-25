package com.data.web.dao.syllabus;

import java.util.List;
import java.util.Map;

import com.data.web.model.syllabus.SyllabusDetailModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:28:24
 */
public interface SyllabusDetailDao {


    /**
     * 分页列表
     *
     * @param map
     * @return
     */
    public List<SyllabusDetailModel> listJson(Page<SyllabusDetailModel> page);

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
    public int update(SyllabusDetailModel logs);

    /**
     * 新增
     * @param classes
     * @return
     */
    public int add(SyllabusDetailModel logs);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);

	public SyllabusDetailModel findById(String id);

	/**
	 * 获取课程表明细
	 * @param params
	 * @return
	 */
	public List<SyllabusDetailModel> getList(Map<String, Object> params);


}
