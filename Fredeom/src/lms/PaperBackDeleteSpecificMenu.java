package lms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PaperBackDeleteSpecificMenu extends JFrame implements ActionListener{
    
    JPanel p1;
    JLabel lb1,lb;
    JTextField textField;
    JButton back,mainMenu,delete;
    PaperBackDeleteSpecificMenu()
    {
       
        initComponents();
    }
    
    void initComponents()
    {
        setTitle("PaperBack_del_specific");
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        p1=new JPanel();
        lb1=new JLabel("ISBM"); 
        lb1.setFont(new Font("Arial", Font.BOLD, 24));
        lb1.setBounds(230,130,240,50);
        lb1.setForeground(Color.red);
        textField=new JTextField(18); 
        textField.setBounds(180,170,250,40);
        textField.setFont(new Font("Arial", Font.BOLD, 22));
       

        delete=new JButton("Delete");
        delete.setFont(new Font("Arial", Font.BOLD, 24));
        delete.setBounds(240,240,150,50);
        back=new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 24));
        back.setBounds(240,320,150,50);
        mainMenu=new JButton("Main Menu");
        mainMenu.setFont(new Font("Arial", Font.BOLD, 24));
        mainMenu.setBounds(240,400,150,50);
        
      //sset lb layout here otherwise it creat issue
        lb=new JLabel();
        p1=new JPanel();
        lb.setIcon(new ImageIcon("bckgrnd1.jpg"));
        lb.setLayout(new BorderLayout(200,200));
        
        p1.setOpaque(false);
        p1.add(lb1);
        p1.add(textField);
        p1.add(back);
        p1.add(mainMenu);
        p1.add(delete);

        //sset p1 layout here otherwise it creat issue
        p1.setLayout(new BorderLayout(200,200));
      
      
       lb.add(p1);
       add(lb);
        back.addActionListener(this);
        mainMenu.addActionListener(this);
        delete.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==back)
        {   
        	setVisible(false);
            new PaperBackDeleteMenu();
        }else if(evt.getSource()==mainMenu)
        {    
        	setVisible(false);
            LMS l=new LMS();
        }else if(evt.getSource()==delete)
        {
            int ISBM=Integer.parseInt(textField.getText());
            setVisible(false);
            PaperBack p=new PaperBack(ISBM);
            p.readData();
            p.delete();
            JOptionPane.showMessageDialog(null, "Successfully Deleted");
            textField.setText("");
        }
    }
}
