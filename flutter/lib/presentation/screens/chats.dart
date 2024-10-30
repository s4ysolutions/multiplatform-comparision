import 'package:flutter/material.dart';
import 'package:puretest/presentation/widgets/chats/chats_list.dart';
import 'package:puretest/presentation/widgets/chats/likes_count.dart';
import 'package:puretest/presentation/widgets/chats/chats_title.dart';
import 'package:puretest/presentation/widgets/panels/panel.dart';

import '../widgets/chats/incognito_switch.dart';

class ChatsScreen extends StatelessWidget {
  const ChatsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Stack(children: [
      Positioned(
          left: 0,
          right: 0,
          bottom: 0,
          child: Container(
            color: Colors.black, // Set background color to black
            width: double.infinity, // Fit the width of the parent
            height: MediaQuery.of(context).size.height *
                0.65, // Set height to 60% of the screen
          )),
      Panel1(
          child: Column(
        children: <Widget>[
          Row(
            children: <Widget>[
              const Expanded(child: const ChatsTitle()),
              const ChatIncognitoSwitch(),
            ],
          ),
          SizedBox(height: 16),
          const LikesCount(),
          SizedBox(height: 16),
          Expanded(child: const ChatsList()),
        ],
      ))
    ]);
  }
}
