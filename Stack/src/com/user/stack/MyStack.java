package com.user.stack;


/**
 * 自己实现顺序栈
 * 使用数组
 * @author user
 * @param <T>
 *
 */
public class MyStack<T> implements MyStackInterface<T>{
	
	private int size=0; //栈的大小
	private Object[] stack = new Object[16]; //创建一个数组 

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public void clear() {
		for(int i=0;i<stack.length;i++){
			stack[i] = null;
		}
		size=0;
	}

	@Override
	public boolean push(T data) {
		if (size >= stack.length) { // 进行扩容

			Object[] stackCopy = new Object[2 * stack.length + 1];
			for (int i = 0; i < stack.length; i++) {
				stackCopy[i] = stack[i];
			}
			stack = null;
			stack = stackCopy;
		}
		stack[++size] = data;
		return true;
	}

	@Override
	public T pop() {
		
		if(size==0){
			return null;
		}
		T t = (T) stack[size];
//		stack[size] = null;
		size--;
		return t;
	}

	public T top(){
	
		return (T) stack[size];
	}
	
	@Override
	public int length() {
		
		return size;
	}

	
	
	
}
