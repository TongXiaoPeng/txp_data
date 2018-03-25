package com.data.web.dto.syllabus;


/**
 * 课程表明细
 * @author txp
 * @date 2017-10-29 ����12:06:04
 */
public class SyllabusDetailDto {

	/**
	 * 明细id
	 */
	private String detailId;
	
	/**
	 * 课程表id
	 */
	private String syllabusId;
	
	/**
	 * 课程名称
	 */
	private String  sourceName;
	
	/**
	 * 周几 0-6  周日到周六
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
	 * 教师名称
	 */
	private String teacherName;
	
	/**
	 * 班级id
	 */
	private String classId;
	
	/**
	 * 班级名称
	 */
	private String className;

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	

}
