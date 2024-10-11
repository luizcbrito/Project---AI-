public class Main {
    public static void main(String[] args) {
        int[][] initialState = {
            {1, 2, 3},
            {4, 0, 5},
            {6, 7, 8}
        };

        int[][] goalState = {
            {1, 2, 3},
            {4, 5, 0},
            {6, 7, 8}
        };

        PuzzleState initial = new PuzzleState(initialState);
        PuzzleState goal = new PuzzleState(goalState);
        Node root = new Node(initial, null, 0, null);

    };
};