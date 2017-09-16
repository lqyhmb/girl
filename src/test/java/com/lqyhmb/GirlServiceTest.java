package com.lqyhmb;

import com.lqyhmb.model.Girl;
import com.lqyhmb.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Rodriguez
 * 2017/9/16 10:31
 */

@RunWith(SpringRunner.class) // 表示现在在测试环境里面跑了，底层使用的是Juint工具
@SpringBootTest // 表示启动整个Spring工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(3);
        Assert.assertEquals(new Integer(15), girl.getAge());
        //Assert.assertEquals(new Integer(16), girl.getAge());
    }
}
