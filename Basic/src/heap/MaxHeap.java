package heap;

/**
 * 最大堆
 * 主要操作包括：初始化最大堆 插入节点 删除节点
 * 用数组表示完全二叉树有节点上的特性 (不使用的数组0点会清晰一些)
 * Created by sun on 2020/2/3
 */
public class MaxHeap {

    private int[] heap;
    private int maxSize = -1;
    private int heapSize = 0;

    private final int DEFAULT_HEAP_SIZE = 100;

    public MaxHeap(int[] heap) {
        if(this.maxSize == -1) maxSize = DEFAULT_HEAP_SIZE;
        this.heap = new int[maxSize];
        System.arraycopy(heap, 0, this.heap, 1, heap.length);
        heapSize = heap.length;
    }

    public MaxHeap(int[] heap, int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
        System.arraycopy(heap, 0, this.heap, 1, heap.length);
        heapSize = heap.length;
    }

    public void init() {
        print();
        int size = heap.length;
        for (int i = size / 2; i >= 1; i--) {
            // 存储当前节点
            int temp = heap[i];
            // 比较两个子节点
            int left = i * 2;
            while (left < size) {
                if (left + 1 < size && heap[left] < heap[left + 1]) {
                    // 左节点小于右节点
                    left++;
                }
                // 比较子节点中较大的那个和自己的大小
                if (heap[left] <= temp) {
                    break;
                } else {
                    // 自己和子节点交换 这里不能使用i 要使用left / 2
                    heap[left / 2] = heap[left];
                    heap[left] = temp;
                    // 自己调整到子节点的位置 继续向下比较 直到这个堆调整完成
                    left *= 2;
                }
            }
        }
        print();
    }

    public void insert(int node) {
        // 插入节点到最大堆
        if (heapSize >= maxSize) {
            System.out.println("out of size");
            return;
        }
        // 插入到最后
        heap[heapSize + 1] = node;
        heapSize++;
        // 循环向父节点比较交换 直到顶
        for (int i = heapSize; i > 1; i /= 2) {
            if (heap[i / 2] < heap[i]) {
                int temp = heap[i];
                heap[i] = heap[i / 2];
                heap[i / 2] = temp;
            } else {
                break;
            }
        }
    }

    private void print() {
        for (int i = 1; i <= heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        MaxHeap maxHeap = new MaxHeap(arr);
        maxHeap.init();
        maxHeap.insert(13);
        maxHeap.print();
    }

}
