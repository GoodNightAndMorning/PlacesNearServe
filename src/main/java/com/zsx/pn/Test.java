package com.zsx.pn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "hello world";
    }
}
