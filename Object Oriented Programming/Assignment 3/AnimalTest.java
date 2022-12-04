public class AnimalTest {
    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1() {

        System.out.println("--------TEST 1---------\n");

        // create array of 4 animals of the 4 different types

        Animal[] animals = new Animal[4];

        animals[0] = new Canary("Aretha");
        animals[1] = new Ostrich("Stevie");
        animals[2] = new Shark("Marvin");
        animals[3] = new Trout("Ray");

        // print out animal toString information

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }
    public static void test2() {

        System.out.println("--------TEST 2---------\n");

        // create array of 8 animals of the 4 different types


        Animal[] animals = new Animal[8];


        animals[0] = new Canary("Lucas");
        animals[1] = new Canary("Steve");
        animals[2] = new Ostrich("Dimitri");
        animals[3] = new Ostrich("Mike");
        animals[4] = new Shark("Thomas");
        animals[5] = new Shark("Guy");
        animals[6] = new Trout("Sasha");
        animals[7] = new Trout("John");


        // print out animal toString information


        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }


        // print out whether each animal is equal to the next animal

        for (int i = 0, j = 1; j < animals.length; i++) {
            System.out.println(String.format("\nAnimal at index %d equals Animal at index %d ?\n", i, j));
            System.out.println(animals[i].equals(animals[j]));
            j++;
        }

    }
}