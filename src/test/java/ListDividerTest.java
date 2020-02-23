import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ListDividerTest {
    private int[] elementos;
    private float fraccion;
    private int[] list1;
    private int[] list2;
    private static ListDivider listDivider;

    public ListDividerTest(int[] elementos, float fraccion, int[] list1, int[] list2){
        this.elementos = elementos;
        this.fraccion = fraccion;
        this.list1 = list1;
        this.list2 = list2;
    }

    @Parameters
    public static Collection<Object[][]> data(){
        return (Collection<Object[][]>) Arrays.asList(new Object[][][]{
                {{2,2,-3}, {0.5}, {-3,2}, {2}},
                {{2,2,3}, {1}, {2,2,3}, {}},
                {{3,4,3,4}, {0.45}, {3,4}, {3,4}},
                {{2,-1,2,3}, {0.4}, {2}, {-1,2,3}},
                {{1,2,2,3}, {0}, {}, {1,2,2,3}},
                {{2,2,-6,-6,3,3}, {0.5}, {-6,2,3}, {-6,2,3}},
                {{}, {0.467}, null, null},
                {null, {0.32}, null, null},
                {{9,-6,9,4}, null, null, null},
                {{3,7,5,2,2,5}, {-3.2}, null, null},
                {{7,7,7,8,8}, {1.1}, null, null},
                {{6,6,6,6,6}, {0.8}, {6,6,6,6}, {6}},
                {{5,4,2,9,6,7,1}, {0.6}, {1,2,4,5,6,7,9}, {}},
                {{0,3,8,1,7,4}, {0.4}, {}, {0,1,2,3,4,7,8}},
                {{-3,-8,-8,-1,-3}, {0.3}, {-8,-3}, {-8,-3,-1}},
        });
    }

    @BeforeClass
    public static void iniciador(){
        listDivider = new ListDivider();
    }

    @Test
    void divideList() {
    }
}