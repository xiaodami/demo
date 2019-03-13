package com.baizhi.dao;

import com.baizhi.entity.Tu;

import java.util.List;

public interface TuMapper  {
    int deleteByPrimaryKey(String id);

    int insert(Tu record);

    int insertSelective(Tu record);

    Tu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tu record);

    int updateByPrimaryKey(Tu record);
    List<Tu> selectAll();
}