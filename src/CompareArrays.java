import java.util.*;

public final class CompareArrays <T extends Comparable<T>>{

    //Repository for incoming values. If you want to add sorting by ASC, you can replace HashMap with a TreeMap
    private HashMap<T, Integer> vault = new HashMap<>();

    //Matching function. Repeats in the incoming data array are eliminated through the use of HashSet
    public T[] compareData(T[] first, T[] second) {
        List<T> result = new ArrayList<>();
        fillVault(new HashSet<>(Arrays.asList(first)));
        fillVault(new HashSet<>(Arrays.asList(second)));
        vault.forEach((key, value) -> {
            if (value > 1)
                result.add(key);
        });
        return result.toArray((T[]) new Object[result.size()]);
    }

    //The method for filling the Map(vault) with values
    private void fillVault (HashSet<T> input) {
        input.forEach(value -> {
            if (!vault.containsKey(value))
                vault.put(value, 1);
            else
                vault.put(value, vault.get(value) + 1);
        });
    }
}

/* © RadolfSurplus 27.02.2018 */