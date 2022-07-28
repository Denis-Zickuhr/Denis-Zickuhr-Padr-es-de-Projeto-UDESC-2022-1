package View;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.CommandFactory.MoveCommandoFactory;
import Controller.BoardController.Command.CommandInvoker;
import Controller.MachineSelection.MachineSelectionController;
import Controller.PointCounterController.PointControllerObserver;
import Controller.PointCounterController.PointCounterController;
import Model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PointCounterView extends JFrame implements PointControllerObserver {

    JPanel placar = new JPanel(new BorderLayout());
    JLabel pontos1 = new JLabel();
    JLabel pontos2 = new JLabel();

    public PointCounterView() throws Exception {

        PointCounterController machineSelectionController = PointCounterController.getInstance();
        machineSelectionController.attach(this);

        JPanel jp_contentPane = new JPanel(new BorderLayout());
        setContentPane(jp_contentPane);

        setBackground(Color.WHITE);
        setSize(new Dimension(150,300));

        setTitle("Contador de pontos");

        setLocation(900,0);
        loadScreen();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);


        pontos1.setFont(new Font(Font.MONOSPACED, Font.BOLD,90));
        pontos1.setForeground(Color.blue);
        pontos2.setFont(new Font(Font.MONOSPACED, Font.BOLD,90));
        pontos2.setForeground(Color.red);
        placar.add(pontos1, BorderLayout.WEST);
        placar.add(pontos2, BorderLayout.EAST);
        placar.setVisible(true);
        this.add(placar, BorderLayout.CENTER);
        update();

    }


    private void loadScreen() {
        setVisible(true);
        JPanel jp_buttons = new JPanel();
        jp_buttons.add(new JButton("redo"), 0);
        jp_buttons.add(new JButton("undo"), 1);

        this.add(jp_buttons, BorderLayout.SOUTH);
        loadButtonsEvents(jp_buttons);
    }

    private void loadButtonsEvents(JPanel jp_buttons){
        jp_buttons.getComponent(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    CommandInvoker.getCommandInvoker().redo();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jp_buttons.getComponent(1).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    CommandInvoker.getCommandInvoker().undo();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    public void update() {
        if (Board.getPlayer1() == BoardController.getInstance().getTurn()){
            placar.setBackground(new Color(0x3992EC));
        }else{
            placar.setBackground(new Color(0xE87676));
        }
        pontos1.setText(""+Board.getPlayer1().getPoints());
        pontos2.setText(Board.getPlayer2().getPoints()+"");
        placar.updateUI();
        this.repaint();
    }

    @Override
    public void post() {

    }


}
