package Backend;

public class RoomType implements Manageable {

    private String name;
    private double pricePerNight;

    public RoomType(String name, double pricePerNight) {
        setName(name);
        setPricePerNight(pricePerNight);
        Database.addRoomType(this);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("RoomType name cannot be empty.");
        }
        this.name = name;
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.pricePerNight = pricePerNight;
    }

    public String getName() {
        return name;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void add(){
        Database.addRoomType(this);
    };

    public void delete(){
        Database.getRoomTypes().remove(this);
    };
    public void read(){
        System.out.println("Room Type Name: " + this.getName());
        System.out.println("Room Type Price: " + this.getPricePerNight());
    };
    public void update(Manageable M){
        this.setName( ((RoomType) M).getName());
        this.setPricePerNight( ((RoomType) M).getPricePerNight());
    };
}
