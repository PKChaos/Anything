package anything

import arc.*
import mindustry.game.EventType.*
import mindustry.mod.*
import anything.content.*
import anything.classpathing.*
import com.github.smol.kotmindy.arc.events.*

class Anything : Mod(){

    init{
        listen<ClientLoadEvent>{
            AnyClassGateway().load()
        }
    }
    
    override fun loadContent(){
        WhateverBlocks.load()
    }
}
