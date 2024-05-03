package tree_tasks;

public class RecursiveTask1 {

    public static void main(String[] args) {

        String filePath = "./src/tree_tasks/tree.txt";

       /* TreeNode parent = new TreeNode("Parent", new TreeNode[]{
                new TreeNode("Комплектующие", new TreeNode[]{
                        new TreeNode("Процессоры", new TreeNode[]{
                                new TreeNode("Intel"),
                                new TreeNode("AMD")
                        }),
                        new TreeNode("ОЗУ")
                }),
                new TreeNode("Аудиотехника", new TreeNode[]{
                        new TreeNode("Наушники"),
                        new TreeNode("Колонки")
                })
        });*/

        TreeUtil treeUtil = new TreeUtil(filePath, null);
    //    treeUtil.treePrint(parent);
       TreeNode parent = treeUtil.treeFormFromFile();
     //   treeUtil.treePrint(parent);
        TreeNode subNode = treeUtil.searchTreeNodeByName("Процессоры", parent);
        treeUtil.treePrintWithParent(subNode);

    }

}
