package com.fwh.blog.service;

import com.fwh.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface TagService {

    // 新增
    Tag saveTag(Tag type);

    //通过id获取标签
    Tag getTag(Long id);

    // 通过名称获取标签
    Tag getTagByName(String name);

    //分页查询
    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

    List<Tag> listTag(String ids);

    // 更新
    Tag updateTag(Long id, Tag type);

    //删除
    void deleteTag(Long id);
}
