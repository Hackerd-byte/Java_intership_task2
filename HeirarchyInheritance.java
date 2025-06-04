class Animal{
  void eats(){
    System.out.println("This animal Eats");
  }
}
class Dog extends Animal{
  void barks(){
    System.out.println("Dog barks");
  }
}
class Cat extends Animal{
  void meows(){
    System.out.println("Cat meows");
  }
}
public class HeirarchyInheritance{
  public static void main(String[] args){
    Animal a=new Animal();
    Dog b=new Dog();
    Cat c=new Cat();
    System.out.println("Main class");
    a.eats();
    System.out.println("Subclass 1");
    b.eats();
    b.barks();
    System.out.println("Subclass 2");
    c.eats();
    c.meows();
  }
}
