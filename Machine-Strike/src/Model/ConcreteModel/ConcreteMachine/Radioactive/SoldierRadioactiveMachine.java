package Model.ConcreteModel.ConcreteMachine.Radioactive;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractMachineBuilder;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.RadioEmiter.Radio;

public class SoldierRadioactiveMachine extends MachineSoldierEntity {

    public SoldierRadioactiveMachine(RadioactiveMachineBuilder machineBuilder) {
        super(machineBuilder);
    }

    public static class RadioactiveMachineBuilder extends AbstractMachineBuilder {

        private int radRadius;
        private Radio radio;

        public int getRadRadius() {
            return radRadius;
        }

        @Override
        public RadioactiveMachineBuilder buildRadio(Radio radio) {

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
            return this;

        }

        @Override
        public SoldierRadioactiveMachine build() {
            return new SoldierRadioactiveMachine(this);
        }
    }

}
