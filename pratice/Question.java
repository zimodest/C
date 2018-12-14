//error
class A extends B , C implements E {
    
}

//ok
class A extends B implements C ,E {
    
}

//error
class A extends B implements C implements E {
    
}

//error
class A implements B extends C{
    
}

//error
interface A{
    
    private int a = 10;
    
}

//error
class A{
    
    public abstract void a();
    
}

//ok
abstract class A{
 
    public void a(){
        
    }
    public void b(){
        
    }
}

//ok
abstract class A implements B{
    
    
}

//error
class A extends B , C {
    
}

//ok 
interface A extends B , C {
    
}

//error
interface class A extends B , C {
    
}




