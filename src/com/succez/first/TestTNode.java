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

	/**
	 * 根据树的根节点查询指定层数n的所有节点的值，结果返回一个字符串如：A-B-C
	 * 
	 * @param tree
	 *            树的根节点
	 * @param n
	 *            要查询的层数
	 * @return 第n层所有节点的值，且顺序从左到右，格式如：A-B-C。
	 * @throws NullPointerException
	 *             ,WrongLevelException
	 */
	public static String getNodesValue(TNode tree, int n)
			throws NullPointerException, WrongLevelException {
		if (tree == null) {
			throw new NullPointerException("请不要输入一个空树");
		}
		if (n <= 0) {
			throw new WrongLevelException("请输入正确的层数:0~最大层数");
		}
		List<TNode> nodes = new ArrayList<TNode>();
		List<TNode> temp = new ArrayList<TNode>();
		nodes.add(tree);
		ArrayList<TNode> result = (ArrayList<TNode>) TNode.getNodesByTreeLevel(
				nodes, n, temp);
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
		assertEquals("A-B-E-C-D-F", printList(TNode.preorder(nodeA, list)));// 先序遍历
		list.removeAll(list);
		assertEquals("E-B-A-D-C-F", printList(TNode.inorder(nodeA, list)));// 中序遍历
		list.removeAll(list);
		assertEquals("E-B-D-F-C-A", printList(TNode.postorder(nodeA, list)));// 后序遍历

		assertEquals("A", getNodesValue(nodeA, 1));
		assertEquals("B-C", getNodesValue(nodeA, 2));
		assertEquals("E-D-F", getNodesValue(nodeA, 3));

		expectedEx.expect(WrongLevelException.class);
		expectedEx.expectMessage("请输入正确的层数:0~最大层数");
		getNodesValue(nodeA, -1);

		expectedEx.expect(NullPointerException.class);
		expectedEx.expectMessage("请不要输入一个空树");
		TNode nodeB = null;
		getNodesValue(nodeB, 1);
	}
}
