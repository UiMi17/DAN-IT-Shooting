package net.uimi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int randX = rand.nextInt(6) + 1;
        int randY = rand.nextInt(6) + 1;
        randX = randX > 5 ? randX - 1 : randX;
        randY = randY > 5 ? randY - 1 : randY;
        boolean hasPlayerWon = false;
        String[][] gameField = new String[6][6];

        createGameField(gameField);
        showGameField(gameField);

        while (!hasPlayerWon) {
            System.out.println("\nInsert the coords, captain:");
            boolean isCoordsCorrect = false;
            while (!isCoordsCorrect) {
                System.out.println("X: ");
                int x = scanner.nextInt();
                System.out.println("Y: ");
                int y = scanner.nextInt();

                if ((x >= 1 && x <= 5) && (y >= 1 && y <= 5)) {
                    isCoordsCorrect = true;

                    if (x == randX && y == randY) {
                        System.out.println("You have won!");

                        gameField[randX][randY] = "x|";
                        showGameField(gameField);

                        System.out.println("\nPlay again? (Y/N): ");
                        char userAnswer = scanner.next().toLowerCase().charAt(0);
                        if (userAnswer == 'n') hasPlayerWon = true;
                        else {
                            randX = rand.nextInt(6) + 1;
                            randY = rand.nextInt(6) + 1;
                            randX = randX > 5 ? randX - 1 : randX;
                            randY = randY > 5 ? randY - 1 : randY;

                            createGameField(gameField);
                            showGameField(gameField);
                        }
                    } else {
                        System.out.println("We missed!");

                        gameField[x][y] = "*|";
                        showGameField(gameField);
                    }
                }
                else System.out.println("Please, tell us the right coords!");
            }
        }
    }

    public static void showGameField(String[][] gameField) {
        for (String[] row : gameField) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    public static void createGameField(String[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            if (i == 0) {
                for (int j = 0; j < gameField[i].length; j++) {
                    gameField[0][j] = String.format("%s|", j);
                }
            } else {
                for (int j = 0; j < gameField[i].length; j++) {
                    if (j == 0) {
                        gameField[i][0] = String.format("%s|", i);
                    } else {
                        gameField[i][j] = "-|";
                    }
                }
            }
        }

        System.out.println("All Set. Get ready to rumble!");
    }
}