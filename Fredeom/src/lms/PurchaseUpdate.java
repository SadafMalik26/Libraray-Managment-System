package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
public class PurchaseUpdate extends JFrame implements ActionListener{
    JPanel p1;
    JLabel lb1,lb;
    JTextField textField;
    JButton back,mainMenu,update;
    JComboBox status1;
    
    PurchaseUpdate()
    {
        initComponents();
    }
    
    void initComponents()
    {
        setTitle("Purchase_update_status");
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        p1=new JPanel();
        lb1=new JLabel("ISBM"); 
        lb1.setFont(new Font("Arial", Font.BOLD, 24));
        lb1.setBounds(250,100,220,60);
        lb1.setForeground(Color.red);
        textField=new JTextField(18); 
        textField.setBounds(170,170,300,40);
        textField.setFont(new Font("Arial", Font.BOLD, 22));
       
        update=new JButton("Update");
        update.setFont(new Font("Arial", Font.BOLD, 24));
        update.setBounds(240,320,150,50);
        back=new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 24));
        back.setBounds(240,400,150,50);
        mainMenu=new JButton("Main Menu");
        mainMenu.setFont(new Font("Arial", Font.BOLD, 24));
        mainMenu.setBounds(210,480,220,50);

        String[] s={"Audio","VISBMeo"};
        status1=new JComboBox(s);
        status1.setBounds(210,240,100,30);
        
        
        
        
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
        p1.add(update);
        p1.add(status1);

        //sset p1 layout here otherwise it creat issue
        p1.setLayout(new BorderLayout(200,200));
      
      
       lb.add(p1);
       add(lb);
        back.addActionListener(this);
        mainMenu.addActionListener(this);
        update.addActionListener(this);
    
        
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==back)
        {
        	setVisible(false);
            PurchaseMenu p=new PurchaseMenu();
        }else if(evt.getSource()==mainMenu)
        {
        	setVisible(false);
            LMS l=new LMS();
        }else if(evt.getSource()==update)
        {
            try{
                String statu1;
                int ISBM1=Integer.parseInt(textField.getText());
                if(ISBM1<0)
                {
                    throw new RuntimeException();
                }
                statu1=(String)status1.getSelectedItem();
                Purchase d=new Purchase(ISBM1,statu1);
                d.update();
                JOptionPane.showMessageDialog(null, "Type Updated");
            }catch(RuntimeException e)
            {
                JOptionPane.showMessageDialog(null, "ID can only be a Positive Integer.","Inane error",JOptionPane.ERROR_MESSAGE);
                textField.setText("");
                System.out.println(e.getMessage());
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "ID not Found.","Inane error",JOptionPane.ERROR_MESSAGE);
                textField.setText("");
                System.out.println(e.getMessage());
            }
            
        }
    }
}
