package View;

import Controller.MachineSelection.MachineSelectionController;
import Controller.MachineSelection.MachineSelectionObserver;
import View.Components.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class MachineSelectionView extends JFrame implements MachineSelectionObserver {

    JPanel jp_cp;
    String[] imageBuffer;
    MachineSelectionController controller;

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
    public MachineSelectionView(MachineSelectionController controller) throws HeadlessException {

        this.controller = controller;
        this.controller.attach(this);

        jp_cp = new JPanel(new BorderLayout());
        jp_cp.setBackground(Color.blue);
        initButtons();
        setSize(new Dimension(1000,550));

        imageBuffer = new String[]{"Assets\\pieceSelectionBackGround.png"};
        jp_cp.add(new ImagePanel(imageBuffer, new Dimension(500,500)), BorderLayout.CENTER);
        imageBuffer = new String[]{"Assets\\pieceCard.png"};
        jp_cp.add((new ImagePanel(imageBuffer, new Dimension(500,500))), BorderLayout.EAST);

        this.add(jp_cp);
        setVisible(true);
    }

    public void initButtons(){

        JPanel jp_buttons = new JPanel();
        jp_buttons.setBackground(Color.black);

        JButton jb_prev = new JButton("Peça Anterior");
        JButton jb_next = new JButton("Peça Seguinte");
        JButton jb_new = new JButton("Peça Nova");
        JButton jb_sel = new JButton("Selecionar");
        JRadioButton jrb_radio = new JRadioButton("Versão Radioativa");

        jb_prev.addActionListener(evt -> controller.prevMachine());
        jb_next.addActionListener(evt -> {
            try {
                controller.nextMachine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jb_new.addActionListener(evt -> controller.newMachine());
        jb_sel.addActionListener(evt -> {
            try {
                controller.selectMachine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jrb_radio.addActionListener(evt -> {
            try {
                controller.toggleRadMachine(jrb_radio.isSelected());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        jp_buttons.add(jb_prev);
        jp_buttons.add(jb_next);
        jp_buttons.add(jb_new);
        jp_buttons.add(jb_sel);
        jp_buttons.add(jrb_radio);

        jp_cp.add(jp_buttons, BorderLayout.SOUTH);
    }

    @Override
    public void prevMachineClicked() {
        System.out.println("cheguei querida");
    }

    @Override
    public void nextMachineClicked() {

    }

    @Override
    public void selMachineClicked() {

    }

    @Override
    public void newMachineClicked() {

    }

    @Override
    public void radMachineClicked() {

    }
}
