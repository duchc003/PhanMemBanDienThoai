/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import service.impl.QuenMatKhauServiceImpl;
import viewmodel.QuenMatKhauModel;

/**
 *
 * @author ASUS
 */
public class QuenMatKhau extends javax.swing.JFrame {

    private QuenMatKhauServiceImpl quenMatKhauServices = new QuenMatKhauServiceImpl();
    List<QuenMatKhauModel> lists = new ArrayList<>();
    private Random rd = new Random();
    private int maXacNhan = rd.nextInt(999999);
    //namnam

    public QuenMatKhau() {
        initComponents();
        setLocationRelativeTo(null);

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
        txtMaCode = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSendCode = new javax.swing.JButton();
        lblmatkhau = new javax.swing.JLabel();
        txtNhapLaiMatKhau = new javax.swing.JPasswordField();
        txtMatKhau = new javax.swing.JPasswordField();
        lblthongbao = new javax.swing.JLabel();
        lblnhapLaiMk = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        btnXacNhan.setBackground(new java.awt.Color(51, 255, 51));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/check-mark.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã Nhân Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã Xác Nhận");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mật khẩu mới");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu");

        btnSendCode.setBackground(new java.awt.Color(51, 255, 51));
        btnSendCode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSendCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/email.png"))); // NOI18N
        btnSendCode.setText("Send code");
        btnSendCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendCodeActionPerformed(evt);
            }
        });

        lblmatkhau.setBackground(new java.awt.Color(255, 255, 255));
        lblmatkhau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblmatkhau.setForeground(new java.awt.Color(255, 0, 51));
        lblmatkhau.setAutoscrolls(true);

        txtNhapLaiMatKhau.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNhapLaiMatKhauCaretUpdate(evt);
            }
        });

        txtMatKhau.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMatKhauCaretUpdate(evt);
            }
        });

        lblthongbao.setBackground(new java.awt.Color(0, 255, 153));
        lblthongbao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblthongbao.setForeground(new java.awt.Color(0, 255, 51));
        lblthongbao.setAutoscrolls(true);

        lblnhapLaiMk.setBackground(new java.awt.Color(0, 255, 153));
        lblnhapLaiMk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnhapLaiMk.setForeground(new java.awt.Color(255, 0, 51));
        lblnhapLaiMk.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaCode, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnXacNhan))
                            .addComponent(txtNhapLaiMatKhau)
                            .addComponent(txtMatKhau))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnhapLaiMk, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSendCode))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblthongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendCode)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNhapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblnhapLaiMk, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnXacNhan)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCodeActionPerformed
        int luachon = JOptionPane.showConfirmDialog(this, "Xác nhận gửi mã?");
        if (luachon == JOptionPane.YES_OPTION) {
            if (txtMa.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên !");
                return;
            }
            lists = quenMatKhauServices.getEmail(txtMa.getText());

            if (lists.size() <= 0) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại !");
                return;
            }
            String email = lists.get(0).toString();

<<<<<<< HEAD
            final String username = "huyhmph22668@fpt.edu.vn";
            final String password = "huy180803";
=======
            final String username = "hieunmph22569@fpt.edu.vn";
            final String password = "15012003";
>>>>>>> 77f34ad9124592ba40003ffbe109873ea2bd7d35
            Properties prop = new Properties();
            prop.setProperty("mail.smtp.host", "smtp.gmail.com");
            prop.setProperty("mail.smtp.port", "587");
            prop.setProperty("mail.smtp.starttls.enable", "true");
            prop.setProperty("mail.smtp.auth", "true");

            Session session = Session.getInstance(prop,
                    new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message message = new MimeMessage(session);
<<<<<<< HEAD
                message.setFrom(new InternetAddress("huyhmph22668@fpt.edu.vn"));
=======
                message.setFrom(new InternetAddress("hieunmph22569@fpt.edu.vn"));
>>>>>>> 77f34ad9124592ba40003ffbe109873ea2bd7d35
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject("Mã xác nhận");
                message.setText("Mã xác nhận của bạn là : " + maXacNhan
                        + "\n \n" + "Vui lòng không chia sẻ mã này để tránh mất tài khoản");
                Transport.send(message);
                lblthongbao.setText("Đã gửi mã xác nhận tới email "
                        + email);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        if (luachon == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "đã hủy");
        }
    }//GEN-LAST:event_btnSendCodeActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        int luachon = JOptionPane.showConfirmDialog(this, "Xác nhận đổi mật khẩu ?");
        if (luachon == JOptionPane.YES_OPTION) {
            if (validateForm() == false) {
                return;
            }
            if (validatePass() == false) {
                return;
            }
            System.out.println(maXacNhan);
            if (txtMaCode.getText().equals(String.valueOf(maXacNhan)) == true) {
                String ma = txtMa.getText();
                String matKhau = txtMatKhau.getText();
                JOptionPane.showMessageDialog(this, quenMatKhauServices.update(matKhau, ma));
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Mã xác nhận không đúng \n Vui lòng Kiểm tra lại email");
                return;
            }
        }
        if (luachon == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Đã hủy");
        }


    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtMatKhauCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMatKhauCaretUpdate
        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        if (p.matcher(txtMatKhau.getText()).find() == true) {
            lblmatkhau.setText("Mật khẩu mạnh");
            lblmatkhau.setForeground(Color.green);
        }
        if (p.matcher(txtMatKhau.getText()).find() == false) {
            lblmatkhau.setText("Mật khẩu yếu");
            lblmatkhau.setForeground(Color.red);
        }
    }//GEN-LAST:event_txtMatKhauCaretUpdate

    private void txtNhapLaiMatKhauCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNhapLaiMatKhauCaretUpdate
        if (txtMatKhau.getText().equals(txtNhapLaiMatKhau.getText())) {
            lblnhapLaiMk.setText("Khớp");
            lblnhapLaiMk.setForeground(Color.green);
        } else {
            lblnhapLaiMk.setText("Không khớp");
            lblnhapLaiMk.setForeground(Color.red);
        }
    }//GEN-LAST:event_txtNhapLaiMatKhauCaretUpdate

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
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendCode;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lblnhapLaiMk;
    private javax.swing.JLabel lblthongbao;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaCode;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtNhapLaiMatKhau;
    // End of variables declaration//GEN-END:variables

    private boolean validateForm() {
        if (txtMa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã");
            return false;
        }
        if (txtMaCode.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã xác nhận");
            return false;
        }
        if (txtMatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu");
            return false;
        }
        if (txtNhapLaiMatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lại mật khẩu");
            return false;
        }
        return true;
    }

    private boolean validatePass() {
        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        if (p.matcher(txtMatKhau.getText()).find() == false) {
            JOptionPane.showMessageDialog(this, " Mật khẩu tối thiểu tám ký tự \n Ít nhất một chữ cái viết hoa\n Một chữ cái viết thường \n Một số và một ký tự đặc biệt!");
            return false;
        }
        return true;
    }

    private void clearForm() {
        txtMa.setText("");
        txtMaCode.setText("");
        txtMatKhau.setText("");
        txtNhapLaiMatKhau.setText("");
        lblmatkhau.setText("");
        lblnhapLaiMk.setText("");
        lblthongbao.setText("");

    }
}
