package search_server;

import java.util.*;

public class SearchServer {

    private Map<Integer, String> docs;
    private List<Document> list;
    private int size;

    public SearchServer(){
        docs = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }

    public void add(Document doc){
        docs.put(doc.getId(), doc.getContent());
        if(docs.size() - size == 1){
            size++;
            list.add(doc);
        }
    }

    public List<Document> findDocumentByContent(String str){
        List<Document> list1 = new ArrayList<>();
        String[] text = str.split("\\s+");
        int length = text.length;
        for (Document document : list) {
            String[] words = document.getContent().split("\\s+");
            int coincidence = 0;
            boolean found = false;
            for (String word : words) {
                for (String s : text) {
                    if(word.equals(s)){
                        coincidence++;
                        break;
                    }
                }
                if(coincidence == length){
                    found = true;
                    break;
                }
            }
            if(found) list1.add(document);
        }
        return list1;
    }

    @Override
    public String toString() {
        String str = "";
        for (Document document : list) {
            str += document.getId() + ": " + document.getContent() + "\n";
        }
        return str;
    }

    public Map<Integer, String> getDocs() {
        return docs;
    }

    public List<Document> getList() {
        return list;
    }
}
