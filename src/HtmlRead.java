import java.net.*;
import java.io.*;

public class HtmlRead {
    public static void main(String[] args) {
        HtmlRead app = new HtmlRead();
    }

    public HtmlRead() {
        try {
            System.out.println();
            URL fred = new URL("https://www.milton.edu/");
            URLConnection urlc = fred.openConnection();
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlc.getInputStream(), "UTF-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("href")) {
                    // find the href
                    int hrefPos = line.indexOf("href");

                    // find the first  quote mark after the href is found
                    int firstQuote = line.indexOf("\"", hrefPos);
                    if (firstQuote == -1) {
                        continue;
                    }

                    // find the second quote mark
                    int secondQuote = line.indexOf("\"", firstQuote + 1);
                    if (secondQuote == -1) {
                        continue;
                    }

                    // the bounds of the link
                    String link = line.substring(firstQuote + 1, secondQuote);
                    // makes sure the link is blue
                    if (link.startsWith("http://") || link.startsWith("https://")) {
                        System.out.println(link);

                    }
                }}




                reader.close();
            } catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
