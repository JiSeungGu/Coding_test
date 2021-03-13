public class Quick_ver2 {
    private static int number = 11;
    private static int[] data;
    private static int cnt = 0; // quick_sort 호출 횟수
    public static void quick_sort(int[] data, int x, int y) {
        cnt++; 
        if (x >= y) {
            // 원소가 1개인 경우
            return;
        }
        int pivot = x;
        int left = pivot + 1;
        int right = y;
        int temp;
        while (left < right) {
            while (left <= y && data[left] < data[pivot]) {
                left++;
            }
            while (right >= pivot && data[pivot] < data[right]) {
                right--;
            }

            if (left < right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            } else {
                temp = data[pivot];
                data[pivot] = data[right];
                data[right] = temp;
            }
            quick_sort(data, x, right - 1);
            quick_sort(data, right + 1, y);
        }
    }
    public static void printData(int[] data, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        // 1~100 랜덤한 값 출력
        data = new int[number];
        for (int i = 0; i < number; i++) {
            data[i] = (int) (Math.random() * 100);
        }
        // 정렬 전
        printData(data, number);
        // 정렬 시작
        quick_sort(data, 0, number - 1);
        // 정렬 후
        printData(data, number);
        // 연산 횟수
        System.out.println("N : " + number + " / cnt : " + cnt);
    }
}



