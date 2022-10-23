package anything.world.blocks;

import arc.*;
import arc.math.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.game.EventType.*;
import mindustry.world.*;
import mindustry.world.meta.*;

public class UnitBlockR extends Block{
    /** The unit. */
    public UnitType unit;
    
    public static boolean yeet = false;
    
    public UnitBlockR(UnitType unit){
        super("unit-block-" + unit.name);
        this.unit = unit;
        update = true;
        solid = true;
        destructible = true;
        hasShadow = false;
        rebuildable = false;
        createRubble = false;
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
    
    public class UnitBlockRBuild extends Building{
        
        
        public void anAttempt(){
            super.kill();
            kill();
            super.remove();
            remove();
        }
        
        @Override
        public void placed(){
            super.placed();
            anAttempt();
            
            Unit mus = unit.spawn(team, x + Mathf.range(5f), y + Mathf.range(5f));
            mus.rotation = Mathf.random(360f);
            if(yeet) mus.vel.add(Mathf.random(360f), Mathf.random(360f));
        }
        
        @Override
        public void updateTile(){
            anAttempt();
        }
    }
}
