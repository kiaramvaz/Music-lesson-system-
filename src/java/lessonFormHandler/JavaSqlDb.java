package lessonFormHandler;
//Sql Database Methods


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author KiaraVaz
 */
public class JavaSqlDb {
    private String dbName;
    private ArrayList<ArrayList<String>> data;
    private Connection dbConn;
   
    
    public JavaSqlDb(String dbName)
    {
        this.dbName = dbName;
        this.data = null;
        setdbConn();
    }
    
    public JavaSqlDb(){
        this.dbName = "";
        this.data = null;
        this.dbConn =null;    
    }

    public String getdbName() {
        return dbName;
    }

    public void setdbName(String dbName) {
        this.dbName = dbName;
    }

    public ArrayList<ArrayList<String>> getdata(String tableName, String[] tableHeaders) {
        int columnCount=tableHeaders.length;
        ResultSet rs=null;
        Statement s=null;
        String dbQuery= "SELECT * FROM " + tableName;
        this.data= new ArrayList<>();
        
        
        try{
          s= this.dbConn.createStatement();
          rs = s.executeQuery(dbQuery);
          while(rs.next()){
            ArrayList<String> row= new ArrayList<>();
            for(int i = 0; i < columnCount; i++){
                row.add(rs.getString(tableHeaders[i]));
            }
            this.data.add(row);
        }
          
        
        }
          catch(SQLException err){
                  System.out.println("Unable to get the data from database!");
                  System.exit(0);
                  }
          return this.data;
        }
    
    public void setdata(ArrayList<ArrayList<String>> data) {
        this.data = data;
    }

    public Connection getdbConn() {
        return this.dbConn;
    }

    public void setdbConn() {
        
        String connectionURL = "jdbc:mysql://localhost:3306/" + this.dbName;
        this.dbConn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.dbConn= DriverManager.getConnection(connectionURL, "root", "mysql1");
        }
        catch(SQLException err){
            System.out.println("SQL Connection ERRORRR set db");
            System.exit(0);
        }
        catch(ClassNotFoundException ex){
            System.out.println("Class For Name not Found");
            System.exit(0);
            
        }
    }
    
    public void closeDbConn(){
        try{
            this.dbConn.close();
            
        }
        catch (Exception err) {
           System.out.println("DB closing error");
           System.exit(0);
        }
    }
    
    public void createDb(String newDbName){
        this.dbName = newDbName;
        String connectionURL = "jdbc:mysql://localhost:3306/" ;
        
        
        try{
            
            System.out.println("Connection to and creating the database");
            Class.forName("com.mysql.jdbc.Driver");
            this.dbConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
            Statement s = this.dbConn.createStatement();
            int result = s.executeUpdate("Create DATABASE " + newDbName);
            System.out.println("Database created.");
            dbConn.close();
            
        }
        catch (Exception err){
            System.out.println("Error creating database:" + newDbName);
            System.exit(0);
            
        }
        
    }
    
    public void createTable(String newTable, String dbName){
        Statement s;
        
        setdbName(dbName);
        setdbConn();
        try{
            s= this.dbConn.createStatement();
            s.execute(newTable);
            System.out.println("New table created");
            this.dbConn.close();
           
        }
        catch(SQLException err){
            System.out.println("Error creating table"+ newTable);
            System.exit((0));
        }
    }   
    public static void main(String[] args)
    {
            String dbName = "lessonDb";
            String tableName="voiceTable";
            String [] tableHeaders={"Time", "Monday", "Tuesday", "Wednesday", "Thursday","Friday"};
            JavaSqlDb dbObj = new JavaSqlDb(dbName);
            
            ArrayList<ArrayList<String>> data = dbObj.getdata(tableName, tableHeaders);        
    }
       
}