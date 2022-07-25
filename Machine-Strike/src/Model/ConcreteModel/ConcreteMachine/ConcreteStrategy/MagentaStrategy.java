package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadMagenta;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegMagenta;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponMagenta;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoMagenta;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

public class MagentaStrategy extends AbstractStrategy {

    public MagentaStrategy() {
        super("Magenta Droid");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadMagenta()).addLegs(new LegMagenta()).addTorso(new TorsoMagenta());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadMagenta()).addLegs(new LegMagenta()).addTorso(new TorsoMagenta()).addRadio(new WeaponMagenta());
        return machineBuilder.build();
    }

}