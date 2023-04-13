import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        List<Integer> nums2 = new ArrayList<>(List.of(1, 1, 2, 10, 4, 4, 5, 5, 6, 7));
        List<String> strings = new ArrayList<>(List.of("один", "один", "два", "два", "два", "три", "три", "три"));

        showEvenOrOddNum(nums, "even");
        showSortedOddNum(nums2);
        //uniqueWordsList(strings);
        countUniqueWords(strings);
    }

    public static void showEvenOrOddNum(List<Integer> nums, String param) {
        List<Integer> evenOrOddList = new ArrayList<>();
        String preposition = "не";
        int remainder = 1;
        if (param.equals("even")) {
            remainder = 0;
            preposition = "";
        }
        for (Integer listItem : nums) {
            if (listItem % 2 == remainder) {
                evenOrOddList.add(listItem);
            }
        }

        System.out.printf("Все %sчётные числа множества: %s\n", preposition, evenOrOddList.toString());
    }

    public static void showSortedOddNum(List<Integer> nums) {
        List<Integer> oddNums = new ArrayList<>();
        for (Integer itemVolume : nums) {
            if (itemVolume % 2 == 0) {
                oddNums.add(itemVolume);
            }
        }
        Collections.sort(oddNums);
        for (int i = 1; i < oddNums.size(); i++) {
            if (oddNums.get(i) == oddNums.get(i - 1)) {
                oddNums.remove(i);
                i--;
            }
        }
        System.out.printf("%s\n", oddNums.toString());
    }

    public static void uniqueWordsList(List<String> strings) {
        Collections.sort(strings);
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i - 1).equals(strings.get(i))) {
                strings.remove(i);
                i--;
            }
        }
        System.out.printf("%s\n", strings.toString());
    }

    public static void countUniqueWords(List<String> strings) {
        Map<String, Integer> stringMap = new HashMap<>();
        for (String listItem : strings) {
            stringMap.put(
                    listItem,
                    stringMap.containsKey(listItem) ? stringMap.get(listItem) + 1 : 1
            );
        }
        for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}