package Model.ConcreteModel.BuilderParts.Weapons;

public abstract class Weapon {

    protected int health;
    protected int attackPoints;
    protected int attackDistance;
    protected int moveSpan;
    protected int ammo;
    protected String s = "#";
    protected String b = ".png";
    protected String[] buffer;


    public Weapon() {
        this.health = 0;
        this.attackPoints = 0;
        this.attackDistance = 0;
        this.moveSpan = 0;
    }

    public String[] getBuffer() {
        return buffer;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getAttackDistance() {
        return attackDistance;
    }

    public int getMoveSpan() {
        return moveSpan;
    }

    public int getAmmo() {
        return ammo;
    }
}