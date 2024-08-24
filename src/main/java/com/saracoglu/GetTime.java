package com.saracoglu;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Scanner;

public class GetTime {
    public static String getTimeInfo(){
        Scanner kb = new Scanner(System.in);
        while(true) {
            System.out.println("saati HH formatında giriniz:  ");
            String time = kb.nextLine();
            if(!formatCheck(time))
                System.out.println("yanlış formatta girdiniz !");
            else if (!isValidTime(time))
                System.out.println("geçersiz saat girdiniz !");
            else return time.concat(":00:00");
        }
    }
    private static boolean formatCheck(String time)
    {
        return time.matches("\\d{2}");
    }

    private static boolean isValidTime(String time)
    {
        //LocalTime.parse metodu parametresi ile aldığı String'i saate çevirir.
        try{
            LocalTime hour = LocalTime.parse(time.concat(":00:00"));
            return true;
        }
        catch (DateTimeException e)
        {
            return false;
        }
    }
}
