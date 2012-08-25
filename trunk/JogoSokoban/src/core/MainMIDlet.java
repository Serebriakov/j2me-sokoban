/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import game.MainGame;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.SplashScreen;

/**
 * @author jaspion
 */
public class MainMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command okCommand;
    private Command okCommand1;
    private Command okCommand2;
    private Command backCommand;
    private SplashScreen splashScreen;
    private Form optionForm;
    private List list;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public MainMIDlet() {
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
        switchDisplayable(null, getList());//GEN-LINE:|3-startMIDlet|1|3-postAction
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
        if (displayable == list) {//GEN-BEGIN:|7-commandAction|1|68-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|68-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|2|68-postAction
                // write post-action user code here
            } else if (command == okCommand1) {//GEN-LINE:|7-commandAction|3|76-preAction
                // write pre-action user code hereasdf



                method();//GEN-LINE:|7-commandAction|4|76-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|86-preAction
        } else if (displayable == optionForm) {
            if (command == backCommand) {//GEN-END:|7-commandAction|5|86-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|6|86-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|24-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|7|24-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|8|24-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|7-postCommandAction
        }//GEN-END:|7-commandAction|9|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|10|
//</editor-fold>//GEN-END:|7-commandAction|10|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|

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

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|45-getter|1|45-postInit
            // write post-init user code here
        }//GEN-BEGIN:|45-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|45-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: optionForm ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initialized instance of optionForm component.
     *
     * @return the initialized component instance
     */
    public Form getOptionForm() {
        if (optionForm == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            optionForm = new Form("Option");//GEN-BEGIN:|56-getter|1|56-postInit
            optionForm.addCommand(getBackCommand());
            optionForm.setCommandListener(this);//GEN-END:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return optionForm;
    }
//</editor-fold>//GEN-END:|56-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|67-getter|0|67-preInit
    /**
     * Returns an initialized instance of list component.
     *
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|67-getter|0|67-preInit
            // write pre-init user code here
            list = new List("Menu", Choice.IMPLICIT);//GEN-BEGIN:|67-getter|1|67-postInit
            list.append("List Element 1", null);
            list.append("List Element 2", null);
            list.addCommand(getOkCommand1());
            list.setCommandListener(this);
            list.setSelectedFlags(new boolean[]{false, false});//GEN-END:|67-getter|1|67-postInit
            // write post-init user code here
        }//GEN-BEGIN:|67-getter|2|
        return list;
    }
//</editor-fold>//GEN-END:|67-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|67-action|0|67-preAction
    /**
     * Performs an action assigned to the selected list element in the list
     * component.
     */
    public void listAction() {//GEN-END:|67-action|0|67-preAction
        // enter pre-action user code here
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-BEGIN:|67-action|1|70-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("List Element 1")) {//GEN-END:|67-action|1|70-preAction
                // write pre-action user code here
                startGame();//GEN-LINE:|67-action|2|70-postAction
                // write post-action user code here
            } else if (__selectedString.equals("List Element 2")) {//GEN-LINE:|67-action|3|71-preAction
                // write pre-action user code here
                switchDisplayable(null, getOptionForm());//GEN-LINE:|67-action|4|71-postAction
                // write post-action user code here
            }//GEN-BEGIN:|67-action|5|67-postAction
        }//GEN-END:|67-action|5|67-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|67-action|6|
//</editor-fold>//GEN-END:|67-action|6|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|75-getter|1|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|2|
        return okCommand1;
    }
//</editor-fold>//GEN-END:|75-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|77-getter|0|77-preInit
    /**
     * Returns an initialized instance of okCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {//GEN-END:|77-getter|0|77-preInit
            // write pre-init user code here
            okCommand2 = new Command("Ok", Command.OK, 0);//GEN-LINE:|77-getter|1|77-postInit
            // write post-init user code here
        }//GEN-BEGIN:|77-getter|2|
        return okCommand2;
    }
//</editor-fold>//GEN-END:|77-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: method ">//GEN-BEGIN:|80-switch|0|80-preSwitch
    /**
     * Performs an action assigned to the method switch-point.
     */
    public void method() {//GEN-END:|80-switch|0|80-preSwitch
        int menuIndex = getList().getSelectedIndex() + 1;


        switch (menuIndex) {//GEN-BEGIN:|80-switch|1|81-preAction
            case 1://GEN-END:|80-switch|1|81-preAction
                // write pre-action user code here
                startGame();//GEN-LINE:|80-switch|2|81-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|80-switch|3|82-preAction
            case 2://GEN-END:|80-switch|3|82-preAction
                // write pre-action user code here
                switchDisplayable(null, getOptionForm());//GEN-LINE:|80-switch|4|82-postAction
                // write post-action user code here
                break;//GEN-BEGIN:|80-switch|5|80-postSwitch
        }//GEN-END:|80-switch|5|80-postSwitch
        // enter post-switch user code here
    }//GEN-BEGIN:|80-switch|6|
//</editor-fold>//GEN-END:|80-switch|6|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|85-getter|0|85-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|85-getter|0|85-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|85-getter|1|85-postInit
            // write post-init user code here
        }//GEN-BEGIN:|85-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|85-getter|2|

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

        MainGame mainGame = new MainGame();
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
}
