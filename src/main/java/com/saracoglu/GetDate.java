package com.saracoglu;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class GetDate {
    public static String getDateInfo(){
        Scanner kb = new Scanner(System.in);
        while(true) {
            System.out.println("tarihi (YYYY-MM-DD formatında) giriniz: ");
            String date = kb.nextLine();
            if(!formatCheck(date))
                System.out.println("yanlış formatta girdiniz !");
            else if (!isValidDate(date))
                System.out.println("geçersiz tarih girdiniz !");
            else return date;
        }
    }
    private static boolean formatCheck(String date)
    {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    private static boolean isValidDate(String date)
    {
        //parse metodu Stringi Date'e çevirir. çeviremezse, validdate değilse exception oluşur
        try{
            LocalDate.parse(date);
            return true;
        }
        catch (DateTimeException e)
        {
            return false;
        }
    }

}
