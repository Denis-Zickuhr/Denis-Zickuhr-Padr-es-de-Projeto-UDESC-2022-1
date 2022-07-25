package Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons;

public class WeaponBlack extends Weapon {
    public WeaponBlack() {
        this.health = 10;
        this.attackPoints = 1;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "minigun";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}