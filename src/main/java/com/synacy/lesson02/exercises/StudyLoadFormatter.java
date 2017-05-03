package com.synacy.lesson02.exercises;

import com.synacy.lesson02.exercises.domain.PrinterFormattable;
import com.synacy.lesson02.exercises.domain.StudyLoad;

public interface StudyLoadFormatter {
	StudyLoad format(PrinterFormattable printerFormattable);
}
