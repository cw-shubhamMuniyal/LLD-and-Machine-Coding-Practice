import abstractor.LongView;
import abstractor.ShortView;
import abstractor.View;
import implementor.ArtistResource;
import implementor.PlaylistResource;

public class BridgePatternExample {
    public static void main(String[] args) {

        System.out.println("Learning Bridge pattern using example!");
        System.out.println("______________________________________");

        View shortView = new ShortView(new PlaylistResource());
        String html = shortView.showHtml();
        System.out.println("playlist details on short form view: " + html);

        View longView = new LongView(new ArtistResource());
        html = longView.showHtml();
        System.out.println("Artist details on long form view: " + html);


    }
}