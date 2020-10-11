package com.miloszmomot.waluty;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KantorView extends JFrame {

    private JLabel iloscWalutyLabel = new JLabel("Ilość waluty: ");
    private JTextField iloscWalutyText = new JTextField(10);
    private JLabel walutaZrodlowaLabel = new JLabel("Waluta źródłowa: ");
    private JComboBox walutaZrodlowaCombo;
    private JLabel walutaDocelowaLabel = new JLabel("Waluta docelowa: ");
    private JComboBox walutaDocelowaCombo;
    private JButton przewalutujButton = new JButton("Calculate");
    private JTextField wynikPrzewalutowaniaText = new JTextField(10);

    public KantorView(ArrayList<Waluta> listaWalut) {
        JPanel kantorPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 120);
        this.setTitle("Kalkulator walut by Miłosz Momot");

        String[] dostepneWaluty = new String[listaWalut.size()];
        for (int i = 0; i < dostepneWaluty.length; i++) {
            dostepneWaluty[i] = listaWalut.get(i).getNazwaWaluty();
        }

        walutaZrodlowaCombo = new JComboBox(dostepneWaluty);
        walutaDocelowaCombo = new JComboBox(dostepneWaluty);

        kantorPanel.add(iloscWalutyLabel);
        kantorPanel.add(iloscWalutyText);
        kantorPanel.add(walutaZrodlowaLabel);
        kantorPanel.add(walutaZrodlowaCombo);
        kantorPanel.add(walutaDocelowaLabel);
        kantorPanel.add(walutaDocelowaCombo);
        kantorPanel.add(przewalutujButton);
        kantorPanel.add(wynikPrzewalutowaniaText);

        this.add(kantorPanel);
    }

    public double getIloscWaluty(){
        return Double.parseDouble(iloscWalutyText.getText());
    }

    public int getZrodlowaWalutaIndex(){
        return walutaZrodlowaCombo.getSelectedIndex();
    }

    public int getDocelowaWalutaIndex(){
        return walutaDocelowaCombo.getSelectedIndex();
    }

    public void setWynikPrzewalutowaniaText(double wynikPrzewalutowania){
        wynikPrzewalutowaniaText.setText(Double.toString(wynikPrzewalutowania));
    }

    void addPrzewalutowanieListener(ActionListener listenForPrzewalutowanieButtonClick){
        przewalutujButton.addActionListener(listenForPrzewalutowanieButtonClick);
    }

    void showErrorMessage(String wiadomosc){
        JOptionPane.showMessageDialog(this,wiadomosc);
    }




}
