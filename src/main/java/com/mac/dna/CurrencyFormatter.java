package com.mac.dna;

import java.text.NumberFormat;
import java.util.stream.Stream;

public class CurrencyFormatter {
    public static void main(String[] args) {
        double money = 100.1;
        System.out.println(formatCurrency(money));
    }

    private static String formatCurrency(double money) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
      return currency.format(money);
    }
}
