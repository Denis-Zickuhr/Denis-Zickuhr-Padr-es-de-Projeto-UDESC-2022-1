package View;

import Controller.BoardController.BoardController;
import Controller.BoardController.BoardObserver;
import Controller.BoardController.Command.Commands.Move;
import Model.Terrain.Terrain;
import View.Components.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BoardView extends JFrame implements BoardObserver {
    private final JPanel jp_contentPane;
    private JPanel jp_grid;
    public static JPanel jp_buttonsSouth;
    public static JPanel jp_buttonsNorth;
    private final BoardController controller;

    public BoardView(BoardController controller) throws Exception {

        this.controller = controller;
        this.controller.attach(this);

        jp_contentPane = new JPanel();
        jp_contentPane.setBackground(Color.black);
        setSize(new Dimension(800,800));
        BorderLayout layout = new BorderLayout();
        jp_contentPane.setLayout(layout);
        setContentPane(jp_contentPane);
        setTitle("Robo Attack");
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
        for (int key = 0; key < board.size(); key++) {
            JPanel panel = new JPanel(new BorderLayout());
            ImagePanel terrain = new ImagePanel(board.get(key).getDraw());
            //panel.add(terrain, BorderLayout.CENTER, 0);
            int finalKey = key;
            terrain.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e){

                    String[] temp = (Integer.toString(finalKey, 8) + "").split("");
                    int[] cords;
                    if (temp.length == 1){
                        cords = new int[]{0, Integer.parseInt(temp[0])};
                    }else{
                        cords = new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
                    }
                    try {
                        controller.terrainClicked(cords);
                    } catch (Exception ignored) {
                    }
                }
            });
            jp_grid.add(terrain);
        }
    }

    public void redraw(ArrayList<Terrain> board){
        int index = 0;
        for (Component component: jp_grid.getComponents()
        ) {
            //JPanel father = (JPanel) component;
            ImagePanel panel = (ImagePanel) component;
            panel.setBuffer(board.get(index).getDraw());
            index++;
        }
        this.repaint();
    }

    private void loadScreen() throws Exception {
        loadGrid();
        loadButtons();
    }

    private void loadButtons(){

        // Define a cor e as ações do jogador 1

        jp_buttonsSouth = new JPanel();
        jp_buttonsSouth.setBackground(Color.BLUE);

        buildActions(jp_buttonsSouth);
        jp_contentPane.add(BorderLayout.SOUTH,jp_buttonsSouth);

        // Define a cor e as ações do jogador 2

        jp_buttonsNorth = new JPanel();
        jp_buttonsNorth.setBackground(Color.RED);

        buildActions(jp_buttonsNorth);

        jp_contentPane.add(BorderLayout.NORTH,jp_buttonsNorth);
    }

    private void buildActions(JPanel jp_buttons) {
        jp_buttons.add(new JButton("Mover Peça"), Action.MOVE);
        jp_buttons.add(new JButton("Iniciar Ataque"), Action.ATTACK);
        jp_buttons.add(new JButton("Sobrecarregar"), Action.OVERCHARGE);
        jp_buttons.add(new JButton("Ataque Especial"), Action.SPECIAL_ATTACK);
        jp_buttons.add(new JButton("Girar"), Action.SPIN);
        jp_buttons.add(new JRadioButton("Ataque Armado"), Action.ARMED_ATTACK);
        jp_buttons.add(new JButton("Cancelar Ação"), Action.CANCEL);
        addButtonActions(jp_buttons);
        toggleAllButtons(jp_buttons, false);
    }

    private void addButtonActions(JPanel jp_buttons){
        jp_buttons.getComponent(Action.MOVE.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                controller.add(new Move(controller));
            }
        });
        jp_buttons.getComponent(Action.ATTACK.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){

            }
        });
        jp_buttons.getComponent(Action.OVERCHARGE.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){

            }
        });
        jp_buttons.getComponent(Action.SPECIAL_ATTACK.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){

            }
        });
        jp_buttons.getComponent(Action.SPIN.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){

            }
        });
        jp_buttons.getComponent(Action.CANCEL.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                controller.releasePiece();
                toggleAllButtons(jp_buttons, false);
            }
        });
    }

    private void toggleAllButtons(JPanel jp_buttons, boolean enabled){
        toggleAction(jp_buttons, enabled, Action.MOVE);
        toggleAction(jp_buttons, enabled, Action.OVERCHARGE);
        toggleAction(jp_buttons, enabled, Action.ATTACK);
        toggleAction(jp_buttons, enabled, Action.ARMED_ATTACK);
        toggleAction(jp_buttons, enabled, Action.SPECIAL_ATTACK);
        toggleAction(jp_buttons, enabled, Action.SPIN);
        toggleAction(jp_buttons, enabled, Action.CANCEL);
    }

    public void toggleAction(JPanel jp_buttons ,boolean enable, Action action){
        jp_buttons.getComponent(action.getIndex()).setEnabled(enable);
    }

}
