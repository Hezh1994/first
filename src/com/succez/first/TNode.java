package com.succez.first;

import java.util.ArrayList;
import java.util.List;

public class TNode {
	private String value;
	private TNode left, right;
	private StringBuffer preStringBuffer;
	private StringBuffer inPreStringBuffer;
	private StringBuffer postStringBuffer;

	public TNode() {
	}

	public TNode(String value) {
		super();
		this.value = value;
		this.left = null;
		this.right = null;
		this.preStringBuffer = new StringBuffer();
		this.inPreStringBuffer = new StringBuffer();
		this.postStringBuffer = new StringBuffer();
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
	public static String TreeLevel(TNode tree, int n)
			throws NullPointerException, WrongLevelException {
		if (tree == null) {
			throw new NullPointerException("�벻Ҫ����һ������");
		}
		if (n <= 0) {
			throw new WrongLevelException("��������ȷ�Ĳ���:0~������");
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
	 * �������
	 * 
	 * @param root
	 */
	public String PreOrder(TNode root) {
		if (root != null) {
			preStringBuffer.append(root.getValue());
			PreOrder(root.left);
			PreOrder(root.right);
		}
		return preStringBuffer.toString();
	}

	/**
	 * �������
	 * 
	 * @param root
	 */
	public String InOrder(TNode root) {
		if (root != null) {
			InOrder(root.left);
			inPreStringBuffer.append(root.getValue());
			InOrder(root.right);
		}
		return inPreStringBuffer.toString();
	}

	/**
	 * �������
	 * 
	 * @param root
	 */
	public String PostOrder(TNode root) {
		if (root != null) {
			PostOrder(root.left);
			PostOrder(root.right);
			postStringBuffer.append(root.getValue());
		}
		return postStringBuffer.toString();
	}
}