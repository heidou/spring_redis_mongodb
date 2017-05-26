package com.heidou.controller;

import com.heidou.dao.BookDOMapper;
import com.heidou.dao.NameDao;
import com.heidou.model.BookDO;
import com.heidou.model.StudentDO;
import com.heidou.util.RedisComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author heidou.f
 *         2017/3/25.
 */
@RestController
@RequestMapping("/hd")
public class HeidouController {

    @Autowired
    private BookDOMapper bookDOMapper;
    @Autowired
    private RedisComponent redisComponent;
    @Autowired
    private NameDao nameDao;

    @RequestMapping(value = "/dum", method = {RequestMethod.GET, RequestMethod.POST})
    public String findByName() {
        StudentDO studentDO = new StudentDO();
        studentDO.setName("hhh");
        nameDao.create(studentDO);
        nameDao.findByName("hhh");
        return null;
    }


    @RequestMapping(value = "/read", method = {RequestMethod.GET, RequestMethod.POST})
    public String selectByPrimaryKey(ModelMap map, HttpServletRequest request,
                                     @RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        BookDO bookDO = new BookDO();

        bookDO.setName("英语");
        bookDO.setPrice(28.23);
        bookDO.setTenantId("2013");
        bookDOMapper.insert(bookDO);

        redisComponent.set("key13", "qwq");
        String result = (String) redisComponent.get("key13");

        System.out.println("-----book----- " + bookDO.getName() + bookDO.getPrice());
        return "id =" + myId;
    }
}
