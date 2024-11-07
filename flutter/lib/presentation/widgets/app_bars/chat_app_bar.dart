import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/extensions/chat.dart';
import 'package:puretest/presentation/widgets/app_bars/leading_back.dart';
import 'package:puretest/services/chat_service.dart';

AppBar chatAppBar({required BuildContext context, required String chatId}) {
  final chatService = Provider.of<ChatService>(context);
  return AppBar(
    actions: [
      IconButton(
        icon: const Icon(Icons.more_vert),
        onPressed: () {}
      ),
    ],
    automaticallyImplyLeading: false,
    centerTitle: false,
    leading: IconButton(
      icon: leadingBack,
      onPressed: () => context.pop(),
    ),
    leadingWidth: 50,
    title: FutureBuilder(
        future: chatService.getChat(chatId),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Text('');
          }
          return SizedBox(
              height: 30,
              child: FittedBox(
                  fit: BoxFit.fitHeight,
                  child: snapshot.data?.imageWidget ?? const Text('')));
        }),
    titleSpacing: 0,
  );
}
