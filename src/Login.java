import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame
{
	JLabel labelid, labelpwd;
	JTextField Textid;
	JPasswordField Textpwd;
	JButton sign_in, sign_up;
	
	Login()
	{
		setTitle("login");
		setSize(280, 150);
		setResizable(false);
		setLocation(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		
		add(panel);
		setVisible(true);
	}
	
	public void placeLoginPanel(JPanel panel)
	{
		panel.setLayout(null);
		labelid = new JLabel("User");
		labelid.setBounds(10,10,80,25);
		panel.add(labelid);
		
		labelpwd = new JLabel("Pwd");
		labelpwd.setBounds(10,40,80,25);
		panel.add(labelpwd);
		
		Textid = new JTextField(20);
		Textid.setBounds(100,10,160,25);
		panel.add(Textid);
		
		Textpwd = new JPasswordField(20);
		Textpwd.setBounds(100,40,160,25);
		panel.add(Textpwd);
		//Textpwd.addActionListener(new ActionListener(){});
		
		sign_in = new JButton("sign in");
		sign_in.setBounds(10,80,100,25);
		panel.add(sign_in);
		
		sign_in.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//Textid 와 Textpwd의 정보를 DB와 비교
			setVisible(false);
			new DataBoard();}
			});
		
		sign_up = new JButton("sign up");
		sign_up.setBounds(160, 80, 100, 25);
		panel.add(sign_up);
		//sign_up.addActionListener(new ActionListener(){});_

	}

}
