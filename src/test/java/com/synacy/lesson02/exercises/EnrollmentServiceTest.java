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

    @Mock StudentProfileService studentProfileService;
    @Mock CourseClassService courseClassService;
    @Mock EnrollmentNotificationService enrollmentNotificationService;
    @Mock SystemService systemService;
    @Mock StudyLoadFormatter studyLoadFormatter;

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
        StudentProfile studentProfile = mock(StudentProfile.class);
        when(enrollmentDetails.getStudentProfile()).thenReturn(studentProfile);

        Set<CourseClass> enrolledClasses = new HashSet<>();
        enrolledClasses.add(mock(CourseClass.class));
        enrolledClasses.add(mock(CourseClass.class));
        when(enrollmentDetails.getEnrolledClasses()).thenReturn(enrolledClasses);

        enrollmentService.processEnrollment(enrollmentDetails);
        studentProfileService.updateStudentProfile(studentProfile);

        Iterator<CourseClass> iterator = enrolledClasses.iterator();

        Student student = enrollmentDetails.getStudent();
        verify(courseClassService, times(1)).enrollStudentToClass(
                ArgumentMatchers.eq(student),
                ArgumentMatchers.eq(iterator.next())
        );
    }

    @Test
    public void processEnrollment_shouldNotifyStudentViaEmail() throws Exception {
        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);
        StudentProfile studentProfile = mock(StudentProfile.class);
        when(enrollmentDetails.getStudentProfile()).thenReturn(studentProfile);

        enrollmentService.processEnrollment(enrollmentDetails);

        verify(enrollmentNotificationService, times(1)).emailStudent(
                ArgumentMatchers.eq(StudentEmailType.ENROLLMENT),
                ArgumentMatchers.eq(enrollmentDetails)
        );
    }

    @Test
    public void processEnrollment_shouldPrintStudyLoadOfStudent() throws Exception {
        EnrollmentDto enrollmentDetails = mock(EnrollmentDto.class);
        StudentProfile studentProfile = mock(StudentProfile.class);
        when(enrollmentDetails.getStudentProfile()).thenReturn(studentProfile);

        enrollmentService.processEnrollment(enrollmentDetails);

        Printable studyLoadPrintable = mock(StudyLoad.class);
//        StudyLoad studyLoad = mock(Printable.class);
        when(studyLoadFormatter.format(enrollmentDetails)).thenReturn((StudyLoad) studyLoadPrintable);

        verify(systemService).print(
                ArgumentMatchers.eq(studyLoadPrintable)
        );
    }

}