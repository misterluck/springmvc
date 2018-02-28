package org.demo.springmvc.controller;

import org.demo.springmvc.bean.DemoObj;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @RequestMapping(value = "/getJSON", produces = MediaType.APPLICATION_JSON_VALUE)
    public DemoObj getJson(DemoObj demoObj) {
        System.out.println(demoObj.getId()+"\t"+demoObj.getName());
        return demoObj;
    }

    @RequestMapping(value = "/getXML", produces = MediaType.APPLICATION_XML_VALUE)
    public DemoObj getXml(DemoObj demoObj) {
        return demoObj;
    }

}
