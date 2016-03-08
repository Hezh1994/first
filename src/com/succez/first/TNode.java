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
	 * 传入一个包装有树的根节点的集合，以及需要查找的层数n， 返回包含指定层数所有节点的ArrayList集合
	 * 
	 * @param nodes
	 *            包装树的根节点的List集合
	 * @param n
	 *            层数
	 * @param temp
	 *            临时的List集合
	 * @return 第n层所有节点的值
	 */
	public static List<TNode> getNodesByTreeLevel(List<TNode> nodes, int n,
			List<TNode> temp) {
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
		return getNodesByTreeLevel(temp, n - 1, nodes);
	}

	/**
	 * 先序遍历二叉树，将节点信息保存到指定集合中并返回
	 * 
	 * @param root
	 *            二叉树的根节点
	 * @param list
	 *            用来保存节点信息的集合
	 * @return 包含二叉树所有节点信息的集合
	 */
	public static ArrayList<TNode> preorder(TNode root, ArrayList<TNode> list) {
		if (root != null) {
			list.add(root);
			preorder(root.left, list);
			preorder(root.right, list);
		}
		return list;
	}

	/**
	 * 中序遍历二叉树，将节点信息保存到指定集合中并返回
	 * 
	 * @param root
	 *            二叉树的根节点
	 * @param list
	 *            用来保存节点信息的集合
	 * @return 包含二叉树所有节点信息的集合
	 */
	public static ArrayList<TNode> inorder(TNode root, ArrayList<TNode> list) {
		if (root != null) {
			inorder(root.left, list);
			list.add(root);
			inorder(root.right, list);
		}
		return list;
	}

	/**
	 * 后序遍历二叉树，将节点信息保存到指定集合中并返回
	 * 
	 * @param root
	 *            二叉树的根节点
	 * @param list
	 *            用来保存节点信息的集合
	 * @return 包含二叉树所有节点信息的集合
	 */
	public static ArrayList<TNode> postorder(TNode root, ArrayList<TNode> list) {
		if (root != null) {
			postorder(root.left, list);
			postorder(root.right, list);
			list.add(root);
		}
		return list;
	}
}