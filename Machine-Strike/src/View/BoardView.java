package View;

import Controller.BoardController.BoardController;
import Controller.BoardController.BoardObserver;
import Controller.BoardController.Command.CommandFactory.AttackCommandoFactory;
import Controller.BoardController.Command.CommandFactory.MoveCommandoFactory;
import Controller.BoardController.Command.CommandFactory.OverchargeCommandoFactory;
import Controller.BoardController.Command.Commands.Attack;
import Controller.BoardController.Command.Commands.Move;
import Controller.BoardController.Command.Commands.Overcharge;
import Model.AbstractModel.AbstractMachine.Machine;
import Model.Board;
import Model.Player;
import Model.Terrain.Terrain;
import View.Components.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class BoardView extends JFrame implements BoardObserver {
    private final JPanel jp_contentPane = new JPanel();;
    private JPanel jp_grid;
    public static JPanel player1Input;
    public static JPanel player2Input;

    public BoardView() throws Exception {

        BoardController controller = BoardController.getInstance();
        controller.attach(this);

        new PointCounterView();

        setBackground(Color.black);
        setSize(new Dimension(800,900));
        BorderLayout layout = new BorderLayout();
        jp_contentPane.setLayout(layout);
        setContentPane(jp_contentPane);
        setTitle("Robo Attack");
        setLocation(0,0);
        loadScreen();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void loadGrid() throws Exception {
        jp_grid = new JPanel(new GridLayout(8,8,2,2));
        jp_grid.setBackground(Color.black);
        jp_contentPane.add(BorderLayout.CENTER,jp_grid);
    }

    public void draw(ArrayList<Terrain> terrains){
        this.setVisible(true);
        for (int key = 0; key < terrains.size(); key++) {
            JPanel holder = new JPanel(new BorderLayout());
            ImagePanel terrain = new ImagePanel(terrains.get(key).getDraw());
            holder.add(terrain, BorderLayout.CENTER, 0);
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
                        BoardController.getInstance().terrainClicked(cords);
                    } catch (Exception ignored) {
                    }
                }
            });
            jp_grid.add(holder);
        }
        redraw(terrains);
    }

    public void redraw(ArrayList<Terrain> terrains){

        int index = 0;
        for (Component component: jp_grid.getComponents()
        ) {

            JPanel holder = (JPanel) component;

            ImagePanel panel = (ImagePanel) holder.getComponent(0);
            panel.setBuffer(terrains.get(index).getDraw());


            boolean selectedMachine = BoardController.getInstance().getTerrain() == terrains.get(index);
            if(selectedMachine){

                String[] highlightBuffer = new String[terrains.get(index).getDraw().length + 1];
                for (int i = 0; i < terrains.get(index).getDraw().length; i++) {
                    highlightBuffer[i] = terrains.get(index).getDraw()[i];
                }
                highlightBuffer[terrains.get(index).getDraw().length] = "Assets/selector.png";
                panel.setBuffer(highlightBuffer);
            }

            boolean containsMachine = terrains.get(index).getMachine() != null;

            if(holder.getComponents().length > 1)
                holder.remove(1);

            if(containsMachine){
                holder.add(new JLabel(terrains.get(index).getMachine().toString()), BorderLayout.SOUTH, 1);
            }

            holder.updateUI();
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

        player1Input = new JPanel();
        player1Input.setBackground(Color.BLUE);

        buildActions(player1Input);
        jp_contentPane.add(BorderLayout.NORTH, player1Input);

        // Define a cor e as ações do jogador 2

        player2Input = new JPanel();
        player2Input.setBackground(Color.RED);

        buildActions(player2Input);

        jp_contentPane.add(BorderLayout.SOUTH, player2Input);
    }

    private void buildActions(JPanel jp_buttons) {
        jp_buttons.add(new JButton("Mover Peça"), Action.MOVE);
        jp_buttons.add(new JButton("Iniciar Ataque"), Action.ATTACK);
        jp_buttons.add(new JButton("Sobrecarregar"), Action.OVERCHARGE);
        jp_buttons.add(new JButton("Ataque Especial"), Action.SPECIAL_ATTACK);
        jp_buttons.add(new JRadioButton("Ataque Armado"), Action.ARMED_ATTACK);
        jp_buttons.add(new JButton("Cancelar Ação"), Action.CANCEL);
        addButtonActions(jp_buttons);
        toggleAllButtons(jp_buttons, false);
    }

    private void addButtonActions(JPanel jp_buttons){
        jp_buttons.getComponent(Action.MOVE.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    BoardController.getInstance().prepareCommand(new MoveCommandoFactory());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jp_buttons.getComponent(Action.ATTACK.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                try {
                    BoardController.getInstance().prepareCommand(new AttackCommandoFactory());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jp_buttons.getComponent(Action.OVERCHARGE.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){

                try {
                    BoardController.getInstance().prepareCommand(new OverchargeCommandoFactory());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jp_buttons.getComponent(Action.SPECIAL_ATTACK.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                //BoardController.getInstance().prepareCommand(new ActionEvent(e.getSource(), command_id++, Action.SPECIAL_ATTACK.toString()));
            }
        });
        jp_buttons.getComponent(Action.CANCEL.getIndex()).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                BoardController.getInstance().releasePiece();
                toggleAllButtons(jp_buttons, false);
                redraw(BoardController.getInstance().getBoard().getTerrains());
            }
        });
    }

    private void toggleAllButtons(JPanel jp_buttons, boolean enabled){
        toggleAction(jp_buttons, enabled, Action.MOVE);
        toggleAction(jp_buttons, enabled, Action.OVERCHARGE);
        toggleAction(jp_buttons, enabled, Action.ATTACK);
        toggleAction(jp_buttons, enabled, Action.ARMED_ATTACK);
        toggleAction(jp_buttons, enabled, Action.SPECIAL_ATTACK);
        toggleAction(jp_buttons, enabled, Action.CANCEL);
    }

    public void toggleAction(JPanel jp_buttons ,boolean enable, Action action){
        jp_buttons.getComponent(action.getIndex()).setEnabled(enable);
    }

    @Override
    public void toggleAction(Player player , boolean enable, Action action){
        if(Board.getPlayer1() == player){
            player1Input.getComponent(action.getIndex()).setEnabled(enable);
        }else if(Board.getPlayer2() == player){
            player2Input.getComponent(action.getIndex()).setEnabled(enable);
        }
    }

    @Override
    public void disableAllButtons() {
        toggleAllButtons(player1Input, false);
        toggleAllButtons(player2Input, false);
    }

}
