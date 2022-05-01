package td3.sudoku;

/**
 * une classe pour résoudre les sudokus de façon naive
 */
public class SudokuSolver {
    // Default values for a sudoku grid
    private static final int DEFAULT_SIZE = 9;
    private static final int DEFAULT_CELL_SIZE = 3;

    private final int size; // grid size
    private final int cellSize; // size of one cell of the grid
    private final int[][] grid; // sudoku grid

    /**
     * constructeur par défaut qui construit une grille de Sudoku
     * standard
     */
    public SudokuSolver() {
        size = DEFAULT_SIZE;
        cellSize = DEFAULT_CELL_SIZE;
        grid = new int[size][size];
    }

    /**
     * construire une grille de taille par défaut
     * avec des valeurs initiales
     * PRECOND : t est de taille 9
     */
    public SudokuSolver(int[][] t) {
        this(); // appel au constructeur par défaut
        for (int i = 0; i < t.length; i++)
            System.arraycopy(t[i], 0, grid[i], 0, t.length);
    }

    /**
     * place la valeur initiale v en (i,j)
     */
    public void init(int i, int j, int v) {
        grid[i][j] = v;
    }

    /**
     * CONSEQUENT : renvoie vrai si la  valeur v est possible pour la ligne l
     *
     * @param l: le n° de ligne
     * @param v: la valeur
     * @return : true si la valeur v peut être mise dans la ligne l
     */
    private boolean lineIsPossible(int l, int v) {
        for (int a = 0; a < size; a++) {
            if (grid[l][a] == v) {
                return false;
            }
        }
        return true;
    }

    /**
     * CONSEQUENT : renvoie vrai si la  valeur v est possible pour la colonne c
     *
     * @param c: le n° de colonne
     * @param v: la valeur
     * @return : true si la valeur v peut être mise dans la colonne l
     */
    private boolean columnIsPossible(int c, int v) {
        for (int a = 0; a < size; a++) {
            if (grid[a][c] == v) {
                return false;
            }
        }
        return true;
    }

    /**
     * CONSEQUENT : renvoie vrai si la valeur v est possible pour le carre
     * dont le coin (haut,gauche) est (i,j)
     *
     * @param i: la coordonnée x du carré dont le coin (haut,gauche) est en (i,j)
     * @param j: la coordonnée y du carré dont le coin (haut,gauche) est en (i,j)
     * @return : true si la valeur v est possible pour ce carré
     */
    private boolean cellIsPossible(int i, int j, int v) {
        int coinI = (i / cellSize) * cellSize;
        int coinJ = (j / cellSize) * cellSize;
        for (int i1 = 0; i1 < cellSize; i1++)
            for (int j1 = 0; j1 < cellSize; j1++)
                if (grid[coinI + i1][coinJ + j1] == v) return false;
        return true;
    }

    /**
     * renvoie la ligne de la case à droite de la case (i,j)
     *
     * @param i : la coordonnée x de la case
     * @param j : la coordonnée y de la case
     * @return le n° de ligne de la case à droite de (i,j)
     */
    private int nextLine(int i, int j) {
        if (j == size - 1) {
            return i + 1;
        }
        else {
            return i;
        }
    }

    /**
     * renvoie la colonne de la case à droite de  (i,j)
     *
     * @param i : la coordonnée x de la case
     * @param j : la coordonnée y de la case
     * @return le n° de colonne qui est à droite de la case (i,j)
     */
    private int nextColumn(int i, int j) {
        if (j == size - 1) {
            return 0;
        }
        else {
            return j + 1;
        }
    }

    /**
     * CONSEQUENT : remplit la grille si c'est possible
     *
     * @return : renvoie false si c'est impossible
     */
    public boolean fillGrid() {
        return fillGrid(0, 0);
    }


    /* CONSEQUENT : place une valeur en (i,j), renvoie false si c'est impossible */
    private boolean fillGrid(int i, int j) {
        // on a dépassé la dernière ligne donc la grille est remplie
        if (i == size) {
            return true;
        }
        ;
        //  la grille a une valeur initiale, on continue sur la prochaine case
        if (grid[i][j] != 0)
            return fillGrid(nextLine(i, j), nextColumn(i, j));

        int k = 1;
        // on essaie toutes les valeurs possibles
        while (k <= size) {
            // Si le k est possible dans la line
            // ET
            // le k est possible dans la column
            // ET
            // le k est possible dans la cell
            if (lineIsPossible(i, k) && columnIsPossible(j, k) && cellIsPossible(i, j, k)) {
                grid[i][j] = k;
                if (fillGrid(nextLine(i, j), nextColumn(i, j))) {
                    return true;
                } else {
                    grid[i][j] = 0;
                }
            }
            k++;
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Méthode privée pour dessiner une ligne
     *
     * @return une ligne de longueur taille formée de tirets
     */
    private String drawHorizontalSeparator() {
        StringBuilder horizontalSeparator = new StringBuilder("||");
        // -- pour la place d'un nombre
        for (int i = 0; i < size; i++) {
            horizontalSeparator.append("--");
        }
        ;
        // -- pour la place d'un séparateur vertical
        for (int i = 0; i < size / cellSize; i++) {
            horizontalSeparator.append("--");
        }
        ;
        horizontalSeparator.append("-||\n");
        return horizontalSeparator.toString();
    }

    /**
     * le séparateur vertical est ||, les chiffres sont espacés d'un espace,
     * le séparateur horizontal est obtenu par la méthode separateurHorizontal()
     * voir exemple dans la classe de test
     *
     * @return : renvoie une chaine qui représente la grille
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        String horizontalSeparator = drawHorizontalSeparator();
        for (int i = 0; i < size; i++) {
            if (i % cellSize == 0)
                result.append(horizontalSeparator);
            for (int j = 0; j < size; j++) {
                if (j % cellSize == 0)
                    result.append("|| ");
                result.append(grid[i][j]).append(" ");
            }
            result.append("||\n");
        }
        result.append(horizontalSeparator);
        return result.toString();
    }


}
