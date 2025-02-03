/**
 *  Program 3
 *  Calculates the distance from one place
 *  to another on a sphere
 *  CS160-section 1
 *  2/13/2024
 *  @author  Aayush Talati
 */
public class Location {
    public final double EARTH_RADIUS_MILES = 3693.1576;
    public double latitude;
    public double longitude;

    public Location() {
        latitude = 0;
        longitude = 0;
    }
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public double distanceFrom(Location other) {
        double lat1 = Math.toRadians(latitude);
        double lon1 = Math.toRadians(longitude);
        double lat2 = Math.toRadians(other.getLatitude());
        double lon2 = Math.toRadians(other.getLongitude());
        double cosC = (Math.sin(lat1) * Math.sin(lat2)) + (Math.cos(lat1) * Math.cos(lat2)) * Math.cos(lon1 - lon2);
        double arcLenC = Math.cos(cosC);
        return arcLenC * EARTH_RADIUS_MILES;
    }

    public boolean equals(Location other) {
        if ((getLatitude() * 1000 == other.getLatitude() * 1000) && (getLongitude() * 1000 == other.getLongitude() * 1000)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "latidude:" + getLatitude() + ",longitude:" + getLongitude();
    }

}
