package com.user.stack;

public interface MyStackInterface<T> {
	/**
	 * 判断栈石否为空
	 */
	boolean isEmpty();
	/**
	 * 清空栈
	 */
	void clear();
	/**
	 * 入栈
	 */
	boolean push(T data);
	/**
	 * 出栈
	 */
	T pop();
	/**
	 * 栈长度
	 */
	int length();
}
