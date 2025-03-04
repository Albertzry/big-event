package org.example.service;

import org.example.pojo.Category;

import java.util.List;

public interface CategoryService {
    //新增分类
    void add(Category category);
    //列表查询
    List<Category> list();
    //根据ID查询
    Category findById(Integer id);
    //更新分类
    void update(Category category);
}
