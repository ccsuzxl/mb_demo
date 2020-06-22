package com.example.mb_demo.controller;

import com.example.mb_demo.bean.Emp;
import com.example.mb_demo.bean.User;
import com.example.mb_demo.service.EmpService;
import com.example.mb_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmpService empService;


    @RequestMapping("test")
    public String test(){
        final RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        final HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String header = request.getHeader("user-agent");
        System.out.println(header);
        return "Hello!";
    }

    @RequestMapping("getUsersByName")
    public List<User> getUsersByName(String name, String orderByColumn){
        System.out.println("name:"+name+"   orderByColumn:"+orderByColumn);
        return userService.selectUserByName(name,orderByColumn);
    }
    @PostMapping("getAllEmp")
    public List<Emp> getAllEmp(){
        System.out.println("11111");
        return empService.selectAllEmp();
    }
}
