package Controller.MachineSelection.State;

import Controller.MachineSelection.Factory.AbstractMachineFactory;
import Controller.MachineSelection.Factory.ConcreteMachineFactory;
import Controller.MachineSelection.MachineSelectionController;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public abstract class MachineSelectionState {

    protected final MachineSelectionController controller;
    protected AbstractMachineFactory factory;
    AbstractStrategy strategy;

    public AbstractStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    // Construtor do estado inicial
    public MachineSelectionState(MachineSelectionController controller) {
        this.controller = controller;
        factory = new ConcreteMachineFactory();
    }

    public MachineSelectionState(MachineSelectionController controller, AbstractMachineFactory factory, AbstractStrategy strategy) {
        this.controller = controller;
        this.factory = factory;
        this.strategy = strategy;
    }

    public MachineSelectionController getController() {
        return controller;
    }

    public abstract void prevMachine();
    public abstract void nextMachine();
    public abstract Machine selectMachine() throws Exception;
    public abstract void changeFactory(boolean selected);

}
