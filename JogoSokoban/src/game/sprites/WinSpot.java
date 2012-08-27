package game.sprites;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author jaspion
 */
public class WinSpot extends Sprite {

    
    private int[] sequence = {3};
    
    private int row;
    private int col;
    
    public WinSpot(Image image, int row, int col) {
        super(image, 16, 16);

        this.row = row;
        this.col = col;
        setVisible(true);
        setFrameSequence(sequence);
        setRefPixelPosition(getWidth() / 2, getHeight() / 2);
        setPosition(col * 16, row * 16);
    }
}
