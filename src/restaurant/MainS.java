package restaurant;

import javax.swing.*;
import oracle.jdeveloper.layout.XYLayout;
import oracle.jdeveloper.layout.XYConstraints;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class MainS extends JFrame implements ActionListener,ListSelectionListener
{
  private JPanel upPane = new JPanel();
  private JPanel videoWindow = new JPanel();
  
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JScrollPane jScrollPane2 = new JScrollPane();
 
  private JLabel jLabellname = new JLabel();
  private JLabel PL = new JLabel();
  
  private JLabel jLabel1 = new JLabel();
 
  private JLabel phone1 = new JLabel();
 
  private JLabel jLabellname1 = new JLabel();
  
  private JLabel jLabellname2 = new JLabel();
  
  
  private JLabel jLabel3 = new JLabel();
 
  private JLabel jLabel2 = new JLabel();
 
  private JLabel customerIDxx = new JLabel();
  
  private JLabel jLabellname3 = new JLabel();
 
  private JPanel jPanel5 = new JPanel();
  private JScrollPane jScrollPane3 = new JScrollPane();
 
  private JPanel jPanel3 = new JPanel();
  private JLabel jLabel4 = new JLabel();
  
  
  
   private JComboBox state = new JComboBox();
    private JTextPane dishDescrption = new JTextPane();
  private JTextField orderID,subTotal,customerID,detuct,status_menu,price_menu,itemID_menu,name_menu;
  private JTextField phone,street,apt,zip,grandTotal,un6;
   private JTable restaurantTable,saleTable,menuTable,menuTable_menu,restaurantTable_Res,customerTable_cus;
   private TModel menuModel,saleModel;
   private TModel restaurantTableModel,menuTable_menuModel,restaurantTable_ResModel,customerTable_cusModel;
   
   private JTextField newCatagory_menu,lastName,city,firstName,zip_Res,customerID_Res,businessName_Res,cellPhone_Res;
   private JTextField phone3_Res,abName_Res,lastName_Res,street_Res,unit_Res,city_Res,phone_Res,firstName_Res,total_cus;
   
  private JScrollPane jScrollPane4 = new JScrollPane();
 
  private JLabel dishPicture = new JLabel();
  
  private JRadioButton goOrStay = new JRadioButton();
  private JRadioButton delivery = new JRadioButton();
  
   private JButton update,saleAdd,saleDelete,saleConfirm;
   private JButton update_menu,add_menu,delete_menu,catagoryAdd_menu,catagoryDelete_menu,capture_menu;
   
  
  private JComboBox catagory_menu = new JComboBox();
  private JRadioButton hot_menu = new JRadioButton();
  
  
   
  private JTabbedPane tabbed=new JTabbedPane();
  private JTextPane important = new JTextPane();
  private JRadioButton phoneContact = new JRadioButton();
  private JRadioButton outsideCustomer = new JRadioButton();
  private JRadioButton insideCustomer = new JRadioButton();
 
 
  
   private JComboBox state_Res = new JComboBox();
  
   private JButton update_Res = new JButton();
 
  private JButton add_Res = new JButton();
  private JButton delete_Res = new JButton();
 
   private JButton customerList_cus = new JButton();
  private JButton saleRecord_cus = new JButton();
  private JComboBox customerID_cus = new JComboBox();
  
   private JComboBox restaurantID_cus = new JComboBox();
   private String RESTAURANTID="NA";
  private boolean NEWCUSTOMER=false;
   private Vector resID=new Vector();
    private JList catagoryEditor_menu,customer,restaurant,catagory;
   private DefaultListModel catagoryEditor_menuModel,restaurantModel,catagoryModel;
   public DefaultListModel customerModel;
   private ListSelectionModel lsm_Res,lsm_menu,lsm_cus;
   private long currentValue=0;
   private double subT=0;
   public Vector waiting=new Vector();
  
  
  
  
  private JPanel downPane = new JPanel();
 
  private JScrollPane jScrollPane5 = new JScrollPane();
  private JScrollPane jScrollPane6 = new JScrollPane();
  private JScrollPane jScrollPane7 = new JScrollPane();
  
 
  private JScrollPane jScrollPane8 = new JScrollPane();
  private JScrollPane jScrollPane9 = new JScrollPane();
 
  
  
  private JLabel jLabel5 = new JLabel();
  private JLabel jLabel6 = new JLabel();
  
 
  
  
  //***menupane
  private JPanel menuEnterPane = new JPanel();
  private JLabel jLabel_menu = new JLabel();
  private JLabel desc_menu = new JLabel();
 
  private JLabel jLabel1_menu = new JLabel();
  private JLabel jLabellname3menu = new JLabel();
  
 
   
   
    private JPanel jPanel5_menu = new JPanel();
  private JScrollPane jScrollPane6_menu = new JScrollPane();
  private JLabel jLabel2_menu = new JLabel();
   private JTextPane description_menu = new JTextPane();
  private JScrollPane jScrollPane2_menu = new JScrollPane();
   private JLabel jLabel4_menu = new JLabel();
  private JScrollPane jScrollPane3_menu = new JScrollPane();
  private JScrollPane jScrollPane1_menu = new JScrollPane();
  private XYLayout xYLayout1 = new XYLayout();
  private JPanel jPanel1_menu = new JPanel();
  private GridBagLayout gridBagLayout1_menu = new GridBagLayout();
  private JPanel jPanel2_menu = new JPanel();
  private GridBagLayout gridBagLayout2_menu = new GridBagLayout();
  private JPanel jPanel3_menu = new JPanel();
  private GridBagLayout gridBagLayout3_menu = new GridBagLayout();
  private GridBagLayout gridBagLayout4 = new GridBagLayout();
  private JScrollPane scr_menu = new JScrollPane();
  private GridBagLayout gridBagLayout5_menu = new GridBagLayout();
  private GridBagLayout gridBagLayout3 = new GridBagLayout();
  private JPanel jPanel8 = new JPanel();
  private GridBagLayout gridBagLayout5 = new GridBagLayout();
  private JPanel jPanel9 = new JPanel();
  private GridBagLayout gridBagLayout6 = new GridBagLayout();
  private GridBagLayout gridBagLayout7 = new GridBagLayout();
  private JScrollPane jScrollPane10 = new JScrollPane();
  private JPanel jPanel10 = new JPanel();
  private GridBagLayout gridBagLayout2 = new GridBagLayout();
  private JPanel jPanel6 = new JPanel();
  private GridBagLayout gridBagLayout8 = new GridBagLayout();
  private JScrollPane jScrollPane11 = new JScrollPane();
  private JScrollPane jScrollPane12 = new JScrollPane();
  private GridBagLayout gridBagLayout9 = new GridBagLayout();
  private JPanel jPanel2 = new JPanel();
  private XYLayout xYLayout4 = new XYLayout();
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private GridBagLayout gridBagLayout10 = new GridBagLayout();
  private JScrollPane scrDown = new JScrollPane();
  private JScrollPane scrUp = new JScrollPane();
  
  //restaurant:
   private JPanel restaurantPane = new JPanel();
  private JLabel jLabellname_Res = new JLabel();
  private JLabel jLabel_Res = new JLabel();
  
  private JLabel jLabel1_Res = new JLabel();
  
  private JLabel jLabelll_Res = new JLabel();
  
  private JLabel jLabellname1_Res = new JLabel();
  
  private JLabel jLabelln_Res = new JLabel();
  
  private JLabel jLabel3_Res = new JLabel();
 
  private JLabel jLabel2_Res = new JLabel();
 
  private JLabel customerIDxx_Res = new JLabel();
  
  private JLabel jLabell_Res = new JLabel();
 
  private JPanel jPanel5_Res = new JPanel();
  private JScrollPane jScrollPane6_Res = new JScrollPane();
  
  
  
  private JLabel jLabel5_Res = new JLabel();
  private JLabel jLabel6_Res = new JLabel();
    private JLabel jLabel4_Res = new JLabel();
  
  private GridBagLayout gridBagLayout1_Res = new GridBagLayout();
  private BorderLayout borderLayout1 = new BorderLayout();
  
  
  //customerPane
  
   private JPanel customerPane = new JPanel();
  private JScrollPane jScrollPane6_cus = new JScrollPane();
  
  private JPanel control_cus = new JPanel();
 
  private JLabel jLabel1_cus = new JLabel();
 
  
  private JLabel jLabel1_cus1 = new JLabel();
  private JLabel jLabel13_cus = new JLabel();
  
  private GridBagLayout gridBagLayout1_cus = new GridBagLayout();
  private BorderLayout borderLayout1_cus = new BorderLayout(); 
  
   private void initial()
  {

   
    String[] columnNames=new String[]{"ItemID","Name","Price","Hot","Catagory","Note"};
    boolean[] edit=new boolean[]{false,false,false,false,false,false};
    menuModel=new TModel(columnNames,edit);
    menuModel.setData(Database.getMenu());
    menuModel.setID("menudModel");
    menuTable=new JTable(menuModel);
    
  //  restaurantTableModel,menuTable_menuModel,restaurantTable_ResModel,customerTable_cusModel;
    columnNames=new String[]{"ID","First Name","Last Name","Street","Apt","City","State","Zip","Phone"};
    edit=new boolean[]{false,false,false,false,false,false,false,false,false};
    customerTable_cusModel=new TModel(columnNames,edit);
    //customerTable_cusModel.setData(Database.getMenu());
    customerTable_cusModel.setID("customerTable_cusModel");
    customerTable_cus=new JTable(customerTable_cusModel);
    lsm_cus = customerTable_cus.getSelectionModel();
    lsm_cus.addListSelectionListener(this);
    
    catagoryEditor_menuModel=new DefaultListModel();
    restaurantModel=new DefaultListModel();
    catagoryModel=new DefaultListModel();
    customerModel=new DefaultListModel();
    
    catagoryEditor_menu = new JList(catagoryEditor_menuModel);
    restaurant=new JList(restaurantModel);
    catagory=new JList(catagoryModel);
    customer=new JList(customerModel);
  
    Vector temdata=Database.getRestaurants("Summary");
   
    columnNames=new String[]{"ID","Name","City","State","Zip","Phone","ABName","First Name","Last Name"};
    edit=new boolean[]{false,false,false,false,false,false,false,false,false};
    restaurantTable_ResModel=new TModel(columnNames,edit);
    restaurantTable_ResModel.setData(temdata);
    restaurantTable_ResModel.setID("restaurantTable_ResModel");
    restaurantTable_Res=new JTable(restaurantTable_ResModel);
    lsm_Res = restaurantTable_Res.getSelectionModel();
    lsm_Res.addListSelectionListener(this);
    
    String[] temss=null;
    for(int i=0;i<temdata.size();i++)
    {
      temss=(String[])(temdata.get(i));
      restaurantModel.addElement(temss[1]);
      resID.add(temss[0]);
      restaurantID_cus.addItem(temss[1]);
    }
    customerID_cus.addItem("ALL");
    
    columnNames=new String[]{"ItemID","Name","Price","Hot","Catagory","Status"};
    edit=new boolean[]{false,false,false,false,false,false};
    menuTable_menuModel=new TModel(columnNames,edit);
    menuTable_menuModel.setID("menuTable_menuModel");
    menuTable_menu=new JTable(menuTable_menuModel);
    lsm_menu = menuTable_menu.getSelectionModel();
    lsm_menu.addListSelectionListener(this);
    
    columnNames=new String[]{"First Name","Last Name","Position","Experience"};
    edit=new boolean[]{false,false,false,false};
    restaurantTableModel=new TModel(columnNames,edit);
    //restaurantTableModel.setData(Database.getMenu());
    restaurantTableModel.setID("restaurantTableModel");
    restaurantTable=new JTable(restaurantTableModel);
    
    columnNames=new String[]{"ItemID","Name","Price"};
    edit=new boolean[]{true,false,false};
    saleModel=new TModel(columnNames,edit);
    saleModel.setID("saledModel");
    saleTable=new JTable(saleModel);
  
  state_Res.addItem("SC");
  state_Res.addItem("NC"); 
  state.addItem("SC");
  state.addItem("NC"); 
  orderID=new JTextField();
  customerID_Res = new JTextField();
   businessName_Res = new JTextField();
   cellPhone_Res = new JTextField();
    phone3_Res = new JTextField();
    abName_Res = new JTextField();
   lastName_Res = new JTextField();
   street_Res = new JTextField();
   unit_Res = new JTextField();
   city_Res = new JTextField();
   phone_Res = new JTextField();
   firstName_Res = new JTextField();
   total_cus = new JTextField();  
   newCatagory_menu = new JTextField();  
   subTotal = new JTextField();
   customerID = new JTextField();
   detuct = new JTextField();
   price_menu = new JTextField();
   itemID_menu = new JTextField();
   disableIt(itemID_menu);
   name_menu = new JTextField();
   status_menu = new JTextField();  
    lastName = new JTextField();
   city = new JTextField();

   firstName = new JTextField();
 
     zip_Res = new JTextField();
     phone = new JTextField();
     street = new JTextField();
     apt = new JTextField();
     zip = new JTextField();
     grandTotal = new JTextField();
     un6 = new JTextField();
    
    
    
 
   // private JButton customerUpdate,saleAdd,saleDelete,saleConfirm;
  // private JButton update_menu,add_menu,Delete_menu,catagoryAdd_menu,catagoryDelete_menu,capture_menu;
    update=new JButton();
    saleAdd=new JButton();
    saleDelete=new JButton();
    saleConfirm=new JButton();
    update_menu=new JButton();
    add_menu=new JButton();
    delete_menu=new JButton();
    catagoryAdd_menu=new JButton();
    catagoryDelete_menu=new JButton();
    capture_menu=new JButton();
    actionListener(update);
    actionListener(saleAdd);
    actionListener(saleDelete);
    actionListener(saleConfirm);
    actionListener(saleRecord_cus);
    actionListener(customerList_cus);
    actionListener(update_menu);
    actionListener(add_menu);
    actionListener(delete_menu);
    actionListener(catagoryAdd_menu);
    actionListener(catagoryDelete_menu);
    actionListener(add_Res);
    actionListener(update_Res);
    actionListener(delete_Res);  
    actionListener(restaurant);
    actionListener(catagory);
    actionListener(restaurantID_cus);
    
  }

  public MainS()
  {
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

    }
    catch(ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    try
    {
      initial();
      jbInit();
      enableEvents(AWTEvent.WINDOW_EVENT_MASK);
      pack();
      setVisible(true);
      
       String name = "//localhost:1099/Compute";
        try {
            Compute engine = new ComputeEngine(this);
            p.p(name);
            Naming.rebind(name, engine);
            p.p("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception: " + 
			       e.getMessage());
            e.printStackTrace();
        }
        p.p("OK");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }
   private void disableIt(Component c)
  {
        c.setEnabled(false);
  }
   private void able(Component c)
  {
        c.setEnabled(true);
  }
   private void actionListener(JButton c)
  {
        c.addActionListener(this);
  }
  private void actionListener(JComboBox c)
  {
        c.addActionListener(this);
  }
  private void actionListener(JRadioButton c)
  {
        c.addActionListener(this);
  }
   private void actionListener(JList c)
  {
        c.addListSelectionListener(this);
  }
 protected void processWindowEvent(WindowEvent e)
  {
    if(e.getID()==WindowEvent.WINDOW_CLOSING)
    {
      dispose();
      System.exit(0);
    }
    super.processWindowEvent(e);
  }
  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    MainS mainS = new MainS();
  }

  private void jbInit() throws Exception
  {
    //this.setSize(new Dimension(750, 450));
    upPane.setLayout(gridBagLayout9);
    upPane.setBackground(Color.white);
    videoWindow.setBackground(Color.white);
    videoWindow.setBorder(BorderFactory.createLineBorder(new Color(146, 179, 171), 1));
    phoneContact.setText("Phone");
    outsideCustomer.setText("Outside");
    outsideCustomer.setSelected(true);
  
    insideCustomer.setText("Inside");
    restaurant.setBorder(BorderFactory.createTitledBorder("Restaurant"));
    customer.setBorder(BorderFactory.createTitledBorder("Customer"));
    jLabellname.setText("First Name:");
    jLabellname.setHorizontalAlignment(SwingConstants.TRAILING);
    PL.setText("Phone:");
    PL.setHorizontalAlignment(SwingConstants.TRAILING);
//    jFormattedTextField1.setText("                          ");
    firstName.setText("                       ");
    jLabel1.setText("LastName");
    jLabel1.setHorizontalAlignment(SwingConstants.TRAILING);
    lastName.setText("                       ");
    phone1.setText("Street:");
    phone1.setHorizontalAlignment(SwingConstants.TRAILING);
//    jFormattedTextField2.setText("                          ");
    jLabellname1.setText("APT:");
    jLabellname1.setHorizontalAlignment(SwingConstants.TRAILING);
//    firstName1.setText("                       ");
    jLabellname2.setText("City:");
    jLabellname2.setHorizontalAlignment(SwingConstants.TRAILING);
    city.setText("                       ");
    jLabel3.setText("Zip:");
    jLabel3.setHorizontalAlignment(SwingConstants.TRAILING);
//    lastName2.setText("                       ");
    jLabel2.setText("State:");
    jLabel2.setHorizontalAlignment(SwingConstants.TRAILING);
    customerIDxx.setText("Order ID:");
    customerIDxx.setHorizontalAlignment(SwingConstants.TRAILING);
    orderID.setText("                          ");
    jLabellname3.setText("Customer ID");
    jLabellname3.setHorizontalAlignment(SwingConstants.TRAILING);
    update.setText("Update");
    jPanel5.setLayout(gridBagLayout7);
    jPanel5.setBorder(BorderFactory.createLineBorder(new Color(143, 138, 179), 1));
    jPanel3.setBorder(BorderFactory.createLineBorder(new Color(153, 155, 179), 1));
    jPanel3.setLayout(gridBagLayout3);
    jLabel4.setText("SubTotal$:");
    jLabel4.setHorizontalAlignment(SwingConstants.TRAILING);
    subTotal.setBorder(BorderFactory.createLineBorder(new Color(179, 6, 165), 1));
    saleDelete.setText("--");
    downPane.setBorder(BorderFactory.createLineBorder(new Color(146, 179, 171), 1));
    downPane.setLayout(gridBagLayout10);
    saleAdd.setText("+");
    catagory.setBorder(BorderFactory.createTitledBorder("Catagory"));
    saleConfirm.setText("Confirm");
    dishPicture.setBorder(BorderFactory.createLineBorder(new Color(143, 179, 149), 1));
    detuct.setText("0");
    un6.setBorder(BorderFactory.createLineBorder(new Color(255, 53, 77), 1));
    goOrStay.setText("To go");
    goOrStay.setSelected(true);
    delivery.setText("Delivery");
    jLabel5.setText("Detuct");
    jLabel5.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel6.setText("Grand Total$");
    jLabel6.setHorizontalAlignment(SwingConstants.TRAILING);
    jPanel8.setLayout(gridBagLayout5);
    jPanel9.setLayout(gridBagLayout6);
    jPanel10.setLayout(gridBagLayout2);
    jPanel6.setLayout(gridBagLayout8);
    jPanel2.setLayout(gridBagLayout1);
    xYLayout4.setWidth(962);
    xYLayout4.setHeight(766);
    jPanel5.add(jPanel8, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 3, 0), 5, 12));
    jPanel5.add(jPanel9, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 0, 3, 3), 0, 0));
    jPanel3.add(delivery, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 15, 0, 0), 10, 2));
    jPanel3.add(goOrStay, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 32, 2));
    jPanel3.add(saleConfirm, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(30, 5, 0, 0), 16, 2));
    jScrollPane4.getViewport().add(saleTable, null);
    jPanel3.add(jScrollPane4, new GridBagConstraints(2, 1, 3, 4, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 3, 3), -262, -282));
    jPanel3.add(subTotal, new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 0), 83, 9));
    jPanel3.add(jLabel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 18, 6));
    jPanel8.add(jLabel2, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(13, 15, 0, 0), 5, 6));
    jPanel8.add(PL, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 11, 1));
    jPanel8.add(phone, new GridBagConstraints(1, 0, 1, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 0), 16, 4));
    jPanel8.add(jLabellname, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 5, 1));
    jPanel8.add(firstName, new GridBagConstraints(4, 0, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 10), 30, 4));
    jPanel8.add(street, new GridBagConstraints(1, 2, 5, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(12, 0, 0, 10), 191, 4));
    jPanel8.add(phone1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(15, 0, 0, 0), 16, 1));
    jPanel8.add(jLabellname2, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(18, 25, 0, 0), 2, 1));
    jPanel8.add(city, new GridBagConstraints(1, 4, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(11, 0, 0, 0), 25, 4));
    jPanel8.add(state, new GridBagConstraints(4, 4, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(11, 0, 0, 10), 86, 5));
    jPanel8.add(customerID, new GridBagConstraints(5, 5, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(15, 10, 0, 10), 84, 6));
    jPanel8.add(jLabellname3, new GridBagConstraints(2, 5, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 5, 1));
    jPanel8.add(update, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(15, 0, 0, 0), 38, 2));
    jPanel9.add(customerIDxx, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 9, 1));
    jPanel9.add(orderID, new GridBagConstraints(1, 6, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(15, 0, 5, 5), 1, 4));
    jPanel9.add(zip, new GridBagConstraints(1, 4, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(15, 0, 0, 5), 10, 6));
    jPanel9.add(jLabel3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(18, 25, 0, 0), 12, 1));
    jPanel9.add(apt, new GridBagConstraints(1, 2, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(15, 0, 0, 5), 10, 4));
    jPanel9.add(jLabellname1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(17, 15, 0, 0), 17, 1));
    jPanel9.add(lastName, new GridBagConstraints(1, 0, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 0, 5), 10, 6));
    jPanel9.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 3, 1));
    jPanel10.add(videoWindow, new GridBagConstraints(7, 0, 1, 3, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 0, 0, 5), 133, 153));
    jPanel10.add(grandTotal, new GridBagConstraints(5, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 0), 73, 9));
    jPanel10.add(jLabel6, new GridBagConstraints(3, 2, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 25, 0, 0), 8, 6));
    jPanel10.add(detuct, new GridBagConstraints(1, 2, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 33, 6));
    jPanel10.add(jLabel5, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 5, 0, 0), 13, 11));
    jScrollPane2.getViewport().add(customer, null);
    jPanel10.add(jScrollPane2, new GridBagConstraints(0, 0, 7, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 0, 0), 22, -30));
    jPanel10.add(phoneContact, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 15, 0, 0), 15, -3));
    jPanel10.add(outsideCustomer, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 17, -3));
    jPanel10.add(insideCustomer, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 10, 0, 0), 20, -3));
    jScrollPane3.getViewport().add(restaurantTable, null);
    jPanel6.add(jScrollPane3, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 0), -242, -247));
    jScrollPane1.getViewport().add(restaurant, null);
    jPanel6.add(jScrollPane1, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 0, 5, 0), -93, 25));
    jPanel6.add(jPanel3, new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 0, 5, 0), 5, 0));
    jScrollPane5.getViewport().add(important, null);
    jPanel6.add(jScrollPane5, new GridBagConstraints(3, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 15, 5, 5), 226, 133));
    jScrollPane8.getViewport().add(dishDescrption, null);
    jPanel2.add(jScrollPane8, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 10), 136, 103));
    jScrollPane9.getViewport().add(dishPicture, null);
    jPanel2.add(jScrollPane9, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 10), 124, 84));
    jScrollPane7.getViewport().add(catagory, null);
    jPanel2.add(jScrollPane7, new GridBagConstraints(0, 0, 1, 3, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 0, 0), -183, 110));
    downPane.add(jPanel2, new GridBagConstraints(2, 0, 1, 3, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 0, 3, 3), 0, 0));
    jScrollPane6.getViewport().add(menuTable, null);
    downPane.add(jScrollPane6, new GridBagConstraints(0, 0, 1, 3, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 3, 0), 198, -162));
    downPane.add(saleAdd, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(45, 0, 0, 0), -1, 27));
    downPane.add(saleDelete, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(65, 0, 0, 0), -1, 27));
    jScrollPane12.getViewport().add(jPanel10, null);
    upPane.add(jScrollPane12, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 15), -37, -7));
    jScrollPane10.getViewport().add(jPanel5, null);
    upPane.add(jScrollPane10, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), -2, 3));
    jScrollPane11.getViewport().add(jPanel6, null);
    upPane.add(jScrollPane11, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 15), -4, 31));
    scrDown.getViewport().add(downPane, null);
    scrUp.getViewport().add(upPane, null);
    creatMenuPane();
    createRestaurantPane();
    createCustomerPane();
    tabbed.add("Menu",scrDown);
    tabbed.add("Items",menuEnterPane);
    tabbed.add("Restaurant",restaurantPane);
    tabbed.add("Customers",customerPane);
    JSplitPane splitPane3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                           scrUp, tabbed);
    splitPane3.setOneTouchExpandable(true);
    splitPane3.setDividerLocation(550);
    splitPane3.setPreferredSize(new Dimension(1000, 700));
    this.getContentPane().add(splitPane3, BorderLayout.CENTER);
    
  }
private void creatMenuPane()
{
     menuEnterPane.setLayout(new BorderLayout());
    menuEnterPane.setBackground(Color.white);
    jLabel_menu.setText("Price");
    jLabel_menu.setHorizontalAlignment(SwingConstants.TRAILING);
    desc_menu.setText("Description:");
    desc_menu.setHorizontalAlignment(SwingConstants.TRAILING);
    status_menu.setText("                          ");
    price_menu.setText("                       ");
    jLabel1_menu.setText("Catagory");
    jLabel1_menu.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabellname3menu.setText("Item ID");
    jLabellname3menu.setHorizontalAlignment(SwingConstants.TRAILING);
    update_menu.setText("Update");
    jPanel5_menu.setLayout(gridBagLayout3);
    jPanel5_menu.setBorder(BorderFactory.createLineBorder(new Color(143, 138, 179), 1));
    menuTable_menu.setBorder(BorderFactory.createLineBorder(new Color(179, 41, 90), 1));
   
    jLabel4_menu.setText("Name");
    jLabel4_menu.setHorizontalAlignment(SwingConstants.TRAILING);
    add_menu.setText("Add");
   
    delete_menu.setText("Delete");
    
  //  xYLayout1.setWidth(954);
  //  xYLayout1.setHeight(588);
    
    catagoryAdd_menu.setText("Add");
    catagoryDelete_menu.setText("Delete");
    hot_menu.setText("Hot");
    jLabel2_menu.setText("Status");
    jLabel2_menu.setHorizontalAlignment(SwingConstants.TRAILING);
    capture_menu.setText("Capture");
    jPanel1_menu.setLayout(new GridBagLayout());
    jPanel1_menu.setBorder(BorderFactory.createLineBorder(new Color(143, 138, 179), 1));
    jPanel2_menu.setLayout(gridBagLayout1);
    jPanel3_menu.setLayout(gridBagLayout2);
    jPanel5_menu.add(jPanel3_menu, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 15, 0, 0), 0, -5));
    jPanel5_menu.add(jPanel1_menu, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 0, 0, 0), -26, -34));
    jPanel5_menu.add(jPanel2_menu, new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 10, 0, 6), 0, 0));
    jPanel1_menu.add(catagoryAdd_menu, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 5, 10), 19, 2));
    jPanel1_menu.add(catagoryDelete_menu, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 5, 5, 0), 7, 2));
    jPanel1_menu.add(newCatagory_menu, new GridBagConstraints(0, 1, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 10), 129, 6));
    jScrollPane1_menu.getViewport().add(catagoryEditor_menu, null);
    jPanel1_menu.add(jScrollPane1_menu, new GridBagConstraints(0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 0, 10), -118, -50));
    jPanel2_menu.add(delete_menu, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 20, 0, 0), 12, 2));
    jPanel2_menu.add(capture_menu, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 25, 0, 0), 4, -3));
    jPanel2_menu.add(jScrollPane3_menu, new GridBagConstraints(3, 3, 2, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 5, 5), 103, 93));
    jPanel2_menu.add(add_menu, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(25, 20, 5, 0), 24, 2));
    jPanel2_menu.add(update_menu, new GridBagConstraints(2, 0, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 20, 0, 0), 8, 2));
    jPanel2_menu.add(desc_menu, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 10, 0, 0), 23, 1));
    jScrollPane2_menu.getViewport().add(description_menu, null);
    jPanel2_menu.add(jScrollPane2_menu, new GridBagConstraints(0, 3, 2, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 5, 0), 96, 73));
    jPanel3_menu.add(jLabel2_menu, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(35, 15, 0, 0), 19, 6));
    jPanel3_menu.add(hot_menu, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 52, -3));
    jPanel3_menu.add(status_menu, new GridBagConstraints(5, 2, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(35, 0, 0, 0), 21, 4));
    jPanel3_menu.add(catagory_menu, new GridBagConstraints(5, 0, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 86, 5));
    jPanel3_menu.add(jLabel1_menu, new GridBagConstraints(3, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 15, 1));
    jPanel3_menu.add(itemID_menu, new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 99, 6));
    jPanel3_menu.add(jLabellname3menu, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 14, 1));
    jPanel3_menu.add(name_menu, new GridBagConstraints(1, 2, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(35, 0, 0, 0), 99, 6));
    jPanel3_menu.add(jLabel4_menu, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(35, 5, 0, 0), 23, 6));
    jPanel3_menu.add(price_menu, new GridBagConstraints(1, 4, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(20, 0, 10, 0), 30, 4));
    jPanel3_menu.add(jLabel_menu, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(25, 5, 0, 0), 22, 1));
    scr_menu.getViewport().add(jPanel5_menu, null);
    menuEnterPane.add(scr_menu, BorderLayout.NORTH);
    jScrollPane6_menu.getViewport().add(menuTable_menu, null);
    menuEnterPane.add(jScrollPane6_menu, BorderLayout.CENTER);
    
}
private void createRestaurantPane()
{
restaurantPane.setLayout(borderLayout1);
    restaurantPane.setBackground(Color.white);
    jLabellname_Res.setText("First Name:");
    jLabellname_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel_Res.setText("Phone:");
    jLabel_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    phone_Res.setText("                          ");
    firstName_Res.setText("                       ");
    jLabel1_Res.setText("Last Name");
    jLabel1_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    lastName_Res.setText("                       ");
    jLabelll_Res.setText("Street:");
    jLabelll_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    street_Res.setText("                          ");
    jLabellname1_Res.setText("Unit:");
    jLabellname1_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    unit_Res.setText("                       ");
    jLabelln_Res.setText("City:");
    jLabelln_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    city_Res.setText("                       ");
    jLabel3_Res.setText("Zip:");
    jLabel3_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    zip_Res.setText("                       ");
    jLabel2_Res.setText("State:");
    jLabel2_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    customerIDxx_Res.setText("CellPhone");
    customerIDxx_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    cellPhone_Res.setText("                          ");
    jLabell_Res.setText("Customer ID");
    jLabell_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    update_Res.setText("Update");
    jPanel5_Res.setLayout(gridBagLayout1_Res);
    jPanel5_Res.setBorder(BorderFactory.createLineBorder(new Color(143, 138, 179), 1));
    restaurantTable_Res.setBorder(BorderFactory.createLineBorder(new Color(179, 41, 90), 1));
    jLabel4_Res.setText("Businiss Name");
    jLabel4_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    add_Res.setText("Add");
    delete_Res.setText("Delete");
    jLabel5_Res.setText("Phone3");
    jLabel5_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel6_Res.setText("ABName:");
    jLabel6_Res.setHorizontalAlignment(SwingConstants.TRAILING);
    xYLayout1.setWidth(948);
    xYLayout1.setHeight(568);
    jPanel5_Res.add(abName_Res, new GridBagConstraints(16, 3, 1, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(25, 0, 0, 3), 74, 6));
    jPanel5_Res.add(phone3_Res, new GridBagConstraints(16, 0, 1, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 3), 74, 6));
    jPanel5_Res.add(jLabel6_Res, new GridBagConstraints(15, 3, 1, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(25, 0, 0, 0), 9, 6));
    jPanel5_Res.add(jLabel5_Res, new GridBagConstraints(15, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 9, 1));
    jPanel5_Res.add(delete_Res, new GridBagConstraints(16, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 0, 0, 3), 22, 2));
    jPanel5_Res.add(add_Res, new GridBagConstraints(14, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 34, 2));
    jPanel5_Res.add(businessName_Res, new GridBagConstraints(4, 0, 4, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 149, 6));
    jPanel5_Res.add(jLabel4_Res, new GridBagConstraints(2, 0, 2, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 23, 6));
    jPanel5_Res.add(customerID_Res, new GridBagConstraints(1, 0, 1, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 94, 6));
    jPanel5_Res.add(firstName_Res, new GridBagConstraints(12, 0, 1, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 15, 4));
    jPanel5_Res.add(jLabel1_Res, new GridBagConstraints(13, 0, 1, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 0, 0), 15, 1));
    jPanel5_Res.add(jLabellname_Res, new GridBagConstraints(8, 0, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 15, 0, 0), 15, 1));
    jPanel5_Res.add(lastName_Res, new GridBagConstraints(14, 0, 1, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 5, 6));
    jPanel5_Res.add(phone_Res, new GridBagConstraints(12, 3, 1, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(25, 0, 0, 0), 6, 4));
    jPanel5_Res.add(jLabel_Res, new GridBagConstraints(10, 3, 2, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 0, 0, 0), 6, 1));
    jPanel5_Res.add(street_Res, new GridBagConstraints(1, 3, 4, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(25, 0, 0, 0), 186, 4));
    jPanel5_Res.add(unit_Res, new GridBagConstraints(7, 3, 2, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(25, 0, 0, 0), -5, 4));
    jPanel5_Res.add(jLabellname1_Res, new GridBagConstraints(5, 3, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(25, 15, 0, 0), 17, 1));
    jPanel5_Res.add(jLabelll_Res, new GridBagConstraints(0, 3, 1, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 20, 0, 0), 21, 1));
    jPanel5_Res.add(jLabel2_Res, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(25, 30, 0, 0), 5, 6));
    jPanel5_Res.add(jLabel3_Res, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(25, 15, 0, 0), 12, 1));
    jPanel5_Res.add(zip_Res, new GridBagConstraints(7, 6, 3, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(20, 0, 0, 0), 5, 6));
    jPanel5_Res.add(state_Res, new GridBagConstraints(3, 6, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(20, 0, 0, 0), 76, 5));
    jPanel5_Res.add(city_Res, new GridBagConstraints(1, 6, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(20, 0, 0, 0), 25, 4));
    jPanel5_Res.add(jLabelln_Res, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(25, 50, 0, 0), 2, 1));
    jPanel5_Res.add(jLabell_Res, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 5, 0, 0), 10, 1));
    jPanel5_Res.add(cellPhone_Res, new GridBagConstraints(14, 3, 1, 2, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(25, 0, 0, 0), -4, 4));
    jPanel5_Res.add(customerIDxx_Res, new GridBagConstraints(13, 3, 1, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(30, 25, 0, 0), 3, 1));
    jPanel5_Res.add(update_Res, new GridBagConstraints(12, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 28, 2));
    restaurantPane.add(jPanel5_Res, BorderLayout.NORTH);
    jScrollPane6_Res.getViewport().add(restaurantTable_Res, null);
    restaurantPane.add(jScrollPane6_Res, BorderLayout.CENTER);
}
private void createCustomerPane()
{
customerPane.setBorder(BorderFactory.createLineBorder(new Color(146, 179, 171), 1));
    customerPane.setLayout(borderLayout1_cus);
    xYLayout1.setWidth(962);
    xYLayout1.setHeight(484);
    control_cus.setLayout(gridBagLayout1_cus);
    jLabel1_cus.setText("Restaurant ID:");
    jLabel1_cus.setHorizontalAlignment(SwingConstants.TRAILING);
    customerList_cus.setText("Customers");
    saleRecord_cus.setText("Sale Record");
    jLabel1_cus1.setText("Customer ID:");
    jLabel1_cus1.setHorizontalAlignment(SwingConstants.TRAILING);
    jLabel13_cus.setText("Total");
    jLabel13_cus.setHorizontalAlignment(SwingConstants.TRAILING);
    control_cus.add(total_cus, new GridBagConstraints(7, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 10, 10, 125), 74, 6));
    control_cus.add(jLabel13_cus, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 10, 0), 16, 11));
    control_cus.add(jLabel1_cus1, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 10, 0), 21, 11));
    control_cus.add(customerID_cus, new GridBagConstraints(5, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 10, 0), 161, 5));
    control_cus.add(saleRecord_cus, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 10, 10, 0), 11, 2));
    control_cus.add(customerList_cus, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 10, 0), 12, 2));
    control_cus.add(jLabel1_cus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 10, 0), 8, 11));
    control_cus.add(restaurantID_cus, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 10, 0), 71, 5));
    customerPane.add(control_cus, BorderLayout.NORTH);
    jScrollPane6_cus.getViewport().add(customerTable_cus, null);
    customerPane.add(jScrollPane6_cus, BorderLayout.CENTER);
}
public void addRestaurant(String resid,String side)
{
   String[] ss=Database.getRestaurants(resid,"Summary");
   restaurantModel.addElement(ss[1]+"_"+side);
   resID.add(ss[0]);
}
public void endOp(String resid,String type,String location)
{
  if(type.equalsIgnoreCase("END"))
  {
    String[] ss=Database.getRestaurants(resid,"Summary");
    int ind=-1;
    String tem="";
    for(int i=restaurantModel.getSize()-1;i>=0;i--)
    {
        tem=(String)(restaurantModel.getElementAt(i));
        if(tem.equalsIgnoreCase(ss[1]+"_"+location))
        {
          restaurantModel.removeElementAt(i); 
          ind=i;
          break;
        }
    }
    if(ind>=0)
    resID.removeElementAt(ind);
    
    ind=-1;
    for(int i=customerModel.getSize()-1;i>=0;i--)
    {
        tem=(String)(customerModel.getElementAt(i));
        ind=tem.indexOf("@");
        if(ind>0)
        {
          tem=tem.substring(0,ind);
        }
       // p.p(tem);
        if(tem.equalsIgnoreCase(ss[1]+"_"+location))
        {
          customerModel.removeElementAt(i);
        //  p.p("OK");
          ind=i;
          break;
        }
    }
    if(ind>=0)
    waiting.removeElementAt(ind);
  }
}
  public void actionPerformed(ActionEvent e)
  {
    Object source=e.getSource();
    p.p("VV");
    if(source==update_menu)
    {
        update_menuOp();
    }
    if(source==add_menu)
    {
        add_menuOp();
    }
    if(source==delete_menu)
    {
        delete_menuOp();
    }
     if(source==catagoryAdd_menu)
    {
        catagoryAdd_menuOp();
    }
     if(source==catagoryDelete_menu)
    {
        catagoryDelete_menuOp();
    }
    if(source==update_Res)
    {
        update_ResOp();
    }
    if(source==add_Res)
    {
        add_ResOp();
    }
    if(source==delete_Res)
    {
        delete_ResOp();
    }
     if(source==update)
    {
        updateOp();
    }
     if(source==saleAdd)
    {
        saleAddOp();
    }
     if(source==saleDelete)
    {
        saleDeleteOp();
    }
     if(source==saleConfirm)
    {
        saleConfirmOp();
    }
     if(source==restaurantID_cus)
    {
        restaurantID_cusOp();
    }
     if(source==saleRecord_cus)
    {
        saleRecord_cusOp();
    }
     if(source==customerList_cus)
    {
        customerList_cusOp();
    }
  }
  private void saleRecord_cusOp()
  {
  Vector temdata=null;
      int index=restaurantID_cus.getSelectedIndex();
      String type=(String)(customerID_cus.getSelectedItem());
      if(type.equalsIgnoreCase("ALL"))
      temdata=Database.getSaleRecords((String)(resID.get(index)),null,null);
      else
      temdata=Database.getSaleRecords((String)(resID.get(index)),type,null);
      
      String[] names=new String[]{"First Name","Last Name","Name","Price","DateSold","TRNO"};
      customerTable_cusModel.setNames(names);
      customerTable_cusModel.setID("SaleRecord");
     customerTable_cusModel.setData(temdata);
  }
  private void customerList_cusOp()
  {
      Vector temdata=null;
      int index=restaurantID_cus.getSelectedIndex();
      String type=(String)(customerID_cus.getSelectedItem());
      if(type.equalsIgnoreCase("ALL"))
      temdata=Database.getCustomers((String)(resID.get(index)),null);
      else
      temdata=Database.getCustomers((String)(resID.get(index)),type);
      
      String[] names=new String[]{"ID","First Name","Last Name","Street","Apt","City","State","Zip","Phone"};
      customerTable_cusModel.setNames(names);
      customerTable_cusModel.setID("customerTable_cusModel");
  
     customerTable_cusModel.setData(temdata);
  }
   private void restaurantID_cusOp()
  {
      int index=restaurantID_cus.getSelectedIndex();
     Vector temdata=Database.getCustomers((String)(resID.get(index)),null);
     customerID_cus.removeAllItems();
     customerID_cus.addItem("ALL");
     for(int i=0;i<temdata.size();i++)
     {
        customerID_cus.addItem(((String[])(temdata.get(i)))[0]);
     }
  
  }
  
   private void saleConfirmOp()
  {
    Vector temdata=saleModel.getData();
    if(temdata.size()==0)
    {
      able(restaurant);
      subT=0;
      clear(subTotal);
      clear(grandTotal);
      return;
    }
    String orID="";
    if((orID=Database.addTransactions(temdata,RESTAURANTID,customerID.getText().trim())).equalsIgnoreCase("-1"))
    {
      JOptionPane.showMessageDialog(null,"Transaction Failed");
    }
    able(restaurant);
    clear(subTotal);
    clear(grandTotal);
    saleModel.setData(new Vector());
    orderID.setText(orID);
  }
   private void saleAddOp()
  {
      int[] index=menuTable.getSelectedRows();
      if(index.length<=0)
      {
        JOptionPane.showMessageDialog(null,"Select rows in the Table!!!");
        return;
      }
     
      String[] itemids=null;
      for(int i=0;i<index.length;i++)
      {
        itemids=new String[3];
        itemids[0]=(String)(menuTable.getValueAt(index[i],0));
        itemids[1]=(String)(menuTable.getValueAt(index[i],1));
        itemids[2]=(String)(menuTable.getValueAt(index[i],2));
        saleModel.addData(itemids);
        subT=subT+Double.parseDouble(itemids[2]);
      }
      subTotal.setText(""+subT);
      grandTotal.setText(""+(subT-Double.parseDouble(detuct.getText().trim())));
       disableIt(restaurant);
      // orderID.setText(""+(Database.getOrderID()+1));
  }
   private void saleDeleteOp()
  {
     int[] index=saleTable.getSelectedRows();
      if(index.length<=0)
      {
        JOptionPane.showMessageDialog(null,"Select rows in the Table!!!");
        return;
      }
      String tem="";
      for(int i=index.length-1;i>=0;i--)
      {
        tem=(String)(saleTable.getValueAt(index[i],2));
        saleModel.delete(index[i]);
        subT=subT-Double.parseDouble(tem);
      }
      subTotal.setText(""+subT);
      grandTotal.setText(""+(subT-Double.parseDouble(detuct.getText().trim())));
  }
   private void updateOp()
  {
        int index=restaurant.getSelectedIndex();
        if(index<0)
        return;
        String resid=(String)(resID.get(index));
    String[] ss=new String[13];
    //0-id,1=name,2=price,3=hot,4=catagory,5-desc,6=status
    ss[0]=resid;
    ss[1]=customerID.getText().trim();
    ss[2]=firstName.getText().trim();
    ss[3]=lastName.getText().trim();
    ss[4]=street.getText().trim();//street
    ss[5]=apt.getText().trim();//aparty
    ss[6]=city.getText().trim();
    ss[7]=state.getSelectedItem().toString().trim();
    ss[8]=zip.getText().trim();//zip
     ss[9]=phone.getText().trim();//phone

    if(Database.checkForItemID(ss[1],ss[0],"AccountNO"))
    NEWCUSTOMER=false;
    else
    NEWCUSTOMER=true;    
    if(NEWCUSTOMER)
    {
        
        
        if(!Database.addCustomer(ss))
        {
          JOptionPane.showMessageDialog(null,"Customer addition failed");
          return;
        }
    }
    else
    {
         if(!Database.updateCustomer(ss))
        {
          JOptionPane.showMessageDialog(null,"Customer Update failed");
          return;
        }
    }
    

  }
  
   private void add_ResOp()
  {
    
    if(!(customerID_Res.isEnabled()))
    {
      customerID_Res.setForeground(Color.RED);
      able(customerID_Res);
      return;
    }
    String[] ss=new String[13];
    //0-id,1=name,2=price,3=hot,4=catagory,5-desc,6=status
    ss[0]=customerID_Res.getText().trim();
    if(Database.checkForValid(ss[0],"RestaurantID"))
    {
      JOptionPane.showMessageDialog(null,ss[0]+" already exists in database.Please choose another one");
      return;
    }
    ss[1]=businessName_Res.getText().trim();
    ss[2]=street_Res.getText().trim();
    ss[3]=unit_Res.getText().trim();
    ss[4]=city_Res.getText().trim();
    ss[5]=state_Res.getSelectedItem().toString().trim();
    ss[6]=zip_Res.getText().trim();
    ss[7]=phone_Res.getText().trim();
    ss[8]=abName_Res.getText().trim();
    ss[9]=firstName_Res.getText().trim();
    ss[10]=lastName_Res.getText().trim();
    ss[11]=cellPhone_Res.getText().trim();
    ss[12]=phone3_Res.getText().trim();
   
    customerID_Res.setForeground(Color.BLACK);
    
    if(!Database.addRestaurant(ss))
    {
      JOptionPane.showMessageDialog(null,"Restaurant addition failed");
      return;
    }
    String[] ssTable;
    
    ssTable=new String[9]; 
    ssTable[0]=ss[0];
    ssTable[1]=ss[1];
    ssTable[2]=ss[4];
    ssTable[3]=ss[5];
    ssTable[4]=ss[6];
    ssTable[5]=ss[7];
    ssTable[6]=ss[8]; 
    ssTable[7]=ss[9];
    ssTable[8]=ss[10];
    
    restaurantTable_ResModel.addData(ssTable); 
    customerID_Res.setText("");
  }
   private void update_ResOp()
  {
  
     if(JOptionPane.showConfirmDialog(null,"Update?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION)
    return;
    
    int index=restaurantTable_Res.getSelectedRow();
    if(index<0)
    {
      JOptionPane.showMessageDialog(null,"Please Select An Item in the Table");
      return;
    }
    String[] ss=new String[13]; 
    String[] ssT=(String[])(restaurantTable_ResModel.getData().get(index));
    ss[0]=ssT[0];
    ss[1]=businessName_Res.getText().trim();
    ss[2]=street_Res.getText().trim();
    ss[3]=unit_Res.getText().trim();
    ss[4]=city_Res.getText().trim();
    ss[5]=state_Res.getSelectedItem().toString().trim();
    ss[6]=zip_Res.getText().trim();
    ss[7]=phone_Res.getText().trim();
    ss[8]=abName_Res.getText().trim();
    ss[9]=firstName_Res.getText().trim();
    ss[10]=lastName_Res.getText().trim();
    ss[11]=cellPhone_Res.getText().trim();
    ss[12]=phone3_Res.getText().trim();
    
   if(!Database.updateRestaurant(ss))
    {
      JOptionPane.showMessageDialog(null,"Restaurant Update failed");
      return;
    }
    
    //ssT[0]=ss[1];
    ssT[1]=ss[1];
    ssT[2]=ss[4];
    ssT[3]=ss[5];
    ssT[4]=ss[6];
    ssT[5]=ss[7];
    ssT[6]=ss[8];
    ssT[7]=ss[9];
    ssT[8]=ss[10];
      
    restaurantTable_ResModel.update(index);   
  }
   private void delete_ResOp()
  {
    int[] index=restaurantTable_Res.getSelectedRows();
      if(index.length<=0)
      {
        JOptionPane.showMessageDialog(null,"Please Select rows in the Table!!!");
        return;
      }
      String[] itemids=new String[index.length];
      for(int i=0;i<index.length;i++)
      {
        itemids[i]=(String)(restaurantTable_Res.getValueAt(index[i],0));
      }

      if(JOptionPane.showConfirmDialog(null,"Delete "+this.getStatement(itemids)+" ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION)
      return;
      String result=null;
      if((result=Database.deleteRestaurant(itemids))!=null)
      {
        JOptionPane.showMessageDialog(null,"Delete Item "+result+" failed");
        return;
      }
      restaurantTable_ResModel.delete(itemids);
  
  }
  private void catagoryAdd_menuOp()
  {
    String newvalue=newCatagory_menu.getText().trim();
     if(!catagoryEditor_menuModel.contains(newvalue))
    {
      int index=restaurantTable_Res.getSelectedRow();
      if(index<0)
      {
        JOptionPane.showMessageDialog(null,"Select Restaurant Table first");
        return;
      }
      String resid=(String)(restaurantTable_Res.getValueAt(index,0));
      if(Database.addSetting(newvalue,resid));
      {
        catagory_menu.addItem(newvalue);
        catagoryEditor_menuModel.addElement(newvalue);
      }
    }
    else
    {
      JOptionPane.showMessageDialog(null,newvalue+" already exists!");
      return;
    }
  }
   private void catagoryDelete_menuOp()
  {
    int index=catagoryEditor_menu.getSelectedIndex();
    
    if(index<0)
    {
      JOptionPane.showMessageDialog(null,"Please Choose an Item to Remove");
      return;
    }
    index=restaurantTable_Res.getSelectedRow();
      if(index<0)
      {
        JOptionPane.showMessageDialog(null,"Select Restaurant Table first");
        return;
      }
    String resid=(String)(restaurantTable_Res.getValueAt(index,0));
    String value=(String)(catagoryEditor_menu.getSelectedValue());
    if(Database.removeSetting(value,resid))
    {
    catagoryEditor_menuModel.removeElement(value);
    catagory_menu.removeItem(value);
    }
     else
    JOptionPane.showMessageDialog(null,"Removeing Failed");
  }
  private void add_menuOp()
  {
    
   if(!(itemID_menu.isEnabled()))
    { 
      currentValue=this.itemIDgenerate("ItemID");
      itemID_menu.setForeground(Color.RED);
      able(itemID_menu);
      return;
    }
    String[] ss=new String[8];
    //0-id,1=name,2=price,3=hot,4=catagory,5-desc,6=status
    int index=restaurantTable_Res.getSelectedRow();
    if(index<0)
    {
      JOptionPane.showMessageDialog(null,"Please Select a restaurant");
      return;
    }
    ss[0]=(String)(restaurantTable_Res.getValueAt(index,0));//RestaurantID
   
    ss[1]=itemID_menu.getText().trim();
    ss[2]=name_menu.getText().trim();
    ss[3]=price_menu.getText().trim();
    ss[4]=(hot_menu.isSelected()?"Hot":" ");
    ss[5]=catagory_menu.getSelectedItem().toString().trim();
    ss[6]=description_menu.getText().trim();
    ss[7]=status_menu.getText().trim();
    itemID_menu.setForeground(Color.BLACK);
    
    if(Database.checkForItemID(ss[1],ss[0],"ItemID"))
    {
      JOptionPane.showMessageDialog(null,"Item already exists");
      return;
    }
    
    if(!Database.addItem(ss,currentValue))
    {
      JOptionPane.showMessageDialog(null,"Item Addition failed");
      return;
    }
    String[] ssTable;
    ssTable=new String[6];
    ssTable[0]=ss[1];
    ssTable[1]=ss[2];
    ssTable[2]=ss[3];
    ssTable[3]=ss[4];
    ssTable[4]=ss[5];
    ssTable[5]=ss[7]; 
    menuTable_menuModel.addData(ssTable); 
    currentValue=itemIDgenerate("ItemID");
    itemID_menu.setForeground(Color.RED);
  }
  private long itemIDgenerate(String itemid)
  {
    int index=restaurantTable_Res.getSelectedRow();
    if(index<0)
    {
      JOptionPane.showMessageDialog(null,"Select a restaurant");
      return 1000000;
    }
    String resid=(String)(restaurantTable_Res.getValueAt(index,0));
    long currentValue=Database.getNextValue(itemid,resid);
    p.p("idg="+currentValue);
    itemID_menu.setText(Database.getABName(resid)+currentValue);
    return currentValue;
  
  }
  private void update_menuOp()
  {
    if(JOptionPane.showConfirmDialog(null,"Update?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION)
    return;
    
    int index=menuTable_menu.getSelectedRow();
    if(index<0)
    {
      JOptionPane.showMessageDialog(null,"Please Select An Item in the Table");
      return;
    }
    String[] ss=new String[8]; 
    int indexRes=restaurantTable_Res.getSelectedRow();
    String sT=(String)(restaurantTable_Res.getValueAt(indexRes,0));
    ss[0]=sT;
    ss[1]=itemID_menu.getText().trim();
    ss[2]=name_menu.getText().trim();
    ss[3]=price_menu.getText().trim();
    ss[4]=(hot_menu.isSelected()?"Hot":" ");
    ss[5]=catagory_menu.getSelectedItem().toString().trim();
    ss[6]=status_menu.getText().trim();
    ss[7]=description_menu.getText().trim();
    
   if(!Database.updateItem(ss))
    {
      JOptionPane.showMessageDialog(null,"Item Update failed");
      return;
    }
    String[] ssT=(String[])(menuTable_menuModel.getData().get(index));
    ssT[0]=ss[1];
    ssT[1]=ss[2];
    ssT[2]=ss[3];
    ssT[3]=ss[4];
    ssT[4]=ss[5];
    ssT[5]=ss[6];
      
    menuTable_menuModel.update(index);   
  }
  private void delete_menuOp()
  {
     int[] index=menuTable_menu.getSelectedRows();
     int row=restaurantTable_Res.getSelectedRow();
     String resid=(String)(restaurantTable_Res.getValueAt(row,0));
      if(index.length<=0)
      {
        JOptionPane.showMessageDialog(null,"Please Select rows in the menuTable_menu");
        return;
      }
      String[] itemids=new String[index.length];
      String[] resids=new String[index.length];
      for(int i=0;i<index.length;i++)
      {
        itemids[i]=(String)(menuTable_menu.getValueAt(index[i],0));
        resids[i]=resid;
      }

      if(JOptionPane.showConfirmDialog(null,"Delete "+this.getStatement(itemids)+" ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION)
      return;
      String result=null;
      if((result=Database.deleteItem(itemids,resids))!=null)
      {
        JOptionPane.showMessageDialog(null,"Delete Item "+result+" failed");
        return;
      }
      menuTable_menuModel.delete(itemids);
      disableIt(itemID_menu);
  }
   private String getStatement(String[] ss)
  {
        String s="";
        for(int i=0;i<ss.length;i++)
        {
                if(i==0)
                s=s+ss[i];
                else
                s=s+"\n"+ss[i];
        }
        return s;
  }
  private void clear(JTextField f)
  {
    f.setText("");
  }
   private void clear(JTextPane f)
  {
    f.setText("");
  }
  private void menuClear()
  {
    clear(itemID_menu);
    clear(name_menu);
    clear(price_menu);
    clear(status_menu);
    clear(description_menu);
  }
  public void valueChanged(ListSelectionEvent e)
  {
       if (e.getValueIsAdjusting()) 
       return;

      Object o=e.getSource();
      if(o==catagory)
      {
        int index=restaurant.getSelectedIndex();
        if(index<0)
        return;
        String resid=(String)(resID.get(index));
        String cata=(String)(catagory.getSelectedValue());
        Vector ss=Database.getMenu(resid,cata);
        menuModel.setData(ss);
        return;
      }
      if(o!=restaurant)
      {
            ListSelectionModel lsm =
            (ListSelectionModel)e.getSource();
            if (lsm.isSelectionEmpty()) {
            //no rows are selected
            } else 
            {
                int selectedRow = lsm.getMinSelectionIndex();
                if(lsm==lsm_Res)
                {
                  String id=(String)(restaurantTable_Res.getValueAt(selectedRow,0));
                  String[] ss=Database.getRestaurants(id,"Browse");
                  customerID_Res.setText(ss[0]);
                  businessName_Res.setText(ss[1]);
                  city_Res.setText(ss[2]);
                  state_Res.setSelectedItem(ss[3]);
                  zip_Res.setText(ss[4]);
                  phone_Res.setText(ss[5]);
                  abName_Res.setText(ss[6]);
                  firstName_Res.setText(ss[7]);
                  lastName_Res.setText(ss[8]);
                  street_Res.setText(ss[9]);
                  unit_Res.setText(ss[10]);
                  cellPhone_Res.setText(ss[11]);
                  phone3_Res.setText(ss[12]);
                  disableIt(customerID_Res);
                  disableIt(itemID_menu);
                  menuClear();
                  menuTable_menuModel.setData(Database.getMenu(id,null));
               //   customerTable_cusModel.setData(Database.getCustomers(id));
                  
                  catagoryEditor_menuModel.removeAllElements();
                  catagory_menu.removeAllItems();
                //  catagoryModel.removeAllElements();  
                  
                  Vector temdata=Database.getSetting(id);
                  for(int i=0;i<temdata.size();i++)
                  {
                    catagoryEditor_menuModel.addElement(temdata.get(i));
                    catagory_menu.addItem(temdata.get(i));
                 //   catagoryModel.addElement(temdata.get(i));
                  }
    
    
                  return;
                }
          
                if(lsm==lsm_menu)
                {
                  String itemid=(String)(menuTable_menu.getValueAt(selectedRow,0));
                  int resIndex=restaurantTable_Res.getSelectedRow();
                  String resid=(String)(restaurantTable_Res.getValueAt(resIndex,0));
                  String[] ss=Database.getItem(itemid,resid);
            
            //0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
                  itemID_menu.setText(ss[0]);
                  name_menu.setText(ss[1]);
                  price_menu.setText(ss[2]);
                  catagory_menu.setSelectedItem(ss[4]);
                
                  if(ss[3].equalsIgnoreCase("Hot"))
                    hot_menu.setSelected(true);
                  else
                    hot_menu.setSelected(false);
                
                  status_menu.setText(ss[5]);
                  description_menu.setText(ss[6]);
                  disableIt(itemID_menu);
                  p.p(ss[3]+", hot="+ss[4]+"  des="+ss[6]);
                  return;
                  }
                  if(lsm==lsm_cus)
                  {
                    if(customerTable_cusModel.getID().equalsIgnoreCase("SaleRecord"))
                    {
                        int[] inds=customerTable_cus.getSelectedRows();
                        double t=0;
                        for(int i=0;i<inds.length;i++)
                        {
                            t=t+Double.parseDouble((String)(customerTable_cus.getValueAt(inds[i],3)));
                        }
                        total_cus.setText(""+t);
                    }
                  
                  
                  }
            
        
              }
       
      } 
      else
      {
        int index=restaurant.getSelectedIndex();
        if(index<0)
        return;
        RESTAURANTID=(String)(resID.get(index));
        Vector ss=Database.getMenu(RESTAURANTID,null);
        menuModel.setData(ss);
        catagoryModel.removeAllElements();  
                  
        Vector temdata=Database.getSetting(RESTAURANTID);
        for(int i=0;i<temdata.size();i++)
        {                  
            catagoryModel.addElement(temdata.get(i));
        }
      }

  }
  
}