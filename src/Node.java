import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    public PuzzleState state;
    public Node parent;
    public int depth;
    public String move;

    public Node(PuzzleState state, Node parent, int depth, String move) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
        this.move = move;
    }

    // Versão 1: Geração de filhos usando cópia do estado
    public List<Node> getChildrenWithCopy() {
        List<Node> children = new ArrayList<>();
        for (String direction : Arrays.asList("UP", "DOWN", "LEFT", "RIGHT")) {
            PuzzleState newState = this.state.copy();  // Faz uma cópia do estado pai
            newState.move(direction);  // Aplica o movimento na cópia
            children.add(new Node(newState, this, this.depth + 1, direction));
        }
        return children;
    }

    // Versão 2: Geração de filhos modificando o estado diretamente e depois restaurando
    public List<Node> getChildrenWithModification() {
        List<Node> children = new ArrayList<>();
        for (String direction : Arrays.asList("UP", "DOWN", "LEFT", "RIGHT")) {
            PuzzleState originalState = this.state.copy();  // Salva o estado original para restaurar depois
            this.state.move(direction);  // Aplica o movimento diretamente no estado pai
            children.add(new Node(this.state, this, this.depth + 1, direction));
            this.state = originalState;  // Restaura o estado original
        }
        return children;
    }
}
