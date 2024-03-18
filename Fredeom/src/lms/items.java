package lms;
import java.sql.SQLException;
public abstract class items {
    protected String name;
	protected String author;
	protected String publisher;
	protected String Type,status;
	protected int ISBM;
	protected int ID;
    items()
    {
        
    }
    items(int ID,int ISBM,String name,String author,String publisher,String Type,String status)
    {
        this.ID=ID;
        this.ISBM=ISBM;
        this.name=name;
        this.author=author;
        this.publisher=publisher;
        this.Type=Type;
        this.status=status;
    }
    
    items(int ISBM)
    {
        this.ISBM=ISBM;
    }
    
    items(int ISBM,String status)
    {
        this.ISBM=ISBM;
        this.status=status;
    }
    public abstract void add() throws SQLException ;
    public abstract void deleteAll();
    public abstract void delete();
    public abstract void update() throws SQLException  ;
    
}
