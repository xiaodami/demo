package com.baizhi.service;

import com.baizhi.entity.Tu;

import java.util.List;

public interface TuService {
    Tu select(String id);
    void insert(Tu tu);
    List<Tu> selectAll();
}
