package restaurant;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Database extends Object {

  private static String  source="jdbc:odbc:Restaurant";
  private static Connection con;
  /**
   * Constructor
   */
  public Database() {

try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

    }
    catch(ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }

public static boolean addItem(String[] basic,long currentValue)
  {
 //0-id,1=name,2=price,3=hot,4=catagory,5-desc,6=status
/* RestaurantID----------????0
ItemID  1
Name  2
Price  double  3
Hot   4
Catagory---???5
Description  Memo   6
picture      memo 7
status  8
dateAdded  9


RestaurantID
ItemID
Name
Price  double
Hot
Catagory
status
Description  Memo
picture      memo
DateCreated
//*/
    String str="insert into Menu  values (?,?,?,?,?,?,?,?,?,?)";
    boolean ok=false,nv=false;
    try
    {
      con=DriverManager.getConnection(source);
      con.setAutoCommit(false);
      PreparedStatement pst=con.prepareStatement(str);
        pst.setString(1,basic[0]);
        pst.setString(2,basic[1]);
        pst.setString(3,basic[2]);
        pst.setDouble(4,Double.parseDouble(basic[3]));
        pst.setString(5,basic[4]);
        pst.setString(6,basic[5]);     
        pst.setString(7,basic[6]);
        pst.setString(8," ");
         pst.setString(9,basic[7]);
        pst.setDate(10,new java.sql.Date(System.currentTimeMillis()));
        
        int index=pst.executeUpdate();
        if(index>0)
        ok=true;
        else
        return ok;
       pst.close(); 
       str="select * from NextValue where restaurantid=? ";
       pst=con.prepareStatement(str);
       pst.setString(1,basic[0]);
       ResultSet rs=pst.executeQuery();
       if(rs.next())
       {
       
          rs.close();
          str="update NextValue set itemID=? where restaurantid=?";
          pst=con.prepareStatement(str);
          pst.setDouble(1,(currentValue+1));
          pst.setString(2,basic[0]);
         
          int index2=pst.executeUpdate();
          if(index2>0)
          {
            p.p("currentvalue="+currentValue);
            nv=true;
             p.p("uresid="+basic[0]);
          }
       }
       else
       {
          rs.close();
          str="insert into NextValue values(?,?)";
          pst=con.prepareStatement(str);
          pst.setDouble(1,1);
          pst.setString(2,basic[0]);
          p.p("aresid="+basic[0]);
          int index2=pst.executeUpdate();
          if(index2>0)
          {
            nv=true;
          }
       }
        
        
    
     if(nv)
     con.commit();
     else
     {
        ok=false;
        con.rollback();
     }
      pst.close();
     con.setAutoCommit(true);
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
  public static boolean addSetting(String itemid,String resid)//
  {
    
    String str="";
    str="insert into Catagory values (?,?)";
    boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      PreparedStatement pst=con.prepareStatement(str);
        pst.setString(1,resid);
        pst.setString(2,itemid);
        int index=pst.executeUpdate();
        if(index>0)
        ok=true;
        
     pst.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
   public static String addTransactions(Vector data,String resid,String cusid)//
  {
    
    String str="";
    int time=0;
    long result=-1;
    str="insert into Transactions (restaurantid,itemid,name,dateCompleted,unitprice,operator,customerID) values (?,?,?,?,?,?,?)";
    boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      con.setAutoCommit(false);
      PreparedStatement pst=con.prepareStatement(str);
      String[] ss=null;
      for(int i=0;i<data.size();i++)
      {
        ss=(String[])(data.get(i));
        pst.setString(1,resid);
        pst.setString(2,ss[0]);
        pst.setString(3,ss[1]);
        pst.setDate(4,new java.sql.Date(System.currentTimeMillis()));
        pst.setDouble(5,Double.parseDouble(ss[2]));
        pst.setString(6,"NA");
        pst.setString(7,cusid);
        int index=pst.executeUpdate();
        if(index<=0)
        {
          ok=false;
          con.rollback();
          pst.close();
          con.close();
          return "-1";
        }
        time++;
      }
     con.commit(); 
     con.setAutoCommit(true);
     str="select max(TransactionNO) from Transactions";
     pst.close();
     pst=con.prepareStatement(str);
     ResultSet rs=pst.executeQuery();
     if(rs.next())
     result=rs.getLong(1);
     rs.close();
     pst.close();
     con.close();
     return result+"_"+time;
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return "-1";
  }
  
  public static boolean updateSetting(String[] values,String oldValue)//
  {
      
    String str="update Catagory set catagory=?,daysAllowed=? where catagory=?";
   // System.out.println(values[0]+"  "+values[1]);
    boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      PreparedStatement pst=con.prepareStatement(str);
        pst.setString(1,values[0]);
        pst.setInt(2,Integer.parseInt(values[1]));
        pst.setString(3,oldValue);
        int index=pst.executeUpdate();
        if(index>0)
        ok=true;
        
     pst.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }

 public static boolean updateDigit(String s)//
  {
      
    String str="update NextValue set account=?";
   int no=Integer.parseInt(s);
    boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      PreparedStatement pst=con.prepareStatement(str);
        pst.setDouble(1,Math.pow(10,no));
        System.out.println(""+Math.pow(10,no));
        int index=pst.executeUpdate();
        if(index>0)
        ok=true;
        
     pst.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
  
   public static java.sql.Date getDueDate(String id)
  {
        long days=0;
    try
    {
      con=DriverManager.getConnection(source);
      Statement ste=con.createStatement();
      ResultSet rs=null;
      String str="select * from Catagory where catagory='"+getItemInfo(id,"Catagory")+"'";
            
          rs=ste.executeQuery(str);
           //0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
          if(rs.next())
          {            
              days=rs.getInt("daysAllowed"); 
              //System.out.println("day="+days);
              rs.close();
              ste.close();
              con.close();
          }
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return (new java.sql.Date(System.currentTimeMillis()+1000*60*60*24*days));
  }

   public static Vector getSetting(String resid)
  {
    
    String str="";
    str="select * from Catagory where restaurantid=?";
    Vector data=new Vector();
    try
    {
      con=DriverManager.getConnection(source);
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,resid);
      ResultSet rs=ste.executeQuery();
      
      while(rs.next())
      {
       
          data.add(rs.getString("Catagory"));
       
      }
    rs.close();  
     ste.close();
     con.close();
     return data;
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return data;
  }
  public static boolean removeSetting(String value,String resid)
  {
    
    String str="";
    
    str="delete from Catagory where (restaurantid=? and catagory=?)";
    
    boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      PreparedStatement pst=con.prepareStatement(str);
        pst.setString(1,resid);
        pst.setString(2,value);
        int index=pst.executeUpdate();
        if(index>0)
        ok=true;
        
     pst.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
  
  public static boolean addSupplier(String[] basic)
  {
 
   /**0=spID,1-spName,2=spStreet,3=spUnit,4=spCity,5=spState,6=spZip,7=spCountry,8=spPhone,9=spFax,10=spEmail,11=spMobile
    * 12-spContactPerson,13=spCStreet,14=spCUnit,15=spCCity,16=spCState,17=spCZip,18=spCCountry,19=spCPhone,22=spCFax,20=spCEmail,21=spCMobile
    * 23-spWebsite,24-spDes,25-spNote.
   ss[1]=businessName_Res.getText().trim();
    ss[2]=street_Res.getText().trim();
    ss[3]=unit_Res.getText().trim();
    ss[4]=city_Res.getText().trim();
    ss[5]=state_Res.getSelectedItem().toString().trim();
    ss[6]=zip_Res.getText().trim();
    ss[7]=phone_Res.getText().trim();
    ss[8]=abn
    ss[9]=firstName_Res.getText().trim();
    ss[10]=lastName_Res.getText().trim();
    ss[11]=cellPhone_Res.getText().trim();
    ss[12]=phone3_Res.getText().trim();
    
    //*/
    String str="insert into restaurants  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      con.setAutoCommit(false);
      PreparedStatement pst=con.prepareStatement(str);
        pst.setString(1,basic[0]);
        pst.setString(2,basic[1]);
        pst.setString(3,basic[2]);
        pst.setString(4,basic[3]);
        pst.setString(5,basic[4]);
        pst.setString(6,basic[5]);     
        pst.setString(7,basic[6]);
        pst.setString(8,basic[7]);
        pst.setString(9,basic[8]);
        pst.setString(10,basic[9]);
        pst.setString(11,basic[10]);
        pst.setString(12,basic[11]);
        pst.setString(13,basic[12]);
         pst.setString(14,"");
        pst.setDate(15,new java.sql.Date(System.currentTimeMillis()));


        int index=pst.executeUpdate();
        if(index<0)
        {
          pst.close();
          con.rollback();
          con.setAutoCommit(true);
          con.close();
          return ok;
        }

        con.commit();
        con.setAutoCommit(true);
        pst.close();
        con.close();
        return true;
     
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
 
  public static boolean addCustomer(String[] basic)
  {
 
   /**
    ss[1]=customerID.getText().trim();
    ss[2]=firstName.getText().trim();
    ss[3]=lastName.getText().trim();
    ss[4]=un1.getText().trim();//street
    ss[5]=un2.getText().trim();//aparty
    ss[6]=city.getText().trim();
    ss[7]=state.getSelectedItem().toString().trim();
    ss[8]=un4.getText().trim();//zip
    ss[9]=phone_Res.getText().trim();    
    ss[0]=RESTAURANTID;
    
    //*/
    String str="insert into Customers  values (?,?,?,?,?,?,?,?,?,?,?)";
    boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      con.setAutoCommit(false);
      PreparedStatement pst=con.prepareStatement(str);
        
        pst.setString(1,basic[1]);
        pst.setString(2,basic[0]);
        pst.setString(3,basic[2]);
        pst.setString(4,basic[3]);
        pst.setString(5,basic[4]);
        pst.setString(6,basic[5]);     
        pst.setString(7,basic[6]);
        pst.setString(8,basic[7]);
        pst.setString(9,basic[8]);
        pst.setString(10,basic[9]);
        pst.setDate(11,new java.sql.Date(System.currentTimeMillis()));


        int index=pst.executeUpdate();
        if(index<=0)
        {
          pst.close();
          con.close();
          return ok;
        }

        con.commit();
        con.setAutoCommit(true);
        pst.close();
        con.close();
        return true;
     
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
   public static boolean updateCustomer(String[] basic)
  {
 
   /**0=accountNO,1-first,2=last,3=street,4=apt,5=city,6=state,7=zip,8=phone,9=createDate,10=EndDate,11=status
   ss[0]=customerID.getText().trim();
    ss[1]=firstName.getText().trim();
    ss[2]=lastName.getText().trim();
    ss[3]=un1.getText().trim();//street
    ss[4]=un2.getText().trim();//aparty
    ss[5]=city.getText().trim();
    ss[6]=state.getSelectedItem().toString().trim();
    ss[7]=un4.getText().trim();//zip
    ss[8]=phone_Res.getText().trim();    
    ss[9]=RESTAURANTID;
    //*/
    String str="update Customers  set firstName=?,LastName=?,Street=?,Apartment=?,city=?,state=?"+
                ",zip=?,phone=? where (restaurantid=? and customerid=?)";
    boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      con.setAutoCommit(false);
      PreparedStatement pst=con.prepareStatement(str);
        
       
        pst.setString(1,basic[2]);
        pst.setString(2,basic[3]);
        pst.setString(3,basic[4]);
        pst.setString(4,basic[5]);     
        pst.setString(5,basic[6]);
        pst.setString(6,basic[7]);
        pst.setString(7,basic[8]);
        pst.setString(8,basic[9]);
        pst.setString(9,basic[0]);
        pst.setString(10,basic[1]);


        int index=pst.executeUpdate();
        if(index<=0)
        {
          pst.close();
          con.rollback();
          con.setAutoCommit(true);
          con.close();
          return ok;
        }

        con.commit();
        con.setAutoCommit(true);
        pst.close();
        con.close();
        return true;
     
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
 
  public static Vector getMenu()//1=working,0=close,2=startup,3=open,4=all
  {
    Vector data=new Vector();
    String[] tem=new String[]{"aaa","bbb","ccc","ddd","eee"};
    data.add(tem);
    /*
    String str="select * from Items where AccountNo=?";
    try
    {
      con=DriverManager.getConnection(source);
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,accountNo);
      ResultSet rs=ste.executeQuery();
      while(rs.next())
      {
        tem=new String[4];
        //0==itemID,1=title,2=dateout,3=datedue
        tem[0]=rs.getString("ItemID");
        tem[1]=rs.getString("Title");
        tem[2]=rs.getDate("DateOut").toString();
        tem[3]=rs.getDate("DateDue").toString();
        data.add(tem);
      }
      rs.close();
      ste.close();
      con.close();
      return data;
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    //*/
    return data;
  }
  public static boolean orderStatusChange(String orderno)
  {
    boolean status=false;
    String str="UPDATE planning SET status=1 WHERE (order='"+orderno+"' AND status=2)";
      try
    {
      con=DriverManager.getConnection(source);
      Statement ste=con.createStatement();
      int in=ste.executeUpdate(str);
      ste.close();
      con.close();
      if(in>=1)
      status=true;
      return status;
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return false;
  }
  
  public static Vector getMeasureData()
  {
        String str="select * from measurement where status=1";
        String[] ss=null;
        Vector v=new Vector();

    try
      {
        con=DriverManager.getConnection(source);
        Statement ste=con.createStatement();
        str="select mc,position,stock,end,beamsize,measurement,"+
        "((select capacity/(RO*RO-RI*RI)*((RO-measurement)*(RO-measurement)-RI*RI) from emptybeam where size=beamsize)/end*453.6/"+
        "(select Rawm.size*Rawm.modify from Rawm where Rawm.stock=Measurement.stock)*9000/"+
       "((select (speed*efficiency/100) from MCS where MCS.MC=measurement.mc)/"+
        "(SELECT pick from styles where styles.styleno=(select styleno from mcs where MCS.MC=measurement.mc))/36*0.9199*60)),"+

        "(select sum([status])from beams where(status=1 and beams.stock=measurement.stock and beams.end=measurement.end)),"+

        "(select capacity/(RO*RO-RI*RI)*((RO-measurement)*(RO-measurement)-RI*RI) from emptybeam where size=beamsize)/end*453.6/"+
        "(select Rawm.size*Rawm.modify from Rawm where Rawm.stock=Measurement.stock)*9000*0.9199*"+
        "(SELECT (pick/Fpick) from styles where styles.styleno=(select styleno from mcs where MCS.MC=measurement.mc)),"+

        "hot,orderno from measurement where status=1";
        ResultSet rs=ste.executeQuery(str);
        long lon=0;
        while(rs.next())
        {
          ss=new String[12];
         // System.out.println("try0="+rs.getDouble(1));
          ss[0]=rs.getString("MC");
          ss[1]=""+rs.getByte("Position");
          ss[2]=rs.getString("Stock");
          ss[3]=""+rs.getInt("End");
          ss[4]=""+rs.getByte("BeamSize");
          ss[5]=""+rs.getDouble("Measurement");
          lon=(long)(rs.getDouble(7));
          ss[6]=""+(new java.sql.Date(System.currentTimeMillis()+lon*60*60*1000)).toString();//dateOUt
          ss[7]=""+rs.getInt(8);//Invertory
          ss[8]=""+(int)(rs.getDouble(9));//yard
          //System.out.println(ss[6]);
          ss[10]=rs.getString("hot");
          ss[11]=rs.getString("Orderno");//*/
          v.add(ss);
        }
        rs.close();
        ste.close();
        con.close();
       // System.out.println("try2");
        return v;
      }catch(SQLException sqle)
      {
        sqle.printStackTrace();
      }
    return null;

  }
 
  

  public static boolean updateItem(String[] ss)
  {
     boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      String str="update menu set name=?,price=?"+
                  ",hot=?,catagory=?,status=?,description=? where (restaurantID=? and itemid=?)";
      System.out.println(str);
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,ss[2]);
      ste.setDouble(2,Double.parseDouble(ss[3]));
      ste.setString(3,ss[4]);
      ste.setString(4,ss[5]);
      ste.setString(5,ss[6]);
      ste.setString(6,ss[7]);
      ste.setString(7,ss[0]);
      ste.setString(8,ss[1]);
      int ind=ste.executeUpdate();
      if(ind>0)
      {
        ok=true;
      }
     ste.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;

  }
  
   public static boolean updateRestaurant(String[] ss)
  {
  
   /**0=accountNO,1-first,2=last,3=street,4=apt,5=city,6=state,7=zip,8=phone,9=createDate,10=EndDate,11=status
   ss[1]=businessName_Res.getText().trim();
    ss[2]=street_Res.getText().trim();
    ss[3]=unit_Res.getText().trim();
    ss[4]=city_Res.getText().trim();
    ss[5]=state_Res.getSelectedItem().toString().trim();
    ss[6]=zip_Res.getText().trim();
    ss[7]=phone_Res.getText().trim();
    ss[8]=abn
    ss[9]=firstName_Res.getText().trim();
    ss[10]=lastName_Res.getText().trim();
    ss[11]=cellPhone_Res.getText().trim();
    ss[12]=phone3_Res.getText().trim();
    
    //*/
     boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      String str="update Restaurants set businessName=?,street=?"+
                  ",unit=?,city=?,state=?,zip=?,phone=?,ABName=?,firstName=?,lastName=?,cellPhone=?,phone3=? where restaurantID=?";
      
      PreparedStatement ste=con.prepareStatement(str);
      
      ste.setString(1,ss[1]);
      ste.setString(2,ss[2]);
      ste.setString(3,ss[3]);
      ste.setString(4,ss[4]);
      ste.setString(5,ss[5]);
      ste.setString(6,ss[6]);
      ste.setString(7,ss[7]);
      ste.setString(8,ss[8]);
      ste.setString(9,ss[9]);
      ste.setString(10,ss[10]);
      ste.setString(11,ss[11]);
      ste.setString(12,ss[12]);
      ste.setString(13,ss[0]);
      
      
      
      int ind=ste.executeUpdate();
    
      if(ind>0)
      {
        ok=true;
      }
     ste.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;

  }
  
  public static String deleteItem(String[] itid,String[] resid)
  {
     String ok=null;
    try
    {
      con=DriverManager.getConnection(source);
       //0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay
      String str="delete from menu  where (restaurantid=? and itemid=?)";
      PreparedStatement ste=con.prepareStatement(str);
      for(int i=0;i<itid.length;i++)
      {
          ste.setString(1,resid[i]);
          ste.setString(2,itid[i]);
          int ind=ste.executeUpdate();
          if(ind<=0)
          {
            if(ok==null)
            ok="The Following item failed to delete from database:\nRestaurant ID:"+resid[i]+", ItemID:"+itid[i];
            else
            ok=ok+"\nRestaurant ID:"+resid[i]+", ItemID:"+itid[i];
          }
      }
     ste.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
  
   public static String deleteRestaurant(String[] itid)
  {
     String ok=null;
    try
    {
      con=DriverManager.getConnection(source);
       //0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay
      String str="delete from Restaurants  where restaurantid=?";
      System.out.println(str);
      PreparedStatement ste=con.prepareStatement(str);
      for(int i=0;i<itid.length;i++)
      {
          ste.setString(1,itid[i]);
          int ind=ste.executeUpdate();
          if(ind<0)
          {
            if(ok==null)
            ok="The Following item failed to delete from database:\nRestaurant ID:"+itid[i];
            else
            ok=ok+"\nRestaurant ID:"+itid[i];
          }
      }
     ste.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
  
  public static boolean updateAccount(String[] ss)
  {
     //0=accountNO,1-first,2=last,3=street,4=apt,5=city,6=state,7=zip,8=phone,9=createDate,10=EndDate,11=status
     boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      String str="update customers set firstName=?,lastName=?,Street=?"+
                  ",apartment=?,city=?,State=?,zip=?,phone=? where accountNo=?";
      System.out.println(str);
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,ss[1]);
      ste.setString(2,ss[2]);
      ste.setString(3,ss[3]);
      ste.setString(4,ss[4]);
      ste.setString(5,ss[5]);
      ste.setString(6,ss[6]);
      ste.setString(7,ss[7]);
      ste.setString(8,ss[8]);
      ste.setString(9,ss[0]);
      int ind=ste.executeUpdate();
      if(ind>0)
      {
        ok=true;
      }
     ste.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;


  }
  public static String[] getMeasueUpdate(String[] ss)
  {
     String[] out=new String[3];
    try
    {
      con=DriverManager.getConnection(source);
       String str="select((select capacity/(RO*RO-RI*RI)*((RO-measurement)*(RO-measurement)-RI*RI) from emptybeam where size=beamsize)/end*453.6/"+
        "(select Rawm.size*Rawm.modify from Rawm where Rawm.stock=Measurement.stock)*9000/"+
       "((select (speed*efficiency/100) from MCS where MCS.MC=measurement.mc)/"+
        "(SELECT pick from styles where styles.styleno=(select styleno from mcs where MCS.MC=measurement.mc))/36*0.9199*60)),"+

        "(select sum([status])from beams where(status=1 and beams.stock=measurement.stock and beams.end=measurement.end)),"+

        "(select capacity/(RO*RO-RI*RI)*((RO-measurement)*(RO-measurement)-RI*RI) from emptybeam where size=beamsize)/end*453.6/"+
        "(select Rawm.size*Rawm.modify from Rawm where Rawm.stock=Measurement.stock)*9000*0.9199*"+
        "(SELECT (pick/Fpick) from styles where styles.styleno=(select styleno from mcs where MCS.MC=measurement.mc))"+

        " from measurement where (mc='"+ss[0]+"' and position="+ss[1]+")";
      Statement ste=con.createStatement();
      ResultSet rs=ste.executeQuery(str);
      if(rs.next())
      {

          long lon=(long)(rs.getDouble(1));
          out[0]=""+(new java.sql.Date(System.currentTimeMillis()+lon*60*60*1000)).toString();//dateOUt
          out[1]=""+rs.getInt(2);
          out[2]=""+(int)(rs.getDouble(3));
      }
     ste.close();
     con.close();
     return out;
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return null;


  }
  

   public static String setInActive(String[] ss)
  {
    String ok=null;
           try
    {
      con=DriverManager.getConnection(source);
       String str="update customers set status='InActive' where accountno=?";
      PreparedStatement ste=con.prepareStatement(str);         
        for(int i=0;i<ss.length;i++)
      {
          ste.setString(1,ss[i]);
          int ind=ste.executeUpdate();
          if(ind<0)
          {
            if(ok==null)
            ok="The Following item failed to set InActive from database:\nAccount#:";
            else
            ok=ok+"\nAccount#:"+ss[i];
          }
      }
     ste.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }
   public static boolean setLocalPort(String s)
  {
    boolean result=false;
           try
    {
      con=DriverManager.getConnection(source);
      
     
      String str="update locals set localPort=?";
      PreparedStatement ste=con.prepareStatement(str);
            ste.setString(1,s);
          int ind=ste.executeUpdate();
          if(ind>0)
          {
            result=true;
          }
          ste.close();
          con.close();
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return result;
  }
 /** 
  public static long getOrderID()
  {
           try
    {
      con=DriverManager.getConnection(source);
      Statement ste=con.createStatement();
      ResultSet rs=null;
      String str="select max(TransactionNO) from Transactions";
      long result=0;      
          rs=ste.executeQuery(str);
          if(rs.next())
          {
              result=rs.getLong(1);
              rs.close();
              ste.close();
              con.close();
              return result;
          }
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return 0;
  }
  //*/
  public static String getABName(String id)
  {
      
      String s="";
      
           try
    {
      con=DriverManager.getConnection(source);
      
      ResultSet rs=null;
      String str="select * from Restaurants where RestaurantID=?";
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,id);   
          rs=ste.executeQuery();
          if(rs.next())
          {
              
              s=rs.getString("ABName");
              rs.close();
              ste.close();
              con.close();
              return s;
          }
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return s;
  }

   public static long getNextValue(String id,String resid)
  {
      
      long s=0;
      
           try
    {
      con=DriverManager.getConnection(source);
     
      ResultSet rs=null;
      String str="select * from NextValue where restaurantid=?";
       PreparedStatement ste=con.prepareStatement(str);
       ste.setString(1,resid);
            
          rs=ste.executeQuery();
          if(rs.next())
          {
              
              s=(long)(rs.getDouble(id));
              rs.close();
              ste.close();
              con.close();
              p.p("resid="+resid+" s="+s+"  id="+id);
              return s;
          }
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return s;
  }

  public static boolean checkForItemID(String itemid,String resid,String type)
  {
     boolean result=false;
           try
    {
      con=DriverManager.getConnection(source);
      
      ResultSet rs=null;
      String str="";
      if(type.equalsIgnoreCase("AccountNO"))
      str="select * from customers where (restaurantid=? and customerID=?)";
      if(type.equalsIgnoreCase("ItemID"))
      str="select * from menu where (restaurantid=? and itemID=?)";
      PreparedStatement ste=con.prepareStatement(str);
       ste.setString(1,resid); 
       ste.setString(2,itemid); 
          rs=ste.executeQuery();
        
          if(rs.next())
          {
              result=true;
             
          }
           rs.close();
          ste.close();
              con.close();
        return result;
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();
      JOptionPane.showMessageDialog(null,"unknown,database connection problem");

    }
    return true;
  } 

   public static boolean checkForValid(String id,String type)
  {
     boolean result=false;
           try
    {
      con=DriverManager.getConnection(source);
      
      ResultSet rs=null;
      String str="";
      if(type.equalsIgnoreCase("ItemID"))
      str="select * from menu where itemid=?";
      if(type.equalsIgnoreCase("RestaurantID"))
      str="select * from Restaurants where Restaurantid=?";
      PreparedStatement ste=con.prepareStatement(str);
       ste.setString(1,id);     
          rs=ste.executeQuery();
        
          if(rs.next())
          {
              result=true;
             
          }
           rs.close();
          ste.close();
              con.close();
        return result;
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();
      JOptionPane.showMessageDialog(null,type+" unknown,database connection problem");

    }
    return true;
  }

  
  public static String[] getItem(String itemid,String resid)
  {
      String[] ss=new String[7];
    try
    {
      con=DriverManager.getConnection(source);
      
      ResultSet rs=null;
      String str="select * from menu where (restaurantid=? and itemid=?)";
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,resid);
      ste.setString(2,itemid);    

          rs=ste.executeQuery();
          //0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay,8=status,9=account
          if(rs.next())
          {
            
              ss[0]=(rs.getString("ItemID")).trim();
              ss[1]=(rs.getString("Name")).trim();
              ss[2]=""+rs.getDouble("Price");
              ss[3]=(rs.getString("Hot")).trim();
              ss[4]=(rs.getString("Catagory")).trim();             
              ss[5]=(rs.getString("Status")).trim();
              ss[6]=(rs.getString("Description")).trim();
              rs.close();
              ste.close();
              con.close();
              return ss;
          }

    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return ss;

  }
  public static void addErrorMessage(String s)
  {

  }

  public static void toHistory(Vector returns)
  {
        String[] basic=new String[8];
        String str="insert into History values(?,?,?,?,?,?)";
        
    try
    {
      con=DriverManager.getConnection(source);
      PreparedStatement pst=con.prepareStatement(str);
      for(int i=0;i<returns.size();i++)
      { 
        basic=(String[])(returns.get(i));
        pst.setString(1,basic[0]);
        pst.setString(2,basic[5]);
        pst.setDate(3,new java.sql.Date(System.currentTimeMillis()));
        pst.setString(4,basic[2]);
        pst.setString(5,basic[7]);
        pst.setString(6,basic[6]);     
        
        int index=pst.executeUpdate();
        System.out.println("tohistory= "+basic[5]+"  index="+index);

      }
        pst.close();
        con.close();
        
     
//     if(!Database.updateNextValue("Account",(acct+1)))
//     JOptionPane.showMessageDialog(null,"NextAccountNo update failed");
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
  }
   public static String getItemInfo(String id,String type)
  {
             try
    {
      con=DriverManager.getConnection(source);
      
      ResultSet rs=null;
      String str="select * from Items where itemID=?";
       PreparedStatement ste=con.prepareStatement(str);
          ste.setString(1,id);  
          rs=ste.executeQuery();     
          if(rs.next())
          {   
              if(type.equalsIgnoreCase("DateOut"))
              str=(rs.getDate(type)).toString();
              else if(type.equalsIgnoreCase("Points"))
              str=""+rs.getInt(type);
              else
              str=(rs.getString(type)).trim();
              rs.close();
              ste.close();
              con.close();
              return str;
          }
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return null;
  }

  
   public static boolean setGreetingMessage(String message)
  {  
  boolean ok=false;
    try
    {
      con=DriverManager.getConnection(source);
      String str="update NextValue set greeting=?";
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,message);
      int ind=ste.executeUpdate();
      if(ind>0)
      {
        ok=true;
      }
     ste.close();
     con.close();
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
   return ok;
  }

 
   public static Vector getUsers()
  {
      
     
      return null;
  }
  public static int getStep(String user,char[] psw)
  {
      
     
      return 0;
  }
   public static Vector getSaleRecords(String resid,String cusid,java.sql.Date begin)
  {
  /**
    ss[0]=resid;
    ss[1]=customerID.getText().trim();
    ss[2]=firstName.getText().trim();
    ss[3]=lastName.getText().trim();
    ss[4]=un1.getText().trim();//street
    ss[5]=un2.getText().trim();//aparty
    ss[6]=city.getText().trim();
    ss[7]=state.getSelectedItem().toString().trim();
    ss[8]=un4.getText().trim();//zip
    ss[9]=phone_Res.getText().trim();
  //*/
  Vector data=new Vector();
  double to=0;
  //int ti=0;
    String[] ss=new String[9];
    try
    {
      con=DriverManager.getConnection(source);
      String str="";
      if(begin==null)
      {
                 if(cusid==null||cusid.equalsIgnoreCase("ALL"))
                str="select (select FirstName from customers where (customers.customerID=Transactions.customerID "+
                "And customers.RestaurantID=Transactions.RestaurantID))"+
                ",(select LastName from customers where (customers.customerID=Transactions.customerID "+
                "And customers.RestaurantID=Transactions.RestaurantID))"+
                ",Name,unitprice,DateCompleted,transactionno from Transactions where RestaurantID=?";
                else
                str="select (select FirstName from customers where (customers.customerID=Transactions.customerID "+
                "And customers.RestaurantID=Transactions.RestaurantID))"+
                ",(select LastName from customers where (customers.customerID=Transactions.customerID "+
                "And customers.RestaurantID=Transactions.RestaurantID))"+
                ",Name,unitprice,DateCompleted,transactionNO from Transactions where (RestaurantID=? and CustomerID=?)";
      }else
      {
                if(cusid==null||cusid.equalsIgnoreCase("ALL"))
                str="select (select FirstName from customers where (customers.customerID=Transactions.customerID "+
                "And customers.RestaurantID=Transactions.RestaurantID))"+
                ",(select LastName from customers where (customers.customerID=Transactions.customerID "+
                "And customers.RestaurantID=Transactions.RestaurantID))"+
                ",Name,unitprice,DateCompleted,transactionno from Transactions where (RestaurantID=? and DateCompleted >=?";
                else
                str="select (select FirstName from customers where (customers.customerID=Transactions.customerID "+
                "And customers.RestaurantID=Transactions.RestaurantID))"+
                ",(select LastName from customers where (customers.customerID=Transactions.customerID "+
                "And customers.RestaurantID=Transactions.RestaurantID))"+
                ",Name,unitprice,DateCompleted,transactionNO from Transactions where (RestaurantID=? and CustomerID=? and DateCompleted >=?)";
      }
      ResultSet rs=null;
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,resid);
      if(cusid!=null&&!cusid.equalsIgnoreCase("ALL"))
      ste.setString(2,cusid);
      if(begin!=null)
      {
         ste.setDate(3,begin);
         p.p(begin.toString());
      }
      
     
           
          rs=ste.executeQuery();
           //0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
           p.p("Resid"+resid+",   "+cusid);
          while(rs.next())
          {
                
              ss=new String[6];
              ss[0]=(rs.getString(1));//.trim();
              ss[1]=(rs.getString(2));//.trim();
              ss[2]=(rs.getString(3));//.trim();
              to=rs.getDouble(4);
              ss[3]=""+to;
              Object o=rs.getDate(5);
              if(o==null)
              ss[4]="";
              else
              ss[4]=o.toString();
              ss[5]=""+rs.getLong(6);
              data.add(ss);
              
          }
          
          //if(total!=null)
 //         total=Double.valueOf(""+to);
 //         time=Integer.valueOf(""+ti);
          rs.close();
          ste.close();
          con.close();
   //       p.p("dt="+total.doubleValue());
          return data;
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return data;
  }
  public static Vector getCustomers(String id,String cusid)
  {
  /**
    ss[0]=resid;
    ss[1]=customerID.getText().trim();
    ss[2]=firstName.getText().trim();
    ss[3]=lastName.getText().trim();
    ss[4]=un1.getText().trim();//street
    ss[5]=un2.getText().trim();//aparty
    ss[6]=city.getText().trim();
    ss[7]=state.getSelectedItem().toString().trim();
    ss[8]=un4.getText().trim();//zip
    ss[9]=phone_Res.getText().trim();
  //*/
  Vector data=new Vector();
    String[] ss=new String[9];
    try
    {
      con=DriverManager.getConnection(source);
      String str="";
      if(cusid==null||cusid.equalsIgnoreCase("ALL"))
      str="select * from Customers where RestaurantID=?";
      else
      str="select * from Customers where (RestaurantID=? and customerid=?)";
      ResultSet rs=null;
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,id);
      if(cusid!=null&&!cusid.equalsIgnoreCase("ALL"))
      ste.setString(2,cusid);
      
            
          rs=ste.executeQuery();
           //0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
          while(rs.next())
          {
                
              ss=new String[9];
              ss[0]=(rs.getString("customerid")).trim();
              ss[1]=(rs.getString("FirstName")).trim();
              ss[2]=(rs.getString("LastName")).trim();
              ss[3]=(rs.getString("Street")).trim();
              ss[4]=(rs.getString("Apartment")).trim();
              ss[5]=(rs.getString("City")).trim();
              ss[6]=(rs.getString("State")).trim();
              ss[7]=(rs.getString("Zip")).trim();
              ss[8]=(rs.getString("Phone")).trim();
              data.add(ss);
              
          }
          rs.close();
          ste.close();
          con.close();
          return data;
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return data;
  }
  public static String getItemStatus(String id)
  {
     String s="";
    try
    {
      con=DriverManager.getConnection(source);
     
      ResultSet rs=null;
      String str="select * from Items where itemid=?";
      PreparedStatement ste=con.prepareStatement(str);
          ste.setString(1,id);  
          rs=ste.executeQuery();  
            
          rs=ste.executeQuery(str);
           //0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
          if(rs.next())
          {
            
              s=(rs.getString("Status")).trim();
              rs.close();
              ste.close();
              con.close();
              return s;
          }
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return s;
  }
  
   public static String[] getRestaurants(String id,String status)
  {
    
      String[] ss=null;
           try
    {
      con=DriverManager.getConnection(source);
      String str="select * from Restaurants where RestaurantID=? ";
      PreparedStatement ste=con.prepareStatement(str);
      ste.setString(1,id);
      ResultSet rs=ste.executeQuery();
          if(rs.next())
          {
              if(status.equalsIgnoreCase("Detail"))
              ss=new String[14];
              else  if(status.equalsIgnoreCase("Summary"))
              ss=new String[9];
              else  if(status.equalsIgnoreCase("Browse"))
              ss=new String[13];
              ss[0]=(rs.getString("restaurantID")).trim();
              ss[1]=(rs.getString("Businessname")).trim();
              ss[2]=(rs.getString("City")).trim();
              ss[3]=(rs.getString("State")).trim();
              ss[4]=rs.getString("Zip").toString();
              ss[5]=(rs.getString("Phone")).trim();
              ss[6]=(rs.getString("ABName")).trim();
              ss[7]=(rs.getString("FirstName")).trim();
              ss[8]=(rs.getString("LastName")).trim();
              if(status.equalsIgnoreCase("Browse"))
              {    
                ss[9]=(rs.getString("Street")).trim();
                ss[10]=(rs.getString("unit")).trim();
                ss[11]=(rs.getString("CellPhone")).trim();
                ss[12]=(rs.getString("Phone3")).trim();
              }
             
          }

              rs.close();
              ste.close();
              con.close();
              return ss;
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return ss;
  }

  public static Vector getRestaurants(String status)
  {
      Vector data=new Vector();
      String[] ss=null;
           try
    {
      con=DriverManager.getConnection(source);
      Statement ste=con.createStatement();
      ResultSet rs=null;
      String str=null;
      
      str="select * from Restaurants ";
      Object o=null;
            
          rs=ste.executeQuery(str);
            //0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay,8=status,9=account
          while(rs.next())
          {
              if(status.equalsIgnoreCase("Detail"))
              ss=new String[14];
              else  if(status.equalsIgnoreCase("Summary"))
              ss=new String[9];
              else  if(status.equalsIgnoreCase("Browse"))
              ss=new String[12];
              ss[0]=(rs.getString("restaurantID")).trim();
              ss[1]=(rs.getString("Businessname")).trim();
              ss[2]=(rs.getString("City")).trim();
              ss[3]=(rs.getString("State")).trim();
              ss[4]=rs.getString("Zip").toString();
              ss[5]=(rs.getString("Phone")).trim();
              ss[6]=(rs.getString("ABName")).trim();
              ss[7]=(rs.getString("FirstName")).trim();
              ss[8]=(rs.getString("LastName")).trim();
              data.add(ss);
              
          }

              rs.close();
              ste.close();
              con.close();
              return data;
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return data;
  }
  
  public static Vector getMenu(String resID,String catagory)
  {
      Vector data=new Vector();
      String[] ss=null;
           try
    {
      con=DriverManager.getConnection(source);
      String str=null;
      if(catagory==null||catagory.equalsIgnoreCase("ALL"))
      str="select * from menu where restaurantID=?";
      else
      str="select * from menu where (restaurantID=? and catagory=?)";
      PreparedStatement ste=con.prepareStatement(str);
     
      ResultSet rs=null;
      ste.setString(1,resID);
      if(catagory!=null && !catagory.equalsIgnoreCase("ALL"))
      ste.setString(2,catagory);
      rs=ste.executeQuery();
           //0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
          while(rs.next())
          {
              ss=new String[6];
              ss[0]=(rs.getString("ItemID")).trim();
              ss[1]=(rs.getString("Name")).trim();
              ss[2]=""+rs.getDouble("Price");
              ss[3]=(rs.getString("Hot")).trim();
              ss[4]=rs.getString("Catagory").toString();
              ss[5]=(rs.getString("Status")).trim();
              data.add(ss);             
          }

              rs.close();
              ste.close();
              con.close();
              return data;
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return data;
  }
  public static Vector search(String status,String type)
  {
      Vector data=new Vector();
      String[] ss=null;
           try
    {
      con=DriverManager.getConnection(source);
      Statement ste=con.createStatement();
      ResultSet rs=null;
      String str=null;
      if(type.equalsIgnoreCase("Account"))
      {
      str="select * from History where accountno='"+status+"'";
      ss=new String[4];
      }
      else if(type.equalsIgnoreCase("ItemID"))
      {
        str="select History.accountno,customers.firstname,customers.lastname,history.dateout,history.datein from History,customers where ((history.itemID='"+status+"') and (history.accountno=customers.accountno))";;
        ss=new String[5];
        
      }      
          rs=ste.executeQuery(str);
           //0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
          while(rs.next())
          {
              if(type.equalsIgnoreCase("Account"))
              {
              ss=new String[4];
              ss[0]=(rs.getString(1)).trim();
              ss[1]=getItemInfo(ss[0],"Title");
              ss[2]=(rs.getDate(2)).toString();
              ss[3]=(rs.getDate(3)).toString();
              }else if(type.equalsIgnoreCase("ItemID"))
              {
                ss=new String[5];
                ss[0]=(rs.getString(1)).trim();
                ss[1]=(rs.getString(2)).trim();
                ss[2]=(rs.getString(3)).trim();             
                ss[3]=(rs.getDate(4)).toString();
                ss[4]=(rs.getDate(5)).toString();
             // System.out.println(ss[3]+"  "+ss[4]);
              }
         
              
              data.add(ss);
              
                         
          }

              rs.close();
              ste.close();
              con.close();
              return data;
    
    }catch(SQLException sqle)
    {
      sqle.printStackTrace();

    }
    return data;
  }
 
 
}
