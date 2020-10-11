package com.miloszmomot.waluty;

import java.util.ArrayList;

public class KantorModel {

    private KantorProcessor kantorProcessor;
    private ArrayList<Waluta> listaWalut;

    public KantorModel() {
        kantorProcessor=new KantorProcessor();
    }

    public double przewalutuj(double ilosc, String kodWalutyZrodlowej, String kodWalutyDocelowej){
        return kantorProcessor.przewalutuj(ilosc,kodWalutyZrodlowej,kodWalutyDocelowej);
    }

    public void createListaWalut(){
        listaWalut = kantorProcessor.getListaWalut();
    }

    public ArrayList<Waluta> getListaWalut(){
        return listaWalut;
    }
}
