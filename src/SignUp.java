import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame{
	
	SignUp()
	{
		setTitle("Sign Up");
		setBounds(400, 20, 450, 360);
		setResizable(false);
		setLocation(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		placeSignUpPanel(panel);
		
		add(panel);
		setVisible(true);
	}
	
	public void placeSignUpPanel(JPanel panel)
	{
		panel.setLayout(null);
		
		JLabel labelid = new JLabel("아이디");
		labelid.setBounds(20, 30, 100, 20);
		panel.add(labelid);
		
		JTextField Textid = new JTextField();
		Textid.setBounds(140, 30, 150, 20);
		panel.add(Textid);
		
		JButton ButtonId = new JButton("중복확인");
		ButtonId.setBounds(310, 30, 90, 20);
		panel.add(ButtonId);
		
		JLabel labelpwd = new JLabel("패스워드");
		labelpwd.setBounds(20, 70, 150, 20);
		panel.add(labelpwd);
		
		JPasswordField pw = new JPasswordField();
		pw.setBounds(140, 70, 150, 20);
		panel.add(pw);
		
		JLabel labelpwd2 = new JLabel("패스워드 재확인");
		labelpwd2.setBounds(20, 110, 100, 20);
		panel.add(labelpwd2);
		
		JPasswordField pw2 = new JPasswordField();
		pw2.setBounds(140, 110, 150, 20);
		panel.add(pw2);
		
		JLabel labelname = new JLabel("매장 이름");
		labelname.setBounds(20, 150, 100, 20);
		panel.add(labelname);
		
		JTextField Textname = new JTextField();
		Textname.setBounds(140, 150, 150, 20);
		panel.add(Textname);
		
		JLabel labelname2 = new JLabel("매장 위치");
		labelname2.setBounds(20, 190, 100, 20);
		panel.add(labelname2);
		
		JTextField Textname2= new JTextField();
		Textname2.setBounds(140, 190, 150, 20);
		panel.add(Textname2);
		
		JLabel phone_id = new JLabel("전화번호");
		phone_id.setBounds(20, 230, 150, 20);
		panel.add(phone_id);
		Vector phone_v = new Vector<>();
		phone_v.add("010");
		phone_v.add("010");
		JComboBox phone = new JComboBox<>(phone_v);
		phone.setBounds(140, 230, 60, 20);
		panel.add(phone);
		JTextField phone_t = new JTextField();
		phone_t.setBounds(210, 230, 100, 20);
		panel.add(phone_t);
		
		JButton join = new JButton("가입하기");
		join.setBounds(170, 270, 90, 40);
		panel.add(join);
		
		
	}
}
