package com.synacy.lesson02.exercises;

import com.synacy.lesson02.exercises.domain.EmailAttachable;
import com.synacy.lesson02.exercises.domain.StudentEmailType;

public interface EnrollmentNotificationService {
	void emailStudent(StudentEmailType enrollment, EmailAttachable... attachments);
}
