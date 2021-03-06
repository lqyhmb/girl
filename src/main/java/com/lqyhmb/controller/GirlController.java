package com.lqyhmb.controller;

import com.lqyhmb.model.Girl;
import com.lqyhmb.model.Result;
import com.lqyhmb.repository.GirlRepository;
import com.lqyhmb.service.GirlService;
import com.lqyhmb.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Rodriguez
 * 2017/9/7 13:08
 */

@RestController
public class GirlController {

    private final static Logger LOGGER = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    // 查询所有女生列表
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        //System.out.println("girlList");
        LOGGER.info("girlList");
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return null;
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setName(girl.getName());
        girl.setMoney(girl.getMoney());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /*@PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Result result = new Result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
            return result;
           *//* System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;*//*
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setName(girl.getName());
        girl.setMoney(girl.getMoney());

        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(girlRepository.save(girl));
        return result;
    }*/

    // 添加一个女生
   /* @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("name") String name, @RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }*/

    // 查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    // 更新一个女生
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name,
                           @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age,
                           @RequestParam("money") double money) {

        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setMoney(money);

        return girlRepository.save(girl);
    }

    // 删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    // 通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "/girls/cupSize/{cupSize}")
    public List<Girl> girlListByCupSize(@PathVariable("cupSize") String cupSize) {
        return girlRepository.findByCupSize(cupSize);
    }

    @GetMapping(value = "/girls/two")
    public void girlAddTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
