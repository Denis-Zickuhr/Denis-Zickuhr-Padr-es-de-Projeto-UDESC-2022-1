package Model;

public abstract class TeamMember {

    public abstract int getPoints();
    public abstract int getAttacks();
    public abstract int getMovements();
    public abstract void resetMovements();
    public abstract void resetAttacks();
    public abstract void block();

}
