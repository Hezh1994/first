package com.succez.first;

import static org.junit.Assert.*;

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
