package com.lqyhmb.service;

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

}
