package com.succez.first;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTNode {
	// private String s;
	// private int i;
	// private TNode root;
	//
	// public TestTNode(String s) {
	// this.s = s;
	// i = -1;
	// creatTree(root);
	// }
	//
	// private void creatTree(TNode node) {
	// do {
	// i++;
	// String value = String.valueOf(s.charAt(i));
	// if ("#".equals(value)) {
	// node = null;
	// } else {
	// node = new TNode(value);
	// creatTree(node.left);
	// creatTree(node.right);
	// }
	// } while (i < s.length());
	// }

	@Test
	public void test() {
		TNode rootNull = null;
		TNode root = new TNode("A");
		TNode nodeB = new TNode("B");
		TNode nodeC = new TNode("C");
		TNode nodeD = new TNode("D");
		TNode nodeE = new TNode("E");
		TNode nodeF = new TNode("F");

		root.left = nodeB;
		root.right = nodeC;
		nodeB.left = nodeE;
		nodeC.left = nodeD;
		nodeC.right = nodeF;

		try {
			assertEquals("A", TNode.TreeLevel(root, 1));
			assertEquals("B-C", TNode.TreeLevel(root, 2));
			assertEquals("E-D-F", TNode.TreeLevel(root,3));
			assertEquals("A", TNode.TreeLevel(rootNull, 1));
			assertEquals("E-D-F", TNode.TreeLevel(root,-1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("请不要输入一个空树", e.getMessage());
			assertEquals("请输入正确的层数:0~最大层数", e.getMessage());
		}

	}
}
