
/**
 * CT255 - Assignment 3
 * Skeleton code for Steganography assignment.
 *
 * @author Michael Schukat, Michael McCurtin
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Stegano1
{
    /**
     * Constructor for objects of class Stegano1
     */
    public Stegano1()
    {
    }

    public static void main(String[] args) {
        String arg1, arg2, arg3, arg4;
        Boolean err = false;
        
        if (args != null && args.length > 1) { // Check for minimum number of arguments

            for (int i = 0; i < args.length; i++) {
            }
            arg1 = args[0];
            arg2 = args[1];
                
            if (arg2.equals("")) {
                err = true; System.out.printf("Err1");
            }
            else if ((arg1.equals("A")) && (args.length > 3)){
                // Get other arguments
                arg3 = args[2];
                arg4 = args[3];
                if (arg3 == "" || arg4 == "") {
                    err = true; System.out.printf("Err2");
                }
                else {
                    // Hide bitstring
                    hide(arg2, arg3, arg4);
                }
            }
            else if (arg1.equals("E")){
                // Extract bitstring from text   
                retrieve(arg2);   
            }
            else {
                err = true; System.out.printf("Err3");
            }
        }
        else {
            err = true; System.out.printf("Err4");
        }
        
        if (err == true) {
            System.out.println();
            System.out.println("Use: Stegano1 <A:E><Input File><OutputFile><Bitstring>");
            System.out.println("Example: Stegano1 A inp.txt out.txt 0010101");
            System.out.println("Example: Stegano1 E inp.txt");
            
        } 
    }
    
    static void hide(String inpFile, String outFile, String binString) {
        // 
        BufferedReader reader;
        BufferedWriter writer;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            writer = new BufferedWriter(new FileWriter(outFile));
            String line = reader.readLine();

            int strIndex = 0;

            // add padding bit to ensure string is even
            if ((binString.length() % 2) != 0)  {
                binString += "0";
            }

            char[] strArray = binString.toCharArray();

            while (line != null && strIndex < strArray.length) {

                // add the first bit to the end of the line

                if (strArray[strIndex] == '0') {
                    line += " ";
                }

                else if (strArray[strIndex] == '1') {
                    line += "  ";
                }
                strIndex++;

                // add the second bit to the end of the line

                if (strArray[strIndex] == '0') {
                    line += "\u180E"; // MONGOLIAN VOWEL SEPARATOR
                }

                else if (strArray[strIndex] == '1') {
                    line += "\u3164"; // HANGUL FILLER
                }

                strIndex++;

                // Store amended line in output file
                writer.write(line);
                writer.newLine();


		// read next line
		line = reader.readLine();
            }
            reader.close();
            writer.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
    
    static void retrieve(String inpFile) {
        BufferedReader reader;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            String line = reader.readLine();
            char[] lineArray = line.toCharArray();

            String message = "";
            while (line != null) {

                // identify last 3 characters of line to find hidden text

                char thirdLast = lineArray[(lineArray.length)-3];
                char secondLast = lineArray[(lineArray.length)-2];
                char last = lineArray[(lineArray.length)-1];

                // case 11
                if (thirdLast == ' ' && last == '\u3164')
                {
                    message += "11";
                }

                // case 10
                else if (thirdLast == ' ' && last == '\u180E')
                {
                    message += "10";
                }

                // case 01
                else if (secondLast == ' ' && last == '\u3164')
                {
                    message += "01";
                }

                // case 00
                else if (secondLast == ' ' && last == '\u180E')
                {
                    message += "00";
                }

                // read next line
                line = reader.readLine();
                if (line != null) lineArray = line.toCharArray();

            }

            if(message.length() > 0) {
                System.out.printf("Hidden message found: %s", message);
            }

            reader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
