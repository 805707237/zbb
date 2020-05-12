package com.course.dao;

import com.course.model.sql.Tem;

import java.util.List;

public interface TemDao {
    /**查询所有**/
    List<Tem> findAll();

    /**user表和tem表一对一查询*/
    List<Tem> temUser();
}
