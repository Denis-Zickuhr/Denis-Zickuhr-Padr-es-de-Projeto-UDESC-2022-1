package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.MachineBuilder;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadDestroyerOfWorld;
import Model.ConcreteModel.ConcreteMachine.Radioactive.SoldierRadioactiveMachine;

public class GrazerRadioactiveStrikeStrategy extends MachineBuilder {
    @Override
    public MachineSoldierEntity build() {
        SoldierRadioactiveMachine.RadioactiveMachineBuilder radioactiveMachineBuilder = new SoldierRadioactiveMachine.RadioactiveMachineBuilder();
        //radioactiveMachineBuilder.buildHead().buildLegs().buildTorso().buildRadio();
        return radioactiveMachineBuilder.build();
    }
}
