class Gen<T>{
    T ob;
    Gen(T ob){
        this.ob = ob;
    }

    T getOb(){
        return this.ob;
    }
}
class Gen2 extends Gen<String> {
    Gen2(String str){
        super(str);
    }
    String getOb(){
        return ob;
    }
}

public class bridgeMethod{
    public static void main(String[] args){
        String str = "Manikanta";
        Gen2 obj = new Gen2(str);
        Gen<String> obj2 = new Gen<>(str);
        System.out.println(obj.getOb());
        System.out.println(obj2.getOb());
        System.out.println( genMethod(str));
    }
    public static <T> T genMethod(T ob){
        return ob;
    }
}
