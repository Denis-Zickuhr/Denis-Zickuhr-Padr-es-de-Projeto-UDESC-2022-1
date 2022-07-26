package Controller.BoardController;

import Controller.BoardController.Command.CommandInvoker;
import Controller.BoardController.Command.Commando;
import Controller.BoardController.State.BoardControllerState;
import Controller.BoardController.State.BoardControllerWaitingPieceState;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.Board;
import Model.Terrain.Terrain;
import View.Action;
import View.BoardView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BoardController extends CommandInvoker{


    /**
     * Constructs a new object.
     */
    public BoardController() {
        board = new Board();
    }

    private final List<BoardObserver> observer = new ArrayList<>();
    public void attach(BoardObserver observer){
        this.observer.add(observer);
    }

    Board board;
    Terrain terrain;
    private boolean ready = false;
    private boolean running = false;
    private BoardControllerState state = new BoardControllerWaitingPieceState(this);

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Board getBoard() {
        return board;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void addPiece(Machine machine){
        board.AddToTemporaryPieceSet(machine);
    }

    public void confirmSet() throws Exception {
        if(ready){
            startGame();
        }else {
            board.setPieceSetAlpha(new ArrayList<>(board.getTemporaryPieceSet()));
            board.clearTemporaryPieceSet();
            ready = true;
        }
    }

    public void startGame() throws Exception {
        board.setPieceSetBeta(new ArrayList<>(board.getTemporaryPieceSet()));
        board.clearTemporaryPieceSet();
        board.assembleBoard();
        new BoardView(this);
        for (BoardObserver obs: observer
             ) {
            obs.draw(board.getTerrains());
        }
        running = true;
    }

    public boolean gameRunning(){
        return running;
    }

    public void setState(BoardControllerState state) {
        this.state = state;
    }

    public void terrainClicked(int[] cords) throws Exception {
        state.terrainClicked(cords);
        for (BoardObserver obs: observer
        ) {
            obs.redraw(board.getTerrains());
        }
    }

    public void releasePiece() {
        this.terrain = null;
    }

    public boolean machineSelected() {
        return terrain.getMachine() != null;
    }

    public void swapPiece(int[] cordsOrigin, int[] cordsDestiny) throws Exception {
        System.out.println("tentei trocar");
        if (board.getTerrain(cordsDestiny).getMachine() == null){
            Machine tempMachine = board.getTerrain(cordsOrigin).getMachine();
            getTerrain().removeMachine();
            board.getTerrain(cordsDestiny).addMachine(tempMachine);
        }
        redraw();
    }

    public boolean attackMachine(Machine machine){
        int damage = getTerrain().getMachine().getAttackPoints() + getTerrain().getTerrainType().value();
        machine.setHealth(machine.getHealth() - damage);
        return true;
    }

    public boolean overCharge(){
        return true;
    }

    public boolean specialAttack() throws Exception {
        getTerrain().getMachine().getAdapter().specialAttack();
        return false;
    }

    public void toggleButton(){
        for (BoardObserver obs: observer
             ) {
             obs.toggleAction(BoardView.jp_buttonsNorth, true, Action.MOVE);
        }
    }

    public void redraw(){
        for (BoardObserver obs: observer
        ) {
            obs.redraw(this.board.getTerrains());
        }
    }


}
