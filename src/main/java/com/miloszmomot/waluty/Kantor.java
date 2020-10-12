package com.miloszmomot.waluty;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Kantor {

    public abstract double przewalutuj(double iloscWalutyZrodlowej, String kodWalutyZrodlowej,
                                       String kodWalutyDocelowej);

    public abstract ArrayList<Waluta> setListaWalut();
}
