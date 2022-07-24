package Controller.MachineSelection.State;

import Controller.Factory.AbstractMachineFactory;
import Controller.Factory.ConcreteMachineFactory;
import Controller.Factory.ConcreteRadioactiveMachineFactory;
import Controller.MachineSelection.MachineSelectionController;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public class MachineSelectionSoldierState extends MachineSelectionState {

    public MachineSelectionSoldierState(MachineSelectionController controller) {
        super(controller);
    }

    public MachineSelectionSoldierState(MachineSelectionController controller, AbstractMachineFactory factory) {
        super(controller, factory);
    }

    public void prevMachine(){
        controller.setState(new MachineSelectionBeastState(getController(), this.factory));
    };

    public void nextMachine(){
        controller.setState(new MachineSelectionKingState(getController(), this.factory));
    };

    public Machine selectMachine() throws Exception {
        return factory.createSoldierMachine();
    }

    @Override
    public void changeFactory(boolean selected) {
        if(selected){
            this.factory = new ConcreteRadioactiveMachineFactory();
        }else{
            this.factory = new ConcreteMachineFactory();
        }
    }
}
