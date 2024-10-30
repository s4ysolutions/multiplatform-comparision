import 'package:puretest/services/chat_service.dart';

class ChatsService {
  Future<List<ChatInfoModel>> getChats() async {
    await Future.delayed(const Duration(milliseconds: 500));
    return chats;
  }
}
