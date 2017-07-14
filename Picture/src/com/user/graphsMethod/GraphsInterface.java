package com.user.graphsMethod;

/**
 * @author user
 *图的各种算法
 */

public interface GraphsInterface {
	
	/**
	 * 邻接矩阵非递归遍历 深度优先
	 * 
	 * @param graph
	 */
	public void DFSNotRecursion(GraphMatrix graph, int veritx);

	/**
	 * 邻接矩阵的递归遍历 深度优先
	 * 
	 * @param graph
	 */
	public void DFS(GraphMatrix graph, int veritx);

	/**
	 * 邻接矩阵非递归遍历 广度优先
	 * 
	 * @param graph
	 */
	public void BFSNotRecursion(GraphMatrix graph, int veritx);

	/**
	 * 邻接表非递归遍历 深度优先
	 * 
	 * @param graph
	 */
	public void DFSNotRecursion(GraphList graph, int veritx);

	/**
	 * 邻接表递归遍历 深度优先
	 * 
	 * @param graph
	 */
	public void DFS(GraphList graph, int veritx);

	/**
	 * 邻接表递归遍历 广度优先
	 * 
	 * @param graph
	 */
	public void BFS(GraphList graph, int veritx);
}
