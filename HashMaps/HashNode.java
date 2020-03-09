package HashMaps;

public class HashNode<KeyType, ValueType> {
    KeyType key;
    ValueType value;
    HashNode<KeyType, ValueType> next;

    public HashNode(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }
}
