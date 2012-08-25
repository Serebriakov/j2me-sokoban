package game.sprites;

import game.GameDesign.Posicao;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author jaspion
 */
public class Bloco extends Sprite {

    private boolean marcado = false;
    

    public Bloco(Sprite s, int row,int col) {
        super(s);

        setRefPixelPosition(getWidth() / 2, getHeight() / 2);
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

    public boolean in(Posicao[] posicoes) {
        for (int i = 0; i < posicoes.length; i++) {
            if (
                    (posicoes[i].x*16 == (getX())) 
                    && (posicoes[i].y*16 == (getY()))
                    ) {
                
                return true;
            }
        }
        return false;
    }
}
