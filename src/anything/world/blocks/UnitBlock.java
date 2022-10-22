package anything.world.blocks;

import arc.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.game.EventType.*;
import mindustry.world.*;
import mindustry.world.meta.*;

public class UnitBlock extends Block{
    /** The unit. */
    public UnitType unit;
    
    public UnitBlock(UnitType unit){
        super("unit-block-" + unit.name);
        this.unit = unit;
        update = true;
        solid = true;
        destructible = true;
        hasShadow = false;
        buildVisibility = BuildVisibility.shown;
        category = Category.units;
    }
    
    @Override
    public void load(){
        super.load();
        Events.on(ClientLoadEvent.class, e -> {
            fullIcon = unit.fullIcon;
            uiIcon = unit.fullIcon;
        });
    }
    
    public class FallenUnitBuild extends Building{
        
        @Override
        public void placed(){
            super.placed();
            super.remove();
            
            unit.spawn(team, x, y);
        }
    }
}
