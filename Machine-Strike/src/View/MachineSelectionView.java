package View;

import Controller.MachineSelection.MachineSelectionController;
import Controller.MachineSelection.MachineSelectionObserver;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import View.Components.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class MachineSelectionView extends JFrame implements MachineSelectionObserver {

    JPanel jp_cp;
    JComboBox<AbstractStrategy> jb_new;
    String[] imageBuffer;
    String[] machineBuffer = {"Assets\\pieceSelectionBackGround.png"};
    ImagePanel piece;
    MachineSelectionController controller;

    @Override
    public void addPieceStrategy(AbstractStrategy st){
        this.jb_new.addItem(st);
    }

    @Override
    public AbstractStrategy getStrategy() {
        return (AbstractStrategy)jb_new.getSelectedItem();
    }

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

        piece = new ImagePanel(machineBuffer, new Dimension(500,500));
        jp_cp.add(piece , BorderLayout.CENTER);
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
        jb_new = new JComboBox();
        JButton jb_sel = new JButton("Selecionar");
        JRadioButton jrb_radio = new JRadioButton("Versão Radioativa");

        jb_prev.addActionListener(evt -> {
            try {
                controller.prevMachine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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

    @Override
    public void drawMachine(Machine machine){
        try {
            String[] newBuffer = rebuff(this.machineBuffer, machine.getBuffer());
            jp_cp.remove(piece);
            piece = new ImagePanel(newBuffer, new Dimension(500, 500));
            jp_cp.add(piece, BorderLayout.CENTER);
            jp_cp.updateUI();
        }catch(Exception e){
            String[] newBuffer = rebuff(this.machineBuffer, new String[]{"Assets\\nopiece.png"});
            jp_cp.remove(piece);
            piece = new ImagePanel(newBuffer, new Dimension(500, 500));
            jp_cp.add(piece, BorderLayout.CENTER);
            jp_cp.updateUI();
        }
    }

    private String[] rebuff(String[] buffer, String[] sources){
        String[] newBuffer = new String[sources.length + buffer.length];
        newBuffer[0] = buffer[0];
        System.arraycopy(sources, 0, newBuffer, 1, sources.length + 1 - 1);
        return newBuffer;
    }
}
