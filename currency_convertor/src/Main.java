package org.example;
import netscape.javascript.JSObject;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        JFrame Fereastra = new JFrame();

        Fereastra.setSize(400, 200);
        Fereastra.setTitle("Convertor monetar");
        Fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fereastra.setLocationRelativeTo(null);
        JPanel panou = new JPanel();



        panou.setLayout(new FlowLayout());


        JLabel suma = new JLabel("Introdu suma de bani:");
        panou.add(suma);

        JTextField camp_suma = new JTextField(20);
        panou.add(camp_suma);
        Fereastra.add(panou, BorderLayout.NORTH);

        JPanel panou_butoane = new JPanel();
       panou_butoane.setLayout(new FlowLayout());
        JLabel val_curenta = new JLabel("Selecteaza moneda curenta:");
        panou_butoane.add(val_curenta);

        String[] moneda_curenta = {"AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND",
                "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF",
                "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ",
                "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES",
                "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD",
                "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB",
                "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP",
                "SLE", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS", "UAH",
                "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"};

        JComboBox<String> ListaMonede_curente = new JComboBox<>(moneda_curenta);
        panou_butoane.add(ListaMonede_curente);

        JLabel val_selectata = new JLabel("Selecteaza moneda de schimb:");
       panou_butoane.add(val_selectata);
        JButton ok = new JButton("OK");
        JPanel panou2 = new JPanel();
        panou2.setLayout(new FlowLayout());
        panou2.add(ok);


        String[] moneda_selectata = {"AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND",
                "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF",
                "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ",
                "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES",
                "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD",
                "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB",
                "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP",
                "SLE", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS", "UAH",
                "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"};
        JComboBox<String> ListaMonede_selectate_ = new JComboBox<>(moneda_selectata);
        panou_butoane.add(ListaMonede_selectate_);
       Fereastra.add(panou_butoane, BorderLayout.CENTER);
        Fereastra.add(panou2, BorderLayout.SOUTH);
       panou2.setBackground(Color.BLUE);
        Fereastra.setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    double suma_primita = Double.parseDouble(camp_suma.getText());
                    if (suma_primita < 0) {
                        JOptionPane.showMessageDialog(null, "Introdu o sumă valida!");
                        return;
                    }
                    String dinMoneda = (String) (ListaMonede_curente.getSelectedItem());
                    String inMoneda = (String) (ListaMonede_selectate_.getSelectedItem());
                    if(dinMoneda==inMoneda){
                        JOptionPane.showMessageDialog(null, "Eroare! Monedele nu pot fi aceleasi!");
                        return;
                    }
                    double rezultat = converteste(suma_primita, dinMoneda, inMoneda);


                  JFrame fereastraRezultat = new JFrame("Rezultat");
                    fereastraRezultat.setSize(250, 100);
                    fereastraRezultat.setLocationRelativeTo(null);
                    JLabel labelRezultat = new JLabel("Rezultatul conversiei: " + rezultat+inMoneda.toLowerCase());

                    fereastraRezultat.add(labelRezultat);
                    fereastraRezultat.setVisible(true);
                } catch (NumberFormatException ex) {
                   JOptionPane.showMessageDialog(null, "Introdu o suma valida!");
                } catch (IOException ex)
                    {throw new RuntimeException(ex);
                }
            }
        });

    }

    private static double converteste(double suma, String dinMoneda, String inMoneda) throws IOException {
        String url_adresa = "https://api.exchangerate.host/convert?access_key=8ab400f997ec752d24eed50a31cf4bb7&from=" + dinMoneda.toUpperCase() + "&to=" + inMoneda.toUpperCase() + "&amount=" + suma;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url_adresa)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        String stringResponse = response.body().string();
        JSONObject jsObject = new JSONObject(stringResponse);
        BigDecimal rate = jsObject.getJSONObject("info").getBigDecimal("quote");
        double rata = rate.doubleValue();
        return suma * rata;
    }

}

