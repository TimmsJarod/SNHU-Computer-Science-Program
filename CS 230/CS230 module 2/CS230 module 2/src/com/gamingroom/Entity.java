public class Entity {

    //local private variables
    private long id;
    private String name;

    //Class constructors
    private Entity() {}
    public Entity(long id, String name)
    {
        this.name = name;
        this.id = id;
    }

    //Accessors to return class variables
    public long getId() {return id;}

    public String getName() {return name;}

    //method to return current entity information
    public String toString()
    {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}
