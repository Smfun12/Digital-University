public class Cathedra {
	private String name;
	private Student[] students = {};
	private Lecturer[] lecturers = {};

	public Cathedra(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addStudent(Student student) {
		for (Student s : students) {
			if (s.getName().equals(student.getName())) {
				System.out.println("Student with name: " + s.getName() + " already exist");
				return;
			}
		}
		Student[] temp = new Student[students.length + 1];
		System.arraycopy(students, 0, temp, 0, students.length);
		temp[students.length] = student;
		students = temp;
	}

	public void addLecturer(Lecturer lecturer) {
		for (Lecturer l : lecturers) {
			if (l.getName().equals(lecturer.getName())) {
				System.out.println("Lecturer with name: " + l.getName() + " already exist");
				return;
			}
		}
		Lecturer[] temp = new Lecturer[lecturers.length + 1];
		System.arraycopy(lecturers, 0, temp, 0, lecturers.length);
		temp[lecturers.length] = lecturer;
		lecturers = temp;
	}

	public Student[] getStudents() {
		return students;
	}

	public Lecturer[] getLecturers() {
		return lecturers;
	}

	public void editStudent(String oldName) {
		
		for (int i = 0; i < students.length; i++) {
			if (students[i].getName().equals(oldName)) {
				System.out.println("Student: " + students[i].getName() + ", course: " + students[i].getCourse() + ", group: "
						+ students[i].getGroup());
				int choice = DataInput.getInt(
						"What do you want to change? To change name, press 1, course - 2, group - 3.");
				if (choice == 1) {
					String result = DataInput.getStr("New name: ");
					students[i].setName(result);
					System.out.println(
							"Student's name " + oldName + " was succesfully changed to " + result);
				} else if (choice == 2) {
					int result = DataInput.getInt("New course: ");
					students[i].setCourse(result);
					System.out.println("Student's course was succesfully changed to " + result);
				} else if (choice == 3) {
					String result = DataInput.getStr("New group: ");
					students[i].setGroup(result);
					System.out.println("Student's group was succesfully changed to " + result);
				} else
					System.out.println("Wrong number");
				break;
			}
			if (i == students.length - 1) {
				System.out.println("Student " + oldName + " was not found");
			}
		}
	}

	public void editLecturer(String oldName) {
		String result = DataInput.getStr("Change name: ");
		for (int i = 0; i < lecturers.length; i++) {
			if (lecturers[i].getName().equals(oldName)) {
				lecturers[i].setName(result);
				System.out.println("Lecturer's name " + oldName + " was succesfully changed to " + result);
				break;
			}
			if (i == lecturers.length - 1) {
				System.out.println("Lecturer " + oldName + " was not found");
			}
		}
	}

	public void deleteStudent(String oldName) {
		
		
		Student[] temp;
		int counter = 0;
		if (students.length == 0) {
			temp = new Student[students.length];
		} else {
			temp = new Student[students.length - 1];
		}
		for (int i = 0, k = 0; i < students.length; i++) {
			if (students[i].getName().equals(oldName) && counter == 0) {
				System.out.println("Student " + oldName + " was succesfully deleted");
				counter++;
				continue;
			}
			temp[k++] = students[i];
		}
		students = temp;
	}
		
		
		
		

	public void deleteLecturer(String oldName) {
		Lecturer[] temp;
		if (lecturers.length == 0) {
			temp = new Lecturer[lecturers.length];
		} else {
			temp = new Lecturer[lecturers.length - 1];
		}
		for (int i = 0, k = 0; i < lecturers.length; i++) {
			if (lecturers[i].getName().equals(oldName)) {
				System.out.println("Lecturer " + oldName + " was succesfully deleted");
				continue;
			}
			temp[k++] = lecturers[i];
		}
		lecturers = temp;
	}
}
