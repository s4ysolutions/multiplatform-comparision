import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:go_router/go_router.dart';

class BottomNavScaffold extends StatelessWidget {
  final Widget child;
  final GoRouterState state;

  const BottomNavScaffold(
      {super.key, required this.child, required this.state});

  static ColorFilter? itemColor(BuildContext context, int buttonIndex, int currentIndex) {
    final color = currentIndex == buttonIndex
        ? Theme.of(context).bottomNavigationBarTheme.selectedItemColor
        : Theme.of(context).bottomNavigationBarTheme.unselectedItemColor;
    return color != null ? ColorFilter.mode(color, BlendMode.srcIn) : null;
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;
    final backgroundColor =
        Theme.of(context).bottomNavigationBarTheme.backgroundColor;
    final currentIndex = state.uri.path == '/home'
        ? 0
        : state.uri.path == '/chats'
            ? 1
            : state.uri.path == '/favorites'
                ? 2
                : 3;


    return Scaffold(
      body: child,
      bottomNavigationBar: _bottom()
          ? BottomNavigationBar(
              currentIndex: currentIndex,
              items: [
                BottomNavigationBarItem(
                    icon: SvgPicture.asset('assets/images/bottombar/home.svg',
                        width: 24,
                        height: 24,
                        colorFilter: itemColor(context, 0, currentIndex)),
                    label: l10n.homeLabel,
                    backgroundColor: backgroundColor),
                BottomNavigationBarItem(
                    icon: SvgPicture.asset('assets/images/bottombar/chats.svg',
                        width: 24,
                        height: 24,
                        colorFilter: itemColor(context, 1, currentIndex)),
                    label: l10n.chatsLabel,
                    backgroundColor: backgroundColor),
                BottomNavigationBarItem(
                    icon: SvgPicture.asset(
                        'assets/images/bottombar/favorites.svg',
                        width: 24,
                        height: 24,
                        colorFilter: itemColor(context, 2, currentIndex)),
                    label: l10n.favoritesLabel,
                    backgroundColor: backgroundColor),
                BottomNavigationBarItem(
                    icon: SvgPicture.asset(
                        'assets/images/bottombar/settings.svg',
                        width: 24,
                        height: 24,
                        colorFilter: itemColor(context, 3, currentIndex)),
                    label: l10n.settingsLabel,
                    backgroundColor: backgroundColor),
              ],
              onTap: (index) {
                switch (index) {
                  case 0:
                    context.go('/home');
                    break;
                  case 1:
                    context.go('/chats');
                    break;
                  case 2:
                    context.go('/favorites');
                    break;
                  case 3:
                    context.go('/settings');
                    break;
                }
              },
            )
          : null,
    );
  }

  bool _bottom() {
    var currentPath = state.uri.path;
    return currentPath == '/home' ||
        currentPath == '/chats' ||
        currentPath == '/favorites' ||
        currentPath == '/settings';
  }
}
