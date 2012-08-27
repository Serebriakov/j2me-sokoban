package game;

import game.sprites.Bloco;
import game.sprites.CharacterSprite;
import game.sprites.WinSpot;
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

    public MainGame() {
        super(false);
        cenarios = new Cenario[4];
        cenarios[0] = Cenario.getCenario1();
        cenarios[1] = Cenario.getCenario2();
        cenarios[2] = Cenario.getCenario3();
        cenarios[3] = Cenario.getCenario4();

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
            Cenario cenario = cenarios[i];
            initCenario(cenario);

            while (!cenario.isCompleted()) {
                try {
                    verifyGameState();
//
                    checkUserInput();

                    updateGameScreen(cenario, getGraphics());

                    Thread.currentThread().sleep(100);
                    System.out.println(count);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

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
        if ((keyState & DOWN_PRESSED) != 0) {
            move(DOWN);
        } else if ((keyState & UP_PRESSED) != 0) {
            move(UP);
        } else if ((keyState & LEFT_PRESSED) != 0) {
            move(LEFT);
        } else if ((keyState & RIGHT_PRESSED) != 0) {
            move(RIGHT);
        } else {
            character.setFrame(0);
        }
    }

    private void updateGameScreen(Cenario cenario, Graphics graphics) {

        cenario.paint(graphics, 30, 30);
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
}
