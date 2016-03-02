package com.succez.first;

import java.util.ArrayList;
import java.util.List;

public class TNode {
	private String value;
	private TNode left, right;

	public TNode(String value) {
		super();
		this.value = value;
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
	 * 
	 * @param nodes
	 *            ��Ÿ��ڵ��List
	 * @param n
	 *            ����
	 * @return ����һ��ArrayLise���ϣ������д�ŵ�n���е����нڵ�
	 * 
	 *         ���õݹ�ķ���������ǰ�����List�����е����к��ӽڵ��ŵ�temp�����У��ٽ�temp��Ϊ���� ���룬ͬʱn-1
	 *         n=1Ϊ�ݹ���ڣ����ص�ǰ����ļ��ϡ�
	 */
	public static List<TNode> TreeLevel(List<TNode> nodes, int n) {
		if (nodes == null || nodes.size() == 0) {
			return null;
		}
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
		return TreeLevel(temp, n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ������������
		TNode root = new TNode("A");

		TNode nodeB = new TNode("B");

		TNode nodeD = new TNode("D");

		TNode nodeG = new TNode("G");

		TNode nodeH = new TNode("H");

		TNode nodeC = new TNode("C");

		TNode nodeF = new TNode("F");


		root.setLeft(nodeB);
		root.setRight(nodeD);

		nodeB.setLeft(nodeG);
		nodeB.setRight(nodeH);

		nodeD.setLeft(nodeC);
		nodeD.setRight(nodeF);

		List<TNode> nodes = new ArrayList<TNode>();
		nodes.add(root);
		ArrayList<TNode> result = (ArrayList<TNode>) TreeLevel(nodes, 3);

		// ��ӡ���ص�ArrayList
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).getValue());
			if (i < result.size() - 1)
				System.out.print("-");
		}
	}
}