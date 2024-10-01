import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        // Create a Map with Integer keys and String values using HashMap
        Map<Integer, String> map = new HashMap<>();

        // Add key-value pairs to the Map
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Date");

        // Display the Map
        System.out.println("Initial Map: " + map);

        // Get a value by key
        String value = map.get(2); // Gets the value associated with key 2
        System.out.println("Value for key 2: " + value);

        // Remove a key-value pair by key
        map.remove(3); // Removes the entry for key 3
        System.out.println("After removing key 3: " + map);

        // Check if a key exists in the Map
        boolean hasKey4 = map.containsKey(4);
        System.out.println("Map contains key 4: " + hasKey4);

        // Check if a value exists in the Map
        boolean hasValueDate = map.containsValue("Date");
        System.out.println("Map contains value 'Date': " + hasValueDate);

        // Get the size of the Map
        int size = map.size();
        System.out.println("Size of the Map: " + size);

        // Iterate through the Map using entrySet
        System.out.println("Iterating through Map using entrySet:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Iterate through the Map using keySet
        System.out.println("Iterating through Map using keySet:");
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Iterate through the Map using values
        System.out.println("Iterating through Map using values:");
        for (String val : map.values()) {
            System.out.println("Value: " + val);
        }

        // Clear all entries from the Map
        map.clear();
        System.out.println("Map after clearing: " + map);

        // Check if the Map is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is the Map empty: " + isEmpty);
    }
}
