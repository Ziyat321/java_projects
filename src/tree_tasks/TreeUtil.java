package tree_tasks;

import java.io.*;
import java.util.*;

public class TreeUtil {


    private final File file;
    private final String filePath;
    private final TreeNode parent;

    private TreeNode parentFromFile;

    private List<String> lineList;

    private List<Integer> levelList;

    private Map<Integer, TreeNode> treePos;

    private TreeNode subNode;

    public TreeUtil(String filePath, TreeNode parent) {
        file = new File(filePath);
        this.filePath = filePath;
        lineList = new ArrayList<>();
        levelList = new ArrayList<>();
        treePos = new HashMap<>();
        parentFromFile = null;
        subNode = null;
        try {
            boolean created;
            if (!file.exists()) {
                created = file.createNewFile();
                if (!created) {
                    throw new RuntimeException("Файл не создан");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.parent = parent;
    }

    public void treeVisualizationInFile() throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        treeVisualizationInFile(parent, 0, bufferedWriter);
        bufferedWriter.close();
    }

    private void treeVisualizationInFile(TreeNode parent, int level, BufferedWriter bufferedWriter) throws IOException {
        level++;
        for (TreeNode branch : parent.getBranches()) {
            bufferedWriter.write("- ".repeat(level - 1) + branch.getName() + "\n");
            treeVisualizationInFile(branch, level, bufferedWriter);
        }
    }                        // запись дерева в файл


    public void treePrint(TreeNode parent) {
        treePrint(parent, 0);
    }

    private void treePrint(TreeNode parent, int level) {
        level++;
        for (TreeNode branch : parent.getBranches()) {
            System.out.println("- ".repeat(level - 1) + branch.getName());
            treePrint(branch, level);
        }                                      // вывод дерева в консоль
    }

    public void treePrintWithParent(TreeNode parent){
        System.out.println(parent.getName());
        treePrint(parent, 1);
    }                                              // вывод дерева вместе с родителем


    private int levelCounter(String line) {
        int finish = line.lastIndexOf("-");
        if (finish == -1) return 0;
        else return finish / 2 + 1;
    }

    private String lineModifier(String line) {
        int start = line.lastIndexOf("-");
        if (start == -1) return line;
        return line.substring(start + 2);
    }



    /*private void listModifier(){
        int maxLevel = findMaxNumInList();
        int start = levelList.indexOf(maxLevel);
        int finish = start;

        for (int j = start + 1; j < levelList.size(); j++) {
            if (j == levelList.size() - 1 && levelList.get(j).equals(levelList.get(start))) {
                finish = j;
            }
            if (!levelList.get(j).equals(levelList.get(start))) {
                finish = j - 1;
                break;                                                // узнать начало и конец, начиная с самого глубокого уровня
            }                                                         // и подряд стоящих, к самому верхнему уровню
        }
        int size = finish - start + 1;
        TreeNode[] branches = new TreeNode[size];
        int parentPos = start - 1;
        String parentName = lineList.get(parentPos);
        TreeNode parent = new TreeNode(parentName, branches);
        for (int i = start; i <= finish ; i++) {
            branches[i - start] = new TreeNode(lineList.get(i));
        }                                                               // cоздать поддерево с элементами от найденного начала до конца


        for (int i = start; i <= finish; finish--){
            levelList.remove(i);
            lineList.remove(i);                                           // подчистить списки
        }
        System.out.println(levelList);
        System.out.println(lineList);
        treePrint(parent);
        System.out.println();
        treePos.put(parentPos, parent);
        listModifier2();
    }*/

    private void listsFormer(){
        try(FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int level = levelCounter(line);
                levelList.add(level);
                lineList.add(lineModifier(line));
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public TreeNode treeFormFromFile(){
        listsFormer();
        treeFormFromFileRec();
        return parentFromFile;
    }
    private void treeFormFromFileRec() {
        int maxLevel = findMaxNumInList();
        int start = levelList.indexOf(maxLevel);
        int finish = start;

        for (int j = start + 1; j < levelList.size(); j++) {
            if (j == levelList.size() - 1 && levelList.get(j).equals(levelList.get(start))) {
                finish = j;
            }
            if (!levelList.get(j).equals(levelList.get(start))) {
                finish = j - 1;
                break;                                                // узнать начало и конец, начиная с самого глубокого уровня
            }                                                         // и подряд стоящих, к самому верхнему уровню
        }
        int size = finish - start + 1;

        TreeNode[] branches = new TreeNode[size];
        Set<Integer> keys = treePos.keySet();
        String parentName;
        TreeNode parentNew;
        for (int i = start; i <= finish; i++) {
            boolean exists = false;
            int parentPos = -1;                                         // если на данных позициях уже существует поддерево,
            for (Integer key : keys) {                                  // добавить это поддерево в новый массив веток
                if (i == key) {
                    exists = true;                                      // проверка существует ли уже поддерево проверяется
                    parentPos = key;                                      // в карте с ключом в позиции подеерева и
                    break;                                               // значением самого поддерева
                }
            }
            if (exists && parentPos >= 0) {
                branches[i - start] = treePos.get(parentPos);
                treePos.remove(parentPos);                               // если уже существующее поддерево с идентичной позицией
            } else {                                                      // было добавлено в массив веток, удалить его из карты
                branches[i - start] = new TreeNode(lineList.get(i));        // как уже использованное
            }
        }

        if (maxLevel != 0) {
            int parentPosNew = start - 1;                              // присвоить созданный массив веток родителю
            parentName = lineList.get(parentPosNew);                   // и сохранить позицию родителя и самого
            parentNew = new TreeNode(parentName, branches);            // родителя в карту
            treePos.put(parentPosNew, parentNew);
            for (int i = start; i <= finish; finish--) {
                levelList.remove(i);
                lineList.remove(i);                                           // подчистить списки
            }                                                                  // используется свойство, что после удаления позиций
            //System.out.println(levelList);                                  // и содержания массива веток, позиция родителя
            //System.out.println(lineList);                                     // остается неизменной
            //treePrint(parentNew);
            //System.out.println();

            treeFormFromFileRec();

        } else {
            parentName = "Parent";
            parentNew = new TreeNode(parentName, branches);
            //treePrint(parentNew);
            parentFromFile = parentNew;
            treePos.clear();
        }

        //return new TreeNode("");
        // 0 1 2 2 3 2 1 2 3 3 0 1 1 2 2
        // 0 1 2 (2) 2 1 2 3 3 0 1 1 2 2
        // 0 1 2 (2) 2 1 (2) 0 1 1 2 2
    }



    private int findMaxNumInList() {
        int maxLevel;
        if (!levelList.isEmpty()) {
            maxLevel = levelList.get(0);
            for (int i = 1; i < levelList.size(); i++) {
                maxLevel = Math.max(maxLevel, levelList.get(i));
            }
        } else {
            maxLevel = -1;
        }
        // узнать максимальную глубину вложенности дерева
        return maxLevel;
    }


    public TreeNode searchTreeNodeByName(String name, TreeNode parent){
        searchTreeNodeByNameRec(name, parent);
        return subNode;
    }

    private void searchTreeNodeByNameRec(String name, TreeNode parent){
        if(parent.getName().equals(name)) subNode = parent;
        else{
            for (TreeNode branch : parent.getBranches()) {
                searchTreeNodeByNameRec(name, branch);
            }                                                      //поиск поддерева с определенным названием
        }
    }


    public File getFile() {
        return file;
    }

    public TreeNode getParent() {
        return parent;
    }
}

