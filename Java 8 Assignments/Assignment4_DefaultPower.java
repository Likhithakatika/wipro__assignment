interface Power {
    void turnOn();

    default void turnOff() {
        System.out.println("Power is now OFF");
    }
}

public class Assignment4_DefaultPower {
    public static void main(String[] args) {
        Power device = () -> System.out.println("Power is now ON");
        device.turnOn();
        device.turnOff();
    }
}
