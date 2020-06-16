package com.mzc.service;

import com.mzc.dao.BlogRepository;
import com.mzc.po.Blog;
import com.mzc.po.Type;
import com.mzc.util.MarkdownUtils;
import com.mzc.util.MyBeanUtiles;
import com.mzc.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/5/20 - 19:13
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    @Transactional
    @Override
    public Blog getAndConvert(Long id) throws ClassNotFoundException {
        Blog blog =blogRepository.getOne(id);
        if(blog == null){
            throw new ClassNotFoundException("博客不存在");
        }
        Blog b = new Blog();
        BeanUtils.copyProperties(blog,b);
        String content = b.getContent();
        b.setContent(MarkdownUtils.makedownToHtmlExtensions(content));

        //浏览详情页面之后浏览数目进行增加
        blogRepository.updateViews(id);
        return b;
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            //CriteriaQuery：查询的条件容器
            //criteriaBuilder:设置具体条件的表达式
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(!"".equals(blog.getTitle()) && blog.getTitle() !=null){
                    predicates.add(cb.like(root.<String>get("title"),"%"+blog.getTitle()));
                }

                if(blog.getTypeId() !=null){
                    predicates.add(cb.equal(root.<Type>get("type").get("id"),blog.getTypeId()));
                }

                if(blog.isRecommened()){
                    predicates.add(cb.equal(root.<Boolean>get("recommened"),blog.isRecommened()));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    //根据id查询对应的博客
    @Override
    public Page<Blog> listBlog(Long tagId, Pageable pageable) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Join join = root.join("tages");
                return cb.equal(join.get("id"),tagId);
            }
        },pageable);
    }

    @Override
    public Page<Blog> listBlog(String query, Pageable pageable) {
        return blogRepository.findByQuery(query,pageable);
    }

    @Override
    public List<Blog> listRecommendlistBlogTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"updateTime");
        Pageable pageable = PageRequest.of(0,size,sort);
        return blogRepository.findTop(pageable);
    }

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {

        if(blog.getId() == null){
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        }else{
            blog.setUpdateTime(new Date());
        }
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) throws ClassNotFoundException {
        Blog b = blogRepository.getOne(id);
        if(b == null){
            throw new ClassNotFoundException("该博客不存在");

        }
        BeanUtils.copyProperties(blog,b, MyBeanUtiles.getNullPropertyNames(blog));
        return blogRepository.save(b);
    }

    @Transactional
    @Override
    public void deleteBlog(Long id) {

        blogRepository.deleteById(id);
    }
}
