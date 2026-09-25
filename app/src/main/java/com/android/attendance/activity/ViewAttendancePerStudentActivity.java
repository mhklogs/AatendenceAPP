package com.android.attendance.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.attendance.bean.AttendanceBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;
import com.example.androidattendancesystem.R;

public class ViewAttendancePerStudentActivity extends Activity {

	ArrayList<AttendanceBean> attendanceBeanList;
	private ListView listView ;  
	private ArrayAdapter<String> listAdapter;

	DBAdapter dbAdapter = new DBAdapter(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.__listview_main);

		listView=(ListView)findViewById(R.id.listview);
		final ArrayList<String> attendanceList = new ArrayList<String>();
		attendanceList.add("Student Attendance Report (P/A/L/E + %)");

		attendanceBeanList=((ApplicationContext)ViewAttendancePerStudentActivity.this.getApplicationContext()).getAttendanceBeanList();

		for(AttendanceBean attendanceBean : attendanceBeanList)
		{
			String users = "";
			int studentId = attendanceBean.getAttendance_student_id();
			int presentCount = attendanceBean.getAttendance_session_id();

			DBAdapter dbAdapter = new DBAdapter(ViewAttendancePerStudentActivity.this);
			StudentBeanWrapper wrapper = getStudentAndStats(attendanceBean);

			double pct = wrapper.total == 0 ? 0.0 : (100.0 * wrapper.present / wrapper.total);
			String flag = pct >= 75.0 ? "OK" : (pct >= 60.0 ? "WARN" : "LOW");
			users = studentId + ".  " + wrapper.name + "  P:" + wrapper.present
					+ " A:" + wrapper.absent + " L:" + wrapper.late + " E:" + wrapper.leave
					+ "  " + (int) Math.round(pct) + "%  [" + flag + "]";
			attendanceList.add(users);
		}

		listAdapter = new ArrayAdapter<String>(this, R.layout.view_attendance_list_per_student, R.id.labelAttendancePerStudent, attendanceList);
		listView.setAdapter( listAdapter ); 
	}

	private StudentBeanWrapper getStudentAndStats(AttendanceBean bean) {
		DBAdapter dbLocal = new DBAdapter(ViewAttendancePerStudentActivity.this);
		StudentBeanWrapper result = new StudentBeanWrapper();
		com.android.attendance.bean.StudentBean studentBean = dbLocal.getStudentById(bean.getAttendance_student_id());
		result.name = studentBean.getStudent_firstname() + " " + studentBean.getStudent_lastname();
		int[] stats = dbLocal.getAttendanceStatsForStudent(bean.getAttendance_student_id());
		result.present = stats[0];
		result.absent = stats[1];
		result.late = stats[2];
		result.leave = stats[3];
		result.total = stats[4];
		return result;
	}

	private static class StudentBeanWrapper {
		String name = "";
		int present = 0;
		int absent = 0;
		int late = 0;
		int leave = 0;
		int total = 0;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}