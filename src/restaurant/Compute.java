package restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface Compute extends Remote 
{
    Vector getMenu(String resid,String catagory) throws RemoteException;
    Boolean ask(String resid,String side,String ip) throws RemoteException;
    String addSaleRecord(Vector saleData,String resid,String cusid) throws RemoteException;
    void phoneRing(String resid,String phoneno,String firstname,String lastname,String midname) throws RemoteException;
    Boolean login(String resid,String password) throws RemoteException;
    Boolean endOp(String resid,String type,String location) throws RemoteException; 
    Vector getHistory(String resid,String accountno,java.sql.Date begin) throws RemoteException;
}
