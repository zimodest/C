
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


需求：存储三个学生对象，并遍历。用两种方式遍历
 练习：
 		Vector和LinkedList。
		存储字符串并遍历
 		存储自定义对象并遍历