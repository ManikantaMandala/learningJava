public class learningBuiltInAnnotation{
    public static void main(String arg[]){
        /*
         * Lambda Expression can be used when it is a FunctionalInterface
         * Meaning it should have only one abstract method
         */

        Printer printer=()->{
            System.out.println("I print anything!");
        }; // Definitation of print() 

        printer.print(); // usage of print()
    }
}

//Marker Annotation
@FunctionalInterface  // by this there should only one abstract method(0 methods gives error)
interface Printer{
    public abstract void print(); 
    // void print(); // This is same as above
}

class Laptop{
    public String screen(String input){
        System.out.println("I display things!");
        return input;
    }
    public void keyboard(String input){
        System.out.println(" I take input and display on screen");
        screen(input);
    }
}

class MacBook extends Laptop{
    @Override // will check for same method class in the super class if 
    // it is present then it won't show error else it shows
    // By this we can say the RetentionPolicy is set to SOURCE
    // And Target is Method
    public void keyboard(String input){
        System.out.println(" I display the input: "+ input + " on screen");
        screen(input);
    }
}
