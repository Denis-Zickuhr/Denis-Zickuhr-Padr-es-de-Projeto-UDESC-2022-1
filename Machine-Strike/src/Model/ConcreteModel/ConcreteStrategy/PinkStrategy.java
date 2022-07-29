package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadPink;
import Model.ConcreteModel.BuilderParts.Legs.LegPink;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponPink;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoPink;
import Model.ConcreteModel.Armed.SoldierArmedMachine;

public class PinkStrategy extends AbstractStrategy {

    public PinkStrategy() {
        super("Pashion Bot");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadPink()).addLegs(new LegPink()).addTorso(new TorsoPink());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadPink()).addLegs(new LegPink()).addTorso(new TorsoPink()).addRadio(new WeaponPink());
        return machineBuilder.build();
    }

}
