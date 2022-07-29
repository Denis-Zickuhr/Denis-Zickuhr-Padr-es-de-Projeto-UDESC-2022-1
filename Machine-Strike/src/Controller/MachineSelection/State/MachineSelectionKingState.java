package Controller.MachineSelection.State;

import Controller.MachineSelection.Factory.AbstractMachineFactory;
import Controller.MachineSelection.Factory.ConcreteMachineFactory;
import Controller.MachineSelection.Factory.ConcreteArmedMachineFactory;
import Controller.MachineSelection.MachineSelectionController;
import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.Machine;

public class MachineSelectionKingState extends MachineSelectionState {

    public MachineSelectionKingState(MachineSelectionController controller) {
        super(controller);
    }

    public MachineSelectionKingState(MachineSelectionController controller, AbstractMachineFactory factory, AbstractStrategy strategy) {
        super(controller, factory, strategy);
    }

    public void prevMachine(){
        controller.setState(new MachineSelectionSoldierState(getController(), this.factory, this.strategy));
    };

    public void nextMachine(){
        controller.setState(new MachineSelectionQueenState(getController(), this.factory, this.strategy));
    };

    public Machine selectMachine() throws Exception {
        return factory.createKingMachine();
    }

    @Override
    public void changeFactory(boolean selected) {
        if(selected){
            this.factory = new ConcreteArmedMachineFactory();
        }else{
            this.factory = new ConcreteMachineFactory();
        }
    }
}
