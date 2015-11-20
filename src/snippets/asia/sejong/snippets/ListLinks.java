package asia.sejong.snippets;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListLinks {
    public static void main(String[] args) throws IOException {
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        //String url = args[0];
    	String url = "http://mac.sejong.asia/eazimemo/stock/businessReportSectionDetail?rcpNo=20151116001819&dcmNo=4856396&eleId=11";
        print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");
        Elements tables = doc.select("p,table");
        

        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                print(" * %s: <%s> %sx%s (%s)",
                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                        trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
        }

        print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
        }

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }
        
        ArrayList<Element> forRemove = new ArrayList<Element>();
        for (Element link : tables) {
        	if ( "body".equalsIgnoreCase(link.parent().tagName()) ) {
        		if ( "table".equalsIgnoreCase(link.tagName())) {
        			continue;
        		}
        		Elements span = link.select("span");
        		if ( span.size() > 0 ) {
        			int idx = tables.indexOf(link);
        			tables.set(idx, span.get(0));
        			continue;
        		}
        	}
        	forRemove.add(link);
        }
        tables.removeAll(forRemove);
        
        print("\nTables: (%d)", tables.size());
        for (Element link : tables) {
            print(" * %s: (%s)", link.tag(), trim(link.text(), 35));
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}