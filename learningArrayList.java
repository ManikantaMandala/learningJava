import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class learningArrayList{
    public static void main(String[] args) {
        // String[] students = new String[30];

        // students[0]="Manikanta";
        // //..........
        // students[29]="Mandala";
        // //New student
        // students[30]= "RRR";//This will give out of bound error.
        
        ArrayList<String> students = new ArrayList<>();
        //add() function in arrayList: TimeComplexity will be O(n)
        // size -> n
        // next time the size will be n+ n/2 + 1 spaces will be created when a arraylist is outOfBound.
        students.add("Manikanta");
        // arrayList.add(element) will add the element at the end of the arrray in arraylist.

        students.add("Mandala");
        System.out.println(students);

        students.add(1, "vijaysurya"); // This will add at a index(first parameter) and the element will be(second parameter)
        System.out.println(students);

        ArrayList<String> age = new ArrayList<>();
        age.add("43");
        age.add("23");

        students.addAll(age); //This will add age arrayList at the end of the students arrayList
        System.out.println(students);

        //get() function in arrayList: TimeComplexity will be O(1)
        System.out.println(students.get(3)); // This will get the element at index 3 in students arrayList.

        System.out.println(students.getClass());

        //remove() function in arrayList: TimeComplexity will be O(n)
        students.remove(2); // If the values is int -> It will remove the element at that index.
        System.out.println(students);

        students.remove(String.valueOf("43")); // This will remove that element if the parameter is a object and if the parameter is in that arrayList.
        System.out.println(students);

        //clear() function in arrayList:
        // students.clear();// This will remove all the elements in students.

        //set() function in arrayList:TimeComplexity is O(1)
        students.set(1, "vijay");
        System.out.println(students);

        //contains() function in arrayList: TimeComplexity is O(n)
        System.out.println(students.contains("vijay"));//This will return a boolean value.

        // for traversing in arrayList, There are different kinds of ways to do those things:
        //1st:
        System.out.println("\nThe elements in arrayList iterated using for loop are:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
        System.out.println("\nThe elements in arrayList iterated using foreach loop are:");
        for (String i : students) {
            System.out.println(i);
        }

        System.out.println("\nThe elements in arrayList iterated using iterator are:");
        // Iterator<String> it = students.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }
    }
}