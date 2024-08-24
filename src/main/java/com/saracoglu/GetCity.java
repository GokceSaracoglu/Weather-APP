package com.saracoglu;


import java.util.Scanner;

public class GetCity {
    public static String getCityName() {
        Scanner kb = new Scanner(System.in);
        while(true) {
            System.out.println("Şehir ismini giriniz:");
            String str = kb.nextLine();
            if (str.equalsIgnoreCase("istanbul") || str.equalsIgnoreCase("ankara"))
                return str;
            System.out.println("hatalı giriş yaptınız..");
        }
    }


}
