package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadRed;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegRed;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponRed;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoRed;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

public class RedStrategy extends AbstractStrategy {

    public RedStrategy() {
        super("Crimson Robot");
    }

    @Override
    public MachineSoldierEntity build() {
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadRed()).addLegs(new LegRed()).addTorso(new TorsoRed());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadRed()).addLegs(new LegRed()).addTorso(new TorsoRed()).addRadio(new WeaponRed());
        return machineBuilder.build();
    }

}
