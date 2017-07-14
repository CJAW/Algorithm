package com.user.stack;


/**
 *链栈的实现 
 * @author user
 * @param <T>
 *
 */

public class LinkStack<T> implements MyStackInterface<T>{


	private int size ;
	private Node<T> top; // 栈顶
	
	 public LinkStack() {
		 size =0;
		 top =null;
	}
	
	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public void clear() {
		top = null;
		size=0;
	}

	@Override
	public boolean push(T data) {
		//新建节点
		Node<T> node = new Node<T>();
		node.setDatas(data);
		//链接节点
		node.setPre(top);
		//变换栈顶节点
		top = node;
		size++;
		return true;
	}

	@Override
	public T pop() {
		if(top==null){
			return null;
		}else {
			T t = top.getDatas();
			//变更top节点
			top =top.getPre(); 
			size--;
			return t;

		}
	}	

	public T currentNode() {
		return top.getDatas();
	}
	
	@Override
	public int length() {
		
		return size;
	}

}
