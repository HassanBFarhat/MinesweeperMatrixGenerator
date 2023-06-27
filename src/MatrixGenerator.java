import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MatrixGenerator {

    private int myRows;
    private int myCols;
    private int myPercentOfMines;


    MatrixGenerator (final int theRows, final int theCols, final int thePercentOfMines) {
        setNumberOfRows(theRows);
        setNumberOfCols(theCols);
        setPercentOfMines(thePercentOfMines);
    }


    final public int getNumberOfRows() {
        return myRows;
    }

    final public int getNumberOfCols() {
        return myCols;
    }

    final public int getPercentOfMines() {
        return myPercentOfMines;
    }

    final public void setNumberOfRows(final int theRows) {
        if (theRows < 0) {
            System.out.println("INVALID INPUT. ROWS MUST BE POSITIVE VALUES");
        } else {
            myRows = theRows;
        }
    }

    final public void setNumberOfCols(final int theCols) {
        if (theCols < 0 || theCols > 100) {
            System.out.println("INVALID INPUT. Cols MUST BE POSITIVE VALUES AND OR BELOW 100");
        } else {
            myCols = theCols;
        }
    }

    final public void setPercentOfMines(final int thePercentOfMines) {
        if (thePercentOfMines < 0) {
            System.out.println("INVALID INPUT. PERCENT OF MINES MUST BE POSITIVE VALUES");
        } else {
            myPercentOfMines = thePercentOfMines;
        }
    }

    private int randomNumGenerator() {
        return (int) (Math.random() * 100);
    }

    final public void generateTheMineField() throws IOException {
        final FileWriter fw = new FileWriter("team_minesweeper_input.txt", true);
        final PrintWriter printWriter = new PrintWriter(fw);
        final StringBuilder sb = new StringBuilder();
        int minesPlacedInField = 0;

        printWriter.println(getNumberOfRows() + " " + getNumberOfCols());

        for (int rows = 0; rows < getNumberOfRows(); rows++) {
            for (int cols = 0; cols < getNumberOfCols(); cols++) {
                final int randomNum = randomNumGenerator();
                if (randomNum > (100 - getPercentOfMines()) && minesPlacedInField < numberOfMines()
                        || (numberOfMines() == (getNumberOfRows() * getNumberOfCols()))) {
                    sb.append("*");
                    minesPlacedInField++;
                } else {
                    sb.append(".");
                }
            }
            printWriter.println(sb.toString());
            sb.setLength(0);
        }
        printWriter.close();
    }

    private int numberOfMines() {
        final double percentage = getPercentOfMines() / 100.0;
        return (int) ((getNumberOfRows() * getNumberOfCols()) * percentage);
    }

}
