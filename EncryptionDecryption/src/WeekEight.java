import java.util.*;

public class WeekEight {
    private static final Scanner scnr = new Scanner(System.in);

    public static void main (String[] args){
        String userInput = "";

        while (!userInput.equalsIgnoreCase("q")) {
            System.out.println("Make a selection: \n[E]ncrypt\n[D]ecrypt\n[Q]uit");
            userInput = scnr.next();
            switch (userInput.toLowerCase()) {
                case "e":
                    encryptMsg();
                    break;
                case "d":
                    decryptMsg();
                    break;
                default:
                    System.out.println("Invalid entry. Please try again.");
                    break;
            }
        }
        System.out.print("Good bye.");
    }
    public static void encryptMsg() {
        String encryptionString;
        int encryptedChar;
        int i;

        System.out.println("What is your message?");
        encryptionString = scnr.nextLine();
        encryptionString += scnr.nextLine();

        for (i=0 ; i < encryptionString.toUpperCase().length(); i++ ){
            try {
                if (encryptionString.charAt(i) != ' ') {
                    int encryptionValue;
                    Hashtable<Character, Integer> assocValue = new Hashtable<>();

                    assocValue.put('A', 1);
                    assocValue.put('B', 2);
                    assocValue.put('C', 3);
                    assocValue.put('D', 4);
                    assocValue.put('E', 5);
                    assocValue.put('F', 6);
                    assocValue.put('G', 7);
                    assocValue.put('H', 8);
                    assocValue.put('I', 9);
                    assocValue.put('J', 10);
                    assocValue.put('K', 11);
                    assocValue.put('L', 12);
                    assocValue.put('M', 13);
                    assocValue.put('N', 14);
                    assocValue.put('O', 15);
                    assocValue.put('P', 16);
                    assocValue.put('Q', 17);
                    assocValue.put('R', 18);
                    assocValue.put('S', 19);
                    assocValue.put('T', 20);
                    assocValue.put('U', 21);
                    assocValue.put('V', 22);
                    assocValue.put('W', 23);
                    assocValue.put('X', 24);
                    assocValue.put('Y', 25);
                    assocValue.put('Z', 26);
                    assocValue.put('.', 27);
                    assocValue.put(' ', 32);

                    encryptionValue = assocValue.get(encryptionString.toUpperCase().charAt(i));
                    encryptedChar = (int) (Math.pow(encryptionValue, 3) % 33);


                    System.out.printf("%02d" + " ", encryptedChar);
                } else if (encryptionString.charAt(i) == ' ') {
                    System.out.print("32" + " ");
                }
            }catch(Exception dec){
                System.out.println("There was an error somewhere in your entry. encryption supports alphas <A-Z> and periods<.>");
                break;
            }
        }
        System.out.println(); //DELETE ME MAYBE

    }
    public static void decryptMsg() {
        int i;
        String decryptionString;
        String[] inputList;

        System.out.println("What would you like to decrypt?");
        decryptionString = scnr.nextLine();
        decryptionString += scnr.nextLine();

        inputList = decryptionString.split(" ");


        for (i = 0; i < inputList.length; i++) {
            try {
                if (!(inputList[i].equals("32"))) {
                    char decryptionKey;

                    Hashtable<Integer, Character> assocValue = new Hashtable<>();

                    assocValue.put(1, 'A');
                    assocValue.put(2, 'B');
                    assocValue.put(3, 'C');
                    assocValue.put(4, 'D');
                    assocValue.put(5, 'E');
                    assocValue.put(6, 'F');
                    assocValue.put(7, 'G');
                    assocValue.put(8, 'H');
                    assocValue.put(9, 'I');
                    assocValue.put(10, 'J');
                    assocValue.put(11, 'K');
                    assocValue.put(12, 'L');
                    assocValue.put(13, 'M');
                    assocValue.put(14, 'N');
                    assocValue.put(15, 'O');
                    assocValue.put(16, 'P');
                    assocValue.put(17, 'Q');
                    assocValue.put(18, 'R');
                    assocValue.put(19, 'S');
                    assocValue.put(20, 'T');
                    assocValue.put(21, 'U');
                    assocValue.put(22, 'V');
                    assocValue.put(23, 'W');
                    assocValue.put(24, 'X');
                    assocValue.put(25, 'Y');
                    assocValue.put(26, 'Z');
                    assocValue.put(27, '.');
                    assocValue.put(32, ' ');

                    int decryptedVal = (int) (Math.pow(Integer.parseInt(inputList[i]), 7) % 33);
                    decryptionKey = assocValue.get(decryptedVal);

                    System.out.print(decryptionKey);
                } else if ((inputList[i].equals("32"))) {
                    System.out.print(" ");
                }
            }catch (Exception enc){
                System.out.println("There was an error somewhere in your entry. Entry may not be using the proper encryption.");
                break;
            }


        }
        System.out.println();
    }
}
