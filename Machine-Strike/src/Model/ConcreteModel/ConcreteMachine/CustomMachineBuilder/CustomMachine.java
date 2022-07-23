package Model.ConcreteModel.ConcreteMachine.CustomMachineBuilder;

import Model.AbstractModel.Armor;
import Model.AbstractModel.MachineEntity;
import Model.AbstractModel.Plate;
import Model.ConcreteModel.ConcreteMachine.CustomMachineBuilder.Parts.Heads.Head;
import Model.ConcreteModel.ConcreteMachine.CustomMachineBuilder.Parts.Legs.Leg;
import Model.ConcreteModel.ConcreteMachine.CustomMachineBuilder.Parts.Torsos.Torso;

public class CustomMachine extends MachineEntity {

    public CustomMachine(MachineBuilder machineBuilder) {
        setHealth(machineBuilder.getHealth());
        setAttackPoints(machineBuilder.getAttackPoints());
        setAttackDistance(machineBuilder.getAttackDistance());
        setMoveSpan(machineBuilder.getMoveSpan());
        setArmors(machineBuilder.getArmors());
    }

    public static class MachineBuilder{

        int health;
        int attackPoints;
        int attackDistance;
        int moveSpan;
        Head head;
        Leg leg;
        Torso torso;
        Armor[] armors = {Armor.Neutral, Armor.Neutral, Armor.Neutral, Armor.Neutral};

        public void reset(){
            health = 0;
            attackPoints = 0;
            attackDistance = 0;
            moveSpan = 0;
            head = null;
            leg = null;
            torso = null;
            armors = new Armor[]{Armor.Neutral, Armor.Neutral, Armor.Neutral, Armor.Neutral};
        }

        public MachineBuilder buildHead(Head head) {

            if (this.head != null) {
                this.health -= this.head.getHealth();
                this.attackPoints -= this.head.getAttackPoints();
                this.attackDistance -= this.head.getAttackDistance();
                this.moveSpan -= this.head.getMoveSpan();
            }
            this.head = head;

            this.health += head.getHealth();
            this.attackPoints += head.getAttackPoints();
            this.attackDistance += head.getAttackDistance();
            this.moveSpan += head.getMoveSpan();
            return this;

        }

        public MachineBuilder buildLegs(Leg legs) {

            if (this.leg != null) {
                this.health -= this.leg.getHealth();
                this.attackPoints -= this.leg.getAttackPoints();
                this.attackDistance -= this.leg.getAttackDistance();
                this.moveSpan -= this.leg.getMoveSpan();
            }
            this.leg = legs;

            health += legs.getHealth();
            attackPoints += legs.getAttackPoints();
            attackDistance += legs.getAttackDistance();
            moveSpan += legs.getMoveSpan();
            return this;

        }

        public MachineBuilder buildTorso(Torso torso) {

            if (this.torso != null) {
                this.health -= this.torso.getHealth();
                this.attackPoints -= this.torso.getAttackPoints();
                this.attackDistance -= this.torso.getAttackDistance();
                this.moveSpan -= this.torso.getMoveSpan();
            }
            this.torso = torso;

            health += torso.getHealth();
            attackPoints += torso.getAttackPoints();
            attackDistance += torso.getAttackDistance();
            moveSpan += torso.getMoveSpan();
            return this;

        }

        public void buildArmor(Plate plate, Armor armor) {
            this.armors[plate.getValue()] = armor;
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

        public Armor[] getArmors() {
            return armors;
        }

        public CustomMachine build(){
            return new CustomMachine(this);
        }
    }
}
