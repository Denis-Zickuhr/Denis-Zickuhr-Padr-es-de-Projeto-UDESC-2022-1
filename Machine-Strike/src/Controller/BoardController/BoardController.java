package Controller.BoardController;

import Controller.BoardController.Command.CommandInvoker;
import Controller.BoardController.State.BoardControllerState;
import Controller.BoardController.State.BoardControllerWaitingPieceState;
import Controller.BoardController.Visitor.ApplyTerrainEffectMachineVisitor;
import Controller.BoardController.Visitor.UnalteredMachineVisitor;
import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineKingEntity;
import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineQueenEntity;
import Model.AbstractModel.AbstractMachine.Machine;
import Model.Board;
import Model.ConcreteModel.ConcreteMachine.Armed.KingArmedMachine;
import Model.ConcreteModel.ConcreteMachine.Basic.KingMachine;
import Model.ConcreteModel.ConcreteMachine.Basic.QueenMachine;
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
    private Player turn = Board.getPlayer2();
    private BoardControllerState state = new BoardControllerWaitingPieceState();
    private final ApplyTerrainEffectMachineVisitor applyTerrainEffectMachineVisitor = new ApplyTerrainEffectMachineVisitor();
    private final UnalteredMachineVisitor unalteredMachineVisitor = new UnalteredMachineVisitor();

    public Player getTurn() {
        return turn;
    }

    public void toggleTurn() {
        if(Board.getPlayer1().isBlocked() & getTurn() == Board.getPlayer1()){
                Board.getPlayer2().reset();
                this.turn = Board.getPlayer2();
        }
        if(Board.getPlayer2().isBlocked() & getTurn() == Board.getPlayer2()){
            Board.getPlayer1().reset();
            this.turn = Board.getPlayer1();
        }
        System.out.println(this.turn.toString());
    }

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

    public void swapPiece(int[] cordsOrigin, int[] cordsDestiny, boolean execute) throws Exception {
        if (board.getTerrain(cordsDestiny).getMachine() == null){
            Machine tempMachine = board.getTerrain(cordsOrigin).getMachine();
            if(execute)
                tempMachine.blockMovements();
            else
                tempMachine.resetMovements();
            getTerrain().removeMachine();
            BoardController.getInstance().setTerrain(board.getTerrain(cordsOrigin));
            board.getTerrain(cordsDestiny).addMachine(tempMachine);
        }
        redraw();
        toggleTurn();
        toggleButtons();
    }

    public void attackMachine(int[] attacker, int[] defender, int vertex) throws Exception {
        board.getTerrain(attacker).accept(applyTerrainEffectMachineVisitor);
        board.getTerrain(defender).accept(unalteredMachineVisitor);
        if(vertex > 0)
            board.getTerrain(attacker).getMachine().blockAttacks();
        else
            board.getTerrain(attacker).getMachine().resetAttacks();
        int damage = applyTerrainEffectMachineVisitor.getMachine().getAttackPoints() * vertex;
        board.getTerrain(defender).getMachine().setHealth(unalteredMachineVisitor.getMachine().getHealth() - damage);
        toggleTurn();
        toggleButtons();
    }

    public void overCharge(int[] attacker, int vertex) throws Exception {
        board.getTerrain(attacker).accept(unalteredMachineVisitor);
        getTerrain().getMachine().setHealth(unalteredMachineVisitor.getMachine().getAttackPoints()-(vertex*2));
        if(vertex > 0)
            getTerrain().getMachine().reset();
        else
            getTerrain().getMachine().block();
    }

    public boolean specialAttack() throws Exception {
        getTerrain().getMachine().getAdapter().specialAttack();
        return false;
    }

    public void toggleButtons(){
        for (BoardObserver obs: observer
             ) {

            if(BoardController.getInstance().getTerrain().getMachine().getMoveSpan() > 0 & BoardController.getInstance().getTerrain().getMachine().getMovements() > 0)
                obs.toggleAction(BoardController.getInstance().getTurn(), true, Action.MOVE);
            else
                obs.toggleAction(BoardController.getInstance().getTurn(), false, Action.MOVE);

            if (BoardController.getInstance().getTerrain().getMachine().getAttacks() > 0)
                obs.toggleAction(BoardController.getInstance().getTurn(), true, Action.ATTACK);
            else
                obs.toggleAction(BoardController.getInstance().getTurn(), false, Action.ATTACK);

            if (BoardController.getInstance().getTerrain().getMachine().getClass() == KingMachine.class
                    || BoardController.getInstance().getTerrain().getMachine().getClass() == QueenMachine.class
                    || BoardController.getInstance().getTerrain().getMachine().getClass() == KingArmedMachine.class)
                obs.toggleAction(BoardController.getInstance().getTurn(), true, Action.SPECIAL_ATTACK);
            else
                obs.toggleAction(BoardController.getInstance().getTurn(), false, Action.SPECIAL_ATTACK);

            if (BoardController.getInstance().getTerrain().getMachine() != null)
                obs.toggleAction(BoardController.getInstance().getTurn(), true, Action.CANCEL);
            else
                obs.toggleAction(BoardController.getInstance().getTurn(), false, Action.CANCEL);

            if(BoardController.getInstance().getTerrain().getMachine().isBlocked())
                obs.toggleAction(BoardController.getInstance().getTurn(), true, Action.OVERCHARGE);
            else
                obs.toggleAction(BoardController.getInstance().getTurn(), false, Action.OVERCHARGE);
        }
    }

    public void redraw(){
        for (BoardObserver obs: observer
        ) {
            obs.redraw(this.board.getTerrains());
        }
    }


}
