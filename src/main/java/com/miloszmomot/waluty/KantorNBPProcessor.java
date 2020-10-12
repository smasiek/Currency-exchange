package com.miloszmomot.waluty;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class KantorNBPProcessor extends KantorProcessor{
    private KantorNBP kantorNBP;

    public KantorNBPProcessor() {
        this.kantorNBP = new KantorNBP();
    }

    public ArrayList<Waluta> setListaWalut() {
            return kantorNBP.setListaWalut();
    }

    public double przewalutuj(double ilosc,String kodWalutyZrodlowej,String kodWalutyDocelowej) {
        double wynikPrzewalutowania;
        wynikPrzewalutowania = kantorNBP.przewalutuj(ilosc,kodWalutyZrodlowej, kodWalutyDocelowej);
        return wynikPrzewalutowania;
    }

}
