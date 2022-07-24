package Controller.MachineSelection.State;

import Controller.Factory.AbstractMachineFactory;
import Controller.Factory.ConcreteMachineFactory;
import Controller.Factory.ConcreteRadioactiveMachineFactory;
import Controller.MachineSelection.MachineSelectionController;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public class MachineSelectionQueenState extends MachineSelectionState {


    public MachineSelectionQueenState(MachineSelectionController controller) {
        super(controller);
    }

    public MachineSelectionQueenState(MachineSelectionController controller, AbstractMachineFactory factory, AbstractStrategy strategy) {
        super(controller, factory, strategy);
    }

    public void prevMachine(){
        controller.setState(new MachineSelectionKingState(getController(), this.factory, this.strategy));
    };

    public void nextMachine(){
        controller.setState(new MachineSelectionBeastState(getController(), this.factory, this.strategy));;
    };

    public Machine selectMachine() throws Exception {
        return factory.createQueenMachine();
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
