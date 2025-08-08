public class LightSwitch {
    private Switchable device;

    public LightSwitch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        System.out.println("Toggling...");
        device.turnOn();
    }
}
