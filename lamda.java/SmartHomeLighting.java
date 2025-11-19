import java.util.*;

@FunctionalInterface
interface LightAction {
    void execute(String room);
}

public class SmartHomeLighting {
    public static void main(String[] args) {

        Map<String, LightAction> triggers = new HashMap<>();

        triggers.put("MOTION", r -> System.out.println("Motion in " + r + " → Full Brightness ON"));
        triggers.put("NIGHT", r -> System.out.println("Night Mode in " + r + " → Dim Warm Light"));
        triggers.put("VOICE", r -> System.out.println("Voice Command in " + r + " → Toggle Lights"));

        triggers.get("MOTION").execute("Hallway");
        triggers.get("NIGHT").execute("Living Room");
        triggers.get("VOICE").execute("Bedroom");
    }
}
