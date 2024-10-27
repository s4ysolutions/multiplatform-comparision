import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class ChatsScreen extends StatelessWidget {
  const ChatsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: ElevatedButton(
        onPressed: () => context.go('/chats/0'),
        child: const Text('Go to the chat(0) screen'),
      ),
    );
  }
}
