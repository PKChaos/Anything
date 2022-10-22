package anything.binding;

public class Bind<T>{
    public T target = null;
    
    public Bind(){
        this(null);
    }
    
    public Bind(T point){
        target = point;
    }
}
