public class BookParser implements IBookParser{

    String book;

    BookParser(String book) {
        this.book = book;
        // there will be some expensive operation carried over here.
    }

    @Override
    public int getNumberOfPages() {
        System.out.println("returns number of pages in the book!");
        return 251;
    }
}
