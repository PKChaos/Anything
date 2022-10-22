package anything.content;

import arc.struct.Seq;
import mindustry.Vars;
import anything.binding.Bind;
import anything.world.blocks.UnitBlock;


public class WhateverBlocks{
    
    public static Seq<Bind<UnitBlock>> binds = new Seq<Bind<UnitBlock>>()
    
    public static void load(){
        Vars.content.units().each(u -> {
            binds.add(new UnitBlock(u));
        });
    }
}
