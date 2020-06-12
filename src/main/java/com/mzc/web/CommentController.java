package com.mzc.web;

import com.mzc.po.comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author mazhicheng
 * @date 2020/6/12 - 17:52
 */

@Controller
public class CommentController {

    @GetMapping("comments/{blogId}")
    public String comments(Long blogId, Model model){
        model.addAttribute("comments","");
        return "blog :: commentList";
    }

    @PostMapping("comments")
    public String post(comment comment){

        return "redirect:/comments/"+comment.getBlog().getId();
    }
}
