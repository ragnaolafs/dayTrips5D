package View;
/**
 * imports
 */
import Controller.DatabaseController;
import Model.HostLogin;
import Model.Search;
import Model.Trip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;

/**
 * This class is the main view form of the application.
 * It shows all the trips, has a view of the search and a login option.
 * @author Ragna Ólafsdóttir, rao9@hi.is
 * @author Hugrún Guðmundsdóttir, hug17@hi.is
 * @author Karen Ósk Pétursdóttir, kop1@hi.is
 */
public class TripsView extends javax.swing.JFrame {

    public static Trip selectedTrip;
    
    /**
     * Creates new form TripsView
     */
    public TripsView() {
        initComponents();
        HostLogin mja = new HostLogin();
        if("".equals(mja.getLoggedIn()) ){
            jLogout.setVisible(false);
        }else{
            jLogout.setVisible(true);
        }
        showTrips();
    }
    /**
     * Gets connection from database.
     * @return 
     */
    public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:dayTripsDB.db", "root", "");
            return con;
        } catch(SQLException e){
            return null;
        }     
    }
    /**
     * Gets user selected trip.
     * @return 
     */
    public Trip getSelectedTrip(){
        int n = jTable.getSelectedRow();
        Search search = new Search();
        ArrayList<Trip> tripList = search.getCurrentTripList();

        selectedTrip = tripList.get(n);
        
        return selectedTrip;
    }
    
    /**
     * Calls search class and gets current list.
     */
    public void showTrips(){
        Search search = new Search();
        ArrayList<Trip> tripList =search.resetSearch();
        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        Object[] row = new Object[3];
  
        for(int i = 0; i < tripList.size(); i++){
            row[0]= tripList.get(i).getName();
            row[1]= tripList.get(i).getPrice();
            row[2]= tripList.get(i).getLocation();
            model.insertRow(i, row);
        }
        jTable.setModel(model);
    }
    /**
     * Checks checked checkboxes and returns them.
     * @return 
     */
    public ArrayList<JCheckBox> getCheckboxes(){
        ArrayList<JCheckBox> checkboxes = new ArrayList();
        checkboxes.add(jCheckReykjavik);
        checkboxes.add(jCheckNorth);
        checkboxes.add(jCheckSouth);
        checkboxes.add(jCheckWest);
        checkboxes.add(jCheckEast);
        return checkboxes;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogMoreInfo = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jInfo = new javax.swing.JTextArea();
        jBook = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDatesAvail = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTripName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScroll = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jMoreInfo = new javax.swing.JButton();
        jSearchText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSearch = new javax.swing.JButton();
        jPriceFrom = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jPriceTo = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jCheckReykjavik = new javax.swing.JCheckBox();
        jCheckNorth = new javax.swing.JCheckBox();
        jCheckSouth = new javax.swing.JCheckBox();
        jCheckWest = new javax.swing.JCheckBox();
        jCheckEast = new javax.swing.JCheckBox();
        jDateChooseTo = new com.toedter.calendar.JDateChooser();
        jDateChooseFrom = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jHostLogin = new javax.swing.JButton();
        jLogout = new javax.swing.JButton();
        jCancelSearch = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCreateTrip = new javax.swing.JMenuItem();

        jDialogMoreInfo.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 250, 240));

        jClose.setText("Close");
        jClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCloseActionPerformed(evt);
            }
        });

        jInfo.setEditable(false);
        jInfo.setColumns(20);
        jInfo.setRows(5);
        jScrollPane1.setViewportView(jInfo);

        jBook.setText("Book trip");
        jBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookActionPerformed(evt);
            }
        });

        jDatesAvail.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jDatesAvail);

        jLabel1.setText("Available dates: ");

        jPanel4.setBackground(new java.awt.Color(192, 192, 192));

        jTripName.setFont(new java.awt.Font("Phosphate", 0, 36)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jTripName, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTripName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jClose)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2)
                            .addComponent(jBook, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jBook, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jClose)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogMoreInfoLayout = new javax.swing.GroupLayout(jDialogMoreInfo.getContentPane());
        jDialogMoreInfo.getContentPane().setLayout(jDialogMoreInfoLayout);
        jDialogMoreInfoLayout.setHorizontalGroup(
            jDialogMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogMoreInfoLayout.setVerticalGroup(
            jDialogMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 250, 240));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Price", "Location"
            }
        ));
        jScroll.setViewportView(jTable);

        jMoreInfo.setText("More info");
        jMoreInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMoreInfoActionPerformed(evt);
            }
        });

        jLabel2.setText("Search after text:");

        jSearch.setText("Search");
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });

        jPriceFrom.setMajorTickSpacing(50);
        jPriceFrom.setMaximum(500);
        jPriceFrom.setMinorTickSpacing(10);
        jPriceFrom.setPaintLabels(true);
        jPriceFrom.setPaintTicks(true);

        jLabel3.setText("Price range from (EUR):");

        jPriceTo.setMajorTickSpacing(50);
        jPriceTo.setMaximum(500);
        jPriceTo.setMinorTickSpacing(10);
        jPriceTo.setPaintLabels(true);
        jPriceTo.setPaintTicks(true);

        jLabel4.setText("Price range to (EUR):");

        jCheckReykjavik.setSelected(true);
        jCheckReykjavik.setText("Reykjavik (capital area)");

        jCheckNorth.setSelected(true);
        jCheckNorth.setText("North Iceland");

        jCheckSouth.setSelected(true);
        jCheckSouth.setText("South Iceland");

        jCheckWest.setSelected(true);
        jCheckWest.setText("West Iceland");

        jCheckEast.setSelected(true);
        jCheckEast.setText("East Iceland");

        jDateChooseTo.setBackground(new java.awt.Color(153, 204, 255));

        jDateChooseFrom.setBackground(new java.awt.Color(153, 204, 255));

        jLabel5.setText("From");

        jLabel6.setText("To");

        jPanel3.setBackground(new java.awt.Color(192, 192, 192));

        jLabel7.setFont(new java.awt.Font("Phosphate", 0, 36)); // NOI18N
        jLabel7.setText("Find your dream trip");

        jHostLogin.setText("Login as host");
        jHostLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHostLoginActionPerformed(evt);
            }
        });

        jLogout.setText("Log out");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jHostLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLogout, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jHostLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLogout)
                .addGap(18, 18, 18))
        );

        jCancelSearch.setText("Cancel search");
        jCancelSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckSouth)
                                    .addComponent(jCheckEast)
                                    .addComponent(jCheckWest)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCancelSearch)))
                                .addContainerGap(218, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckNorth)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(240, 240, 240)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jCheckReykjavik)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooseTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooseFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 52, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jMoreInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckReykjavik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooseFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckNorth)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckSouth)
                                .addComponent(jLabel6))
                            .addComponent(jDateChooseTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckEast)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckWest)
                                .addGap(67, 67, 67)
                                .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCancelSearch)))
                    .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jMenu1.setText("Host menu");

        jCreateTrip.setText("Create a trip");
        jCreateTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateTripActionPerformed(evt);
            }
        });
        jMenu1.add(jCreateTrip);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Gets all info for current selected trip and opens a more info dialog.
     * @param evt 
     */
    private void jMoreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMoreInfoActionPerformed

        Trip trip = getSelectedTrip();
        int n = jTable.getSelectedRow();
        trip.getName();

        jDialogMoreInfo.setSize(700,500);
        jDialogMoreInfo.setVisible(true); 
        
        String descr = trip.getDescription();
        ArrayList<String> types = trip.getTypes();
        String typestring = types.get(0);
        for(int i = 1; i<types.size();i++){
            typestring = " and " + types.get(i);
        }
        String time = trip.getTime();
        int price = trip.getPrice();
        String loc = trip.getLocation();
        int cap = trip.getCapacity();
        String dur = trip.getDuration();
        String everything = "Description: "+ descr +"\n" + "When : " + time + " for " + dur + " hours" + "\n"
                            + "Where: " + loc + "\n" + "Available spots: " + cap + "\n" + "Price: " + price;
                
                
        jInfo.setText(everything);
        
        String name = trip.getName();
        jTripName.setText(name);
        
        ArrayList<String> dates = trip.getDates();
        DefaultListModel datemodel = new DefaultListModel();
        for(int i = 0; i< dates.size();i++){
            datemodel.addElement(dates.get(i));
        }
        
        jDatesAvail.setModel(datemodel);
    }//GEN-LAST:event_jMoreInfoActionPerformed
    
    /**
     * Gets selected trip and opens a from of Booking view.
     * @param evt 
     */
    private void jBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookActionPerformed
        int n = jTable.getSelectedRow();
        DatabaseController cntr = new DatabaseController();
        Search search = new Search();
        ArrayList<Trip> tripList = search.resetSearch();
        
        selectedTrip = tripList.get(n);

        JFrame BookingView = new BookingView();
        BookingView.setVisible(true);
        jDialogMoreInfo.setVisible(false);
    }//GEN-LAST:event_jBookActionPerformed
    
    /**
     * Gets all user input and calls search class for searched trips.
     * @param evt 
     */
    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        // Make ArrayList<JCheckBox> for all checked boxes
        ArrayList<JCheckBox> checkboxes = getCheckboxes();
        ArrayList<String> locations = new ArrayList();
        
        for(int i = 0; i < checkboxes.size(); i++){
            if(checkboxes.get(i).isSelected()){
                locations.add(checkboxes.get(i).getText());
            }
        }
        // If no locations are selected, search in all locations.
        if(locations.isEmpty()){
            for(int i = 0; i < checkboxes.size(); i++){
                locations.add(checkboxes.get(i).getText());
            }
        }
        
        int priceLower = jPriceFrom.getValue();
        int priceHigher = jPriceTo.getValue();
        
        Date dateF = jDateChooseFrom.getDate();
        String dateFrom="";
        try{
           dateFrom = new SimpleDateFormat("yyyy-MM-dd").format(dateF);
        }catch (Exception e){
            if(dateF == null){
            Date date= new Date();
            dateFrom = new SimpleDateFormat("yyyy-MM-dd").format(date);
            }   
        }
        Date dateT = jDateChooseTo.getDate();
        String dateTo = "";
        try{
            dateTo = new SimpleDateFormat("yyyy-MM-dd").format(dateT);
        }catch (Exception e){
            if(dateT == null){
            Date date= new Date();
            dateTo = new SimpleDateFormat("yyyy-MM-dd").format(date);
            }    
        }

        String query = jSearchText.getText();
        
        Search search = new Search();
        try {
            ArrayList<Trip> search1 = search.search(locations, priceLower, priceHigher, dateFrom, dateTo, query);
            DefaultTableModel model = (DefaultTableModel)jTable.getModel();
            
            Object[] row = new Object[3];

            int rowCount = model.getRowCount();
            for(int i = rowCount - 1; i >= 0; i--){
                model.removeRow(i);
            }
            for(int i = 0; i<search1.size();i++){
                row[0]= search1.get(i).getName();
                row[1]= search1.get(i).getPrice();
                row[2]= search1.get(i).getLocation();
                model.insertRow(i, row);
        
            }
            jTable.setModel(model);
        } catch (ParseException ex) {
            Logger.getLogger(TripsView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jSearchActionPerformed
    /**
     * Opens a form of Login view.
     * @param evt 
     */
    private void jHostLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHostLoginActionPerformed
        JFrame Login = new LoginView();
        Login.setVisible(true);
    }//GEN-LAST:event_jHostLoginActionPerformed
    
    /**
     * Closes more info dialog.
     * @param evt 
     */
    private void jCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCloseActionPerformed
        jDialogMoreInfo.setVisible(false);
    }//GEN-LAST:event_jCloseActionPerformed
    
    /**
     * Opens a form of post trip view if user is logged in.
     * @param evt 
     */
    private void jCreateTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateTripActionPerformed
        PostTripView create = new PostTripView();
        HostLogin kisi = new HostLogin();
        
        if(kisi.getLoggedIn() == null || "".equals(kisi.getLoggedIn())){
            JOptionPane.showMessageDialog(this, "You must be logged in");
            create.setVisible(false);
            jLogout.setVisible(false);
        }else{
            create.setVisible(true);
            jLogout.setVisible(true);
        }
    }//GEN-LAST:event_jCreateTripActionPerformed
    
    /**
     * Cancels search and returns the initial list.
     * @param evt 
     */
    private void jCancelSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelSearchActionPerformed

        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        int rowCount = model.getRowCount();
        for(int i = rowCount - 1; i >= 0; i--){
            model.removeRow(i);
        }
        showTrips();
    }//GEN-LAST:event_jCancelSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TripsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TripsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TripsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TripsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TripsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBook;
    private javax.swing.JButton jCancelSearch;
    private javax.swing.JCheckBox jCheckEast;
    private javax.swing.JCheckBox jCheckNorth;
    private javax.swing.JCheckBox jCheckReykjavik;
    private javax.swing.JCheckBox jCheckSouth;
    private javax.swing.JCheckBox jCheckWest;
    private javax.swing.JButton jClose;
    private javax.swing.JMenuItem jCreateTrip;
    private com.toedter.calendar.JDateChooser jDateChooseFrom;
    private com.toedter.calendar.JDateChooser jDateChooseTo;
    private javax.swing.JList<String> jDatesAvail;
    private javax.swing.JDialog jDialogMoreInfo;
    private javax.swing.JButton jHostLogin;
    private javax.swing.JTextArea jInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jLogout;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jMoreInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSlider jPriceFrom;
    private javax.swing.JSlider jPriceTo;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jSearch;
    private javax.swing.JTextField jSearchText;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel jTripName;
    // End of variables declaration//GEN-END:variables
}
