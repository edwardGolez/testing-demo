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

/**
 * Created by banjoe on 5/3/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceTest {

    private EnrollmentService enrollmentService;

    private EnrollmentDto enrollmentDetails;
    private Student student;
    private StudentProfile studentProfile;
    private Set<CourseClass> enrolledClasses;
    private CourseClass courseClass1;
    private CourseClass courseClass2;

    @Mock StudentProfileService studentProfileService;
    @Mock CourseClassService courseClassService;
    @Mock EnrollmentNotificationService enrollmentNotificationService;
    @Mock StudyLoadFormatter studyLoadFormatter;
    @Mock SystemService systemService;

    @Before
    public void setup() throws Exception {
        enrollmentService = new EnrollmentService();
        enrollmentService.setCourseClassService(courseClassService);
        enrollmentService.setEnrollmentNotificationService(enrollmentNotificationService);
        enrollmentService.setStudentProfileService(studentProfileService);
        enrollmentService.setStudyLoadFormatter(studyLoadFormatter);
        enrollmentService.setSystemService(systemService);

        enrollmentDetails = mock(EnrollmentDto.class);
        student = mock(Student.class);
        when(enrollmentDetails.getStudent()).thenReturn(student);

        studentProfile = mock(StudentProfile.class);
        when(enrollmentDetails.getStudentProfile()).thenReturn(studentProfile);

        courseClass1 = mock(CourseClass.class);
        courseClass2 = mock(CourseClass.class);

        enrolledClasses = new HashSet<>();
        enrolledClasses.add(courseClass1);
        enrolledClasses.add(courseClass2);
        when(enrollmentDetails.getEnrolledClasses()).thenReturn(enrolledClasses);
    }

    @Test
    public void processEnrollment_shouldUpdateStudentProfile() throws Exception {
        enrollmentService.processEnrollment(enrollmentDetails);
        verify(studentProfileService, times(1)).updateStudentProfile(ArgumentMatchers.eq(studentProfile));
    }

    @Test
    public void processEnrollment_shouldEnrollStudentToAClass() throws Exception {
        enrollmentService.processEnrollment(enrollmentDetails);

        verify(courseClassService, times(1)).enrollStudentToClass(ArgumentMatchers.eq(enrollmentDetails.getStudent()), ArgumentMatchers.eq(courseClass1));
        verify(courseClassService, times(1)).enrollStudentToClass(ArgumentMatchers.eq(enrollmentDetails.getStudent()), ArgumentMatchers.eq(courseClass2));
    }

    @Test
    public void processEnrollment_shouldNotifyStudentsEnrollmentDetailsByEmail() throws Exception {
        enrollmentService.processEnrollment(enrollmentDetails);
        verify(enrollmentNotificationService, times(1)).emailStudent(ArgumentMatchers.eq(StudentEmailType.ENROLLMENT), ArgumentMatchers.eq(enrollmentDetails));
    }

    @Test
    public void processEnrollment_shouldReturnPrintableStudyLoad() throws Exception {
        enrollmentService.processEnrollment(enrollmentDetails);
        verify(studyLoadFormatter, times(1)).format(ArgumentMatchers.eq(enrollmentDetails));
    }

    @Test
    public void processEnrollment_shouldPrintTheStudentsStudyLoad() throws Exception {
        StudyLoad studyLoadPrintable = mock(StudyLoad.class);
        when(studyLoadFormatter.format(enrollmentDetails)).thenReturn(studyLoadPrintable);

        enrollmentService.processEnrollment(enrollmentDetails);
        verify(systemService, times(1)).print(ArgumentMatchers.eq(studyLoadPrintable));
    }



}