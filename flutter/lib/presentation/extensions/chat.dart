import 'package:flutter/material.dart';
import 'package:puretest/services/chat_service.dart';

final _regex = RegExp(r'image(\d+)\.jpg');

extension ChatInfoModelHelper on ChatInfoModel {
  Widget get imageWidget {
    final match = _regex.firstMatch(imageUrl.path);
    if (match != null) {
      final number = int.parse(match.group(1)!);
      if (number >= 1 && number <= 6) {
        return Image.asset('assets/images/chats/users/user$number.jpeg');
      }
    }
    return const SizedBox();
  }
  ImageProvider get imageProvider {
    final match = _regex.firstMatch(imageUrl.path);
    if (match != null) {
      final number = int.parse(match.group(1)!);
      if (number >= 1 && number <= 6) {
        return AssetImage('assets/images/chats/users/user$number.jpeg');
      }
    }
    return const AssetImage('assets/images/chats/users/user1.jpeg');
  }
}
