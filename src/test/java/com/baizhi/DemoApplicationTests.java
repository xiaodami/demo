package com.baizhi;

import com.baizhi.dao.TuMapper;
import com.baizhi.entity.Tu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
    @Autowired
    private TuMapper tm;
    @Test
    public void contextLoads() {
        List<Tu> tus = tm.selectAll();
        System.out.println(123);
        System.out.println(tus);
        System.out.println(111);
        System.out.println(000);
    }

}
