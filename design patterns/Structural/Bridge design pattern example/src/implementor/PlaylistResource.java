package implementor;

public class PlaylistResource implements MediaResource {

    @Override
    public String getSnippet() {
        return "play list name: Learning design patterns";
    }
}
