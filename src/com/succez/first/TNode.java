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
	 * 根据层次遍历的顺序，获得二叉树第n层节点的所有节点集合
	 * 
	 * @param root
	 *            二叉树的根节点
	 * @param n
	 *            层数
	 * @param nodes
	 *            存放节点信息的集合
	 * @return 第n层的所有节点
	 */
	public static List<TNode> getNodesByTreeLevel(TNode root, int n,
			List<TNode> nodes) {
		if (root == null) {
			throw new NullPointerException("请不要输入一颗空树");
		}
		if (n == 1) {
			nodes.add(root);
		} else {
			if (root.left != null) {
				getNodesByTreeLevel(root.left, n - 1, nodes);
			}
			if (root.right != null) {
				getNodesByTreeLevel(root.right, n - 1, nodes);
			}
		}
		return nodes;
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