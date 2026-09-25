package com.android.attendance.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.attendance.bean.AttendanceBean;
import com.android.attendance.bean.FacultyBean;
import com.android.attendance.bean.StudentBean;
import com.android.attendance.db.DBAdapter;
import com.example.androidattendancesystem.R;

public class DashboardActivity extends Activity {

	private DBAdapter dbAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		dbAdapter = new DBAdapter(this);

		int studentCount = dbAdapter.getAllStudent().size();
		int facultyCount = dbAdapter.getAllFaculty().size();
		int sessionCount = dbAdapter.getAllAttendanceSession().size();

		((TextView) findViewById(R.id.tvStudentCount)).setText("Students: " + studentCount);
		((TextView) findViewById(R.id.tvFacultyCount)).setText("Faculty: " + facultyCount);
		((TextView) findViewById(R.id.tvSessionCount)).setText("Attendance Sessions: " + sessionCount);

		buildRiskList();

		((Button) findViewById(R.id.btnExportCSV)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(DashboardActivity.this, "Export will be added as an option below.", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void buildRiskList() {
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<StudentBean> students = dbAdapter.getAllStudent();

		double worst = 100.0;
		String worstName = "";
		for (StudentBean s : students) {
			int[] stats = dbAdapter.getAttendanceStatsForStudent(s.getStudent_id());
			if (stats[4] == 0) continue;
			double pct = 100.0 * stats[0] / stats[4];
			if (pct < worst) { worst = pct; worstName = s.getStudent_firstname() + " " + s.getStudent_lastname(); }
			if (pct < 75.0) {
				lines.add(s.getStudent_firstname() + " " + s.getStudent_lastname() + "  -  " + (int) Math.round(pct) + "% (below 75%)");
			}
		}

		TextView tvStatus = (TextView) findViewById(R.id.tvRiskSummary);
		if (students.isEmpty()) {
			tvStatus.setText("No students yet. Add students to see risk analytics.");
		} else if (lines.isEmpty() && worst < 100.0) {
			tvStatus.setText("No at-risk students. Best attendance so far is " + worstName + " at " + (int) Math.round(worst) + "%.");
		} else if (lines.isEmpty()) {
			tvStatus.setText("No attendance marked yet.");
		} else {
			tvStatus.setText("At-risk (below 75%): " + lines.size());
		}

		ListView lv = (ListView) findViewById(R.id.lvRisk);
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lines));

		// Export/share CSV of this report
		((Button) findViewById(R.id.btnExportCSV)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				shareCsv(lines);
			}
		});
	}

	private void shareCsv(ArrayList<String> riskLines) {
		StringBuilder csv = new StringBuilder();
		csv.append("Student,Present,Absent,Late,Leave,Total,Pct\n");
		ArrayList<StudentBean> students = dbAdapter.getAllStudent();
		for (StudentBean s : students) {
			int[] stats = dbAdapter.getAttendanceStatsForStudent(s.getStudent_id());
			double pct = stats[4] == 0 ? 0.0 : 100.0 * stats[0] / stats[4];
			csv.append(s.getStudent_firstname() + " " + s.getStudent_lastname())
				.append(",").append(stats[0])
				.append(",").append(stats[1])
				.append(",").append(stats[2])
				.append(",").append(stats[3])
				.append(",").append(stats[4])
				.append(",").append(String.format("%.1f", pct))
				.append("\n");
		}

		android.content.Intent send = new android.content.Intent(android.content.Intent.ACTION_SEND);
		send.setType("text/plain");
		send.putExtra(android.content.Intent.EXTRA_SUBJECT, "Attendance Report");
		send.putExtra(android.content.Intent.EXTRA_TEXT, csv.toString());
		startActivity(android.content.Intent.createChooser(send, "Share attendance report"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}