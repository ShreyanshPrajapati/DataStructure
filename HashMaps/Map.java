package HashMaps;

import java.util.ArrayList;

public class Map<KeyType, ValueType> {
    private ArrayList<HashNode<KeyType, ValueType>> hashMap;
    private int maxMapSize;
    private int hashMapSize;

    public Map() {
        this.maxMapSize = 100;
        this.hashMapSize = 0;
        this.hashMap = new ArrayList<>();
        for (int i = 0; i < this.maxMapSize; i++) {
            this.hashMap.add(null);
        }
    }

    public void AddElement(KeyType key, ValueType value) {
        int index = getIndex(key);
        HashNode<KeyType, ValueType> headNode = hashMap.get(index);
        while (headNode != null) {
            if (headNode.key.equals(key)) {
                headNode.value = value;
                return;
            }
            headNode = headNode.next;
        }
        headNode = hashMap.get(index);
        HashNode<KeyType, ValueType> newNode = new HashNode<>(key, value);
        newNode.next = headNode;
        hashMap.set(index, newNode);
        hashMapSize++;

        if ((1.0 * hashMapSize) / maxMapSize >= 0.6) {
            ArrayList<HashNode<KeyType, ValueType>> tempHashMap = hashMap;
            hashMap = new ArrayList<>();
            maxMapSize = 2 * maxMapSize;
            hashMapSize = 0;
            for (int i = 0; i < maxMapSize; i++) {
                hashMap.add(null);
            }
            for (HashNode<KeyType, ValueType> head : tempHashMap) {
                while (head != null) {
                    AddElement(head.key, head.value);
                    head = head.next;
                }
            }
        }
        return;
    }

    public ValueType GetElement(KeyType key) {
        int index = getIndex(key);
        HashNode<KeyType, ValueType> headNode = hashMap.get(index);
        while (headNode != null) {
            if (headNode.key.equals(key)) {
                return headNode.value;
            }
            headNode = headNode.next;
        }
        return null;
    }

    public ValueType RemoveElement(KeyType key) {
        int index = getIndex(key);
        HashNode<KeyType, ValueType> headNode = hashMap.get(index);
        HashNode<KeyType, ValueType> prevNode = null;
        while (headNode != null) {
            if (headNode.key.equals(key)) {
                break;
            } else {
                prevNode = headNode;
                headNode = headNode.next;
            }
        }
        if (headNode == null) {
            return null;
        }
        hashMapSize--;
        if (prevNode != null) {
            prevNode.next = headNode.next;
        } else {
            hashMap.set(index, headNode.next);
        }
        return headNode.value;
    }

    public int GetSize() {
        return this.hashMapSize;
    }

    public boolean IsEmpty() {
        return (this.hashMapSize == 0);
    }

    private int getIndex(KeyType key) {
        return key.hashCode() % this.maxMapSize;
    }
}
