package anything

import arc.*
import mindustry.game.EventType.*
import mindustry.mod.*
import anything.classpathing.*

class Anything : Mod(){

    init{
        Events.on(ClientLoadEvent::class.java){
            AnyClassGateway().load()
        }
    }
}
