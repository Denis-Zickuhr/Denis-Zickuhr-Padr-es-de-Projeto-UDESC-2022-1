package Controller.MachineSelection.Factory;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public interface AbstractMachineFactory {

        Machine createKingMachine() throws Exception;
        Machine createQueenMachine() throws Exception;
        Machine createSoldierMachine(AbstractStrategy s) throws Exception;

}
