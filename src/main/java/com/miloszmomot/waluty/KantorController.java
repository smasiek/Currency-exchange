package com.miloszmomot.waluty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KantorController {

    private KantorView kantorView;
    private KantorModel kantorModel;

    public KantorController(KantorView kantorView,KantorModel kantorModel){
        this.kantorView=kantorView;
        this.kantorModel=kantorModel;

        this.kantorView.addPrzewalutowanieListener(new PrzewalutowanieListener());
    }

    private class PrzewalutowanieListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int walutaZrodlowaIndex,walutaDocelowaIndex;
            ArrayList<Waluta> listaWalut;
            String kodWalutyZrodlowej,kodWalutyDocelowej;
            double iloscWaluty,wynikPrzewalutowania;
            try{
                iloscWaluty=kantorView.getIloscWaluty();
                walutaZrodlowaIndex=kantorView.getZrodlowaWalutaIndex();
                walutaDocelowaIndex=kantorView.getDocelowaWalutaIndex();

                kantorModel.setListaWalut();
                listaWalut = kantorModel.getListaWalut();

                kodWalutyZrodlowej=listaWalut.get(walutaZrodlowaIndex).getKodWaluty();
                kodWalutyDocelowej=listaWalut.get(walutaDocelowaIndex).getKodWaluty();

                wynikPrzewalutowania=kantorModel.przewalutuj(iloscWaluty,kodWalutyZrodlowej,kodWalutyDocelowej);

                kantorView.setWynikPrzewalutowaniaText(wynikPrzewalutowania);
            }catch (RuntimeException ex){
                kantorView.showErrorMessage(ex.getMessage());
                System.out.println(ex.getMessage());
            }

        }
    }

}
