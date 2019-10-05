public class MergeSort {
    static int[] mergeSort(int[] array) {

        return split(array);
    }

    private static int[] split(int[] array) {
        if (array.length <= 1) {
            return array;
        } else {
            int middleIndex = array.length / 2;

            int[] leftArray = split(getArray(array, 0, middleIndex - 1));
            int[] rightArray = split(getArray(array, middleIndex, array.length - 1));
            return merge(leftArray, rightArray);
        }
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] tempArray = new int[leftArray.length + rightArray.length];
        int leftIndex = 0, rightIndex = 0, tempIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                tempArray[tempIndex++] = leftArray[leftIndex++];
            } else if (leftArray[leftIndex] > rightArray[rightIndex]) {
                tempArray[tempIndex++] = rightArray[rightIndex++];
            } else {
                tempArray[tempIndex++] = leftArray[leftIndex++];
                tempArray[tempIndex++] = rightArray[rightIndex++];
            }
        }
        //If there are some remaining items in the leftArray
        while (leftIndex < leftArray.length) {
            tempArray[tempIndex++] = leftArray[leftIndex++];
        }
        //If there are still some remaining items in rightArray
        while (rightIndex < rightArray.length) {
            tempArray[tempIndex++] = rightArray[rightIndex++];
        }

        return tempArray;
    }

    private static int[] getArray(int[] array, int startingIndex, int lastIndex) {
        int[] tempArray = new int[lastIndex - startingIndex + 1];
        int tempIndex = 0;
        do {
            tempArray[tempIndex++] = array[startingIndex++];
        } while (startingIndex <= lastIndex);
        return tempArray;
    }

}
