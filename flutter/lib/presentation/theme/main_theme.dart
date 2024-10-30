import 'package:flutter/material.dart';

const padding = 16.0;
const hspace = 8.0;
const em = 8.0;

// Semantic colors
const colorTitleMedium = Color(0xFFF6F4F4);
const colorBody = Color(0xFFF6F4F4);
const colorBodyMedium = colorBody;
const colorBodySmall = colorBody;
const colorHeadlineMedium = colorBody;
const colorHeadlineSmall = colorBody;
const colorChat = Color(0xFF8D8D8D);

const colorDesktopBackground = Color(0xFFD9D9D9);
const colorChatsPanelsBackground = Color(0xFF212020);
const colorIncognitoBuyPanelBackground = Color(0xFF0D1333);
const colorBottomBarBackground = Color(0xFF191818);

const colorPanelsBorderColor = Color(0xFF393737);

const colorAttention = Color(0xFF7446AC);
const colorBannerBackground = colorAttention;

const colorBuyButtonBackground = Color(0xFFAA044A);

// Semantic text styles
const textStyleScreenTitle = TextStyle(
  fontSize: 24.0,
  fontWeight: FontWeight.w400,
);

const textStyleButtonLabel = TextStyle(
  fontSize: 16.0,
  fontWeight: FontWeight.w400,
);

const textStyleChat = TextStyle(
  fontSize: 12.0,
  fontWeight: FontWeight.w300,
  color: colorChat,
);

const textStyleChatHint = TextStyle(
  fontSize: 14.0,
  fontWeight: FontWeight.w300,
  color: colorChat,
);

const textStyleChatMessage = TextStyle(
  fontSize: 14.0,
  fontWeight: FontWeight.w300,
  color: Colors.white,
);

final buyButtonStyle = ButtonStyle(
  backgroundColor: WidgetStateProperty.all<Color>(colorBuyButtonBackground),
  shape: WidgetStateProperty.all<OutlinedBorder>(
    RoundedRectangleBorder(
      borderRadius: BorderRadius.circular(8.0),
    ),
  ),
);

// No animation for page transitions, attempt to fight lags
class NoAnimationPageTransitionsBuilder extends PageTransitionsBuilder {
  const NoAnimationPageTransitionsBuilder();

  @override
  Widget buildTransitions<T>(
    PageRoute<T> route,
    BuildContext context,
    Animation<double> animation,
    Animation<double> secondaryAnimation,
    Widget child,
  ) {
    return child;
  }
}

// Mapping semantic colors to theme colors
final appTheme = ThemeData(
  useMaterial3: true,
  fontFamily: 'Ubuntu',
  appBarTheme: const AppBarTheme(
    backgroundColor: colorDesktopBackground,
    foregroundColor: colorTitleMedium,
    titleTextStyle: TextStyle(fontSize: 24.0, fontWeight: FontWeight.w400),
    actionsIconTheme: IconThemeData(size: 30),
  ),
  bottomNavigationBarTheme: const BottomNavigationBarThemeData(
    // more than 3 items, the bar will be of colort of the items
    backgroundColor: colorBottomBarBackground,
    // Background color of the bar
    selectedItemColor: Color(0xFFF2C94C),
    // Color for selected items
    unselectedItemColor: colorAttention,
    // Color for unselected items
    selectedIconTheme: IconThemeData(size: 30),
    // Styling for selected icons
    unselectedIconTheme: IconThemeData(size: 24),
    // Hide label for selected items
    showSelectedLabels: false,
    // Hide label for unselected items
    showUnselectedLabels: false,
  ),
  colorScheme:
      ColorScheme.fromSeed(seedColor: Colors.black, brightness: Brightness.dark)
          .copyWith(
    surfaceContainerLowest: colorDesktopBackground,
    surfaceContainerLow: colorChatsPanelsBackground,
    surfaceContainerHigh: colorIncognitoBuyPanelBackground,
    onSurfaceVariant: colorPanelsBorderColor,
  ),
  /*
  pageTransitionsTheme: const PageTransitionsTheme(
    builders: {
      TargetPlatform.android: NoAnimationPageTransitionsBuilder(),
      TargetPlatform.iOS: NoAnimationPageTransitionsBuilder(),
      TargetPlatform.macOS: NoAnimationPageTransitionsBuilder(),
      TargetPlatform.windows: NoAnimationPageTransitionsBuilder(),
      TargetPlatform.linux: NoAnimationPageTransitionsBuilder(),
    },
  ),
   */
  typography: Typography.material2021(),
  textTheme: const TextTheme(
    titleLarge: textStyleScreenTitle,
    labelLarge: textStyleButtonLabel,
    bodyMedium: TextStyle(
        fontSize: 14.0, fontWeight: FontWeight.w300, color: colorBodyMedium),
    bodySmall: TextStyle(
        fontSize: 12.0, fontWeight: FontWeight.w300, color: colorBodySmall),
    headlineMedium: TextStyle(
        fontSize: 14.0,
        fontWeight: FontWeight.w500,
        color: colorHeadlineMedium),
    headlineSmall: TextStyle(
        fontSize: 13.0,
        fontWeight: FontWeight.w300,
        color: colorHeadlineSmall,
        fontStyle: FontStyle.italic),
    displayMedium: textStyleChatMessage,
    displaySmall: textStyleChat,
  ),
  elevatedButtonTheme: ElevatedButtonThemeData(
    style: ButtonStyle(
      padding: WidgetStateProperty.all<EdgeInsetsGeometry>(
          const EdgeInsets.symmetric(horizontal: 0, vertical: 0)),
      backgroundColor: WidgetStateProperty.all<Color>(const Color(0xFF4f4f4f)),
      iconSize: WidgetStateProperty.all<double>(12.0),
    ),
  ),
  textButtonTheme: TextButtonThemeData(
    style: ButtonStyle(
      padding: WidgetStateProperty.all<EdgeInsetsGeometry>(
          const EdgeInsets.symmetric(horizontal: 0, vertical: 0)),
      iconSize: WidgetStateProperty.all<double>(12.0),
    ),
  ),
  buttonTheme: const ButtonThemeData(
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.all(Radius.circular(8.0)),
    ),
  ),
);
