class Gen<T>{
    private T obj;
    public Gen(T obj){
        this.obj = obj;
    }

    public T getObject(){
        return this.obj;
    }

    public void showType(){
        System.out.println("The type: " + this.obj.getClass().getName());
    }

}

public class genericsClass{
    public static void main(String[] args){
        Gen<Integer> genObject1 = new Gen<>(1);
        Gen<String> genObject2 = new Gen<>("Object2");

        System.out.println("Object 1: " + genObject1.getObject() + "\nObject 2: " + genObject2.getObject());
        System.out.print("Object 1: ");genObject1.showType();System.out.print("Object 2: ");genObject2.showType();
    }
}
