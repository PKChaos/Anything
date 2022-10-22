package anything.content;

import mindustry.Vars;
import anything.world.blocks.UnitBlock;

public class WhateverBlocks{
    
    public static void load(){
        Vars.content.units().each(u -> {
            new UnitBlock(u);
        });
    }
}
