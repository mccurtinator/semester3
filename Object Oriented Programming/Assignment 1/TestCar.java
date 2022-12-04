
/**
 *
 * @author Michael McC
 * @version 1
 */
public class TestCar
{
    
    /**
     * main method
     * creates the test configuration
     * runs tests
     */
 public static void main(String[] args) {
     
     // create test configuration
     
     Car car = new Car("Donda Civic");
     
     // add engine with specified name and turns per litre
     Engine engine = new Engine("XXXCOMBUSTION", 43);
     car.addEngine(engine);
     
    // add wheel with specified name and radius
     Wheel wheel = new Wheel ("Wheel Lotta Red", 0.15);
     car.addWheel(wheel);
     
     // Test 1
     car.setFuel(100);
     car.drive();
     
     // Test 2
     car.setFuel(50);
     car.drive();
     

 }
}
