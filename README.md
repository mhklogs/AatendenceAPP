# Attendio — College Attendance System

An offline-first **Android attendance management app** built in **Java**. Faculty and admins can register students of a branch/year, create subject sessions, and mark daily attendance that is stored locally in an SQLite database — no server or internet connection required.

![Android](https://img.shields.io/badge/Platform-Android-3DDC84) ![Java](https://img.shields.io/badge/Language-Java-007396) ![SQLite](https://img.shields.io/badge/Storage-SQLite-003B57) ![License](https://img.shields.io/badge/License-MIT-blue)

---

## ✨ Features

### Admin Module
- Add / view **students** and **faculty**
- Create attendance **sessions** (department + class + subject + date) with **duplicate-session prevention**
- Mark **Present / Absent / Late / Excused** roll-call in one screen
- View attendance **per student** with live totals and an **at-risk tracker** (<75%)
- **Dashboard** with student / faculty / session counts, at-risk list, and **one-tap CSV export** (share sheet)

### Faculty Module
- Log in with a faculty account
- Manage students, sessions, and daily attendance
- Simple dashboard-driven navigation with on-device storage

## 📲 Download the APK

Grab the latest signed release and install it directly on your Android device:

| App | APK | Size |
|---|---|---|
| Attendio v2.0 | [**Attendio.apk**](https://android-apps-rho.vercel.app/downloads/Attendio.apk) | ~0.3 MB |

Requires **Android 6.0 (API 23)+**. Allow installation from unknown sources when prompted.

## 🛠 Tech Stack

| Layer      | Technology                            |
|------------|---------------------------------------|
| Language   | Java                                  |
| UI         | XML layouts + Material platform theme, ListViews/Spinners |
| Storage    | SQLite via a custom `DBAdapter`       |
| Build      | Gradle 8.8, AGP 8.x, R8 + resource shrinking |

## 🚀 Getting Started

### Prerequisites
- [Android Studio](https://developer.android.com/studio) (Hedgehog or newer)
- JDK 11+ (bundled with Android Studio)

### Run it
```bash
git clone https://github.com/mhklogs/Attendio.git
```
Open the folder in Android Studio and press **Run ▶**. The app works fully offline — data lives in the device's SQLite database.

> **Default admin login:** username `admin` · password `admin123` (from `LoginActivity.java`)

## 📁 Project Structure

```
app/src/main/java/com/android/attendance/
├── activity/          # All screens (login, menus, add/view screens)
├── bean/              # POJOs: Student, Faculty, Attendance, AttendanceSession
├── context/           # Shared application context
└── db/DBAdapter.java  # SQLite helper (schema + CRUD)
```

## 🧭 Roadmap

- Export attendance to CSV/PDF
- Data backup & restore
- Cloud sync across devices

## 🤝 Contributing
Pull requests are welcome. For major changes, open an issue first to discuss your approach.

## 📄 License
Released under the [MIT License](LICENSE).