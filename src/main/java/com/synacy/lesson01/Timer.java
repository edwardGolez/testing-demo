package com.synacy.lesson01;

public class Timer {

	private int hour;
	private int minute;
	private int second;


	public Timer() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public nextSecond() {
		incrementSecond(1);
	}

	private void incrementSecond(int increment) {
		this.second += increment;
		if(this.second > 60) {
			int additionalMinutes = this.second / 60;
			this.second %= 60;
			incrementMinutes(additionalMinutes);
		}
	}

	private void incrementMinutes(int increment) {
		this.minute += increment;
		if(this.minute > 60) {
			int additionalHours = this.minute / 60;
			this.minute %= 60;
			incrementHours(additionalHours);
		}
	}

	private void incrementHours(int increment) {
		this.hour += increment;
		if(this.hour > 24) {
			this.hour %= 24;
		}
	}

}
