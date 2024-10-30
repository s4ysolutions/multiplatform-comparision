import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/widgets/chat/chat.dart';
import 'package:puretest/presentation/widgets/chat/prompt.dart';
import 'package:puretest/presentation/widgets/chat/temptation.dart';
import 'package:puretest/presentation/widgets/panels/panel.dart';
import 'package:puretest/services/chat_service.dart';

class ChatScreen extends StatelessWidget {
  final String id;

  const ChatScreen({required this.id, super.key});

  @override
  Widget build(BuildContext context) {
    final chatService = Provider.of<ChatService>(context);
    return FutureBuilder(
        future: chatService.getChat(id),
        builder: (context, snapshot) {
          return Stack(children: [
            Column(children: [
              SizedBox(
                height: 16 * 2 + 14,
              ),
              TemptationInCommonCounter(
                  chat: snapshot.hasData ? snapshot.requireData : null)
            ]),
            const Panel1(
                haveAppBar: true,
                child: Column(children: [
                  Expanded(child: Chat()),
                  ChatPrompt(),
                  SizedBox(height: kBottomNavigationBarHeight),
                ]))
          ]);
        });
  }
}
