import java.util.Arrays;

public class PuzzleState {
    int[][] state;

    public PuzzleState(int[][] state) {
        this.state = state;
    }

    // Verifica se o estado atual é o estado objetivo
    public boolean isGoal(int[][] goal) {
        return Arrays.deepEquals(this.state, goal);
    }

    // Faz uma cópia profunda do estado
    public PuzzleState copy() {
        int[][] newState = new int[3][3];
        for (int i = 0; i < 3; i++) {
            newState[i] = Arrays.copyOf(this.state[i], 3);
        }
        return new PuzzleState(newState);
    }

    // Realiza o movimento de acordo com a direção (simula mover o espaço vazio)
    public void move(String direction) {
        // Implementação simplificada para mover o zero (espaço vazio)
        int[] zeroPos = findZero();  // Encontra a posição do zero
        int x = zeroPos[0];
        int y = zeroPos[1];

        switch (direction) {
            case "UP":
                if (x > 0) {
                    swap(x, y, x - 1, y);
                }
                break;
            case "DOWN":
                if (x < 2) {
                    swap(x, y, x + 1, y);
                }
                break;
            case "LEFT":
                if (y > 0) {
                    swap(x, y, x, y - 1);
                }
                break;
            case "RIGHT":
                if (y < 2) {
                    swap(x, y, x, y + 1);
                }
                break;
        }
    }

    // Encontra a posição do "0" no tabuleiro
    private int[] findZero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Faz a troca de posições no tabuleiro
    private void swap(int x1, int y1, int x2, int y2) {
        int temp = state[x1][y1];
        state[x1][y1] = state[x2][y2];
        state[x2][y2] = temp;
    }

    // Exibe o estado (para fins de depuração)
    public void printState() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(state[i]));
        }
        System.out.println();
    }
}
