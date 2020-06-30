package tictactoe;

import tictactoe.util.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
    /*private static final Scanner scanner = new Scanner(System.in);

    *//*public static void main(String[] args) {
        char[][] playSpace = new char[3][3];
        String input = "";
        do {
            System.out.println("Input command:");
            input = scanner.nextLine();
            String[] inputs = input.split("\\s+");
            if (!isValid(inputs)) {
                System.out.println("Bad parameters!");
                continue;
            }
            if (!"exit".equals(input)) {
                initialize(playSpace);
                playGame(playSpace, inputs[1], inputs[2]);
            }
        } while (!"exit".equals(input));
    }

    private static boolean isValid(String[] inputs) {
        if (inputs.length == 3 && isValidInput3(inputs)) {
            return true;
        } else if (inputs.length == 1 && "exit".equals(inputs[0])) {
            return true;
        }
        return false;
    }

    private static boolean isValidInput3(String[] inputs) {
        if (!"start".equals(inputs[0])) {
            return false;
        }
        for (int i = 1; i < 3; i++) {
            if (!"easy".equals(inputs[i]) && !"user".equals(inputs[i])) {
                return false;
            }
        }
        return true;
    }

    public static void playGame(char[][] playSpace, String player1, String player2) {
        boolean isXMove = true;
        displayGrid(playSpace);
        do {
            if (isXMove) {
                makeMove(playSpace, player1, 'X');
            } else {
                makeMove(playSpace, player2, 'O');
            }
            String status = getStatus(playSpace);
            displayGrid(playSpace);
            if (status.equals("X wins") || status.equals("O wins")
                    || status.equals("Draw")) {
                System.out.println(status);
                break;
            }
            isXMove = !isXMove;
        } while (true);
    }

    private static void makeMove(char[][] playSpace, String player, char symbol) {
        if ("user".equals(player)) {
            placeSymbol(playSpace, symbol);
        } else {
            System.out.println("Making move level \"easy\"");
            makeComputerMove(playSpace, symbol);
        }
    }

    private static void makeComputerMove(char[][] playSpace, char symbol) {
        Random random = new Random(System.currentTimeMillis());
        do {
            int xVal = random.nextInt(3) + 1;
            int yVal = random.nextInt(3) + 1;
            if (playSpace[3 - yVal][xVal - 1] == '_') {
                playSpace[3 - yVal][xVal - 1] = symbol;
                break;
            }

        } while (true);
    }



    private static void initialize(char[][] playSpace) {
        int rowCount = 0;
        for (int i = 0; i < 9; i++) {
            playSpace[rowCount][i % 3] = '_';
            if ((i + 1) % 3 == 0) {
                rowCount++;
            }
        }
    }

    private static void placeSymbol(char[][] playSpace, char symbol) {
        do {
            System.out.println("Enter the coordinates:");
            int xVal;
            int yVal;
            String[] coordinates;
            try {
                String input = scanner.nextLine();
                coordinates = input.split("\\s+");
                xVal = Integer.parseInt(coordinates[0]);
                yVal = Integer.parseInt(coordinates[1]);
            } catch (Exception ex) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (xVal > 3 || yVal > 3 || xVal < 1 || yVal < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (playSpace[3 - yVal][xVal - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                playSpace[3 - yVal][xVal - 1] = symbol;
                break;
            }

        } while (true);
    }

    private static String getStatus(char[][] playSpace) {
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int[] diagSum = new int[2];
        int xCount = 0;
        int oCount = 0;
        int _Count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (playSpace[i][j] == 'X') {
                    xCount++;
                } else if (playSpace[i][j] == 'O') {
                    oCount++;
                } else {
                    _Count++;
                }
                rowSum[i] += playSpace[i][j];
                colSum[j] += playSpace[i][j];
                if (i == j) {
                    diagSum[0] += playSpace[i][j];
                }
                if (3 - (j + 1) == i) {
                    diagSum[1] += playSpace[i][j];
                }
            }
        }
        if (Math.abs(xCount - oCount) > 1) {
            return "Impossible";
        }
        boolean xWins = false;
        boolean oWins = false;
        for (int i = 0; i < 3; i++) {
            if (rowSum[i] == 3 * 'X' || colSum[i] == 3 * 'X') {
                xWins = true;
            } else if (rowSum[i] == 3 * 'O' || colSum[i] == 3 * 'O') {
                oWins = true;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (diagSum[i] == 3 * 'X') {
                xWins = true;
            } else if (diagSum[i] == 3 * 'O') {
                oWins = true;
            }
        }
        if (xWins && oWins) {
            return "Impossible";
        } else if (xWins) {
            return "X wins";
        } else if (oWins) {
            return "O wins";
        } else if (_Count > 0) {
            return "Game not finished";
        }
        return "Draw";
    }

    public static void displayGrid(char[][] playSpace) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + playSpace[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }*/
}
