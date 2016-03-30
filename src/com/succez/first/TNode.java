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
	 * ���ݲ�α�����˳�򣬻�ö�������n��ڵ�����нڵ㼯��
	 * 
	 * @param root
	 *            �������ĸ��ڵ�
	 * @param n
	 *            ����
	 * @param nodes
	 *            ��Žڵ���Ϣ�ļ���
	 * @return ��n������нڵ�
	 */
	public static List<TNode> getNodesByTreeLevel(TNode root, int n,
			List<TNode> nodes) {
		if (root == null) {
			throw new NullPointerException("�벻Ҫ����һ�ſ���");
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
	 * ������������������ڵ���Ϣ���浽ָ�������в�����
	 * 
	 * @param root
	 *            �������ĸ��ڵ�
	 * @param list
	 *            ��������ڵ���Ϣ�ļ���
	 * @return �������������нڵ���Ϣ�ļ���
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
	 * ������������������ڵ���Ϣ���浽ָ�������в�����
	 * 
	 * @param root
	 *            �������ĸ��ڵ�
	 * @param list
	 *            ��������ڵ���Ϣ�ļ���
	 * @return �������������нڵ���Ϣ�ļ���
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
	 * ������������������ڵ���Ϣ���浽ָ�������в�����
	 * 
	 * @param root
	 *            �������ĸ��ڵ�
	 * @param list
	 *            ��������ڵ���Ϣ�ļ���
	 * @return �������������нڵ���Ϣ�ļ���
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