import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	class Citation {
	    LocalDate date;
	    int offenseCode;
	    double amount;
	    String status;
	    Registration registration;

	    Citation(LocalDate date, int offenseCode, double amount, String status, Registration registration) {
	        this.date = date;
	        this.offenseCode = offenseCode;
	        this.amount = amount;
	        this.status = status;
	        this.registration = registration;
	    }

	    @Override
	    public String toString() {
	        return "Citation{" +
	                "date=" + date +
	                ", offenseCode=" + offenseCode +
	                ", amount=" + String.format("%.2f", amount) +
	                ", status='" + status + '\'' +
	                '}';
	    }
	}

	// Registration class
	class Registration {
	    int uniqueID;
	    LocalDate startDate;
	    LocalDate endDate;
	    Owner owner;
	    Vehicle vehicle;
	    String plate;

	    Registration(int uniqueID, LocalDate startDate, LocalDate endDate, Owner owner, Vehicle vehicle, String plate) {
	        this.uniqueID = uniqueID;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.owner = owner;
	        this.vehicle = vehicle;
	        this.plate = plate;
	    }

	    @Override
	    public String toString() {
	        return "Registration{" +
	                "uniqueID=" + uniqueID +
	                ", startDate=" + startDate +
	                ", endDate=" + endDate +
	                ", owner=" + owner +
	                ", vehicle=" + vehicle +
	                ", plate='" + plate + '\'' +
	                '}';
	    }
	}

	// Owner class
	class Owner {
	    String firstName;
	    String lastName;
	    String address;
	    String city;
	    String state;
	    int zipCode;

	    Owner(String firstName, String lastName, String address, String city, String state, int zipCode) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.address = address;
	        this.city = city;
	        this.state = state;
	        this.zipCode = zipCode;
	    }

	    @Override
	    public String toString() {
	        return "Owner{" +
	                "firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", address='" + address + '\'' +
	                ", city='" + city + '\'' +
	                ", state='" + state + '\'' +
	                ", zipCode=" + zipCode +
	                '}';
	    }
	}

	// Vehicle class
	class Vehicle {
	    String vin;
	    LocalDate dateOfMfg;
	    String make;
	    String model;
	    String color;
	    int numberOfDoors;

	    Vehicle(String vin, LocalDate dateOfMfg, String make, String model, String color, int numberOfDoors) {
	        this.vin = vin;
	        this.dateOfMfg = dateOfMfg;
	        this.make = make;
	        this.model = model;
	        this.color = color;
	        this.numberOfDoors = numberOfDoors;
	    }

	    @Override
	    public String toString() {
	        return "Vehicle{" +
	                "vin='" + vin + '\'' +
	                ", dateOfMfg=" + dateOfMfg +
	                ", make='" + make + '\'' +
	                ", model='" + model + '\'' +
	                ", color='" + color + '\'' +
	                ", numberOfDoors=" + numberOfDoors +
	                '}';
	    }
	}

	// DMV class
	public class DMV {
	    private static List<Registration> registrations = new ArrayList<>();
	    private static List<Citation> citations = new ArrayList<>();
	    private static List<Vehicle> vehicles = new ArrayList<>();
	    private static List<Owner> owners = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	  public static void main(String[] args) {
	    int choice;
	    do {
	        displayMenu();
	        String input = scanner.nextLine(); // Read the entire line as a String
	        if (!input.isEmpty() && input.matches("\\d+")) { // Check if the input is not empty and contains only digits
	            choice = Integer.parseInt(input);
	            handleChoice(choice);
	        } else {
	            System.out.println("Invalid input. Please enter a valid choice.");
	            choice = 0; // Set choice to an invalid value to continue the loop
	        }
	    } while (choice != 9);
	}

	    private static void displayMenu() {
	        System.out.println("1. Register Vehicle");
	        System.out.println("2. Register Citation");
	        System.out.println("3. List All Registrations");
	        System.out.println("4. List All Citations");
	        System.out.println("5. List all Registrations for a vehicle");
	        System.out.println("6. List all Registrations for a person");
	        System.out.println("7. List all Citations for a vehicle");
	        System.out.println("8. List all Citations for a person");
	        System.out.println("9. Exit");
	        System.out.print("Enter your choice: ");
	    }

	    private static void handleChoice(int choice) {
	        switch (choice) {
	            case 1:
	                registerVehicle();
	                break;
	            case 2:
	                registerCitation();
	                break;
	            case 3:
	                listAllRegistrations();
	                break;
	            case 4:
	                listAllCitations();
	                break;
	            case 5:
	                listRegistrationsForVehicle();
	                break;
	            case 6:
	                listRegistrationsForPerson();
	                break;
	            case 7:
	                listCitationsForVehicle();
	                break;
	            case 8:
	                listCitationsForPerson();
	                break;
	            case 9:
	                System.out.println("Exiting program...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }

	    private static void registerVehicle() {
	        System.out.print("Enter Vehicle VIN: ");
	        String vin = scanner.nextLine();
	        System.out.print("Enter Vehicle Make: ");
	        String make = scanner.nextLine();
	        System.out.print("Enter Vehicle Model: ");
	        String model = scanner.nextLine();
	        System.out.print("Enter Vehicle Color: ");
	        String color = scanner.nextLine();
	        System.out.print("Enter Number of Doors: ");
	        int numberOfDoors = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character

	        System.out.print("Enter Owner First Name: ");
	        String firstName = scanner.nextLine();
	        System.out.print("Enter Owner Last Name: ");
	        String lastName = scanner.nextLine();
	        System.out.print("Enter Owner Address: ");
	        String address = scanner.nextLine();
	        System.out.print("Enter Owner City: ");
	        String city = scanner.nextLine();
	        System.out.print("Enter Owner State: ");
	        String state = scanner.nextLine();
	        System.out.print("Enter Owner Zip Code: ");
	        int zipCode = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character

	        System.out.print("Enter Registration Start Date (yyyy-MM-dd): ");
	        LocalDate startDate = LocalDate.parse(scanner.nextLine());
	        System.out.print("Enter Registration End Date (yyyy-MM-dd): ");
	        LocalDate endDate = LocalDate.parse(scanner.nextLine());
	        System.out.print("Enter License Plate: ");
	        String plate = scanner.nextLine();

	        Vehicle vehicle = new Vehicle(vin, LocalDate.now(), make, model, color, numberOfDoors);
	        Owner owner = new Owner(firstName, lastName, address, city, state, zipCode);
	        Registration registration = new Registration(registrations.size() + 1, startDate, endDate, owner, vehicle, plate);

	        vehicles.add(vehicle);
	        owners.add(owner);
	        registrations.add(registration);

	        System.out.println("Vehicle registered successfully!");
	    }

	    private static void registerCitation() {
	        System.out.print("Enter Vehicle License Plate: ");
	        String plate = scanner.nextLine();

	        Registration registration = findRegistrationByPlate(plate);
	        if (registration == null) {
	            System.out.println("No registration found for the given license plate.");
	            return;
	        }

	        System.out.print("Enter Offense Code: ");
	        int offenseCode = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character
	        System.out.print("Enter Citation Amount: ");
	        double amount = scanner.nextDouble();
	        scanner.nextLine(); // Consume the newline character
	        System.out.print("Enter Citation Status: ");
	        String status = scanner.nextLine();

	        Citation citation = new Citation(LocalDate.now(), offenseCode, amount, status, registration);
	        citations.add(citation);

	        System.out.println("Citation registered successfully!");
	    }

	    private static void listAllRegistrations() {
	        if (registrations.isEmpty()) {
	            System.out.println("No registrations found.");
	        } else {
	            System.out.println("All Registrations:");
	            for (Registration registration : registrations) {
	                System.out.println(registration);
	            }
	        }
	    }

	    private static void listAllCitations() {
	        if (citations.isEmpty()) {
	            System.out.println("No citations found.");
	        } else {
	            System.out.println("All Citations:");
	            for (Citation citation : citations) {
	                System.out.println(citation);
	            }
	        }
	    }

	    private static void listRegistrationsForVehicle() {
	        System.out.print("Enter Vehicle License Plate: ");
	        String plate = scanner.nextLine();

	        List<Registration> vehicleRegistrations = findRegistrationsByPlate(plate);
	        if (vehicleRegistrations.isEmpty()) {
	            System.out.println("No registrations found for the given license plate.");
	        } else {
	            System.out.println("Registrations for Vehicle (" + plate + "):");
	            for (Registration registration : vehicleRegistrations) {
	                System.out.println(registration);
	            }
	        }
	    }

	    private static void listRegistrationsForPerson() {
	        System.out.print("Enter Owner First Name: ");
	        String firstName = scanner.nextLine();
	        System.out.print("Enter Owner Last Name: ");
	        String lastName = scanner.nextLine();

	        List<Registration> ownerRegistrations = findRegistrationsByOwner(firstName, lastName);
	        if (ownerRegistrations.isEmpty()) {
	            System.out.println("No registrations found for the given owner.");
	        } else {
	            System.out.println("Registrations for Owner (" + firstName + " " + lastName + "):");
	            for (Registration registration : ownerRegistrations) {
	                System.out.println(registration);
	            }
	        }
	    }

	    private static void listCitationsForVehicle() {
	        System.out.print("Enter Vehicle License Plate: ");
	        String plate = scanner.nextLine();

	        List<Citation> vehicleCitations = findCitationsByPlate(plate);
	        if (vehicleCitations.isEmpty()) {
	            System.out.println("No citations found for the given license plate.");
	        } else {
	            System.out.println("Citations for Vehicle (" + plate + "):");
	            for (Citation citation : vehicleCitations) {
	                System.out.println(citation);
	            }
	        }
	    }

	    private static void listCitationsForPerson() {
	        System.out.print("Enter Owner First Name: ");
	        String firstName = scanner.nextLine();
	        System.out.print("Enter Owner Last Name: ");
	        String lastName = scanner.nextLine();

	        List<Citation> ownerCitations = findCitationsByOwner(firstName, lastName);
	        if (ownerCitations.isEmpty()) {
	            System.out.println("No citations found for the given owner.");
	        } else {
	            System.out.println("Citations for Owner (" + firstName + " " + lastName + "):");
	            for (Citation citation : ownerCitations) {
	                System.out.println(citation);
	            }
	        }
	    }

	    private static Registration findRegistrationByPlate(String plate) {
	        for (Registration registration : registrations) {
	            if (registration.plate.equals(plate)) {
	                return registration;
	            }
	        }
	        return null;
	    }

	    private static List<Registration> findRegistrationsByPlate(String plate) {
	        List<Registration> vehicleRegistrations = new ArrayList<>();
	        for (Registration registration : registrations) {
	            if (registration.plate.equals(plate)) {
	                vehicleRegistrations.add(registration);
	            }
	        }
	        return vehicleRegistrations;
	    }

	    private static List<Registration> findRegistrationsByOwner(String firstName, String lastName) {
	        List<Registration> ownerRegistrations = new ArrayList<>();
	        for (Registration registration : registrations) {
	            if (registration.owner.firstName.equals(firstName) && registration.owner.lastName.equals(lastName)) {
	                ownerRegistrations.add(registration);
	            }
	        }
	        return ownerRegistrations;
	    }

	    private static List<Citation> findCitationsByPlate(String plate) {
	        List<Citation> vehicleCitations = new ArrayList<>();
	        for (Citation citation : citations) {
	            if (citation.registration.plate.equals(plate)) {
	                vehicleCitations.add(citation);
	            }
	        }
	        return vehicleCitations;
	    }

	    private static List<Citation> findCitationsByOwner(String firstName, String lastName) {
	        List<Citation> ownerCitations = new ArrayList<>();
	        for (Citation citation : citations) {
	            if (citation.registration.owner.firstName.equals(firstName) && citation.registration.owner.lastName.equals(lastName)) {
	                ownerCitations.add(citation);
	            }
	        }
	        return ownerCitations;
	    }
	}
