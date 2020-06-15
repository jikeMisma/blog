package com.mzc.web;

import com.mzc.po.comment;
import com.mzc.service.BlogService;
import com.mzc.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author mazhicheng
 * @date 2020/6/12 - 17:52
 */

@Controller
public class CommentController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private  BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentsService.lsitCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("comments")
    public String post(comment comment){

        Long blodId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blodId));
        comment.setAvatar(avatar);
        commentsService.saveComment(comment);
        return "redirect:/comments/"+blodId;
    }
}
