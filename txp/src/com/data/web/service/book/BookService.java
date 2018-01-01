package com.data.web.service.book;

import java.util.List;
import java.util.Map;

import com.data.web.model.book.BookModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 ����1:23:07
 */
public interface BookService {


    /**
     * ��ѯ�鼮
     *
     * @param map
     * @return
     */
    public List<BookModel> listJson(Page<BookModel> page)throws Exception;
    /**
     * ��ѯ�鼮����
     *
     * @param map
     * @return
     */
    public Long getTotalBook(Map<String, Object> map)throws Exception;


    /**
     * �޸��鼮
     *
     * @param user
     * @return
     */
    public int updateBook(BookModel book)throws Exception;

    /**
     * �����鼮
     *
     * @param user
     * @return
     */
    public BookModel addBook(BookModel book)throws Exception;

    /**
     * ɾ���鼮
     *
     * @param id
     * @return
     */
    public int deleteBook(String id)throws Exception;

}
