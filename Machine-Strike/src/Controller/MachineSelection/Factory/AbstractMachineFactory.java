package Controller.MachineSelection.Factory;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.Machine;

public interface AbstractMachineFactory {

        Machine createKingMachine() throws Exception;
        Machine createQueenMachine() throws Exception;
        Machine createSoldierMachine(AbstractStrategy s) throws Exception;

}
