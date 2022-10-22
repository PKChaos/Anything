package anything.binding;

import arc.struct.*;

public class Bind<T>{
    private T target = null;
    
    public Bind(){
        this(null);
    }
    
    public Bind(T point){
        target = point;
    }
    
    public T get(){
        return target;
    }
    
    public T set(T point){
        target = point;
        return target;
    }
}
