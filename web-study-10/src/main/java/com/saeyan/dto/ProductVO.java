package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * create table product(
    code number(5) primary key,
    name varchar2(100) not null,
    price number(8) not null,
    pictureurl varchar2(50),
    description VARCHAR2(1000)
);

 * */
@Setter
@Getter
@ToString
public class ProductVO {
//	Integer int 차이는 Integer는 null값을 사용가능, int는 불가능
	private int code;
	private String name;
	private int price;
	private String pictureUrl;
	private String description;
}
