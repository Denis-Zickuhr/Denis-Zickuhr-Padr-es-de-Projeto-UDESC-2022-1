package Controller.MachineSelection.Factory;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.AbstractModel.Machine;
import Model.ConcreteModel.Armed.KingArmedMachine;

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
