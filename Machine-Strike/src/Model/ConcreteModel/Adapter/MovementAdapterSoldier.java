package Model.ConcreteModel.Adapter;

public class MovementAdapterSoldier implements MovementBehaviourAdapter {

    @Override
    public void specialAttack(boolean reverse) throws Exception {
        throw new Exception("operation not supported");
    }
}
