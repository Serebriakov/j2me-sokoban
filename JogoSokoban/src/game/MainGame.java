package game;

import game.GameDesign.Posicao;
import game.sprites.Bloco;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *
 * @author jaspion
 */
public class MainGame extends GameCanvas implements Runnable {

    private Sprite character;
    private TiledLayer wall;
    private GameDesign gameDesign;
    private int CURRENT_DIRECTION;
    private int VELOCIDADE = 2;
    private LayerManager layerManager;
    private Bloco[] blocos = new Bloco[4];
    private TiledLayer background;
    private int count = 0;

    public MainGame() {
        super(false);
        gameDesign = new GameDesign();
        try {
            wall = gameDesign.getBlocks();
            character = gameDesign.getCharacterDown();
            background = gameDesign.getBackground();


            layerManager = new LayerManager();

            gameDesign.updateLayerManagerForTeste(layerManager);

            for (int i = 0; i < gameDesign.posicaoBloco.length; i++) {
                blocos[i] = new Bloco(gameDesign.getBlocoAzul(),0,0);

                blocos[i].setVisible(true);
                blocos[i].setPosition(gameDesign.posicaoBloco[i].x * 16, gameDesign.posicaoBloco[i].y * 16);
                layerManager.insert(blocos[i], 2);


            }
            CURRENT_DIRECTION = DOWN;


        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public void run() {


        while (count != 4) {
            try {
                verifyGameState();

                checkUserInput();

                updateGameScreen(getGraphics());

                System.out.println(count);
                Thread.currentThread().sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void start() {
        // do initialization

        // and then start a thread
        Thread runner = new Thread(this);
        runner.start();
    }

    private void verifyGameState() {
        Posicao[] posicoes = gameDesign.posicaoWin;
        count = 0;
        for (int j = 0; j < blocos.length; j++) {
            Bloco bloco = blocos[j];
            if (bloco.in(posicoes)) {
                bloco.setFrame(1);
                
            } else {
                bloco.setFrame(0);
             
            }
            
            
            if ( bloco.getFrame() == 1) {
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

    private void updateGameScreen(Graphics graphics) {

        layerManager.paint(graphics, 0, 0);
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
                    && character.collidesWith(bloco, true)
                    && bloco.shouldMoveBy(character, nextMove)) {
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
                    && bloco.collidesWith(blocos[i], true)) {
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
                character.setFrameSequence(gameDesign.CharacterDownseq001);
                break;
            case UP:
                character.setFrameSequence(gameDesign.CharacterUpseq001);
                break;
            case LEFT:
                character.setFrameSequence(gameDesign.Characterseq001);
                break;
            case RIGHT:
                character.setFrameSequence(gameDesign.CharacterRightseq001);
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

    //<editor-fold defaultstate="collapsed" desc="moves">
    private void moveToDown() {
        int moveType = DOWN;
        if (CURRENT_DIRECTION == moveType) {
            character.nextFrame();
        } else {
            CURRENT_DIRECTION = moveType;
            character.setFrameSequence(gameDesign.CharacterDownseq001);
            character.setFrame(0);
        }
        moveToDown(character);
        if (colides(character, wall)) {
            moveToUp(character);
        } else {
            checkColidesBloco(moveType);

        }
    }

    private void moveToLeft() {
        int moveType = LEFT;
        if (CURRENT_DIRECTION == moveType) {
            character.nextFrame();
        } else {
            CURRENT_DIRECTION = moveType;
            character.setFrameSequence(gameDesign.Characterseq001);
            character.setFrame(0);
        }
        moveToLeft(character);
        if (colides(character, wall)) {

            moveToRight(character);
        } else {
            checkColidesBloco(moveType);

        }
    }

    private void moveToRight() {
        int moveType = RIGHT;
        if (CURRENT_DIRECTION == moveType) {
            character.nextFrame();
        } else {
            CURRENT_DIRECTION = moveType;
            character.setFrameSequence(gameDesign.CharacterRightseq001);
            character.setFrame(0);
        }

        moveToRight(character);
        if (colides(character, wall)) {
            moveToLeft(character);
        } else {
            checkColidesBloco(moveType);
        }
    }

    private void moveToUp() {
        int moveType = UP;
        if (CURRENT_DIRECTION == moveType) {
            character.nextFrame();
        } else {
            CURRENT_DIRECTION = moveType;
            character.setFrameSequence(gameDesign.CharacterUpseq001);
            character.setFrame(0);
        }


        moveToUp(character);
        if (colides(character, wall)) {
            moveToDown(character);
        } else {
            checkColidesBloco(moveType);

        }
    }
//</editor-fold>
}
