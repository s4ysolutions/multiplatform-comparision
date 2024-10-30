import 'dart:math';

import 'package:equatable/equatable.dart';

class ChatInfoModel extends Equatable {
  final Uri imageUrl;
  final DateTime lastMessageTime;
  final String lastMessage;
  final bool hasUnreadMessages;
  final bool marked;

  const ChatInfoModel({
    required this.imageUrl,
    required this.lastMessageTime,
    required this.lastMessage,
    required this.hasUnreadMessages,
    required this.marked,
  });

  @override
  // TODO: implement props
  List<Object?> get props =>
      [imageUrl, lastMessageTime, lastMessage, hasUnreadMessages, marked];
}

extension CalculatedProperties on ChatInfoModel {
  int get temptationsCount {
    return Random().nextInt(5);
  }
}

final List<ChatInfoModel> chats = [
  ChatInfoModel(
    imageUrl: Uri.parse('https://example.com/image1.jpg'),
    lastMessageTime: DateTime.now()
        .subtract(Duration(minutes: Random().nextInt(60 * 24))),
    lastMessage: 'Отлично выглядишь',
    hasUnreadMessages: false,
    marked: true,
  ),
  ChatInfoModel(
    imageUrl: Uri.parse('https://example.com/image2.jpg'),
    lastMessageTime: DateTime.now()
        .subtract(Duration(minutes: Random().nextInt(60 * 24))),
    lastMessage: 'Встретимся? Я рядом',
    hasUnreadMessages: false,
    marked: false,
  ),
  ChatInfoModel(
    imageUrl: Uri.parse('https://example.com/image3.jpg'),
    lastMessageTime: DateTime.now()
        .subtract(Duration(minutes: Random().nextInt(60 * 24))),
    lastMessage: 'Встретимся?',
    hasUnreadMessages: true,
    marked: false,
  ),
  ChatInfoModel(
    imageUrl: Uri.parse('https://example.com/image4.jpg'),
    lastMessageTime: DateTime.now()
        .subtract(Duration(minutes: Random().nextInt(60 * 24))),
    lastMessage: 'Давно хочу тебя увидеть',
    hasUnreadMessages: false,
    marked: false,
  ),
  ChatInfoModel(
    imageUrl: Uri.parse('https://example.com/image5.jpg'),
    lastMessageTime: DateTime.now()
        .subtract(Duration(minutes: Random().nextInt(60 * 24))),
    lastMessage: 'Скинь фото...',
    hasUnreadMessages: false,
    marked: false,
  ),
  ChatInfoModel(
    imageUrl: Uri.parse('https://example.com/image6.jpg'),
    lastMessageTime: DateTime.now()
        .subtract(Duration(minutes: Random().nextInt(60 * 24))),
    lastMessage: 'Привет',
    hasUnreadMessages: false,
    marked: false,
  ),
];

class ChatService {
  Future<ChatInfoModel> getChat(String id) async {
    await Future.delayed(const Duration(milliseconds: 500));
    // TODO: fix not found
    return chats[int.parse(id)] ?? chats[0];
  }
}
