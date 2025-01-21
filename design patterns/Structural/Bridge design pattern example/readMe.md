## Requirements

Create media resources to be rendered on a view.  </br>
Media resource like playlists, author, audio, video, etc.  </br>
Create views on which resource can be shown.  </br>
Views can be of any type.  </br>
New media resources and views can be added or removed without breaking change.  </br>

## Definition of Bridge DP

It's a structural design pattern that decouples an abstraction from its implementation so that the two can vary independently.  </br></br>

The Bridge pattern uses composition instead of inheritance to separate the abstraction (what the client interacts with) from the implementation (how it works). 
This allows changes to be made to either side independently, making the design more flexible and scalable.

## Benefits

Flexibility: The abstraction and implementation can evolve independently.  </br>
Reusability: You can use the same abstraction with different implementations.  </br>
Scalability: Adding new abstractions or implementations doesn’t require modifying existing code.  </br>

## Analogy from head first design pattern book

Think of a remote control (abstraction) that works with various types of devices like TVs or DVD players (implementation).
You can have different remotes for different devices, but the way the remote operates (e.g., on/off buttons, volume controls) is abstracted from the specific device functionality. </br>

## code

```
// Implementor
interface Device {
    void powerOn();
    void powerOff();
    void setVolume(int level);
}

// Concrete Implementor: TV
class TV implements Device {
    @Override
    public void powerOn() {
        System.out.println("TV is now ON");
    }

    @Override
    public void powerOff() {
        System.out.println("TV is now OFF");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("TV volume set to " + level);
    }
}

// Concrete Implementor: Radio
class Radio implements Device {
    @Override
    public void powerOn() {
        System.out.println("Radio is now ON");
    }

    @Override
    public void powerOff() {
        System.out.println("Radio is now OFF");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Radio volume set to " + level);
    }
}

// Abstraction
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void togglePower();
    public abstract void changeVolume(int level);
}

// Refined Abstraction: Basic Remote
class BasicRemote extends RemoteControl {
    private boolean isOn = false;

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        if (isOn) {
            device.powerOff();
        } else {
            device.powerOn();
        }
        isOn = !isOn;
    }

    @Override
    public void changeVolume(int level) {
        device.setVolume(level);
    }
}

// Client
public class BridgePatternExample {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl tvRemote = new BasicRemote(tv);

        System.out.println("Using TV Remote:");
        tvRemote.togglePower();
        tvRemote.changeVolume(15);

        Device radio = new Radio();
        RemoteControl radioRemote = new BasicRemote(radio);

        System.out.println("\nUsing Radio Remote:");
        radioRemote.togglePower();
        radioRemote.changeVolume(7);
    }
}

```
