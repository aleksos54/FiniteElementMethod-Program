package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Global_Data {
    double H; //wysokosc
    double W; //dlugosc
    int nH; //liczba wezlow po wysokosci
    int nW; //liczba wezlow po dlugosci

    int nE;  //liczba elementow
    int nN;  //liczba wezlow

    double K; //przewodnosc (konduktywnosc)
    double ro; //gestosc
    double cp; //cieplo
    int pkt_calk; //ilosc pkt calkowania
    double t0; //poczatkowa temperatura
    double alfa;//wspolczynnik konwekcyjnej wymiany ciepla
    double t_alfa; //temp otoczenia
    int czas_symulacji;
    int czas_kroku;


    public Global_Data(){
        try{
            File file = new File("dane.txt");
            Scanner Reader = new Scanner(file);

            this.pkt_calk= Reader.nextInt();
            this.t0 = Reader.nextDouble();
            this.czas_symulacji = Reader.nextInt();
            this.czas_kroku = Reader.nextInt();
            this.t_alfa = Reader.nextDouble();
            this.alfa = Reader.nextDouble();
            this.H = Reader.nextDouble();
            this.W = Reader.nextDouble();
            this.nH = Reader.nextInt();
            this.nW = Reader.nextInt();
            this.cp = Reader.nextDouble();
            this.K = Reader.nextDouble();
            this.ro = Reader.nextDouble();



            nE=(nH - 1)*(nW - 1);
            nN=(nH*nW);
            Reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
