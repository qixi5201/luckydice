/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aa
 */
import java.util.Arrays;
public class project {
     public static void main(String[] args) {
        int p1w = 0;//玩家一勝場數
        int p2w = 0;//玩家二勝場數
        int n=1;//總場數
        while (p1w <= 2 || p2w <= 2) {

            int p1[] = new int[4];//設每玩家骰4次
            int p2[] = new int[4];
            for (int i = 0; i < 4; i++) {//隨機產生玩家點數
                p1[i] = (int) (Math.random() * 6) + 1;
            }
            for (int i = 0; i < 4; i++) {
                p2[i] = (int) (Math.random() * 6) + 1;
            }
           
            if (p1w >2 ^ p2w >2) {//當某一玩家勝三場以上結束遊戲
             
                break;
            }
          
            
            System.out.println("第"+n+"場");
             System.out.println();
            System.out.println("第一位玩家的骰子為:" + Arrays.toString(p1));
            System.out.println("第二位玩家的骰子為:" + Arrays.toString(p2));
            System.out.println();
            System.out.println("p1的分數為" + score(p1));
            System.out.println("p2的分數為" + score(p2));
            if (score(p1) > score(p2)) {//當玩家一分數高於玩家二，玩家一勝場加一
                p1w++;
            } else if (score(p2) > score(p1)) {//當玩家二分數高於玩家一，玩家二勝場加一
                p2w++;
            } else if (score(p1) == score(p2)) {//平手時，兩方各加一
              p1w++;
              p2w++;
            }
            n++;
            System.out.println("目前比分:(p1:p2)" + p1w + ":" + p2w);
            System.out.println("---------------------------------------------------");

        }
        //顯示結果
       if(p1w==p2w){
         System.out.println("無勝方\t\n比分為:"+p1w+":"+p2w);
     }
       else if(p1w==3){
        System.out.println("勝方為:p1\n比分為:(p1:p2)"+p1w+":"+p2w);
    }
     else if(p2w==3){
	 System.out.println("勝方為:p2\n比分為:(p1:p2)"+p1w+":"+p2w);
}
    

    }

//判斷是否四個點數皆同
    public static boolean all(int array[]) {
        boolean all = false;
        for (int i = 1; i < 4; i++) {
            if (array[i - 1] == array[i]) {
                all = true;
            }
        }
        return all;
    }
////判斷是否有三個點數相同

    public static boolean three(int array[]) {
        Arrays.sort(array);
        if (array[0] == array[1] && array[1] == array[2] && array[2] != array[3]) {
            return true;

        }
        if (array[2] == array[1] && array[3] == array[2] && array[0] != array[1]) {
            return true;

        }
        return false;
    }

    ////判斷是否有兩組兩個點數相同
    public static boolean two1(int array[]) {
        Arrays.sort(array);
        if (array[0] == array[1] && array[2] == array[3] && array[1] != array[2]) {

            return true;
        }

        return false;
    }

    ////判斷是否只有兩個點數相同
    public static boolean two2(int array[]) {
        Arrays.sort(array);
        if (array[0] == array[1] && array[2] != array[1] && array[3] != array[0] && array[2] != array[3]) {
            return true;
        } else if (array[1] == array[2] && array[0] != array[1] && array[3] != array[1] && array[0] != array[3]) {
            return true;
        } else if (array[2] == array[3] && array[0] != array[2] && array[1] != array[2] && array[0] != array[1]) {
            return true;
        }

        return false;
    }
    ////判斷是否點數皆不同

    public static boolean one(int array[]) {
        Arrays.sort(array);
        if (array[0] != array[1] && array[1] != array[2] & array[2] != array[3]) {
            return true;
        }

        return false;
    }

   
    //計算分數
    public static int score(int array[]) {
        int s = 0;
        if (one(array)) {
            s += 1;
        } else if (two2(array)^two1(array)) {
            s += 2;
        } else if (two1(array)^two2(array)) {
            s += 3;
        } else if (three(array)) {
            s += 4;
        } else if (all(array)) {
            s += 5;
        }

        return s;
    }

}
    
    