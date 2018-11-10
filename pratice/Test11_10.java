1.编写一个算法来判断一个数是不是“快乐数”。
一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直
到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
示例:
输入: 19 输出: true 
解释:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

解法1:
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int flag = getNext(n);
            if (set.contains(flag)) {
                return false;
            }else {
                set.add(flag);
                n = flag;
            }
        }
        return true;

    }
    public int getNext(int num) {
        int result = 0;
        result = result+((num % 10)*(num % 10));
        num = num / 10;
        if (num == 0) {
            return result;
        }else {
            return result+getNext(num);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(20));
    }
}

解法2:
public class Solution {
    public boolean isHappy(int n) {
        while (true) {
           int flag = getNext(n);
           if (flag == 1) {
               return true;
           }else {
               n = flag;
               if (n == 89) {
                   return false;
               }
           }
        }
    }
    public int getNext(int num) {
        int result = 0;
        result = result+((num % 10)*(num % 10));
        num = num / 10;
        if (num == 0) {
            return result;
        }else {
            return result+getNext(num);
        }
    }

第三题:
public class Solution {
    public static void main(String[] args) {
        int[] people = new int[10];
        // 给每个人编号
        for (int i = 0;i < 10;i++) {
            people[i] = i+1;
        }
        // 报数标志
        int flag = 0;
        // 退出人数
        int quitPeople = 0;
        // 计数器
        int i = 0;
        while (quitPeople < 9) {
            if (people[i] != 0 ) {
                // 该编号的人还在圈中
                flag++;
            }
            if (flag == 3) {
                flag = 0;
                people[i] = 0;
                quitPeople++;
            }
            i++;
            if (i == 10) {
                i = 0;
            }
        }
        for (int j = 0;j < 10;j++) {
            if (people[j] != 0) {
                System.out.println(j+1);
            }
        }
    }
}
    
