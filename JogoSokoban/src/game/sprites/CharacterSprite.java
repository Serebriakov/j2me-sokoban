package game.sprites;

import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author lucasirc
 */
public class CharacterSprite extends Sprite {

    int direction;
    int[] rightPersonagem = {24, 25, 26, 27, 28};
    int[] leftPersonagem = {45, 44, 43, 42, 41};
    int[] downPersonagem = {16, 17, 18, 19, 20};
    int[] upPersonagem = {32, 33, 34, 35, 36};

    public CharacterSprite(Image imagem, int row, int col, int pixelSize) {
        super(imagem, pixelSize, pixelSize);
        setFrameSequence(downPersonagem);
        setRefPixelPosition(getWidth() / 2, getHeight() / 2);
        
        setPosition(col * pixelSize, row * pixelSize);
        setVisible(true);
        direction = GameCanvas.DOWN;
    }

    public int getDirection() {
        return direction;
    }

    public void down() {
        setFrameSequence(downPersonagem);
        direction = GameCanvas.DOWN;

    }

    public void up() {
        setFrameSequence(upPersonagem);
        direction = GameCanvas.UP;
    }

    public void left() {
        setFrameSequence(leftPersonagem);
        direction = GameCanvas.LEFT;

    }

    public void right() {
        setFrameSequence(rightPersonagem);
        direction = GameCanvas.RIGHT;
    }
}
