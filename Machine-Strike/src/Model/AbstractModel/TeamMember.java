package Model.AbstractModel;

public abstract class TeamMember {

    public abstract int getPoints();
    public abstract int getAttacks();
    public abstract int getMovements();
    public abstract void resetMovements();
    public abstract void resetAttacks();
    public abstract void blockAttacks();
    public abstract void blockMovements();
    public abstract void reset();
    public abstract void block();
    public abstract boolean isBlocked();

}
