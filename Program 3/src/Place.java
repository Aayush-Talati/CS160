/**
 *  Program 3B
 *  Writing this program to learn
 *  how to make classes use other classes
 *  CS160-section 1
 *  2/14/2024
 *  @author  Aayush Talati
 */
public class Place {
    public String name;
    public String description;
    public Location location;

    public Place(String name, String description, double latitude, double longitude) {
        location = new Location();
        this.name = name;
        this.description = description;
        location.setLatitude(latitude);
        location.setLongitude(longitude);
    }
    public Place() {
        location = new Location();
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void setLocation(double latitude, double longitude) {
        location.setLatitude(latitude);
        location.setLongitude(longitude);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String toString() {
        return name + "," + description +  ",latitude:" + location.getLatitude() + ",longitude:" + location.getLongitude();
    }
    public String getID() {
        return "Program 3b, Aayush Talati";
    }
}
