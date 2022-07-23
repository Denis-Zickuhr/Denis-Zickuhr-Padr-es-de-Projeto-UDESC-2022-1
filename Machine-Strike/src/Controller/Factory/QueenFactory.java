package Controller.Factory;

import Model.AbstractModel.MachineEntity;
import Model.AbstractModel.MachineRadioactiveEntity;
import Model.ConcreteModel.ConcreteMachine.Queen;

public class QueenFactory implements AbstractMachineFactory {

    // Essa máquina usa um Singleton para garantir que existe apenas um Queen no jogo

    Queen queen;

    @Override
    public MachineEntity createMachine() {
        if (queen == null)
            queen = new Queen();
        return queen;
    }

    @Override
    public MachineRadioactiveEntity createRadioactiveMachine() throws Exception {
        throw new Exception("Radioactive Queen not available");
    }
}
