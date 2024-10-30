import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';

class Chat extends StatelessWidget {
  const Chat();

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;
    final tt = Theme.of(context).textTheme;
    return Container(
        height: kToolbarHeight,
        padding: const EdgeInsets.only(top: 36),
        child: Text(
          l10n.beginConversation,
          textAlign: TextAlign.center,
          style: tt.displaySmall,
        ));
  }
}
