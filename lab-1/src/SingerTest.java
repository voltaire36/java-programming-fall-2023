// Voltaire A. Rono
// 301276375


public class SingerTest {
    public static void main(String[] args) {
        // Create a Singer object using the no-argument constructor
        Singer singer1 = new Singer();

        // Display the default values
        System.out.println("Default Values for singer1:");
        System.out.println("ID: " + singer1.getId());
        System.out.println("Name: " + singer1.getName());
        System.out.println("Address: " + singer1.getAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("Number of Albums: " + singer1.getNumberOfAlbums());

        // Set values using setter methods
        singer1.setId(1);
        singer1.setName("Voltaire Rono");
        singer1.setAddress("96 Hummingbird");
        singer1.setDateOfBirth("1995-06-01");
        singer1.setNumberOfAlbums(5);

        // Display the updated values
        System.out.println("\nUpdated Values for singer1:");
        System.out.println("ID: " + singer1.getId());
        System.out.println("Name: " + singer1.getName());
        System.out.println("Address: " + singer1.getAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("Number of Albums: " + singer1.getNumberOfAlbums());

        // Create a Singer object using the no-argument constructor
        Singer singer2 = new Singer();

        // Display the default values
        System.out.println("Default Values for singer1:");
        System.out.println("ID: " + singer2.getId());
        System.out.println("Name: " + singer2.getName());
        System.out.println("Address: " + singer2.getAddress());
        System.out.println("Date of Birth: " + singer2.getDateOfBirth());
        System.out.println("Number of Albums: " + singer2.getNumberOfAlbums());

        // Set values using setter methods
        singer2.setId(2);
        singer2.setName("Taylor Swift");
        singer2.setAddress("718 Thompson Lane, Ste 108256");
        singer2.setDateOfBirth("1989-12-13");
        singer2.setNumberOfAlbums(10);

        // Display the updated values
        System.out.println("\nUpdated Values for singer1:");
        System.out.println("ID: " + singer2.getId());
        System.out.println("Name: " + singer2.getName());
        System.out.println("Address: " + singer2.getAddress());
        System.out.println("Date of Birth: " + singer2.getDateOfBirth());
        System.out.println("Number of Albums: " + singer2.getNumberOfAlbums());

        // Create a Singer object using the no-argument constructor
        Singer singer3 = new Singer();

        // Set values using setter methods
        singer1.setId(3);
        singer1.setName("No Album Dummy");
        singer1.setAddress("Anywhere");
        singer1.setDateOfBirth("-06-01");

        // Display the updated values
        System.out.println("\nUpdated Values for singer1:");
        System.out.println("ID: " + singer1.getId());
        System.out.println("Name: " + singer1.getName());
        System.out.println("Address: " + singer1.getAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
    }
}
