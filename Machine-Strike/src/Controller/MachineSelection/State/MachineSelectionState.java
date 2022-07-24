package Controller.MachineSelection.State;

import Controller.Factory.AbstractMachineFactory;
import Controller.Factory.ConcreteMachineFactory;
import Controller.Factory.ConcreteRadioactiveMachineFactory;
import Controller.MachineSelection.MachineSelectionController;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public abstract class MachineSelectionState {

    protected final MachineSelectionController controller;
    protected AbstractMachineFactory factory;

    // Construtor do estado inicial
    public MachineSelectionState(MachineSelectionController controller) {
        this.controller = controller;
        factory = new ConcreteMachineFactory();
    }

    public MachineSelectionState(MachineSelectionController controller, AbstractMachineFactory factory) {
        this.controller = controller;
        this.factory = factory;
    }

    public MachineSelectionController getController() {
        return controller;
    }

    public abstract void prevMachine();
    public abstract void nextMachine();
    public abstract Machine selectMachine() throws Exception;
    public abstract void changeFactory(boolean selected);

}
