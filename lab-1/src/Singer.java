// Voltaire A. Rono
// 301276375

public class Singer {
    // Instance variables
    private int id;
    private String name;
    private String address;
    private String dateOfBirth;
    private int numberOfAlbums;

    // Constructors
    public Singer() {
        // Default constructor with no arguments
    }

    public Singer(int id) {
        this.id = id;
    }

    public Singer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Singer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Singer(int id, String name, String address, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public Singer(int id, String name, String address, String dateOfBirth, int numberOfAlbums) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }

    // Getter and Setter methods for the instance variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumberOfAlbums() {
        return numberOfAlbums;
    }
    public void setNumberOfAlbums(int numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }
}
