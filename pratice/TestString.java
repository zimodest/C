public class TestString{


    //String对象实例化
    public static void code1(){
        //1.直接赋值
        String str1=  "java is best";
        //2.构造方法创建
        String str2 = new String("java is best");
        
        System.out.println(str1);
        System.out.println(str2);
    }
    
    //String对象的内容比较
    public static void code2(){
        int x =10;
       int y =10;
       System.out.println("int x == y "+ (x==y));
       
       //1.不相等 地址不一样 == 是数值比较
       String str1= "java is best";
       String str2 =new String("java is best");
       System.out.println("String str1 == str2 "+ (str1==str2));
       
       System.out.println("String str1 equals str2 "+str1.equals(str2));
    }

    //String对象内容比较采用equals方法
    //如果和匿名String对象比较,建议匿名对象放在equals前面
    public static void code3(){
         String str1 =null ;
       String str = new String("Hello") ;    
   
       //方法2
       //System.out.println(str1.equals(str));
       System.out.println(str.equals(str1));
       
       //方法1 ： 把字符串匿名对象放在前面
       System.out.println("Hello".equals(str));
       //System.out.println(str.equals("Hello")); 
    }
    
    
    //直接赋值法和构造法在内存空间分配的不同
    public static void code4(){
         //直接赋值法
        String str1 = "hello" ; //堆空间开辟1个内存块，共享（字符串共享池）
		String str2 = "hello" ; 
		String str3 = "hello" ; 
		System.out.println(str1 == str2); //true
		System.out.println(str1 == str3); //true
		System.out.println(str2 == str3); //true
        
        //构造方法
        String str4 = new String("hello"); //堆空间上开辟2个内存块
        System.out.println(str4 == str1); //false
    }
    
    //通过构造方法实例化的字符串对象 入 共享池 
    public static void code5(){
         /*
        String str2 = new String("java is best").intern();//共享池
        String str1 = "java is best";
        System.out.println(str1==str2); //true
       */
        String str2 = new String("java is best");
        str2= str2.intern();
        String str1 = "java is best";
        System.out.println(str1==str2); //true
    }
    
    //字符串不可变更，如果对字符串进行修改，会创建新的字符串对象
    public static void code6(){
         //开辟 5 个
        String str = "hello" ; 
		str = str + " world" ; 
		str += "!!!" ; 
		System.out.println(str); // hello world!!!
    }
    
    //字符串和字符数组转换
    public static void code7(){
        String str ="hello";//5个 
       //获取字符串指定索引位置的字符
       char ch = str.charAt(0); //0-4
       System.out.println(ch);
       
       System.out.println("--------------------");
       
       str  = "helloworld";//10
       char[] chars = str.toCharArray();
       for(int i=0; i<chars.length; i++){
           System.out.print(chars[i]);
           if(i < chars.length-1){
               System.out.print(", ");
           }
       }
       System.out.println();
       
       System.out.println("--------------------");
       String str1 = new String(chars);
       System.out.println("Str1 = "+ str1);
       
       String str2 = new String(chars,0,5);
       System.out.println("Str2 = "+ str2);
       
       String str3 = new String(chars,5,5);
       System.out.println("Str3 = "+ str3);
    }
    
    //判断str的每个字符是否是0~9数字组成
    public static boolean isNumber(String str){
        char[] chars = str.toCharArray();
        for(int i=0; i< chars.length ; i++){
            char c  = chars[i];
            if( c >='0' && c <='9'){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
    //字符串和字节数组转换
    public static void code8(){
         
        String str = "helloWorld";
        byte[] bytes= str.getBytes();
        for(int i=0, j = bytes.length ; i<j ; i++){
            System.out.print(bytes[i]-32);
           if(i < j-1){
               System.out.print(", ");
           }
        }
        
        String str1 = new String(bytes);
        System.out.println(str1);
    }
    
    //字符串的比较
    public static void code9(){
        
        String str1 = "hello";
        String str2 = "Hello";
        String str3 = "helloworld";
        
        System.out.println(str1+ " equals "+ str2 + " = "+ str1.equals(str2)); //false
        
        System.out.println(str1+ " equalsIgnoreCase "+ str2 + " = "+ str1.equalsIgnoreCase(str2)); //true
        
        //关系
        //obj1.compareTo(obj2) ; 返回值的正负和0
        System.out.println("A".compareTo("a")); // -32 
        System.out.println("a".compareTo("A")); // 32
        System.out.println("A".compareTo("A")); // 0
        System.out.println("AB".compareTo("AC")); // -1
        
        System.out.println("刘".compareTo("杨")); //-5456    
    }
    
    
    //字符串方法
    public static void code10(){
        String str1 = "helloworld";
         
         System.out.println(str1 + " contains hello "+ str1.contains("hello"));
         
         
         String filename="Person.java";
         
         //1.判断文件是否是java源文件
         int index= filename.lastIndexOf("."); //6
         if(index !=-1){
             //字符串截取
            String extend= filename.substring(index+1);
            System.out.println("java".equals(extend));
         }else{
             System.out.println(". 不存在");
         }
        
         //2. endsWith
         System.out.println(filename+" is java file "+ filename.endsWith("java"));
        
        
         //字符串替换
         System.out.println(filename.replaceAll("a",""));
         System.out.println(filename.replaceFirst("a","A"));
         
         System.out.println("--------------");
         
         //字符串拆分
         String str2 = "hello world java";
         String[] words = str2.split(" ");
         for(int i=0; i<words.length; i++){
             System.out.print(words[i] + " , ");
         }
         System.out.println("--------------");
          
         String ip ="192.168.1.1";
         String[] ipsegment = ip.split("\\.");
         for(int i=0; i< ipsegment.length ;i++){
             System.out.print(ipsegment[i] + " , ");
         }
         System.out.println("--------------");
         String personInfo = "张三:28|李四:29|王五:30";
         String[] persons = personInfo.split("\\|");
         for(int i=0; i< persons.length ;i++){
             String person = persons[i];
             String[] values  = person.split(":");
             System.out.println("姓名："+values[0]+" 年龄："+values[1]);
         }
         

         //字符串截取
         System.out.println(ip.substring(4));
         System.out.println(ip.substring(4,6));
         
         
         //字符串的其它方法
         String str5  = "   java is best   ";
         System.out.println("["+str5+"]");
         System.out.println("["+str5.trim()+"]");
         
         String str6 = "java123中国";
         System.out.println("before "+str6 +" after " + str6.toUpperCase());
         
         
         System.out.println("helloWorld".length());//10;
         System.out.println(" ".isEmpty());//false
         System.out.println("abc".isEmpty());//false
         System.out.println("0".isEmpty());//false
         System.out.println("".isEmpty());//true
    }
    
    
    public static String toFirstCharUpperCase(String str){
        if(str == null){
            return null;
        }
        if(str.isEmpty()){
            return "";
        }
        char[] chars = str.toCharArray();
        char[] ch  = new char[]{ chars[0] };
        String firstStr = new String(ch).toUpperCase();
        
        return firstStr +  (str.length() == 1 ? "" :   str.substring(1));
        //测试用例
        /*
        System.out.println(toFirstCharUpperCase(null));//null
         System.out.println(toFirstCharUpperCase(""));//""
         System.out.println(toFirstCharUpperCase(" "));//" "
         System.out.println(toFirstCharUpperCase("a")); //A
         System.out.println(toFirstCharUpperCase("abc")); //Abc
         */
    }
    
    public static void main(String[] args){
           
         //StringBuilder 线程不安全
         //StringBuffer 线程安全
         StringBuffer sb = new StringBuffer("helloWorld")
             .delete(1,2) //-> hlloWorld
             .insert(2,"ww"); //-> hlwwloWorld
         /*
         for(int i=0; i<100 ; i++){
            sb.append("java")
              .append(" is ")
              .append(" best ")
              .append(i);//链式调用
         }*/
  

         //System.out.println(sb.reverse());
         System.out.println(sb.toString());
    }
}