package com.data.web.dao.book;

import java.util.List;
import java.util.Map;

import com.data.web.model.book.BookModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:28:24
 */
public interface BookDao {


    /**
     * ��ѯ
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
     * ����
     *
     * @param book
     * @return
     */
    public int update(BookModel book);

    /**
     * ����
     *
     * @param book
     * @return
     */
    public int add(BookModel book);

    /**
     * ɾ��
     *
     * @param id
     * @return
     */
    public int delete(String id);

}
