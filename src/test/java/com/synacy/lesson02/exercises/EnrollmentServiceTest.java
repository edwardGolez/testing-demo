package com.synacy.lesson02.exercises;

import com.synacy.lesson02.exercises.domain.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
/**
 * Created by michael on 5/3/17.
 */
public class EnrollmentServiceTest {

    private  EnrollmentService enrollmentService;

    @Mock StudentProfileService studentProfileService;
    @Mock CourseClassService courseClassService;
    @Mock EnrollmentNotificationService enrollmentNotificationService;
    @Mock StudyLoadFormatter studyLoadFormatter;
    @Mock SystemService systemService;

    @Before
    public void setUp() {
        enrollmentService = new EnrollmentService();

        enrollmentService.setStudentProfileService(studentProfileService);
        enrollmentService.setCourseClassService(courseClassService);
        enrollmentService.setEnrollmentNotificationService(enrollmentNotificationService);
        enrollmentService.setStudyLoadFormatter(studyLoadFormatter);
        enrollmentService.setSystemService(systemService);
    }

    @Test
    public void processEnrollment_shouldUpdateStudentProfile() throws Exception {
        EnrollmentDto enrollmentDto = mock(EnrollmentDto.class);

        enrollmentService.processEnrollment(enrollmentDto);
        verify(studentProfileService, times(1)).updateStudentProfile(ArgumentMatchers.eq(enrollmentDto.getStudentProfile()));
    }

    @Test
    public void processEnrollment_shouldEnrollStudentToACourse() throws Exception {
        EnrollmentDto enrollmentDto = mock(EnrollmentDto.class);

        Set<CourseClass> classes = new HashSet<CourseClass>();

        CourseClass class1 = mock(CourseClass.class);
        CourseClass class2 = mock(CourseClass.class);

        classes.add(class1);
        classes.add(class2);

        when(enrollmentDto.getEnrolledClasses()).thenReturn(classes);

        Student student = mock(Student.class);

        when(enrollmentDto.getStudent()).thenReturn(student);

        enrollmentService.processEnrollment(enrollmentDto);

        verify(courseClassService, times(1)).enrollStudentToClass(
                ArgumentMatchers.eq(student),
                ArgumentMatchers.eq(class1));

        verify(courseClassService, times(1)).enrollStudentToClass(
                ArgumentMatchers.eq(student),
                ArgumentMatchers.eq(class2));
    }

    @Test
    public void processEnrollment_shouldNotifyStudentByEmail() throws Exception {
        EnrollmentDto enrollmentDto = mock(EnrollmentDto.class);

        enrollmentService.processEnrollment(enrollmentDto);

        verify(enrollmentNotificationService).emailStudent(
                ArgumentMatchers.eq(StudentEmailType.ENROLLMENT),
                ArgumentMatchers.eq(enrollmentDto));
    }

    @Test
    public void processEnrollment_shouldPrintEnrollmentDetails() throws Exception {
        EnrollmentDto enrollmentDto = mock(EnrollmentDto.class);

        StudyLoad studyLoadPrintable = mock(StudyLoad.class);

        when(studyLoadFormatter.format(enrollmentDto)).thenReturn(studyLoadPrintable);

        enrollmentService.processEnrollment(enrollmentDto);

        verify(systemService).print(ArgumentMatchers.eq(studyLoadPrintable));
    }
}