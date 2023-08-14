package File;

	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;

	class Student {
		int id;
		String name;
		int[] marks = new int[5];
		int totalMarks;

		void calculateTotalMarks() {
			for (int mark : marks) {
				totalMarks += mark;
			}
		}

		double calculatePercentage() {
			return (double) totalMarks / (5 * 100) * 100;
		}

		int getHighestMark() {
			int highest = marks[0];
			for (int mark : marks) {
				if (mark > highest) {
					highest = mark;
				}
			}
			return highest;
		}

		int getLowestMark() {
			int lowest = marks[0];
			for (int mark : marks) {
				if (mark < lowest) {
					lowest = mark;
				}
			}
			return lowest;
		}
	}

	public class File {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);

			System.out.print("Enter the number of students: ");
			int n = scan.nextInt();

			Student[] students = new Student[n];

			for (int i = 0; i < n; i++) {
				students[i] = new Student();

				System.out.println("Enter details for student " + (i + 1) + ":");
				System.out.print("ID: ");
				students[i].id = scan.nextInt();
				scan.nextLine();
				System.out.print("Name: ");
				students[i].name = scan.nextLine();

				System.out.println("Enter marks for 5 subjects:");
				for (int j = 0; j < 5; j++) {
					System.out.print("Subject " + (j + 1) + ": ");
					students[i].marks[j] = scan.nextInt();
				}

				students[i].calculateTotalMarks();
			}

			try {
				FileWriter fileWriter = new FileWriter("STU.txt");
				for (int i = 0; i < n; i++) {
					fileWriter.write("Id: " + students[i].id + "\n");
					fileWriter.write("Name :" + students[i].name + "\n");
					fileWriter.write("Total Marks: " + students[i].totalMarks + "\n");
					fileWriter.write("Percentage: " + students[i].calculatePercentage() + "%" + "\n");
					fileWriter.write("Highest Mark: " + students[i].getHighestMark() + "\n");
					fileWriter.write("Lowest Mark: " + students[i].getLowestMark() + "\n\n");
				}
				fileWriter.close();
				System.out.println("Student details saved to file.");

			} catch (IOException e) {
				System.out.println("An error occurred while writing to the file.");
				e.printStackTrace();

			}

			try {
				FileReader fileReader = new FileReader("STU.txt");
				Scanner fileScanner = new Scanner(fileReader);
				System.out.println("\nReading from file");
				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					System.out.println(line);
				}

				fileScanner.close();
				fileReader.close();
			} catch (IOException e) {
				System.out.println("An error occurred while reading the file.");
				e.printStackTrace();
			}

			scan.close();
		}
	}

