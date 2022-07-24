package Controller.MachineSelection;

import Controller.Factory.AbstractMachineFactory;
import Controller.MachineSelection.State.MachineSelectionKingState;
import Controller.MachineSelection.State.MachineSelectionState;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.ConcreteModel.ConcreteMachine.ConcreteStrategy.BlackStrategy;
import Model.ConcreteModel.ConcreteMachine.ConcreteStrategy.WhiteStrategy;
import View.MachineSelectionView;

import java.util.ArrayList;
import java.util.List;

public class MachineSelectionController{

    private final List<MachineSelectionObserver> observer = new ArrayList<>();
    private final List<AbstractMachineFactory> factories = new ArrayList<>();
    private MachineSelectionState state = new MachineSelectionKingState(this);

    public MachineSelectionState getState() {
        return this.state;
    }
    public void setState(MachineSelectionState state) {
        this.state = state;
    }

    public void attach(MachineSelectionObserver observer){
        this.observer.add(observer);
    }
    public MachineSelectionController() throws Exception {
        MachineSelectionView cl = new MachineSelectionView(this);
        for (MachineSelectionObserver obs : observer) {
            obs.drawMachine(state.selectMachine());
            for (AbstractStrategy s: getStrategies()
                 ) {
                obs.addPieceStrategy(s);
            }
            getState().setStrategy(obs.getStrategy());
        }
    }

    public void prevMachine() throws Exception {
        state.prevMachine();
        for (MachineSelectionObserver obs : observer) {
            obs.drawMachine(state.selectMachine());
        }
    }
    public void nextMachine() throws Exception {
        state.nextMachine();
        for (MachineSelectionObserver obs : observer) {
            obs.drawMachine(state.selectMachine());
        }
    }
    public void newMachine() throws Exception {
        for (MachineSelectionObserver obs : observer) {
            obs.nextMachineClicked();
            getState().setStrategy(obs.getStrategy());
            obs.drawMachine(state.selectMachine());
        }
    }
    public void selectMachine() throws Exception {
        System.out.println(state.selectMachine().getClass());
        for (MachineSelectionObserver obs : observer) {
            obs.nextMachineClicked();
        }
    }
    public void toggleRadMachine(boolean selected) throws Exception {
        state.changeFactory(selected);
    }

    public static AbstractStrategy[] getStrategies(){
        AbstractStrategy[] st = new AbstractStrategy[2];
        st[0] = new BlackStrategy();
        st[1] = new WhiteStrategy();
        return st;
    }

    public static void main(String[] args) throws Exception {
        MachineSelectionController msc = new MachineSelectionController();
    }
}


