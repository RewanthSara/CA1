# 📚 Student Record Management App

An Android application for managing student records with full CRUD (Create, Read, Update, Delete) functionality, backed by **Firebase Realtime Database**.

---

## 📱 App Screenshots

> _Screenshots will be added here_

| Home Screen | Add Record | View Records |
|:-----------:|:----------:|:------------:|
| ![Home](screenshots/home.png) | ![Add](screenshots/add.png) | ![View](screenshots/view.png) |

---

## 🔥 Firebase Screenshots

> _Firebase console screenshots will be added here_

| Firebase Realtime Database | Firebase Rules |
|:--------------------------:|:--------------:|
| ![DB](screenshots/firebase_db.png) | ![Rules](screenshots/firebase_rules.png) |

---

## ✨ Features

- Add new student records (Name, Roll No, Marks)
- View all student records in a scrollable list
- Update existing student records
- Delete student records
- Real-time data sync with Firebase

---

## 🛠️ Tech Stack

- **Language:** Java / Kotlin
- **UI:** XML Layouts with LinearLayout & RecyclerView
- **Backend:** Firebase Realtime Database
- **Min SDK:** 21 (Android 5.0 Lollipop)

---

## 📂 Project Structure

```
app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com.example.studentrecords/
│       │       ├── MainActivity.java
│       │       ├── StudentAdapter.java
│       │       └── StudentModel.java
│       └── res/
│           └── layout/
│               ├── activity_main.xml      # Main screen with form & buttons
│               └── item_student.xml       # RecyclerView item layout
└── google-services.json
```

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (latest version recommended)
- A Firebase project with Realtime Database enabled
- `google-services.json` file from your Firebase project

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/student-record-management.git
   cd student-record-management
   ```

2. **Add Firebase to the project**
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Create a new project (or use an existing one)
   - Add an Android app with your package name
   - Download `google-services.json` and place it in the `app/` directory

3. **Enable Realtime Database**
   - In Firebase Console, go to **Build → Realtime Database**
   - Click **Create Database** and start in test mode

4. **Add dependencies** in `app/build.gradle`
   ```groovy
   implementation 'com.google.firebase:firebase-database:20.3.0'
   ```

5. **Sync and Run**
   - Click **Sync Now** in Android Studio
   - Run the app on an emulator or physical device

---

## 🗄️ Firebase Database Structure

```json
{
  "students": {
    "unique_id_1": {
      "name": "John Doe",
      "rollNo": "101",
      "marks": "95"
    },
    "unique_id_2": {
      "name": "Jane Smith",
      "rollNo": "102",
      "marks": "88"
    }
  }
}
```

---

## 📖 How to Use

1. **Add a Record** — Fill in Name, Roll No, and Marks, then tap **Add**
2. **View Records** — Tap **View** to load all records into the list below
3. **Update a Record** — Select a record, modify the fields, then tap **Update**
4. **Delete a Record** — Select a record and tap **Delete** to remove it

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
