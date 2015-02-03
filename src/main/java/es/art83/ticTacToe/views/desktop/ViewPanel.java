package es.art83.ticTacToe.views.desktop;

import javax.swing.JPanel;

import es.art83.ticTacToe.controllers.ejbs.ControllerFactoryEJB;

abstract class ViewPanel extends JPanel {

    protected Frame frame;
    
    protected static ControllerFactoryEJB factory = new ControllerFactoryEJB();
    
    ViewPanel(Frame frame){
        this.frame = frame;
    }
    
}
