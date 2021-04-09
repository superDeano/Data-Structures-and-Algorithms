import java.util.*;

public class Combinations {

    public static int[] findCombinations(int array[], int numberOfElementsPerCombination) {
        begin(array, numberOfElementsPerCombination);
        return array;
    }


    private static void begin(int array[], int numberOfElementsForCombination) {
        Queue<int[]> allCombinations = new LinkedList<>();
        int[] indexesForCombination = createArrayOfIndexes(numberOfElementsForCombination, array.length - 1);

        do {
            int[] combination = new int[numberOfElementsForCombination];

            for (int index = 0; index < indexesForCombination.length; index++) {

                try {
                    combination[index] = array[indexesForCombination[index]];
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            allCombinations.add(combination);

            indexesForCombination = incrementCombinationIndex(indexesForCombination, array.length - 1);
        } while (thereIsMoreCombinations(indexesForCombination, array.length - 1));

        print(allCombinations);
    }


    private static int[] createArrayOfIndexes(int numElements, int lastIndexFromArray) {
        int indexes[] = new int[numElements];
        Arrays.fill(indexes, 0);

        while (arrayHasSimilarIndexes(indexes)) {
            indexes = incrementCombinationIndex(indexes, numElements);
        }

        return indexes;
    }

    private static int[] incrementCombinationIndex(int[] indexes, int arrayLastIndex) {

        do {
            int atIndex = 0;

            try {
                if (indexes[indexes.length - 1] == arrayLastIndex) {
                    return indexes;
                } else {
                    indexes[atIndex]++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e + " in the incrementation");
            }

            for (atIndex = 0; atIndex < indexes.length; atIndex++) {
                if (indexes[atIndex] > arrayLastIndex) {
                    do {
                        indexes[atIndex] = 0;
                        if (indexesCanStillBeIncremented(indexes, arrayLastIndex)) {//TODO: make a function to check that the index does not go out of bound
                            indexes[atIndex + 1]++;
                        } else {
                            break;
                        }
                    } while (indexes[atIndex++] > arrayLastIndex && atIndex < indexes.length);
                }
            }
        } while (arrayHasSimilarIndexes(indexes));
        return indexes;
    }

    private static boolean thereIsMoreCombinations(int[] indexes, int arrayLastIndex) {
        for (int i = indexes.length - 1; i >= 0; i--) {
            if (indexes[i] < arrayLastIndex) {
                return true;
            }
        }
        return false;
    }

    private static boolean arrayHasSimilarIndexes(int[] indexes) {
        Set<Integer> store = new HashSet<Integer>();
        for (int index : indexes) {
            if (store.add(index) == false) {
                return true;
            }
        }
        return false;
    }

    private static void print(Queue queue) {
        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            int[] array = (int[]) iterator.next();
            for (int values : array) {
                System.out.print(values + " ");
            }
            System.out.println(" ");
        }
    }

    private static boolean indexesCanStillBeIncremented(int[] indexes, int lastIndex) {
        boolean canStillBeIncremented = true;
        boolean cannotContinue = false;

        int i = indexes.length - 1;

        if (indexes[i] == lastIndex) {
            for (; i > 0; i--) {

                if (i != 0) {

                    if (indexes[i] - 1 == indexes[i]) {
                        continue;
                    } else {
                        return canStillBeIncremented;
                    }
                } else {
                    return cannotContinue;
                }
            }
        }
        return canStillBeIncremented;
    }
}
