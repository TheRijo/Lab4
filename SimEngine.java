package com.company;

public class SimEngine {
    //tworzenie prywatnych pól
    private double m;       //masa
    private double k;       //współczynnik sprężystości
    private double c;       //współczynnik tłumienia
    private double L0;      //długość swobodnej sprężyny
    private double xMasy;   //położenie masy
    private double yMasy;
    private double xPunkt;  //położenie punktu
    private double yPunkt;
    private double xV;      //prędkość
    private double yV;
    private double g;       //przyspieszenie grawitacyjne
    public double ay;
    public double t;
    public double temp;

        Vector2D polozenieMasy;     //wektor położenia masy
        Vector2D polozeniePunktu;   //wektor położenia punktu

    //akcesory
    public void getM(double podajM){
        m = podajM;
    }
    public void getK(double podajK){
        k = podajK;
    }
    public void getC(double podajC){
        c = podajC;
    }
    public void getL0(double podajL0){
        L0 = podajL0;
    }
    public void getxMasy(double podajxMasy){
        xMasy = podajxMasy;
    }
    public void getyMasy(double podajyMasy){
        yMasy = podajyMasy;
    }
    public void getxPunkt(double podajxPunkt){
        xPunkt = podajxPunkt;
    }
    public  void getyPunkt(double podajyPunkt){
        yPunkt = podajyPunkt;
    }
    public void getyV(double podajyV){
        yV = podajyV;
    }
    public void getG(double podajG){
        g = podajG;
    }
    public double showxPunkt(){
        return polozenieMasy.x;
    }
    public double showyPunkt(){
        return polozeniePunktu.y;
    }
    public double showxMasy(){
        return polozenieMasy.x;
    }
    public double showyMasy(){
        System.out.println(polozenieMasy.y);
        return polozenieMasy.y;
    }

    //konstruktor z parametrem
    public SimEngine(double m1, double k1, double c1, double L1, double g1, double xMasy1, double yMasy1, double yPunkt1){
        m = m1;
        k = k1;
        c = c1;
        L0 = L1;
        xV = 0;
        yV = 0;
        g = g1;
        ay = 0;
        xMasy = xMasy1;
        yMasy = yMasy1;
        xPunkt = xMasy1;
        yPunkt = yPunkt1;
        t = 0;
        polozenieMasy = new Vector2D(xMasy1, yMasy1);
        polozeniePunktu = new Vector2D(xMasy1, yPunkt1);
    }

    //metoda obliczająca przebieg symulacji
    public void przebieg(double krok){
        t = krok;
        ay = (m*g-k*polozenieMasy.y-c*yV)/m;
        temp = temp+yV*t+ay*t*t/2;
        polozenieMasy.y = (int)temp;
    }

    //metoda resetująca
    public void zerowanie(){
        yV = 0;
    }
}