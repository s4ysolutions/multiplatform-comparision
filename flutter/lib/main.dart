import 'package:flutter/widgets.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:provider/provider.dart';
import 'package:puretest/bloc/likes_count_bloc.dart';
import 'package:puretest/services/chat_service.dart';
import 'package:puretest/services/chats_service.dart';
import 'package:puretest/ui.dart';
import 'package:puretest/services/likes_count_service.dart';

void main() {
  // TODO: should be DI
  final likesCountService = LikesCountService();
  final chatService = ChatService();
  final chatsService = ChatsService();

  // TODO: for simplicity, create all BloCs on the top level
  final app = MultiBlocProvider(
    // BlocProviders
    providers: [
      BlocProvider(
        create: (context) => LikesCountBloc(likesCountService),
      ),
    ],
    child: MultiProvider(providers: [
      // Arbitrary services
      Provider<ChatsService>(
        create: (_) => chatsService,
      ),
      Provider<ChatService>(
        create: (_) => chatService,
      ),
      //], child: const UI()),
    ], child: const UI(locale: Locale("ru", "RU"))),
  );

  runApp(app);
}
