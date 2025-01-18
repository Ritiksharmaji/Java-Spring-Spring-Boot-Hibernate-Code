package com.example_using_vs.demo_vs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestControllerByVs {

    @RequestMapping("/test")
    public String firstHandler() {

        System.out.println("test controller is runing");
        return "this is for testing purpose by using the Vs IDE:";

    }

}
