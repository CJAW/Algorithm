package com.user.binanyTree;

/**
 * 
 * @author user
 *树的接口实现
 * @param <T>
 */

public interface BinanyTree<T> {

	/**
	 * 创建二叉树非递归
	 */
	Node creadeBainyTreeNoRecursion(T[] elemet);
	
	/**
	 * 判空
	 */
	boolean isEmpty(Node<T> tree);
	/**
	 * 父亲节点
	 * @return
	 */
	boolean parent(Node<T> tree,T x);
	
	/**
	 * 前序遍历
	 */
	void preOrder(Node node);
	/**
	 * 中序遍历
	 */
	void inOrder(Node node);
	/**
	 * 后序遍历
	 */
	void postOrder(Node node);
	/**
	 * 层次遍历
	 */
	void levelOrder(Node node);
}
