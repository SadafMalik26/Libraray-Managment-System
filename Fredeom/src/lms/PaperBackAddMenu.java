package lms;
import java.awt.*;

import java.awt.event.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.*;
public class PaperBackAddMenu extends JFrame implements ActionListener{

	 
    JButton add,back,mainMenu,clear,exit;
    JComboBox status1,Type1;
    JLabel noOfPages,status,Type,publisher,author,name,ISBM;
    JTextField noOfPages1,publisher1,author1,name1,ISBM1;
    JPanel p1;
	private JLabel lb;
     PaperBackAddMenu()
    {
        initComponents();
    }
    
    void initComponents()
    {
        setTitle("PaperBack_Add_Menu");
       setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        name=new JLabel("Book_Name:");
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
        noOfPages=new JLabel("NoOfPages:");
        noOfPages.setFont(new Font("Arial", Font.BOLD, 17));
        noOfPages.setBounds(210,240,80,24);
        noOfPages.setForeground(Color.red);
        
        
        Type=new JLabel("Type:");
        Type.setFont(new Font("Arial", Font.BOLD, 17));
        Type.setBounds(210,270,80,24);
        Type.setForeground(Color.red);
        status=new JLabel("Status:");
        status.setFont(new Font("Arial", Font.BOLD, 17));
        status.setBounds(210,300,80,24);
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
        noOfPages1=new JTextField(19);
        noOfPages1.setFont(new Font("Arial", Font.PLAIN, 17));
        noOfPages1.setBounds(320,240,200,24);
        
        String[] s={"Novel","Educational","Story","Magzine","Islmic","funny","Poem","History"};
        Type1=new JComboBox(s);
        Type1.setBounds(320,270,80,24);

        String[] s1={"Available","Not Available"};
        status1=new JComboBox(s1);
        status1.setBounds(320,300,80,24);
        
        add=new JButton("Add_Book");
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
        p1.add(noOfPages);
        p1.add(Type);
        p1.add(status);
        
        p1.add(name1);
        p1.add(ISBM1);
        p1.add(author1);
        p1.add(publisher1);
        p1.add(noOfPages1);
        p1.add(Type1);
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
        {
        	System.exit(0);
        }
        else if(evt.getSource()==clear)
        { 
        	
        	noOfPages1.setText("");
        publisher1.setText("");
        author1.setText("");
        name1.setText("");
        ISBM1.setText("");}
        
        else if(evt.getSource()==back)
        {
        	setVisible(false);
            PaperBackMenu d=new PaperBackMenu();
        }
        else if(evt.getSource()==add)
        {
            try{
            	 String name,author,publisher,Type,status;
                 int noOfPages,ISBM,ID = 0;
                 name=name1.getText();
                 author=author1.getText();
                 publisher=publisher1.getText();
                 Type=(String)Type1.getSelectedItem();
                 status=(String)status1.getSelectedItem();
                 if(name.isEmpty()||author.isEmpty()||publisher.isEmpty()||Type.isEmpty())
                 {
                     throw new RuntimeException();
                 }
                 ISBM=Integer.parseInt(ISBM1.getText());
                 noOfPages=Integer.parseInt(noOfPages1.getText());
                 if(noOfPages<0)
                 {
                     throw new NumberFormatException();
                 }
                 PaperBack d=new PaperBack(0,ISBM,name,author,publisher,Type,status,noOfPages);
                 d.add();
                 JOptionPane.showMessageDialog(null, "Successfully Added");
                 noOfPages1.setText("");
                 publisher1.setText("");
                 author1.setText("");
                 name1.setText("");
                 ISBM1.setText("");
             }catch(SQLException e)
             {
                 JOptionPane.showMessageDialog(null, "ID Already Used","Inane error",JOptionPane.ERROR_MESSAGE);
                 ISBM1.setText("");
             }
             catch(NumberFormatException e)
             {
                 JOptionPane.showMessageDialog(null, "No of Pages and ID can only be a Positive Integers.","Inane error",JOptionPane.ERROR_MESSAGE);
                 noOfPages1.setText("");
                 ISBM1.setText("");
             }
             catch(RuntimeException r)
             {
                 JOptionPane.showMessageDialog(null, "Fields Cannot be Empty","Inane error",JOptionPane.ERROR_MESSAGE);
             }
         }
     }
 }
