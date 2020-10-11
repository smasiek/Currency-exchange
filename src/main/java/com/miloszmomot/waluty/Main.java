package com.miloszmomot.waluty;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        KantorProcessor kantorProcessor=new KantorProcessor();
        ArrayList<Waluta> listaWalut=kantorProcessor.getListaWalut();

        KantorView kantorView = new KantorView(listaWalut);
        KantorModel kantorModel = new KantorModel();
        KantorController kantorController = new KantorController(kantorView,kantorModel);

        kantorView.setVisible(true);
    }
}
