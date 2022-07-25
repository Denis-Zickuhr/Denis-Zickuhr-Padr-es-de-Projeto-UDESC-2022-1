package Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons;

public class WeaponPhantom extends Weapon {
    public WeaponPhantom() {
        this.health = 10;
        this.attackPoints = 10;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "shotgun";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}