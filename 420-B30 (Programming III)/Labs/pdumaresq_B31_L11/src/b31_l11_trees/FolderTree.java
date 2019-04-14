package b31_l11_trees;

import gray.adts.binarytree.BinaryTree;
import gray.adts.binarytree.BinaryTreeNode;
import gray.adts.binarytree.LinkedBinaryTree;
import gray.adts.binarytree.Visitor;

public class FolderTree {
	BinaryTree<String> tree;
	@SuppressWarnings("unchecked")
	Visitor<String> visitor = new FolderTreeVisitor<String>();
	
	public FolderTree() {
		tree = new LinkedBinaryTree<String>("Home");
	}
	
	public void createTree() {
		BinaryTreeNode<String> prog = tree.makeLeftChild(tree.root(), "420-B31");
		tree.makeLeftChild(prog, "Assignments");
		BinaryTreeNode<String> labs = tree.makeRightChild(prog, "Labs");
		tree.makeRightChild(labs, "pdumaresq_B31_L11");
		
		BinaryTreeNode<String> db = tree.makeRightChild(tree.root(), "420-D10");
		BinaryTreeNode<String> blah = tree.makeLeftChild(db, "Assignments");
		tree.makeRightChild(db, "Labs");
		
		System.out.print(blah.leftChild().element().toString());
	}
	
	public void listDirectories() {
		tree.preOrderTraversal(visitor);
	}
	
	public static void main(String[] args) {
		FolderTree t = new FolderTree();
		t.createTree();
		t.listDirectories();
	}

}
