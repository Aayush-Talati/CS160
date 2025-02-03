/**
 *  Program 3
 *  Tests the Location.java class
 *  CS160-section 1
 *  2/13/2024
 *  @author  Aayush Talati
 */
public class LocationTester {
    public static void main(String[] args) {
        Location d = new Location();
        System.out.println("Latitude = " + d.getLatitude());
        System.out.println("Longitude = " + d.getLongitude());
        d.setLatitude(45.0);
        d.setLongitude(90.0);
        System.out.println("Latitude = " + d.getLatitude());
        System.out.println("Longitude = " + d.getLongitude());
        Location e = new Location(45.0, 90.0);
        System.out.println("Latitude = " + e.getLatitude());
        System.out.println("Longitude = " + e.getLongitude());
        e.setLatitude(180.0);
        e.setLongitude(270.0);
        System.out.println("Latitude = " + e.getLatitude());
        System.out.println("Longitude = " + e.getLongitude());
        System.out.println(d.distanceFrom(e));

    }
}
