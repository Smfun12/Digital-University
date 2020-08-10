import java.util.Arrays;
import java.util.Comparator;

public class Utilities {

	public static void findStudentByName(University university, String name) {
		for (Faculty f : university.getFaculties()) {
			for (Cathedra c : f.getCathedras()) {
				Student[] students = c.getStudents();
				for (int i = 0; i < students.length; i++) {
					if (students[i].getName().equals(name)) {
						System.out.println("Student " + name + " was succesfully found. Course: "
								+ students[i].getCourse() + ", group: " + students[i].getGroup());
						break;
					}
					if (i == students.length - 1) {
						System.out.println("Student " + name + " was not found.");
					}
				}
			}
		}
	}

	public static void findLecturerByName(University university, String name) {
		for (Faculty f : university.getFaculties()) {
			for (Cathedra c : f.getCathedras()) {
				Lecturer[] lecturers = c.getLecturers();
				for (int i = 0; i < lecturers.length; i++) {
					if (lecturers[i].getName().equals(name)) {
						System.out.println("Lecturer " + name + " was succesfully found.");
						break;
					}
					if (i == lecturers.length - 1) {
						System.out.println("Lecturer " + name + " was not found.");
					}
				}
			}
		}
	}

	public static void findStudentsByCourse(University university, int course) {
		for (Faculty f : university.getFaculties()) {
			for (Cathedra c : f.getCathedras()) {
				Student[] students = c.getStudents();
				int i = 0;
				boolean notFound = true;
				System.out.println("Students on " + course + " course:");
				for (; i < students.length; i++) {
					if (students[i].getCourse() == course) {
						System.out.println(i + 1 + ". Name: " + students[i].getName() + ", group: "
								+ students[i].getGroup());
						notFound = false;
					}
				}
				if (notFound) {
					System.out.println("No students were found.");
				}
			}
		}
	}

	public static void findStudentsByGroup(University university, String group) {
		for (Faculty f : university.getFaculties()) {
			for (Cathedra c : f.getCathedras()) {
				Student[] students = c.getStudents();
				int i = 0;
				boolean notFound = true;
				System.out.println("Students in \"" + group + "\" group:");
				for (; i < students.length; i++) {
					if (students[i].getGroup().equals(group)) {
						System.out.println(i + 1 + ". Name: " + students[i].getName() + ", course: "
								+ students[i].getCourse());
						notFound = false;
					}
				}
				if (notFound) {
					System.out.println("No students were found.");
				}
			}
		}
	}

	public static Student[] getAllStudents(University university) {
		Student[] all = {};
		for (Faculty f : university.getFaculties()) {
			for (Cathedra c : f.getCathedras()) {
				Student[] students = c.getStudents();
				Student[] temp = new Student[students.length + all.length];
				System.arraycopy(all, 0, temp, 0, all.length);
				for (int i = all.length; i < students.length + all.length; i++) {
					temp[i] = students[i - all.length];
				}
				all = temp;
			}
		}
		return all;
	}

	public static Student[] getAllStudentsFromFaculty(Faculty faculty) {
		Student[] all = {};
		for (Cathedra c : faculty.getCathedras()) {
			Student[] students = c.getStudents();
			Student[] temp = new Student[students.length + all.length];
			System.arraycopy(all, 0, temp, 0, all.length);
			for (int i = all.length; i < students.length + all.length; i++) {
				temp[i] = students[i - all.length];
			}
			all = temp;
		}
		return all;
	}

	public static Lecturer[] getAllLecturersFromFaculty(Faculty faculty) {
		Lecturer[] all = {};
		for (Cathedra c : faculty.getCathedras()) {
			Lecturer[] lecturers = c.getLecturers();
			Lecturer[] temp = new Lecturer[lecturers.length + all.length];
			System.arraycopy(all, 0, temp, 0, all.length);
			for (int i = all.length; i < lecturers.length + all.length; i++) {
				temp[i] = lecturers[i - all.length];
			}
			all = temp;
		}
		return all;
	}

	public static void sortFacultyPersonsByAlphabeticOrder(University university) {
		boolean hasFaculties = university.printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty faculty = university.findFacultyByName(DataInput.getStr("Enter the faculty: "));
			if (faculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				int choice = DataInput
						.getInt("If you want to print all lecturers, press 1, student - 2: ");
				if (choice == 1) {
					Utilities.sortLecturersByAlphabet(Utilities.getAllLecturersFromFaculty(faculty));
				} else if (choice == 2) {
					Utilities.sortStudentsByAlphabet(Utilities.getAllStudentsFromFaculty(faculty));
				} else
					System.out.println("Wrong number. ");
			}
		}
	}

	public static void sortCathedrasStudentsByCourses(University university) {
		boolean hasFaculties = university.printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = university.findFacultyByName(DataInput.getStr("Enter faculty: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = cathedraFaculty
							.findCathedraByName(DataInput.getStr("Enter cathedra: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						Utilities.sortByCourse(cathedra.getStudents());
					}
				}
			}
		}
	}

	public static void sortCathedrasPersonsByAlphabeticOrder(University university) {
		boolean hasFaculties = university.printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty faculty = university.findFacultyByName(DataInput.getStr("Enter the faculty: "));
			if (faculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = faculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = faculty.findCathedraByName(DataInput.getStr("Enter cathedra: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						int choice = DataInput
								.getInt("If you want to print all lecturers, press 1, student - 2: ");
						if (choice == 1) {
							Utilities.sortLecturersByAlphabet(cathedra.getLecturers());
						} else if (choice == 2) {
							Utilities.sortStudentsByAlphabet(cathedra.getStudents());
						} else
							System.out.println("Wrong number. ");
					}
				}

			}
		}
	}

	public static Student[] findCathedrasStudentsByCourse(University university) {
		boolean hasFaculties = university.printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty faculty = university.findFacultyByName(DataInput.getStr("Enter the faculty: "));
			if (faculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = faculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = faculty.findCathedraByName(DataInput.getStr("Enter cathedra: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						int course = DataInput.getInt("Enter student's course: ");
						if (course < 1 || course > 6) {
							while (true) {
								System.out.println("Course value is either too high or too low. "
										+ "Please enter the correct value from range of 1 to 6.");
								course = DataInput.getInt("Enter course of the student: ");
								if (course > 0 && course < 7)
									break;
							}
						}
						Student[] students = {};
						for (Student student : cathedra.getStudents()) {
							if (course == student.getCourse()) {
								Student[] temp = new Student[students.length + 1];
								System.arraycopy(students, 0, temp, 0, students.length);
								temp[students.length] = student;
								students = temp;
							}
						}
						return students;
					}
				}
			}
		}
		return new Student[0];
	}

	public static void sortByCourse(Student[] students) {
		Arrays.sort(students, new CourseComparator());
		for (Student student : students) {
			System.out.println(" Course: " + student.getCourse() + ", name: " + student.getName()
					+ ", group: " + student.getGroup());
		}
	}

	public static void sortStudentsByAlphabet(Student[] students) {
		Arrays.sort(students, new NameComparator());
		for (Student student : students) {
			System.out.println("Name: " + student.getName() + ", course: " + student.getCourse()
					+ ", group: " + student.getGroup());
		}
	}

	public static void sortLecturersByAlphabet(Lecturer[] lecturers) {
		Arrays.sort(lecturers, new NameComparator());
		for (Lecturer lecturer : lecturers) {
			System.out.println("Name: " + lecturer.getName());
		}
	}
}

class CourseComparator implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		return a.getCourse() < b.getCourse() ? -1 : a.getCourse() == b.getCourse() ? 0 : 1;
	}
}

class NameComparator implements Comparator<Person> {
	@Override
	public int compare(Person a, Person b) {
		return a.getName().compareToIgnoreCase(b.getName());
	}
}
