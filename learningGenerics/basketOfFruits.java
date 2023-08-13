import java.util.ArrayList;
import java.util.List;

public class basketOfFruits {
    public static void main(String[] args) {
        Basket<Banana> bananaBasket = new Basket<>();
        for(int i=0;i<5;i++){
            bananaBasket.addFruits(new Banana());
        }
        Basket<Fruits> fruitsBasket = new Basket<>();
        fruitsBasket.addFruits(new Orange());
        fruitsBasket.addFruits(new Mango());
        fruitsBasket.addFruits(new Watermelon());
        fruitsBasket.addFruits(new Apple());
        System.out.println("Banana Basket have: "+ bananaBasket.basket.size()+ " bananas");
        System.out.println("Fruits Basket have: "+ fruitsBasket.basket.size()+ " fruits");
        System.out.println(fruitsBasket.basket);

    }
}

interface Fruits {
    public default String getName() {
        return this.getClass().getName().toString();
    }
}

class Basket<T extends Fruits>{
    List<String> basket = new ArrayList<>();
    public Basket(){
    }

    public boolean addFruits(T fruit){
        return basket.add(fruit.getName());
    }
}

class Banana implements Fruits {}

class Orange implements Fruits{}

class Mango implements Fruits{}

class Watermelon implements Fruits{}

class Apple implements Fruits{}
