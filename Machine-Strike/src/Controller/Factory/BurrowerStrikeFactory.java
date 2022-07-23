package Controller.Factory;

import Model.AbstractModel.MachineEntity;
import Model.AbstractModel.MachineRadioactiveEntity;
import Model.ConcreteModel.ConcreteMachine.BurrowerStrike;
import Model.ConcreteModel.ConcreteMachine.RadioactiveBurrowerStrike;

public class BurrowerStrikeFactory implements AbstractMachineFactory{
    @Override
    public MachineEntity createMachine() {
        return new BurrowerStrike();
    }

    @Override
    public MachineRadioactiveEntity createRadioactiveMachine() {
        return new RadioactiveBurrowerStrike();
    }
}
