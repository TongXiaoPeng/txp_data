package com.data.web.model.syllabus;

import com.data.web.model.system.BaseModel;

/**
 * 课程表详情
 * @author txp
 * @date 2017-10-29 ����12:06:04
 */
public class SyllabusDetailModel extends BaseModel{

	/**
	 * id
	 */
	private String id;
	
	/**
	 * 课程表id
	 */
	private String syllabusId;
	
	/**
	 * 课程名称
	 */
	private String  sourceName;

	/**
	 * 周几：0-6 --周日到周六
	 */
	private Integer weekType;
	
	/**
	 * 序号
	 */
	private Integer serial;
	
	/**
	 * 是否单周
	 */
	private Integer isSingle;
	
	/**
	 * 教师id
	 */
	private String teacherId;
	
	/**
	 * 班级id
	 */
	private String classId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSyllabusId() {
		return syllabusId;
	}

	public void setSyllabusId(String syllabusId) {
		this.syllabusId = syllabusId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Integer getWeekType() {
		return weekType;
	}

	public void setWeekType(Integer weekType) {
		this.weekType = weekType;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Integer getIsSingle() {
		return isSingle;
	}

	public void setIsSingle(Integer isSingle) {
		this.isSingle = isSingle;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	
}
