# Playing Card Recognizer (Android)

An independent Android mobile application built in Java with Android Studio that captures playing cards through the device camera, recognizes text/card information, and announces results aloud using text-to-speech.

## Key Features & Tech Stack
- **Language & IDE:** Java, Android Studio
- **Camera & Vision:** CameraX and Google ML Kit Text Recognition
- **Accessibility / Feedback:** Android `TextToSpeech` for spoken output
- **UI Layout:** XML layout (`activity_main.xml`) and `AndroidManifest.xml` permission/component configuration

## Files
- `FinalActivity.java` — Main activity handling camera preview/capture, ML Kit text recognition, and `TextToSpeech` announcements.
- `activity_main.xml` — UI layout definition for the application screen.
- `AndroidManifest.xml` — App configuration and required permissions (such as camera access).
- `build.gradle` — Module-level Gradle configuration and dependencies.
- `report_playing_card_app.pdf` — Project documentation and presentation slides covering design choices, implementation, and testing (in Traditional Chinese).
- `Screenshot_demo.png` — Application screenshot showing the interface/output.