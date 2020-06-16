package com.mzc.web;

import com.mzc.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mazhicheng
 * @date 2020/6/16 - 14:27
 */

@Controller
public class ArchiveShowController {


    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){

        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.countBlog());
       return "archives";
    }
}
