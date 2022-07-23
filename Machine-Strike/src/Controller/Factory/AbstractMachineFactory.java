package Controller.Factory;

import Model.AbstractModel.MachineEntity;
import Model.AbstractModel.MachineRadioactiveEntity;
import Model.ConcreteModel.ConcreteMachine.BurrowerStrike;
import Model.ConcreteModel.ConcreteMachine.RadioactiveBurrowerStrike;

public interface AbstractMachineFactory {

    MachineEntity createMachine();
    MachineRadioactiveEntity createRadioactiveMachine() throws Exception;

}
