package game.sprites;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author lucasirc
 */
public class WinSpot extends Sprite {

    
    private int[] sequence = {3};   
 
    
    public WinSpot(Image image, int row, int col, int pixelSize) {
        super(image, pixelSize, pixelSize);

    
        setVisible(true);
        setFrameSequence(sequence);
        setRefPixelPosition(getWidth() / 2, getHeight() / 2);
        setPosition(col * pixelSize, row * pixelSize);
    }
}
