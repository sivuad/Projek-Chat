/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tes.prog.chat1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;

/**
 *
 * @author sivu
 */
public class prjek_chat extends javax.swing.JFrame implements Runnable{

    Socket client; // class socket untuk client
    ServerSocket server; // class socket untuk server
    BufferedReader server_reader, client_reader; // buffered messege
    BufferedWriter server_writer, client_writer; // buffered typing
    /**
     * Creates new form prjek_chat
     */
    public prjek_chat() {
        initComponents();
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
        cboKoneksi = new javax.swing.JComboBox<>();
        btnKoneksi = new javax.swing.JButton();
        jtUser = new javax.swing.JTextField();
        listChat = new java.awt.List();
        jtChat = new java.awt.TextField();
        btnKirim = new java.awt.Button();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        cboKoneksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Server", "Client" }));
        cboKoneksi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboKoneksiItemStateChanged(evt);
            }
        });

        btnKoneksi.setText("ON");
        btnKoneksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoneksiActionPerformed(evt);
            }
        });

        jtUser.setText("Username");

        jtChat.setText("Type Chat");

        btnKirim.setLabel("Send");
        btnKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimActionPerformed(evt);
            }
        });

        label1.setForeground(new java.awt.Color(204, 255, 0));
        label1.setText("PROJEK CHAT SEDERHANA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtUser)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKoneksi)
                    .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listChat, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKirim, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboKoneksiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKoneksiItemStateChanged
        if (cboKoneksi.getSelectedItem().equals("Server")) {
            btnKoneksi.setText("ON");
            jtUser.setText("Server");
        } else {
            btnKoneksi.setText("Hubungkan");
            jtUser.setText("Client");
        }
    }//GEN-LAST:event_cboKoneksiItemStateChanged

    private void btnKoneksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoneksiActionPerformed
        // TODO add your handling code here:
        if (btnKoneksi.getText().equals("Hubungkan")) {
            btnKoneksi.setText("Putuskan");
            client_connection();
            Thread thread = new Thread(this);
            thread.start();
        } else if (cboKoneksi.getSelectedItem().equals("Server")){
            btnKoneksi.setText("OFF");
            read_connection();
            Thread thread = new Thread(this);
            thread.start();
        }
    }//GEN-LAST:event_btnKoneksiActionPerformed

    private void btnKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimActionPerformed
        // TODO add your handling code here:
        try {
            server_writer.write(jtUser.getText() + ": " + jtChat.getText());
            server_writer.newLine();
            server_writer.flush();
        }
        catch (IOException e){
            Logger.getLogger(prjek_chat.class.getName()).log(Level.SEVERE, null, e);
        }
        listChat.add("Me: "+jtChat.getText());
        jtChat.setText("");
    }//GEN-LAST:event_btnKirimActionPerformed
    
    
    private void client_connection(){
        try{
            String ip_address   = JOptionPane.showInputDialog("Masukkan Alamat IP Server!");
            client      = new Socket(ip_address, 2000);
            cboKoneksi.setEnabled(false);
            server_reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            server_writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            btnKoneksi.setText("Putuskan");
        } catch (UnknownHostException e){
            System.err.println("Akses server gagal!!!");
            System.exit(-1);
        } catch (IOException e) {
            Logger.getLogger(prjek_chat.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void read_connection(){
        try {
            try {
                try {
                    server  = new ServerSocket(2000);
                    this.setTitle("Mohon Tunggu Sebentar ...");
                } catch (IOException e) {
                     System.err.println("Gagal membuat server");
                    System.exit(-1);
                }
                 client = server.accept();
                this.setTitle("Terhubung ke "+client.getInetAddress());
            } catch (IOException e) {
                System.err.println("Akses ditolak");
                System.exit(-1);
            }
            server_reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            server_writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            System.err.println("Tidak dapat membaca pesan");
            System.exit(-1);
        }
    }
    private void disconnected_by_client(){
        try {
            client.close();
            server_reader.close();
            server_writer.close();
            cboKoneksi.setEnabled(true);
            btnKoneksi.setText("Hubungkan");
        } catch (IOException e) {
            Logger.getLogger(prjek_chat.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void stopped_by_client(){
        try {
            server_reader.close();
            server_writer.close();
            btnKoneksi.setText("ON");
            this.setTitle("Terputus");
        } catch (Exception e) {
            Logger.getLogger(prjek_chat.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
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
            java.util.logging.Logger.getLogger(prjek_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prjek_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prjek_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prjek_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prjek_chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnKirim;
    private javax.swing.JButton btnKoneksi;
    private javax.swing.JComboBox<String> cboKoneksi;
    private javax.swing.JPanel jPanel1;
    private java.awt.TextField jtChat;
    private javax.swing.JTextField jtUser;
    private java.awt.Label label1;
    private java.awt.List listChat;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {            
            try {
                listChat.add(server_reader.readLine());
            } catch (IOException e) {
                Logger.getLogger(prjek_chat.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
