package lab09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	// getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course maxCourse = null;
		int maxStudents = 0;
		for (Course course : courses) {
			if (course.getType().equals("thực hành") && course.getStudents().size() > maxStudents) {
				maxStudents = course.getStudents().size();
				maxCourse = course;
			}
		}
		return maxCourse;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> studentsByYear = new HashMap<>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				if (!studentsByYear.containsKey(student.getYear())) {
					studentsByYear.put(student.getYear(), new ArrayList<>());
				}
				studentsByYear.get(student.getYear()).add(student);
			}
		}
		return studentsByYear;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> filteredCourses = new TreeSet<>(Comparator.comparingInt(c -> -c.getStudents().size()));
		for (Course course : courses) {
			if (course.getType().equals(type)) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	public static void main(String[] args) {
		
		Student student1 = new Student();
		student1.setId("1");
		student1.setName("Nguyen Van A");
		student1.setYear(2000);

		Student student2 = new Student();
		student2.setId("2");
		student2.setName("Tran Thi B");
		student2.setYear(2001);


		Course course1 = new Course();
		course1.setId("C1");
		course1.setTitle("Java Programming");
		course1.setType("thực hành");
		course1.setStudents(Arrays.asList(student1, student2));
		course1.setLecturer("Dr. C");

		Course course2 = new Course();
		course2.setId("C2");
		course2.setTitle("Web Development");
		course2.setType("lý thuyết");
		course2.setStudents(Collections.singletonList(student1));
		course2.setLecturer("Dr. D");

		
		Faculty faculty = new Faculty();
		faculty.setName("Khoa CNTT");
		faculty.setAddress("NlU");
		faculty.setCourses(Arrays.asList(course1, course2));

		// Kiểm tra các phương thức
		System.out.println( faculty.getMaxPracticalCourse().getTitle());
		System.out.println(faculty.groupStudentsByYear());
		System.out.println("Các khóa học lý thuyết: "
				+ faculty.filterCourses("lý thuyết").stream().map(Course::getTitle).collect(Collectors.toList()));
	}
	
}

