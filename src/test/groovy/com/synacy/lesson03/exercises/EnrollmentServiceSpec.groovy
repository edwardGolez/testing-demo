package com.synacy.lesson03.exercises

import com.synacy.lesson02.exercises.CourseClassService
import com.synacy.lesson02.exercises.EnrollmentNotificationService
import com.synacy.lesson02.exercises.EnrollmentService
import com.synacy.lesson02.exercises.StudentProfileService
import com.synacy.lesson02.exercises.StudyLoadFormatter
import com.synacy.lesson02.exercises.SystemService
import com.synacy.lesson02.exercises.domain.CourseClass
import com.synacy.lesson02.exercises.domain.EnrollmentDto
import com.synacy.lesson02.exercises.domain.Student
import com.synacy.lesson02.exercises.domain.StudentEmailType
import com.synacy.lesson02.exercises.domain.StudentProfile
import org.mockito.Mock

/**
 * Created by kenichigouang on 5/4/17.
 */
class EnrollmentServiceSpec extends spock.lang.Specification {

    EnrollmentService service

    StudentProfileService studentProfileService
    CourseClassService courseClassService
    EnrollmentNotificationService enrollmentNotificationService
    StudyLoadFormatter studyLoadFormatter
    SystemService systemService

    void setup() {
        service = new EnrollmentService()

        studentProfileService = Mock()
        courseClassService = Mock()
        enrollmentNotificationService = Mock()
        studyLoadFormatter = Mock()
        systemService = Mock()

        service.studentProfileService = studentProfileService
        service.courseClassService = courseClassService
        service.enrollmentNotificationService = enrollmentNotificationService
        service.studyLoadFormatter = studyLoadFormatter
        service.systemService = systemService
    }

    def "ProcessEnrollment should update student profile on processing of enrollment"() {
        given:
        EnrollmentDto enrollmentDetails = Mock()
        StudentProfile studentProfile = Mock()

        when:
        service.processEnrollment(enrollmentDetails)

        then:
        1 * studentProfileService.updateStudentProfile(studentProfile)
    }

    def "ProcessEnrollment should enroll student to a class/classes on processing of enrollment"() {
        given:
        EnrollmentDto enrollmentDetails = Mock()
        Student student = Mock()
        CourseClass courseClass1 = Mock()
        CourseClass courseClass2 = Mock()

        when:
        service.processEnrollment(enrollmentDetails)

        then:
        1 * courseClassService.enrollStudentToClass(student, courseClass1)
        1 * courseClassService.enrollStudentToClass(student, courseClass2)
    }

    def "ProcessEnrollment should notify student via email on processing of enrollment"() {
        given:
        EnrollmentDto enrollmentDetails = Mock()

        when:
        service.processEnrollment(enrollmentDetails)

        then:
        1 * enrollmentNotificationService.emailStudent(StudentEmailType.ENROLLMENT, enrollmentDetails)
    }
}

