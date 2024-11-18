import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        JFrame Fereastra = new JFrame();

        Fereastra.setSize(350, 200);
        ;
        Fereastra.setTitle("Fereastra principala");
        Fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JLabel mesaj = new JLabel("Bine ai venit în aplicația mea!");
        // Fereastra.add(mesaj, BorderLayout.NORTH);
        JPanel panou = new JPanel();
        panou.setLayout(new FlowLayout());
        //panel.setLayout(); // Setează layout-ul pentru panou

        // Adaugă eticheta pentru suma de bani
        JLabel suma = new JLabel("Introdu suma de bani:", SwingConstants.LEFT);
        panou.add(suma); // Adaugă eticheta în panou

        // Creează câmpul de text
        JTextField camp_suma = new JTextField(20); // Lățimea câmpului de text
        panou.add(camp_suma); // Adaugă câmpul de text în panou

        // Adaugă panoul în fereastră
        Fereastra.add(panou, BorderLayout.NORTH);

        JPanel panou_butoane = new JPanel();
        //  panou.setLayout(new BoxLayout( panou_butoane, BoxLayout.Y_AXIS));
        panou_butoane.setLayout(new FlowLayout());
        JLabel val_curenta = new JLabel("Selecteaza moneda curenta:");
        panou_butoane.add(val_curenta);
        String[] moneda_curenta = {"RON", "EUR", "USD", "GBP"};
        JComboBox<String> ListaMonede_curente = new JComboBox<>(moneda_curenta);
        panou_butoane.add(ListaMonede_curente);

        JLabel val_selectata = new JLabel("Selecteaza moneda de schimb:");
        panou_butoane.add(val_selectata);
        JButton ok = new JButton("OK");
        JPanel panou2 = new JPanel();
        panou2.setLayout(new FlowLayout());
        panou2.add(ok);


        //  JButton ron = new JButton("RON");
        // ron.setSize();
        // panou_butoane.add(ron);
        // JButton dolari = new JButton("DOLARS");
        //panou_butoane.add(dolari);


        String[] moneda_selectata = {"RON", "EUR", "USD", "GBP"};
        JComboBox<String> ListaMonede_selectate_ = new JComboBox<>(moneda_selectata);
        panou_butoane.add(ListaMonede_selectate_);
        Fereastra.add(panou_butoane, BorderLayout.CENTER);
        Fereastra.add(panou2, BorderLayout.SOUTH);
        Fereastra.setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double suma_primita = Double.parseDouble(camp_suma.getText());
                    String dinMoneda = (String) (ListaMonede_curente.getSelectedItem());
                    String inMoneda = (String) (ListaMonede_selectate_.getSelectedItem());
                    double rezultat = converteste(suma_primita, dinMoneda, inMoneda);


                    // Deschide o nouă fereastră pentru a afișa rezultatul
                    JFrame fereastraRezultat = new JFrame("Rezultat");
                    fereastraRezultat.setSize(300, 200);
                    fereastraRezultat.setLocationRelativeTo(null);// Centrează fereastra
                    JLabel labelRezultat = new JLabel("Rezultatul conversiei: " + rezultat);
                    fereastraRezultat.add(labelRezultat);
                    fereastraRezultat.setVisible(true);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introdu o sumă validă!");
                }
            }
        });

    }

    private static double converteste(double suma, String dinMoneda, String inMoneda) {
        double rataConversie = obtineRataConversie(dinMoneda, inMoneda);
        return suma * rataConversie;
    }

    private static double obtineRataConversie(String dinMoneda, String inMoneda) {
        if (dinMoneda.equals(inMoneda)) {
            return 1;
        }
        switch (dinMoneda) {
            case "RON":
                switch (inMoneda) {
                    case "EUR":
                        return 0.2;
                    case "USD":
                        return 0.23;
                    case "GBP":
                        return 0.17;
                }
                break;
            case "EUR":
                switch (inMoneda) {
                    case "RON":
                        return 5;
                    case "USD":
                        return 1.1;
                    case "GBP":
                        return 0.85;
                }
                break;
            case "USD":
                switch (inMoneda) {
                    case "RON":
                        return 4.3;
                    case "EUR":
                        return 0.9;
                    case "GBP":
                        return 0.78;
                }
                break;
            case "GBP":
                switch (inMoneda) {
                    case "RON":
                        return 5.7;
                    case "EUR":
                        return 1.18;
                    case "USD":
                        return 1.28;
                }
                break;
            default:
                System.out.println("Moneda nu este suportată");
                return 0;
        }
        return 0;
    }
}



