package game;

import game.sprites.Bloco;
import game.sprites.CharacterSprite;
import game.sprites.WinSpot;
import game.util.Point;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *
 * @author jaspion
 */
public class Cenario extends LayerManager {

    private TiledLayer wall;
    private TiledLayer ground;
    public static int WALL = 1;
    public static int GROUND = 2;
    public static int BLOCK = 4;
    public static int WIN_SPOT = 3;
    public static int CHARACTER_POSITION = 5;
    private Bloco[] blocks;
    WinSpot[] winSpots;
    private CharacterSprite character;

    private Cenario(Bloco[] blocos,
            WinSpot[] winSpots,
            CharacterSprite character,
            TiledLayer wall,
            TiledLayer ground) {
        this.blocks = blocos;
        this.winSpots = winSpots;
        this.ground = ground;
        this.wall = wall;
        this.character = character;



        if (character != null) {
            append(character);

        }
        for (int i = 0; i < blocos.length; i++) {
            if (blocos[i] != null) {
                append(blocos[i]);
            }
        }
        for (int i = 0; i < winSpots.length; i++) {
            if (winSpots[i] != null) {
                append(winSpots[i]);
            }
        }

        append(wall);
        append(ground);
    }

    public static Cenario getCenario1() {
        try {
            Image sprite = Image.createImage("/game/images/sprites.png");
            int[][] fase = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 5, 2, 1, 1},
                {1, 1, 2, 2, 4, 2, 1, 1},
                {1, 1, 2, 1, 2, 1, 1, 1},
                {1, 2, 2, 1, 2, 1, 3, 1},
                {1, 2, 1, 2, 2, 4, 3, 1},
                {1, 2, 4, 2, 2, 2, 3, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},};
            return getCenario(sprite, 8, 8, fase, 3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cenario getCenario2() {
        try {
            Image sprite = Image.createImage("/game/images/sprites.png");
            int[][] fase = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 5, 1},
                {1, 1, 1, 1, 1, 4, 4, 2, 1},
                {1, 3, 1, 1, 1, 2, 4, 2, 1},
                {1, 3, 1, 1, 1, 2, 1, 1, 1},
                {1, 3, 2, 2, 2, 2, 1, 1, 1},
                {1, 2, 2, 1, 2, 2, 2, 1, 1},
                {1, 1, 1, 1, 2, 2, 2, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},};
            return getCenario(sprite, 9, 9, fase, 3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Cenario getCenario3() {
        try {
            Image sprite = Image.createImage("/game/images/sprites.png");
            int[][] fase = {
                {0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 2, 5, 3, 3, 3, 1, 0},
                {0, 1, 2, 2, 2, 1, 1, 1, 1},
                {1, 1, 1, 4, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 1, 4, 1, 2, 1},
                {1, 2, 4, 2, 1, 2, 2, 2, 1},
                {1, 2, 2, 2, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 0}, };
            return getCenario(sprite, 9, 8, fase, 3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Cenario getCenario4() {
        try {
            Image sprite = Image.createImage("/game/images/sprites.png");
            int[][] fase = {
                {0, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 1, 2, 2, 3, 1, 1, 1, 1},
                {1, 2, 2, 3, 4, 3, 4, 2, 1},
                {1, 2, 4, 1, 2, 1, 4, 5, 1},
                {1, 2, 2, 3, 2, 3, 4, 2, 1},
                {1, 2, 4, 1, 4, 1, 1, 1, 1},
                {1, 2, 2, 3, 2, 3, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 0, 0}, };
            return getCenario(sprite, 9, 8, fase, 7);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    private static Cenario getCenario(Image sprite, int cols, int rows, int[][] fase, int blocksCount) {

        TiledLayer wall = new TiledLayer(cols, rows, sprite, 16, 16);
        wall.setVisible(true);
        TiledLayer ground = new TiledLayer(cols, rows, sprite, 16, 16);
        ground.setVisible(true);
        CharacterSprite character = null;

        Bloco[] blocos = new Bloco[blocksCount];
        WinSpot[] winSpots = new WinSpot[blocksCount];

        int countBlock = 0;
        int countWinSpot = 0;

        for (int i = 0; i < fase.length; i++) {
            for (int j = 0; j < fase[i].length; j++) {

                if (fase[i][j] == WALL) {
                    wall.setCell(j, i, WALL);
                } else if (fase[i][j] == GROUND
                        || fase[i][j] == BLOCK
                        || fase[i][j] == WIN_SPOT
                        || fase[i][j] == CHARACTER_POSITION) {

                    ground.setCell(j, i, GROUND);


                    if (fase[i][j] == BLOCK) {
                        blocos[countBlock] = new Bloco(sprite, i, j);
                        countBlock++;
                    }
                    if (fase[i][j] == CHARACTER_POSITION) {
                        character = new CharacterSprite(sprite, i, j);
                    }
                    if (fase[i][j] == WIN_SPOT) {
                        winSpots[countWinSpot] = new WinSpot(sprite, i, j);
                        countWinSpot++;
                    }
                }

            }
        }
        Cenario cenario = new Cenario(blocos, winSpots, character, wall, ground);
        return cenario;
    }

    public TiledLayer getWall() {
        return wall;
    }

    public TiledLayer getGround() {
        return ground;
    }

    public Bloco[] getBlocks() {
        return blocks;
    }

    public WinSpot[] getWinSpots() {
        return winSpots;
    }

    public CharacterSprite getCharacter() {
        return character;
    }

    public int getWinCout() {
        return winSpots.length;
    }

    public boolean isCompleted() {
         int count = 0;
        for ( int i = 0 ; i < blocks.length; i++ ) {
            
            if ( blocks[i].getFrame() == 1 ) {
                count ++;
            }
        }
        return count == blocks.length;
    }
}
