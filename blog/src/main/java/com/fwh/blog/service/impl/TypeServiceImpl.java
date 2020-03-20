package com.fwh.blog.service.impl;

import com.fwh.blog.NotFoundException;
import com.fwh.blog.dao.TypeRepository;
import com.fwh.blog.pojo.Type;
import com.fwh.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    // 添加
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    // 用id获取
    public Type getType(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    // 通过名称查询
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    // 分页查新
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }


    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = new PageRequest(0,size,sort);
        return typeRepository.findTop(pageable);
    }


    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        //首先根据id把type查询出来
        Type t = typeRepository.findOne(id);
        // 如果查不出来,抛出异常
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        // 把需要修改的数据复制到新的类型中
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }



    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.delete(id);
    }
}
