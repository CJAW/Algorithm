package com.user.addTwoNumber;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 您有两个表示两个非负数字的链表。这些数字以相反的顺序存储，每个节点都包含一个数字。添加两个数字，并将其作为链接列表返回。
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 节点满十向前进一为
 * 
 * @author user
 *
 */

public class Solution {
	int nodeValue;
	int topValue;
	// 对节点的值进行遍历
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		//头节点
        ListNode head = new ListNode(0);
        //操作节点
        ListNode listNode = head;
		
		while (l1 != null && l2 != null) {
			nodeValue = l1.val + l2.val + topValue;
			topValue =0;
			if (nodeValue >= 10) {
				topValue = nodeValue / 10;
				nodeValue = nodeValue % 10;
			}
			listNode.next = new ListNode(nodeValue);
			l1 = l1.next;
			l2 = l2.next;
            listNode = listNode.next;
		}
		// 合并节点
		while (l1 != null ) {
				nodeValue = l1.val + topValue;
				topValue=0;
				listNode.next = new ListNode(nodeValue);
				l1 = l1.next;
				listNode = listNode.next;
		}
		while(l2!=null){
				nodeValue = l2.val + topValue;
				topValue=0;
				listNode.next = new ListNode(nodeValue);
				l2 = l2.next;
				listNode = listNode.next;
			}
			
		if (topValue != 0) {
			listNode = new ListNode(topValue);
		    listNode.next = null;	
		}
		return head.next;
	}

	public static void main(String[] args) {

		Solution addListNode = new Solution();
		ListNode l1 = new ListNode(6);
		ListNode l2 = new ListNode(3);
		System.out.println(addListNode.addTwoNumbers(l1, l2).val);
	}

}

/**
 * 
 * 要想使用new 生成一个内部类的实例，需要先指向一个外部类的实例，也就是先生成外部类的实例，因为内部类可以调用外部类的人员成员，
 * 当没有外部类实例的时候也就没有这些成员的内存空间，内部类在实例化的时候，调用外部类的成员就会出错，
 *
 */
// 链表节点

class ListNode {
	int val;// 节点值
	ListNode next; // 下一个节点
	public ListNode(int value) {
		this.val = value;
		next = null;

	}
}















