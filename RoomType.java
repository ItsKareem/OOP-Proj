Public class RoomType {
    private int id;
    private String name;
    private double pricePerNight

    public RoomType(int id, String name, double pricePerNight) {
        setId(id);
        setName(name);
        setPricePerNight(pricePerNight);
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("RoomType ID must be positive.");
        }
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}
