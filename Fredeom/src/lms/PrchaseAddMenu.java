package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PrchaseAddMenu extends JFrame implements ActionListener{
    
    JButton add,back,mainMenu,clear,exit;
    JComboBox type1,gender1,status1;
    JLabel publisher,author,type,name,status,ISBM,m_name,adress,profesion,gender;
    JTextField date1,publisher1,author1,name1,ISBM1, m_name1, m_phone1, email1,adress1,profesion1;
    JPanel p1;
	private JLabel lb,m_phone, email;
    public String date;
    
     PrchaseAddMenu()
    {
        initComponents();
    }
    
    void initComponents()
    {
        setTitle("Purchase Menu");
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        type=new JLabel("Type:");
        type.setFont(new Font("Arial", Font.BOLD, 17));
        type.setBounds(80,120,80,20);
        type.setForeground(Color.red);
        
        name=new JLabel("Item_Name:");
        name.setFont(new Font("Arial", Font.BOLD, 17));
        name.setBounds(210,120,120,24);
        name.setForeground(Color.red);
        ISBM=new JLabel("ISBM:");
        ISBM.setFont(new Font("Arial", Font.BOLD, 17));
        ISBM.setBounds(210,150,120,24);
        ISBM.setForeground(Color.red);
        author=new JLabel("Author:");
        author.setFont(new Font("Arial", Font.BOLD, 17));
        author.setForeground(Color.red);
        author.setBounds(210,180,80,24);
        publisher=new JLabel("Publisher:");
        publisher.setFont(new Font("Arial", Font.BOLD, 17));
        publisher.setBounds(210,210,80,24);
        publisher.setForeground(Color.red);
        status=new JLabel("Status:");
        status.setFont(new Font("Arial", Font.BOLD, 17));
        status.setBounds(210,240,80,20);
        status.setForeground(Color.red);
        
        m_name=new JLabel("Member Name:");
        m_name.setFont(new Font("Arial", Font.BOLD, 17));
        m_name.setBounds(210,270,120,24);
        m_name.setForeground(Color.red);
        m_phone=new JLabel("Phone no:");
        m_phone.setFont(new Font("Arial", Font.BOLD, 17));
        m_phone.setBounds(210,300,120,24);
        m_phone.setForeground(Color.red);
        email=new JLabel("Email:");
        email.setFont(new Font("Arial", Font.BOLD, 17));
        email.setForeground(Color.red);
        email.setBounds(210,330,80,24);
        adress=new JLabel("Adress:");
        adress.setFont(new Font("Arial", Font.BOLD, 17));
        adress.setBounds(210,360,80,24);
        adress.setForeground(Color.red);
        profesion=new JLabel("Profession:");
        profesion.setFont(new Font("Arial", Font.BOLD, 17));
        profesion.setBounds(210,390,80,24);
        profesion.setForeground(Color.red);
        gender=new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD, 17));
        gender.setBounds(210,420,80,22);
        gender.setForeground(Color.red);
        
        name1=new JTextField(21);
        name1.setFont(new Font("Arial", Font.PLAIN, 17));
        name1.setBounds(320,120,200,24);
        ISBM1=new JTextField(19);
        ISBM1.setFont(new Font("Arial", Font.PLAIN, 17));
        ISBM1.setBounds(320,150,200,24);
        author1=new JTextField(20);
        author1.setFont(new Font("Arial", Font.PLAIN, 17));
        author1.setBounds(320,180,200,24);
        publisher1=new JTextField(19);
        publisher1.setFont(new Font("Arial", Font.PLAIN, 17));
        publisher1.setBounds(320,210,200,24);
        m_name1=new JTextField(21);
        m_name1.setFont(new Font("Arial", Font.PLAIN, 17));
        m_name1.setBounds(320,270,200,24);
        m_phone1=new JTextField(19);
        m_phone1.setFont(new Font("Arial", Font.PLAIN, 17));
        m_phone1.setBounds(320,300,200,24);
        email1=new JTextField(20);
        email1.setFont(new Font("Arial", Font.PLAIN, 17));
        email1.setBounds(320,330,200,24);
        adress1=new JTextField(19);
        adress1.setFont(new Font("Arial", Font.PLAIN, 17));
        adress1.setBounds(320,360,200,24);
        profesion1=new JTextField(19);
        profesion1.setFont(new Font("Arial", Font.PLAIN, 17));
        profesion1.setBounds(320,390,200,24);
        
        String[] s={"Book","Dvd"};
        type1=new JComboBox(s); 
        type1.setBounds(120,120,80,24);
        

        String[] s1={"Get","Return"};
        status1=new JComboBox(s1); 
        status1.setBounds(320,240,80,24);
        
        String[] s2={"Male","Female"};
        gender1=new JComboBox(s2); 
        gender1.setBounds(320,420,80,24);

        add=new JButton("Add_Item");
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.setBounds(100,460,150,30);
        back=new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setBounds(330,460,150,30);
        mainMenu=new JButton("Main Menu");
        mainMenu.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenu.setBounds(100,500,150,30);
        clear=new JButton("Clear");
        clear.setFont(new Font("Arial", Font.BOLD, 20));
        clear.setBounds(330,500,150,30);
        exit=new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 22));
        exit.setBounds(510,480,100,30);
        
        lb=new JLabel();
        p1=new JPanel();
        //sset lb layout here otherwise it creat issue
        lb.setLayout(new BorderLayout(200,200));
        p1.setOpaque(false);
        p1.add(name);
        p1.add(ISBM);
        p1.add(author);
        p1.add(publisher);
        p1.add(type);
        p1.add(status);
        p1.add(m_name);
        p1.add(m_phone);
        p1.add(email);
        p1.add(adress);
        p1.add(profesion);
        p1.add(gender);
        p1.add(name1);
        p1.add(ISBM1);
        p1.add(author1);
        p1.add(publisher1);
        p1.add(type1);
        p1.add(status1);
        p1.add(m_name1);
        p1.add(m_phone1);
        p1.add(email1);
        p1.add(adress1);
        p1.add(profesion1);
        p1.add(gender1);
        
        p1.add(add);      
        p1.add(back);
        p1.add(mainMenu);
        p1.add(clear);
        p1.add(exit);

        //sset p1 layout here otherwise it creat issue
         p1.setLayout(new BorderLayout(200,200));
       
        lb.setIcon(new ImageIcon("bckgrnd1.jpg"));
       
        lb.add(p1);
        add(lb);
        add.addActionListener(this);
        exit.addActionListener(this);
        back.addActionListener(this);
        mainMenu.addActionListener(this);
        clear.addActionListener(this);
        
        
        
    }
    
     public void actionPerformed(ActionEvent evt)
    {
    	 if(evt.getSource()==mainMenu)
         {    
         	setVisible(false);
             LMS l=new LMS();
         }else if(evt.getSource()==back)
         {    
          	setVisible(false);
              LMS l=new LMS();
          }else if(evt.getSource()==exit)
          {    
            	System.exit(0);
            }
         else if(evt.getSource()==clear)
         {
             publisher1.setText("");
             author1.setText("");
             name1.setText("");
             ISBM1.setText("");
             m_name1.setText("");
             adress1.setText("");
             profesion1.setText("");
             m_phone1.setText("");
             email1.setText("");         
         }
         else if(evt.getSource()==add)
         {
             try{
                 String   name,author,publisher,Type,status,m_name,email,adress,profesion,gender;
				int m_phone,ISBM;
                 name=name1.getText();
                 author=author1.getText();
                 publisher=publisher1.getText();
                 m_name=m_name1.getText();
                 email=email1.getText();
                 adress=adress1.getText();
                 Type=(String)type1.getSelectedItem();
                 status=(String)status1.getSelectedItem();
                 gender=(String)gender1.getSelectedItem();

                 profesion=profesion1.getText();
                
                 m_phone=Integer.parseInt(m_phone1.getText());
                 ISBM=Integer.parseInt(ISBM1.getText());
                 if(ISBM<0||m_phone<0)
                 {
                     throw new NumberFormatException();
                 } 
                 Purchase d=new Purchase(0,ISBM,name,author,publisher,Type,status,m_name, m_phone,email,adress,profesion, gender," ");
                    d.add();
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                 publisher1.setText("");
                 author1.setText("");
                 name1.setText("");
                 ISBM1.setText("");
                 m_name1.setText("");
                 m_phone1.setText("");
                 email1.setText("");
                 adress1.setText("");
                 profesion1.setText("");
                 
                 
             }catch(NumberFormatException e)
             {
                 JOptionPane.showMessageDialog(null, " ID and phone no only be Positive Integers.","Inane error",JOptionPane.ERROR_MESSAGE);
                 ISBM1.setText("");m_phone.setText("");
             }catch(Exception e)
             {
                 JOptionPane.showMessageDialog(null, "ID Already Used","Inane error",JOptionPane.ERROR_MESSAGE);
                 ISBM1.setText("");m_phone.setText("");
             }   
         } 
     }
 
}



