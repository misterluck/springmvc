package org.demo.springmvc.controller;

import org.demo.springmvc.bean.DemoObj;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test(String username, String password) {
        System.out.println("username:"+username+"password:"+password);
        return "username:"+username+"password:"+password;
    }

    @RequestMapping(value = "/pathVariable/{message}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String pathVariable(@PathVariable(value = "message") String str, HttpServletRequest request) {
        System.out.println("url:"+request.getRequestURL()+" message:"+str);
        return "url:"+request.getRequestURL()+" message:"+str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String passRequestParam(String id, String name, HttpServletRequest request) {
        return "url:"+request.getRequestURL()+" id:"+id+" name:"+name;
    }

    @RequestMapping(value = "/obj", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String passObj(DemoObj demoObj, HttpServletRequest request) {
        return "{url:"+request.getRequestURL()+",id:"+demoObj.getId()+",name:"+demoObj.getName()+"}";
    }

    @RequestMapping(value = {"/name1","/name2"}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String name(HttpServletRequest request) {
        return "url:"+request.getRequestURL();
    }

}
