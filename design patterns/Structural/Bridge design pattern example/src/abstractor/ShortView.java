package abstractor;

import implementor.MediaResource;

public class ShortView extends View {

    public ShortView(MediaResource mediaResource) {
        super(mediaResource);
    }

    @Override
    public String showHtml() {
        return this.mediaResource.getSnippet();
    }
}
