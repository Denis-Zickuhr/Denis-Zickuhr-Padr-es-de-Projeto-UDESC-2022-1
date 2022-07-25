package Controller.BoardController;

import Controller.MachineSelection.MachineSelectionObserver;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import View.BoardView;

import java.util.ArrayList;
import java.util.List;

public class BoardController{
    /**
     * Constructs a new object.
     */
    public BoardController() {
    }

    private final List<BoardObserver> observer = new ArrayList<>();
    public void attach(BoardObserver observer){
        this.observer.add(observer);
    }

    private List<Machine> pieceSetAlpha;
    private List<Machine> pieceSetBeta;
    private final List<Machine> temporaryPieceSet = new ArrayList<>();
    private boolean ready = false;
    private boolean running = false;

    public List<Machine> getPieceSetAlpha() {
        return pieceSetAlpha;
    }
    public List<Machine> getPieceSetBeta() {
        return pieceSetBeta;
    }

    public void addPiece(Machine machine){
        temporaryPieceSet.add(machine);
    }

    public void confirmSet(){
        if(ready){
            startGame();
        }else {
            pieceSetAlpha = new ArrayList<>(temporaryPieceSet);
            temporaryPieceSet.clear();
            ready = true;
        }
    }

    public void startGame(){
        pieceSetBeta = new ArrayList<>(temporaryPieceSet);
        temporaryPieceSet.clear();
        new BoardView(this).setVisible(true);
        running = true;
        System.out.println(pieceSetAlpha.toString());
        System.out.println(pieceSetBeta.toString());
    }

    public boolean gameRunning(){
        return running;
    }


}
