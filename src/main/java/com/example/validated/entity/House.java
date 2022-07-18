package com.example.validated.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.validated.annotation.dict.FieldLength;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@TableName("house")
public class House {
  @TableId(type = IdType.AUTO)
  private long id;
  @FieldLength(type = "char",message = "char的问题")
  private String house;
  @FieldLength(type = "int4",message = "int的问题")
  private Integer price;
  private String name;
  private long studentId;
//  @FieldLength(type = "float4",message = "float的取值范围")
//  private float haha;
//  @FieldLength(type ="float8",message = "超出float8的取值范围")
//  private Double dou;
  private UUID UUID;
}
