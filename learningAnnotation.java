/* Annotation works on the concept of Interface
 * but both are different
 *
 * /

/* To make a interface to Annotation
 * We use @ 
 *
 * @ -> informs the compiler that it is not a interface but a Annotation type!
 */

/*
 * The other things which I want to mentions are 
 * 1. Target -> At which level you want to give the permission
 *  Target have 12 enums(types):
 *      1.  ANNOTATION_TYPE            Annotation interface declaration (Formerly known as an annotation type.)
 *      2.  CONSTRUCTOR                Constructor declaration
 *      3.  FIELD                      Field declaration (includes enum constants)
 *      4.  LOCAL_VARIABLE             Local variable declaration
 *      5.  METHOD                     Method declaration
 *      6.  MODULE                     Module declaration.
 *      7.  PACKAGE                    Package declaration
 *      8.  PARAMETER                  Formal parameter declaration
 *      9.  RECORD_COMPONENT           Record component
 *      10. TYPE                       Class, interface (including annotation interface), enum, or record declaration
 *      11. TYPE_PARAMETER             Type parameter declaration
 *      12. TYPE_USE                   Use of a type
 * 2. Retention -> Upto which time(Compile time, Run time) it will work
 *  RetentionPolicy have 3 type:
 *      1. CLASS -> Until the compile time
 *      2. SOURCE -> Act as a comment
 *      3. RUNTIME -> Act as a comment, reach to the compile time and also 
 *                  reaches runtime(Reaching JVM);
 */

/*
 * We have to two ways to declare the values in Annotation
 * 1. Use default keyword in Annotation
 * 2. Using explicit declaration of before the target level
 */


/*
 *  We can declare multiple ElementType by making a list of them using {}.
 *  Eg: {ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD}
 *  This type of Target will work for all the 3 cases: class, constructor, fields
 *  and Method
 */
import java.lang.annotation.Target;
import java.lang.Class;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface CricketPlayer{
    int age() default 34;
    String country() default "India";
}

@CricketPlayer(age=35, country="India")
class Virat{
    @CricketPlayer
    int runs;
    int innings;

    @CricketPlayer
    public void setRuns(int runs){
        this.runs = runs;
    }
    public void setInnings(int innings){
        this.innings=innings;
    }
    public int getRuns(){
        return this.runs;
    }
    public int getInnings(){
        return this.innings;
    }
}

public class learningAnnotation{
    public static void main(String arg[])  {
        try{
            Virat v = new Virat();
            v.setRuns(15000);
            v.setInnings(250);
            System.out.println(v.getRuns());
            System.out.println(v.getInnings());

            Class c = v.getClass();
            Annotation an = c.getAnnotation(CricketPlayer.class);
            //Getting age value without downcasting
            System.out.println(an.annotationType().getMethod("age").invoke(an));
            CricketPlayer cp = (CricketPlayer)an;
            System.out.println("Age of Virat: "+cp.age());
            System.out.println("Age of Virat: "+cp.country());
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}
