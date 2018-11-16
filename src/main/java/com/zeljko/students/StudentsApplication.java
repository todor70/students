package com.zeljko.students;

import com.zeljko.students.entity.Course;
import com.zeljko.students.entity.Student;
import com.zeljko.students.repository.CourseRepository;
import com.zeljko.students.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CourseRepository courseRepository, StudentRepository studentRepository) {
		return args -> {

			Course course1 = new Course("java");
			Course course2 = new Course("spring");
			Course course3 = new Course("javaee");
			Course course4 = new Course("spring boot");
			Course course5 = new Course("android");

			courseRepository.save(course1);
			courseRepository.save(course2);
			courseRepository.save(course3);
			courseRepository.save(course4);
			courseRepository.save(course5);

			Student student1 = new Student("marko", "markovic", "marko@gmail.com");
			Student student2 = new Student("petar", "petrovic", "petar@gmail.com");
			Student student3 = new Student("ivana", "ivanovic", "ivana@gmail.com");
			Student student4 = new Student("jelena", "jovanovic", "jelena@gmail.com");

			student1.addCourse(course1);
			student1.addCourse(course2);
			student2.addCourse(course2);
			student2.addCourse(course3);
			student2.addCourse(course5);
			student3.addCourse(course3);
			student3.addCourse(course4);
			student4.addCourse(course4);
			student4.addCourse(course5);
			studentRepository.save(student1);
			studentRepository.save(student2);
			studentRepository.save(student3);
			studentRepository.save(student4);

		};
	}

}
