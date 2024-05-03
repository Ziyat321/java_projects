package parser;

public class UrlParserMain {

    public static void main(String[] args) {

        String path = "https://vk.com/profile/alex";
        UrlParser urlParser= new UrlParser(path);
        System.out.println(urlParser.getProtocol());
        System.out.println(urlParser.getHost());
        System.out.println(urlParser.getUrl());
    }

}
