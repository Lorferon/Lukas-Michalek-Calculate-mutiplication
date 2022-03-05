import java.math.BigInteger;

public class multiply {

    // ::::::::::::::::::::::  VERSION "FROM SCRATCH" - WITHOUT USING BIGINTEGER CLASS :::::::::::::::::::::::::::::

    public static String multiplyStrings(String number1, String number2){

        int number1Length = number1.length();
        int number2Length = number2.length();

        if(number1Length == 0 || number2Length == 0)
            return "0";

        int result[] = new int[number1Length + number2Length];  // FINAL RESULT WILL BE STORED HERE BUT IN REVERSED ORDER

        int indexNo1 = 0;   // INDEXES FOR EACH NUMBER TO FIND CORRECT POSITION IN RESULT
        int indexNo2 = 0;

        for(int i = number1Length - 1; i >= 0; i--) {   // MOVING FROM RIGHT TO LEFT IN NUMBER 1

            int carry = 0;                          // CARRY FOR NUMBERS > 9
            int no1 = number1.charAt(i) - '0';      // CURRENT DIGIT OF THE FIRST NUMBER

            indexNo2 = 0;       // SHIFT POSITION TO LEFT AFTER EVERY MULTIPLICATION OF A DIGIT IN NUM 2

            for (int j = number2Length - 1; j >= 0; j--) {  // MOVING FROM RIGHT TO LEFT IN NUMBER 2

                int no2 = number2.charAt(j) - '0';      // CURRENT DIGIT OF THE SECOND NUMBER

                int sum = no1 * no2 + result[indexNo1 + indexNo2] + carry;

                // MULTIPLY WITH CURRENT DIGIT OF THE FIRST NUMBER AND ADD RESULT TO PREVIOUSLY STORED RESULT

                carry = sum / 10;
                result[indexNo1 + indexNo2] = sum % 10;

                indexNo2++;

            }

            if (carry > 0) {        // STORE CARRY IN NEXT CELL
                result[indexNo1 + indexNo2] += carry;
            }
                indexNo1++;     //

        }
        int i = result.length - 1;

        while (i >= 0 && result[i] == 0){       // IGNORING ZEROES FROM RIGHT
            i--;
        }

        if(i == -1){        // IF ONE OR ALL NUMBERS ARE 0 RESULT IS 0

            return "0";
        }

        String finalResult = "";        // FINAL PART WHERE THE RESULT WILL BE SWITCHET FROM REVERSED TO CORRCT ORDER

        while (i >= 0){
            finalResult += (result[i--]);

        }

        return finalResult;
    }

    // :::::::::::::::::::::::::::::::::: SOLUTION WHERE I USE "BIGINTEGER CLASS"  :::::::::::::::::::::::::::

    public static String multiplyBigClass(String number1, String number2){

        BigInteger sum;

        BigInteger a = new BigInteger(number1);
        BigInteger b = new BigInteger(number2);

        sum = a.multiply(b);

        String finalSum = sum.toString();

        return finalSum;


    }


    public static void main(String [] args){

        if(args[0].equals("alg1")) {        // FIRST VERSION BY USING BIGINTEGER CLASS

            System.out.println(multiplyBigClass(args[1], args[2]));
        }

         else if(args[0].equals("alg2")){       // VERSION USING STRING MULTIPLICATION WITHOU BIGINTEGER CLASS

            System.out.println(multiplyStrings(args[1], args[2]));

        }

         else if(args[0].equals("unittest")){       // UNITTEST TO TEST BOTH VERSIONS

             String alg1 = multiplyBigClass(args[1], args[2]);

             String alg2 = multiplyStrings(args[1], args[2]);

             if(alg1.equals(alg2)){
                 System.out.println("Solution by using BigInteger class is: " + alg1);
                 System.out.println("Solution by using String Multiplication is: " + alg2);

                 System.out.println("Both solutions(Algorithms) are equal");
             }
             else{
                 System.out.println("Solution by using BigInteger class is: " + alg1);
                 System.out.println("Solution by using String Multiplication is: " + alg2);
                 System.out.println("Solutions(Algorithms) are not equal");
             }


        }

        else{
            System.out.println("Please enter alg1 or alg2 for your desired implementation");
        }
    }
}
