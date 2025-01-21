package abstractor;

import implementor.MediaResource;

public class LongView extends View {

    public LongView(MediaResource mediaResource) {
        super(mediaResource);
    }

    @Override
    public String showHtml() {
        return this.mediaResource.getSnippet();
    }
}
