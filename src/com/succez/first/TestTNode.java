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

	/**
	 * �������ĸ��ڵ��ѯָ������n�����нڵ��ֵ���������һ���ַ����磺A-B-C
	 * 
	 * @param tree
	 *            ���ĸ��ڵ�
	 * @param n
	 *            Ҫ��ѯ�Ĳ���
	 * @return ��n�����нڵ��ֵ����˳������ң���ʽ�磺A-B-C��
	 * @throws NullPointerException
	 *             ,WrongLevelException
	 */
	public static String getNodesValue(TNode tree, int n)
			throws NullPointerException, WrongLevelException {
		if (tree == null) {
			throw new NullPointerException("�벻Ҫ����һ������");
		}
		if (n <= 0) {
			throw new WrongLevelException("��������ȷ�Ĳ���:0~������");
		}
		List<TNode> nodes = new ArrayList<TNode>();
		ArrayList<TNode> result = (ArrayList<TNode>) TNode.getNodesByTreeLevel(
				tree, n, nodes);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i).getValue());
			if (i < result.size() - 1)
				sb.append('-');
		}
		return sb.toString();
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
		assertEquals("A-B-E-C-D-F", printList(TNode.preorder(nodeA, list)));// �������
		list.removeAll(list);
		assertEquals("E-B-A-D-C-F", printList(TNode.inorder(nodeA, list)));// �������
		list.removeAll(list);
		assertEquals("E-B-D-F-C-A", printList(TNode.postorder(nodeA, list)));// �������

		assertEquals("A", getNodesValue(nodeA, 1));
		assertEquals("B-C", getNodesValue(nodeA, 2));
		assertEquals("E-D-F", getNodesValue(nodeA, 3));

		expectedEx.expect(WrongLevelException.class);
		expectedEx.expectMessage("��������ȷ�Ĳ���:0~������");
		getNodesValue(nodeA, -1);

		expectedEx.expect(NullPointerException.class);
		expectedEx.expectMessage("�벻Ҫ����һ������");
		TNode nodeB = null;
		getNodesValue(nodeB, 1);
	}
}
