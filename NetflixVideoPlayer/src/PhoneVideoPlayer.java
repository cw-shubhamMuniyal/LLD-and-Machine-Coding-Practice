import stratergies.device.Device;
import stratergies.resolution.Resolution;

public class PhoneVideoPlayer extends VideoPlayer {

    Resolution resolution;
    Device device;

    public PhoneVideoPlayer(Resolution resolution, Device device) {
       super(resolution, device);
    }

    @Override
    void display() {
        this.device.display();
        this.resolution.display();
    }
    
}
