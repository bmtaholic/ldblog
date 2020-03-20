package com.fwh.blog.service;

import com.fwh.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    // 新增
    Type saveType(Type type);

    // id查询
    Type getType(Long id);

    // 通过名称查询
    Type getTypeByName(String name);

    // 分页查询
    Page<Type> listType(Pageable pageable);

    //博客页面的标题框
    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    // 修改
    Type updateType(Long id, Type type);

    // 删除
    void deleteType(Long id);
}
