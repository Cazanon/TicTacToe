package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.art83.ticTacToe.controllers.ejbs.ControllerEjbFactory;

abstract class ViewPanel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;

    protected Frame frame;
    
    protected static final int FIELD_LENGTH = 15;
    
    protected static ControllerEjbFactory factory = new ControllerEjbFactory();
    
    ViewPanel(Frame frame){
        this.frame = frame;
        this.updateControllers();
        this.createComponents();
        this.updateComponents();
        this.visualizeComponents();    }
    
    protected abstract  void updateControllers();

    protected abstract void createComponents();
    
    protected abstract void updateComponents();
    
    protected abstract void visualizeComponents();
    
    protected void updateAndVisualizeComponents(){
        this.updateComponents();
        this.visualizeComponents();
    }
    
    protected JButton createButtonInPanel(String title){
        JButton result = new JButton(title);
        this.add(result);
        result.addActionListener(this);
        return result;
    }
    
    protected JLabel createLabelInPanel(String title){
        JLabel result = new JLabel(title);
        this.add(result);
        return result;
    }
    
    protected <T> JComboBox<T> createComboBoxInPanel(){
        JComboBox<T> result = new JComboBox<T>();
        this.add(result);
        return result;
    }
    
    protected JTextField createTextFieldInPanel(int length){
        JTextField result = new JTextField(length);
        this.add(result);
        return result;
    }
    
    protected JPasswordField createPasswordFieldInPanel(int length){
        JPasswordField result = new JPasswordField(length);
        this.add(result);
        return result;
    }
    
}
