// import java.util.ArrayList;
// import java.util.Iterator;

// public class ListDemo {
// 	public static void main(String[] args) {
// 		ArrayList array = new ArrayList();

// 		array.add("hello");
// 		array.add("world");
// 		array.add("java");

// 		// 迭代器
// 		Iterator it = array.iterator();
// 		while (it.hasNext()) {
// 			String s = (String) it.next();
// 			System.out.println(s);
// 		}
// 		System.out.println("--------------");
// 		// 普通for
// 		for (int x = 0; x < array.size(); x++) {
// 			String s = (String) array.get(x);
// 			System.out.println(s);
// 		}
// 	}


public class Student {
	private String name;
	private int age;
	public Student() {
		super();
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}


public class ListTest {
	public static void main(String[] args) {
		// 创建集合对象
		ArrayList array = new ArrayList();
		// 创建元素对象
		Student s1 = new Student("朱元璋", 50);
		Student s2 = new Student();
		s2.setName("李世民");
        		s2.setAge(60);
		Student s3 = new Student("秦始皇", 40);
		// 把元素添加到集合
		array.add(s1);
		array.add(s2);
		array.add(s3)
		// 遍历集合
		Iterator it = array.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s.getName() + "---" + s.getAge());
		}
		System.out.println("-----------------");

		for (int x = 0; x < array.size(); x++) {
			Student s = (Student) array.get(x);
			System.out.println(s.getName() + "---" + s.getAge());
		}
	}
}
