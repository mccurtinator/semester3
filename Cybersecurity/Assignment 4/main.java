import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class main {

    public static void main(String[] args) throws InterruptedException {

        scenario1();
        scenario2();


    }

    public static void scenario1() throws InterruptedException {
        System.out.println("----------Scenario 1:----------");
        int q = generatePrime();
        int a = findPrimitive(q);

        long AliceSecretNum = getRandomNumber(1, 10); // smaller number eliminates risk of overflow and is guaranteed to be less than q
       System.out.printf("Alice's secret value: %d\n", AliceSecretNum);

        TimeUnit.SECONDS.sleep(2); // delay ensures a different number is generated

        long BobSecretNum = getRandomNumber(1, 10);
        System.out.printf("Bob's's secret value: %d\n", BobSecretNum);

        long AlicePublicValue = generator(a,AliceSecretNum,q);
        System.out.printf("Alice sends the public value %d to Bob\n", AlicePublicValue);
        long BobPublicValue = generator(a,BobSecretNum,q);
        System.out.printf("Bob sends the public value %d to Alice\n", BobPublicValue);


        System.out.printf("Alice generates the secret key %d\n", generator(BobPublicValue,AliceSecretNum,q));
        System.out.printf("Bob generates the secret key %d\n", generator(AlicePublicValue,BobSecretNum,q));

        System.out.println("--------------------\n");

    }

    public static void scenario2() throws InterruptedException {
        System.out.println("----------Scenario 2:----------");
        int q = generatePrime();
        int a = findPrimitive(q);

        long AliceSecretNum = getRandomNumber(1, 10); // smaller number eliminates risk of overflow and is guaranteed to be less than q
        System.out.printf("Alice's secret value: %d\n", AliceSecretNum);

        TimeUnit.SECONDS.sleep(2); // delay ensures a different number is generated

        long BobSecretNum = getRandomNumber(1, 10);
        System.out.printf("Bob's's secret value: %d\n", BobSecretNum);

        TimeUnit.SECONDS.sleep(2); // delay ensures a different number is generated

        long MallorySecretNum = getRandomNumber(1, 10);
        System.out.printf("Mallory's secret value: %d\n", MallorySecretNum);


        long AlicePublicValue = generator(a,AliceSecretNum,q);
        System.out.printf("Alice sends the public value %d to Bob (intercepted by MALLORY)\n", AlicePublicValue);

        long BobPublicValue = generator(a,BobSecretNum,q);
        System.out.printf("Bob sends the public value %d to Alice (intercepted by MALLORY)\n", BobPublicValue);

        long MalloryPublicValue = generator(a,MallorySecretNum,q);

        System.out.printf("Mallory sends the public value %d to Bob\n", MalloryPublicValue);
        System.out.printf("Mallory sends the public value %d to Alice\n", MalloryPublicValue);

        System.out.printf("MalloryBob secret key: %d\n", generator(AlicePublicValue,MallorySecretNum,q));
        System.out.printf("Alice generates the secret key %d\n", generator(MalloryPublicValue,AliceSecretNum,q));

        System.out.printf("MalloryAlice secret key: %d\n", generator(BobPublicValue,MallorySecretNum,q));
        System.out.printf("Bob generates the secret key %d\n", generator(MalloryPublicValue,BobSecretNum,q));

        System.out.println("--------------------\n");
    }
    public static int generatePrime() {

        int randNum = getRandomNumber(10000, 100000);

        if (!isPrime(randNum)) {
            while (!isPrime(randNum)) {
                randNum = getRandomNumber(10000, 100000);
            }
        }

        System.out.printf("Generated prime %d\n", randNum);
        return randNum;
    }


    public static long generator(long a, long b, long q) {
       // System.out.printf("\na: %d, b:%d, q:%d", a,b,q);

        long power = a;
        //long power = (int)Math.pow(a,b);
        for (int i=0; i < b; i++) {
            power = power * b;
        }
        // I found the math.pow function to overflow easily, so this loop performs the same multiplication

        //System.out.printf("\nresult of power operation: %d", power);
        long Y = power % q;

      // System.out.printf("\nresult of power+modulo operation: %d\n", Y);
        return Y;
    }


    public static int getRandomNumber(int min, int max) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(max - min) + min;
    }


    public static boolean isPrime(int n) {
        // edge case: n is less than 1
        if (n <= 1)
            return false;

        // Check if n is divisible by integers aside from 1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }



    // copied shit

        // Returns true if n is prime
        static int power(int x, int y, int p)
        {
            int res = 1;	 // Initialize result

            x = x % p; // Update x if it is more than or
            // equal to p

            while (y > 0)
            {
                // If y is odd, multiply x with result
                if (y % 2 == 1)
                {
                    res = (res * x) % p;
                }

                // y must be even now
                y = y >> 1; // y = y/2
                x = (x * x) % p;
            }
            return res;
        }

        // findPrimeFactors function finds prime factors of a number and store in a HashSet
        static void findPrimeFactors(HashSet<Integer> primeFactors, int n)
        {

            // while number is divisible by 2
            while (n % 2 == 0)
            {
                primeFactors.add(2);
                n = n / 2;
            }

            // check if number is divisible by odd numbers smaller than the square root

            for (int i = 3; i <= Math.sqrt(n); i = i + 2)
            {

                while (n % i == 0)
                {
                    primeFactors.add(i);
                    n = n / i;
                }
            }

            // edge case: n is prime and > 2
            if (n > 2)
            {
                primeFactors.add(n);
            }
        }

        // findPrimitive function finds the smallest primitive root of n
        static int findPrimitive(int n)
        {
            HashSet<Integer> primeFactors= new HashSet<Integer>();

            // Check if n is prime or not
            if (isPrime(n) == false)
            {
                return -1;
            }

            // Find value of Euler's phi function of n
            // n is a prime number so the value of Euler phi function is n-1 as there are n-1 relatively prime numbers.

            int euler = n - 1;

            // Find prime factors of euler, store in a HashSet
            findPrimeFactors(primeFactors, euler);

            for (int r = 2; r <= euler; r++)
            {
                // Iterate through PrimeFactors, check if there is a power with value 1

                boolean condition = false;
                for (Integer a : primeFactors)
                {

                    // Check if r^((euler)/primefactors) mod n
                    // is 1 or not
                    if (power(r, euler / (a), n) == 1)
                    {
                        condition = true;
                        break;
                    }
                }

                if (condition == false)
                {
                    return r;
                }
            }

            return -1;
        }


}
