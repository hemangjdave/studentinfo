package com.techrevolution.jpawithhibernate.studentinfo;

import com.techrevolution.jpawithhibernate.studentinfo.entities.Course;
import com.techrevolution.jpawithhibernate.studentinfo.entities.Passport;
import com.techrevolution.jpawithhibernate.studentinfo.entities.Review;
import com.techrevolution.jpawithhibernate.studentinfo.entities.Student;
import com.techrevolution.jpawithhibernate.studentinfo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentinfoApplication {

    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentinfoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            saveStudent();
        };
    }

    private void saveStudent(){
        Student student = Student.builder()
                .firstName("Hemang")
                .lastName("Dave")
                .email("hemangjdave@gmail.com")
                .passport(Passport.builder().passportNumber("A12345").build())
                .courses(
                        Set.of(
                                Course.builder()
                                        .courseName("EffetiveJava")
                                        .reviews(
                                                Set.of(
                                                        Review.builder().review("AwesomeCourse").rating(5).build(),
                                                        Review.builder().review("ExtraOrdinaryCourse").rating(5).build(),
                                                        Review.builder().review("WorthTheMoney").rating(5).build()
                                                )
                                        ).build()
//                                    Course.builder()
//                                            .courseName("JavaConcurrencyInPractice").build()
                        )
                )
                .build();
        studentRepository.save(student);
    }

}
