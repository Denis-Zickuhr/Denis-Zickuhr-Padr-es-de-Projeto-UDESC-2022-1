package Controller.BoardController;

import Controller.MachineSelection.MachineSelectionObserver;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.BaseEntity;
import Model.BoardEntity;
import Model.Terrain.Terrain;
import View.BoardView;

import java.util.ArrayList;
import java.util.List;

public class BoardController{
    /**
     * Constructs a new object.
     */
    public BoardController() {
        board = new BoardEntity();
    }

    private final List<BoardObserver> observer = new ArrayList<>();
    public void attach(BoardObserver observer){
        this.observer.add(observer);
    }

    BoardEntity board;
    private boolean ready = false;
    private boolean running = false;

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
        board.build();
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

}
