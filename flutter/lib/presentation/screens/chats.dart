import 'package:flutter/material.dart';
import 'package:puretest/presentation/widgets/chats/title.dart';
import 'package:puretest/presentation/widgets/chats/panel.dart';

import '../widgets/chats/incognito_switch.dart';

class ChatsScreen extends StatelessWidget {
  const ChatsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return const ChatsPanel(
        child: Padding(
            padding: EdgeInsets.all(16),
            child: Column(
              children: <Widget>[
                Row(
                  children: <Widget>[
                    Expanded(child: ChatsTitle()),
                    ChatIncognitoSwitch(),
                  ],
                ),
                Text('Chat 2'),
                Text('Chat 3'),
              ],
            )));
  }
}
