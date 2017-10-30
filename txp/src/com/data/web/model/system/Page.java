package com.data.web.model.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page<T> {

	private static final Logger logger = LoggerFactory.getLogger(Page.class);

	public static String DEFAULT_PAGESIZE = "10";
	private int pageNo; //当前页码
	private int pageSize; // 每页行数
	private int totalRecord; // 总记录数
	private int totalPage; // 总页数
	private Map<String, Object> sumMap;
	private Map<String, Object> params; //查询条件
	private Map<String, List<String>> paramLists; // 数组查询条件
	private List<T> list = new ArrayList<T>(); //返回值

	public static Page newBuilder(int pageNo, int pageSize) {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
	}

	public static String getDEFAULT_PAGESIZE() {
		return DEFAULT_PAGESIZE;
	}

	public static void setDEFAULT_PAGESIZE(String dEFAULT_PAGESIZE) {
		DEFAULT_PAGESIZE = dEFAULT_PAGESIZE;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return list.size();
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		double zhi=((double) totalRecord/pageSize);
		return (int) Math.ceil(zhi);
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Map<String, List<String>> getParamLists() {
		return paramLists;
	}

	public void setParamLists(Map<String, List<String>> paramLists) {
		this.paramLists = paramLists;
	}

	public static Logger getLogger() {
		return logger;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Map<String, Object> getSumMap() {
		return sumMap;
	}

	public void setSumMap(Map<String, Object> sumMap) {
		this.sumMap = sumMap;
	}

	
	
	
}