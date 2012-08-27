package game;

import game.sprites.Bloco;
import game.sprites.CharacterSprite;
import game.sprites.WinSpot;
import javax.microedition.lcdui.Canvas;
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
    private Bloco[] blocos;
    private WinSpot[] winSpot;
    private int count = 0;
    private Cenario[] cenarios;
    private int cenarioIndexAtual;
    private Cenario cenarioAtual;

    public MainGame() {
        super(false);
        cenarios = new Cenario[4];
        cenarios[0] = Cenario.getCenario(0);
        cenarios[1] = Cenario.getCenario(1);
        cenarios[2] = Cenario.getCenario(2);
        cenarios[3] = Cenario.getCenario(3);
    }

    public void initCenario(Cenario cenario) {

        wall = cenario.getWall();
        character = cenario.getCharacter();
        blocos = cenario.getBlocks();
        winSpot = cenario.getWinSpots();
        CURRENT_DIRECTION = character.getDirection();
    }

    public void run() {

        for (int i = 0; i < cenarios.length; i++) {
            cenarioIndexAtual = i;
            cenarioAtual = cenarios[i];
            initCenario(cenarioAtual);

            showGraphicsState("Stage " + i);

            while (!cenarioAtual.isCompleted()) {
                try {
                    verifyGameState();
//
                    checkUserInput();

                    updateGameScreen(cenarioAtual, getGraphics());

                    Thread.currentThread().sleep(100);
                    System.out.println(count);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        showGraphicsState("Fim do jogo");

    }

    public void start() {
        Thread runner = new Thread(this);
        runner.start();
    }

    private void verifyGameState() {

        count = 0;
        for (int i = 0; i < winSpot.length; i++) {
            Bloco bloco = blocos[i];
            if (bloco.in(winSpot)) {
                bloco.setFrame(1);

            } else {
                bloco.setFrame(0);
            }

            if (bloco.getFrame() == 1) {
                count++;
            }
        }
    }

    private void checkUserInput() throws Exception {


        int keyState = getKeyStates();

        System.out.println(keyState + " " + KEY_NUM3 + " " + (keyState & KEY_NUM3) + " ");
        if ((keyState & DOWN_PRESSED) != 0) {
            move(DOWN);
        } else if ((keyState & UP_PRESSED) != 0) {
            move(UP);
        } else if ((keyState & LEFT_PRESSED) != 0) {
            move(LEFT);
        } else if ((keyState & RIGHT_PRESSED) != 0) {
            move(RIGHT);
        } else if (keyState  == 1024) {
            System.out.println("Reset");
            cenarioAtual = Cenario.getCenario(cenarioIndexAtual);
            initCenario(cenarioAtual);
        }


    }

    private void updateGameScreen(Cenario cenario, Graphics graphics) {
        Graphics gr = getGraphics();
        gr.setColor(0, 0, 0);
        gr.fillRect(0, 0, getWidth(), getHeight());
        
        int width = cenario.cols * cenario.pixelSize;
        int height = cenario.rows * cenario.pixelSize;
        
        int x = getWidth() / 2  - (width/2 );
        int y = getHeight() / 2  - (height/2 );
        System.out.println(getHeight() + " " + height);
        
        cenario.paint(graphics, x, y);
        flushGraphics();

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

    private void showGraphicsState(String texto) {

        Graphics gr = getGraphics();
        gr.setColor(0, 0, 0);
        gr.fillRect(0, 0, getWidth(), getHeight());

        gr.setColor(125, 125, 125);
        gr.drawString(texto, (getWidth() /2 - (texto.length()*4)), getHeight() / 2, 0);

        flushGraphics();
        try {
            Thread.sleep(1500l);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
