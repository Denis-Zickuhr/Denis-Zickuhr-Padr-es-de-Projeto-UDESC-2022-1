package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.Machine;

public class MovementAdapterSoldier implements MovementBehaviourAdapter {

    @Override
    public boolean specialAttack(Machine... machine) throws Exception {
        throw new Exception("operation not supported");
    }
}
