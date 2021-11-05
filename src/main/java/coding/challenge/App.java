
package coding.challenge;

import coding.challenge.rest.CapitalCityRequest;
import coding.challenge.rest.CapitalCityResponse;

import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new App().playGame();
    }

    private void playGame() {
        boolean quit = false;
        App app = new App();
        while (!quit) {
            quit = isQuit(quit, app);
        }
    }

    private boolean isQuit(boolean quit, App app) {
        int userInput = 0;
        System.out.println("Press 1 to play 2 to quit");
        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();
        } else {
            scanner.next();
        }
        if (userInput == 1) {
            System.out.println(app.promptForInput());
            String countryInput = app.readInput();
            CapitalCityResponse capitalCity = CapitalCityRequest.getInstance(countryInput).getCapitalCity();
            app.outputCapitalCity(capitalCity);
        } else if (userInput == 2) {
            quit = true;
            scanner.close();
            System.out.println("Okay Bye");
        } else System.out.println("Not a valid Entry");
        return quit;
    }

    private void outputCapitalCity(CapitalCityResponse capitalCity) {
        System.out.println(capitalCity);
    }

    public String promptForInput() {
        return "Please enter the full name of the country";
    }

    String readInput() {
        String countryInput = "";
        if (scanner.hasNext()) {
            countryInput = scanner.next();
        }
        System.out.println("You entered " + countryInput);
        return countryInput;
    }
}
