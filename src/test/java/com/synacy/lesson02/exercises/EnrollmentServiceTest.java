package com.synacy.lesson02.exercises;

import com.synacy.lesson02.exercises.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceTest {

    private EnrollmentService enrollmentService;

    @Mock private StudentProfileService studentProfileService;
    @Mock private CourseClassService courseClassService;
    @Mock private EnrollmentNotificationService enrollmentNotificationService;
    @Mock private SystemService systemService;
    @Mock private StudyLoadFormatter studyLoadFormatter;

    @Before
    public void setup() {
        enrollmentService = new EnrollmentService();

        enrollmentService.setStudentProfileService(studentProfileService);
        enrollmentService.setCourseClassService(courseClassService);
        enrollmentService.setEnrollmentNotificationService(enrollmentNotificationService);
        enrollmentService.setSystemService(systemService);
        enrollmentService.setStudyLoadFormatter(studyLoadFormatter);
    }

    @Test
    public void processEnrollment_shouldUpdateStudentProfile() throws Exception {
        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);
        StudentProfile studentProfile = mock(StudentProfile.class);

        when(enrollmentDetails.getStudentProfile()).thenReturn(studentProfile);

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(studentProfileService, times(1)).updateStudentProfile(
                studentProfile
        );
    }

    @Test
    public void processEnrollment_shouldEnrollStudentToClass() throws Exception {
        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);

        Student student = enrollmentDetails.getStudent();

        Set<CourseClass> enrolledClasses = new HashSet<>();
        enrolledClasses.add(mock(CourseClass.class));
        enrolledClasses.add(mock(CourseClass.class));
        when(enrollmentDetails.getEnrolledClasses()).thenReturn(enrolledClasses);
        Iterator<CourseClass> courseClassIterator = enrolledClasses.iterator();

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(courseClassService, times(1)).enrollStudentToClass(
                ArgumentMatchers.eq(student),
                ArgumentMatchers.eq(courseClassIterator.next())
        );
        verify(courseClassService, times(1)).enrollStudentToClass(
                ArgumentMatchers.eq(student),
                ArgumentMatchers.eq(courseClassIterator.next())
        );
    }

    @Test
    public void processEnrollment_shouldNotifyStudentViaEmail() throws Exception {
        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(enrollmentNotificationService, times(1)).emailStudent(
                ArgumentMatchers.eq(StudentEmailType.ENROLLMENT),
                ArgumentMatchers.eq(enrollmentDetails)
        );
    }

    @Test
    public void processEnrollment_shouldPrintStudyLoadOfStudent() throws Exception {
        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);
        StudyLoad studyLoad = mock(StudyLoad.class);

        when(studyLoadFormatter.format(enrollmentDetails)).thenReturn(studyLoad);
        Printable studyLoadPrintable = studyLoad;

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(systemService, times(1)).print(
                ArgumentMatchers.eq(studyLoadPrintable)
        );
    }

}