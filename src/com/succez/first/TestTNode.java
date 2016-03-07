package com.succez.first;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestTNode {
	/**
	 * ��һ����ȷ�����ű�ʾ����ʾ�Ķ������ַ���ת��Ϊ���������ظ��ڵ�. �磺"A(B(D,),C(E,F))",��ʾ����Ϊ
	 * 
	 * <pre>
	 *         A
	 *        / \
	 *       B   C
	 *      /   / \
	 *     E   D   f
	 * </pre>
	 * 
	 * @param ��ȷ�����ű�ʾ����ʾ�Ķ������ַ���
	 * @return �������ĸ��ڵ�
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
		expectedEx.expectMessage("��������ȷ�Ĳ���:0~������");
		TNode.TreeLevel(nodeA, -1);
		
		expectedEx.expect(NullPointerException.class);
		expectedEx.expectMessage("�벻Ҫ����һ������");
		TNode nodeB = null;
		TNode.TreeLevel(nodeB, 1);
	}
}
