package com.user.graphsMethod;

import com.user.queue.MyLinkQuene;

import com.user.stack.LinkStack;

public class GraphMethodImplement implements GraphsInterface {

	int MAX_Value = 20;
	boolean[] mark; // 判断当前节点是否访问过；

	@Override
	public void DFSNotRecursion(GraphMatrix graph, int veritx) {
		mark = new boolean[MAX_Value];
		LinkStack<Integer> linkStack = new LinkStack<>();
		mark[veritx] = true;
		System.out.print(veritx);
		linkStack.push(veritx);
		while (!linkStack.isEmpty()) {
			int curr = linkStack.pop();
			for (int j = 0; j < graph.vertexsNum; j++) {

				//是否访问过,没有访问过则更换顶点，访问过则继续
				if (graph.edges[curr][j] == 1 && mark[j] == false) {
					//深度遍历1-2，2-3，3-4
					linkStack.push(j);
					System.out.print(curr);
					mark[j] = true;
					break;//停止，更换顶点
				}
			}
		}
	}

	// 深度优先沿着一个顶点，找到该顶点有关的边（即邻接边）
	// 不断地沿着顶点的深度方向遍历。顶点的深度方向是指它的邻接点方向。
	@Override
	public void DFS(GraphMatrix graph, int veritx) {
		mark = new boolean[MAX_Value];
		mark[veritx] = true; // 进行标记
		System.out.print(veritx);// 输出顶点
		for (int i = 0; i < graph.vertexsNum; i++) { // 便利该顶点所有的边

			if (graph.edges[veritx][i] == 1 && mark[i] == false) { // 深度优先需要找到邻接的一条边或多条边才能进行下一个顶点&&当前节点是否遍历过
				DFS(graph, i);//更换顶点继续
			}

		}

	}

	// 广度优先就是按照顶点开始将每一个顶点都访问一边，再按第一次的顺序方问每一个没有被访问的节点
	@Override
	public void BFSNotRecursion(GraphMatrix graph, int veritx) {
		mark = new boolean[MAX_Value];
		// 依靠队列临时存储顶点
		MyLinkQuene<Integer> myQuene = new MyLinkQuene<>();
		mark[veritx] = true;
		System.out.print(veritx);

		myQuene.inser(veritx);

		// 遍历队列里的所有顶点
		while (!myQuene.isEmpty()) {
			// 出队列作为顶点遍历
			int currVeritx = myQuene.remove();

			for (int j = 0; j < graph.vertexsNum; j++) {

				if (graph.edges[currVeritx][j] == 1 && mark[j] == false) {

					myQuene.inser(j);
					System.out.print(j);
					mark[j] = true;
				}
			}
		}
	}
	
	
	@Override
	public void DFSNotRecursion(GraphList graph, int veritx) {
		
		LinkStack<Integer> linkStack = new LinkStack<>();
		mark = new boolean[MAX_Value];
		mark[veritx] = true;
		//顶点边表入栈
		linkStack.push(veritx);
		EdgesNode edgesNode = new EdgesNode();
		while(!linkStack.isEmpty()){

			int curr = linkStack.pop();
			
			edgesNode = graph.vertexs[curr].fistNode;
			
			while(edgesNode!=null){
				//是否访问过,没有访问过则更换顶点，访问过则继续
				if(mark[edgesNode.vertexsNo]==false){
					//深度遍历1-2，2-3，3-4
					linkStack.push(edgesNode.vertexsNo);
					mark[edgesNode.vertexsNo] =true;
				    break;  //停止，更换顶点
				}else {
					//访问过则继续，下一个节点
					edgesNode = edgesNode.nextNode;	
				}
				
			}
		}
		
	}

	@Override
	public void DFS(GraphList graph, int veritx) {
		
		mark = new boolean[MAX_Value];
		//临时节点
		EdgesNode edgesNode = new EdgesNode();
		mark[veritx] = true;
		//边表顶点的第一个节点
		edgesNode = graph.vertexs[veritx].fistNode;
		System.out.print(veritx);
		while(edgesNode!=null){
			//是否访问过,没有访问过则更换顶点，访问过这继续
			if(mark[edgesNode.vertexsNo]==false){
				//深度遍历1-2，2-3，3-4，更换顶点继续访问
				DFS(graph, edgesNode.vertexsNo);
			}
			//下一个节点
			edgesNode = edgesNode.nextNode;
		}
	}

	// 广度优先就是按照顶点开始将每一个顶点都访问一边，再按第一次的顺序方问每一个没有被访问的节点
	@Override
	public void BFS(GraphList graph, int veritx) {
		MyLinkQuene<Integer> linkStack = new MyLinkQuene<Integer>();
		mark = new boolean[MAX_Value];
		mark[veritx] = true;
		//顶点边表入栈
		linkStack.inser(veritx);
		EdgesNode edgesNode = new EdgesNode();
		while(!linkStack.isEmpty()){

			int curr = linkStack.remove();
			
			edgesNode = graph.vertexs[curr].fistNode;//第一个节点
			
			while(edgesNode!=null){
				//是否访问过,没有访问过则进入队列备用，所有点都要访问一遍
				if(mark[edgesNode.vertexsNo]==false){
					//深度遍历1-2，2-3，3-4
					linkStack.inser(edgesNode.vertexsNo);
					mark[edgesNode.vertexsNo] =true;
				}
					//下一个节点
					edgesNode = edgesNode.nextNode;	
			}
		}
		
		
	}

}
