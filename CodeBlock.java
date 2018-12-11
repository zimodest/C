public class CodeBlock{
    
    private int codeline ;
    
    private String codeFileName;
    
    private int salary  ;
    
    static {
        System.out.println("静态块， 类");
    }
    
    {
        //暗示 它的执行在CodeBlock之前
        System.out.println("构造块，非静态块");
        codeline = 10;  
        //这里进行初始化
        salary = codeline * 2;
    }
    
    public CodeBlock(){
       //可以再这里进行 初始 
       System.out.println("CodeBlock 构造方法执行"); 
    }
    
    public static void norCodeBlock(){
         {
          int x = 10;
          System.out.println(x);  
        }
        int x = 100; 
        System.out.println(x);
    }
    
    public static void main(String[] args){
        //CodeBlock codeBlock1 = new CodeBlock();
        //CodeBlock codeBlock2 = new CodeBlock();
        //CodeBlock codeBlock3 = new CodeBlock();
        System.out.println("main");
        new StaticBlock();
       
    }
}