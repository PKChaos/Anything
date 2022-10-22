package anything.classpathing

import rhino.*
import mindustry.Vars

//from ion
open class AnyClassGateway{

    fun load(){
        val scope = Vars.mods.scripts.scope as ImporterTopLevel
        
        val packages = Vars.tree.get("classpaths/anything-classpath.txt").readString().split('\n')
        
        packages.forEach{
            val p = NativeJavaPackage(it, Vars.mods.mainLoader())
            p.parentScope = scope
            scope.importPackage(p)
        }
    }
}
