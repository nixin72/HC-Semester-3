package morse_code_tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;
import adts.binarytree.BinaryTree;
import adts.binarytree.BinaryTreeNode;
import adts.binarytree.LinkedBinaryTree;

public class MorseCodeTree {
	private BinaryTree<String> tree = new LinkedBinaryTree<String>("");

	public BinaryTree<String> getTree() {
		return tree;
	}

	public MorseCodeTree() {
		try {
			File file = new File("codes.txt");
			Scanner read = new Scanner(file);

			while (read.hasNextLine()) {
				String line = read.nextLine();
				char letter = line.charAt(0);
				String code = line.substring(2);
				BinaryTreeNode<String> parent = tree.root();

				for (int q = 0; q < code.length(); q++) {
					char curr = code.charAt(q);

					if (curr == '.') {
						if (parent.leftChild() != null) {
								BinaryTreeNode<String> temp = parent.leftChild();
								temp.element().toString();
								parent = temp;
						}
						else {
							tree.makeLeftChild(parent, String.valueOf(letter));
						}
					} 
					else {
						if (parent.rightChild() != null) {
							BinaryTreeNode<String> temp = parent.rightChild();
							temp.element().toString();
							parent = temp;
						}
						else {
							tree.makeRightChild(parent, String.valueOf(letter));
						}
					}
				}
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be found.");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String encode(String m) {
		m = m.toLowerCase();
		CodeVisitor visit = new CodeVisitor();
		tree.levelOrderTraversal(visit);
		String tempvar = visit.getCode();
		String[] words = m.split("\\s");
		String msg = "";

		String[] codes = tempvar.split("\\s");
		String[] letters = visit.getLetters();

		for (int q = 0; q < words.length; q++) {
			for (int w = 0; w < words[q].length(); w++) {
				for (int k = 0; k < letters.length; k++) 
					if (String.valueOf(words[q].charAt(w)).equals(letters[k]))
						msg += codes[k + 2];
				if (w != words[q].length() - 1)
					msg += " ";
			}
			if (q != words.length - 1)
				msg += "  ";
		}
		return msg;
	}

	public String decode(String c) {
		String[] words = c.split("\\s\\s");
		String message = "";

		for (int w = 0; w < words.length; w++) {
			String[] codes = words[w].split("\\s");
			for (int q = 0; q < codes.length; q++) {
				String code = codes[q];
				BinaryTreeNode<String> parent = tree.root();
				for (int k = 0; k < code.length(); k++) {
					char curr = code.charAt(k);

					if (curr == '.') {
						BinaryTreeNode<String> temp = parent.leftChild();
						temp.element().toString();

						if (k != code.length() - 1) {
							parent = temp;
						} else {
							message += parent.leftChild().element().toString();
						}
					} else if (curr == '-') {
						BinaryTreeNode<String> temp = parent.rightChild();
						temp.element().toString();

						if (k != code.length() - 1) {
							parent = temp;
						} else {
							message += parent.rightChild().element().toString();
						}
					}
				}
			}
			if (w != words.length - 1)
				message += " ";
		}
		return message;
	}
}