import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * @author Sunss
 * @since 2021/3/26
 */
public class LRUCache<V> {

    private int capacity = 1024; // 容量
    private final Map<String, ListNode<String, V>> table = new ConcurrentHashMap<>(); // 缓存表
    private final ListNode<String, V> head;
    private final ListNode<String, V> tail;

    public LRUCache(int capacity) {
        this();
        this.capacity = capacity;
    }

    public LRUCache() {
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    public ListNode<String, V> get(String key) {
        ListNode<String, V> node = table.get(key);
        if (node != null) {
            // 更新LRU的状态，把这个key对应的内容存到链表头
            // 先把这个节点摘出来
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 在把它链到链表头部
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            return node;
        } else {
            // 做相关操作，去其它地方找数据(比如数据库)，然后再把它存进来，这里随机生成
            Random random = new Random();
            ListNode<String, V> newNode = new ListNode(key, random.nextInt(100));
            put(key, newNode);
            return newNode;
        }
    }

    public void put(String key, ListNode<String, V> node) {
        if (table.size() >= capacity) {
            // 删去尾部
            ListNode<String, V> delNode = tail.prev;
            delNode.prev.next = tail;
            tail.prev = delNode.prev;

            String delKey = delNode.getKey();
            table.remove(delKey);
        }
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

        table.put(key, node);
    }


    public static class ListNode<K, V> {
        private K key;
        private V value;
        ListNode<K, V> prev;
        ListNode<K, V> next;

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {

        }

        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

}
