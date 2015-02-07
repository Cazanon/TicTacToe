package es.art83.ticTacToe.views.desktop;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import es.art83.ticTacToe.controllers.LogoutController;
import es.art83.ticTacToe.controllers.SaveGameController;
import es.art83.ticTacToe.controllers.ShowGameController;

@SuppressWarnings("serial")
public class SaveViewPanel extends ViewPanel {

	private SaveGameController saveGameController;

	private ShowGameController showGameController;
	
	private LogoutController logoutController;

	private boolean logout;

	private JLabel gameNamesMsg;

	private JTextArea gameNames;

	private JLabel gameNameMsg;

	private JTextField gameName;

	private JButton save;

	private JButton overwrite;

	private JButton cancel;

	private boolean duplicated;

	SaveViewPanel(Frame frame, boolean logout) {
		super(frame);
		this.logout = logout;
	}

	public SaveViewPanel(Frame frame) {
		this(frame, false);
	}

	@Override
	protected void updateControllers() {
		duplicated = false;
		saveGameController = factory.getSaveGameController();
		showGameController = factory.getShowGameController();
		logoutController = factory.getLogoutController();
	}

	@Override
	protected void createComponents() {
		gameNamesMsg = this.createLabelInPanel("Game names:");
		gameNames = this.createTextAreaWithScrollInPanel(FIELD_LENGTH, 3);
		gameNameMsg = this.createLabelInPanel("Game name:");
		gameName = this.createTextFieldInPanel(FIELD_LENGTH);
		save = this.createButtonInPanel("Save Game");
		overwrite = this.createButtonInPanel("Overwrite Game");
		cancel = this.createButtonInPanel("Cancel");
	}

	@Override
	protected void updateComponents() {
		String text = "";
		for (String gameName : showGameController.gameNamesOfPlayer()) {
			text += gameName + "\n";
		}
		gameNames.setText(text);
	}

	@Override
	protected void visualizeComponents() {
		gameNamesMsg.setVisible(true);
		gameNames.setVisible(true);
		gameNameMsg.setVisible(true);
		gameName.setVisible(true);
		save.setVisible(!duplicated);
		overwrite.setVisible(duplicated);
		cancel.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == save) {
			this.save();
		} else if (event.getSource() == overwrite) {
			this.overwrite();
		} else if (event.getSource() == cancel) {
			this.cancel();
		} else {
			assert false;
		}
	}

	private void save() {
		if (gameName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Game name can't be empty!");
		} else {
			for (String gameName : showGameController.gameNamesOfPlayer()) {
				if (this.gameName.getText().equals(gameName)) {
					duplicated = true;
				}
			}
			if (!duplicated) {
				saveGameController.saveGame(gameName.getText());
				this.nextPanel();
			} else {
				this.updateAndVisualizeComponents();
			}
		}
	}

	private void overwrite() {
		saveGameController.overwriteGame(gameName.getText());
		this.nextPanel();
	}

	private void cancel() {
		if (duplicated) {
			duplicated = false;
			this.updateAndVisualizeComponents();
		} else {
			frame.setPanel(new GameViewPanel(frame));
		}
	}
	
	private void nextPanel(){
		if (logout) {
			logoutController.logout();
			frame.setPanel(new LoginViewPanel(frame));
		} else {
			frame.setPanel(new GameViewPanel(frame));
		}
	}
}
