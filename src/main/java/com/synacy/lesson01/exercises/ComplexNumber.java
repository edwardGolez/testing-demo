package com.synacy.lesson01.exercises;

public class ComplexNumber {

	private double real;
	private double imaginary;

	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public double getReal() {
		return real;
	}

	public double getImaginary() {
		return imaginary;
	}

	public ComplexNumber add(ComplexNumber anotherComplexNumber) {
		return new ComplexNumber(real + anotherComplexNumber.real, imaginary + anotherComplexNumber.imaginary);
	}

	public ComplexNumber subtract(ComplexNumber anotherComplexNumber) {
		return new ComplexNumber(real - anotherComplexNumber.real, imaginary - anotherComplexNumber.imaginary);
	}

	public ComplexNumber multiply(ComplexNumber anotherComplexNumber) {
		double resultImaginaryNumber = real * anotherComplexNumber.imaginary + this.imaginary * anotherComplexNumber.real;
		double resultRealNumber = this.real * anotherComplexNumber.real - this.imaginary * anotherComplexNumber.imaginary;

		return new ComplexNumber(resultRealNumber, resultImaginaryNumber);
	}

}
