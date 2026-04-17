package Backend;

public interface Manageable {

    void add();
    void delete();
    void read();
    void update(Manageable M);
}
