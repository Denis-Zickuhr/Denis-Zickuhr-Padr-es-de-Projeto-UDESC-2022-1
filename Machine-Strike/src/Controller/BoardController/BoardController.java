package Controller.BoardController;

import Controller.BoardController.Command.AbstractCommandoBuilder;
import Controller.BoardController.Command.CommandFactory.AbstractCommandoFactory;
import Controller.BoardController.Command.CommandInvoker;
import Controller.BoardController.State.BoardControllerState;
import Controller.BoardController.State.BoardControllerWaitingPieceState;
import Controller.BoardController.Visitor.ApplyTerrainEffectMachineVisitor;
import Controller.BoardController.Visitor.UnalteredMachineVisitor;
import Model.AbstractModel.Machine;
import Model.ConcreteModel.Board;
import Model.ConcreteModel.Player;
import Model.ConcreteModel.Terrain;
import View.Action;
import View.Views.BoardView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardController{

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
    private static AbstractCommandoBuilder commandoBuilder;

    public Player getTurn() {
        return turn;
    }

    public void toggleTurn() {
        if(Board.getPlayer1().isBlocked() & getTurn() == Board.getPlayer1()){
                Board.getPlayer2().reset();
                this.turn = Board.getPlayer2();
            System.out.println("Player 2");
        }
        if(Board.getPlayer2().isBlocked() & getTurn() == Board.getPlayer2()){
            Board.getPlayer1().reset();
            this.turn = Board.getPlayer1();
            System.out.println("Player 1");
        }
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

    public void releasePiece() {
        this.setState(new BoardControllerWaitingPieceState());
        this.terrain = null;
    }

    public boolean machineSelected() {
        return terrain.getMachine() != null;
    }

    public void swapPiece(int[] cordsOrigin, int[] cordsDestiny, boolean execute) throws Exception {

        if (board.getTerrain(cordsDestiny).getMachine() == null){
            Machine tempMachine = board.getTerrain(cordsOrigin).getMachine();
            if(execute)
                board.getTerrain(cordsOrigin).getMachine().blockMovements();
            else
                board.getTerrain(cordsOrigin).getMachine().resetMovements();
            board.getTerrain(cordsOrigin).removeMachine();
            board.getTerrain(cordsDestiny).addMachine(tempMachine);
            releasePiece();

        }

        redraw();
        toggleTurn();

    }

    public void attackMachine(int[] attacker, int[] defender, int vertex) throws Exception {
        System.out.println("comecei de atacar");

        if(vertex > 0) {
            board.getTerrain(attacker).getMachine().blockAttacks();
        }
        else {
            board.getTerrain(attacker).getMachine().resetAttacks();
        }

        if(board.getTerrain(defender).getMachine() == null){
            System.out.println("errei");
        }else{
            board.getTerrain(attacker).accept(applyTerrainEffectMachineVisitor);
            int damage = applyTerrainEffectMachineVisitor.getMachine().getAttackPoints() * vertex;
            board.getTerrain(defender).accept(unalteredMachineVisitor);
            board.getTerrain(defender).getMachine().setHealth(unalteredMachineVisitor.getMachineList().getHealth() - damage);
            System.out.println("terminei de atacar");
        }

        redraw();
        toggleTurn();
        toggleButtons();

    }

    public void attackFromDistanceMachine(int[] attacker, int[] defender, int vertex) throws Exception {

        System.out.println("comecei de atirar");

        int distance = Math.max(Math.abs(attacker[0] - defender[0]), Math.abs(attacker[1] - defender[1]));

        if(board.getTerrain(defender).getMachine() == null){
            System.out.println("errei");
        }else{
            board.getTerrain(attacker).accept(applyTerrainEffectMachineVisitor);
            int partialDamage = Math.max((applyTerrainEffectMachineVisitor.getMachine().getAttackPoints() - distance), 0);
            int damage = partialDamage * vertex;
            if(vertex > 0){
                board.getTerrain(attacker).getMachine().shoot();
            }else{
                board.getTerrain(attacker).getMachine().reload();
            }
            board.getTerrain(defender).accept(unalteredMachineVisitor);
            System.out.println(formatCords(defender));
            board.getTerrain(defender).getMachine().setHealth(unalteredMachineVisitor.getMachineList().getHealth() - damage);
            System.out.println("terminei de atacar");
        }

        redraw();
        toggleTurn();
        toggleButtons();

    }

    public void overCharge(int[] origin, int vertex) throws Exception {
        board.getTerrain(origin).accept(unalteredMachineVisitor);
        board.getTerrain(origin).getMachine().setHealth(unalteredMachineVisitor.getMachineList().getHealth()-(vertex*2));

        if(vertex > 0) {
            board.getTerrain(origin).getMachine().reset();
            board.getTerrain(origin).getMachine().setOvercharged(true);
        }
        else {
            board.getTerrain(origin).getMachine().block();
            board.getTerrain(origin).getMachine().setOvercharged(false);
        }
        releasePiece();
        redraw();
        toggleButtons();
    }

    public void specialMove(int[] origin, boolean reverse) throws Exception {
        board.getTerrain(origin).getMachine().getAdapter().specialAttack(reverse);
    }

    public void prepareCommand(AbstractCommandoFactory<?> factory) throws Exception {

        commandoBuilder = factory.createCommandBuilder();
        commandoBuilder.reset();
        commandoBuilder.addOrigin(getTerrain().getCords());
        if(commandoBuilder.isExecutable()){
            CommandInvoker.getCommandInvoker().add(commandoBuilder.build());
            CommandInvoker.getCommandInvoker().execute();
            releasePiece();
            redraw();
        }
    }

    public static AbstractCommandoBuilder getCommandoBuilder() {
        return commandoBuilder;
    }

    public void toggleButtons() throws Exception {
        Player player = BoardController.getInstance().getTurn();

        if(getTerrain() != null){
            getTerrain().accept(unalteredMachineVisitor);

            for (BoardObserver obs: observer
            ) {
                obs.toggleAction(player, unalteredMachineVisitor.getMachineAbilities().canMove(), Action.MOVE);
                obs.toggleAction(player, unalteredMachineVisitor.getMachineAbilities().canAttack(), Action.ATTACK);
                obs.toggleAction(player, unalteredMachineVisitor.getMachineAbilities().canSpecialAttack(), Action.SPECIAL_MOVE);
                obs.toggleAction(player, unalteredMachineVisitor.getMachineAbilities().canCancel(), Action.CANCEL);
                obs.toggleAction(player, unalteredMachineVisitor.getMachineAbilities().canOvercharge(), Action.OVERCHARGE);
                obs.toggleAction(player, unalteredMachineVisitor.getMachineAbilities().canLongRange(), Action.ARMED_ATTACK);
            }
        }else{
            for (BoardObserver obs: observer
            ) {
                obs.disableAllButtons();
            }
        }
    }

    public void disableAllButtons() throws Exception {
        for (BoardObserver obs: observer
        ) {
            obs.disableAllButtons();
        }
    }


    public void redraw(){
        for (BoardObserver obs: observer
        ) {
            obs.redraw(BoardController.getInstance().getBoard().getTerrains());
        }
    }

    public void terrainClicked(int[] cords) throws Exception {
        state.terrainClicked(cords);
        for (BoardObserver obs: observer
        ) {
            obs.redraw(board.getTerrains());
        }
    }

    public int formatCords(int[] cords){
        return Integer.parseInt(Integer.toString(Integer.parseInt(Arrays.toString(cords).replaceAll(" ", "").
                replaceAll("\\[", "").
                replaceAll("\\]", "").
                replaceAll(",", ""), 8), 10));
    }


}
