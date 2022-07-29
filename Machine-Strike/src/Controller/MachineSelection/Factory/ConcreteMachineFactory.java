package Controller.MachineSelection.Factory;

import Model.AbstractModel.MachineKingEntity;
import Model.AbstractModel.MachineQueenEntity;
import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Basic.KingMachine;
import Model.ConcreteModel.Basic.QueenMachine;

public class ConcreteMachineFactory implements AbstractMachineFactory{

    @Override
    public MachineKingEntity createKingMachine() throws Exception {
        return new KingMachine();
    }

    @Override
    public MachineQueenEntity createQueenMachine() throws Exception {
        return new QueenMachine();
    }


    @Override
    public MachineSoldierEntity createSoldierMachine(AbstractStrategy s) throws Exception {
        return s.build();
    }

}
