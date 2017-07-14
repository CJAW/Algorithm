package com.user.binanyTree;

import java.util.Scanner;

import com.user.queue.MyQuene;
import com.user.stack.LinkStack;
import com.user.stack.MyStack;


/**
 * 使用链式结构实现二叉树(递归和非递归的创建)（以及二叉树的遍历，将使用非递归和递归）
 * 顺序结构的二叉树易造成空间的浪费，却可以用数组代替。
 * @author user
 *
 * @param <T>
 */

public class MyBainyTree<T> implements BinanyTree<T> {	
	int i = 0;
	int top = 0; // 栈顶指针
	// 非递归创建二叉树，返回树根节点

	@Override
	public Node<T> creadeBainyTreeNoRecursion(T[] elemet) {
		Node<T>[] stack = new Node[20]; // 存储双亲节点,模拟栈
		Node<T> root = null; // 跟节点
		Node<T> currenttree = null; // 当前节点
		int flag = 1;
		if (root == null) {
			Node<T> newNode = new Node<T>();
			newNode.data = elemet[0];
			root = newNode;
			root.leftChild = null;
			root.rightChild = null;
			stack[++top] = root; // 根节点入栈
			i = i + 1;
		}
		while (i != elemet.length) {
			if (flag == 1) {
				if (elemet[i] == "#") {
					flag = 2;
				} else {
					Node<T> newNode = new Node<T>();
					newNode.data = elemet[i];
					currenttree = stack[top];
					currenttree.leftChild = newNode;
					stack[++top] = newNode;
					flag = 1;
				}
			} else if (flag == 2) {
				if (i < elemet.length && elemet[i] == "#") {
					flag = 3;
				} else {
					Node<T> newNode = new Node<T>();
					newNode.data = elemet[i];
					currenttree = stack[top];
					currenttree.rightChild = newNode;
					stack[++top] = newNode;
					flag = 1;
				}
			} else if (flag == 3) { // 左右子树都满，进行出栈，会到父节点
				currenttree = stack[--top];
				while (top > 1 && stack[top - 1].leftChild == currenttree) {
					--top;
					flag = 2;
					--i;
				}
			}
			++i;
		}
		return root;
	}

	// 递归建立二叉树,返回树根节点
	public Node<T> creadeBainyTreeRecursion() {
		Node<T> bt = null;
		System.out.println("输入节点数字");
		Scanner string = new Scanner(System.in);
		String s = string.nextLine();
		char c;
		c = s.charAt(0);
		if (c == '#') {
			return bt = null;
		} else {
			bt = new Node<T>(); // 第一步创建根节点
			bt.data = (T) s;
			bt.leftChild = creadeBainyTreeRecursion();
			bt.rightChild = creadeBainyTreeRecursion();
			return (bt);
		}
	}

	@Override
	public void preOrder(Node node) {
		// 判断当前节点是否为空
		if (node == null) {
			return;
		}
		System.out.print((T) node.data); // 取出根节点的值,以及后序节点的值
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}
	
	//非递归的先序遍历，遍历左子树，入栈，遇null出栈，遍历右子树，重复步骤
	public void preOrderNoRecursion(Node<T> tree) {
		MyStack<Node<T>> myStack = new MyStack<>();
			while (!myStack.isEmpty()||tree!=null) {
				// 遍历左子树
				while (tree != null) {
					System.out.print(tree.data);
					myStack.push(tree);
					tree = tree.leftChild;
				}
				//出栈寻找右子树
				if(!myStack.isEmpty()){
					tree  = myStack.pop();
					tree = tree.rightChild;
				}
			}	
	}
	
	
	@Override
	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.leftChild);
		System.out.print((T) node.data); // 取出根节点的值,以及后序节点的值
		inOrder(node.rightChild);
	}
	
	//非递归中序遍历,现遍历左子树，入栈，遇null则出栈遍历右子树，右子树入栈，重复步骤
	public void inOrderNoRecursion(Node<T> tree){
		MyStack<Node<T>> myStack = new MyStack<>();
		while (!myStack.isEmpty()||tree!=null) {
			// 遍历左子树
			while (tree != null) {
				myStack.push(tree);
				tree = tree.leftChild;
			}
			//出栈寻找右子树
			if(!myStack.isEmpty()){
				tree  = myStack.pop();
				System.out.print(tree.data);
				tree = tree.rightChild;
			}
		}	
		
	}

	@Override
	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		System.out.print((T) node.data); // 取出根节点的值,以及后序节点的值
	}
	
	// 非递归后序遍历，所有节点压入两次栈中
	public void postOrderNonRecursion(Node<T> tree) {
		MyStack<postNode<T>> myStack = new MyStack<>();
		postNode<T> pNode = null;//临时判断的节点
		
		while (!myStack.isEmpty() || tree != null) {
			// 遍历左子树
			while (tree != null) {
				postNode<T> postNode = new postNode<T>();// 含有标志的节点
				postNode.postNode = tree;
				postNode.isFirst = true;
				myStack.push(postNode);
				tree = tree.leftChild;
			}
			if (!myStack.isEmpty()) {
				//获取头节点，判断是否两次压栈。
				pNode = myStack.pop(); //临时判断的节点
				if (pNode.isFirst == true) {
					pNode.isFirst = false;
					myStack.push(pNode);
					tree = pNode.postNode.rightChild;
				} else{ //两次压栈打印
					System.out.print(pNode.postNode.data);
					tree = null;//当前节点为空
				}
			}
		}
	}
	
	// 二叉树的层次遍历,使用队列，先进先出
	@Override
	public void levelOrder(Node node) {

		MyQuene<Node<T>> myQuene = new MyQuene<>();
		if (node != null) { // 根节点加入队列
			myQuene.inser(node);
		}
		Node<T> currNode = null; // 关键点，临时存放当前的节点，为了不修改节点
		while (!myQuene.isEmpty()) {

			node = myQuene.remove(); //出队列， 取出节点,即地址
			
			System.out.print(node.data);

			if ((currNode = node.leftChild) != null) {
				myQuene.inser(currNode);
			}
			if ((currNode = node.rightChild) != null) {
				myQuene.inser(currNode);
			}
		}
	}

	//获取树的高度
	public int treeHeight(Node<T> tree){
		
		int left = 0;
		int right = 0; 
		
		if(tree==null){
			return 0;
			}
		//左子树
			left = left +treeHeight(tree.leftChild);
			//右子树
			right = right +treeHeight(tree.rightChild);
		
		return (left>right)?left+1:right+1;//出栈时进行相加
	}
	
	// 查找二叉树中的某一个节点
	public Node<T> findNode(Node<T> tree, T x) {
		Node<T> currNode = null;//当前节点,防止节点被修改。
		if (tree == null) {
			return null;
		}
		if(tree.data.equals(x)){  //==比较的是地址（两个地址的值不一样），equals比较的是值
			return tree;
		}else {
			//查询左子树，不再左就在右
			currNode = findNode(tree.leftChild, x);//当前节点,防止节点被修改。
			if(currNode!=null){
				return currNode;
			}else {
				//查询右子树
				return findNode(tree.rightChild, x);
			}	
		}
	}
	
	//以某个节点的为根，输出高度
	public int treeHeightByNode(Node<T>tree ,T x){
		Node<T> findNode = findNode(tree, x);
		return treeHeight(findNode);
	}
	
	//以某个节点，查找节点所在的层数
	public int treeLevelByNode(Node<T> tree , T x){
		int left = 0;//左子数高度
		int right = 0; //有子树高度
		int level = 0;//层数
		if(tree ==null){
			return 0;
		}
		if(tree.data.equals(x)){
			return level=1;
		}else {
		//遍历左子树，不再左就在右
		left = treeLevelByNode(tree.leftChild, x);
		//遍历右子树
		right = treeLevelByNode(tree.rightChild, x);
		}
		//未找到节点
		if(left==0&&right==0) {
		return level =0;	
		}else {
			return level = (left>right)?(left+1):(right+1);//出栈时进行相加
		}
	
	}

	@Override
	public boolean isEmpty(Node<T> tree) {

		if (tree == null) {
			return true;
		} else {
			return false;
		}

	}

	//寻找某个节点的所有的祖父节点
	@Override
	public boolean parent(Node<T> tree ,T x) {

		if(tree==null){
			return false;
		}
		//当找到节点时，跳出递归，开始回溯。，相当于将栈中节点弹出
		if(tree.data.equals(x)){
			return true;
		}
		//后序遍历的两次入栈
		if(parent(tree.leftChild, x)==true||parent(tree.rightChild, x)==true){
			System.out.print(tree.data);
			return true;
		}
		
       return true;
	}
	//寻找某个节点的所有的祖父节点，非递归
	public void parentNoRecusion(Node<T> tree,T x){
		MyStack<postNode<T>> myStack = new MyStack<>();
		postNode<T> pNode = null;//临时判断的节点
		
		while (!myStack.isEmpty() || tree != null) {
			// 遍历左子树
			while (tree != null) {
				postNode<T> postNode = new postNode<T>();// 含有标志的节点
				postNode.postNode = tree;
				postNode.isFirst = true;
				myStack.push(postNode);
				tree = tree.leftChild;
			}
			if (!myStack.isEmpty()) {
				//获取头节点，判断是否两次压栈。
				pNode = myStack.pop(); //临时判断的节点
				if (pNode.isFirst == true) {
					pNode.isFirst = false;
					myStack.push(pNode);
					tree = pNode.postNode.rightChild;
				} else{ //两次压栈打印
					if(pNode.postNode.data.equals(x)){//当找到该节点后，栈中剩余的节点都是改节点的祖先节点
						break;
					}
					tree = null;//当前节点为空
				}
			}
		}
		//打印栈中的祖先节点
		while(!myStack.isEmpty()){
			System.out.print(myStack.pop().postNode.data);
		}
	}
	
	//查找树中所有的叶子节点，既没有左右子树的节点
	public void findLeafNode(Node<T> tree){
		if(tree==null){
			return;
		}
		if(tree.leftChild==null&&tree.rightChild==null){
			
			System.out.print(tree.data);
		}
		//左子树
		findLeafNode(tree.leftChild);
		//右子树
		findLeafNode(tree.rightChild);
		
		
	}
	
	public static void main(String[] args) {
		MyBainyTree<Object> myBainyTree = new MyBainyTree<>();
		String[] a = { "A","B","C","#","#","D","E","#","G","#","#","F","#","#","#" }; // 以前序遍历ABD123CE4F5G678
		Node node = myBainyTree.creadeBainyTreeRecursion();
		//System.out.println(myBainyTree.treeLevelByNode(node, "a"));
//		myBainyTree.parent(node, "d");
		myBainyTree.findLeafNode(node);
	}

}



class Node<T> {

	T data;
	Node leftChild = null;
	Node rightChild = null;

}

class postNode<T>{
	Node<T> postNode=null;
	boolean isFirst = true; //标志判断 
}