package com.user.graphsMethod;

/**
 * 图
 */
public class GraphList{
	Vertexs[] vertexs; //边表
	int edgesNum; //边数
	int vertexsNum; //顶点数
}

 /**
 *节点
 * @author user
 */
class EdgesNode{
	int vertexsNo ;//指向节点的编号
	EdgesNode nextNode;//下一个节点
	int weight ;   //权值
}

/**
 * @author user
 *顶点
 */
class Vertexs{
	Object data; //顶点信息
	int on;   //当前顶点编号
	EdgesNode fistNode; //边表指向第一个节点
}


