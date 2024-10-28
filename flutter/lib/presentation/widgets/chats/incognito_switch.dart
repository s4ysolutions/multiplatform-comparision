import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:flutter_svg/svg.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/state/notifiers/buy_incognito_visibility.dart';

class ChatIncognitoSwitch extends StatelessWidget {
  const ChatIncognitoSwitch({super.key});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;

    return Consumer<BuyIncognitoVisibility>(
        builder: (context, buyIncognitoVisibility, _) {
          return TextButton(
              onPressed: () {
                Provider.of<BuyIncognitoVisibility>(context, listen: false)
                    .toggle();
              },
              child: Row(children: [
                Text(
                  l10n.off.toUpperCase(),
                  /*
                  style: Theme
                      .of(context)
                      .textTheme
                      .labelLarge,
                   */
                ),
                const SizedBox(width: 12),
                SvgPicture.asset("assets/images/chats/incognito_switch_off.svg",
                    width: 40, height: 20),
              ]));
        }
    );
  }
}
