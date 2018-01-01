package com.data.web.service.book;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.data.web.dao.book.BookDao;
import com.data.web.model.book.BookModel;
import com.data.web.model.system.Page;
import com.data.web.service.book.BookService;


/**
 * 
 * @author txp
 * @date 2017-10-29 ÉÏÎç1:25:15
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;


    @Override
    public List<BookModel> listJson(Page<BookModel> page)throws Exception {
        return bookDao.listJson(page);
    }

    @Override
    public int updateBook(BookModel book)throws Exception {
    	book.setUpdateTime(new Date());
        return bookDao.update(book);
    }

    @Override
    public Long getTotalBook(Map<String, Object> map)throws Exception {
        return bookDao.getTotalBook(map);
    }

    @Override
    public BookModel addBook(BookModel book)throws Exception {
    	book.setCreateName(book.getUserId());
    	book.setCreateTime(new Date());
    	book.setIsDeleted(0);
    	bookDao.add(book);
		return book;
    }

    @Override
    public int deleteBook(String id)throws Exception {
        return bookDao.delete(id);
    }



}