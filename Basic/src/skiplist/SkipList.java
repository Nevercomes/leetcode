package skiplist;

import java.util.Random;

/**
 * 跳表实现
 *
 * @author Sunss
 * @since 2020/9/10
 */


public class SkipList {

    class Node {
        private int data;

        /**
         * 表示当前节点位置的下一个节点所有层的数据，从上层切换到下层，就是数组下标 - 1
         * forwards[3]表示当前节点在第三层的下一个节点
         * 虽然叫forward，但它实际还是保存的next节点
         */
        private Node forwards[];

        private int maxLevel = 0;

        public Node(int level) {
            forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }

    }

    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    /**
     * 带头链表
     */
    private Node head = new Node(MAX_LEVEL);
    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        // 逐层遍历，从最高层开始
        for (int i = levelCount; i >= 0; i--) {
            // p的next的data >= value p的data < value
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i]; // 这里体现了forwards还是next的性质
            }
        }
        // 上一个for循环无论如何都会来到第零层
        // 上一个for循环里的while会定位到那个 >= value 的第0层节点
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        // 如果随机到的level比现有的层高要大，那么也只能再高一层了，而不是使用随机值
        if (level > levelCount) {
            level = ++levelCount;
        }
        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            // 这里的while同find，是节点查找的过程
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // 下面就是建立索引和节点的过程，这两者的过程被统一了起来
            if (level > i) {
                if (p.forwards[i] == null) {
                    p.forwards[i] = newNode;
                } else {
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    public void delete(int value) {
        // 保存需要删除的各层节点
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; i--) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public void printAll_beautiful() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }
}


