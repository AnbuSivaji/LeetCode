public class AddArray {
    public static int[] addArrays(int[] arr1, int[] arr2) {
        int maxLength = Math.max(arr1.length, arr2.length);
        int[] result = new int[maxLength];
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int num1 = i < arr1.length ? arr1[arr1.length - 1 - i] : 0;
            int num2 = i < arr2.length ? arr2[arr2.length - 1 - i] : 0;

            int sum = num1 + num2 + carry;
            result[maxLength - 1 - i] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            int[] extendedResult = new int[maxLength + 1];
            System.arraycopy(result, 0, extendedResult, 1, maxLength);
            extendedResult[0] = carry;
            return extendedResult;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        int[] result = addArrays(arr1, arr2);

        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num);
        }
    }
}