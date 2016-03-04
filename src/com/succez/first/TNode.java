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
	 * ����һ����װ�����ĸ��ڵ�ļ��ϣ��Լ���Ҫ���ҵĲ���n�����ذ���ָ���������нڵ��ArrayList����
	 * 
	 * @param nodes
	 *            ��װ���ĸ��ڵ��List����
	 * @param n
	 *            ����
	 * @return ��n�����нڵ��ֵ����˳������ң���ʽ�磺A-B-C��
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
	 * �������ĸ��ڵ��ѯָ������n�����нڵ��ֵ���������һ���ַ����磺A-B-C
	 * 
	 * @param tree
	 *            ���ĸ��ڵ�
	 * @param n
	 *            Ҫ��ѯ�Ĳ���
	 * @return ָ������n���нڵ��ֵ
	 * @throws Exception
	 */
	public static String TreeLevel(TNode tree, int n) throws Exception {
		if (tree == null) {
			throw new Exception("�벻Ҫ����һ������");
		}
		if (n <= 0) {
			throw new Exception("��������ȷ�Ĳ���:0~������");
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
	 * ǰ�����
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
	 * �������
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
	 * �������
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