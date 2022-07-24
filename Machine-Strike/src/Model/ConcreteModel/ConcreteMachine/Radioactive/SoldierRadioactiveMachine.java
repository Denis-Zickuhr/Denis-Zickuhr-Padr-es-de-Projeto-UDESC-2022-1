package Model.ConcreteModel.ConcreteMachine.Radioactive;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractMachineBuilder;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.RadioEmiter.Radio;

public class SoldierRadioactiveMachine extends MachineSoldierEntity {

    public SoldierRadioactiveMachine(MachineBuilder machineBuilder) {
        super(machineBuilder);
    }

    public static class MachineBuilder extends AbstractMachineBuilder {

        private int radRadius;
        private Radio radio;

        public int getRadRadius() {
            return radRadius;
        }

        @Override
        public MachineBuilder addRadio(Radio radio) {

            if (this.radio != null) {
                this.health -= this.radio.getHealth();
                this.attackPoints -= this.radio.getAttackPoints();
                this.attackDistance -= this.radio.getAttackDistance();
                this.moveSpan -= this.radio.getMoveSpan();
            }
            this.radio = radio;


            this.health += radio.getHealth();
            this.attackPoints += radio.getAttackPoints();
            this.attackDistance += radio.getAttackDistance();
            this.moveSpan += radio.getMoveSpan();
            this.buffer[2] = radio.getBuffer()[0];
            return this;

        }

        @Override
        public SoldierRadioactiveMachine build() {
            return new SoldierRadioactiveMachine(this);
        }
    }

}
