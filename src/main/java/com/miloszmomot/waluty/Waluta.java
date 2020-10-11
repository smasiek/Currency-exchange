package com.miloszmomot.waluty;

public class Waluta {
    private String nazwaWaluty;
    private int przelicznik;
    private String kodWaluty;
    private double kursSredni;

    public Waluta(String nazwaWaluty, int przelicznik, String kodWaluty, double kursSredni) {
        this.nazwaWaluty = nazwaWaluty;
        this.przelicznik = przelicznik;
        this.kodWaluty = kodWaluty;
        this.kursSredni = kursSredni;
    }


    public int getPrzelicznik() {
        return przelicznik;
    }

    public String getKodWaluty() {
        return kodWaluty;
    }

    public double getKursSredni() {
        return kursSredni;
    }

    public String getNazwaWaluty() {
        return nazwaWaluty;
    }
}
