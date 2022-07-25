package Controller.MachineSelection;

import Controller.BoardController.BoardController;
import Controller.MachineSelection.State.MachineSelectionKingState;
import Controller.MachineSelection.State.MachineSelectionSoldierState;
import Controller.MachineSelection.State.MachineSelectionState;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.ConcreteModel.ConcreteMachine.ConcreteStrategy.*;
import View.MachineSelectionView;

import java.util.ArrayList;
import java.util.List;

public class MachineSelectionController{

    BoardController boardController = new BoardController();

    public MachineSelectionController() throws Exception {
        new MachineSelectionView(this);
        for (MachineSelectionObserver obs : observer) {
            obs.drawMachine(state.selectMachine());
            obs.enableComboBox(false);
            for (AbstractStrategy s: getStrategies()
            ) {
                obs.addPieceStrategy(s);
            }
            getState().setStrategy(obs.getStrategy());
        }
    }

    /*

        State

     */

    private MachineSelectionState state = new MachineSelectionKingState(this);
    public MachineSelectionState getState() {
        return this.state;
    }
    public void setState(MachineSelectionState state) {
        this.state = state;
    }


    /*

        Observer

     */

    private final List<MachineSelectionObserver> observer = new ArrayList<>();
    public void attach(MachineSelectionObserver observer){
        this.observer.add(observer);
    }
    public void prevMachine() throws Exception {
        state.prevMachine();
        for (MachineSelectionObserver obs : observer) {
            obs.drawMachine(state.selectMachine());
            obs.enableComboBox(comboBoxVisible());
        }
    }
    public void nextMachine() throws Exception {
        state.nextMachine();
        for (MachineSelectionObserver obs : observer) {
            obs.drawMachine(state.selectMachine());
            obs.enableComboBox(comboBoxVisible());
        }
    }
    public void changeStrategy() throws Exception {
        for (MachineSelectionObserver obs : observer) {
            getState().setStrategy(obs.getStrategy());
            obs.drawMachine(state.selectMachine());
        }
    }
    public void selectMachine() throws Exception {
        boardController.addPiece(state.selectMachine());
    }

    public void confirmePlayerSet(){
        boardController.confirmSet();
        if(boardController.gameRunning()){
            for (MachineSelectionObserver obs: observer
            ) {
                obs.dispose();
            }
        }
    }

    public void toggleRadMachine(boolean selected) throws Exception {
        state.changeFactory(selected);
        for (MachineSelectionObserver obs : observer) {
            obs.drawMachine(state.selectMachine());
        }
    }
    public boolean comboBoxVisible(){
        return getState().getClass() == MachineSelectionSoldierState.class;
    }

    /*

    Strategies

     */

    public static AbstractStrategy[] getStrategies(){
        AbstractStrategy[] st = new AbstractStrategy[10];
        st[0] = new BlackStrategy();
        st[1] = new WhiteStrategy();
        st[2] = new RedStrategy();
        st[3] = new BlueStrategy();
        st[4] = new GreenStrategy();
        st[5] = new CyanStrategy();
        st[6] = new YellowStrategy();
        st[7] = new MagentaStrategy();
        st[8] = new PinkStrategy();
        st[9] = new PhantomStrategy();

        return st;
    }

}


