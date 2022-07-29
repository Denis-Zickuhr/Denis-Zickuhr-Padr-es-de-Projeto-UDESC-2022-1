package View.Views;

import Controller.MachineSelection.MachineSelectionController;
import Controller.MachineSelection.MachineSelectionObserver;
import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.Machine;
import View.Components.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class MachineSelectionView extends JFrame implements MachineSelectionObserver {

    JPanel jp_cp;
    JComboBox<AbstractStrategy> jb_new;
    String[] imageBuffer;
    String[] machineBuffer = {"Assets\\pieceSelectionBackGround.png"};
    ImagePanel piece;
    JLabel machineData = new JLabel("init");

    @Override
    public void addPieceStrategy(AbstractStrategy st){
        this.jb_new.addItem(st);
    }

    @Override
    public AbstractStrategy getStrategy() {
        try {
            return (AbstractStrategy) jb_new.getSelectedItem();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void enableComboBox(Boolean enable) {
        jb_new.setEnabled(enable);
    }

    public MachineSelectionView() throws Exception {

        MachineSelectionController controller = MachineSelectionController.getInstance();
        controller.attach(this);

        setTitle("Seleção de peças, Jogador 1");

        jp_cp = new JPanel(new BorderLayout());
        jp_cp.setBackground(Color.white);
        initButtons();
        setSize(new Dimension(500,550));

        piece = new ImagePanel(machineBuffer, new Dimension(500,500));
        jp_cp.add(piece , BorderLayout.CENTER);
        jp_cp.add(machineData, BorderLayout.NORTH);

        this.add(jp_cp);
        setVisible(true);

        MachineSelectionController.getInstance().init();
    }

    public void initButtons(){

        JPanel jp_buttons = new JPanel();
        jp_buttons.setBackground(Color.black);

        JButton jb_prev = new JButton("<");
        JButton jb_next = new JButton(">");
        jb_new = new JComboBox();
        JButton jb_sel = new JButton("Adiciona");
        JRadioButton jrb_radio = new JRadioButton("Versão Armada");
        JButton jb_conf = new JButton("Ok");

        jb_prev.addActionListener(evt -> {
            try {
                MachineSelectionController.getInstance().prevMachine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jb_next.addActionListener(evt -> {
            try {
                MachineSelectionController.getInstance().nextMachine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jb_new.addActionListener(evt -> {
            try {
                MachineSelectionController.getInstance().changeStrategy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jb_sel.addActionListener(evt -> {
            try {
                MachineSelectionController.getInstance().selectMachine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jrb_radio.addActionListener(evt -> {
            try {
                MachineSelectionController.getInstance().toggleRadMachine(jrb_radio.isSelected());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        jb_conf.addActionListener(evt -> {
            try {
                MachineSelectionController.getInstance().confirmePlayerSet();
                this.setTitle("Seleção de peças, Jogador 2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        jp_buttons.add(jb_prev);
        jp_buttons.add(jb_next);
        jp_buttons.add(jb_new);
        jp_buttons.add(jb_sel);
        jp_buttons.add(jrb_radio);
        jp_buttons.add(jb_conf);

        jp_cp.add(jp_buttons, BorderLayout.SOUTH);
    }

    @Override
    public void alterTittle() {
        setTitle("Seleção de peças, Jogador 2");
    }

    @Override
    public void drawMachine(Machine machine){
        try {
            String[] newBuffer = rebuff(this.machineBuffer, machine.getBuffer());
            machineData.setText(machine.toString());
            jp_cp.remove(piece);
            piece = new ImagePanel(newBuffer, new Dimension(500, 500));
            jp_cp.add(piece, BorderLayout.CENTER);
            jp_cp.updateUI();
        }catch(Exception e){
            String[] newBuffer = rebuff(this.machineBuffer, new String[]{"Assets\\nopiece.png"});
            machineData.setText("Máquina indisponível");
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
        for (int i = 0; i < newBuffer.length; i++) {
            if(newBuffer[i] != null)
            newBuffer[i] = newBuffer[i].replaceAll("#", "large");
        }
        return newBuffer;
    }
}
