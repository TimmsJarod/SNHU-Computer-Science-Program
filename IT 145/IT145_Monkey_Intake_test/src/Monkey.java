public class Monkey extends RescueAnimal{ //extends RescueAnimal to inherit methods and variables.
    //Variables Monkey class.
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    //Enters the Monkey constructor based off inputs made by the user in the Drive class.
    public Monkey(String name, String tailLength, String height, String bodyLength, String species, String gender, String age,
               String weight, String acquisitionDate, String acquisitionCountry,
               String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }
    //Enters the Monkey specific accessors and mutators
    public void setTailLength(String inputLength){
       tailLength = inputLength;
    }
    public String getTailLength () {
        return tailLength;
    }

    public void setHeight (String inputHeight){
        height = inputHeight;
    }
    public String getHeight () {
        return height;
    }

    public void setBodyLength (String inputBodyLength ){
        bodyLength = inputBodyLength;
    }
    public String getBodyLength () {
        return bodyLength;
    }

    public void setSpecies (String inputSpecies){
        species = inputSpecies;
    }
    public String getSpecies () {
        return species;
    }
}