/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseController;
import Model.HostLogin;
import Model.Trip;
import com.toedter.calendar.JCalendar;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author karen
 */
public class PostTrip extends javax.swing.JFrame {
    
    private Trip tripObject;
    private HostLogin host;
  
    /**
     * Creates new form PostTrip
     */
    public PostTrip() {
        initComponents();  
        jLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reykjavik (capital area)", "North Iceland", "South Iceland","West Iceland","East Iceland"}));
        jTimeFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "12:00", "12:30", "1:00","1:30","2:00", "2:30", "3:00", "3:30",
            "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30",
            "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30"
        }));      
        jTimeTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "12:00", "12:30", "1:00","1:30","2:00", "2:30", "3:00", "3:30",
            "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30",
            "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30"
        }));
        jPMAM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PM","AM"}));
        jPMAM2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PM","AM"}));
        DefaultListModel<String> listModel = new DefaultListModel<>();
        jDateList.setModel(listModel);


    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTripName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTripDescr = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLocation = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTimeFrom = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTimeTo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPMAM = new javax.swing.JComboBox<>();
        jPMAM2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jExtreme = new javax.swing.JCheckBox();
        jHorse = new javax.swing.JCheckBox();
        jHikeYoga = new javax.swing.JCheckBox();
        jOvernight = new javax.swing.JCheckBox();
        jSightseeing = new javax.swing.JCheckBox();
        jSailFish = new javax.swing.JCheckBox();
        jNorthLights = new javax.swing.JCheckBox();
        jHotSpring = new javax.swing.JCheckBox();
        jOther = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jCapacity = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPrice = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jPost = new javax.swing.JButton();
        jChooseDate = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDateList = new javax.swing.JList<>();
        jAddDate = new javax.swing.JButton();
        jDeleteDate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 1, 36)); // NOI18N
        jLabel1.setText("Create your trip");

        jLabel2.setText("Name of trip:");

        jTripDescr.setColumns(20);
        jTripDescr.setRows(5);
        jScrollPane2.setViewportView(jTripDescr);

        jLabel3.setText("Description:");

        jLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLocationActionPerformed(evt);
            }
        });

        jLabel4.setText("Location");

        jTimeFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Time from:");

        jTimeTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Time to:");

        jPMAM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPMAM2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        jExtreme.setText("Extreme sport");
        jPanel2.add(jExtreme);

        jHorse.setText("Horseback");
        jPanel2.add(jHorse);

        jHikeYoga.setText("Hiking/Yoga");
        jPanel2.add(jHikeYoga);

        jOvernight.setText("Over-night");
        jPanel2.add(jOvernight);

        jSightseeing.setText("Sightseeing");
        jPanel2.add(jSightseeing);

        jSailFish.setText("Sailing/Fishing");
        jPanel2.add(jSailFish);

        jNorthLights.setText("Northern Lights");
        jPanel2.add(jNorthLights);

        jHotSpring.setText("Hot Spring tour");
        jHotSpring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHotSpringActionPerformed(evt);
            }
        });
        jPanel2.add(jHotSpring);

        jOther.setText("Other");
        jPanel2.add(jOther);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Dates:");

        jLabel8.setText("Capacity:");

        jLabel9.setText("Price:");

        jLabel10.setText("EUR");

        jPost.setText("Post");
        jPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPostActionPerformed(evt);
            }
        });

        jDateList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jDateList);

        jAddDate.setText("Add date");
        jAddDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddDateActionPerformed(evt);
            }
        });

        jDeleteDate.setText("Delete date");
        jDeleteDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTimeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPMAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jTimeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPMAM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                            .addComponent(jCapacity, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jAddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDeleteDate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1))))
                    .addComponent(jTripName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTripName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTimeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jPMAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTimeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jPMAM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jAddDate)
                                        .addComponent(jDeleteDate)))
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPost, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLocationActionPerformed

    private void jHotSpringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHotSpringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHotSpringActionPerformed

    private void jPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPostActionPerformed
        // TODO add your handling code here:
       String name = jTripName.getText();
       String descr = jTripDescr.getText();
       
       String location = "" + jLocation.getSelectedItem();
       System.out.println(location);
       
       String timefrom = "" + jTimeFrom.getSelectedItem() + jPMAM.getSelectedItem();
       String timeto = "" + jTimeTo.getSelectedItem() + jPMAM2.getSelectedItem();
       System.out.println(timefrom + timeto);
       
       int capac = (int) jCapacity.getValue();
       int price = (int) jPrice.getValue();
       
      /*
       * Types
       */
       ArrayList<String> types = new ArrayList();
       if(jExtreme.isSelected())    types.add(jExtreme.getText());
       if(jHikeYoga.isSelected())    types.add(jHikeYoga.getText());
       if(jHorse.isSelected())    types.add(jHorse.getText());
       if(jHotSpring.isSelected())    types.add(jHotSpring.getText());
       if(jNorthLights.isSelected())    types.add(jNorthLights.getText());
       if(jOvernight.isSelected())    types.add(jOvernight.getText());
       if(jSightseeing.isSelected())    types.add(jSightseeing.getText());
       if(jSailFish.isSelected())    types.add(jSailFish.getText());
       if(jOther.isSelected())    types.add(jOther.getText());
       
      
       /*
        *  Dates
        */
        int listLength = jDateList.getModel().getSize();
        ArrayList<String> dates = new ArrayList();
        System.out.println(listLength);
        for(int i = 0; i < listLength; i++){
            String elem = jDateList.getModel().getElementAt(i);
            dates.add(elem);   
        }
        //DatabaseController.isertTrip();
        
        
        
        
    }//GEN-LAST:event_jPostActionPerformed

    private void jAddDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddDateActionPerformed
        // TODO add your handling code here:
        DefaultListModel model = (DefaultListModel) jDateList.getModel();
        String t = "" + jChooseDate.getDate();
        model.addElement(t);
        jDateList.setModel(model);

    }//GEN-LAST:event_jAddDateActionPerformed

    private void jDeleteDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteDateActionPerformed
        // TODO add your handling code here:
        if(!jDateList.isSelectionEmpty()){
            int i = jDateList.getSelectedIndex();
            System.out.println(i);
            DefaultListModel model = (DefaultListModel) jDateList.getModel();
            model.remove(i);

            jDateList.setModel(model);
        }
        
        
    }//GEN-LAST:event_jDeleteDateActionPerformed

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
            java.util.logging.Logger.getLogger(PostTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostTrip().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddDate;
    private javax.swing.JSpinner jCapacity;
    private com.toedter.calendar.JDateChooser jChooseDate;
    private javax.swing.JList<String> jDateList;
    private javax.swing.JButton jDeleteDate;
    private javax.swing.JCheckBox jExtreme;
    private javax.swing.JCheckBox jHikeYoga;
    private javax.swing.JCheckBox jHorse;
    private javax.swing.JCheckBox jHotSpring;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jLocation;
    private javax.swing.JCheckBox jNorthLights;
    private javax.swing.JCheckBox jOther;
    private javax.swing.JCheckBox jOvernight;
    private javax.swing.JComboBox<String> jPMAM;
    private javax.swing.JComboBox<String> jPMAM2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jPost;
    private javax.swing.JSpinner jPrice;
    private javax.swing.JCheckBox jSailFish;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jSightseeing;
    private javax.swing.JComboBox<String> jTimeFrom;
    private javax.swing.JComboBox<String> jTimeTo;
    private javax.swing.JTextArea jTripDescr;
    private javax.swing.JTextField jTripName;
    // End of variables declaration//GEN-END:variables


   



    }
