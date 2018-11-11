package www.jin.java11_11;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Test1 {
    public static void main(String[] args) {
        int nums1[] = new int[]{1,2,3,0,0,0};
        int nums2[] = new int[]{2,5,6};
//        int[] nums1 = new int[]{1,2,3,4,5,6,0,0,0,0};
//        int[] nums2 = new int[]{2,5,7,9};
        merge(nums1,6,nums2,4);
        for(int i = 0; i<nums1.length;i++)
            System.out.println(nums1[i]);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0,j = 0;
        int k = 0;
        int num = 0;
        while(i<n){
            if(nums2[i] < nums1[j]){
                for(k = j+m;k>j;k--){
                    nums1[k] = nums1[k-1];
                }
                nums1[j] = nums2[i];
                j=j+2;
                i++;
                m--;
            }else if(nums2[i] == nums1[j]){
                j++;
                m--;
            }else{
                if(m == 0){
                    nums1[j] = nums2[i];
                    i++;
                    j++;
                }else {
                    j++;
                    m--;
                }
            }
        }


    }
}
