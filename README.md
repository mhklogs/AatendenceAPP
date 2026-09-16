# AatendenceAPP — College Attendance System

An offline-first **Android attendance management app** built in **Java**. Faculty and admins can register students of a branch/year, create subject sessions, and mark daily attendance that is stored locally in an SQLite database — no server or internet connection required.

![Android](https://img.shields.io/badge/Platform-Android-3DDC84) ![Java](https://img.shields.io/badge/Language-Java-007396) ![SQLite](https://img.shields.io/badge/Storage-SQLite-003B57) ![License](https://img.shields.io/badge/License-MIT-blue)

---

## ✨ Features

### Admin Module
- Add / view **students** and **faculty**
- Create attendance **sessions** (department + class + subject + date)
- Mark present / absent roll-call in one screen
- View attendance **per student**, **per faculty**, and **per class**

### Faculty Module
- Log in with a faculty account
- Manage students, sessions, and daily attendance
- Simple dashboard-driven navigation with on-device storage

## 🛠 Tech Stack

| Layer      | Technology                            |
|------------|---------------------------------------|
| Language   | Java                                  |
| UI         | XML layouts + ListViews/Spinners      |
| Storage    | SQLite via a custom `DBAdapter`       |
| Build      | Gradle 8.5, Android Gradle Plugin 8.1  |

## 🚀 Getting Started

### Prerequisites
- [Android Studio](https://developer.android.com/studio) (Hedgehog or newer)
- JDK 11+ (bundled with Android Studio)

### Run it
```bash
git clone https://github.com/mhklogs/AatendenceAPP.git
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
- Modern Material UI migration

## 🤝 Contributing
Pull requests are welcome. For major changes, open an issue first to discuss your approach.

## 📄 License
Released under the [MIT License](LICENSE).