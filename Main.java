import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login userLogin = new Login();

        System.out.println("=== USER REGISTRATION ===");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        userLogin.setFirstName(firstName);

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        userLogin.setLastName(lastName);

        String username;
        while (true) {
            System.out.print("Enter Username: ");
            username = scanner.nextLine();
            if (userLogin.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        String password;
        while (true) {
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
            if (userLogin.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        String cellPhone;
        while (true) {
            System.out.print("Enter South African Cell Phone Number (e.g., +27838968976): ");
            cellPhone = scanner.nextLine();
            if (userLogin.checkCellPhoneNumber(cellPhone)) {
                System.out.println("Cell number successfully captured.");
                break;
            } else {
                System.out.println("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
            }
        }

        // Register the user details in the system
        userLogin.registerUser(username, password, cellPhone);
        System.out.println("\nRegistration Completed Successfully!\n");

        System.out.println("=== USER LOGIN ===");
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter Username: ");
            String loginUser = scanner.nextLine();

            System.out.print("Enter Password: ");
            String loginPass = scanner.nextLine();

            loggedIn = userLogin.loginUser(loginUser, loginPass);
            System.out.println(userLogin.returnLoginStatus(loggedIn));
        }

        scanner.close();
    }
}
