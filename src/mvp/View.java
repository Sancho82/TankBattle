package mvp;

import accessories.Tank;
import colors.GameColors;
import main.Main;

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

    private GameColors gameColors;
    private Font defaultFont = new Font("Verdana", Font.BOLD, 14);

    private Presenter presenter;

    public View() {

        setBounds(0, 0,650, 650);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        gameColors = new GameColors();

        presenter = new Presenter(this);

        mapButtons = new JButton[6][12];

        setSetupScreen();
    }

    public void setSetupScreen() {

        setupPanel = new JPanel();
        setupPanel.setBounds(0, 0, 650, 650);
        setupPanel.setBackground(gameColors.getDrape());
        setupPanel.setName("Setup");
        setupPanel.setLayout(null);

        setupTanksPerArmy = new JLabel(" Set tanks per opponent");
        setupTanksPerArmy.setBounds(50, 10, 295, 30);
        setupTanksPerArmy.setOpaque(true);
        setupTanksPerArmy.setBackground(gameColors.getLife());
        setupTanksPerArmy.setForeground(Color.WHITE);
        setupTanksPerArmy.setFont(defaultFont);

        setupTextField = new JTextField(null, null, 1);
        setupTextField.setBounds(355, 10, 50, 30);
        setupTextField.setBackground(gameColors.getFog());
        setupTextField.setForeground(Color.WHITE);
        setupTextField.setFont(defaultFont);

        setupSides = new JLabel(" Choose two opponents");
        setupSides.setBounds(50, 50, 295, 30);
        setupSides.setOpaque(true);
        setupSides.setBackground(gameColors.getLife());
        setupSides.setForeground(Color.white);
        setupSides.setFont(defaultFont);

        americans = new JCheckBox("Americans");
        americans.setBounds(50, 90, 145, 60);
        americans.setBackground(gameColors.getUsMilitary());
        americans.setForeground(Color.white);
        americans.setFont(defaultFont);

        germans = new JCheckBox("Germans");
        germans.setBounds(200, 90, 145, 60);
        germans.setBackground(gameColors.getGermanMilitary());
        germans.setForeground(Color.white);
        germans.setFont(defaultFont);

        soviets = new JCheckBox("Soviets");
        soviets.setBounds(350, 90, 145, 60);
        soviets.setBackground(gameColors.getSovietMilitary());
        soviets.setForeground(Color.white);
        soviets.setFont(defaultFont);

        setupButton = new JButton();
        setupButton.setBounds(50, 160, 145, 60);
        setupButton.setBackground(gameColors.getGold());
        setupButton.setForeground(Color.white);
        setupButton.setFont(defaultFont);
        setupButton.setText("Go!");

        setupButton.addActionListener(e -> {
            if (setupTextField.getText().matches(setupTextField.getText().length() == 1 ? "[1-9]" : "[1][0-2]")) {
                if (americans.isSelected() && germans.isSelected() && !soviets.isSelected()) {
                    presenter.startGame("US_GE", Integer.parseInt(setupTextField.getText()));

                } else if (!americans.isSelected() && germans.isSelected() && soviets.isSelected()) {
                    presenter.startGame("GE_SU", Integer.parseInt(setupTextField.getText()));

                } else if (americans.isSelected() && !germans.isSelected() && soviets.isSelected()) {
                    presenter.startGame("US_SU", Integer.parseInt(setupTextField.getText()));

                } else {
                    setupSides.setText(" Choose exactly two opponents!");
                }

            } else {
                setupTanksPerArmy.setText(" Type a number between 1 and 12!");
            }
        });

        setupPanel.add(americans);
        setupPanel.add(germans);
        setupPanel.add(soviets);

        setupPanel.add(setupTanksPerArmy);
        setupPanel.add(setupSides);
        setupPanel.add(setupTextField);
        setupPanel.add(setupButton);

        this.add(setupPanel);
        repaint();
    }

    public void setMapScreen() {
        this.remove(setupPanel);
        setBounds(0, 0, 1900, 650);
        setLocationRelativeTo(null);
        mapPanel = new JPanel();
        mapPanel.setLayout(null);
        mapPanel.setBounds(30, 50, 1750, 500);

        mapDrawer();

        fightButton = new JButton();
        fightButton.setBounds(800, 480, 300, 60);
        fightButton.setBackground(Color.orange);
        fightButton.setFont(new Font("Verdana", Font.BOLD, 17));
        fightButton.setText("Fight!");
        fightButton.addActionListener(e ->
                presenter.finishGame()
        );

        mapPanel.add(fightButton);
        this.add(mapPanel);
        repaint();
    }

    public void mapDrawer() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                JButton jButton = new JButton();
                jButton.setBounds(50 + i * 150, 50 + j * 65, 145 , 60);
                jButton.setBackground(Color.lightGray);
                jButton.setForeground(Color.white);
                jButton.setFont(defaultFont);
                mapButtons[j][i] = jButton;
                mapPanel.add(jButton);
            }
        }
    }

    public void tankDrawer(Tank[][] tankMatrix) {

        for (int i = 0; i < tankMatrix.length; i++) {
            for (int j = 0; j < tankMatrix[i].length; j++) {
                if (tankMatrix[i][j] != null) {

                    mapButtons[i][j].setText(tankMatrix[i][j].toStringBasic());

                    switch (tankMatrix[i][j].getNation()) {

                        case "United States":   mapButtons[i][j].setBackground(gameColors.getUsMilitary());
                            break;

                        case "Germany":         mapButtons[i][j].setBackground(gameColors.getGermanMilitary());
                            break;

                        case "Soviet Union":    mapButtons[i][j].setBackground(gameColors.getSovietMilitary());
                            break;

                    }

                } else {
                    mapButtons[i][j].setText(null);
                    mapButtons[i][j].setBackground(Color.lightGray);
                }
            }
        }
    }

    public void setEndScreen(String announcement) {
        this.remove(mapPanel);
        endPanel = new JPanel();
        endPanel.setLayout(null);
        endPanel.setBounds(30, 50, 1750, 500);

        resultLabel = new JLabel();
        resultLabel.setBounds(50, 50, 1750, 100);
        resultLabel.setBackground(Color.green);
        resultLabel.setOpaque(true);
        resultLabel.setFont(new Font("Stencil", Font.BOLD, 25));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setText(announcement);

        replayButton = new JButton("New Game");
        replayButton.setBounds(780, 170, 145, 60);
        replayButton.setBackground(gameColors.getBleed());
        replayButton.setForeground(Color.white);
        replayButton.setFont(defaultFont);
        replayButton.setHorizontalAlignment(SwingConstants.CENTER);
        replayButton.addActionListener(e -> {
            removeAll();
            setVisible(false);
            Main.main(null);
        });

        quitButton = new JButton("Quit");
        quitButton.setBounds(930, 170, 145, 60);
        quitButton.setBackground(gameColors.getFog());
        quitButton.setForeground(Color.white);
        quitButton.setFont(defaultFont);
        quitButton.setHorizontalAlignment(SwingConstants.CENTER);
        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        endPanel.add(resultLabel);
        endPanel.add(replayButton);
        endPanel.add(quitButton);
        this.add(endPanel);
        repaint();
    }
}
