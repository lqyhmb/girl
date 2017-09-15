package com.lqyhmb.service;

import com.lqyhmb.exception.GirlException;
import com.lqyhmb.model.Girl;
import com.lqyhmb.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rodriguez
 * 2017/9/7 15:07
 */

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl = new Girl();
        girl.setName("Mary2");
        girl.setAge(15);
        girl.setCupSize("F");
        girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setName("Mary3");
        girl2.setAge(16);
        girl2.setCupSize("GGGG");
        girlRepository.save(girl2);
    }

   /* public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            // 返回"你还在上小学吧" code=100
            throw new Exception("你还在上小学吧");
        } else if (age > 10 && age < 16) {
            // 返回"你可能还在上初中" code=101
            throw new Exception("你可能还在上初中");
        }

        // 如果age>16，加钱
        // ...
    }*/

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            // 返回"你还在上小学吧" code=100
            throw new GirlException(100, "你还在上小学吧");
        } else if (age > 10 && age < 16) {
            // 返回"你可能还在上初中" code=101
            throw new GirlException(101, "你可能还在上初中");
        }

        // 如果age>16，加钱
        // ...
    }
}
