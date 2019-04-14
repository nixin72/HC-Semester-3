package morse_code_tree;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class MorseCodeFrame extends JFrame {
	private MorseCodeTree tree = new MorseCodeTree();
	private JTextArea textAreaResult;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MorseCodeFrame frame = new MorseCodeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MorseCodeFrame() {
		setTitle("Morse Code Translator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 499);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterMsg = new JLabel("Enter text to encode or decode:");
		lblEnterMsg.setBounds(27, 16, 319, 20);
		contentPane.add(lblEnterMsg);
		
		JTextArea textAreaMsg = new JTextArea();
		textAreaMsg.setFont(new Font("Courier New", Font.PLAIN, 20));
		textAreaMsg.setBounds(15, 37, 489, 140);
		contentPane.add(textAreaMsg);
		textAreaMsg.setLineWrap(true);
		textAreaMsg.setWrapStyleWord(true);
		
		JButton btnTo = new JButton("To Morse Code");
		btnTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaResult.setText(tree.encode(textAreaMsg.getText()));
			}
		});
		btnTo.setBounds(15, 193, 230, 29);
		contentPane.add(btnTo);
		
		JButton btnFrom = new JButton("From Morse Code");
		btnFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaResult.setText(tree.decode(textAreaMsg.getText()));
			}
		});
		btnFrom.setBounds(274, 193, 230, 29);
		contentPane.add(btnFrom);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(274, 238, 230, 29);
		contentPane.add(btnClear);
		
		textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Courier New", Font.PLAIN, 20));
		textAreaResult.setBounds(15, 283, 489, 140);
		contentPane.add(textAreaResult);
		textAreaResult.setLineWrap(true);
		textAreaResult.setWrapStyleWord(true);
		textAreaResult.setEditable(false);
		
		/*
		 * Does not just swap the text within both boexes, will actually read it in 
		 * and then call the encode()/decode() method depending one whether is was 
		 * English or Morse Code that was read in. 
		 */
		JButton btnSwap = new JButton("Swap");
		btnSwap.setBounds(15, 238, 230, 29);
		contentPane.add(btnSwap);
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = textAreaResult.getText();
				textAreaMsg.setText(result);
				if (result.matches("^[A-Za-z\\s]+$")) 
					textAreaResult.setText(tree.encode(result));
				else 
					textAreaResult.setText(tree.decode(result));
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaMsg.setText("");
				textAreaResult.setText("");
			}
		});
	}
}