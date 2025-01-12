import java.awt.print.Book;

public class Proxy {
    public static void main(String[] args) throws Exception {
        System.out.println("Virtual Proxy DP example!!");

        IBookParser bookParser = new BookParserProxy("harry potter and chamber of secrets Book content serialized format");
        System.out.println(bookParser.getNumberOfPages());
    }
}
