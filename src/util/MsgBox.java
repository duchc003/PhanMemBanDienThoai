/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MsgBox {

    public static void alert(Component p, String m) {
        JOptionPane.showMessageDialog(p, m, "Hệ thống quản lý của hàng bán điện thoại", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component p, String m) {
        int resul = JOptionPane.showConfirmDialog(p, m, "Hệ thống quản lý của hàng bán điện thoại", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return resul == JOptionPane.YES_OPTION;
    }

    public static String prompt(Component p, String m) {
        return JOptionPane.showInputDialog(p, m, "Hệ thống quản lý của hàng bán điện thoại", JOptionPane.INFORMATION_MESSAGE);
    }
}
