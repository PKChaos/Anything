package anything.content;

import arc.struct.Seq;
import mindustry.Vars;
import anything.binding.Bind;
import anything.world.blocks.UnitBlockR;


public class WhateverBlocks{
    
    public static Seq<Bind<UnitBlockR>> binds = new Seq<Bind<UnitBlockR>>();
    
    public static void load(){
        Vars.content.units().each(u -> {
            binds.add(new Bind<UnitBlockR>(new UnitBlockR(u)));
        });
    }
}
