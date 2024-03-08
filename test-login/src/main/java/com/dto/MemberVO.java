package com.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
create table member(
	name varchar2(30),
	userid varchar2(30) PRIMARY key,
	pwd VARCHAR2(20),
	admin number(1)
);
*/

@Setter
@Getter
@ToString
public class MemberVO {
	String name;
	String userid;
	String pwd;
	int admin;
}
