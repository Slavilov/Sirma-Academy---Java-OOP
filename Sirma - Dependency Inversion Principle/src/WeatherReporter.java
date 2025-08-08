public class WeatherReporter {
    private TemperatureSensor sensor;

    public WeatherReporter(TemperatureSensor sensor) {
        this.sensor = sensor;
    }

    public String report() {
        return "Current temperature: " + sensor.getTemperature();
    }
}
