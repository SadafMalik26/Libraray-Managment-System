package lms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PaperBackMenu extends JFrame implements ActionListener{
    JPanel p1;
    JButton add,delete,update,mainMenu,history;
	private JLabel lb;
    
    PaperBackMenu()
    {
       
        initComponents();
    }
    
  
    void initComponents()
    {
        setTitle("PaperBack_Menu");
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        p1=new JPanel();
        p1.setLayout(new GridBagLayout());
        add=new JButton("Add Menu");
        add.setFont(new Font("Arial", Font.BOLD, 24));
        add.setBounds(220,120,220,50);
        delete=new JButton("Delete MENU");
        delete.setFont(new Font("Arial", Font.BOLD, 24));
        delete.setBounds(220,200,220,50);
        history=new JButton("Show History");
        history.setFont(new Font("Arial", Font.BOLD, 24));
        history.setBounds(220,280,220,50);
        update=new JButton("Update");
        update.setFont(new Font("Arial", Font.BOLD, 24));
        update.setBounds(220,360,220,50);
        mainMenu=new JButton("Back");                          //go back
        mainMenu.setFont(new Font("Arial", Font.BOLD, 24));
        mainMenu.setBounds(220,440,220,50);
        
        
        lb=new JLabel();
        p1=new JPanel();
        //sset lb layout here otherwise it creat issue
        lb.setLayout(new BorderLayout(200,200));
        p1.setOpaque(false);
        add(p1);
        p1.add(add);
        p1.add(delete);
        p1.add(history);
        p1.add(update);
        p1.add(mainMenu);


        //sset p1 layout here otherwise it creat issue
         p1.setLayout(new BorderLayout(200,200));
       
        lb.setIcon(new ImageIcon("bckgrnd1.jpg"));
       
        lb.add(p1);
        add(lb);
        add.addActionListener(this);
        delete.addActionListener(this);
        history.addActionListener(this);
        update.addActionListener(this);
        mainMenu.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==add)
        {   
        	setVisible(false);
        	PaperBack pb=new PaperBack();
            pb.readData();
            new PaperBackAddMenu();
        }
        else if(evt.getSource()==mainMenu)
        {
        	setVisible(false);
            new LMS();
        }
        else if(evt.getSource()==history)
        {
            PaperBack pb=new PaperBack();
            pb.readData();
            pb.show();
            JOptionPane.showMessageDialog(null, "Welcome to history");}
        else if(evt.getSource()==delete)
        {
        	setVisible(false);
           new PaperBackDeleteMenu();
        }
        else if(evt.getSource()==update)
        {
        	setVisible(false);
        	new PaperBackUpdateMenu();
        
    }
    }}
