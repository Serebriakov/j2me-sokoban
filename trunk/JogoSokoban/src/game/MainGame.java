package game;

import core.MainMIDlet;
import game.sprites.Bloco;
import game.sprites.CharacterSprite;
import game.sprites.WinSpot;
import java.util.Timer;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *
 * @author jaspion
 */
public class MainGame extends GameCanvas implements Runnable {

    private CharacterSprite character;
    private TiledLayer wall;
    private int CURRENT_DIRECTION;
    private int VELOCIDADE = 16;
    private int cenarioIndexAtual;
    private int x;
    private int y;
    private int maxSpot;
    private int winnedSpot;
    private Bloco[] blocos;
    private WinSpot[] winSpot;
    private Cenario cenarioAtual;
    private Clock clock;
    private Timer timer;
    private Thread runner;
    private MainMIDlet midlet;
    private int score;

    public MainGame(MainMIDlet midlet) {
        super(false);

        this.midlet = midlet;

    }

    /**
     * Executa o game
     */
    public void run() {
        int cenariosCount = 4;

        loop:
        for (int i = 0; i < cenariosCount; i++) {
            cenarioIndexAtual = i;
            cenarioAtual = Cenario.getCenario(i);
            initCenario(cenarioAtual);

            showTextoCentro("Cenário " + (cenarioIndexAtual + 1));
            while (!cenarioAtual.isCompleted()
                    && !(clock.getTimeLeft() < 0)) {
                try {
                    verifyGameState();
                    checkUserInput();
                    updateGameScreen(getGraphics());

                    Thread.currentThread().sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            score += (clock.getTimeLeft() > 0 ? clock.getTimeLeft() : 0)*10 + winnedSpot*10 ;
            if (cenarioAtual.timeout == clock.getTimeLeft() || clock.getTimeLeft() < 0) {
                break loop;
            } 

        }
        try {
            timer.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (clock.getTimeLeft() < 0) {
            showTextoCentro("O tempo acabou, tente novamente!");
            midlet.goSaveScore(score);
            
        } else {
            showTextoCentro("Você venceu!");
            midlet.goSaveScore(score);
        }

    }

    /**
     * Inicia o cenario para o game
     *
     * @param cenario
     */
    public void initCenario(Cenario cenario) {

        wall = cenario.getWall();
        character = cenario.getCharacter();
        blocos = cenario.getBlocks();
        winSpot = cenario.getWinSpots();
        maxSpot = winSpot.length;
        winnedSpot = 0;
        CURRENT_DIRECTION = character.getDirection();
        int width = cenario.cols * cenario.pixelSize;
        int height = cenario.rows * cenario.pixelSize;

        x = getWidth() / 2 - (width / 2);
        y = getHeight() / 2 - (height / 2);
        clock = new Clock(30);


        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        clock = new Clock(cenario.timeout);
        timer = new Timer();
        timer.scheduleAtFixedRate(clock, 0, 1000);
    }

    /**
     *
     */
    public void start() {
        runner = new Thread(this);
        runner.start();

    }

    //<editor-fold defaultstate="collapsed" desc="Verifica Estado do jogo">
    private void verifyGameState() {
        winnedSpot = 0;

        for (int i = 0; i < winSpot.length; i++) {
            Bloco bloco = blocos[i];
            if (bloco.in(winSpot)) {
                bloco.setFrame(1);

            } else {
                bloco.setFrame(0);
            }

            if (bloco.getFrame() == 1) {
                winnedSpot++;
            }
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Verifica Entradas">
    private void checkUserInput() throws Exception {


        int keyState = getKeyStates();


        if ((keyState & DOWN_PRESSED) != 0) {
            move(DOWN);
        } else if ((keyState & UP_PRESSED) != 0) {
            move(UP);
        } else if ((keyState & LEFT_PRESSED) != 0) {
            move(LEFT);
        } else if ((keyState & RIGHT_PRESSED) != 0) {
            move(RIGHT);
        }
//        else if (keyState == 1024) {
//            cenarioAtual = Cenario.getCenario(cenarioIndexAtual);
//            initCenario(cenarioAtual);
//            showTextoCentro("Cenário " + (cenarioIndexAtual + 1));
//        }


    }

    private boolean colides(Sprite character, TiledLayer blocks) {

        return character.collidesWith(blocks, true);

    }

    private void move(int moveType) {
        if (CURRENT_DIRECTION == moveType) {
            character.nextFrame();
        } else {
            CURRENT_DIRECTION = moveType;
            changeCharacterSequence(moveType);
            character.setFrame(0);
        }


        moveSprite(character, moveType);
        if (colides(character, wall)) {
            moveSpriteInvert(character, moveType);
        } else {
            checkColidesBloco(moveType);

        }



    }

    private Sprite checkColidesBloco(int nextMove) {
        for (int i = 0; i < blocos.length; i++) {
            Bloco bloco = blocos[i];
            if (bloco != null
                    && character.collidesWith(bloco, false)) {
                switch (nextMove) {
                    case DOWN:
                        moveToDown(bloco);
                        break;
                    case UP:
                        moveToUp(bloco);
                        break;
                    case LEFT:
                        moveToLeft(bloco);
                        break;
                    case RIGHT:
                        moveToRight(bloco);
                        break;
                }
                if (!bloco.collidesWith(wall, false)
                        && !colidesWithBlocos(bloco, blocos, i)) {
                    return bloco;
                } else {
                    switch (nextMove) {
                        case DOWN:
                            moveToUp(bloco);
                            moveToUp(character);
                            break;
                        case UP:
                            moveToDown(bloco);
                            moveToDown(character);
                            break;
                        case LEFT:
                            moveToRight(bloco);
                            moveToRight(character);

                            break;
                        case RIGHT:
                            moveToLeft(bloco);
                            moveToLeft(character);
                            break;
                    }
                    //colide com bloco mas o bloco esta colidindo com outra coisa
                    return null;
                }

            }
        }
        //nao colide com bloco
        return null;
    }

    /**
     * Verifica se o sprite colide com os blocos, excluindo bloco da posicao
     * passada por parametro
     *
     * @param bloco
     * @param blocos
     * @param position
     * @return
     */
    private boolean colidesWithBlocos(Sprite bloco, Sprite[] blocos, int position) {
        for (int i = 0; i < blocos.length; i++) {
            if (blocos[i] != null
                    && i != position
                    && bloco.collidesWith(blocos[i], false)) {
                return true;
            }
        }
        return false;
    }

    public void moveSprite(Sprite sprite, int moveType) {
        switch (moveType) {
            case DOWN:
                sprite.move(0, VELOCIDADE);
                break;
            case UP:
                sprite.move(0, -VELOCIDADE);
                break;
            case LEFT:
                sprite.move(-VELOCIDADE, 0);
                break;
            case RIGHT:
                sprite.move(VELOCIDADE, 0);
                break;
        }
    }

    public void moveToUp(Sprite sprite) {
        sprite.move(0, -VELOCIDADE);
    }

    public void moveToDown(Sprite sprite) {
        sprite.move(0, VELOCIDADE);
    }

    public void moveToRight(Sprite sprite) {
        sprite.move(VELOCIDADE, 0);
    }

    public void moveToLeft(Sprite sprite) {
        sprite.move(-VELOCIDADE, 0);
    }

    private void changeCharacterSequence(int moveType) {
        switch (moveType) {
            case DOWN:
                character.down();
                break;
            case UP:
                character.up();
                break;
            case LEFT:
                character.left();
                break;
            case RIGHT:
                character.right();

                break;
        }
    }

    private void moveSpriteInvert(Sprite sprite, int moveType) {
        switch (moveType) {
            case DOWN:
                sprite.move(0, -VELOCIDADE);
                break;
            case UP:
                sprite.move(0, VELOCIDADE);
                break;
            case LEFT:
                sprite.move(VELOCIDADE, 0);
                break;
            case RIGHT:
                sprite.move(-VELOCIDADE, 0);
                break;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atualiza Visao">
    private void updateGameScreen(Graphics graphics) {
        Graphics gr = getGraphics();
        gr.setColor(0, 0, 0);
        gr.fillRect(0, 0, getWidth(), getHeight());

        showTimeLeft(gr);
        showCommands(gr);

        cenarioAtual.paint(graphics, x, y);

        flushGraphics();


    }

    private void showTextoCentro(String texto) {
        Graphics gr = getGraphics();
        gr.setColor(0, 0, 0);
        gr.fillRect(0, 0, getWidth(), getHeight());

        gr.setColor(125, 125, 125);
        gr.drawString(texto, (getWidth() / 2 - (texto.length() * 4)), getHeight() / 2, 0);

        flushGraphics();
        try {
            Thread.currentThread().sleep(1500l);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void showCommands(Graphics gr) {
        gr.setColor(0xffffff);
        String valor = "Blocos " + winnedSpot + "/" + maxSpot;
        gr.drawString(valor, 0, getHeight() - 20, 0);

    }

    private void showTimeLeft(Graphics g) {

        // what does the clock say
        int timeLeft = clock.getTimeLeft();

        // if less than 6 seconds left
        // flicker time with red and black
        if (timeLeft < 10) {
            if ((timeLeft % 2) == 0) {
                g.setColor(0xff0000);
            } else {
                g.setColor(0xffffff);
            }
        } else {
            g.setColor(0xffffff);
        }

        g.drawString("Tempo: " + timeLeft + "s", 0, 0, 0);

        // reset the color


        g.setColor(0x000000);

    }
    //</editor-fold>
}
