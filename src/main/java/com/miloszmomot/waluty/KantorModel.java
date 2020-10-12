package com.miloszmomot.waluty;

import java.util.ArrayList;

public class KantorModel {

    private KantorProcessor kantorProcessor;
    private ArrayList<Waluta> listaWalut;

    public KantorModel() {
        kantorProcessor =new KantorNBPProcessor();
    }

    public double przewalutuj(double ilosc, String kodWalutyZrodlowej, String kodWalutyDocelowej){
        return kantorProcessor.przewalutuj(ilosc,kodWalutyZrodlowej,kodWalutyDocelowej);
    }

    public void setListaWalut(){
        listaWalut = kantorProcessor.setListaWalut();
    }

    public ArrayList<Waluta> getListaWalut(){
        return listaWalut;
    }
}
