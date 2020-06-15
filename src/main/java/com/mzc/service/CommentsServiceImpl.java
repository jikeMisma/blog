package com.mzc.service;

import com.mzc.dao.CommentRepository;
import com.mzc.po.comment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/15 - 9:25
 */

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<comment> lsitCommentByBlogId(Long blodId) {
        Sort sort = Sort.by(Sort.Direction.ASC,"createTime");
        List<comment> comments = commentRepository.findByBlogIdAndParentCommentNull(blodId,sort);
        return eachComment(comments);
    }

    @Transactional
    @Override
    public comment saveComment(comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if(parentCommentId != -1){
            //建立留言回复的子父级关系
            comment.setParentComment(commentRepository.getOne(parentCommentId));
        }else{
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }

    /**
     * 循环每个顶级的评论点
     * @param comments
     * @return
     */
    private List<comment> eachComment(List<comment> comments){
        List<comment> commentsVeiw = new ArrayList<>();
        for(comment comment :comments){
            comment c = new comment();
            BeanUtils.copyProperties(comment,c);
            commentsVeiw.add(c);
        }
        //合并评论的各层的子集到第一层的子集中
        conbineChildren(commentsVeiw);
        return commentsVeiw;
    }

    /**
     * root根节点，blog不为空的对象的集合
     * @param comments
     */
    private void conbineChildren(List<comment> comments){

        for(comment comment : comments){
            List<comment> replys1 = comment.getReplayComments();
            for(comment reply1 :replys1){
                //循环迭代，找出子集，存放在tempRepl中
                recursively(reply1);

            }
            //修改顶级结点的reply集合为迭代处理后的集合
            comment.setReplayComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //存放迭代找出的所有子代集合
    private List<comment> tempReplys = new ArrayList<>();

    /**
     * 剥洋葱
     * @param comment
     */
    private  void recursively(comment comment){
        tempReplys.add(comment);//添加结点到临时存放集合
        if(comment.getReplayComments().size() > 0){
            List<comment> replys = comment.getReplayComments();
            for(comment reply : replys){
                tempReplys.add(reply);
                if(reply.getReplayComments().size() > 0){
                    recursively(reply);
                }
            }
        }
    }
}
