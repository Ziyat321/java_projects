package search_server;

public class SearchServerMain {

    public static void main(String[] args) {

        SearchServer searchServer = new SearchServer();

        searchServer.add(new Document(3, "java the best"));
        searchServer.add(new Document(5, "python the best"));
        searchServer.add(new Document(7, "java better than python"));
        searchServer.add(new Document(7, "test"));



        System.out.println(searchServer.findDocumentByContent("java python")); //
    }

}
