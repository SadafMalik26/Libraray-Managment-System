package lms; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class DVDDeleteMenu extends JFrame implements ActionListener{
    
    JPanel p1;
	private JLabel lb;
    JButton back,mainMenu, del, delall;
    
    DVDDeleteMenu()
    {
        initComponents();
    }
    
    void initComponents()
    {
        setTitle("DVD_Dll_Menu");
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        p1=new JPanel();
        del=new JButton("del specific");
        del.setFont(new Font("Arial", Font.BOLD, 24)); delall=new JButton("Del_all");
        delall.setFont(new Font("Arial", Font.BOLD, 24));
        delall.setBounds(220,200,220,50);
        del.setBounds(220,120,220,50);
        back=new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 24));
        back.setBounds(220,280,220,50);
        mainMenu=new JButton("Main Menu");
        mainMenu.setFont(new Font("Arial", Font.BOLD, 24));
        mainMenu.setBounds(220,360,220,50);
       
        
        lb=new JLabel();
        p1=new JPanel();
        //sset lb layout here otherwise it creat issue
        lb.setLayout(new BorderLayout(200,200));
        p1.setOpaque(false);
        p1.add(del);
        p1.add(delall);
        p1.add(back);
        p1.add(mainMenu);
  

        //sset p1 layout here otherwise it creat issue
         p1.setLayout(new BorderLayout(200,200));
       
        lb.setIcon(new ImageIcon("bckgrnd1.jpg"));
       
        lb.add(p1);
        add(lb);
        del.addActionListener(this);
        delall.addActionListener(this);
        back.addActionListener(this);
        mainMenu.addActionListener(this);
        add(lb);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==back)
        {
        	setVisible(false);
            DVDMenu d=new DVDMenu();
        }else if(evt.getSource()==mainMenu)
        {
        	setVisible(false);
            LMS l=new LMS();
        }else if(evt.getSource()==delall)
        {
            DVD d=new DVD();
            d.deleteAll();
            JOptionPane.showMessageDialog(null, "Data Deleted");
        }else if(evt.getSource()==del)
        {
        	setVisible(false);
            DVDDeleteSpecificMenu d=new DVDDeleteSpecificMenu();
        }
    }
}
