import java.util.Objects;

public class BookParserProxy implements IBookParser{

    String book;
    BookParser bookParser = null;

    BookParserProxy(String book) {
        this.book = book;
    }

    @Override
    public int getNumberOfPages() {

//        this proxy is now delaying instantiation of BookParser which was expensive operation. Hence Virtual proxy.
        if (Objects.isNull(bookParser)) {
            bookParser = new BookParser(this.book);
        }
        return bookParser.getNumberOfPages();
    }
}
