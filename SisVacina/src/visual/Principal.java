/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

/**
 *
 * @author boemo
 */
public class Principal {
    public static Terminal terminal;
    public static Screen screen;
    public static GUIScreen guiScreen;
    
    public static void main(String[] args) {
        
                terminal = TerminalFacade.createTerminal();
        screen = new Screen(terminal);
        guiScreen = new GUIScreen(screen);

        screen.startScreen();
        
        guiScreen.showWindow(new TelaPrincipal(guiScreen));
        screen.stopScreen();
        
        
    }
}
