package org.example;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String args[]) throws ParseException {
        Main main = new Main();
        main.numberFormat();
        main.currencyFormat();
        main.currencyParser();
        main.numberFormatter();
        main.dateFormatter();
        main.resourceBundleTest();
    }

    public void numberFormat() {
        double num = 1.235;
        String USLocale = NumberFormat.getInstance(Locale.US).format(num);
        String italyLocale = NumberFormat.getInstance(Locale.ITALY).format(num);
        String frenchLocale = NumberFormat.getInstance(Locale.FRENCH).format(num);
        String chineseLocale = NumberFormat.getInstance(Locale.CHINESE).format(num);
        System.out.println("USLocale is " + USLocale);
        System.out.println("italyLocale is " + italyLocale);
        System.out.println("frenchLocale is " + frenchLocale);
        System.out.println("chineseLocale is " + chineseLocale);
    }
    public void currencyFormat(){
            double currency = 1000.25;
            String usCurrency = NumberFormat.getCurrencyInstance(Locale.US).format(currency);
            String ukCurrency = NumberFormat.getCurrencyInstance(Locale.UK).format(currency);
            String italyCurrency = NumberFormat.getCurrencyInstance(Locale.ITALY).format(currency);
            String chineseCurrency = NumberFormat.getCurrencyInstance(Locale.CHINESE).format(currency);
            String indianCurrency = NumberFormat.getCurrencyInstance().format(currency);
            System.out.println("usCurrency is " + usCurrency);
            System.out.println("ukCurrency is " + ukCurrency);
            System.out.println("italyCurrency is " + italyCurrency);
            System.out.println("chineseCurrency is " + chineseCurrency);
            System.out.println("indianCurrency is " + indianCurrency);
    }
        public void currencyParser() throws ParseException {
                double currency = 1000.25;
                Number usCurrency = NumberFormat.getCurrencyInstance(Locale.US).parse("$1000.25");
                String ukCurrency = NumberFormat.getCurrencyInstance(Locale.UK).format(currency);
                Number italyCurrency = NumberFormat.getCurrencyInstance(Locale.ITALY).parse("1.000,25 €");
                String chineseCurrency = NumberFormat.getCurrencyInstance(Locale.CHINESE).format(currency);
                String indianCurrency = NumberFormat.getCurrencyInstance().format(currency);
                System.out.println("usCurrency is " + usCurrency);
                System.out.println("ukCurrency is " + ukCurrency);
                System.out.println("italyCurrency is " + italyCurrency);
                System.out.println("chineseCurrency is " + chineseCurrency);
                System.out.println("indianCurrency is " + indianCurrency);
        }
        public void numberFormatter() throws ParseException {
                double currency = 1000.25;
                String format = "##,####,##.#";
                String nullFormat = "00,0000,00.0";
                System.out.println("new format is "+new DecimalFormat(format).format(currency));
                System.out.println("new null format is "+new DecimalFormat(nullFormat).format(currency));
        }
        public void dateFormatter(){
            LocalDateTime currTime = LocalDateTime.now();
            DateTimeFormatter longDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
            System.out.println("longDateFormatter is "+longDateFormatter.format(currTime));
            DateTimeFormatter shortDateFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.US);
            System.out.println("shortDateFormatter is "+shortDateFormatter.format(currTime));
            DateTimeFormatter mediumDateFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(Locale.US);
            System.out.println("mediumDateFormatter is "+mediumDateFormatter.format(currTime));

        }
        public void resourceBundleTest(){

             Locale localeCA = new Locale("en","CA");
            ResourceBundle bundle = ResourceBundle.getBundle("org//example//TestNew",localeCA);
        }


}