# Full Screen Video Android App

A minimal Android app that opens directly to a supplied video in immersive full-screen mode. The video starts automatically, keeps its audio, and loops continuously.

## Build APK on GitHub
1. Create a new GitHub repository.
2. Upload the contents of this folder (not the ZIP itself) to the repository's `main` branch.
3. Open the repository's **Actions** tab.
4. Select **Build Android APK** and click **Run workflow** (or wait for the automatic build after pushing).
5. Open the completed workflow run, then download the **FullScreenImageApp-debug** artifact.
6. Unzip the downloaded artifact to get `app-debug.apk`, then install it on your Android phone.

## Opening video
Put your video file here, with this exact filename:
`app/src/main/assets/opening_video.mp4`

The app expects an MP4 file encoded with H.264 video (AAC audio recommended). Keep the filename exactly `opening_video.mp4`. The app starts playback automatically, plays audio, loops continuously, and shows no playback controls.

## App icon
A placeholder icon concept is included as `launcher-icon-placeholder.png`. The Android launcher currently uses the default system icon. If you upload your preferred app icon image, it can be added to the Android launcher resources.

This workflow creates a **debug APK** for testing/personal installation. A Play Store release build would need a signed release configuration.


## App name and icon
- App name: **Lux ka kotha**
- Launcher icon: generated from the supplied image and included in Android mipmap resources.
- The icon uses a square black canvas and preserves the full original image (no cropping).
