package View;

import Controller.MachineSelection.MachineSelectionController;

import javax.swing.*;
import java.awt.*;

public class GameStartView extends JFrame {

    private final JPanel jp_contentPane = new JPanel();

    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public GameStartView() throws HeadlessException {
        super();
        initComponents();
    }

    public void initComponents(){
        jp_contentPane.setBackground(Color.white);
        jp_contentPane.setLayout(new BorderLayout());
        setContentPane(jp_contentPane);
        setSize(new Dimension(400,100));
        setVisible(true);
        setTitle("Robo Strike");
        setLocation(0,0);
        initButtons();
    }

    public void initButtons(){
        JButton jb_newGame = new JButton("Novo Jogo");
        JButton jb_about = new JButton("Sobre");

        jb_newGame.addActionListener(evt -> {
            try {
                new MachineSelectionView();
                this.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jb_about.addActionListener(evt -> {});


        jp_contentPane.add(jb_newGame, BorderLayout.PAGE_START);
        jp_contentPane.add(jb_about, BorderLayout.PAGE_END);
        jp_contentPane.updateUI();

    }

    public static void main(String[] args) {
        GameStartView gsv = new GameStartView();
    }

}
