package Controller.MachineSelection.Factory;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineKingEntity;
import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineQueenEntity;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.KingMachine;
import Model.ConcreteModel.ConcreteMachine.Basic.QueenMachine;

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
