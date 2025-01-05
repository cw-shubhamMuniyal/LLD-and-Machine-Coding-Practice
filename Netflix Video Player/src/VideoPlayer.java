import stratergies.device.Device;
import stratergies.resolution.Resolution;

public abstract class VideoPlayer {

    Resolution resolution;
    Device device;

    public VideoPlayer(Resolution resolution, Device device) {
        this.resolution = resolution;
        this.device = device;
    }

    abstract void display();
    
}
