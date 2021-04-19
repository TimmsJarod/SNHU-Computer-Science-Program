import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    //Initialized array list for test monkeys
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    //scanner object for user inputs
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();
        String menuChoice = ""; //Variable for storing user choice

        //Menu method is called for user interaction. A switch statement executes the desired function.
        while (!menuChoice.equalsIgnoreCase("q")) {
            displayMenu();
            menuChoice = scnr.nextLine();
            switch (menuChoice) {
                case "1":
                    intakeNewDog(scnr);
                    break;
                case "2":
                    intakeNewMonkey(scnr);
                    break;
                case "3":
                    reserveAnimal(scnr);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("all");
                    break;
                default:
                    if (!menuChoice.equalsIgnoreCase("q")) { //If input is invalid. returns menu.
                        System.out.print("\nInvalid entry, please try again. Enter 1-6 or q to quit.");
                    }
                    break;

            }
        }
        System.out.println("Goodbye.");
    }

    // For the project submission you must also include input validation
    // and appropriate feedback to the user.
    // Hint: create a Scanner and pass it to the necessary
    // methods
    // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", true, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("George", "1", "2", "3", "Capuchin", "Male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Monkey monkey2 = new Monkey("Jo Young", "0", "100", "100", "Marmoset", "Male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Monkey monkey3 = new Monkey("Jarod", "0", "6", "6", "Squirrel Monkey", "Male", "4", "25.6", "12-10-2021", "Canada", "in service", false, "Canada");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        boolean reservedDogBool;
        //checks to see if name is already in list of dogs.
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        //collects user input for dog list.
        System.out.println("What is the new dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the new dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("How old is the new dog?");
        String age = scanner.nextLine();
        System.out.println("What is the new dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("When was the new dog acquired?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What country was the new dog acquired in?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the new dog's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the new dog reserved? \n<Enter true or false>");
        String reservedString = scanner.nextLine();
        System.out.println("Where is the new dog in service?");
        String inServiceCountry = scanner.nextLine();

        //elif statement converts user input into boolean.
        reservedDogBool = reservedString.equalsIgnoreCase("true");

        //Monkey variables added to new dog object.
        Dog dog = new Dog( name, breed, gender, age,
                 weight, acquisitionDate, acquisitionCountry,
                 trainingStatus, reservedDogBool, inServiceCountry);

        //New dog added to list of dogs.
        dogList.add(dog);

        // Add the code to instantiate a new dog and add it to the appropriate list
    }

    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        //temporary variable for entering boolean into monkey object.
        boolean reservedMonkeyBool = false;

        System.out.println("What is the new monkey's name?");
        String name = scanner.nextLine();
        //checks to see if monkey already exists in list.
        for (Monkey existMonkey : monkeyList) {
            if (existMonkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is the new monkey's tail length?");
        String tailLength = scanner.nextLine();
        System.out.println("What is the new monkey's height?");
        String height = scanner.nextLine();
        System.out.println("What is the new monkey's body length?");
        String bodyLength = scanner.nextLine();
        System.out.println("What is the species of the new monkey?");
        String species = scanner.nextLine();
        //Switch statement allows for validation of input species.
        switch (species.toLowerCase()) {
            case "capuchin":
            case "marmoset":
            case "tamarin":
            case "macaque":
            case "guenon":
            case "squirrel monkey":
                break;
            default:
                System.out.println("Sorry. This species is not supported in the program or entry is misspelled.");
                return;
        }
        System.out.println("What is the new monkey's gender?");
        String gender = scanner.nextLine();
        System.out.println("How old is the new monkey?");
        String age = scanner.nextLine();
        System.out.println("What is the new monkey's weight?");
        String weight = scanner.nextLine();
        System.out.println("When was the new monkey acquired?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What country was the new monkey acquired in?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the new monkey's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the new monkey reserved? \n<Enter true or false>");
        String reservedString = scanner.nextLine();
        System.out.println("Where is the new monkey in service?");
        String inServiceCountry = scanner.nextLine();

        //elif statement converts user input into boolean.
        reservedMonkeyBool = reservedString.equalsIgnoreCase("true");


        //Monkey variables added to new monkey object.
        Monkey monkey = new Monkey(name, tailLength, height, bodyLength, species, gender, age, weight,
                acquisitionDate, acquisitionCountry, trainingStatus, reservedMonkeyBool, inServiceCountry);

        //New monkey added to list of monkeys.
        monkeyList.add(monkey);
    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        String animalType;
        String animalCountry;

        //Requests input from the user of what animal the would like to reserve and hands that off to the elif.
        System.out.println("What type of animal would you like reserve?: \n<Dog, Monkey>");
        animalType = scnr.nextLine();
        System.out.println("What country would you like to reserve from?");
        animalCountry = scnr.nextLine();

        //Checks user input and executes desired animal type or rejects input.
            //each selection looks through available animals to find animal that meets both criteria and if that
            //animal is available for reservation, otherwise the request is rejected.
        if (animalType.equalsIgnoreCase("dog")) {

            for (Dog dog : dogList) {
                if (dog.getInServiceLocation().equalsIgnoreCase(animalCountry) && !dog.getReserved()) {
                    dog.setReserved(true);
                    System.out.println(dog.getName() + " was reserved!");
                    return;
                }
            }
            System.out.println("Sorry, there are no animals that meet that criteria.");
        }
        else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(animalCountry) && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    System.out.println(monkey.getName() + " was reserved!");
                    return;
                }
            }
            System.out.println("Sorry, there are no animals that meet that criteria.");
        }
        else {
            System.out.println("There are no available animals that meet this criteria.");
        }
    }

    /*The displayMenu method runs different strings through printAnimals depending on user input.
    contextually sensitive elif statements sort out the available to reserve animals while the
    method also prints the full lists of animals, depending on user input through displayMenu.*/
    public static void printAnimals(String userInput) {
        //Switch takes user input and outputs which animal to list. the result then displays the available animals.
        switch (userInput) {
            case "dog":
                System.out.println("\tBehold. All dogs registered!");
                for (Dog dog : dogList) {
                    System.out.print("Name: " + dog.getName() + ", Status: " + dog.getTrainingStatus() + ", Origin: " + dog.getAcquisitionLocation() + ", Reserved: ");
                    if (!dog.getReserved()){System.out.print("Available\n");}
                    else{System.out.print("Reserved\n");}
                }

                //elif statement verifies any animals that are "in service" and not reserved.
                System.out.println("\n\tThese Dogs are in service and available for reservation.");
                for (Dog dog : dogList) {
                    if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service")) {
                        System.out.print("Name: " + dog.getName() + ", Origin: " + dog.getAcquisitionLocation() + ", Reservation: ");
                        if (!dog.getReserved()){System.out.println("Available");}
                        else{System.out.println("Reserved");}
                    }

                }
                break;
            case "monkey":
                System.out.println("\tBehold. All monkeys registered!");
                for (Monkey monkey : monkeyList) {
                    System.out.print("Name: " + monkey.getName() + ", Status: " + monkey.getTrainingStatus() + ", Origin: " + monkey.getAcquisitionLocation() + ", Reserved: ");
                    if (!monkey.getReserved()){System.out.print("Available");}
                    else{System.out.print("Reserved");}
                }

                System.out.println("\n\tThese monkeys are in service and available for reservation.");
                for (Monkey monkey : monkeyList) {
                    if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
                        System.out.print("Name: " + monkey.getName() + ", Origin: " + monkey.getAcquisitionLocation() + ", Reserved: ");
                        if (!monkey.getReserved()){System.out.println("Available");}
                        else{System.out.println("Reserved");}
                    }
                }
                break;
            case "all":
                System.out.println("\tBehold. All animals registered!");
                for (Dog dog : dogList) {
                    System.out.print("Name: " + dog.getName() + ", Status: " + dog.getTrainingStatus() + ", Origin: " + dog.getAcquisitionLocation() + ", Reserved: ");
                    if (!dog.getReserved()){System.out.print("Available\n");}
                    else{System.out.print("Reserved\n");}
                }
                for (Monkey monkey : monkeyList) {
                    System.out.print("Name: " + monkey.getName() + ", Status: " + monkey.getTrainingStatus() + ", Origin: " + monkey.getAcquisitionLocation() + ", Reserved: ");
                    if (!monkey.getReserved()){System.out.print("Available\n");}
                    else{System.out.print("Reserved\n");}
                }

                System.out.println("\n\tThese animals are in service and available for reservation.");
                for (Dog dog : dogList) {
                    if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service")) {
                        System.out.print("Name: " + dog.getName() + ", Origin: " + dog.getAcquisitionLocation() + ", Reservation: ");
                        if (!dog.getReserved()){System.out.println("Available");}
                        else{System.out.println("Reserved");}
                    }
                }
                for (Monkey monkey : monkeyList) {
                    if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
                        System.out.print("Name: " + monkey.getName() + ", Origin: " + monkey.getAcquisitionLocation() + ", Reserved: ");
                        if (!monkey.getReserved()){System.out.println("Available");}
                        else{System.out.println("Reserved");}
                    }
                }
                break;
            }
        }
    }


