package Controller.Factory;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public interface AbstractMachineFactory {

        Machine createKingMachine() throws Exception;
        Machine createQueenMachine() throws Exception;
        Machine createBeastMachine() throws Exception;
        Machine createSoldierMachine() throws Exception;

}
