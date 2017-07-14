package com.user.queue;

/**
 * 顺序队列的实现
 * @author user
 *
 */
public class MyQuene<T> implements MyQueueInterface<T>{

	private Object[] quene = new Object[16];
	private int size=0;
	private int fornt=0;//对头
	private int rear=-1; // 对未
	@Override
	public boolean inser(T data) {
		//扩容
		if(size>=quene.length){
			Object[] newQuene = new Object[2*quene.length+1];
			for(int i=0;i<quene.length;i++){
				newQuene[i] = quene[i];
				quene[i]=null;
			}
			quene = newQuene;
		}
		quene[++rear] = data;
	    size++;
		return true;
	}

	@Override
	public T remove() {
		if(size==0){
		return null;
		}else {
			size--;
			return (T) quene[fornt++];
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
		for(int i=0;i<size;i++){
			quene[i] = null;
		}
		size=0;
	}

	@Override
	public boolean isFull() {
		if(rear==quene.length){
			return true;	
		}else {
			return false;
		}
		
	}
}
