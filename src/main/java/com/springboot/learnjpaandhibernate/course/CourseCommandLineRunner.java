package com.springboot.learnjpaandhibernate.course;


import com.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

    /*@Autowired
    private CourseJdbcRepository repository;*/

    /*@Autowired
    private CourseJpaRepository repository;*/

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Silvi", "Silvi"));
        repository.save(new Course(2, "Rodri", "Rodri"));
        repository.save(new Course(3, "Feli", "Feli"));

        repository.deleteById(2l);

        System.out.println("Course 1 -> " + repository.findById(1l));

        System.out.println("All courses -> " + repository.findAll());
        System.out.println("Count -> " + repository.count());
        System.out.println(repository.findByAuthor("Silvi"));
        System.out.println(repository.findByAuthor(""));

    }
}
