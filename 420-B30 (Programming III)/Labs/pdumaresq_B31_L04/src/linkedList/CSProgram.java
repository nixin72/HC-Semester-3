package linkedList;

public class CSProgram {
	private SinglyLinkedList<Course> CSCourses = new SinglyLinkedList<Course>();

	public CSProgram() {
		CSCourses.add(new Course("420-B31", "Programming III", 3, 2, 3));
		CSCourses.add(new Course("420-B10", "Programming I", 1, 3, 3));
		CSCourses.add(new Course("420-B20", "Programming II", 2, 3, 3));
		CSCourses.add(new Course("420-B40", "Programming IV", 4, 2, 2));
		CSCourses.add(new Course("420-B50", "Programming V", 5, 2, 2));
		CSCourses.add(new Course("420-A11", "Operating Systems", 1, 2, 2));
		CSCourses.add(new Course("420-A31", "Networks", 3, 3, 3));
		CSCourses.add(new Course("420-C10", "Web Programming I", 1, 2, 3));
		CSCourses.add(new Course("420-C20", "Web Programming II", 2, 2, 3));
		CSCourses.add(new Course("420-C30", "Web Programming III", 4, 2, 3));
		CSCourses.add(new Course("420-C40", "Web Programming IV", 5, 2, 3));
		CSCourses.add(new Course("420-D10", "Database I", 3, 3, 3));
		CSCourses.add(new Course("420-D20", "Database II", 4, 2, 2));
		CSCourses.add(new Course("420-E11", "Systems I", 3, 3, 3));
		CSCourses.add(new Course("420-E21", "Systems II", 4, 3, 3));
		CSCourses.add(new Course("420-E31", "Systems III", 5, 3, 2));
		CSCourses.add(new Course("420-E41", "Systems IV", 6, 1, 2));
		CSCourses.add(new Course("420-E50", "Development Project I", 5, 0, 6));
		CSCourses.add(new Course("420-E61", "Development Project II", 6, 0, 12));
		CSCourses.add(new Course("420-E71", "Maintenance Project", 6, 0, 6));
	} // CSProgram

	public SinglyLinkedList<Course> getCSCourses() {
		return CSCourses;
	} // getCSCourses()

	public void listCourses() {

		for (int i = 0; i < CSCourses.getLength(); ++i) {
			Course current = CSCourses.getElementAt(i);
			System.out.println("Semester: " + current.getSemester() + " Course: " + current.getCourseNumber() + " - "
					+ current.getCourseName());
		}
	} // listCourses()

	public int getHours(int semester) {
		int hours = 0;
		if (semester < 1 || semester > 6) {
			throw new IllegalArgumentException("Semester must be between 1 and 6");
		} else {
			for (byte q = 0; q < CSCourses.getLength(); q++) {
				Course current = CSCourses.getElementAt(q);
				if (current.getSemester() == semester) {
					hours += current.getClassHours();
				}
			}
		}
		System.out.println(hours);
		return hours;
	}
} // CSProgram
