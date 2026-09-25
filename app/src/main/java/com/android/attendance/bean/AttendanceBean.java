package com.android.attendance.bean;

public class AttendanceBean {

	private int attendance_session_id;
	private int attendance_student_id;
	private String attendance_status;
	private long attendance_marked_at;

	public int getAttendance_session_id() {
		return attendance_session_id;
	}
	public void setAttendance_session_id(int attendance_session_id) {
		this.attendance_session_id = attendance_session_id;
	}
	public int getAttendance_student_id() {
		return attendance_student_id;
	}
	public void setAttendance_student_id(int attendance_student_id) {
		this.attendance_student_id = attendance_student_id;
	}
	public String getAttendance_status() {
		return attendance_status;
	}
	public void setAttendance_status(String attendance_status) {
		this.attendance_status = attendance_status;
	}
	public long getAttendance_marked_at() {
		return attendance_marked_at;
	}
	public void setAttendance_marked_at(long attendance_marked_at) {
		this.attendance_marked_at = attendance_marked_at;
	}
}