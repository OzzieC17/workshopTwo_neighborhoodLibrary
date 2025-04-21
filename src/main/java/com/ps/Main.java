package com.ps;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Books[] inventory = new Books[20];
        String[] bookGenres = {"Mystery", "Fantasy", "Sci-Fi", "Romance", "Thriller"};
        for (int i = 0; i < inventory.length; i++) {
            String title = bookGenres[i % bookGenres.length] + " Book " + (i + 1);
            inventory[i] = new Books("", false, title, "ISBN" + (1000 + i), i + 1);
        }


        System.out.println("Neighborhood Library");
        System.out.println("1) Show available books");
        System.out.println("2) Show checked out books");
        System.out.println("3) Check out");
        System.out.println("4) Check in");

        String givenCommand = scanner.nextLine();

        switch (givenCommand) {
            case "1":
                System.out.println("\nAvailable Books:");
                for (Books b : inventory) {
                    if (!b.isCheckedOut()) {
                        System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle());
                    }
                }
                break;

            case "2":
                System.out.println("\nChecked Out Books:");
                for (Books b : inventory) {
                    if (b.isCheckedOut()) {
                        System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle() +
                                " | Checked out to: " + b.getCheckedOutTo());
                    }
                }
                break;
        }
    }
}