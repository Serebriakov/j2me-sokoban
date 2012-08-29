package game;

import core.MainMIDlet;
import core.Registro;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author lucasirc
 */
public class ScoreList extends GameCanvas implements Runnable {

    private String start = "Iniciar";
    private String score = "Pontuação";
    private int selectionMenu = 1;
    private MainMIDlet midlet;
    private int menu = 0;
    private int toblink = 0;

    public ScoreList(MainMIDlet midlet) {
        super(false);
        this.midlet = midlet;
    }

    public void run() {
        try {

            printTopList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (menu == 0) {

            try {


                blinkTopString();

                checkUserInput();
                toblink++;
                Thread.currentThread().sleep(250);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        midlet.goMenuGame();
    }

    public void start() {
        Thread tr = new Thread(this);
        tr.start();
    }

    private void checkUserInput() {
        int keyState = getKeyStates();

        if (keyState != 0) {
            menu = 1;
        }
    }

    private void printTopList() {
        Graphics g2d = getGraphics();

        int MARGEM = 30;


        g2d.setColor(0, 0, 0);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(255, 0, 0);




        int MARGEM_ESTRUTURA = MARGEM - 5;
        g2d.drawLine(0, MARGEM_ESTRUTURA, getWidth(), MARGEM_ESTRUTURA);
        g2d.drawLine(65, MARGEM_ESTRUTURA, 65, MARGEM + 200);
        g2d.drawLine(178, MARGEM_ESTRUTURA, 178, MARGEM + 200);
        g2d.drawLine(0, MARGEM + 200, getWidth(), MARGEM + 200);


        Registro[] registros = midlet.listarRegistros();

        g2d.setColor(125, 125, 125);
        for (int i = 0; i < registros.length; i++) {



            if (registros[i] != null) {
                if (i == 0) {
                    g2d.setColor(255, 255, 0);
                } else if (i == 1) {
                    g2d.setColor(171, 171, 167);
                } else if (i == 2) {
                    g2d.setColor(235, 163, 30);
                } else {
                    g2d.setColor(198, 245, 245);
                }


                g2d.drawString(registros[i].getNome(), 5, MARGEM + 20 * i, 0);
                g2d.drawString(registros[i].getData(), 70, MARGEM + 20 * i, 0);
                g2d.drawString(registros[i].getScoreString(), 184, MARGEM + 20 * i, 0);
            }
        }

    }

 

    private void blinkTopString() {
        Graphics g2d = getGraphics();


        if (toblink % 2 == 0) {

            g2d.setColor(255, 255, 255);
        } else {
            g2d.setColor(255, 0, 0);
        }


        g2d.drawString("Top 10", getWidth() / 2 - 20, 5, 0);
        flushGraphics();
    }
}
