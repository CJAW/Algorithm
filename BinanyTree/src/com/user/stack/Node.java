package com.user.stack;

/**
 * 节点
 * @author user
 * @param <T>
 *
 */

public class Node<T> {

	private Node pre;
	private T datas;
	public Node getPre() {
		return pre;
	}
	public void setPre(Node pre) {
		this.pre = pre;
	}
	public T getDatas() {
		return datas;
	}
	public void setDatas(T datas) {
		this.datas = datas;
	}
	
}
