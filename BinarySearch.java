import java.util.*;

public class BinarySearch {

    // Optimized Bubble Sort
    static void bubbleSort(int[] num) {
        int n = num.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Exit early if no swap occurred
        }
    }

    // Proper Binary Search (Iterative)
    static void binarySearch(int[] num, int key) {
        int low = 0;
        int high = num.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (num[mid] == key) {
                System.out.println("Key found at index: " + mid);
                return;
            } else if (key < num[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Key not found.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[10];

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            num[i] = input.nextInt();
        }

        bubbleSort(num);

        System.out.print("Sorted Array: ");
        for (int x : num) {
            System.out.print(x + " ");
        }

        System.out.print("\nEnter the key to search: ");
        int key = input.nextInt();

        binarySearch(num, key);
    }
}
