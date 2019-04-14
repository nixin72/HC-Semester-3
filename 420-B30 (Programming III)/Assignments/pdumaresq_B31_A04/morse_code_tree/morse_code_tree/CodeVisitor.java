package morse_code_tree;

import java.util.ArrayList;
import adts.binarytree.BinaryTreeNode;
import adts.binarytree.Visitor;
import adts.stack.LinkedStack;

@SuppressWarnings("rawtypes")
public class CodeVisitor<E> implements Visitor {
	private String code = "";
	private ArrayList<String> letters = new ArrayList<String>();
	private LinkedStack<String> chars = new LinkedStack<String>();
	
	@Override
	public void visit(BinaryTreeNode node) {		
		if (!node.element().toString().equals("")) {
			if (!letters.contains(node.element().toString())) {
				letters.add(node.element().toString());
			}
			
			BinaryTreeNode parent = node.parent();
			if (parent.leftChild().equals(node)) 
				chars.push(".");
			else 
				chars.push("-");
			visit(parent);
		}	
		else {
			chars.push("\n");
			while (!chars.isEmpty()) {
				code += chars.pop();
			}
		}
	}
	
	public String getCode() {
		return code;
	}
	
	public String[] getLetters() {
		String[] newLetters = new String[26];
		for (int q = 0 ; q < letters.size() ; q++) {
			newLetters[q] = letters.get(q);
		}
		return newLetters;
	}
}