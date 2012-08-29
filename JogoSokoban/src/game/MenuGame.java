package game;

import core.MainMIDlet;
import game.sprites.Bloco;
import game.sprites.CharacterSprite;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author lucasirc
 */
public class MenuGame extends GameCanvas implements Runnable {

    private String start = "Iniciar";
    private String score = "Pontuação";
    private int selectionMenu = 1;
    private MainMIDlet midlet;
    private int menu = 0;
    private CharacterSprite character;
    private Bloco bloco;
    private Timer timer;

    public MenuGame(MainMIDlet midlet) {
        super(false);
        this.midlet = midlet;

        try {

            Image sprite = Image.createImage("/game/images/sprites.png");
            character = new CharacterSprite(sprite, getHeight() / 16, 0, 16);
            bloco = new Bloco(sprite, getHeight() / 16, 0, 16);


        } catch (Exception e) {
            e.printStackTrace();
        }

        character.setPosition(0, getHeight() - 30);
        bloco.setPosition(10, getHeight() - 30);
        character.right();
  


    }

    public void run() {

        while (menu == 0) {

            try {
                if (character.getX() < getWidth()) {
                    character.nextFrame();
                    character.move(4, 0);
                    bloco.move(4, 0);
                } else {
                    character.setPosition(-10, getHeight() - 30);
                    bloco.setPosition(0, getHeight() - 30);
                }
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
                midlet.goPontuacao();
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

        try {
            Image logo = Image.createImage("/game/images/logo.png");
            graphics.drawImage(logo, 60, 20, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        character.nextFrame();
        character.paint(graphics);
        bloco.paint(graphics);


        int cx = getWidth() / 2;
        graphics.setColor(125, 125, 125);

        int startX = cx - start.length() * 4 +10;
        int startY = getHeight() / 2 - 40;
        int scoreX = cx - score.length() * 4 + 10;
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
