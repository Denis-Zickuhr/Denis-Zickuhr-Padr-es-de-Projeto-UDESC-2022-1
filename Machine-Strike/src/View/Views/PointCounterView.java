package View.Views;

import Controller.BoardController.BoardController;
import Controller.PointCounterController.PointControllerObserver;
import Controller.PointCounterController.PointCounterController;
import Model.ConcreteModel.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PointCounterView extends JFrame implements PointControllerObserver {

    JPanel placar = new JPanel(new BorderLayout());
    JLabel pontos1 = new JLabel();
    JLabel pontos2 = new JLabel();
    JPanel jp_buttons;

    public PointCounterView() throws Exception {

        PointCounterController machineSelectionController = PointCounterController.getInstance();
        machineSelectionController.attach(this);

        JPanel jp_contentPane = new JPanel(new BorderLayout());
        setContentPane(jp_contentPane);

        setBackground(Color.WHITE);
        setSize(new Dimension(350,300));

        setTitle("Contador de pontos");

        setLocation(900,0);
        loadScreen();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);


        pontos1.setFont(new Font(Font.MONOSPACED, Font.BOLD,128));
        pontos1.setForeground(Color.blue);
        pontos2.setFont(new Font(Font.MONOSPACED, Font.BOLD,128));
        pontos2.setForeground(Color.red);
        placar.add(pontos1, BorderLayout.WEST);
        placar.add(pontos2, BorderLayout.EAST);
        placar.setVisible(true);
        this.add(placar, BorderLayout.CENTER);
        update();

    }


    private void loadScreen() {
        setVisible(true);
        jp_buttons = new JPanel();
        jp_buttons.add(new JButton("redo"), 0);
        jp_buttons.add(new JButton("undo"), 1);
        jp_buttons.add(new JButton("swap turn"), 2);
        this.add(jp_buttons, BorderLayout.SOUTH);
        loadButtonsEvents(jp_buttons);
    }

    private void loadButtonsEvents(JPanel jp_buttons){
        jp_buttons.getComponent(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    PointCounterController.getInstance().redo();
                } catch (Exception ignored) {
                }
            }
        });
        jp_buttons.getComponent(1).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    PointCounterController.getInstance().undo();
                } catch (Exception ignored) {
                }
            }
        });
        jp_buttons.getComponent(2).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    PointCounterController.getInstance().swap();
                } catch (Exception ignored) {
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
        if(Board.getPlayer1().getPoints() == 0){
            placar.setBackground(new Color(0xE87676));
            pontos1.setText(""+Board.getPlayer1().getPoints());
            Board.getPlayer1().block();
            Board.getPlayer2().block();
        } else if(Board.getPlayer2().getPoints() == 0){
            placar.setBackground(new Color(0x3992EC));
            pontos2.setText("");
            Board.getPlayer1().block();
            Board.getPlayer2().block();
        }
        this.repaint();
    }

}
