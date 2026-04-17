package Backend;

public class Amenity implements Manageable{
    private String name;

    public Amenity(String name) {

        setName(name);
        Database.addAmenity(this);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Amenity name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() { return name; }

    public void add(){
        Database.addAmenity(this);
    };
    public void delete(){
        Database.getAmenities().remove(this);
    };
    public void read(){
        System.out.println("Name: " + getName());
    };
    public void update(Manageable M){
        this.setName( ((Amenity)M).getName());
    };
}