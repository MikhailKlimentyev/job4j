package ru.job4j.loop;

/**
 * Board.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/29/2018
 */
public class Board {

    /**
     * paint.
     * <p>
     * Method paints 'x' and ' ' on board in chess order.
     *
     * @param width  width of board.
     * @param height height of board.
     * @return board with painted symbols.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
