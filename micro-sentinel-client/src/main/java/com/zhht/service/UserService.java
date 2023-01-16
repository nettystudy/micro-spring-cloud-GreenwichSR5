package com.zhht.service;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhht.util.ExcepitonUtil;

@Service
public class UserService {

	@SentinelResource(value="getUserName",blockHandler= "exceptionHandler",fallback="getUserFallback")
	public String getUserName(String userName) {
		return userName;
	}
	
	/**
	 * Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数
	 * @param userName
	 * @param t
	 * @return
	 */
	public String getUserFallback(String userName, Throwable t) {
		t.printStackTrace();
		return "getUserFallback error";
	}
	
	/**
	 * Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
	 * @param userName
	 * @param ex
	 * @return
	 */
	public String exceptionHandler(String userName, BlockException ex) {
		ex.printStackTrace();
		return "exceptionHandler error";
	}
	
	/**
	 * 对应的 `handleException` 函数需要位于 `ExceptionUtil` 类中，并且必须为 public static 函数.
	 * @param userName
	 * @return
	 */
	@SentinelResource(value="getAge",blockHandler="handleException",blockHandlerClass= {ExcepitonUtil.class})
	public String getUserAge(String userName) {
		return "10";
	}
	
	@SentinelResource(value="testSource",
			entryType=EntryType.OUT,
			fallbackClass=DefaultFallbackClass.class,//提供的方法必须是public static，否则无法解析
			fallback="testResource",//默认当前class，用于在抛出异常的时候提供 fallback 处理逻辑
			blockHandlerClass=DefaultBlockHaldleClass.class,
			blockHandler=""
			)
	public String testResource(int a,int b) {
		return "";
	}
	
	class DefaultFallbackClass{
		public String testResource(int a,int b ,Throwable t) {
			return "";
		}
	}
	class DefaultBlockHaldleClass{
		public String getBlockHaldleResource(int a,int b ,BlockException ex) {
			return "BlockHaldle";
		}
	}
}
