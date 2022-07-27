package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.Machine;

public interface MovementBehaviourAdapter {

    boolean specialAttack(Machine... machine) throws Exception;

}
