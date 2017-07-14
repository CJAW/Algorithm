package com.user.queue;

/**
 * 实现链队列
 * @author user
 *
 * @param <T>
 */

public class MyLinkQuene<T> implements MyQueueInterface<T> {

	
	private int size=0;
	private Node<T> front = null; //对头
	private Node<T> rear =null; // 队未
	
	@Override
	public boolean inser(T data) {
		//使用为空判断关联头尾节点，即首次插入节点头尾节点一样
		if(isEmpty()){
			Node<T> node = new Node<T>();
			node.data = data;
			front = rear = node;
			size++;
		}else {
			Node<T> node = new Node<T>();
			node.data = data;
			//队未插入
			rear.next = node; //链接节点
			rear = node;  //队未变化
			size++;
		}
		
		return true;
	}

	@Override
	public T remove() {
		if(front==null){
			return null;
		}else {
			
			T t = front.data;
			front = front.next;
			size--;
			return t;
		}
	}

	@Override
	public int length() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public void clear() {
		
		front = null;
		size=0;
	}

	@Override
	public boolean isFull() {
		
		return false;
	}
	
}

class Node<T>{
	T data;
	Node<T> next;
	
}
