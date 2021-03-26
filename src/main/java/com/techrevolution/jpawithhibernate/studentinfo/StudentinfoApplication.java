package com.techrevolution.jpawithhibernate.studentinfo;

import com.techrevolution.jpawithhibernate.studentinfo.entities.Passport;
import com.techrevolution.jpawithhibernate.studentinfo.entities.Student;
import com.techrevolution.jpawithhibernate.studentinfo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentinfoApplication {

	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentinfoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args) -> {
			Stream.of(
					Student.builder()
							.firstName("Hemang")
							.lastName("Dave")
							.email("hemangjdave@gmail.com")
							.passport(Passport.builder().passportNumber("A123456").build())
							.build(),
					Student.builder()
							.firstName("Krutarth")
							.lastName("Dave")
							.email("krutarthsdave@gmail.com")
							.passport(Passport.builder().passportNumber("B123456").build())
							.build(),
					Student.builder()
							.firstName("Shiva")
							.lastName("Dave")
							.email("shivajdave@gmail.com")
							.passport(Passport.builder().passportNumber("C123456").build())
							.build()
					).forEach(studentRepository::save);
		};
	}

}
