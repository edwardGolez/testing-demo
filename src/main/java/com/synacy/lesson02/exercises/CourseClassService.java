package com.synacy.lesson02.exercises;

import com.synacy.lesson02.exercises.domain.CourseClass;
import com.synacy.lesson02.exercises.domain.Student;

public interface CourseClassService {
	void enrollStudentToClass(Student student, CourseClass courseClass);
}
