import stratergies.device.Device;
import stratergies.resolution.Resolution;

public class TvVideoPlayer extends VideoPlayer {

    public TvVideoPlayer(Resolution resolution, Device device) {
       super(resolution, device);
    }

    @Override
    void display() {
        this.device.display();
        this.resolution.display();
    }
    
}
