package com.succez.first;

import java.util.ArrayList;
import java.util.List;

public class TNode {
	private String value;
	private TNode left, right;

	public TNode() {
	}

	public TNode(String value) {
		super();
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TNode getLeft() {
		return left;
	}

	public void setLeft(TNode left) {
		this.left = left;
	}

	public TNode getRight() {
		return right;
	}

	public void setRight(TNode right) {
		this.right = right;
	}

	/**
	 * 传入一个包装有树的根节点的集合，以及需要查找的层数n，返回包含指定层数所有节点的ArrayList集合
	 * 
	 * @param nodes
	 *            包装树的根节点的List集合
	 * @param n
	 *            层数
	 * @return 第n层所有节点的值，且顺序从左到右，格式如：A-B-C。
	 */
	private static List<TNode> getNodesByTreeLevel(List<TNode> nodes, int n) {
		List<TNode> temp = new ArrayList<TNode>();
		if (n == 1) {
			return nodes;
		}
		for (TNode node : nodes) {
			if (node.getLeft() != null) {
				temp.add(node.getLeft());
			}
			if (node.getRight() != null) {
				temp.add(node.getRight());
			}
		}
		nodes.removeAll(nodes);
		return getNodesByTreeLevel(temp, n - 1);
	}

	/**
	 * 根据树的根节点查询指定层数n的所有节点的值，结果返回一个字符串如：A-B-C
	 * 
	 * @param tree
	 *            树的根节点
	 * @param n
	 *            要查询的层数
	 * @return 指定层数n所有节点的值
	 * @throws Exception
	 */
	public static String TreeLevel(TNode tree, int n) throws Exception {
		if (tree == null) {
			throw new Exception("请不要输入一个空树");
		}
		if (n <= 0) {
			throw new Exception("请输入正确的层数:0~最大层数");
		}
		List<TNode> nodes = new ArrayList<TNode>();
		nodes.add(tree);
		ArrayList<TNode> result = (ArrayList<TNode>) getNodesByTreeLevel(nodes,
				n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i).getValue());
			if (i < result.size() - 1)
				sb.append('-');
		}
		return sb.toString();
	}

	/**
	 * 前序遍历
	 * 
	 * @param root
	 */
	public void PreOrder(TNode root) {
		if (root != null) {
			System.out.println(root.getValue());
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public void InOrder(TNode root) {
		if (root != null) {
			System.out.println(root.left);
			System.out.println(root.getValue());
			System.out.println(root.right);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public void PostOrder(TNode root) {
		if (root != null) {
			System.out.println(root.left);
			System.out.println(root.right);
			System.out.println(root.getValue());
		}
	}

}