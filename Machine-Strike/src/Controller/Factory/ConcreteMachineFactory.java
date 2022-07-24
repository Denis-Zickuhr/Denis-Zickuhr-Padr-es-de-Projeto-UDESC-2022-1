package Controller.Factory;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineBeastEntity;
import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineKingEntity;
import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineQueenEntity;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.ConcreteModel.ConcreteMachine.Basic.BeastMachine;
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
    public MachineBeastEntity createBeastMachine() throws Exception {
        return new BeastMachine();
    }

    @Override
    public MachineSoldierEntity createSoldierMachine() throws Exception {
        // Aqui vamos usar o builder
        return null;
    }

}
