package com.data.web.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.data.web.model.book.BookModel;
import com.data.web.model.system.Page;
import com.data.web.model.user.UserModel;
import com.data.web.service.book.BookService;
import com.data.web.util.ResponseUtil;
import com.data.web.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping(value="myBooksManage")
	public ModelAndView bookManage(){
		ModelAndView mView = new ModelAndView("book/booksManage");
		return mView;
	}
    
    @RequestMapping(value="allBooksManage")
	public ModelAndView allBooksManage(){
		ModelAndView mView = new ModelAndView("book/allBooksManage");
		return mView;
	}
    
    @RequestMapping("/listAll")
    @ResponseBody
    public Object listAll(
            @RequestParam(value = "page", defaultValue="1") int pageNo,
            @RequestParam(value = "rows", defaultValue="20") int pageSize,
            BookModel book, HttpServletResponse response) throws Exception {
    	Page<BookModel> page = new Page<BookModel>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bookName", StringUtil.formatLike(book.getBookName()));
        map.put("bookType", StringUtil.formatLike(book.getBookType()));
        map.put("borrowType", StringUtil.formatLike(book.getBorrowType()));
        page.setParams(map);
        page.setList( bookService.listJson(page));
        
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("rows", page.getList());
        result.put("total", page.getTotalRecord());
        return result;
    }

    @RequestMapping("/listMy")
    @ResponseBody
    public Object listMy(
            @RequestParam(value = "page", defaultValue="1") int pageNo,
            @RequestParam(value = "rows", defaultValue="20") int pageSize,
            BookModel book, 
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
    	Page<BookModel> page = new Page<BookModel>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bookName", StringUtil.formatLike(book.getBookName()));
        
        HttpSession session = request.getSession();
    	UserModel user = (UserModel) session.getAttribute("currentUser");
    	map.put("userId",user.getUserId());
        page.setParams(map);
        page.setList( bookService.listJson(page));
        
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("rows", page.getList());
        result.put("total", page.getTotalRecord());
        return result;
    }
    /**
     * 添加或修改书籍
     *
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(BookModel book, HttpServletResponse response,HttpServletRequest request) throws Exception {
    	JSONObject result = new JSONObject();
        try{
	        if (book.getBookId() == null) {
	        	HttpSession session = request.getSession();
	        	UserModel user = (UserModel) session.getAttribute("currentUser");
	        	book.setUserId(user.getUserId());
	        	bookService.addBook(book);
	        } else {
	            bookService.updateBook(book);
	        }
            result.put("success", true);
        }catch(Exception e){
        	e.printStackTrace();
        	result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
    
    /**
     * 删除书籍
     *
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            bookService.deleteBook(idsStr[i]);
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
