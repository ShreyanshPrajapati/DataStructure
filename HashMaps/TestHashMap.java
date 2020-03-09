package HashMaps;

public class TestHashMap {

    public static void main(String[] args) {
        Map<Integer, String> testHashMap = new Map<>();
        System.out.println("Is my HashMap Empty?: " + testHashMap.IsEmpty());
        testHashMap.AddElement(1, "Shreyansh");
        testHashMap.AddElement(2, "Jay");
        testHashMap.AddElement(3, "Mustafa");
        testHashMap.AddElement(4, "Hem");
        System.out.println("Is my HashMap Empty?: " + testHashMap.IsEmpty());
        System.out.println("Size of the HashMap is: " + testHashMap.GetSize());
        System.out.println("Element at 1: " + testHashMap.GetElement(1));
        testHashMap.RemoveElement(1);
        System.out.println("Element at 1: " + testHashMap.GetElement(1));
        System.out.println("Size of the HashMap is: " + testHashMap.GetSize());
    }

}
