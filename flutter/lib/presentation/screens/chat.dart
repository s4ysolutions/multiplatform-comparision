import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class ChatScreen extends StatelessWidget {
  final int id;

  const ChatScreen({required this.id, super.key});

  @override
  Widget build(BuildContext context) {
    return Center(
        child: ElevatedButton(
          onPressed: () => GoRouter.of(context).pop(),
          child: const Text('Go back'),
        ),
      );
  }
}
