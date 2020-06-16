package com.mzc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mazhicheng
 * @date 2020/6/16 - 16:04
 */

@Controller
public class AboutShowController {


    @GetMapping("/about")
    public String about(){

        return "about";
    }
}
