package com.user.queue;

/**
 * 队列需要实现的接口
 * @author user
 *
 */

public interface MyQueueInterface<T> {
	/**
	 * 插入
	 * @param data
	 */
	boolean inser(T data);
	/**
	 * 获取
	 * @return
	 */
	T remove();
	/**
	 * 长度
	 * @return
	 */
	int length();
	/**
	 * 叛空
	 * @return
	 */
	boolean isEmpty();
	/**
	 * 清除
	 */
	void clear();
	/**
	 * 对满
	 */

	boolean isFull();
}
