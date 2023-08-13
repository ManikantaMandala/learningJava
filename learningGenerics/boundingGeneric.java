import java.util.ArrayList;

interface I{
    void show();
}

class implementedClass extends ArrayList<Integer> implements I{
    @Override
    public void show(){
        System.out.print("The class: "+ this.getClass().getName());
    }
}

class genericClass1<T extends I>{
    T obj1;
    genericClass1(T obj1){
        this.obj1 = obj1;
    }
    
}
public class boundingGeneric{
    public static void main(String[] args){
        implementedClass ic = new implementedClass();
        genericClass1<implementedClass> gc1 = new genericClass1<>(ic);
        gc1.obj1.show();

    }
}
