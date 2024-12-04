package com.cxzcanying.controller;

import com.cxzcanying.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name+":"+age);
//        return "OK";
//
//    }

//springboot
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name,Integer age){
//        System.out.println(name+":"+age);
//        return "OK";
//
//    }
//映射
    @RequestMapping("/simpleParam")
    public Result<Object> simpleParam(@RequestParam(name="name" ,required = false/*默认为ture*/) String username, Integer age){
        System.out.println(username+":"+age);
        return Result.success(username+":"+age);

    }
}
