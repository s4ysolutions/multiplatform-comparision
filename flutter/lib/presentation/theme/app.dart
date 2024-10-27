import 'package:flutter/material.dart';

final appTheme = ThemeData(
  useMaterial3: true,
  // canvasColor: const Color(0xFF191818), // bottom app bar color
  // primaryColor: const Color(0xFFF2C94C ), // bottom selected item color
  // unselectedWidgetColor: const Color(0xFF7446AC), // bottom unselected item color
  bottomNavigationBarTheme: const BottomNavigationBarThemeData(
    backgroundColor: Color(0xFF191818),
    // Background color of the bar
    selectedItemColor: Color(0xFFF2C94C),
    // Color for selected items
    unselectedItemColor: Color(0xFF7446AC),
    // Color for unselected items
    selectedIconTheme: IconThemeData(size: 30),
    // Styling for selected icons
    unselectedIconTheme: IconThemeData(size: 24),
    // Styling for unselected icons
    showSelectedLabels: false,
    // Show label for selected items
    showUnselectedLabels: false, // Hide label for unselected items
  ),
  colorScheme:
      ColorScheme.fromSeed(seedColor: Colors.black, brightness: Brightness.dark)
          .copyWith(
    surface: const Color(0xFFD9D9D9),
    /*
          canvasColor: const Color(0x00393737),
        primary: Colors.blue,
        secondary: Colors.green,
        onPrimary: Colors.white,
        onSecondary: Colors.white,
        background: Colors.white,
        onBackground: Colors.black,
        surface: Colors.white,
        onSurface: Colors.black,
        error: Colors.red,
        onError: Colors.white,
        primaryVariant: Colors.blue.shade700,
        secondaryVariant: Colors.green.shade700,
        brightness: Brightness.dark,
       */
  ),
  textTheme: const TextTheme(
    headlineLarge: TextStyle(fontSize: 24.0, fontFamily: 'sans-serif'),
  ),
);
