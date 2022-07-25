package View;

import Controller.BoardController.BoardController;
import Controller.BoardController.BoardObserver;
import Controller.MachineSelection.MachineSelectionController;
import View.Components.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame implements BoardObserver {
    private JPanel jp_contentPane;
    private JPanel jp_grid;
    private BoardController controller;

    public BoardView(BoardController controller) {

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

    private void loadGrid(){
        jp_grid = new JPanel(new GridLayout(8,8,2,2));
        jp_grid.setBackground(Color.black);
        jp_contentPane.add(BorderLayout.CENTER,jp_grid);
        String[] imagens = {"Assets\\Terrain.png", "Assets\\Piece1.png"};
        for (int i = 0; i < 64; i++) {
            jp_grid.add(new ImagePanel(imagens));
        }
    }

    private void loadScreen(){
        loadGrid();
    }

}
