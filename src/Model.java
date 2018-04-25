import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

class Model
{
    private ArrayList<Integer> stoneCount;
    private static HashMap<Integer, Integer> pair;
    private ChangeListener listener;
    private int playerTurn = 7;                     // 7 is for player 1, 14 i

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

    Model(int count)
    {
        initializeMap();
        stoneCount = new ArrayList<>(14);
        for (int i = 0; i < 14; i++)
            stoneCount.add(count);
    }

    ArrayList<Integer> getStoneCount()
    {
        return stoneCount;
    }


    void attach(ChangeListener l)
    {
        listener = l;
    }
}