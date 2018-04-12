/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseController;
import Model.Search;
import Model.Trip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;


/**
 *
 * @author hugrungudmundsdottir
 */
public class TripsView extends javax.swing.JFrame {

    
    /**
     * Creates new form TripsView
     */
    public TripsView() {
        initComponents();
      
        
    }
    public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:dayTripsDB.db", "root", "");
            return con;
        } catch(SQLException e){
            return null;
        }
        
        
    }
    
    public void showTrips(){
        DatabaseController cntr = new DatabaseController();
        ArrayList<Trip> tripList =cntr.getTripList();
        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i < tripList.size(); i++){
            row[0]= tripList.get(i).getName();
            row[1]= tripList.get(i).getPrice();
            row[2]= tripList.get(i).getLocation();
        }
    }
    
    public ArrayList<JCheckBox> getCheckboxes(){
        ArrayList<JCheckBox> checkboxes = new ArrayList();
        checkboxes.add(jCheckReykjavik);
        checkboxes.add(jCheckNorth);
        checkboxes.add(jCheckSouth);
        checkboxes.add(jCheckWest);
        checkboxes.add(jCheckEast);
        return checkboxes;
    }
    
    /*public ArrayList<String> getSelectedDates(){
        Date from = jDateChooseFrom.getDate();
        Date to = jDateChooseTo.getDate();
    }*/
   
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
        jLabel1 = new javax.swing.JLabel();
        jBook = new javax.swing.JButton();
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

        jClose.setText("Close");

        jInfo.setColumns(20);
        jInfo.setRows(5);
        jScrollPane1.setViewportView(jInfo);

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 1, 18)); // NOI18N
        jLabel1.setText(this.getName());

        jBook.setText("Book trip");
        jBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jClose)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBook))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jClose)
                    .addComponent(jBook))
                .addContainerGap())
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

        jLabel3.setText("Price range from (thousand/isk):");

        jPriceTo.setMajorTickSpacing(50);
        jPriceTo.setMaximum(500);
        jPriceTo.setMinorTickSpacing(10);
        jPriceTo.setPaintLabels(true);
        jPriceTo.setPaintTicks(true);

        jLabel4.setText("Price range to (thousand/isk):");

        jCheckReykjavik.setSelected(true);
        jCheckReykjavik.setText("Reykjavik(capital area)");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jHostLogin)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jHostLogin))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckSouth)
                            .addComponent(jCheckNorth)
                            .addComponent(jCheckEast)
                            .addComponent(jCheckWest)
                            .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(240, 240, 240)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jCheckReykjavik)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooseTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooseFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel3)))
                        .addGap(0, 52, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jMoreInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckReykjavik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckNorth)
                                .addComponent(jLabel5))
                            .addComponent(jDateChooseFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckSouth)
                                .addComponent(jLabel6))
                            .addComponent(jDateChooseTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckEast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckWest)
                        .addGap(67, 67, 67)
                        .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

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

    private void jMoreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMoreInfoActionPerformed
        // TODO add your handling code here:
        //int n = JOptionPane.showConfirmDialog(this, evt, title, WIDTH, HEIGHT
        jDialogMoreInfo.setSize(200,200);
        jDialogMoreInfo.setVisible(true);
    }//GEN-LAST:event_jMoreInfoActionPerformed

    private void jBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookActionPerformed
        // TODO add your handling code here:
        //bookthistrip
        JFrame BookingView = new BookingView();
        BookingView.setVisible(true);
        jDialogMoreInfo.setVisible(false);
 
    }//GEN-LAST:event_jBookActionPerformed

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
        String dateFrom = "";
        Date dateF = jDateChooseFrom.getDate();
        try{
            dateFrom = DateFormat.getDateInstance().format(dateF);
        }catch (Exception e){
            if(dateF == null){
            Date date= new Date();
            dateFrom = DateFormat.getDateInstance().format(date);
            }   
        }
        Date dateT = jDateChooseTo.getDate();
        String dateTo = "";
        try{
            dateTo = DateFormat.getDateInstance().format(dateT);
        }catch (Exception e){
            if(dateT == null){
            Date date= new Date();
            dateTo = DateFormat.getDateInstance().format(date);
            }    
        }
  
        if(dateT == null){
            Date date= new Date();
            dateTo = DateFormat.getDateInstance().format(date);
        }

        String query = jSearchText.getText();
        
        Search search = new Search();
        search.search(locations, priceLower, priceHigher, dateFrom, dateTo, query);
    }//GEN-LAST:event_jSearchActionPerformed

    private void jHostLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHostLoginActionPerformed
        // TODO add your handling code here:
        JFrame Login = new LoginView();
        Login.setVisible(true);
    }//GEN-LAST:event_jHostLoginActionPerformed

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
    private javax.swing.JCheckBox jCheckEast;
    private javax.swing.JCheckBox jCheckNorth;
    private javax.swing.JCheckBox jCheckReykjavik;
    private javax.swing.JCheckBox jCheckSouth;
    private javax.swing.JCheckBox jCheckWest;
    private javax.swing.JButton jClose;
    private com.toedter.calendar.JDateChooser jDateChooseFrom;
    private com.toedter.calendar.JDateChooser jDateChooseTo;
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
    private javax.swing.JButton jMoreInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jPriceFrom;
    private javax.swing.JSlider jPriceTo;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSearch;
    private javax.swing.JTextField jSearchText;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
