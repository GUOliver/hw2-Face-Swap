# SwapSense App

Welcome to the SwapSense app, a mobile application designed for exploring the powerful features of Kotlin for native functionality in Android. SwapSense combines sensor data access and camera functionalities to deliver an engaging user experience, allowing users to interact directly with their device’s hardware. :) I spent around 5 hours finishing this project. The most challenging part of this project was understanding and implementing the face swap feature. Integrating Google ML Kit for accurate face detection and developing a robust face swapping algorithm required addressing technical complexities such as real-time image processing and ensuring seamless integration with the camera functionality.

## Features

### Bottom Toolbar
The app includes a bottom toolbar that categorizes functionalities into two main tabs:
-  **Face Swap Tab:** Swap two faces from the photos selected from the Photo Gallery if faces are detected.
-  **Sensors Tab:** Fetches and displays real-time data from three selected sensors on the device.

### Sensor Features
-  **Multiple Sensors Support:** Access data from three different sensors: Magnetic Field, Proximity, and Light Sensors.
-  **Permission Handling:** Requests necessary permissions for accessing hardware sensors.
-  **Sensor Availability Checks:** Notifies the user with a toast message if a sensor is not supported or unavailable.

### Face Swap Features
-  **Two-Person Face Swap:** Allows users to take photos of two different people and swap their faces using the integrated face detection technology.
-  **Face Detection:** Checks for face presence in captured images and notifies the user if no faces are detected.
-  **Photo Display and Storage:** Displays the original and face-swapped photos, and optionally saves the edited photos to the device storage.

## Technologies Used

-  **Kotlin:** Programming language for all app development.
-  **Android Studio:** Primary IDE for design and development.
-  **Camera2 API:** For advanced camera functionalities.
-  **Google ML Kit:** Utilized for face detection capabilities.
- 
## Permissions

The app requires the following permissions to function correctly:
-  Camera access for taking photos.
-  Storage access for saving images.
-  Sensor access for magnetic field, proximity, and accelerometer sensors.