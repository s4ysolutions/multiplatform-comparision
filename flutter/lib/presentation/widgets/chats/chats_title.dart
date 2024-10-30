import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';

class ChatsTitle extends StatelessWidget {
  const ChatsTitle({super.key});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;
    return Text(l10n.chatsTitle.toUpperCase(),
        style: Theme.of(context).textTheme.titleLarge);
  }
}
