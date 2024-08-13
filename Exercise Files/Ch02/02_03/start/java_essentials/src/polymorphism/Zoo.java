package polymorphism;

public class Zoo {

    public static void main(String[] args) {
        Dog rocky = new Dog();
        rocky.fetch();
        rocky.makeSound();
        feed(rocky);

        Animal sasha = new Dog();
        sasha.makeSound();

        sasha = new Cat();
        sasha.makeSound();
        ((Cat)sasha).scratch();
        feed(sasha);
    }

    public static void feed(Animal animal){


    }
}
