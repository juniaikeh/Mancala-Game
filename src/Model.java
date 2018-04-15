import java.util.ArrayList;
import java.util.HashMap;

public class Model
{
    private ArrayList<Integer> stoneCount;
    private static HashMap<Integer, Integer> pair;

    private static void initializeMap()
    {
        pair = new HashMap<>();
        int[] keys = {1,2,3,4,5,6};
        int[] values = {13,12,11,10,9,8};
        for (int i = 0; i < keys.length; i++)
        {
            pair.put(keys[i], values[i]);
            pair.put(values[i], keys[i]);
        }
    }

    Model()
    {
        initializeMap();
        System.out.println(pair.toString());
        stoneCount = new ArrayList<>(14);
        for (int i = 0; i < 14; i++)
            stoneCount.add(0);
    }

    void remove(int index)
    {
        stoneCount.set(index, stoneCount.get(index)-1);
    }

    void add(int index)
    {
        stoneCount.set(index, stoneCount.get(index)+1);
    }

    boolean isEmpty(int index)
    {
        return stoneCount.get(index) == 0;
    }

    void capture(int index)
    {
        stoneCount.set(index, stoneCount.get(index) + stoneCount.get(pair.get(index)));
    }
}
