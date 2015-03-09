package restaurant;

/* Author: Zule Li
 * Email:zule.li@hotmail.com
 * Last Modified Date:Mar.7,2015
 * */
import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

public class ComputeEngine extends UnicastRemoteObject implements Compute {
	private MainS mn;

	public ComputeEngine(MainS mn) throws RemoteException {
		super();
		this.mn = mn;
	}

	public Vector getMenu(String resid, String catagory) {
		mn.addRestaurant(resid, "O");
		return Database.getMenu(resid, catagory);
	}

	public String addSaleRecord(Vector saleData, String resid, String cusid) {
		return Database.addTransactions(saleData, resid, cusid);
	}

	public Boolean ask(String resid, String location, String ip) {
		String[] ss = new String[4];
		Vector tem = mn.waiting;
		String[] ssN = Database.getRestaurants(resid, "Summary");
		for (int i = 0; i < mn.customerModel.size(); i++) {
			String s = (String) (mn.customerModel.getElementAt(i));
			int ind = s.indexOf("@");
			if (ind >= 0) {
				s = s.substring(0, ind);
			}
			if (s.equals(ssN[1] + "_" + location)) {
				ss = (String[]) (tem.get(i));
				ss[3] = "" + (Integer.parseInt(ss[3]) + 1);
				mn.customerModel.removeElementAt(i);
				mn.customerModel.add(i, ssN[1] + "_" + location + "@" + ss[3]);
				return Boolean.FALSE;
			}
		}
		ss = new String[4];
		ss[0] = resid;
		ss[1] = location;
		ss[2] = ip;
		ss[3] = "1";
		tem.add(ss);

		mn.customerModel.addElement(ssN[1] + "_" + location);
		P.p("IP=" + ss[2]);
		return Boolean.FALSE;
	}

	public void phoneRing(String resid, String phoneno, String firstname,
			String lastname, String midname) {
	}

	public Boolean login(String resid, String password) {
		return Boolean.valueOf(true);
	}

	public Vector getHistory(String resid, String accountno, java.sql.Date begin) {
		Vector tem = Database.getSaleRecords(resid, accountno, begin);
		String[] ss0, ss1;
		Vector data = new Vector();
		for (int i = 0; i < tem.size(); i++) {
			ss1 = new String[3];
			ss0 = (String[]) tem.get(i);
			ss1[0] = ss0[4];
			ss1[1] = ss0[3];
			if (i == 0) {
				data.add(ss1);
			} else {
				boolean same = false;
				for (int j = 0; j < data.size(); j++) {
					ss0 = (String[]) (data.get(j));
					if (ss0[0].equalsIgnoreCase(ss1[0])) {
						ss0[1] = ""
								+ (Double.parseDouble(ss0[1]) + Double
										.parseDouble(ss1[1]));
						same = true;
						break;
					}
				}
				if (!same) {
					data.add(ss1);
				}

			}
		}

		return data;
	}

	public Boolean endOp(String resid, String type, String location) {
		mn.endOp(resid, type, location);
		return Boolean.valueOf(true);
	}

}
