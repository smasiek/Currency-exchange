package com.miloszmomot.waluty;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        KantorNBPProcessor kantorNBPProcessor =new KantorNBPProcessor();
        ArrayList<Waluta> listaWalut= kantorNBPProcessor.setListaWalut();

        KantorView kantorView = new KantorView(listaWalut);
        KantorModel kantorModel = new KantorModel();
        KantorController kantorController = new KantorController(kantorView,kantorModel);

        kantorView.setVisible(true);
    }
}
