package com.data.web.service.book;

import java.util.List;
import java.util.Map;

import com.data.web.model.book.BookModel;
import com.data.web.model.system.Page;


/**
 * 
 * @author txp
 * @date 2017-10-29 下午1:23:07
 */
public interface BookService {


    /**
     * 查询书籍
     *
     * @param map
     * @return
     */
    public List<BookModel> listJson(Page<BookModel> page)throws Exception;
    /**
     * 查询书籍数量
     *
     * @param map
     * @return
     */
    public Long getTotalBook(Map<String, Object> map)throws Exception;


    /**
     * 修改书籍
     *
     * @param user
     * @return
     */
    public int updateBook(BookModel book)throws Exception;

    /**
     * 新增书籍
     *
     * @param user
     * @return
     */
    public BookModel addBook(BookModel book)throws Exception;

    /**
     * 删除书籍
     *
     * @param id
     * @return
     */
    public int deleteBook(String id)throws Exception;

}
