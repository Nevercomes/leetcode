package heap;

/**
 * 最大堆
 * 主要操作包括：初始化最大堆 插入节点 删除节点
 * 用数组表示完全二叉树有节点上的特性 (不使用的数组0点会清晰一些)
 * Created by sun on 2020/2/3
 */
public class MaxHeap {

    public void init(int[] heap) {
        print(heap);
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
                    heap[left/2] = heap[left];
                    heap[left] = temp;
                    // 自己调整到子节点的位置 继续向下比较 直到这个堆调整完成
                    left *= 2;
                }
            }
        }
        print(heap);
    }


    private void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        int[] arr = {-1, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        maxHeap.init(arr);
    }

}
