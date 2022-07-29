package View.Views;

import Model.Packer;

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
        JButton jb_load = new JButton("Carregar Mapa");

        jb_newGame.addActionListener(evt -> {
            try {
                new MachineSelectionView();
                this.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jb_about.addActionListener(evt -> {});

        jb_load.addActionListener(evt -> {
            try {
                onLoad();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });




        jp_contentPane.add(jb_newGame);
        jp_contentPane.add(jb_load);
        jp_contentPane.add(jb_about);
        jp_contentPane.updateUI();

    }

    public static void main(String[] args) {
        GameStartView gsv = new GameStartView();
    }

    private void onLoad() throws Exception {
        FileDialog fileDialog = new FileDialog((Frame) null);
        fileDialog.setVisible(true);
        String path = fileDialog.getDirectory() + fileDialog.getFile();
        Packer packer = new Packer();
        System.out.println(packer.loadPuzzle(path));
    }

}
