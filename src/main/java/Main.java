import java.util.Scanner;

public class Main {

    private static final int PERSON = 1;
    private static final int COMPUTER = 0;
    private static  int count = 0;


    static int[][] ticTacToeArray = {
            {-9,-9,-9},
            {-9,-9,-9},
            {-9,-9,-9}
    };


    public static void main(String[] args) {
        printTicToeCells(ticTacToeArray);
        while (true){
            setCellPerson();
            if (checkWhoIsWinsSimpleVersion(ticTacToeArray)){
                System.out.println("User wins");
                break;
            }
            setCellComputer();
            if (checkWhoIsWinsSimpleVersion(ticTacToeArray)){
                System.out.println("Computer wins");
                break;
            }
        }

//        System.out.println((3 % ticTacToeArray.length));
    }

    private static void setCellPerson(){
        System.out.println("Please enter digits from 1 to 9");
        Scanner personInput = new Scanner(System.in);
        int cell;
        while(true){ 
            if (personInput.hasNextInt()){
                cell = personInput.nextInt();
                if (isEmptyCell(ticTacToeArray,cell)){
                    fillCell(ticTacToeArray, PERSON,cell);
                    printTicToeCells(ticTacToeArray);
                    break;
                } else {
                    System.out.println("Wrong data!You are trying to put in filled cell");
                    personInput.nextLine();
                }

            }else {
                System.out.println("Wrong data! Please try again. Enter digits from 1 to 9");
                personInput.nextLine();
            }
        }

    }

    private static boolean checkWhoIsWinsSimpleVersion(int[][] array){
//        {-9,-9,-9},
//        {-9,-9,-9},
//        {-9,-9,-9}
        return (array[0][0] != -9 && array[0][1] == array[0][0]  && array[0][2] ==array[0][0] )||
                (array[1][0] != -9 && array[1][1] == array[1][0] && array[1][2] ==array[1][0]) ||
                (array[2][0] != -9 && array[2][1] == array[2][0] && array[2][2] ==array[2][0]) ||
                (array[0][0] != -9 && array[1][0] == array[0][0] && array[2][0] ==array[0][0]) ||
                (array[0][1] != -9 && array[1][1] == array[0][1] && array[2][1] ==array[0][1]) ||
                (array[0][2] != -9 && array[1][2] == array[0][2] && array[2][2] ==array[0][2]) ||
                (array[0][0] != -9 && array[1][1] == array[0][0] && array[2][2] ==array[0][0]) ||
                (array[0][2] != -9 && array[1][1] == array[0][2] && array[2][0] ==array[0][2]);
    }


    static boolean checkWins(int[][] array){
        boolean result = false;
        int counter = 0;
        int reverseCounter = 0;
        int diagonalMainCounter = 0 ;
        int diagonalReverseCounter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                counter += array[i][j];
                reverseCounter += array[j][i];
                /*
                {-9,-9,-9},
                {-9,-9,-9},
                {-9,-9,-9}
                 */
                if (i == j){
                    diagonalMainCounter += array[i][j];
                }
                if (i + j == 2) {
                    diagonalReverseCounter += array[i][j];
                }
            }
            if (counter == 0 || reverseCounter == 0 || diagonalMainCounter == 0 || diagonalReverseCounter == 0) {
                System.out.println("Computer wins");
                result = true;
                break;
            } else if (counter == 3 || reverseCounter == 3 || diagonalMainCounter == 3 || diagonalReverseCounter == 3) {
                System.out.println("User wins");
                result = true;
                break;
            } else {
                counter = 0;
                reverseCounter = 0;
//                diagonalMainCounter = 0 ;
//                diagonalReverseCounter = 0;
            }
        }
        return result;
    }

    private static void setCellComputer(){
        while (true) {
            int cell = (int) (Math.random() * 9) + 1;
            if (isEmptyCell(ticTacToeArray, cell)) {
                fillCell(ticTacToeArray, COMPUTER,cell);
                printTicToeCells(ticTacToeArray);
                break;
            }
        }
    }

    private static boolean isEmptyCell(int[][] ticTacToeArray, int cell){
        if (cell == 1 && ticTacToeArray[0][0] == -9) return true;
        else if (cell == 2 && ticTacToeArray[0][1] == -9) return true;
        else if (cell == 3 && ticTacToeArray[0][2] == -9) return true;
        else if (cell == 4 && ticTacToeArray[1][0] == -9) return true;
        else if (cell == 5 && ticTacToeArray[1][1] == -9) return true;
        else if (cell == 6 && ticTacToeArray[1][2] == -9) return true;
        else if (cell == 7 && ticTacToeArray[2][0] == -9) return true;
        else if (cell == 8 && ticTacToeArray[2][1] == -9) return true;
        else
            return (cell == 9 && ticTacToeArray[2][2] == -9);
    }
    
    private static void fillCell(int[][] ticTacToeArray, int type, int cell){
//        count++;
        switch (cell) {
            case 1:
            case 2:
            case 3:
                ticTacToeArray[0][cell - 1] = type;
                break;
            case 4:
            case 5:
            case 6:
                ticTacToeArray[1][cell - 4] = type;
                break;
            case 7:
            case 8:
            case 9:
                ticTacToeArray[2][cell - 7] = type;
                break;
        }
    }
    
    private static void fillCellV2(int[][] ticTacToeArray, int cell){
//        ticTacToeArray[(int) (Math.ceil(cell / ticTacToeArray.length) - 1)]
//                [(cell % ticTacToeArray[0].length)-1] = cell;
//        ticTacToeArray[(ticTacToeArray.length % cell)]
//                [(cell % ticTacToeArray[0].length) - 1] = cell;
//        ticTacToeArray[][]
    }


    private static void printTicToeCells(int[][] array){
        System.out.println();
//        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                beautifyPrint(array, i, j);
            }
            System.out.println();
        }
    }

    private static void beautifyPrint(int[][] array, int i, int j) {
        if (array[i][j] == 1){
            System.out.print("X" + "\t");
        } else if (array[i][j] == 0){
            System.out.print("0" + "\t");
        } else {
            System.out.print("*" + "\t");
        }
    }
}
