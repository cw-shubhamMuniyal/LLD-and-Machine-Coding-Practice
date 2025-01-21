package implementor;

public class ArtistResource implements MediaResource {

    @Override
    public String getSnippet() {
        return "artist name: by Gang of four";
    }
}
