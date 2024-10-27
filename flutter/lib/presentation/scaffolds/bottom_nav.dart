import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:go_router/go_router.dart';

class BottomNavScaffold extends StatelessWidget {
  final Widget child;
  final GoRouterState state;

  const BottomNavScaffold({required this.child, required this.state});

  @override
  Widget build(BuildContext context) {
    var l10n = AppLocalizations.of(context)!;
    return Scaffold(
      body: child,
      bottomNavigationBar: _bottom()
          ? BottomNavigationBar(
              currentIndex: state.uri.path == '/home'
                  ? 0
                  : state.uri.path == '/chats'
                      ? 1
                      : state.uri.path == '/favorites'
                          ? 2
                          : 3,
              items: [
                BottomNavigationBarItem(
                    icon: const Icon(Icons.home), label: l10n.homeLabel),
                BottomNavigationBarItem(
                    icon: const Icon(Icons.chat), label: l10n.chatsLabel),
                BottomNavigationBarItem(
                    icon: const Icon(Icons.favorite),
                    label: l10n.favoritesLabel),
                BottomNavigationBarItem(
                    icon: const Icon(Icons.settings),
                    label: l10n.settingsLabel),
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