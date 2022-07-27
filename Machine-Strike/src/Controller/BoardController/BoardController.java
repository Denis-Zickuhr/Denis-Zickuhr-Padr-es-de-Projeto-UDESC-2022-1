package Controller.BoardController;

import Controller.BoardController.Command.CommandInvoker;
import Controller.BoardController.State.BoardControllerState;
import Controller.BoardController.State.BoardControllerWaitingPieceState;
import Controller.BoardController.Visitor.ApplyOvechargeMachineVisitor;
import Controller.BoardController.Visitor.ApplyTerrainEffectMachineVisitor;
import Controller.BoardController.Visitor.UnalteredMachineVisitor;
import Model.AbstractModel.AbstractMachine.Machine;
import Model.Board;
import Model.Player;
import Model.Terrain.Terrain;
import View.Action;
import View.BoardView;

import java.util.ArrayList;
import java.util.List;

public class BoardController extends CommandInvoker{

    private static BoardController instance;
    public static BoardController getInstance(){
        if(instance == null){
            instance = new BoardController();
        }
        return instance;
    }

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
    private boolean player1Ready = false;
    private boolean running = false;
    private BoardControllerState state = new BoardControllerWaitingPieceState(this);
    private final ApplyTerrainEffectMachineVisitor applyTerrainEffectMachineVisitor = new ApplyTerrainEffectMachineVisitor();
    private final UnalteredMachineVisitor unalteredMachineVisitor = new UnalteredMachineVisitor();
    private final ApplyOvechargeMachineVisitor applyOvechargeMachineVisitor = new ApplyOvechargeMachineVisitor();


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
        board.addPlayerMachine(player1Ready, machine);
    }

    public void confirmSet() throws Exception {
        if(player1Ready){
            startGame();
        }else {
            player1Ready = true;
        }
    }

    public void startGame() throws Exception {
        board.assembleBoard();
        new BoardView();
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
        if (board.getTerrain(cordsDestiny).getMachine() == null){
            Machine tempMachine = board.getTerrain(cordsOrigin).getMachine();
            getTerrain().removeMachine();
            board.getTerrain(cordsDestiny).addMachine(tempMachine);
        }
        redraw();
    }

    public void attackMachine(int[] attacker, int[] defender, int vertex) throws Exception {
        board.getTerrain(attacker).accept(applyTerrainEffectMachineVisitor);
        board.getTerrain(defender).accept(unalteredMachineVisitor);
        System.out.println(applyTerrainEffectMachineVisitor.getMachine().getHealth());
        System.out.println(unalteredMachineVisitor.getMachine().getHealth());
        System.out.println(Board.getPlayer1().getMachines().toString());
        int damage = applyTerrainEffectMachineVisitor.getMachine().getAttackPoints() * vertex;
        board.getTerrain(defender).getMachine().setHealth(unalteredMachineVisitor.getMachine().getHealth() - damage);
        System.out.println(applyTerrainEffectMachineVisitor.getMachine().getHealth());
        System.out.println(board.getTerrain(defender).getMachine().getHealth());
        System.out.println(Board.getPlayer1().getMachines().toString());
    }

    public boolean overCharge(int[] attacker) throws Exception {
        board.getTerrain(attacker).accept(applyOvechargeMachineVisitor);
        applyTerrainEffectMachineVisitor.getMachine();
        return true;
    }

    public boolean specialAttack() throws Exception {
        getTerrain().getMachine().getAdapter().specialAttack();
        return false;
    }

    public void toggleButton(){
        for (BoardObserver obs: observer
             ) {
             obs.toggleAction(BoardView.player2Input, true, Action.ATTACK);
            obs.toggleAction(BoardView.player2Input, true, Action.MOVE);
        }
    }

    public void redraw(){
        for (BoardObserver obs: observer
        ) {
            obs.redraw(this.board.getTerrains());
        }
    }


}
