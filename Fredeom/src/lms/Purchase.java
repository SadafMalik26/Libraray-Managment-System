package lms;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Purchase extends items implements ActionListener {
      
   	   private int m_phone;
       private Connection con;
	   private JFrame j;
       private JButton back,exit;
       private Vector data,coulmnNames;
	   private JPanel p;
	   private JTable jt;
	   protected String  bdate, m_name, email, adress, profession, gender,date;
       private Connection conn;
       private JPanel fp;
       
	//super to invoke bookclass
    Purchase()
    {
        super();
    }

	//super to invoke bookclass but with addition of date
    Purchase(int ID,int ISBM,String name,String author,String publisher,String Type,String status,String m_name,int m_phone,String email,String adress,String profession,String gender,String date)
    {
        super(ID,ISBM,name,author,publisher,Type,status);
        this.m_name=m_name;
        this.m_phone=m_phone;
        this.email=email;
        this.adress=adress;
        this.profession=profession;
        this.gender=gender;
        this.date=date;
    }
    
    Purchase(int ISBM)
    {
        super(ISBM);
    }
    
    Purchase(int ISBM,String status)
    {
        super(ISBM,status);
    }

public  String Date() {
DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
Date today = new Date();
return date=(today.toString());

}
    //to add data in table
    public void add() throws SQLException
    { 
    	conn = this.connect();
    	try {
        String sql = "insert into Purchase"+"(ISBM,itemname,author,publisher,type,status,purchasername,phoneno,email,adress,profesion,gender,date)"
        		+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ISBM);
            pstmt.setString(2, name);  
            pstmt.setString(3, author); 
            pstmt.setString(4,publisher);
            pstmt.setString(5,Type);
            pstmt.setString(6,status);
            pstmt.setString(7, m_name);  
            pstmt.setInt(8, m_phone); 
            pstmt.setString(9,email);
            pstmt.setString(10,adress);
            pstmt.setString(11, profession); 
            pstmt.setString(12,gender);
            pstmt.setString(13 ,Date());

            pstmt.executeUpdate(); 
    }catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	}
    
    ///tp clearall data
    public void deleteAll()
    {
        String sql = "delete from  Purchase";
        try
        {

        	conn = this.connect(); 
            Statement pstmt = conn.createStatement();
            pstmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e);
            
        }
    } 
    //to dell spcific  data
    public void delete()
    {
        String sql ="delete from Purchase where ISBM = ?";
        try{

        	conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ISBM);
            pstmt.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
  
   
    //set socnnection with drivers and database
    private Connection connect() {
    try {
	   Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	   System.out.println("Drivers found");
	   }
	   catch (ClassNotFoundException e)
	   {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   }

	   try {
	   con= DriverManager.getConnection( "jdbc:ucanaccess://C:\\Users\\hp\\Documents\\LLMMSS.accdb" ) ;
	   System.out.println("Database found");

	   } catch (SQLException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();

		
	   }
	return con;}

    //update status 
    public void update() throws SQLException
    {
        String sql = "update Purchase set status =? where ISBM = ?";
    	conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, status);
        pstmt.setInt(2, ISBM);
        pstmt.executeUpdate();  
    }
    
  
      public void readData() {
    	String s="select * from Purchase";
    	Statement st;
    	conn = this.connect();
    	try {
    	st = con.createStatement();
    	ResultSet rs=st.executeQuery(s);
    	ResultSetMetaData md= rs.getMetaData();

    	data=new Vector();
    	coulmnNames=new Vector();

    	for (int i=1;i<=md.getColumnCount();i++) {
    	coulmnNames.add(md.getColumnName(i));
    	System.out.println(md.getColumnName(i));
    	}

    	while(rs.next()) {
        	Integer ID=rs.getInt("ID");
        	Integer ISBM=rs.getInt("ISBM");
        	String name=rs.getString("itemname");
        	String author=rs.getString("author");
        	String publisher=rs.getString("publisher");
        	String type=rs.getString("type");             
        	String m_name=rs.getString("purchasername");
        	Integer m_phone=rs.getInt("phoneno");
        	String email=rs.getString("email");
        	String adress=rs.getString("adress");
        	String profesion=rs.getString("profesion");
        	String gender=rs.getString("gender");      
        	String date=rs.getString("Date");       
        	String status=rs.getString("status");


        	Vector row=new Vector();
        	row.addElement(ID);
        	row.addElement(ISBM);
        	row.addElement(name);
        	row.addElement(author);
        	row.addElement(publisher);
        	row.addElement(type);
        	row.addElement(m_name);
        	row.addElement(m_phone);
        	row.addElement(email);
        	row.addElement(adress);
        	row.addElement(profesion);
        	row.addElement(gender);
        	row.addElement(Date());
        	row.addElement(status);
        	data.add(row);


    	}
    	System.out.println(data.toString());

    	} catch (SQLException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();}}
    
    public void show() {

   	 conn = this.connect();
   	JFrame f=new JFrame();
		f.getContentPane().removeAll();
   	f.setVisible(true);
   	f.setSize(650,600);
   	 
   	fp=new JPanel();
    //sset p1 layout here otherwise it creat issue
    fp.setLayout(new BorderLayout(200,200));
	back=new JButton("Back");
    back.setFont(new Font("Arial", Font.PLAIN, 17));
    back.setBounds(320,150,200,24);
    exit=new JButton("Exit");;
    exit.setFont(new Font("Arial", Font.PLAIN, 17));
    exit.setBounds(320,200,200,24);
   	jt=new JTable(data,coulmnNames);
   	
   	back.addActionListener(new ActionListener() {
   	@Override
   	public void actionPerformed(ActionEvent arg0) { 
   		new DVDMenu();
   		f.setVisible(false);
   		try {

				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}});	
   	exit.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent arg0) { 
	    		System.exit(0);
			}});
   	
   	fp.add(back);fp.add(exit);
	Dimension d = new Dimension(data.size()*150,7*9 );
	jt.setPreferredScrollableViewportSize( d );
   	JScrollPane jsp=new JScrollPane(jt);
   	
   	fp.add(jsp);
		f.getContentPane().add(fp);
   	f.pack();}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}

