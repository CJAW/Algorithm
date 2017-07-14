package com.user.AdjacencyMatrix;

import java.util.Scanner;

/**
 * 邻接矩阵
 * 使用一维数组存储顶点信息
 * 使用二维数组存储信息
 * 无向图
 * 适合存储边数较多的图
 * @author user
 *
 */

public class AdjacencyMatrix {

	int Max_Value = 10; //最大值
	
	//创建邻接矩阵无向图
	public void createAdjacenyMatrix(Graph graph){
		
		init(graph);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入边数");
		int edgesNum = scanner.nextInt(); //输入的边数
		System.out.println("输入顶点数");
		int vertexsNum = scanner.nextInt();//输入的顶点数
		
		//设置顶点编号
		for(int i=0;i<vertexsNum;i++){
			graph.vertexs[i].no = i;
			graph.vertexsNum++;
		}
		
		//输入边的两个顶点，以及边数
		//设置顶点的链接的边，有链接的设为1(根据顶点的编号确定下标)，没有链接的设为0
		for(int i=0;i<edgesNum;i++){
			System.out.println("输入两个顶点的编号");
			int j = scanner.nextInt();
			int k = scanner.nextInt();
			if(j>=vertexsNum||k>=vertexsNum){
				System.out.println("错误");
				i = i-1;
				continue;
			}else {
				graph.edges[j][k] = 1;
				//无向的图对称
				graph.edges[k][j] = 1;
				graph.edgesNum++;
			}
		}
		
	
		scanner.close();
	}
	
	// 创建邻接矩阵无向图带全
		public void createAdjacenyMatrixHaveWeight(Graph graph) {

			init(graph);

			Scanner scanner = new Scanner(System.in);
			System.out.println("输入边数");
			int edgesNum = scanner.nextInt(); // 输入的边数
			System.out.println("输入顶点数");
			int vertexsNum = scanner.nextInt();// 输入的顶点数

			// 设置顶点编号
			for (int i = 0; i < vertexsNum; i++) {
				graph.vertexs[i].no = i;
				graph.vertexsNum++;
			}

			// 输入边的两个顶点，以及边数
			// 设置顶点的链接的边，有链接的设为1(根据顶点的编号确定下标)，没有链接的设为0
			for (int i = 0; i < edgesNum; i++) {
				System.out.println("输入两个顶点的编号，权值");
				int j = scanner.nextInt();
				int k = scanner.nextInt();
				int weight = scanner.nextInt();
				if (j >= vertexsNum || k >= vertexsNum) {
					System.out.println("错误");
					i = i - 1;
					continue;
				} else {
					graph.edges[j][k] = weight;
					//无向图对称
					graph.edges[k][j] = weight;
					graph.edgesNum++;
				}
			}

			scanner.close();
		}
		
	
	// 创建邻接矩阵有向图
	public void createAdjacenyMatrixDirected(Graph graph) {

		init(graph);

		Scanner scanner = new Scanner(System.in);
		System.out.println("输入边数");
		int edgesNum = scanner.nextInt(); // 输入的边数
		System.out.println("输入顶点数");
		int vertexsNum = scanner.nextInt();// 输入的顶点数

		// 设置顶点编号
		for (int i = 0; i < vertexsNum; i++) {
			graph.vertexs[i].no = i;
			graph.vertexsNum++;
		}

		// 输入边的两个顶点，以及边数
		// 设置顶点的链接的边，有链接的设为1(根据顶点的编号确定下标)，没有链接的设为0
		for (int i = 0; i < edgesNum; i++) {
			System.out.println("输入两个顶点的编号");
			int j = scanner.nextInt();
			int k = scanner.nextInt();
			if (j >= vertexsNum || k >= vertexsNum) {
				System.out.println("错误");
				i = i - 1;
				continue;
			} else {
				graph.edges[j][k] = 1;
				graph.edgesNum++;
			}
		}

		scanner.close();
	}
	
	// 创建邻接矩阵有向图带全
	public void createAdjacenyMatrixDirectedHaveWeight(Graph graph) {

		init(graph);

		Scanner scanner = new Scanner(System.in);
		System.out.println("输入边数");
		int edgesNum = scanner.nextInt(); // 输入的边数
		System.out.println("输入顶点数");
		int vertexsNum = scanner.nextInt();// 输入的顶点数

		// 设置顶点编号
		for (int i = 0; i < vertexsNum; i++) {
			graph.vertexs[i].no = i;
			graph.vertexsNum++;
		}

		// 输入边的两个顶点，以及边数
		// 设置顶点的链接的边，有链接的设为1(根据顶点的编号确定下标)，没有链接的设为0
		for (int i = 0; i < edgesNum; i++) {
			System.out.println("输入两个顶点的编号，权值");
			int j = scanner.nextInt();
			int k = scanner.nextInt();
			int weight = scanner.nextInt();
			if (j >= vertexsNum || k >= vertexsNum) {
				System.out.println("错误");
				i = i - 1;
				continue;
			} else {
				graph.edges[j][k] = weight;
				graph.edgesNum++;
			}
		}

		scanner.close();
	}
	
	
	
	//初始化数组
	public void init(Graph graph){
		graph.edges = new int[Max_Value][Max_Value];
		graph.vertexs = new Vertex[Max_Value];
		graph.edgesNum=0;
		graph.vertexsNum=0;
		//初始化顶点
		for(int i=0;i<Max_Value;i++){
			Vertex vertex = new Vertex();
			vertex.no = 0;
			vertex.message="a";
			graph.vertexs[i] = vertex;
		}
			
		//初始化边
		for(int i=0;i<Max_Value;i++){
			
			for(int j=0;j<Max_Value;j++){
				
				graph.edges[i][j] = 0;
			}
		}
	}
	
	
	public static void main(String[] args){
		Graph graph = new Graph();
		AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix();
		adjacencyMatrix.createAdjacenyMatrix(graph);
		
	}
	
}

//图
class Graph{
	
	Vertex[] vertexs;  //定点
	int[][]  edges;    //边
	int edgesNum;//边数
	int vertexsNum;//定点数
	
}

//顶点
class Vertex{
	int no;    //顶点编号
	Object message;  //顶点信息
}