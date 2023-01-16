package com.zhht.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ExcepitonUtil {

	
	public static String  handleException(String userName,BlockException ex) {
		return "get age occurred exception";
	}
}
