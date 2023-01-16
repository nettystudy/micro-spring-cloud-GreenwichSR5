package com.zhht.test;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class DateTimeTest {

	
	@Test
	public void getLongtime() {
		Date nowdate = new Date();
		System.out.println(nowdate.getTime());
	}
}
