import 'package:flutter/material.dart';
import 'package:puretest/services/chat_service.dart';

final _regex = RegExp(r'image(\d+)\.jpg');

extension ChatInfoModelHelper on ChatInfoModel {
  Widget get image {
    final match = _regex.firstMatch(imageUrl.path);
    if (match != null) {
      final number = int.parse(match.group(1)!);
      if (number >= 1 && number <= 6) {
        return Image.asset('assets/images/chats/users/$number.png');
      }
    }
    return const SizedBox();
  }
}
