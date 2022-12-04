package ct255;

import java.util.Random;

/**
 *
 * @author Michael Schukat, Michael McCurtin
 */
public class CT255_HashFunction1 {

    public static void main(String[] args) {
        int res = 0;

        if (args != null && args.length > 0) { // Check for <input> value
            res = hashF1(args[0]); // call hash function with <input>
            if (res < 0) { // Error
                System.out.println("Error: <input> must be 1 to 64 characters long.");
            } else {
                System.out.println("input = " + args[0] + " : Hash = " + res);
                System.out.println("Start searching for collisions");


                // Your code to look for a hash collision starts here!
                for (int i = 0; i < 24; i++) {
                    findMatches(i);
                }

            }
        } else { // No <input>
            System.out.println("Use: CT255_HashFunction1 <Input>");
        }
    }

    private static int hashF1(String s) {
        int ret = -1, i;
        int[] hashA = new int[]{1, 1, 1, 1};

        String filler, sIn;

        filler = new String("ABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGH");

        if ((s.length() > 64) || (s.length() < 1)) { // String does not have required length
            ret = -1;
        } else {
            sIn = s + filler; // Add characters, now have "<input>HABCDEF..."
            sIn = sIn.substring(0, 64); // // Limit string to first 64 characters
            // System.out.println(sIn); // FYI
            for (i = 0; i < sIn.length(); i++) {
                char byPos = sIn.charAt(i); // get i'th character
                hashA[0] += (byPos * 17); // Note: A += B means A = A + B

                hashA[1] += (byPos * 31);

                hashA[2] += (byPos * 101);

                hashA[3] += (byPos * 79);

            }


            // my additional encryption

            hashA[0] = extraEncryption(hashA[0]);
            hashA[0] = extraEncryption(hashA[1]);
            hashA[0] = extraEncryption(hashA[2]);
            hashA[0] = extraEncryption(hashA[3]);

            // original encryption

            hashA[0] %= 255;  // % is the modulus operation, i.e. division with rest
            hashA[1] %= 255;
            hashA[2] %= 255;
            hashA[3] %= 255;



            ret = hashA[0] + (hashA[1] * 256) + (hashA[2] * 256 * 256) + (hashA[3] * 256 * 256 * 256);
            if (ret < 0) ret *= -1;
        }
        return ret;
    }

    private static void findMatches(int stringLength) {

        //  initialise variables

        char[] randomString = new char[stringLength];
        int matchCounter = 0;


        // make 999999 attempts at finding a match

        for (int i=0; i < 999999; i++) {

            // populate the random string

            for (int j = 0; j < stringLength; j++) {
                Random rnd = new Random();

                String alphabet = "!\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~?/.,";

                char c = alphabet.charAt(rnd.nextInt(alphabet.length())); // pick a random character from the alphabet
                randomString[j] = c;

            }


            int result = hashF1(String.valueOf(randomString));

            // check if the generated hash matches our desired hash

            if (result == 1079524045) {
                /*System.out.println(String.format("%s", String.valueOf(randomString))); // print out string (optional)*/
                matchCounter ++;
            }


        }

        System.out.println(String.format("Number of matches of length %d found: %d", stringLength, matchCounter));

    }

    private static int extraEncryption(int x) {
        // perform 5 bit left shift on the number then subtract the original to get multiplication by 31
        // similar to Java's own String.hashCode() function
        return ( x << 5 - (x));
    }
}
