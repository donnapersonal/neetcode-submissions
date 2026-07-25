class LRUCache {
    private final int cap;
    private final LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        makeRecent(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        }

        if (cache.size() >= cap) {
            int oldestkey = cache.keySet().iterator().next();
            cache.remove(oldestkey);
        }

        cache.put(key, value);
    }

    private void makeRecent(int key) {
        int value = cache.remove(key);
        cache.put(key, value);
    }
}
