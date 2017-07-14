package com.user.huffhanTree;


/**
 * 使用数组模拟huffmantree，huffmantree是每个节点都包含了根左右节点的树，所以可以使用顺序存储结构，即数组
 * huffman树的有效节点为叶只节点
 * huffman树的节点有(2*leafNum－1)个
 * @author user
 *
 */

public class HuffmanTree {

	/**
	 * 初始化节点下标值，控制判断条件
	 * @param huffmanNodes
	 * @param leafNum
	 */
	public void init(HuffmanNode[] huffmanNodes,int leafNum){
		
		for(int i=0;i<leafNum;i++){ 
			
			huffmanNodes[i].leftNode=-1;
			huffmanNodes[i].weight=-1;
			huffmanNodes[i].rightNode=-1;
			huffmanNodes[i].parentNode=-1;
		}
		
	}
	
	
	/**
	 * 初始化huffmantree，分配权值
	 * leafNum 叶子节点树目
	 */
	public void createValue(HuffmanNode[] huffmanTrees,int leafNum,int[] weight){
		
		if(leafNum==0||weight.length==0||huffmanTrees.length==0){
			return;
		}else {
			//初始化权值
			for(int i=0;i<leafNum;i++){
				
				huffmanTrees[i].weight = weight[i];
				
			}
		}
	}
	
	
	/**
	 * 寻找叶子节点中最小的两个节点
	 * 保存下标为flag1,flag2
	 * 只能判断权重不为0的节点，或0在头
	 */
	public void selectNode(HuffmanNode[] huffmanNodes, int flag1, int flag2, int n) {

		int min1 = 3306;
		int min2 = 3306;
		flag1 = flag2 = -1;

		for (int i = 0; i < n; i++) {

			if (huffmanNodes[i].parentNode == -1) { // 控制节点不重复读取叶子节点，即制度取叶子节点，不是叶子节点不用合成节点

				if (huffmanNodes[i].weight < min1) {
					min2 = min1; // 控制第二个if条件，保证可以取到两个下标,交换最小值
					flag2 = flag1; // 保证flag2在右节点
					min1 = huffmanNodes[i].weight;
					flag1 = i;
				}

				 if (huffmanNodes[i].weight < min2) {

					min2 = huffmanNodes[i].weight;
					flag2 = i;
				}
			}
		}
	}

	/**
	 * 创建huffman树使用数组，因此操作的是下标
	 * 
	 * @param huffmanNodes
	 * @param leafNum
	 */

	public void createHuffman(HuffmanNode[] huffmanNodes, int leafNum) {

		for (int i = leafNum; i < 2 * leafNum - 1; i++) { // 新的节点合成次数
			int flag1 = -1;
			int flag2 = -1;
			selectNode(huffmanNodes, flag1, flag2, leafNum + i);

			huffmanNodes[flag1].parentNode = i; // 父节点下标
			huffmanNodes[flag2].parentNode = i; // 父节点下标
			huffmanNodes[i].weight = huffmanNodes[flag1].weight + huffmanNodes[flag2].weight; // 新节点的权重，重新放入huffmanNodes[]数组,下标为i
			huffmanNodes[i].leftNode = flag1; // 左孩子下标
			huffmanNodes[i].rightNode = flag2; // 右孩子下标
		}

	}
	
	public void huffmanCode(HuffmanNode[] huffmanNodes,HuffmanCode[] HC,int leafNum){  //HuffmanCode[]存储编码
		
		int a,p; //下标
		HuffmanCode huffmanCode = new HuffmanCode(); //临时存放节点
		for(int i=0;i<leafNum;i++){  //多少个叶子节点就要循环多少次  
			
			huffmanCode.start = leafNum;  //存放编码的初始大小
			a=i;  //开始节点
			p = huffmanNodes[i].parentNode; //是否为根节点，等于－1则为跟节点，停住循环
			while(p!=-1){
				if(huffmanNodes[p].leftNode==a){  //当前节点左孩子下标是否相等
					
					huffmanCode.code[huffmanCode.start--]='0';
				}else{
					huffmanCode.code[huffmanCode.start--]='1';
					
				}
				
				a = p; //更换左孩子节点的下标
				p = huffmanNodes[p].parentNode; //下一个父节点的下标
				
			}
			huffmanCode.start++; 
			HC[i] =huffmanCode; //存放当前的编码
			
		}
		
	}
}


/**
 *每一个节点的huffman值 
 */
class HuffmanCode{
	int start;
	char[] code;
}


/**
huffmanTree节点
*/
class HuffmanNode{
	
	int leftNode;  //下标
	int rightNode; //下标
	int parentNode;//下标
	int weight;
	
	
}