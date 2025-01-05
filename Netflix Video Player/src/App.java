import stratergies.device.*;
import stratergies.resolution.*;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Netflix Video Player");

        Resolution resolution = new R420p();
        Device device = new Phone();

        VideoPlayer videoPlayer = new TvVideoPlayer(resolution, device);
        videoPlayer.display();
    }
}
