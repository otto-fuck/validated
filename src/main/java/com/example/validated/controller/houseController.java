package com.example.validated.controller;

import com.example.validated.entity.House;
import com.example.validated.repository.HouseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.UUID;

@RestController
public class houseController {
    //UUID 他只能在requestBody里面 现在的方法是用于解决用参数
    @Resource
    public HouseMapper houseMapper;


    /**
     * 添加测试
     * @param house
     * @return
     */

    @PostMapping("/save")
    public int save(@RequestBody @Valid House house){
        int insert = houseMapper.insert(house);
        if(insert!=0){
            return 1;
        }else {
            return 0;
        }
    }

    @PostMapping("/saaaave")
    public int savee(@Param("UUID")UUID UUID){
        System.out.println(UUID);

        return 1;
    }

    @PostMapping("/saaaa")
    public int saveee(@RequestParam("UUID")UUID UUID){
        System.out.println(UUID);

        return 1;

    }

    @PostMapping("/lalala")
    public int savevvv(@PathVariable("UUID")UUID uuid){
        House house = new House();
        return 1;
    }


}
