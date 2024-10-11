import java.util.List;

public class IDDFS {

    // Busca com aprofundamento iterativo, usando geração de filhos com cópia
    public Node iddfsWithCopy(Node root, PuzzleState goal, int maxDepth) {
        for (int depth = 0; depth <= maxDepth; depth++) {
            Node result = dlsWithCopy(root, goal, depth);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    // Busca em profundidade limitada, usando geração de filhos com cópia
    private Node dlsWithCopy(Node node, PuzzleState goal, int depth) {
        if (node.state.isGoal(goal.state)) {
            return node;
        }
        if (depth == 0) {
            return null;
        }
        List<Node> children = node.getChildrenWithCopy();
        for (Node child : children) {
            Node result = dlsWithCopy(child, goal, depth - 1);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    // Busca com aprofundamento iterativo, usando geração de filhos com modificação direta
    public Node iddfsWithModification(Node root, PuzzleState goal, int maxDepth) {
        for (int depth = 0; depth <= maxDepth; depth++) {
            Node result = dlsWithModification(root, goal, depth);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    // Busca em profundidade limitada, usando geração de filhos com modificação direta
    private Node dlsWithModification(Node node, PuzzleState goal, int depth) {
        if (node.state.isGoal(goal.state)) {
            return node;
        }
        if (depth == 0) {
            return null;
        }
        List<Node> children = node.getChildrenWithModification();
        for (Node child : children) {
            Node result = dlsWithModification(child, goal, depth - 1);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}

