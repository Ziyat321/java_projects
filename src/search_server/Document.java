package search_server;

public class Document {

    private int id;
    private String content;

    public Document(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return id + ": " + content + "\n";
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
