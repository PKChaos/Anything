package anything.content;

import arc.struct.Seq;
import mindustry.Vars;
import anything.binding.Bind;
import anything.world.blocks.UnitBlockR;

import static anything.UtilitiesKt.seqOf;


@SuppressWarnings("unchecked")
public class WhateverBlocks{
    
    public static Seq<Bind<UnitBlockR>> binds = seqOf();
    
    public static void load(){
        Vars.content.units().each(u -> binds.add(new Bind<>(new UnitBlockR(u))));
    }
}
