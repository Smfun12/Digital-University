/**
 * This class creates University and contains faculties array
 * It is also operates with cathedras array(add,edit,delete cathedra)
 * @author Саша
 *
 */
public class University {
	private Faculty[] faculties = {};

	public University() {
		super();
	}
/**
 * Add faculty to array
 * @param faculty
 */
	public void addFaculty(Faculty faculty) {
		for (Faculty f : faculties) {
			if (f.getName().equals(faculty.getName())) {
				System.out.println("Faculty with name" + f.getName() + " already exist");
				return;
			}
		}
		Faculty[] temp = new Faculty[faculties.length + 1];
		System.arraycopy(faculties, 0, temp, 0, faculties.length);
		temp[faculties.length] = faculty;
		faculties = temp;
		
	}
/**
 * Edit faculty
 * @param facultyName
 */
	public void editFaculty(String facultyName) {
		Faculty faculty = findFacultyByName(facultyName);
		if (faculty == null) {
			System.out.println("Faculty " + facultyName + " was not found");
			return;
		}
		String result = DataInput.getStr("Change name: ");
		faculty.setName(result);
		System.out.println("Faculty " + facultyName + " was succesfully changed to " + result);
	}
/**
 * Delete faculty from array
 * @param facultyName
 */
	public void deleteFaculty(String facultyName) {
		Faculty faculty = findFacultyByName(facultyName);
		if (faculty == null) {
			System.out.println("Faculty " + facultyName + " was not found");
			return;
		}
		Faculty[] temp = new Faculty[faculties.length - 1];
		for (int i = 0, k = 0; i < faculties.length; i++) {

			if (faculties[i].equals(faculty)) {
				System.out.println("Faculty " + facultyName + " was succesfully deleted");
				continue;

			}
			temp[k++] = faculties[i];
		}
		faculties = temp;

	}
/**
 * Finder faculty, if its found return faculty name, else null
 * @param facultyName
 * @return facultyName
 */
	public Faculty findFacultyByName(String facultyName) {
		for (int i = 0; i < faculties.length; i++) {
			if (faculties[i].getName().equals(facultyName)) {
				return faculties[i];
			}
		}
		return null;
	}
/**
 * Print all faculties of the University
 * @return
 */
	public boolean printAllFaculties() {
		if (faculties.length != 0) {
			System.out.println("Faculties: ");
		}
		for (int i = 0; i < faculties.length; i++) {
			System.out.println(i + 1 + ". " + faculties[i].getName());
		}
		return faculties.length > 0;
	}
/**
 * 
 */
	public void addCathedra() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(DataInput.getStr("Enter faculty of cathedra: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				Cathedra cathedra = new Cathedra(DataInput.getStr("Enter cathedra's name: "));
				cathedraFaculty.addCathedra(cathedra);
				System.out.println("Cathedra " + cathedra.getName() + " was succesfully created");
			}
		}
	}

	public Faculty[] getFaculties() {
		return faculties;
	}

	public void editCathedra() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(
					DataInput.getStr("Enter faculty of cathedra to edit: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else
					cathedraFaculty.editCathedra(DataInput.getStr("Enter cathedra to edit: "));
			}
		}
	}

	public void deleteCathedra() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(
					DataInput.getStr("Enter faculty of cathedra to delete: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else
					cathedraFaculty.deleteCathedra(DataInput.getStr("Enter cathedra to delete: "));
			}
		}
	}

	public void addLecturer() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(DataInput.getStr("Enter faculty of lecturer: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = cathedraFaculty
							.findCathedraByName(DataInput.getStr("Enter cathedra of lecturer: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						Lecturer lecturer = new Lecturer(DataInput.getStr("Enter name of lecturer: "));
						cathedra.addLecturer(lecturer);
						System.out.println("Lecturer: " + lecturer.getName());
					}
				}
			}
		}
	}

	public void addStudent() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(DataInput.getStr("Enter faculty of student: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = cathedraFaculty
							.findCathedraByName(DataInput.getStr("Enter cathedra of student: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						String name = DataInput.getStr("Enter name of the student: ");
						int course = DataInput.getInt("Enter course of the student: ");
						if (course < 1 || course > 6) {
							while (true) {
								System.out.println("Course value is either too high or too low. "
										+ "Please enter the correct value from range of 1 to 6.");
								course = DataInput.getInt("Enter course of the student: ");
								if (course > 0 && course < 7)
									break;
							}
						}
						String group = DataInput.getStr("Enter group of student: ");
						Student student = new Student(name, course, group);
						cathedra.addStudent(student);
						System.out.println("Name: " + student.getName() + ", course: " + student.getCourse() + ", group: "
								+ student.getGroup());
					}
				}
			}
		}
	}

	public void editLecturer() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(DataInput.getStr("Enter faculty of lecturer: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = cathedraFaculty
							.findCathedraByName(DataInput.getStr("Enter cathedra of lecturer: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						cathedra.editLecturer(DataInput.getStr("Enter name of lecturer: "));
					}
				}
			}
		}
	}

	public void editStudent() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(DataInput.getStr("Enter faculty of student: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = cathedraFaculty
							.findCathedraByName(DataInput.getStr("Enter cathedra of student: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						Utilities.sortCathedrasPersonsByAlphabeticOrder(MainClass.NaUKMA);
						cathedra.editStudent(DataInput.getStr("Enter name of student: "));
					}
				}
			}
		}
	}

	public void deleteLecturer() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(DataInput.getStr("Enter faculty of lecturer: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = cathedraFaculty
							.findCathedraByName(DataInput.getStr("Enter cathedra of lecturer: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						cathedra.deleteLecturer(DataInput.getStr("Enter name of lecturer: "));
					}
				}
			}
		}
	}

	public void deleteStudent() {
		boolean hasFaculties = printAllFaculties();
		if (hasFaculties == false) {
			System.out.println("You need to create faculty first.");
		} else {
			Faculty cathedraFaculty = findFacultyByName(DataInput.getStr("Enter faculty of student: "));
			if (cathedraFaculty == null) {
				System.out.println("Faculty is not found.");
			} else {
				boolean hasCathedras = cathedraFaculty.printAllCathedras();
				if (hasCathedras == false) {
					System.out.println("You need to create cathedra first.");
				} else {
					Cathedra cathedra = cathedraFaculty
							.findCathedraByName(DataInput.getStr("Enter cathedra of student: "));
					if (cathedra == null) {
						System.out.println("Cathedra is not found.");
					} else {
						
						cathedra.deleteStudent(DataInput.getStr("Enter name of student: "));
					}
				}
			}
		}
	}

}
