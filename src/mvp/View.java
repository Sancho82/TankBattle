package mvp;

import accessories.Tank;
import colors.GameColors;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements Contract.ViewIF {

    private JPanel setupPanel;
    private JLabel setupTanksPerArmy;
    private JLabel setupSides;
    private JTextField setupTextField;

    private JCheckBox americans;
    private JCheckBox germans;
    private JCheckBox soviets;

    private JButton setupButton;

    private JPanel mapPanel;
    private JButton[][] mapButtons;
    private JButton fightButton;

    private JLabel resultLabel;
    private JPanel endPanel;
    private JButton replayButton;
    private JButton quitButton;

    GameColors gameColors;
    Font defaultFont = new Font("Verdana", Font.BOLD, 14);

    private Presenter presenter;

    public View() {

    }

    @Override
    public void setSetupScreen() {

    }

    @Override
    public void setMapScreen() {

    }

    @Override
    public void mapDrawer() {

    }

    @Override
    public void tankDrawer(Tank[][] tankMatrix) {

    }

    @Override
    public void setEndScreen(String announcement) {

    }
}
