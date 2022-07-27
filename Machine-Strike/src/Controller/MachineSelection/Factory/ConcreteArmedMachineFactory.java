package Controller.MachineSelection.Factory;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.AbstractModel.AbstractMachine.Machine;
import Model.ConcreteModel.ConcreteMachine.Armed.KingArmedMachine;

public class ConcreteArmedMachineFactory implements AbstractMachineFactory{

    @Override
    public KingArmedMachine createKingMachine() throws Exception {
        return new KingArmedMachine();
    }

    @Override
    public Machine createQueenMachine() throws Exception {
        throw new Exception("Armed Queen does not exist");
    }

    @Override
    public MachineSoldierEntity createSoldierMachine(AbstractStrategy s) throws Exception {
        return s.buildRadio();
    }

}
