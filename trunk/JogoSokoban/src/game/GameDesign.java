package game;

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

/**
 * @author jaspion
 */
public class GameDesign {
    public static final int TILE_INIT_BLOCO = 4;
    public static final int TILE_END_BLOCO = 3;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image cenario;
    private Image zelda_sprites;
    public int sdfgsdfgseq001Delay = 200;
    public int[] sdfgsdfgseq001 = {0};
    private Image personall;
    public int pracimaseq001Delay = 200;
    public int[] pracimaseq001 = {33, 34, 35, 36, 37};
    public int prabaixoseq001Delay = 200;
    public int[] prabaixoseq001 = {17, 18, 19, 20, 21};
    public int leftCharacterseq001Delay = 200;
    public int[] leftCharacterseq001 = {25, 26, 27, 28, 29};
    public int rightCharacterseq001Delay = 200;
    public int[] rightCharacterseq001 = {41, 42, 43, 44, 45};
    private Image tileset;
    private Sprite CharacterLeft;
    public int Characterseq001Delay = 200;
    public int[] Characterseq001 = {24, 25, 26, 27, 28};
    private Sprite CharacterUp;
    public int CharacterUpseq001Delay = 200;
    public int[] CharacterUpseq001 = {32, 33, 34, 35, 36};
    private Sprite CharacterDown;
    public int CharacterDownseq001Delay = 260;
    public int[] CharacterDownseq001 = {16, 17, 18, 19, 20};
    private Sprite CharacterRight;
    public int CharacterRightseq001Delay = 200;
    public int[] CharacterRightseq001 = {40, 41, 42, 43, 44};
    private TiledLayer background;
    private TiledLayer blocks;
    private Sprite blocoAzul;
    public int blocoAzulseq001Delay = 200;
    public int[] blocoAzulseq001 = {0, 1};
    private Image bloco;
    private TiledLayer blocoPosicaoInicial;
//</editor-fold>//GEN-END:|fields|0|
//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|
    public Posicao[] posicaoBloco = new Posicao[TILE_INIT_BLOCO];
    public Posicao[] posicaoWin = new Posicao[TILE_INIT_BLOCO];

    public Image getCenario() throws java.io.IOException {//GEN-BEGIN:|2-getter|0|2-preInit
        if (cenario == null) {//GEN-END:|2-getter|0|2-preInit
            // write pre-init user code here
            cenario = Image.createImage("/game/images/cenario.png");//GEN-BEGIN:|2-getter|1|2-postInit
        }//GEN-END:|2-getter|1|2-postInit
        // write post-init user code here
        return this.cenario;//GEN-BEGIN:|2-getter|2|
    }//GEN-END:|2-getter|2|

    public Image getZelda_sprites() throws java.io.IOException {//GEN-BEGIN:|6-getter|0|6-preInit
        if (zelda_sprites == null) {//GEN-END:|6-getter|0|6-preInit
            // write pre-init user code here
            zelda_sprites = Image.createImage("/game/images/zelda_sprites.png");//GEN-BEGIN:|6-getter|1|6-postInit
        }//GEN-END:|6-getter|1|6-postInit
        // write post-init user code here
        return this.zelda_sprites;//GEN-BEGIN:|6-getter|2|
    }//GEN-END:|6-getter|2|

    public Image getPersonall() throws java.io.IOException {//GEN-BEGIN:|10-getter|0|10-preInit
        if (personall == null) {//GEN-END:|10-getter|0|10-preInit
            // write pre-init user code here
            personall = Image.createImage("/game/images/personall.png");//GEN-BEGIN:|10-getter|1|10-postInit
        }//GEN-END:|10-getter|1|10-postInit
        // write post-init user code here
        return this.personall;//GEN-BEGIN:|10-getter|2|
    }//GEN-END:|10-getter|2|

    public Sprite getCharacterLeft() throws java.io.IOException {//GEN-BEGIN:|20-getter|0|20-preInit
        if (CharacterLeft == null) {//GEN-END:|20-getter|0|20-preInit
            // write pre-init user code here
            CharacterLeft = new Sprite(getPersonall(), 32, 32);//GEN-BEGIN:|20-getter|1|20-postInit
            CharacterLeft.setFrameSequence(Characterseq001);//GEN-END:|20-getter|1|20-postInit
            CharacterLeft.defineReferencePixel(CharacterLeft.getWidth() / 2, CharacterLeft.getHeight() / 2);
        }//GEN-BEGIN:|20-getter|2|
        return CharacterLeft;
    }//GEN-END:|20-getter|2|

    public Sprite getCharacterUp() throws java.io.IOException {//GEN-BEGIN:|22-getter|0|22-preInit
        if (CharacterUp == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            CharacterUp = new Sprite(getPersonall(), 32, 32);//GEN-BEGIN:|22-getter|1|22-postInit
            CharacterUp.setFrameSequence(CharacterUpseq001);//GEN-END:|22-getter|1|22-postInit
            CharacterUp.defineReferencePixel(CharacterUp.getWidth() / 2, CharacterUp.getHeight() / 2);
        }//GEN-BEGIN:|22-getter|2|
        return CharacterUp;
    }//GEN-END:|22-getter|2|

    public Sprite getCharacterDown() throws java.io.IOException {//GEN-BEGIN:|24-getter|0|24-preInit
        if (CharacterDown == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            CharacterDown = new Sprite(getPersonall(), 32, 32);//GEN-BEGIN:|24-getter|1|24-postInit
            CharacterDown.setFrameSequence(CharacterDownseq001);//GEN-END:|24-getter|1|24-postInit
            CharacterDown.defineReferencePixel(CharacterDown.getWidth() / 2, CharacterDown.getHeight() / 2);
        }//GEN-BEGIN:|24-getter|2|
        return CharacterDown;
    }//GEN-END:|24-getter|2|

    public Sprite getCharacterRight() throws java.io.IOException {//GEN-BEGIN:|26-getter|0|26-preInit
        if (CharacterRight == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            CharacterRight = new Sprite(getPersonall(), 32, 32);//GEN-BEGIN:|26-getter|1|26-postInit
            CharacterRight.setFrameSequence(CharacterRightseq001);//GEN-END:|26-getter|1|26-postInit
            CharacterRight.defineReferencePixel(CharacterRight.getWidth() / 2, CharacterRight.getHeight() / 2);
        }//GEN-BEGIN:|26-getter|2|
        return CharacterRight;
    }//GEN-END:|26-getter|2|

    public void updateLayerManagerForTeste(LayerManager lm) throws java.io.IOException {//GEN-LINE:|28-updateLayerManager|0|28-preUpdate
        int x = 50;

        getBlocoPosicaoInicial().setPosition(0, 0);//GEN-BEGIN:|28-updateLayerManager|1|28-postUpdate
        getBlocoPosicaoInicial().setVisible(false);
        lm.append(getBlocoPosicaoInicial());
        getCharacterDown().setPosition(50, 94);
        getCharacterDown().setVisible(true);
        lm.append(getCharacterDown());
        getBlocks().setPosition(0, 0);
        getBlocks().setVisible(true);
        lm.append(getBlocks());
        getBackground().setPosition(0, 0);
        getBackground().setVisible(true);
        lm.append(getBackground());//GEN-END:|28-updateLayerManager|1|28-postUpdate
        // write post-update user code here
    }//GEN-LINE:|28-updateLayerManager|2|

    public TiledLayer getBackground() throws java.io.IOException {//GEN-BEGIN:|33-getter|0|33-preInit
        if (background == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
            background = new TiledLayer(20, 20, getCenario(), 16, 16);//GEN-BEGIN:|33-getter|1|33-midInit
            int[][] tiles = {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
            };//GEN-END:|33-getter|1|33-midInit
            int i = 0;
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (tiles[row][col] == TILE_END_BLOCO) {
                        posicaoWin[i] = new Posicao();
                        posicaoWin[i].x = col;
                        posicaoWin[i].y = row;
                        i++;
                    }
                }
            }


            for (int row = 0; row < 20; row++) {//GEN-BEGIN:|33-getter|2|33-postInit
                for (int col = 0; col < 20; col++) {
                    background.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|33-getter|2|33-postInit
        // write post-init user code here
        return background;//GEN-BEGIN:|33-getter|3|
    }//GEN-END:|33-getter|3|

    public TiledLayer getBlocks() throws java.io.IOException {//GEN-BEGIN:|58-getter|0|58-preInit
        if (blocks == null) {//GEN-END:|58-getter|0|58-preInit
            // write pre-init user code here
            blocks = new TiledLayer(20, 20, getCenario(), 16, 16);//GEN-BEGIN:|58-getter|1|58-midInit
            int[][] tiles = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}
            };//GEN-END:|58-getter|1|58-midInit
            // write mid-init user code here
            for (int row = 0; row < 20; row++) {//GEN-BEGIN:|58-getter|2|58-postInit
                for (int col = 0; col < 20; col++) {
                    blocks.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|58-getter|2|58-postInit
        // write post-init user code here
        return blocks;//GEN-BEGIN:|58-getter|3|
    }//GEN-END:|58-getter|3|

    public Image getTileset() throws java.io.IOException {//GEN-BEGIN:|87-getter|0|87-preInit
        if (tileset == null) {//GEN-END:|87-getter|0|87-preInit
            // write pre-init user code here
            tileset = Image.createImage("/game/images/tileset.png");//GEN-BEGIN:|87-getter|1|87-postInit
        }//GEN-END:|87-getter|1|87-postInit
        // write post-init user code here
        return this.tileset;//GEN-BEGIN:|87-getter|2|
    }//GEN-END:|87-getter|2|

    public Image getBloco() throws java.io.IOException {//GEN-BEGIN:|122-getter|0|122-preInit
        if (bloco == null) {//GEN-END:|122-getter|0|122-preInit
            // write pre-init user code here
            bloco = Image.createImage("/game/images/bloco.png");//GEN-BEGIN:|122-getter|1|122-postInit
        }//GEN-END:|122-getter|1|122-postInit
        // write post-init user code here
        return this.bloco;//GEN-BEGIN:|122-getter|2|
    }//GEN-END:|122-getter|2|

    public Sprite getBlocoAzul() throws java.io.IOException {//GEN-BEGIN:|123-getter|0|123-preInit
        if (blocoAzul == null) {//GEN-END:|123-getter|0|123-preInit
            // write pre-init user code here
            blocoAzul = new Sprite(getBloco(), 16, 16);//GEN-BEGIN:|123-getter|1|123-postInit
            blocoAzul.setFrameSequence(blocoAzulseq001);//GEN-END:|123-getter|1|123-postInit
            blocoAzul.defineReferencePixel(blocoAzul.getWidth() / 2, blocoAzul.getHeight() / 2);
        }//GEN-BEGIN:|123-getter|2|
        return blocoAzul;
    }//GEN-END:|123-getter|2|

    public TiledLayer getBlocoPosicaoInicial() throws java.io.IOException {//GEN-BEGIN:|149-getter|0|149-preInit
        if (blocoPosicaoInicial == null) {//GEN-END:|149-getter|0|149-preInit
            // write pre-init user code here
            blocoPosicaoInicial = new TiledLayer(20, 20, getCenario(), 16, 16);//GEN-BEGIN:|149-getter|1|149-midInit
            int[][] tiles = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };//GEN-END:|149-getter|1|149-midInit
            posicaoBloco = new Posicao[4];
            int i = 0;
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (tiles[row][col] == TILE_INIT_BLOCO) {
                        posicaoBloco[i] = new Posicao();
                        posicaoBloco[i].x = col;
                        posicaoBloco[i].y = row;
                        i++;
                    }
                }
            }
            for (int row = 0; row < 20; row++) {//GEN-BEGIN:|149-getter|2|149-postInit
                for (int col = 0; col < 20; col++) {
                    blocoPosicaoInicial.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|149-getter|2|149-postInit
        // write post-init user code here
        return blocoPosicaoInicial;//GEN-BEGIN:|149-getter|3|
    }//GEN-END:|149-getter|3|

    public class Posicao {

        public int x;
        public int y;
    }
}
