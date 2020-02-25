import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashSet;

import static java.util.Collections.sort;

public class ListDivider {
    public ListDivider(){

    }

    public int[][] divideList(int[] elementos, float fraccion){
        ArrayList<Integer> grupList = new ArrayList<Integer>();
        for (int elem: elementos){
            if (!grupList.contains(elem)){
                grupList.add(elem);
            }
        }
        int[] grups = grupList.stream().mapToInt(i->i).toArray();
        int[] subtotales = obtener_subtotales_por_grupo(elementos, grups);
        int[] en_prim_list = new int[grups.length];
        for (int i=0; i< subtotales.length; i++){
            en_prim_list[i] = Math.round(fraccion * subtotales[i]);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int j=0; j < grups.length; j++){
            for (int i=0; i< elementos.length; i++){
                if (elementos[i] == grups[j]){
                    if (en_prim_list[j] > 0){
                        list1.add(i);
                        en_prim_list[j]--;
                    }else{
                       list2.add(i);
                    }
                }
            }
        }
        sort(list1);
        sort(list2);

        int[][] lists = new int[][]{
            list1.stream().mapToInt(i->i).toArray(),
            list2.stream().mapToInt(i->i).toArray()
        };
        return lists;
    }

    public int[] obtener_subtotales_por_grupo(int[] lista, int[] grupos){
        throw new NotImplementedException();
    }
}
