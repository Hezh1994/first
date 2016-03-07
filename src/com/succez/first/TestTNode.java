package com.succez.first;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestTNode {
	/**
	 * 将一串正确的括号表示法表示的二叉树字符串转换为树，并返回根节点. 如："A(B(D,),C(E,F))",表示的树为
	 * 
	 * <pre>
	 *         A
	 *        / \
	 *       B   C
	 *      /   / \
	 *     E   D   f
	 * </pre>
	 * 
	 * @param 正确的括号表示法表示的二叉树字符串
	 * @return 二叉树的根节点
	 */
	public TNode creatTree(String s) {
		Stack<TNode> nodeStack = new Stack<TNode>();
		TNode root = null;
		TNode p = null;
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
				nodeStack.push(p);
				k = 1;
				break;

			case ',':
				k = 2;
				break;

			case ')':
				nodeStack.pop();
				break;

			default:
				p = new TNode(String.valueOf(c));
				if (root == null) {
					root = p;
				} else {
					if (k == 1) {
						nodeStack.peek().setLeft(p);
					} else if (k == 2) {
						nodeStack.peek().setRight(p);
					}
				}
				break;
			}
		}
		return root;
	}

	public String printList(List<TNode> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).getValue());
			if (i < list.size() - 1)
				sb.append('-');
		}
		return sb.toString();
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void test() throws Exception {
		/**
		 * <pre>
		 *         A
		 *        / \
		 *       B   C
		 *      /   / \
		 *     E   D   F
		 * </pre>
		 */

		TNode nodeA = creatTree("A(B(E,),C(D,F))");
		ArrayList<TNode> list = new ArrayList<TNode>();
		assertEquals("A-B-E-C-D-F", printList(TNode.preorder(nodeA, list)));// 先序遍历
		list.removeAll(list);
		assertEquals("E-B-A-D-C-F", printList(TNode.inorder(nodeA, list)));// 中序遍历
		list.removeAll(list);
		assertEquals("E-B-D-F-C-A", printList(TNode.postorder(nodeA, list)));// 后序遍历

		assertEquals("A", TNode.TreeLevel(nodeA, 1));
		assertEquals("B-C", TNode.TreeLevel(nodeA, 2));
		assertEquals("E-D-F", TNode.TreeLevel(nodeA, 3));

		expectedEx.expect(WrongLevelException.class);
		expectedEx.expectMessage("请输入正确的层数:0~最大层数");
		TNode.TreeLevel(nodeA, -1);

		expectedEx.expect(NullPointerException.class);
		expectedEx.expectMessage("请不要输入一个空树");
		TNode nodeB = null;
		TNode.TreeLevel(nodeB, 1);
	}
}
