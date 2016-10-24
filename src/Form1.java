import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Form1 extends JFrame{

	public static void main(String[] args) {
		
		new Form1();

	}
	
	BufferedImage img = null;
	
	public Form1(){
		setLayout(null);
		setSize(750, 550);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("빵집찾기 프로그램");
		
		JLabel label1 = new JLabel("빵 이름");
		label1.setBounds(50, 20, 200, 30);
		add(label1);
		
		JTextField Text1 = new JTextField();
		add(Text1);
		Text1.setBounds(100, 20, 180, 30);

		JButton button1 = new JButton("검색");
		add(button1);
		button1.setBounds(295, 20, 60, 30);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//setVisible(true);
			new DataBoard();}
			});
		
		JButton button2 = new JButton("회원가입");
		add(button2);
		button2.setBounds(440, 20,120, 30);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//setVisible(true);
			new SignUp();}
			});
		
		JButton button3 = new JButton("판매자 로그인");
		add(button3);
		button3.setBounds(580, 20,120,30);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//setVisible(true);
			new Login();}
			});
		try{
			img = ImageIO.read(new File("seoul_map.gif"));
		}catch(IOException e){
			System.out.println("이미지 불러오기 실패");
			System.exit(0);
		}
		
		MyPanel panelimage = new MyPanel();
		panelimage.setBounds(50,80,600,500);
		add(panelimage);
		
		
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paint(Graphics g){
		g.drawImage(img,  0,  0,  null);
		}
	}
	


}