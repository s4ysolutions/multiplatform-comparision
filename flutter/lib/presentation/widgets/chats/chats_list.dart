import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:go_router/go_router.dart';
import 'package:provider/provider.dart';
import 'package:puretest/bloc/chats_bloc.dart';
import 'package:puretest/services/chat_service.dart';
import 'package:puretest/services/chats_service.dart';
import 'package:puretest/presentation/extensions/chat.dart';

class ChatsList extends StatelessWidget {
  const ChatsList({super.key});

  // overcomplicated just to be ready to use BlocProvider
  @override
  Widget build(BuildContext context) {
    return Consumer<ChatsService>(builder: (context, chatsService, _) {
      return BlocProvider(
          create: (context) => ChatsBloc(chatsService),
          child: const _ChatsList());
    });
  }
}

class _ChatsList extends StatelessWidget {
  const _ChatsList({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<ChatsBloc, ChatsState>(builder: (context, state) {
      if (state is ChatsLoading) {
        return const Center(child: CircularProgressIndicator());
      } else if (state is ChatsLoaded) {
        return ListView.separated(
            itemCount: state.chats.length,
            itemBuilder: (context, index) {
              final chat = state.chats[index];
              return InkWell(
                  onTap: () {
                    context.push('/chats/$index');
                  },
                  child: _ChatListItem(chat: chat));
            },
            separatorBuilder: (context, index) => const SizedBox(
                  height: 16,
                ));
      } else if (state is ChatsError) {
        return Center(child: Text(state.message));
      } else {
        return const SizedBox();
      }
    });
  }
}

class _ChatListItem extends StatelessWidget {
  final ChatInfoModel chat;

  const _ChatListItem({super.key, required this.chat});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;
    final tt = Theme.of(context).textTheme;
    return Row(children: [
      Container(
        width: 60,
          height: 60,
          decoration: chat.hasUnreadMessages ? const BoxDecoration(
            shape: BoxShape.circle,
            border: Border.fromBorderSide(BorderSide(
              color: Color(0xFFFFFFFF),
              width: 3,
            )),
          ): null,
          child: CircleAvatar(
        radius: 30,
        backgroundColor: const Color(0xFF1F093A),
        backgroundImage: chat.imageProvider,
      )),
      const SizedBox(width: 16),
      Expanded(
          child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
              l10n.timeFormat(
                  chat.lastMessageTime.hour, chat.lastMessageTime.minute),
              style: tt.bodySmall),
          const SizedBox(height: 4),
          Text(
            chat.lastMessage,
            style: tt.bodyMedium,
          ),
        ],
      )),
      if (chat.hasUnreadMessages)
        Container(
          width: 4,
          height: 4,
          decoration: const BoxDecoration(
            color: Color(0xFFF6F4F4),
            shape: BoxShape.circle,
          ),
        )
    ]);
  }
}
