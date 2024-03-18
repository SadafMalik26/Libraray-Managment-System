package lms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LMS extends JFrame implements ActionListener{

    JPanel panel1;
    JButton paperBack,DVD,prc,exit;
	private JLabel lb;
    LMS(){
    	initComponents();
    }
   
    void initComponents()
    {  
    	//frame to set panel and label in it
        setTitle("Main Menu");
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        //label for add background image
        lb=new JLabel(); 
        
        //panel to set all items(lbl nd btns) in it
        panel1=new JPanel();
        panel1.setOpaque(false);
        //sset p1 layout here otherwise it creat issue
        panel1.setLayout(new BorderLayout(200,200));
  
        DVD=new JButton("DVD_Menu"); 
        DVD.setBounds(190,120,280,50);
        DVD.setFont(new Font("Arial",Font.BOLD,24)); 

        paperBack=new JButton("PaperBack_Menu");
        paperBack.setFont(new Font("Arial",Font.BOLD,24)); 
        paperBack.setBounds(190,200,280,50);
       
        prc=new JButton("Purchase_Menu");
        prc.setFont(new Font("Arial",Font.BOLD,24)); 
        prc.setBounds(190,280,280,50);
        exit=new JButton("Exit");
        exit.setFont(new Font("Arial",Font.BOLD,24));
        exit.setBounds(220,360,200,50);
        //add btns in panel 
        //sset lb layout here otherwise it creat issue
        lb.setLayout(new BorderLayout(200,200));
        panel1.setOpaque(false);
        panel1.add(paperBack);
        panel1.add(DVD); 
        panel1.add(prc); 
        panel1.add(exit);
        //sset p1 layout here otherwise it creat issue
        panel1.setLayout(new BorderLayout(200,200));
        lb.setIcon(new ImageIcon("bckgrnd1.jpg"));
        //add panel in label to display items in image 
        lb.add(panel1);
        //add imglb in frame
        add(lb);
        //apply action listners to invoke ur frame on presssing btn
        paperBack.addActionListener(this);
        DVD.addActionListener(this);
        prc.addActionListener(this);
        exit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()== DVD)
        {
        	setVisible(false);
            new DVDMenu();
            
        }
        else if(evt.getSource()==paperBack)
        {
        	setVisible(false);
           new PaperBackMenu();
        } else if(evt.getSource()==prc)
        {
        	setVisible(false);
           new PurchaseMenu();
        }else if(evt.getSource()==exit)
        {
        	System.exit(0);
        }}}
