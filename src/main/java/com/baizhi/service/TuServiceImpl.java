package com.baizhi.service;

import com.baizhi.dao.TuMapper;
import com.baizhi.entity.Tu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuServiceImpl implements  TuService {
    @Autowired
    private TuMapper tm;
    @Override
    public Tu select(String id) {
        return tm.selectByPrimaryKey(id);
    }

    @Override
    public void insert(Tu tu) {
        tm.insert(tu);
    }

    @Override
    public List<Tu> selectAll() {
        return tm.selectAll();
    }


}
