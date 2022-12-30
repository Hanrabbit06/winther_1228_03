package gui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//독립된 ActionListener 클래스를 구현
public class JFrameTest5 extends JFrame {
	ImageIcon icon = new ImageIcon("images/스노우볼.jpg");
	JLabel lbl = new JLabel(icon, JLabel.CENTER);

	JButton btn1 = new JButton("AKMU");
	JButton btn2 = new JButton("200%");
	JButton btn3 = new JButton("RE-Bay");
	
	public JFrameTest5() {
		JPanel pan = new JPanel();
		ButtonListener btnListener = new ButtonListener(btn1, btn2, lbl);
		btn1.addActionListener(btnListener);
		btn2.addActionListener(btnListener);
		btn3.addActionListener(btnListener);
		
		pan.add(btn1); pan.add(btn2); pan.add(btn3);
		add(pan, "North");
		
		add(lbl, "Center");
		setTitle("JFrame 상속 연습5");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(500, 525);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JFrameTest5();

	}
	
	
}
