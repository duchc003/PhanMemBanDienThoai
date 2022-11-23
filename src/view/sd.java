/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class sd {

    public static void main(String[] args) {
        String dateStart = "2011/03/14";
        String dateStop = "2012/04/15";

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }

// Get msec from each, and subtract.
        long diff = d2.getYear() - d1.getYear(); //đay nè
        System.out.println(diff);
    }
}
