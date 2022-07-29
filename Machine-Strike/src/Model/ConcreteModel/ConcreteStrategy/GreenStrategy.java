package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Armed.SoldierArmedMachine;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadGreen;
import Model.ConcreteModel.BuilderParts.Legs.LegGreen;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponGreen;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoGreen;

public class GreenStrategy extends AbstractStrategy {

    public GreenStrategy() {
        super("Green Trooper");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadGreen()).addLegs(new LegGreen()).addTorso(new TorsoGreen());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadGreen()).addLegs(new LegGreen()).addTorso(new TorsoGreen()).addRadio(new WeaponGreen());
        return machineBuilder.build();
    }

}