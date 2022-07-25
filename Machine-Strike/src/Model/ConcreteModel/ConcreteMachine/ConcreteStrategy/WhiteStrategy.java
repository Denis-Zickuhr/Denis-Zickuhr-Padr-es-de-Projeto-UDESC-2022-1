package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadWhite;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegWhite;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponWhite;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoWhite;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

public class WhiteStrategy extends AbstractStrategy {

    public WhiteStrategy() {
        super("Pale Rocker Bot");
    }

    @Override
    public MachineSoldierEntity build() {
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadWhite()).addLegs(new LegWhite()).addTorso(new TorsoWhite());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadWhite()).addLegs(new LegWhite()).addTorso(new TorsoWhite()).addRadio(new WeaponWhite());
        return machineBuilder.build();
    }

}
