package lms;
import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public  class DVD extends items implements ActionListener {
       private String duration;
       private Connection con;
       private JButton back,exit;
       private Vector data,coulmnNames;
	   private JPanel p,fp;
	   private JTable jt;
		private JLabel lb;
		private JPanel panel1;
	   Connection conn;

	//super to invoke bookclass
    DVD()
    {
        super();
    }

	//super to invoke bookclass but with addition of duration
    DVD(int ID,int ISBM,String name,String author,String publisher,String Type,String status,String duration)
    {
        super(ID,ISBM,name,author,publisher,Type,status);
        this.duration=duration;
    }
    
    DVD(int ISBM)
    {
        super(ISBM);
    }
    
    DVD(int ISBM,String status)
    {
        super(ISBM,status);
    }
   
    
    //to add data in table
    public void add() throws SQLException 
    {         conn = this.connect();
    try {
        String sql = "insert into dvd"+"(ISBM,DVD_Name,Author,Publisher,Type,Status,Duration)"
        		+ " values(?,?,?,?,?,?,?)";
               
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ISBM);
            pstmt.setString(2, name);  
            pstmt.setString(3, author); 
            pstmt.setString(4,publisher);
            pstmt.setString(5,Type);
            pstmt.setString(6,status);
            pstmt.setString(7,duration);
            pstmt.executeUpdate(); 

    }catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	}
	
    
    ///tp clearall data
    public void deleteAll()
    {
        String sql = "delete from  dvd";
        try
        {
        	Connection conn = this.connect(); 
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
        String sql ="delete from dvd where ISBM = ?";
        try{
        	 conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ISBM);
            pstmt.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }  //to dell spcific  data
 
    //set so cnnection with drivers and database
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
        String sql = "update dvd set status =? where ISBM = ?";
    	Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, status);
        pstmt.setInt(2, ISBM);
        pstmt.executeUpdate();  
    }
    public void readData() {
    	String s="select * from dvd";
    	Statement st;
    	try {

        	 conn = this.connect();
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
        	String name=rs.getString("DVD_Name");
        	String author=rs.getString("Author");
        	String publisher=rs.getString("Publisher");
        	String type=rs.getString("Type");
        	String duration=rs.getString("Duration");
        	String status=rs.getString("Status");


        	Vector row=new Vector();
        	row.addElement(ID);
        	row.addElement(ISBM);
        	row.addElement(name);
        	row.addElement(author);
        	row.addElement(publisher);
        	row.addElement(type);
        	row.addElement(duration);
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
    	f.setSize(600,550);
    	 
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
    	Dimension d = new Dimension(data.size()*200,7*9 );
    	jt.setPreferredScrollableViewportSize( d );

    	JScrollPane jsp=new JScrollPane(jt);
    	
    	fp.add(jsp);
		f.getContentPane().add(fp);
    	f.pack();}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}

