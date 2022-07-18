package com.example.validated.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.validated.entity.House;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface HouseMapper extends BaseMapper<House> {
}
