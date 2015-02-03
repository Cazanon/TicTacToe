package es.art83.ticTacToe.views.desktop;

import javax.swing.JFrame;

@SuppressWarnings("serial")
class Frame extends JFrame {

    Frame() {
        super("TicTacToe");
        this.setLocation(0, 0);
        this.setSize(500, 150);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPanel(new LoginViewPanel(this));
    }

    void setPanel(ViewPanel viewPanel) {
        this.setContentPane(viewPanel);
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        new Frame();
    }
}
