package com.succez.first;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestTNode {

	@Test(expected = Exception.class)
	public void test() throws Exception {
		/**
		 * <pre>
		 *         A
		 *        / \
		 *       B   C
		 *      /   / \
		 *     E   D   f
		 * </pre>
		 */
		TNode nodeA = new TNode("A");
		TNode nodeB = new TNode("B");
		TNode nodeC = new TNode("C");
		TNode nodeD = new TNode("D");
		TNode nodeE = new TNode("E");
		TNode nodeF = new TNode("F");

		nodeA.setLeft(nodeB);
		nodeA.setRight(nodeC);
		nodeB.setLeft(nodeE);
		nodeC.setLeft(nodeD);
		nodeC.setRight(nodeF);

		TNode root = null;
		assertEquals("A", TNode.TreeLevel(nodeA, 1));
		assertEquals("B-C", TNode.TreeLevel(nodeA, 2));
		assertEquals("E-D-F", TNode.TreeLevel(nodeA, 3));
		assertEquals("E-D-F", TNode.TreeLevel(nodeA, -1));
		assertEquals("A", TNode.TreeLevel(root, 1));
	}
}
