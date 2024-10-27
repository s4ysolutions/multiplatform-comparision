import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:puretest/presentation/widgets/bottom_nav.dart';

class BottomNavScaffold extends StatelessWidget {
  final Widget child;
  final GoRouterState state;

  const BottomNavScaffold({super.key, required this.child, required this.state});

  @override
  Widget build(BuildContext context) {
    final currentPath = GoRouterState.of(context).uri.path;
    final bottom = currentPath == '/home' ||
        currentPath == '/chats' ||
        currentPath == '/favorites' ||
        currentPath == '/settings';
    return Scaffold(
      body: child,
      bottomNavigationBar: bottom ? MainBottomNavBar(state: state) : null,
    );
  }
}
