package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public class MovementAdapterSoldier implements MovementBehaviourAdapter {

    @Override
    public boolean specialAttack(Machine... machine) throws Exception {
        throw new Exception("operation not supported");
    }
}
