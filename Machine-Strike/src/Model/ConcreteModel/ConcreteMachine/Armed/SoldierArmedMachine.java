package Model.ConcreteModel.ConcreteMachine.Armed;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractMachineBuilder;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.Weapon;

import java.util.Arrays;
import java.util.Random;

public class SoldierArmedMachine extends MachineSoldierEntity {


    private int ammo;

    public int getAmmo() {
        return ammo;
    }

    @Override
    public String toString() {
        return super.toString() +
                '\u204D' + "" + this.ammo;
    }

    public SoldierArmedMachine(MachineBuilder machineBuilder) {
        super(machineBuilder);
        this.ammo = machineBuilder.getAmmo();
    }

    public static class MachineBuilder extends AbstractMachineBuilder {

        Random r = new Random();
        private final int ammo = r.nextInt(10);
        private Weapon weapon;

        public int getAmmo() {
            return ammo;
        }

        @Override
        public String toString() {
            return super.toString() +
                    '\u204D' + "" + this.ammo;
        }

        @Override
        public MachineBuilder addRadio(Weapon weapon) {

            if (this.weapon != null) {
                this.health -= this.weapon.getHealth();
                this.attackPoints -= this.weapon.getAttackPoints();
                this.attackDistance -= this.weapon.getAttackDistance();
                this.moveSpan -= this.weapon.getMoveSpan();
            }
            this.weapon = weapon;


            this.health += weapon.getHealth();
            this.attackPoints += weapon.getAttackPoints();
            this.attackDistance += weapon.getAttackDistance();
            this.moveSpan += weapon.getMoveSpan();
            this.buffer[3] = weapon.getBuffer()[0];
            return this;

        }

        @Override
        public SoldierArmedMachine build() {
            return new SoldierArmedMachine(this);
        }
    }

}
