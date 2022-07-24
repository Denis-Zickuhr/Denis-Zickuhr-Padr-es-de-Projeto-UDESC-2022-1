package Controller.MachineSelection.State;

import Controller.Factory.AbstractMachineFactory;
import Controller.Factory.ConcreteMachineFactory;
import Controller.Factory.ConcreteRadioactiveMachineFactory;
import Controller.MachineSelection.MachineSelectionController;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public class MachineSelectionKingState extends MachineSelectionState {

    public MachineSelectionKingState(MachineSelectionController controller) {
        super(controller);
    }

    public MachineSelectionKingState(MachineSelectionController controller, AbstractMachineFactory factory) {
        super(controller, factory);
    }

    public void prevMachine(){
        controller.setState(new MachineSelectionSoldierState(getController(), this.factory));
    };

    public void nextMachine(){
        controller.setState(new MachineSelectionQueenState(getController(), this.factory));
    };

    public Machine selectMachine() throws Exception {
        return factory.createKingMachine();
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
