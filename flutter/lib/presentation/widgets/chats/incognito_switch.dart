import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:flutter_svg/svg.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/bottom_sheets/buy_incognito/show.dart';
import 'package:puretest/presentation/states/is_buying_popup.dart';

class ChatIncognitoSwitch extends StatelessWidget {
  const ChatIncognitoSwitch({super.key});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;
    final tt = Theme
        .of(context)
        .textTheme;

    return Row(children: [
      Text(
        l10n.off.toUpperCase(),
        style: tt.labelLarge,
      ),
      const SizedBox(width: 12),
      SizedBox(
          width: 40,
          height: 20,
          child: ElevatedButton(
            onPressed: () {
              showBuyIncognitoBottomSheet(context);
            },
            style: ElevatedButton.styleFrom(
              padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 0),
            ),
            child: Consumer<IsBuyingPopup>(
                builder: (_, isBuyingPopup, __) =>
                isBuyingPopup.active
                    ? Row(
                  mainAxisAlignment: MainAxisAlignment.start,
                  mainAxisSize: MainAxisSize.max,
                  // Ensures the button wraps its content
                  children: [
                    SvgPicture.asset(
                      "assets/images/chats/mic_off.svg",
                      width: 30,
                      height: 14,
                    ),
                  ],
                ) /*SvgPicture.asset("assets/images/chats/mic_off.svg",
                        width: 30,
                        height: 12)*/
                    : SvgPicture.asset(
                    "assets/images/chats/incognito_switch_off.svg",
                    width: 30,
                    height: 12)),
          ))
    ]);
  }
}
