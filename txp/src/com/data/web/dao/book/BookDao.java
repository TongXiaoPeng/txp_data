package com.data.web.dao.book;

import java.util.List;
import java.util.Map;

import com.data.web.model.book.BookModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 上午1:28:24
 */
public interface BookDao {


    /**
     * 查询
     *
     * @param map
     * @return
     */
    public List<BookModel> listJson(Page<BookModel> page);

    /**
     * @param map
     * @return
     */
    public Long getTotalBook(Map<String, Object> map);

    /**
     * 更新
     *
     * @param book
     * @return
     */
    public int update(BookModel book);

    /**
     * 新增
     *
     * @param book
     * @return
     */
    public int add(BookModel book);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delete(String id);

}
