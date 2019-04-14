package b31_l11_trees;

import gray.adts.binarytree.BinaryTreeNode;
import gray.adts.binarytree.Visitor;

@SuppressWarnings("rawtypes")
public class FolderTreeVisitor<E> implements Visitor {
	
	public FolderTreeVisitor() { }
	
	@Override
	public void visit(BinaryTreeNode node) {
		System.out.println(node.element().toString());		
	}

}
