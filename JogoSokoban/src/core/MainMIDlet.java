package core;

import game.MainGame;
import game.MenuGame;
import game.ScoreList;
import java.util.Calendar;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.m2g.SVGImage;
import javax.microedition.rms.RecordStore;
import org.netbeans.microedition.lcdui.SplashScreen;

/**
 * @author lucasirc
 */
public class MainMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private static final String NAME_SOKOBAN = "MainSokobanScore";
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command okCommand;
    private Command cancelCommand;
    private Command backCommand;
    private Command backCommand1;
    private SplashScreen splashScreen;
    private Form form;
    private TextField nome;
    private StringItem score;
    private StringItem data;
    private List list;
    private Alert alert;
    private SVGImage svgImage;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public MainMIDlet() {
//        try {
//        RecordStore.deleteRecordStore(NAME_SOKOBAN); } catch (Exception e ) {}
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|
//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the
     * <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        goMenuGame();//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The
     * <code>display</code> instance is taken from
     * <code>getDisplay</code> method. This method is used by all actions in the
     * design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display;
     * if <code>null</code>, then <code>nextDisplayable</code> is set
     * immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|105-preAction
            if (command == cancelCommand) {//GEN-END:|7-commandAction|1|105-preAction
                // write pre-action user code here
                goMenuGame();//GEN-LINE:|7-commandAction|2|105-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|103-preAction
                // write pre-action user code here
                saveScore();//GEN-LINE:|7-commandAction|4|103-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|116-preAction
        } else if (displayable == list) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|5|116-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|6|116-postAction
                // write post-action user code here
            } else if (command == backCommand1) {//GEN-LINE:|7-commandAction|7|119-preAction
                // write pre-action user code here
                goMenuGame();//GEN-LINE:|7-commandAction|8|119-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|24-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|9|24-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|10|24-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|7-postCommandAction
        }//GEN-END:|7-commandAction|11|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|12|
//</editor-fold>//GEN-END:|7-commandAction|12|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of splashScreen component.
     *
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|22-getter|1|22-postInit
            splashScreen.setTitle("splashScreen");
            splashScreen.setCommandListener(this);
            splashScreen.setText("Splash");//GEN-END:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return splashScreen;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgImage ">//GEN-BEGIN:|96-getter|0|96-preInit
    /**
     * Returns an initialized instance of svgImage component.
     *
     * @return the initialized component instance
     */
    public SVGImage getSvgImage() {
        if (svgImage == null) {//GEN-END:|96-getter|0|96-preInit
            // write pre-init user code here
            svgImage = SVGImage.createEmptyImage(null);//GEN-LINE:|96-getter|1|96-postInit
            // write post-init user code here
        }//GEN-BEGIN:|96-getter|2|
        return svgImage;
    }
//</editor-fold>//GEN-END:|96-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|97-getter|0|97-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|97-getter|0|97-preInit
            // write pre-init user code here
            form = new Form("Entre com seu nome", new Item[]{getNome(), getData(), getScore()});//GEN-BEGIN:|97-getter|1|97-postInit
            form.addCommand(getOkCommand());
            form.addCommand(getCancelCommand());
            form.setCommandListener(this);//GEN-END:|97-getter|1|97-postInit
            // write post-init user code here
        }//GEN-BEGIN:|97-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|97-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: nome ">//GEN-BEGIN:|100-getter|0|100-preInit
    /**
     * Returns an initialized instance of nome component.
     *
     * @return the initialized component instance
     */
    public TextField getNome() {
        if (nome == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            nome = new TextField("Nome:", null, 6, TextField.ANY);//GEN-LINE:|100-getter|1|100-postInit
            // write post-init user code here
        }//GEN-BEGIN:|100-getter|2|
        return nome;
    }
//</editor-fold>//GEN-END:|100-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: score ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initialized instance of score component.
     *
     * @return the initialized component instance
     */
    public StringItem getScore() {
        if (score == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            score = new StringItem("Score:", null);//GEN-LINE:|101-getter|1|101-postInit
            // write post-init user code here
        }//GEN-BEGIN:|101-getter|2|
        return score;
    }
//</editor-fold>//GEN-END:|101-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|102-getter|0|102-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|102-getter|0|102-preInit
            // write pre-init user code here
            okCommand = new Command("Salvar", Command.OK, 0);//GEN-LINE:|102-getter|1|102-postInit
            // write post-init user code here
        }//GEN-BEGIN:|102-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|102-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initialized instance of cancelCommand component.
     *
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            cancelCommand = new Command("Cancelar", Command.CANCEL, 0);//GEN-LINE:|104-getter|1|104-postInit
            // write post-init user code here
        }//GEN-BEGIN:|104-getter|2|
        return cancelCommand;
    }
//</editor-fold>//GEN-END:|104-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: data ">//GEN-BEGIN:|106-getter|0|106-preInit
    /**
     * Returns an initialized instance of data component.
     *
     * @return the initialized component instance
     */
    public StringItem getData() {
        if (data == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            data = new StringItem("Data", null);//GEN-LINE:|106-getter|1|106-postInit
            // write post-init user code here
        }//GEN-BEGIN:|106-getter|2|
        return data;
    }
//</editor-fold>//GEN-END:|106-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|112-getter|0|112-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|112-getter|0|112-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|112-getter|1|112-postInit
            // write post-init user code here
        }//GEN-BEGIN:|112-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|112-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|118-getter|0|118-preInit
    /**
     * Returns an initialized instance of backCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|118-getter|0|118-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|118-getter|1|118-postInit
            // write post-init user code here
        }//GEN-BEGIN:|118-getter|2|
        return backCommand1;
    }
//</editor-fold>//GEN-END:|118-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|115-getter|0|115-preInit
    /**
     * Returns an initialized instance of list component.
     *
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|115-getter|0|115-preInit
            // write pre-init user code here
            list = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|115-getter|1|115-postInit
            list.addCommand(getBackCommand1());
            list.setCommandListener(this);//GEN-END:|115-getter|1|115-postInit
            // write post-init user code here
        }//GEN-BEGIN:|115-getter|2|
        return list;
    }
//</editor-fold>//GEN-END:|115-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|115-action|0|115-preAction
    /**
     * Performs an action assigned to the selected list element in the list
     * component.
     */
    public void listAction() {//GEN-END:|115-action|0|115-preAction
        // enter pre-action user code here
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-LINE:|115-action|1|115-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|115-action|2|
//</editor-fold>//GEN-END:|115-action|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|122-getter|0|122-preInit
    /**
     * Returns an initialized instance of alert component.
     *
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|122-getter|0|122-preInit
            // write pre-init user code here
            alert = new Alert("Nome est\u00E1 vazio", "O nome n\u00E3o pode ser vazio para gravar a pontua\u00E7\u00E3o", null, AlertType.WARNING);//GEN-BEGIN:|122-getter|1|122-postInit
            alert.setTimeout(Alert.FOREVER);//GEN-END:|122-getter|1|122-postInit
            // write post-init user code here
        }//GEN-BEGIN:|122-getter|2|
        return alert;
    }
//</editor-fold>//GEN-END:|122-getter|2|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    public void startGame() {

        MainGame mainGame = new MainGame(this);
        mainGame.start();
        switchDisplayable(null, mainGame);
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    public void goMenuGame() {

        menu = new MenuGame(this);
        menu.start();
        Display.getDisplay(this).setCurrent(menu);
    }

    public void goMainGame() {

        game = new MainGame(this);
        game.start();
        Display.getDisplay(this).setCurrent(game);
    }

    public void goSaveScore(int score) {


        Calendar calendar = Calendar.getInstance();

        String data = calendar.get(Calendar.DAY_OF_MONTH) + "/"
                + (calendar.get(Calendar.MONTH) + 1) + "/"
                + calendar.get(Calendar.YEAR) + " "
                + calendar.get(Calendar.HOUR_OF_DAY) + ":";

        if (calendar.get(Calendar.MINUTE) < 9) {
            data += "0" + calendar.get(Calendar.MINUTE);
        } else {
            data += calendar.get(Calendar.MINUTE);
        }


        getData().setText(data);
        getScore().setText(new Integer(score).toString());

        Display.getDisplay(this).setCurrent(getForm());
    }
    private MenuGame menu;
    private MainGame game;

    public void saveScore() {

        if (getNome().getString() != null && getNome().getString().length() != 0) {

            try {

                Registro ultimo = getRegistro();

                Registro[] registros = listarRegistros();
                Registro[] novaLista = new Registro[registros.length + 1];

                for (int i = 0; i < registros.length; i++) {
                    novaLista[i] = registros[i];
                }
                novaLista[novaLista.length - 1] = ultimo;



                RecordStore.deleteRecordStore(NAME_SOKOBAN);


                RecordStore recordStore =
                        RecordStore.openRecordStore(NAME_SOKOBAN, true);

                sort(novaLista);
                int max = novaLista.length < 5 ? novaLista.length : 5;
                for (int i = 0; i < max; i++) {
                    System.out.println(novaLista[i].toString());

                    byte[] byteOutputData = novaLista[i].toString().getBytes();
                    recordStore.addRecord(byteOutputData, 0, byteOutputData.length);

                }


                recordStore.closeRecordStore();
                goMenuGame();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Display.getDisplay(this).setCurrent(getAlert(), getForm());
        }
    }

    /**
     * Lista todos os registros que estao gravados no recordStore
     *
     * @return
     */
    public Registro[] listarRegistros() {
        try {
            RecordStore recordStore =
                    RecordStore.openRecordStore(NAME_SOKOBAN, true);

            byte[] recData = new byte[5];
            Registro[] registros = new Registro[recordStore.getNumRecords()];
            for (int i = 1; i < recordStore.getNumRecords() + 1; i++) {
                if (recordStore.getRecordSize(i) > recData.length) {
                    recData = new byte[recordStore.getRecordSize(i)];
                }

                int len = recordStore.getRecord(i, recData, 0);
                System.out.println("Record #" + i + ": " + new String(recData, 0, len));
                System.out.println("------------------------------");

                Registro novoRegistro = new Registro(new String(recData, 0, len));
                registros[i - 1] = novoRegistro;

            }


            recordStore.closeRecordStore();
            return registros;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void sort(Registro[] registros) {


        int index_min;
        Registro aux;

        for (int i = 0; i < registros.length; i++) {
            index_min = i;
            for (int j = i + 1; j < registros.length; j++) {
                if (registros[j].getScore() > registros[index_min].getScore()) {
                    index_min = j;
                }
            }
            if (index_min != i) {
                aux = registros[index_min];
                registros[index_min] = registros[i];
                registros[i] = aux;
            }
        }

    }

    private Registro getRegistro() {
        String name = getNome().getString();
        String date = getData().getText();
        String pontuacao = getScore().getText();

        Registro registro = new Registro(name, date, pontuacao);
        return registro;
    }

    public void goPontuacao() {

        ScoreList lista = new ScoreList(this);
        lista.start();

        Display.getDisplay(this).setCurrent(lista);

    }
}
