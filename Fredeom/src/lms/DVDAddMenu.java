package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class DVDAddMenu extends JFrame implements ActionListener{
    
    JButton add,back,mainMenu,clear,exit;
    JComboBox type1,status1;
    JLabel duration,publisher,author,type,name,ISBM,status;
    JTextField duration1,publisher1,author1,name1,ISBM1;
    JPanel p1;
	private JLabel lb;
 
    
     DVDAddMenu()
    {
        initComponents();
    }
    
    void initComponents()
    {
        setTitle("DVD_Add_Menu");
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        name=new JLabel("DVD_Name:");
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
        duration=new JLabel("Duration:");
        duration.setFont(new Font("Arial", Font.BOLD, 17));
        duration.setBounds(210,240,80,24);
        duration.setForeground(Color.red);
        
        type=new JLabel("Type:");
        type.setFont(new Font("Arial", Font.BOLD, 17));
        type.setBounds(210,270,80,24);
        type.setForeground(Color.red);  
        
        status=new JLabel("Status:");
        status.setFont(new Font("Arial", Font.BOLD, 17));
        status.setBounds(210,290,80,24);
        status.setForeground(Color.red);
       
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
        duration1=new JTextField(19);
        duration1.setFont(new Font("Arial", Font.PLAIN, 17));
        duration1.setBounds(320,240,200,24);
        
        String[] s={"Audio","Video"};
        type1=new JComboBox(s); 
        type1.setBounds(320,270,80,24);
        
        String[] s1={"Available","Not Available"};
        status1=new JComboBox(s1); 
        status1.setBounds(320,290,80,24);

        add=new JButton("Add_Dvd");
        add.setFont(new Font("Arial", Font.BOLD, 22));
        add.setBounds(120,360,150,50);
        back=new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 22));
        back.setBounds(380,450,150,50);
        mainMenu=new JButton("Main Menu");
        mainMenu.setFont(new Font("Arial", Font.BOLD, 22));
        mainMenu.setBounds(380,360,150,50);
        clear=new JButton("Clear");
        clear.setFont(new Font("Arial", Font.BOLD, 22));
        clear.setBounds(120,450,150,50);
        exit=new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 22));
        exit.setBounds(280,510,80,30);
        
        lb=new JLabel();
        p1=new JPanel();
        //sset lb layout here otherwise it creat issue
        lb.setLayout(new BorderLayout(200,200));
        p1.setOpaque(false);
        p1.add(name);
        p1.add(ISBM);
        p1.add(author);
        p1.add(publisher);
        p1.add(duration);
        p1.add(type);
        p1.add(status);
        
        p1.add(name1);
        p1.add(ISBM1);
        p1.add(author1);
        p1.add(publisher1);
        p1.add(duration1);
        p1.add(type1);
        p1.add(status1);
        
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
         }else if(evt.getSource()==exit)
         {    System.exit(0);
          }
         else if(evt.getSource()==clear)
         {
             duration1.setText("");
             publisher1.setText("");
             author1.setText("");
             name1.setText("");
             ISBM1.setText("");
         }
         else if(evt.getSource()==back)
         {
         	setVisible(false);
             DVDMenu d=new DVDMenu();
         }
         else if(evt.getSource()==add)
         {
             try{
                 String name,author,publisher,Type, duration,status;
                 int ISBM;
                 name=name1.getText();
                 author=author1.getText();
                 publisher=publisher1.getText();
                 Type=(String)type1.getSelectedItem();
                 status=(String)status1.getSelectedItem();
                 duration=duration1.getText();
                 if(name.isEmpty()||author.isEmpty()||publisher.isEmpty()||Type.isEmpty()||status.isEmpty())
                 {
                     throw new RuntimeException();
                 }
                 ISBM=Integer.parseInt(ISBM1.getText());
                 if(ISBM<0)
                 {
                     throw new NumberFormatException();
                 } 
                 DVD d=new DVD(0,ISBM,name,author,publisher,Type,status,duration);
                 d.add();
                 JOptionPane.showMessageDialog(null, "Successfully Added");
                 duration1.setText("");
                 publisher1.setText("");
                 author1.setText("");
                 name1.setText("");
                 ISBM1.setText("");
             }catch(NumberFormatException e)
             {
                 JOptionPane.showMessageDialog(null, " ID can only be Positive Integers.","Inane error",JOptionPane.ERROR_MESSAGE);
                 ISBM1.setText("");
             }catch(RuntimeException r)
             {
            	 
                 JOptionPane.showMessageDialog(null, "Fields Cannot be Empty","Inane error",JOptionPane.ERROR_MESSAGE);
             }catch(SQLException e)
             {
                 JOptionPane.showMessageDialog(null, "ID Already Used","Inane error",JOptionPane.ERROR_MESSAGE);
                 ISBM1.setText("");
             }   
         } 
     }
 }