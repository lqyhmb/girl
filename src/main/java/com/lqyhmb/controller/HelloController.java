package com.lqyhmb.controller;

import com.lqyhmb.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rodriguez
 * 2017/9/4 15:26
 */

@RestController
@RequestMapping(value = {"/hello", "/hi"})
public class HelloController {

    @GetMapping(value = "/test4")
    //@PostMapping(value = "/test4")
    public String test4(@RequestParam(value = "id", required = false, defaultValue = "100") Integer myId) {
        return "id: " + myId;
    }


    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public String test3(@RequestParam(value = "id", required = false, defaultValue = "100") Integer myId) {
        return "id: " + myId;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(@RequestParam("id") Integer myId) {
        return "id: " + myId;
    }

    @RequestMapping(value = "/{id}/test1/{number}", method = RequestMethod.GET)
    public String test1(@PathVariable("id") Integer id, @PathVariable("number") Integer number) {
        return "id: " + id + " number:" + number;
    }

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
        //return "Hello Spring Boot!";
        //return "name: " + name + " cupSize: " + cupSize + " age: " + age;
        //return content;
        //return girlProperties.getName() + " " + girlProperties.getCupSize() + " " + girlProperties.getAge();
        return girlProperties.getCupSize();
    }

    @Value("${name}")
    private String name;

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

}
