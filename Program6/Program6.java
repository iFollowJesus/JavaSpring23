package chapter13GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Program6 extends JFrame implements ActionListener {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 300;
	public static final int LINES = 12;
	public static final int CHAR_PER_LINE = 55;
	
	private JTextArea theText;
	private String memo1 = "No Memo 1. ";

	public Program6(){
		setSize(WIDTH,HEIGHT);
		addWindowListener(new WindowDestroyer());
		setTitle("Panel Demo");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setLayout(new FlowLayout());
		
		JButton memo1Button = new JButton("Save");
		memo1Button.addActionListener(this);
		buttonPanel.add(memo1Button);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.LIGHT_GRAY);
		
		theText = new JTextArea(LINES, CHAR_PER_LINE);
		theText.setBackground(Color.WHITE);
		textPanel.add(theText);
		contentPane.add(textPanel, BorderLayout.CENTER);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Save")) {
			memo1 = theText.getText();
			try {
				PrintWriter out = new PrintWriter("out.txt");
				out.println(memo1);
				out.close();
				Project5.main(new String[0]);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				theText.setText("File Not Found Exception thrown, please check filename and path.");
				e1.printStackTrace();
			}
			
			
		}
		else if(actionCommand.equals("Clear"))
			theText.setText("");
		else
			theText.setText("Error in memo interface");
	

	}

	public static void main(String[] args) {
		Program6 guiMemo = new Program6();
		guiMemo.setVisible(true);

	}

}
