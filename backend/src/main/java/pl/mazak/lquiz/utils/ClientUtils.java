package pl.mazak.lquiz.utils;

public class ClientUtils {
    private ClientUtils() {

    }

    public static String createUrlForPortAndPath(int port, String path) {
        return String.format("http://localhost:%d%s", port, path);
    }
}
