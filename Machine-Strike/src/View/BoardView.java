package View;

import Controller.BoardController.BoardController;
import Controller.BoardController.BoardObserver;
import Controller.MachineSelection.MachineSelectionController;
import Model.BoardEntity;
import Model.ConcreteModel.ConcreteMachine.Armed.KingArmedMachine;
import Model.ConcreteModel.ConcreteMachine.ConcreteStrategy.BlackStrategy;
import Model.Terrain.Terrain;
import View.Components.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class BoardView extends JFrame implements BoardObserver {
    private JPanel jp_contentPane;
    private JPanel jp_grid;
    private BoardController controller;

    public BoardView(BoardController controller) throws Exception {

        this.controller = controller;
        this.controller.attach(this);

        jp_contentPane = new JPanel();
        jp_contentPane.setBackground(Color.black);
        setSize(new Dimension(800,800));
        BorderLayout layout = new BorderLayout();
        jp_contentPane.setLayout(layout);
        setContentPane(jp_contentPane);
        setTitle("App");
        setLocation(0,0);
        loadScreen();
    }

    private void loadGrid() throws Exception {
        jp_grid = new JPanel(new GridLayout(8,8,2,2));
        jp_grid.setBackground(Color.black);
        jp_contentPane.add(BorderLayout.CENTER,jp_grid);
    }

    public void draw(ArrayList<Terrain> board){
        this.setVisible(true);
        for (int i = 0; i < 64; i++) {
            ImagePanel piece = new ImagePanel(board.get(i).getDraw());
            int finalI = i;
            piece.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    System.out.println(Arrays.toString((Integer.toString(finalI, 8) + "").split("")));
                }
            }
            );
            jp_grid.add(piece);
        }
    }

    private void loadScreen() throws Exception {
        loadGrid();
    }
}
