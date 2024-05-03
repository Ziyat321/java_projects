public class MyArrays {

    public static void main(String[] args) {

        /*int[] arr = new int[]{3, -78, 1, 443, -98, 12, 43, -65};

        System.out.print("1)");
        for (int i = 0; i < 3; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("2)");
        for (int i = 1; i < arr.length - 1; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("3)");
        for (int i = 0; i < arr.length; i++){
            if(i % 2 == 1) System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("4)");
        for (int i = 0; i < arr.length/2; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("5)");
        for (int i = arr.length/2; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("6)");
        for (int i = arr.length - 3; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("7)");
        for (int i = arr.length - 1; i >=0; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        int posCount = 0, negCount = 0;

        System.out.print("8)");
        for (int i = 0; i < arr.length; i++){
            if(arr[i] < 0) negCount++;
        }
        System.out.println("Количество отрицательных чисел = " + negCount);

        System.out.print("9)");
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > 0) posCount++;
        }

        if(negCount < posCount) System.out.println("Положительных чисел больше чем отрицательных.");
        else if (negCount > posCount) System.out.println("Отрицательных чисел больше чем положительных.");
        else System.out.println("Положительных и отрицательных чисел одинаковое количество.");

        System.out.print("10)");
        for (int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]) System.out.print(arr[i] + " ");;
        }
        System.out.println();

        boolean increasing_seq = true;

        System.out.print("11)");
        for (int i = 1; i < arr.length; i++){
            if (arr[i] <= arr[i-1]){
                increasing_seq = false;
                break;
            }
        }
        if(increasing_seq) System.out.println("Последовательность является возрастающей.");
        else System.out.println("Последовательность не является возрастающей.");*/

        int[] nums1 = new int[]{1, 2, 3, 54, 32, 87};
        int[] nums2 = new int[]{98, 22, 4, 5};

        int size = nums1.length / 2 + nums2.length / 2;
        int[] nums3 = new int[size];

        System.out.print("12)");

        int pos = 0;
        for (int i = 0; i < nums1.length / 2; i++) {
            nums3[pos] = nums1[i];
            pos++;
        }

        /*for(int i = 0; i < nums2.length/2; i++){
            nums3[nums1.length/2 + i] = nums2[nums2.length/2 + i];
        }*/

        for (int i = nums2.length / 2; i < nums2.length; i++) {
            // nums3[i] = nums2[i - nums1.length/2 + nums2.length/2];
            nums3[pos] = nums2[i];
            pos++;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println();

        System.out.print("13)");

        int min = nums1[0];
        int max = nums1[0];
        int minPos = 0, maxPos = 0;

        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] < min) {
                min = nums1[i];
                minPos = i;
            }
            if (nums1[i] > max) {
                max = nums1[i];
                maxPos = i;
            }
        }

        System.out.println("Минимальное число - " + min);
        System.out.println("   Максимальное число - " + max);

        nums1[minPos] = max;
        nums1[maxPos] = min;

        System.out.print("14)");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();


        boolean unique = true;

        for (int i = 0; i < nums1.length - 1; i++) {
            if (!unique) break;
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[i] == nums1[j]) {
                    unique = false;
                    break;
                }
            }
        }

        System.out.print("15)");
        if (unique) {
            System.out.println("Массив является уникальным.");
        } else {
            System.out.println("Массив не является уникальным.");
        }


        int[] ones = new int[]{1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1 ,1, 1};

        int counter = 0;
        int maxOnes = 0;

        for (int i = 0; i < ones.length; i++) {
            if (ones[i] == 1) {
                counter++;
            } else {
                if (counter > maxOnes) maxOnes = counter;
                counter = 0;
            }

        }
        if (counter > maxOnes) maxOnes = counter;

        System.out.print("16)");
        System.out.println("Максимальное количество подряд встречающихся единиц = " + maxOnes);

        for(int i = 0; i < nums1.length/2; i++){
            int temp = nums1[i];
            nums1[i] = nums1[nums1.length - 1 - i];
            nums1[nums1.length - 1 - i] = temp;
        }

        System.out.print("17)");
        for(int i = 0; i < nums1.length; i++){
            System.out.print(nums1[i] + " ");
        }
        System.out.println();


    }
}
