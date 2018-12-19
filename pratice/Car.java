public class Car {
    
    //属性
	private int num;
	private String color;
	private String brand;
    
    //无setter  品牌，最高时速，发动机编号
    
    //构造方法
	public Car(int num){
		this.num=num;
	}
	public Car(int num,String brand){
		this(num);
		this.brand=brand;
	}
	public Car(int num,String brand,String color){
		this(num,brand);
		this.color=color;
	}
	
    //普通方法-行为
	public String  carInfo(){
		return "车牌号："+num+",品牌："+brand+",颜色："+color;
	} 
	
	public void ride(){
        System.out.println(this.carInfo());
		System.out.println("汽车可以在马路上行驶");
        System.out.println(this);
	}
    
    //getter setter方法
	
    //static 
    public static void print(String message){
        //System.out.prinltn(this.ride());//error
        //System.out.prinltn(this.color);//error
        System.out.println(message);
    }
    
	public static void main(String[] args){
		Car car=new Car(001,"A","黑色");//hashcode
		car.ride();
        Car car2= new Car(002);
        
        print("Hello");//静态方法，类方法
        Car.print("Java");//通过类名调用方法
        
	}
}