package com.fwh.blog.service;

import com.fwh.blog.pojo.Blog;
import com.fwh.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
    //查询
    Blog getBlog(Long id);

    // md转html
    Blog getAndConvert(Long id);

    // 分页查询
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    Page<Blog> listBlog(String query, Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();

    // 新增
    Blog saveBlog(Blog blog);

    //修改
    Blog updateBlog(Long id, Blog blog);

    //删除
    void deleteBlog(Long id);
}
