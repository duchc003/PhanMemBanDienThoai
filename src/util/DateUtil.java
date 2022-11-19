/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class DateUtil {
    
    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd");
    
    public java.util.Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return DateUtil.now();
            }
            return DATE_FORMATER.parse(date);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static java.util.Date now() {
        return new java.util.Date();
    }
}
