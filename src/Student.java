
public class Student extends Person {
	private int course;
	private String group;

	public Student(String name, int course, String group) {
		super(name);
		this.course = course;
		this.group = group;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
