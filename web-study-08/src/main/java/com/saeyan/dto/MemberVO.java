package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
create table member(
	name varchar2(30),
	userid varchar2(30) PRIMARY key,
	pwd VARCHAR2(20),
	email varchar2(30),
	phone char(13),
	admin number(1)
);
*/

@Setter
@Getter
@ToString
public class MemberVO {
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
}
