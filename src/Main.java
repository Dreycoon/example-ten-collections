
import java.util.Iterator;
import java.util.LinkedList;



public class Main {
    public static void main(String[] args) {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("Привет");
        strings.add("меня");
        strings.add("зовут");
        strings.add("массив");

        strings.remove("массив");

        for (String string : strings) {
            System.out.println(string);
        }

        if (strings.contains("Привет")){
            System.out.println("В MyArrayList есть слов " + strings.get(0));

        }
        System.out.println("---------------------------");

        MyLinkedList<String> links = new MyLinkedList<>();
        links.add("Привет");
        links.add("меня");
        links.add("зовут");
        links.add("массив");

        links.remove("массив");

        for (String link : links) {
            System.out.println(link);
        }

        if (links.contains("зовут")){
            System.out.println("В LinkedList есть слов " + links.get(2));

        }

        System.out.println("---------------------------");

        Iterator<String> iterator = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }
        };


        MyArrayList<Dog> dogs = new MyArrayList<>();

        for (int i = 1; i < 3; i++) {
            Dog dog = new Dog();
            dog.height = i;
            dogs.add(dog);

        }

        DogScanner dogScanner = new DogScanner();
        dogScanner.scanDogs(dogs);

    }
}