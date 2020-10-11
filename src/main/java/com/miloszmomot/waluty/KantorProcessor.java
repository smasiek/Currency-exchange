package com.miloszmomot.waluty;

import org.xml.sax.SAXException;
import sun.rmi.runtime.Log;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class KantorProcessor {
    KantorNBP kantorNBP;

    public KantorProcessor() {
        this.kantorNBP = new KantorNBP();
    }

    public ArrayList<Waluta> getListaWalut() {
        try {
            return kantorNBP.createListaWalut();
        } catch (IOException |SAXException |ParserConfigurationException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public double przewalutuj(double ilosc,String kodWalutyZrodlowej,String kodWalutyDocelowej) {
        double wynikPrzewalutowania;
        wynikPrzewalutowania = kantorNBP.dokonajTransakcji(ilosc,kodWalutyZrodlowej, kodWalutyDocelowej);
        return wynikPrzewalutowania;
    }

}
