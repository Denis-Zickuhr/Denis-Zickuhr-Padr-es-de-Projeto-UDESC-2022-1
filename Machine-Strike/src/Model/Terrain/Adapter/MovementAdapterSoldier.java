package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.Machine;

public class MovementAdapterSoldier implements MovementBehaviourAdapter {

    @Override
    public void specialAttack(boolean reverse) throws Exception {
        throw new Exception("operation not supported");
    }
}
