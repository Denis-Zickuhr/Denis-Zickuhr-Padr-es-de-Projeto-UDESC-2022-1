package Controller.Factory;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineBeastEntity;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.Basic.KingMachine;
import Model.ConcreteModel.ConcreteMachine.Basic.QueenMachine;
import Model.ConcreteModel.ConcreteMachine.Radioactive.BeastRadioactiveMachine;

public class ConcreteRadioactiveMachineFactory implements AbstractMachineFactory{

    @Override
    public KingMachine createKingMachine() throws Exception {
        throw new Exception("Radioactive King does not exist");
    }

    @Override
    public QueenMachine createQueenMachine() throws Exception {
        throw new Exception("Radioactive Queen does not exist");
    }

    @Override
    public MachineBeastEntity createBeastMachine() throws Exception {
        return new BeastRadioactiveMachine();
    }

    @Override
    public MachineSoldierEntity createSoldierMachine(AbstractStrategy s) throws Exception {
        return s.buildRadio();
    }

}
