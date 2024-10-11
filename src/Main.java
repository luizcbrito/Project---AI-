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

        IDDFS iddfs = new IDDFS();

        // Usando geração de filhos com cópia
        long startTimeCopy = System.nanoTime();
        Node resultCopy = iddfs.iddfsWithCopy(root, goal, 20);
        long endTimeCopy = System.nanoTime();

        if (resultCopy != null) {
            System.out.println("Solução encontrada com cópia!");
        } else {
            System.out.println("Solução não encontrada com cópia.");
        }
        System.out.println("Tempo de execução com cópia: " + (endTimeCopy - startTimeCopy) + " ns");

        // Usando geração de filhos com modificação direta
        long startTimeMod = System.nanoTime();
        Node resultMod = iddfs.iddfsWithModification(root, goal, 20);
        long endTimeMod = System.nanoTime();

        if (resultMod != null) {
            System.out.println("Solução encontrada com modificação direta!");
        } else {
            System.out.println("Solução não encontrada com modificação direta.");
        }
        System.out.println("Tempo de execução com modificação direta: " + (endTimeMod - startTimeMod) + " ns");
    }
}
