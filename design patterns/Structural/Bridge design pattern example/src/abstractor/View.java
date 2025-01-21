package abstractor;

import implementor.MediaResource;

public abstract class View {

    MediaResource mediaResource;

    public View(MediaResource mediaResource) {
        this.mediaResource = mediaResource;
    }

    public abstract String showHtml();
}
