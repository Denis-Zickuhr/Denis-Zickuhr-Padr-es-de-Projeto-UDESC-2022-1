package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public interface MovementBehaviourAdapter {

    boolean specialAttack(Machine... machine) throws Exception;

}
