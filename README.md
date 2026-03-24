# 📱 WebIntoApp — Universal Web-to-App Template

**WebIntoApp** is a powerful, lightweight, and automated Android application template that converts any website or local HTML project into a real Android app. It uses **GitHub Actions** to build the APK automatically, so you don't need Android Studio installed on your computer.

---

## 🚀 Quick Start Guide

### 1. Repository Setup
1. **Create a Private/Public Repository** on GitHub named `webintoapp`.
2. **Upload the Files**: Copy the project structure provided in the setup.
3. **Add your Logo**: Upload your square icon as `logo.png` to the `app/src/main/res/drawable/` directory.

### 2. Configuration (`AppConfig.java`)
All app behaviors are controlled from **`app/src/main/java/com/webintoapp/AppConfig.java`**. 

* **To load a Website:** Set `URL_TO_LOAD` to your website link (e.g., `https://your-site.com`).
* **To load Local HTML:** Comment out the URL line and uncomment the `file:///android_asset/index.html` line.
* **Splash Screen:** Change `SHOW_SPLASH_SCREEN` to `true` or `false` and adjust `SPLASH_SCREEN_DURATION`.
* **WebView Tweaks:** Enable or disable JavaScript, Zoom, and Cache mode.

### 3. Change App Name
Go to `app/src/main/res/values/strings.xml` and change the value of `app_name`:
```xml
<string name="app_name">My New App Name</string>
```

---

## 🛠️ How to Build the APK (Automated)

You don't need to run any commands. GitHub does it for you:

1.  **Commit & Push**: Once you save/push your changes to the `main` or `master` branch, the build starts automatically.
2.  **Monitor Progress**: Click on the **"Actions"** tab at the top of your GitHub repository.
3.  **Download**: 
    * Click on the latest workflow run (marked with a green checkmark ✅).
    * Scroll down to the **Artifacts** section.
    * Click on **WebIntoApp-APK** to download the zip file containing your `.apk`.

---

## ⚙️ Advanced Customization

### Status Bar & Themes
You can toggle the visibility of the clock/battery bar in `AppConfig.java`:
* `SHOW_STATUS_BAR = true`: Normal app look.
* `SHOW_STATUS_BAR = false`: Immersive/Gaming look.

To change the status bar color, edit `app/src/main/res/values/themes.xml` and modify:
```xml
<item name="android:statusBarColor">#000000</item> ```

### Local Assets
If you are building an offline app, place all your HTML, CSS, and JS files inside the `app/src/main/assets/` folder. Ensure the main file is named `index.html`.

---

## ⚠️ Important Troubleshooting
* **Build Fails?** Ensure your `logo.png` filename is strictly lowercase and has no spaces.
* **White Screen?** Check if your website URL starts with `https://`. If using local files, ensure `index.html` exists in the assets folder.
* **Old Content Showing?** Change `CACHE_MODE` to `2` in `AppConfig.java` to force the app to load fresh content every time.

---

## 📜 License
This project is open-source. Feel free to use it for personal or commercial website conversions.

