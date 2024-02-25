import java.util.Scanner;
public class Main {

    public static double distance(double latitude1, double latitude2, double longitude1,
                                  double longitude2) {
        double latDistance = Math.toRadians(latitude2 - latitude1);
        double lonDistance = Math.toRadians(longitude2 - longitude1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = 6378 * c * 0.621371;
        return Math.sqrt(distance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the latitude and longitude of the first point (in degrees):");
        System.out.print("Latitude: ");
        double lat1 = scanner.nextDouble();
        System.out.print("Longitude: ");
        double lon1 = scanner.nextDouble();

        System.out.println(" ");
        System.out.println("Enter the latitude and longitude of the second point (in degrees):");
        System.out.print("Latitude: ");
        double lat2 = scanner.nextDouble();
        System.out.print("Longitude: ");
        double lon2 = scanner.nextDouble();

        double distance = distance(lat1, lon1, lat2, lon2);
        double timePlane = distance / 500;
        double timePlanecom = distance / 480;
        double timebus = distance / 55;
        double timecar = distance / 60;
        double timerail = distance / 80;

        double Co2emissionsPlane = distance * 1.36078;
        double Co2emissionsPlanecom = distance * 0.299;
        double Co2emissionsbus = distance * 0.10;
        double Co2emissionscar = distance * 0.19;
        double Co2emissionsrail = distance * 0.006;

        System.out.println(" ");
        System.out.println("Distance between the two points: " + distance + " miles");
        System.out.println(" ");
        System.out.println("Time taken to fly between the two points at 500 miles per hour in a private plane: " + timePlane + " hours");
        System.out.println("Co2 emissions between the two points at 500 miles per hour in a private plane: " + Co2emissionsPlane + " kilograms of Co2 emissions");

        System.out.println(" ");
        System.out.println("Time taken to fly between the two points at 480 miles per hour in a commercial plane: " + timePlanecom + " hours");
        System.out.println("Co2 emissions between the two points at 480 miles per hour in a commercial plane: " + Co2emissionsPlanecom + " kilograms of Co2 emissions");

        System.out.println(" ");
        System.out.println("Time taken to drive between the two points at 55 miles per hour in a bus: " + timebus + " hours");
        System.out.println("Co2 emissions between the two points at 55 miles per hour in a bus: " + Co2emissionsbus + " kilograms of Co2 emissions");

        System.out.println(" ");
        System.out.println("Time taken to drive between the two points at 60 miles per hour in a car: " + timecar + " hours");
        System.out.println("Co2 emissions between the two points at 60 miles per hour in a car: " + Co2emissionscar + " kilograms of Co2 emissions");

        System.out.println(" ");
        System.out.println("Time taken to ride between the two points at 80 miles per hour on a train " + timerail + " hours");
        System.out.println("Co2 emissions between the two points at 80 miles per hour on a train: " + Co2emissionsrail + " kilograms of Co2 emissions");

        scanner.close();
    }
}
