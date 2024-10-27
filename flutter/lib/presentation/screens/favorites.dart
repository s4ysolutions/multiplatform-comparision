import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class FavoritesScreen extends StatelessWidget {
  const FavoritesScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Favorites Screen')),
      body: Center(
        child: ElevatedButton(
          onPressed: () => context.go('/chats'),
          child: const Text('Go to the Chats screen'),
        ),
      ),
    );
  }
}