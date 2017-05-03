package com.synacy.lesson02.exercises;

import com.synacy.lesson02.exercises.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.xml.ws.soap.MTOM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceTest {

    private EnrollmentService enrollmentService;
    private EnrollmentDto enrollmentDetails;

    @Mock StudentProfileService studentProfileService;
    @Mock CourseClassService courseClassService;
    @Mock EnrollmentNotificationService enrollmentNotificationService;
    @Mock StudyLoadFormatter studyLoadFormatter;
    @Mock SystemService systemService;

    @Before
    public void setup(){
        enrollmentService = new EnrollmentService();

        enrollmentService.setStudentProfileService(studentProfileService);
        enrollmentService.setCourseClassService(courseClassService);
        enrollmentService.setEnrollmentNotificationService(enrollmentNotificationService);
        enrollmentService.setStudyLoadFormatter(studyLoadFormatter);
        enrollmentService.setSystemService(systemService);
        enrollmentDetails = mock(EnrollmentDto.class);

    }

    @Test
    public void processEnrollment_shouldUpdateStudentProfileWithEnrollmentDetails() throws Exception {

        enrollmentService.processEnrollment(enrollmentDetails);
        verify(studentProfileService).updateStudentProfile(enrollmentDetails.getStudentProfile());
    }

    @Test
    public void processEnrollment_shouldEnrollStudentClasses() throws Exception {

        Student student = mock(Student.class);

        Set<CourseClass> courseSet = new HashSet<>();
        courseSet.add(mock(CourseClass.class));
        Iterator<CourseClass> iterator = courseSet.iterator();

        when(enrollmentDetails.getEnrolledClasses()).thenReturn(courseSet);
        when(enrollmentDetails.getStudent()).thenReturn(student);

        enrollmentService.processEnrollment(enrollmentDetails);

        while (iterator.hasNext()){
            verify(courseClassService).enrollStudentToClass(
                    (enrollmentDetails.getStudent()),
                    (iterator.next())
            );
        }
    }

    @Test
    public void processEnrollment_shouldNotifyStudentWithEnrollmentDetails() throws Exception {
        enrollmentService.processEnrollment(enrollmentDetails);
        verify(enrollmentNotificationService).emailStudent(
                ArgumentMatchers.eq(StudentEmailType.ENROLLMENT),
                ArgumentMatchers.eq(enrollmentDetails)
        );
    }

    @Test
    public void processEnrollment_shouldPrintStudentsDetails() throws Exception {
        enrollmentService.processEnrollment(enrollmentDetails);

        verify(studyLoadFormatter).format(enrollmentDetails);

        Printable studyLoadPrintable = studyLoadFormatter.format(enrollmentDetails);

        verify(systemService).print(studyLoadPrintable);
    }

}