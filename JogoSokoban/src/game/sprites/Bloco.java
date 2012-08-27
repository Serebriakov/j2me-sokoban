package game.sprites;

import game.util.Point;
import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author jaspion
 */
public class Bloco extends Sprite {

    private boolean marcado = false;
    private int[] sequence = {4, 5};
    private int pixelSize;

    public Bloco(Image image, int row, int col, int pixelSize) {
        super(image, pixelSize, pixelSize);
        this.pixelSize = pixelSize;

        setVisible(true);
        setFrameSequence(sequence);
        setRefPixelPosition(getWidth() / 2, getHeight() / 2);
        setPosition(col * pixelSize, row * pixelSize);
    }

    public boolean shouldMoveBy(Sprite other, int direction) {


        switch (direction) {

            case GameCanvas.UP:
                if (other.getY() > getY()) {
                    return true;
                }
                break;
            case GameCanvas.DOWN:
                if (other.getY() < getY()) {
                    return true;
                }
                break;
            case GameCanvas.RIGHT:
                if (other.getX() < getX()) {
                    return true;
                }
                break;
            case GameCanvas.LEFT:
                if (other.getX() > getX()) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public boolean in(WinSpot[] winSpot) {
        for (int i = 0; i < winSpot.length; i++) {
            if ((winSpot[i].getX() == (getX()))
                    && (winSpot[i].getY() == (getY()))) {

                return true;
            }
        }
        return false;
    }
}
