package Controller.Factory;

import Model.AbstractModel.MachineEntity;
import Model.AbstractModel.MachineRadioactiveEntity;
import Model.ConcreteModel.ConcreteMachine.LeaplasherStrike;
import Model.ConcreteModel.ConcreteMachine.RadioactiveLeaplasherStrike;

public class LeaplasherStrikeFactory implements AbstractMachineFactory{
    @Override
    public MachineEntity createMachine() {
        return new LeaplasherStrike();
    }

    @Override
    public MachineRadioactiveEntity createRadioactiveMachine() {
        return new RadioactiveLeaplasherStrike();
    }
}
