package tree_tasks;

public class TreeNode {

    private final String name;

    private final TreeNode[] branches;

    public TreeNode(String name){
        this(name, new TreeNode[0]);
    }

    public TreeNode(String name, TreeNode[] branches) {
        this.name = name;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public TreeNode[] getBranches() {
        return branches;
    }
}
