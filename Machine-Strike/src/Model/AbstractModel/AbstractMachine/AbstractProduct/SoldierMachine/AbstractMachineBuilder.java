package Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine;

import Model.AbstractModel.Armor;
import Model.AbstractModel.AbstractMachine.Machine;
import Model.AbstractModel.Plate;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.Head;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.Leg;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.Weapon;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.Torso;

public abstract class AbstractMachineBuilder extends Machine {

    protected int health;
    protected int attackPoints;
    protected int attackDistance;
    protected int moveSpan;
    protected String[] buffer = new String[4];
    private Head head;
    private Leg leg;
    private Torso torso;
    private Armor[] armors = {Armor.Neutral, Armor.Neutral, Armor.Neutral, Armor.Neutral};

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

    public AbstractMachineBuilder addHead(Head head) {

        if (this.head != null) {
            this.health -= this.head.getHealth();
            this.attackPoints -= this.head.getAttackPoints();
            this.attackDistance -= this.head.getAttackDistance();
            this.moveSpan -= this.head.getMoveSpan();
        }

        this.head = head;

//
//        this.health += head.getHealth();
//        this.attackPoints += head.getAttackPoints();
//        this.attackDistance += head.getAttackDistance();
//        this.moveSpan += head.getMoveSpan();

        this.health += this.head.getHealth();
        this.attackPoints += this.head.getAttackPoints();
        this.attackDistance += this.head.getAttackDistance();
        this.moveSpan += this.head.getMoveSpan();
        this.buffer[0] = this.head.getBuffer()[0];
        return this;

    }

    public AbstractMachineBuilder addLegs(Leg legs) {

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
        this.buffer[1] = legs.getBuffer()[0];
        return this;

    }

    public AbstractMachineBuilder addTorso(Torso torso) {

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
        this.buffer[2] = torso.getBuffer()[0];
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

    public String[] getBuffer() {
        return buffer;
    }

    public abstract MachineSoldierEntity build();

    public abstract AbstractMachineBuilder addRadio(Weapon weapon) throws Exception;

}
