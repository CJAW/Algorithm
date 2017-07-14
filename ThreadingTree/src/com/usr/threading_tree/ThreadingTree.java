package com.usr.threading_tree;

import java.util.Scanner;

/**
 *对二叉树进行线索化
 *增加flag判断前驱和后继。 
 * @author user
 * @param <T>
 *
 */

public class ThreadingTree<T> {
	Scanner scanner = new Scanner(System.in);
	final int Thread = 1; //标志指向前驱或后继
	final int Link = 0; //标志指向左孩子或右孩子
	
	//创建二叉树
	public ThreadingNode<T> creatBinaryTreeByPreOrder(){
		System.out.println("输入信息");
		String  string = scanner.nextLine();
		char ch = string.charAt(0);
		ThreadingNode<T> root =null;
		if(ch =='#'){
			return root = null;
		}else {
			root = new ThreadingNode<T>(); //创建根节点,及节点
			root.date = (T)string; 
			root.leftChild = creatBinaryTreeByPreOrder();
			root.rightChild = creatBinaryTreeByPreOrder();
		}
		return root;  //返回根节点
	}
	 
	
	ThreadingNode<T> preNode; // 前驱节点,新加的节点也要完成线索化（即有前驱和后继）
	//对二叉树进行线索化(创建线索二叉树),以中序线索化
	public ThreadingNode<T> createThreadingTree(ThreadingNode<T> tree){
		ThreadingNode<T> root = new ThreadingNode<T>(); //创建一个头节点(前驱)，使线索二叉树闭合成一个环
		root.leftFlag = Link;
		root.rightFlag = Thread; //线索
		root.rightChild = tree; 
		if(tree==null){
			root.leftChild = root;
		}else {
			root.leftChild = tree;
			preNode = root; // 更改前驱节点
			
			inOrderThreadingTree(tree); // 中序线索
			
			// 链接头节点形成环
			preNode.rightChild = root; // 最后一个右子树的节点的后继指向头节点root
			preNode.rightFlag = Thread;
			root.rightChild = preNode;// 头节点root的后继指向前驱节点，左后一个右子树节点
		}
		
		return root;
	}
	
	
	// 中序遍历线索化二叉树，空指针需要线索，其他不需要
	public void inOrderThreadingTree(ThreadingNode<T> tree) {

		if (tree == null) {
			return;
		}else {
			// 左子树
			inOrderThreadingTree(tree.leftChild);
			if (tree.leftChild == null) { //当前最左节点为空
				tree.leftChild = preNode; //指向前驱
				tree.leftFlag = Thread; // 表示指向前驱标志
			} else {
				tree.leftFlag = Link;
			}
			// 对前驱节点的后继线索化
			if (preNode.rightChild == null) {//当前右节点为空
				preNode.rightChild = tree;//指向后继
				preNode.rightFlag = Thread; // 后继标志
			} else {
				tree.rightFlag = Link;
			}
			preNode = tree;// 更改前驱节点
			//右子树
			inOrderThreadingTree(tree.rightChild);	
		}
		
	}
	
	//中序遍历线索二叉树，中序（左根右）
	public void inOrderTree(ThreadingNode<T> tree){
		ThreadingNode<T> curr = tree.leftChild;//获取根节点
		
		while(curr!=tree){
			//左子树
			while(curr.leftFlag==Link){ //从根节点到最左节点
				curr = curr.leftChild;	
			}
			System.out.print(curr.date); //中序打印第一个节点
			
			while(curr.rightFlag==Thread&&curr.rightChild!=tree){  //当前节点是否含有后继，即返回根节点
				curr = curr.rightChild;
				System.out.print(curr.date);
			}
			curr = curr.rightChild; //进入右节点
			
		}
	}
	
	
	
	
	//对二叉树进行线索化(创建线索二叉树),以前序线索化
	public ThreadingNode<T> createPreThreadingTree(ThreadingNode<T> tree) {
		ThreadingNode<T> root = new ThreadingNode<T>(); // 创建一个头节点(前驱)，使线索二叉树闭合成一个环
		root.leftFlag = Link;
		root.rightFlag = Thread; // 线索
		root.rightChild = root;
		if (tree == null) {
			root.leftChild = root;
		} else {
			root.leftChild = tree;
			preNode = root; // 更改前驱节点

			preOrderThreadingTree(tree); // 中序线索

			// 链接头节点形成环
			preNode.rightChild = root; // 最后一个右子树的节点的后继指向头节点root
			preNode.rightFlag = Thread;
			root.rightChild = preNode;// 头节点root的后继指向前驱节点，左后一个右子树节点
		}

		return root;
	}
		
		
		// 前序遍历线索化二叉树，空指针需要线索，其他不需要
		public void preOrderThreadingTree(ThreadingNode<T> tree) {

			if (tree == null) {
				return;
			}else {
				if (tree.leftChild == null) { //当前最左节点为空
					tree.leftChild = preNode; //指向前驱
					tree.leftFlag = Thread; // 表示指向前驱标志
				} else {
					tree.leftFlag = Link;
				}
				// 对前驱节点的后继线索化
				if (preNode.rightChild == null) {//当前右节点为空
					preNode.rightChild = tree;//指向后继
					preNode.rightFlag = Thread; // 后继标志
				} else {
					tree.rightFlag = Link;
				}
				preNode = tree;// 更改前驱节点
				// 左子树
				if(tree.leftFlag==Link){
					preOrderThreadingTree(tree.leftChild);
				}
				
				//右子树
				if(tree.rightFlag==Link){
					preOrderThreadingTree(tree.rightChild);	
				}
			
			}	
		}
		
		
	//前序遍历线索二叉树
		public void preOrderTree(ThreadingNode<T> tree){
			 //tree为头节点，无任何值，从根节点开始，会到头节点结束
		     //获取根节点
			ThreadingNode<T> currNode = tree.leftChild;
			while(currNode!=tree){
				
				System.out.print(currNode.date);
				if(currNode.leftFlag==Link){
					currNode = currNode.leftChild;
				}else {
					currNode = currNode.rightChild;
				}
				
			}
			
		}
		
		
	public static void main(String[] args){
		
		ThreadingTree<Object> threadingTree = new ThreadingTree<Object>();
		//"A","B","C","#","#","D","E","#","G","#","#","F","#","#","#"
		ThreadingNode tree = threadingTree.creatBinaryTreeByPreOrder();
		
		threadingTree.preOrderTree(threadingTree.createPreThreadingTree(tree));
	}

}




/**
 * 节点
 * @author user
 *
 * @param <T>
 */
class ThreadingNode<T>{

	T date;
    ThreadingNode<T> leftChild;
    ThreadingNode<T> rightChild;
    int leftFlag;
    int rightFlag;
    
}