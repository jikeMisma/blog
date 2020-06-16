package com.mzc.web;

import com.mzc.po.Tag;
import com.mzc.po.Type;
import com.mzc.service.BlogService;
import com.mzc.service.TagService;
import com.mzc.service.TypeService;
import com.mzc.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/16 - 9:54
 */

@Controller
public class TagShowController {

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @GetMapping("/tags/{id}")
    public  String tags(@PageableDefault(size = 6,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         @PathVariable Long id, Model model){

        List<Tag> tags = tagService.lsitTagTop(10000);
        //判断从首页过来的时候显示哪个默认
        if(id == -1){
            id = tags.get(0).getId();
        }

        model.addAttribute("tags",tags);
        model.addAttribute("page",blogService.listBlog(id,pageable));
        model.addAttribute("activeTagid",id);

        return "tags";
    }
}
