package anything

import arc.struct.Seq

typealias MUnit = mindustry.gen.Unit

fun <T> seqOf(vararg types: T): Seq<T>{
    if(types.isEmpty()) return Seq.with()
    return Seq.with(*types)
}