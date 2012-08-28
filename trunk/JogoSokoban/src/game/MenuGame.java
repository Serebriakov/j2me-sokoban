package game;

import core.MainMIDlet;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author jaspion
 */
public class MenuGame extends GameCanvas implements Runnable {

    private String start = "Iniciar";
    private String score = "Pontuação";
    private int selectionMenu = 1;
    private MainMIDlet midlet;
    private int menu = 0;

    public MenuGame(MainMIDlet midlet) {
        super(false);
        this.midlet = midlet;
    }

    public void run() {

        while (menu == 0) {

            try {
                checkUserInput();
                updateGameScreen(getGraphics());
                Thread.currentThread().sleep(250);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("parou menu");
        switch (selectionMenu) {
            case 1:
                MainGame game = new MainGame(midlet);
                game.start();
                Display.getDisplay(midlet).setCurrent(game);

                break;
            case 2:
                
                break;
        }
    }

    public void start() {
        Thread tr = new Thread(this);
        tr.start();
    }

    private void updateGameScreen(Graphics graphics) {

        graphics.setColor(0x000000);
        graphics.fillRect(0, 0, getWidth(), getHeight());



        int cx = getWidth() / 2;
        graphics.setColor(125, 125, 125);

        int startX = cx - start.length() * 4;
        int startY = getHeight() / 2 - 40;
        int scoreX = cx - score.length() * 4;
        int scoreY = getHeight() / 2 - 20;

        graphics.drawString(start, startX, startY, 0);

        graphics.drawString(score, scoreX, scoreY, 0);



        switch (selectionMenu) {
            case 1:
                graphics.setColor(0xff0000);
                graphics.drawRect(startX - 10, startY - 5, 53, 25);

                break;
            case 2:
                graphics.setColor(0xff0000);
                graphics.drawRect(scoreX - 10, scoreY - 5, 80, 25);
                break;
        }


        flushGraphics();



    }

    private void checkUserInput() {
        int keyState = getKeyStates();

        if ((keyState & DOWN_PRESSED) != 0) {
            selectionMenu = 2;

        } else if ((keyState & UP_PRESSED) != 0) {
            selectionMenu = 1;
        } else if ((keyState & FIRE_PRESSED) != 0) {
            menu = selectionMenu;
        }
    }
}
