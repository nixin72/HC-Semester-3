package morse_code_tree;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import adts.binarytree.BinaryTree;

public class MorseCodeTreeTest {
	@Rule
	private final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConstructor() {
		MorseCodeTree test = new MorseCodeTree();
		BinaryTree<String> tree = test.getTree();
		tree.root();
		assertEquals("", "root", tree.root().element().toString());

		assertEquals("", "e", tree.root().leftChild().element().toString());
		assertEquals("", "i", tree.root().leftChild().leftChild().element().toString());
		assertEquals("", "a", tree.root().leftChild().rightChild().element().toString());
		
		assertEquals("", "h", tree.root().leftChild().leftChild().leftChild().leftChild().element().toString());
		assertEquals("", "f", tree.root().leftChild().leftChild().rightChild().leftChild().element().toString());
		
		assertEquals("", "t", tree.root().rightChild().element().toString());
		assertEquals("", "n", tree.root().rightChild().leftChild().element().toString());
		assertEquals("", "m", tree.root().rightChild().rightChild().element().toString());
		
		//Test that trying to access nodes that shouldn't exist will throw an exception
		exception.expect(NullPointerException.class);
		tree.root().leftChild().leftChild().leftChild().leftChild().leftChild().element().toString();
	}
	
	@Test
	public void testDecode() {
		MorseCodeTree test = new MorseCodeTree();
		assertEquals("Testing each letter in the alphabet", "e", test.decode("."));
		assertEquals("Testing each letter in the alphabet", "t", test.decode("-"));
		assertEquals("Testing each letter in the alphabet", "i", test.decode(".."));
		assertEquals("Testing each letter in the alphabet", "a", test.decode(".-"));
		assertEquals("Testing each letter in the alphabet", "n", test.decode("-."));
		assertEquals("Testing each letter in the alphabet", "m", test.decode("--"));
		assertEquals("Testing each letter in the alphabet", "s", test.decode("..."));
		assertEquals("Testing each letter in the alphabet", "u", test.decode("..-"));
		assertEquals("Testing each letter in the alphabet", "r", test.decode(".-."));
		assertEquals("Testing each letter in the alphabet", "w", test.decode(".--"));
		assertEquals("Testing each letter in the alphabet", "d", test.decode("-.."));
		assertEquals("Testing each letter in the alphabet", "k", test.decode("-.-"));
		assertEquals("Testing each letter in the alphabet", "g", test.decode("--."));
		assertEquals("Testing each letter in the alphabet", "o", test.decode("---"));
		assertEquals("Testing each letter in the alphabet", "h", test.decode("...."));
		assertEquals("Testing each letter in the alphabet", "v", test.decode("...-"));
		assertEquals("Testing each letter in the alphabet", "f", test.decode("..-."));
		assertEquals("Testing each letter in the alphabet", "l", test.decode(".-.."));
		assertEquals("Testing each letter in the alphabet", "p", test.decode(".--."));
		assertEquals("Testing each letter in the alphabet", "j", test.decode(".---"));
		assertEquals("Testing each letter in the alphabet", "b", test.decode("-..."));
		assertEquals("Testing each letter in the alphabet", "x", test.decode("-..-"));
		assertEquals("Testing each letter in the alphabet", "c", test.decode("-.-."));
		assertEquals("Testing each letter in the alphabet", "y", test.decode("-.--"));
		assertEquals("Testing each letter in the alphabet", "z", test.decode("--.."));
		assertEquals("Testing each letter in the alphabet", "q", test.decode("--.-"));		
		
		assertEquals("The decode method works", "sos", test.decode("... --- ..."));
		assertEquals("seperating words by two spaces","s o s",test.decode("...  ---  ..."));
		assertEquals("testing all words to the left.","eish", test.decode(". .. ... ...."));
		assertEquals("Testing all words to the right.","tmo", test.decode("- -- ---"));
		
		//Testing words that don't exist
		exception.expect(NullPointerException.class);
		test.decode("----");
		test.decode(".....");
	}
	
	@Test
	public void testEncode() {
		MorseCodeTree test = new MorseCodeTree();
		assertEquals("Testing each letter in the alphabet", ".", test.encode("e"));
		assertEquals("Testing each letter in the alphabet", "-", test.encode("t"));
		assertEquals("Testing each letter in the alphabet", "..", test.encode("i"));
		assertEquals("Testing each letter in the alphabet", ".-", test.encode("a"));
		assertEquals("Testing each letter in the alphabet", "-.", test.encode("n"));
		assertEquals("Testing each letter in the alphabet", "--", test.encode("m"));
		assertEquals("Testing each letter in the alphabet", "...", test.encode("s"));
		assertEquals("Testing each letter in the alphabet", "..-", test.encode("u"));
		assertEquals("Testing each letter in the alphabet", ".-.", test.encode("r"));
		assertEquals("Testing each letter in the alphabet", ".--", test.encode("w"));
		assertEquals("Testing each letter in the alphabet", "-..", test.encode("d"));
		assertEquals("Testing each letter in the alphabet", "-.-", test.encode("k"));
		assertEquals("Testing each letter in the alphabet", "--.", test.encode("g"));
		assertEquals("Testing each letter in the alphabet", "---", test.encode("o"));
		assertEquals("Testing each letter in the alphabet", "....", test.encode("h"));
		assertEquals("Testing each letter in the alphabet", "...-", test.encode("v"));
		assertEquals("Testing each letter in the alphabet", "..-.", test.encode("f"));
		assertEquals("Testing each letter in the alphabet", ".-..", test.encode("l"));
		assertEquals("Testing each letter in the alphabet", ".--.", test.encode("p"));
		assertEquals("Testing each letter in the alphabet", ".---", test.encode("j"));
		assertEquals("Testing each letter in the alphabet", "-...", test.encode("b"));
		assertEquals("Testing each letter in the alphabet", "-..-", test.encode("x"));
		assertEquals("Testing each letter in the alphabet", "-.-.", test.encode("c"));
		assertEquals("Testing each letter in the alphabet", "-.--", test.encode("y"));
		assertEquals("Testing each letter in the alphabet", "--..", test.encode("z"));
		assertEquals("Testing each letter in the alphabet", "--.-", test.encode("q"));
		
		assertEquals("", "... --- ...", test.encode("sos"));
		assertEquals("", "...  ---  ...", test.encode("s o s"));
	}
}