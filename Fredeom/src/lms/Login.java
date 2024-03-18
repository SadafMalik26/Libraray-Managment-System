package lms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Login extends JFrame{
	
	
private JLabel lb,user, pass;
private JTextField txt;
private JPasswordField password;
private JButton bt;

Login(){
setSize(650,600);
setTitle("Welcome to library");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
//label for set image
lb=new JLabel();
lb.setIcon(new ImageIcon("login.jpg"));

user=new JLabel("Adminname");
user.setForeground(Color.black);
user.setFont(new Font("Arial",Font.BOLD,24));
user.setBounds(210,185,180,50);
txt=new JTextField(20);
txt.setFont(new Font("Arial",Font.BOLD,22));
txt.setBounds(400,185,240,60);
pass=new JLabel("Password");
pass.setForeground(Color.BLACK);
pass.setFont(new Font("Arial",Font.BOLD,24));
pass.setBounds(210,325,180,50);
password=new JPasswordField();
password.setFont(new Font("Arial",Font.BOLD,22));
password.setBounds(400,320,240,60);
bt=new JButton("Login");
bt.setFont(new Font("Arial",Font.BOLD,26));
bt.setBounds(340,450,180,50);
bt.setFocusable(false);
bt.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {
if(txt.getText().equals("sadaf")&&(password.getText().equals("321"))){
JOptionPane.showMessageDialog(null,"Login Successfully","Confirmation",JOptionPane.INFORMATION_MESSAGE);
LMS si=new LMS();
si.setVisible(true);
setVisible(false);

}
else
{
JOptionPane.showMessageDialog(null,"Error","Confirmation",JOptionPane.WARNING_MESSAGE);
}

}

});
JPanel p1=new JPanel();
lb.setLayout(new BorderLayout(200,200));
p1.setOpaque(false);
p1.add(user);
p1.add(pass);
p1.add(txt);
p1.add(password);
p1.add(bt);
p1.setLayout(new BorderLayout(200,200));
lb.add(p1);
getContentPane().add(lb);

setVisible(true);
}

public static void main(String[] args) {
// TODO Auto-generated method stub public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new Login();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });

}}
