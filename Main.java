import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Weightlifting Log");
		String command = scanner.nextLine();
		while(!command.equals("close")) {
			switch (command.toLowerCase()) {
				case "workout log":
					System.out.println("Would you like to \"view\" or \"add\" to your log?");
					String workout = scanner.nextLine();
					if(workout.toLowerCase().equals("add")) {
						ArrayList<String> workouts = new ArrayList<String>();
						System.out.print("Please enter the date: ");
						String date = scanner.nextLine();
						workouts.add(date);
						
						String addLift = "";
						while(!addLift.equals("done")) {
							System.out.print("Please enter your log: ");
							addLift = scanner.nextLine();
							workouts.add(addLift);
						}
												
						try {
							FileWriter output = new FileWriter("JournalEntries.txt", true);
							output.write("\n" + "Date: " + workouts.get(0));
							int counter = 1;
							while(counter < workouts.size()-1) {
								output.write("\n" + workouts.get(counter));
								counter++;
							}
							output.write("\n");
							output.close();
							
						} catch (IOException e) {
							System.out.println("Couldn't write to file");
							System.out.println(e);
						}
						
						
					} else {
						try {
							FileReader reader = new FileReader("JournalEntries.txt");
							while(reader.ready()) {
								System.out.print((char)reader.read());
							}
							reader.close();
						} catch (IOException e){
							System.out.println("There was an exception)");
							System.out.println(e);
						}
					}
					break;
				case "weight log":
					System.out.println("Would you like to \"view\" or \"add\" to your log?");
					if(scanner.nextLine().toLowerCase().equals("add")) {
						System.out.print("Please enter the date: ");
						String date = scanner.nextLine();
						System.out.println("");
						System.out.print("Please enter your weight: ");
						String message = scanner.nextLine();
						
						try {
							FileWriter output = new FileWriter("WeightEntries.txt", true);
							output.write("\n" + "Date: " + date);
							output.write("\n" + message);
							output.write("\n");
							output.close();
							
						} catch (IOException e) {
							System.out.println("Couldn't write to file");
							System.out.println(e);
						}
					} else {
						try {
							FileReader reader = new FileReader("WeightEntries.txt");
							while(reader.ready()) {
								System.out.print((char)reader.read());
							}
							reader.close();
						} catch (IOException e){
							System.out.println("There was an exception)");
							System.out.println(e);
						}
					}
					
					break;
				case "workout split":
					System.out.println("Would you like to \"view\", \"add\", or \"remove\" from your split?");
					String splitMessage = scanner.nextLine();
					switch(splitMessage) {
						case("view"):
							try {
								FileReader reader = new FileReader("WorkoutSplit.txt");
								while(reader.ready()) {
									System.out.print((char)reader.read());
								}
								reader.close();
							} catch (IOException e){
								System.out.println("There was an exception)");
								System.out.println(e);
							}
							break;
					}
					break;
					
				default:
					System.out.println("Invalid Command");
			}
			command = scanner.nextLine();
		}
		scanner.close();
		
	}

}
