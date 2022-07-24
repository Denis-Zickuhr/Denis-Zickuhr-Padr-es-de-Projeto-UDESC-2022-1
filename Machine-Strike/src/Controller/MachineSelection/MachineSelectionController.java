package Controller.MachineSelection;

import Controller.Factory.AbstractMachineFactory;
import Controller.Factory.ConcreteMachineFactory;
import Controller.Factory.ConcreteRadioactiveMachineFactory;
import Controller.MachineSelection.State.MachineSelectionKingState;
import Controller.MachineSelection.State.MachineSelectionState;
import View.MachineSelectionView;

import java.util.ArrayList;
import java.util.List;

public class MachineSelectionController{

    private final List<MachineSelectionObserver> observer = new ArrayList<>();
    private final List<AbstractMachineFactory> factories = new ArrayList<>();
    private MachineSelectionState state = new MachineSelectionKingState(this);

    public MachineSelectionState getState() {
        return state;
    }

    public void setState(MachineSelectionState state) {
        this.state = state;
    }

    public void attach(MachineSelectionObserver observer){
        this.observer.add(observer);
    }

    public MachineSelectionController() throws Exception {
        MachineSelectionView cl = new MachineSelectionView(this);
    }

    public void prevMachine() {
        state.prevMachine();
        for (MachineSelectionObserver obs : observer) {
            obs.prevMachineClicked();
        }
    }
    public void nextMachine() throws Exception {
        state.nextMachine();
        for (MachineSelectionObserver obs : observer) {
            obs.nextMachineClicked();
        }
    }
    public void newMachine() {
        for (MachineSelectionObserver obs : observer) {
            obs.nextMachineClicked();
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

    public static void main(String[] args) throws Exception {
        MachineSelectionController msc = new MachineSelectionController();
    }

}


