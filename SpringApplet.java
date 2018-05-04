package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class SpringApplet extends JApplet {

    //tworzenie prywatnych pól
    private static final long serialVersionUTD = 1L;
    private SimEngine simE;
    private SimTask simT;
    private Timer czas;

    //metoda publiczna
    @Override public void init(){
        this.setSize(400,300);

        simE = new SimEngine(3, 0.5, 0.1, 100, 10, 100, 100, 0);
        simT = new SimTask(simE, this, 0.01);
        czas = new Timer();
        czas.scheduleAtFixedRate(simT, 0, 1);
    }

    @Override public void paint(Graphics gDC){
        gDC.fillRect(0, 0, 400, 300);                                                               //czyszczenie appletu
        gDC.setColor(Color.CYAN);                                                                                       //rysowanie sprężyny
        gDC.drawLine((int) simE.showxPunkt(), (int)simE.showyPunkt(), (int) simE.showxMasy(), (int) simE.showyMasy());
        gDC.setColor(Color.PINK);
        gDC.fillOval(((int) simE.showxMasy()-25), (int) simE.showyMasy(), 50, 100);                       //rysowanie masy
    }
}