import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class ListDividerTest {
    private int[]  elementos;
    private float  fraccion;
    private int[][] lists;
    private static ListDivider listDivider;

    public ListDividerTest(int[] elementos, float fraccion, int[][] lists){
        this.elementos = elementos;
        this.fraccion = fraccion;
        this.lists = lists;
    }

    @Parameters
    public static Collection<Object[]> data(){
        return (Collection<Object[]>) Arrays.asList(new Object[][]{
                {new int[]{2,2,-3}, (float) 0.5, new int[][]{{-3,2}, {2}}},
                {new int[]{2,2,3}, (float) 1, new int[][]{{2,2,3}, {}}},
                {new int[]{3,4,3,4}, (float)0.45, new int[][]{{3,4}, {3,4}}},
                {new int[]{2,-1,2,3}, (float)0.4, new int[][]{{2}, {-1,2,3}}},
                {new int[]{1,2,2,3}, (float)0, new int[][]{{}, {1,2,2,3}}},
                {new int[]{2,2,-6,-6,3,3}, (float)0.5, new int[][]{{-6,2,3}, {-6,2,3}}},
                {new int[]{}, (float)0.467, null},
                {null, (float)0.32, null},
                {new int[]{3,7,5,2,2,5}, (float)-3.2, null},
                {new int[]{7,7,7,8,8}, (float)1.1, null},
                {new int[]{6,6,6,6,6}, (float)0.8, new int[][]{{6,6,6,6}, {6}}},
                {new int[]{5,4,2,9,6,7,1}, (float)0.6, new int[][]{{1,2,4,5,6,7,9}, {}}},
                {new int[]{0,3,8,1,7,4}, (float)0.4, new int[][]{{}, {0,1,2,3,4,7,8}}},
                {new int[]{-3,-8,-8,-1,-3}, (float)0.3, new int[][]{{-8,-3}, {-8,-3,-1}}},
        });
    }

    @BeforeClass
    public static void iniciador(){
        listDivider = new ListDivider();
    }

    @Test
    public void divideList() {
        assertEquals(lists, listDivider.divideList(elementos, fraccion));
    }
}