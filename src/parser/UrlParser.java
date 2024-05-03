package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlParser {

    private final String path;
    private String protocol;
    private String host;
    private String url;

    public UrlParser(String path) {
        final String pathRegex = "(https?)://(\\w+.com)((/\\w+)*)";
        final Pattern pattern = Pattern.compile(pathRegex);
        final Matcher matcher;
        this.path = path;
        matcher = pattern.matcher(path);
        if(matcher.find()){
            protocol = matcher.group(1);
            host = matcher.group(2);
            url = matcher.group(3).substring(1);
        } else throw new RuntimeException();
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public String getUrl() {
        return url;
    }

    public String getPath() {
        return path;
    }
}
