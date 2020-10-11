package com.miloszmomot.waluty;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class KantorNBP {
    ArrayList<Waluta> listaWalut;

    public double dokonajTransakcji(double iloscWalutyZrodlowej, String kodWalutyZrodlowej, String kodWalutyDocelowej) {

        //1. lista walut pobrana z pliku xml
        Waluta walutaZrodlowa = null;
        Waluta walutaDocelowa = null;
        //2. wyłuskanie walut zrodlowej i docelowej zs listy
        for (Waluta waluta : listaWalut) {
            if (kodWalutyZrodlowej.equals(waluta.getKodWaluty())) {
                walutaZrodlowa = new Waluta(waluta.getNazwaWaluty(), waluta.getPrzelicznik(), waluta.getKodWaluty(), waluta.getKursSredni());
            }
            if (kodWalutyDocelowej.equals(waluta.getKodWaluty())) {
                walutaDocelowa = new Waluta(waluta.getNazwaWaluty(), waluta.getPrzelicznik(), waluta.getKodWaluty(), waluta.getKursSredni());
            }
        }
        //3. obliczenia
        double wynikTransakcji;
        wynikTransakcji=(iloscWalutyZrodlowej*(walutaZrodlowa.getKursSredni()/walutaZrodlowa.getPrzelicznik()))/(walutaDocelowa.getKursSredni()/walutaDocelowa.getPrzelicznik());
        //4. zaokraglenie
        if((int)((wynikTransakcji+0.005)*100)>(int)((wynikTransakcji)*100)){
            wynikTransakcji=(double)((int)((wynikTransakcji+0.005)*100))/100;
        }else{
            wynikTransakcji=(double)((int)((wynikTransakcji)*100))/100;
        }
        //5. zwrocenie wyniku obliczen
        return wynikTransakcji;
    }

    public ArrayList<Waluta> createListaWalut() throws ParserConfigurationException, IOException, SAXException {

        this.listaWalut = new ArrayList<Waluta>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(new URL("https://www.nbp.pl/kursy/xml/lasta.xml").openStream());

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("pozycja");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            System.out.println("\nCurrent Element: " + nNode.getNodeName()+ " " + (i+1));

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                Node node1 = elem.getElementsByTagName("nazwa_waluty").item(0);
                String nazwaWaluty = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("przelicznik").item(0);
                int przelicznik = Integer.parseInt(node2.getTextContent());

                Node node3 = elem.getElementsByTagName("kod_waluty").item(0);
                String kodWaluty = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("kurs_sredni").item(0);
                double kursSredni = Double.parseDouble(node4.getTextContent().replaceAll(",","."));

                listaWalut.add(new Waluta(nazwaWaluty, przelicznik, kodWaluty, kursSredni));
            }
        }
        listaWalut.add(new Waluta("polski zloty", 1, "PLN", 1.0));

        return listaWalut;
    }
}
