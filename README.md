# 📒 GoNote – Firebase-Powered CRUD Notes App

**GoNote** is a simple and modern Android application that allows users to **Create, Read, Update, and Delete (CRUD)** notes using **Firebase Firestore** for real-time cloud storage. Built with **Jetpack Compose**, it provides a sleek and reactive user interface with smooth performance.

---

## 🚀 Features

* ✍️ Create new notes with title and content
* 📄 View all saved notes in a scrollable list
* 🖊️ Edit existing notes easily
* 🗑️ Delete notes instantly
* ☁️ Cloud data sync via Firebase Firestore
* 🧑‍💻 Built entirely using Kotlin and Jetpack Compose

---

## 🧱 Tech Stack

| Component    | Tech Used          |
| ------------ | ------------------ |
| UI           | Jetpack Compose    |
| Architecture | MVVM               |
| Backend      | Firebase Firestore |
| Language     | Kotlin             |
| Build System | Gradle             |

---

## 🛠️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Aksh1101/GoNote.git
cd GoNote
```

### 2. Add Firebase Configuration

> ⚠️ `google-services.json` is **not included** in this repository for security reasons.

* Go to [Firebase Console](https://console.firebase.google.com/)
* Open or create your Firebase project
* Register your Android app with the correct package name
* Download the `google-services.json` file
* Place it inside your project at:

  ```
  app/google-services.json
  ```

### 3. Build and Run the App

* Open the project in **Android Studio**
* Sync Gradle
* Click **Run** ▶️ to install and launch the app on your device or emulator

---

## 📁 Project Structure

```
GoNote/
├── app/
│   ├── screens/         # UI Screens (Home, Add/Edit Note)
│   ├── data/            # Firebase Firestore logic
│   ├── viewmodel/       # ViewModels for UI state
│   └── MainActivity.kt  # Entry point
├── .gitignore
├── build.gradle
└── README.md
```

---

## 📜 License

This project is released under the MIT License.

---

## 👤 Author

**Akshat Bhardwaj**
📬 [GitHub](https://github.com/Aksh1101)
🌐 [LinkedIn](https://www.linkedin.com/in/akshat-bhardwajj/)

---

## 🤝 Contributions

Contributions and suggestions are welcome!
Feel free to [open an issue](https://github.com/Aksh1101/GoNote/issues) or create a pull request.
  
