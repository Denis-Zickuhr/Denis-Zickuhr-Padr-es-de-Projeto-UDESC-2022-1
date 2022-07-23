package Controller.Factory;

import Model.AbstractModel.MachineEntity;
import Model.AbstractModel.MachineRadioactiveEntity;
import Model.ConcreteModel.ConcreteMachine.King;

public class KingFactory implements AbstractMachineFactory {

    // Essa máquina usa um Singleton para garantir que existe apenas um king no jogo

    King king;

    @Override
    public MachineEntity createMachine() {
        if (king == null)
            king = new King();
        return king;
    }

    @Override
    public MachineRadioactiveEntity createRadioactiveMachine() throws Exception {
        throw new Exception("Radioactive King not available");
    }
}
