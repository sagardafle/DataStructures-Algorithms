import java.util.*;
class Animal{
    String name;
    String type;
    Date arrived;
    
    @Override
    public String toString(){
        return "Name:"+name+" Type: "+type ;
    }
}

class Dog extends Animal{
    public Dog(String name){
        this.name = name;
        type = "Dog";
    }
}

class Cat extends Animal{
    // String name;
    public Cat(String name){
        this.name = name;
        type = "Cat";
    }
}

public class AnimalShelter{
    static private LinkedList<Cat> cats;
    static private LinkedList<Dog> dogs;
    
    public AnimalShelter(){
        cats = new LinkedList<Cat>();
        dogs = new LinkedList<Dog>();
    }
    
    public static void main(String[] args) throws Exception{
        AnimalShelter animalshelter = new AnimalShelter();
        Animal dog1 = new Dog("Rocky");
        animalshelter.enqueue(dog1);
        Animal dog2 = new Dog("Brooky");
        animalshelter.enqueue(dog2);
        Animal dog3 = new Dog("Tommy");
        animalshelter.enqueue(dog3);
        System.out.println("Original Dog list--> "+dogs);
        
        Animal cat1 = new Cat("Pussy");
        animalshelter.enqueue(cat1);
        Animal cat2 = new Cat("Meowww");
        animalshelter.enqueue(cat2);
        Animal cat3 = new Cat("Beoww");
        animalshelter.enqueue(cat3);
        System.out.println("Original Cat list--> "+cats);
        
        animalshelter.dequeueAny();
        System.out.println("After Dequeue ANY-->\nDogs"+dogs+"\nCats"+cats);
        
        animalshelter.dequeueDog();
        System.out.println("After Dequeue Dog-->"+dogs);
        
        animalshelter.dequeueCat();
        System.out.println("After Dequeue Cats-->"+cats);
    }
    
     public void enqueue(Animal animal) throws Exception{
        boolean isCat = animal.type.equals("Cat");
        boolean isDog = animal.type.equals("Dog");
        if(!isCat && !isDog)
            throw new Exception("Unknow type of animal!");
           animal.arrived = new Date();
            if(isCat){
                cats.add((Cat) animal);
            } else {
                dogs.add((Dog) animal);
            }
     }
     
     public Animal dequeueAny() throws Exception{
         if(cats.isEmpty() && dogs.isEmpty()) {
             System.out.println("No animals in the shelter");
             return null;
         }
         if(dogs.isEmpty()) return cats.removeFirst();
         if(cats.isEmpty()) return dogs.removeFirst();
         return (dogs.peek().arrived.compareTo(cats.peek().arrived) < 0) ? dogs.removeFirst() : cats.removeFirst();
     }
     
     public Cat dequeueCat() throws Exception {
         if(cats.isEmpty()) {
             System.out.println("No Cats in the shelter");
             return null;
         } 
         return cats.removeFirst();
    }
    
    public Dog dequeueDog() throws Exception {
        if(dogs.isEmpty()){
            System.out.println("No Dogs in the shelter");
             return null;
         }
         return dogs.removeFirst();
    }
}