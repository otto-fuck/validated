package com.example.validated.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.validated.entity.House;
import com.example.validated.repository.HouseMapper;
import com.example.validated.service.HouseService;
import org.springframework.stereotype.Service;

//public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {

}
