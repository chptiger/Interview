package companies.guidewire;
/**
 * https://dzone.com/articles/custom-hashmap-implementation-in-java
 * 1. why use static nested class?
 * 2. could we move the static nested class outside of the class? useful link: https://www.tutorialspoint.com/What-is-a-static-class-in-Java
 *    You could not use the static keyword with a class unless it is an inner class.
 *    A static inner class is a nested class which is a static member of the outer class.
 *    It can be accessed without instantiating the outer class.
 * 3. it is generally necessary to override the hashCode method whenever equals method is overridden
 * 4. the modifier of the value in the Entry should not be final, the value of the map should be updated for PUT operation.
 */
public class myHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private int capacity;
    private static final int CAPACITY = 16;
    private int size = 0;

    private double lf = 0.75;

    public myHashMap() {
        this(CAPACITY);
    }

    public myHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[this.capacity];
    }

    private int getHash(K key) {
        return key == null? 0 : Math.abs(key.hashCode());
    }

    private int getBucketSize() {
        return buckets.length;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];
        while(bucket != null) {
            if(key == bucket.key) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public void put(K key, V value) {
        if(size == capacity * lf) {
//            rehash
            Entry<K, V>[] old = buckets;
            capacity *= 2;
            size = 0;
            buckets = new Entry[capacity];
            for(Entry<K,V> e : old) {
                while(e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
        }
        Entry<K, V> entry = new Entry<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();
        Entry<K, V> exist = buckets[bucket];
        if(exist == null) {
            buckets[bucket] = entry;
            size++;
        } else {
//            compare the key see if the key already exists
            while(exist.next != null) {
                if(exist.key.equals(key)) {
                    exist.value = value;// the modifier of the value could be final, because the value will be updated
                    return;
                }
                exist = exist.next;
            }

//            the last Entry of current bucket
            if(exist.key.equals(key)) {
                exist.value = value;
            } else {
                exist.next = entry;
                size++;
            }
        }
    }

    /**
     * there is final modifier for key, there is no set method for key, because the final modified variable is immutable.
     */
    static class Entry<K, V> {
        final K key; // no set method for the variable key
        V value; // the value of the key could be updated, there is no final modifier
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        /**
         * Note that it is generally necessary to override the hashCode method whenever equals method is overridden
         */
        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(obj instanceof Entry) {
                Entry entry = (Entry) obj;
                return key.equals(this.getKey()) && value.equals(this.getKey());
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 13;
            hash = 17 * hash + (key == null? 0 : key.hashCode());
            hash = 17 * hash + (value == null? 0 : value.hashCode());
            return hash;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}

