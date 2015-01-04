/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.ihsan.gui;


import me.ihsan.*;
import java.io.File;
import me.ihsan.graph.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.swing.JFileChooser;
import me.ihsan.protege.SavePropertiesToOwl;


class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".csv");
        }
        @Override
        public String getDescription() {
            return "Comma Separeted Value Files (*.csv)";
        }
    } 

public class Main extends javax.swing.JFrame {
    String dopplerst="";
    static List<Integer> dopplerarrayint=new ArrayList();
   


        public Main() {
                initComponents();
        }

     
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Archivee = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Hasta = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        fileChooser.setDialogTitle("This is my open dialog");
        fileChooser.setFileFilter(new MyCustomFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Semantic Course Final App");

        textarea.setColumns(20);
        textarea.setRows(5);
        jScrollPane1.setViewportView(textarea);

        jMenu1.setText("Dosya");

        Open.setText("CSV Aç");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        Archivee.setText("Arşivle");
        Archivee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArchiveeActionPerformed(evt);
            }
        });
        jMenu1.add(Archivee);

        jMenuItem5.setText("Çıkış");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Görüntüle");

        jMenuItem1.setText("Uyarıları Görüntüle");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Grafikleri Görüntüle");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        Hasta.setText("Hasta");

        jMenuItem3.setText("Hasta Ekle");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Hasta.add(jMenuItem3);

        jMenuItem4.setText("Hasta Bilgilerini Düzenle");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Hasta.add(jMenuItem4);

        jMenuBar1.add(Hasta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
                
    int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
            
          textarea.read( new FileReader( file.getAbsolutePath() ), null );
          dopplerst = textarea.getText();
          System.out.println(dopplerst);
          String[] listt=dopplerst.split(";");
          List<String> dopplerarrayst =  Arrays.asList(listt);
          for(int i=0;i<dopplerarrayst.size();i++)
            {
                System.out.println(" -->"+dopplerarrayst.get(i));
                System.out.println(" gecti1");
                dopplerarrayint.add(Integer.parseInt(dopplerarrayst.get(i)));
                System.out.println(" gecti2");
                }
          //analiz çalışması yapılacak
          System.out.println(" gecti3");
           SavePropertiesToOwl so = new SavePropertiesToOwl();
           
          
        } catch (IOException ex) {
          System.out.println("problem accessing file"+file.getAbsolutePath());
        }
    } else {
        System.out.println("File access cancelled by user.");
    
        
} 
        }//GEN-LAST:event_OpenActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                        uyarigrafik ug = new uyarigrafik();
                    ug.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ArchiveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArchiveeActionPerformed
            
    }//GEN-LAST:event_ArchiveeActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Patient p = new Patient();
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       hastakayit hst = new hastakayit();
       hst.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        graphchart plotChart = new graphchart(dopplerarrayint);
        plotChart.execute();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                
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
                        java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new Main().setVisible(true);
                        }
                });
        }
        public static List getList()
        {
            return dopplerarrayint;
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Archivee;
    private javax.swing.JMenu Hasta;
    private javax.swing.JMenuItem Open;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables
}
