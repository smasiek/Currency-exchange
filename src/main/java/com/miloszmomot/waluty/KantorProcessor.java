package com.miloszmomot.waluty;

import java.util.ArrayList;

public abstract class KantorProcessor {

    public abstract ArrayList<Waluta> setListaWalut() ;

    public abstract double przewalutuj(double ilosc, String kodWalutyZrodlowej, String kodWalutyDocelowej);

}
