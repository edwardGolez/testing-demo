package com.synacy.lesson02.exercises;

import com.synacy.lesson02.exercises.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by kenichigouang on 5/3/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceTest {
    private EnrollmentService enrollmentService;

    @Mock StudentProfileService studentProfileService;

    @Mock CourseClassService courseClassService;

    @Mock EnrollmentNotificationService enrollmentNotificationService;

    @Mock StudyLoadFormatter studyLoadFormatter;
    @Mock SystemService systemService;
    @Before
    public void setup() {
        enrollmentService = new EnrollmentService();

        enrollmentService.setStudentProfileService(studentProfileService);
        enrollmentService.setCourseClassService(courseClassService);
        enrollmentService.setEnrollmentNotificationService(enrollmentNotificationService);
        enrollmentService.setStudyLoadFormatter(studyLoadFormatter);
        enrollmentService.setSystemService(systemService);
    }

    @Test
    public void processEnrollment_shouldPrintStudyLoad() throws Exception {
        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);
        Printable studyLoadPrintable = mock(StudyLoad.class);

        when(studyLoadFormatter.format(enrollmentDetails)).thenReturn((StudyLoad) studyLoadPrintable);

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(systemService, times(1)).print(
                ArgumentMatchers.eq(studyLoadPrintable)
        );
    }

    @Test
    public void processEnrollment_shouldNotifyStudentsOnEnrollment() throws Exception {

        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(enrollmentNotificationService, times(1)).emailStudent(
                ArgumentMatchers.eq(StudentEmailType.ENROLLMENT),
                ArgumentMatchers.eq(enrollmentDetails)
        );

    }

    @Test
    public void processEnrollment_shouldEnrollStudentInClasses() throws Exception {

        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);

        Student student = enrollmentDetails.getStudent();

        CourseClass course1 = mock(CourseClass.class);
        CourseClass course2 = mock(CourseClass.class);

        Set<CourseClass> enrolledClasses = new HashSet<>();

        enrolledClasses.add(course1);
        enrolledClasses.add(course2);

        when(enrollmentDetails.getEnrolledClasses()).thenReturn(enrolledClasses);

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(courseClassService, times(1)).enrollStudentToClass(
                ArgumentMatchers.eq(student),
                ArgumentMatchers.eq(course1)
        );

        verify(courseClassService, times(1)).enrollStudentToClass(
                ArgumentMatchers.eq(student),
                ArgumentMatchers.eq(course2)
        );

    }

    @Test
    public void processEnrollment_shouldUpdateStudentProfile() throws Exception {

        EnrollmentDto enrollmentDetails  = mock(EnrollmentDto.class);
        StudentProfile studentProfile = mock(StudentProfile.class);

        when(enrollmentDetails.getStudentProfile()).thenReturn(studentProfile);

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(studentProfileService, times(1)).updateStudentProfile(
                ArgumentMatchers.eq(studentProfile)
        );
    }

}