package com.lqyhmb.repository;

import com.lqyhmb.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Rodriguez
 * 2017/9/7 13:10
 */

public interface GirlRepository extends JpaRepository<Girl,Integer>{

    // 通过年龄来查询
    public List<Girl> findByAge(Integer age);

    // 通过cupSize来查询
    public List<Girl> findByCupSize(String cupSize);
}
