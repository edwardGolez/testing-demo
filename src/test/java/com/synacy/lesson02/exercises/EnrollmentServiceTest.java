package com.synacy.lesson02.exercises;

import com.synacy.lesson02.exercises.domain.EnrollmentDto;
import com.synacy.lesson02.exercises.domain.StudentProfile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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