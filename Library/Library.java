package Library;

import java.util.Scanner;

public class Library {

	String[] bookNames = new String[10];
	String[] authorNames = new String[20];
	int[] availableCopies = new int[10];
	int totalBooks = 0;

	void addBook(String bookName, String authorName, int availableCopies) {
		this.bookNames[totalBooks] = bookName;
		this.authorNames[totalBooks] = authorName;
		this.availableCopies[totalBooks] = availableCopies;
		totalBooks++;
	}

	void searchBookByBookName(String bookName) {
		for (int i = 0; i < totalBooks; i++) {
			if (this.bookNames[i].equalsIgnoreCase(bookName)) {
				System.out.println("Book by name: " + this.bookNames[i]);
				System.out.println("Available copies: " + availableCopies[i]);
				return;
			}
		}
		System.out.println("Book not found.");
	}

	void searchBookByAuthorName(String authorName) {
		for (int i = 0; i < totalBooks; i++) {
			if (this.authorNames[i].equalsIgnoreCase(authorName)) {
				System.out.println("Book by name: " + this.bookNames[i]);
				System.out.println("Author: " + this.authorNames[i]);
				System.out.println("Available copies: " + availableCopies[i]);
				return;
			}
		}
		System.out.println("No books found by author " + authorName + ".");
	}

	void searchBookByBoth(String bookName, String authorName) {
		for (int i = 0; i < totalBooks; i++) {
			if (this.bookNames[i].equalsIgnoreCase(bookName) && this.authorNames[i].equalsIgnoreCase(authorName)) {
				System.out.println("Book by name: " + this.bookNames[i]);
				System.out.println("Author: " + this.authorNames[i]);
				System.out.println("Available copies: " + availableCopies[i]);
				return;
			}
		}
		System.out.println("Book not found.");
	}

	void issueBook(String bookName, int numCopiesToIssue) {
		for (int i = 0; i < totalBooks; i++) {
			if (this.bookNames[i].equalsIgnoreCase(bookName)) {
				if (availableCopies[i] >= numCopiesToIssue) {
					availableCopies[i] -= numCopiesToIssue;
					System.out.println("Issued " + numCopiesToIssue + " copies of " + bookName);
					System.out.println("Available copies: " + availableCopies[i]);
					return;
				} else {
					System.out.println("Not enough copies available.");
					return;
				}
			}
		}
		System.out.println("Book not found.");
	}

	void returnBook(String bookName, int numCopiesToReturn) {
		for (int i = 0; i < totalBooks; i++) {
			if (this.bookNames[i].equalsIgnoreCase(bookName)) {
				availableCopies[i] += numCopiesToReturn;
				System.out.println("Returned " + numCopiesToReturn + " copies of " + bookName);
				System.out.println("Available copies: " + availableCopies[i]);
				return;
			}
		}
		System.out.println("Book not found.");
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Library library = new Library();
		int choice;
		while (true) {
			System.out.println("Select option:");
			System.out.println("1.Add Books");
			System.out.println("2.Search Books by Name");
			System.out.println("3.Search Books by Author");
			System.out.println("4.Search Books by Both Name and Author");
			System.out.println("5.Issue Books");
			System.out.println("6.Return Books");
			System.out.println("7.Exit");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Book Name: ");
				String bookName = scan.next();
				System.out.println("Enter Author Name: ");
				String authorName = scan.next();
				System.out.println("Enter Available Copies: ");
				int availableCopies = scan.nextInt();
				library.addBook(bookName, authorName, availableCopies);
				break;

			case 2:
				System.out.println("Enter Book Name to Search: ");
				String searchBookName = scan.next();
				library.searchBookByBookName(searchBookName);
				break;

			case 3:
				System.out.println("Enter Author Name to Search: ");
				String searchAuthorName = scan.next();
				library.searchBookByAuthorName(searchAuthorName);
				break;

			case 4:
				System.out.println("Enter Book Name to Search: ");
				String searchBothBookName = scan.next();
				System.out.println("Enter Author Name to Search: ");
				String searchBothAuthorName = scan.next();
				library.searchBookByBoth(searchBothBookName, searchBothAuthorName);
				break;

			case 5:
				System.out.println("Enter Book Name to Issue: ");
				String issueBookName = scan.next();
				System.out.println("Enter Number of Copies to Issue: ");
				int numCopiesToIssue = scan.nextInt();
				library.issueBook(issueBookName, numCopiesToIssue);
				break;

			case 6:
				System.out.println("Enter Book Name to Return: ");
				String returnBookName = scan.next();
				System.out.println("Enter Number of Copies to Return: ");
				int numCopiesToReturn = scan.nextInt();
				library.returnBook(returnBookName, numCopiesToReturn);
				break;

			case 7:
				scan.close();
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
}