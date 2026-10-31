# 🛒 HaatBazar (হাট বাজার)

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-7F52FF.svg?style=flat&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Android](https://img.shields.io/badge/Platform-Android-3DDC84.svg?style=flat&logo=android&logoColor=white)](https://www.android.com)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-34-34A853.svg?style=flat)]()
[![Min SDK](https://img.shields.io/badge/Min%20SDK-24-EA4335.svg?style=flat)]()
[![Dagger Hilt](https://img.shields.io/badge/DI-Dagger%20Hilt-4285F4.svg?style=flat)]()
[![Firebase](https://img.shields.io/badge/Backend-Firebase-FFCA28.svg?style=flat&logo=firebase&logoColor=black)](https://firebase.google.com)

**HaatBazar** is a modern, full-featured Android e-commerce and marketplace application built with **Kotlin**, **MVVM architecture**, and **Firebase**. It provides a scalable role-based platform connecting Customers, Sellers, and Administrators with real-time updates and push notifications.

---

## 📱 Features

- 🔐 **Authentication & Security**
  - Email & Password registration and authentication with Firebase Auth.
  - Password recovery / reset mechanism.
  - Strict client-side validation for credentials and email formats.

- 👥 **Role-Based Ecosystem**
  - Architecture supporting **Sellers**, **Customers**, and **Admins**.
  - Dedicated Seller dashboard with session management and secure logout.

- 🔔 **Push Notifications**
  - Integrated **Firebase Cloud Messaging (FCM)** for background & foreground notifications.
  - Custom notification channels and pending intent management.

- 🎨 **Modern & Adaptive UI/UX**
  - Built with Google's **Material Design 3** components.
  - Screen adaptability across various device resolutions using **SDP** (Scalable DP) & **SSP** (Scalable SP).
  - Interactive feedback with **Lottie Animations** and custom progress loaders.

- 🏗️ **Clean Architecture & Scalability**
  - **MVVM (Model-View-ViewModel)** design pattern.
  - Dependency Injection with **Dagger-Hilt**.
  - **Single-Activity Architecture** powered by Jetpack Navigation Component.
  - Observable state handling through custom `DataState` wrappers (Loading, Success, Error).

---

## 🛠️ Tech Stack & Libraries

- **Language:** [Kotlin](https://kotlinlang.org/)
- **Architecture:** MVVM (Model-View-ViewModel) + Repository Pattern
- **Dependency Injection:** [Dagger-Hilt](https://dagger.dev/hilt/)
- **Backend Services:** [Firebase](https://firebase.google.com/)
  - Firebase Authentication
  - Cloud Firestore & Realtime Database
  - Cloud Storage
  - Firebase Cloud Messaging (FCM)
  - Firebase Analytics
- **Jetpack Components:**
  - Navigation Component (Single-Activity Navigation Graph)
  - ViewBinding
  - ViewModel & LiveData
  - Lifecycle extensions
- **UI & Helpers:**
  - [Material Components for Android](https://github.com/material-components/material-components-android)
  - [SDP & SSP](https://github.com/intuit/sdp) (Scalable units for multi-screen support)
  - [Lottie for Android](https://github.com/airbnb/lottie-android) (Smooth vector animations)

---

## 📂 Project Structure

```plaintext
com.esports.haatbazar
├── Base/            # Base Fragment and reusable UI components
├── core/            # App-wide utilities, state wrappers (DataState), constants (Nodes)
├── data/            # Repositories and data source interfaces
├── di/              # Hilt Dependency Injection modules (FirebaseModule, Application class)
├── view/            # Presentation layer (UI)
│   ├── dashboard/   # Seller / User dashboard fragments
│   ├── forgetPassword/ # Password reset UI and ViewModel
│   ├── login/       # Login screen and ViewModel
│   ├── register/    # Registration screen and ViewModel
│   └── starter/     # Splash / Welcome onboarding screen & MainActivity
└── MyService.kt     # Firebase Cloud Messaging Service
```

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio** (Ladybug / Koala / Hedgehog or newer recommended)
- **JDK 11** or **JDK 17**
- Android SDK with API level **34** or higher
- A **Firebase Project** with Authentication, Firestore, and FCM enabled

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/rifathossain472/HaatBazar.git
   cd HaatBazar
   ```

2. **Add Firebase configuration:**
   - Create a project on the [Firebase Console](https://console.firebase.google.com/).
   - Add an Android app with the package name: `com.esports.haatbazar`.
   - Download the `google-services.json` file.
   - Place `google-services.json` into the `app/` directory:
     ```plaintext
     HaatBazar/
     └── app/
         └── google-services.json
     ```

3. **Open and Sync:**
   - Open the project in Android Studio.
   - Wait for Gradle sync to complete.

4. **Build and Run:**
   - Select your target device / emulator and click **Run** (`Shift + F10`).
   - Or build via terminal:
     ```bash
     ./gradlew assembleDebug
     ```

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/rifathossain472/HaatBazar/issues).

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👤 Author

**Rifat Hossain**
- GitHub: [@rifathossain472](https://github.com/rifathossain472)
