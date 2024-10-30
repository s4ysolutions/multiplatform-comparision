import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:puretest/presentation/theme/main_theme.dart';

class ChatPrompt extends StatelessWidget {
  const ChatPrompt({super.key});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;
    final tt = Theme.of(context).textTheme;
    final colorChat = tt.displayMedium!.color!;
    return Row(children: [
      SizedBox(
          height: 16,
          width: 24,
          child: TextButton(
              onPressed: () {},
              child: SvgPicture.asset(
                "assets/images/chats/plus.svg",
                height: 18,
                //width: 14,
                colorFilter: ColorFilter.mode(colorChat, BlendMode.srcIn),
              ))),
      const SizedBox(width: 8),
      Expanded(
          child: Container(
              decoration: BoxDecoration(
                border: Border.all(color: colorChat, width: 1), // Border color
                borderRadius: BorderRadius.circular(8), // Rounded corners
              ),
              padding: const EdgeInsets.only(left: 8, right: 8),
              height: 34,
              child: Center(
                  child: Row(
                      //crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                    Expanded(
                        child: SizedBox(height: 34, child:TextField(
                            decoration: InputDecoration(
                              // filled: true,
                              // fillColor: Colors.green,
                              border: InputBorder.none,
                              // contentPadding: const EdgeInsets.symmetric(vertical: , horizontal: 0.0),
                              //contentPadding: const EdgeInsets.symmetric(horizontal: 0.0),
                              //contentPadding: const EdgeInsets.all(0),
                              contentPadding: const EdgeInsets.only(bottom: 17),
                              hintText: l10n.messagePrompt,
                              hintStyle: textStyleChatHint,
                            ),
                            textAlignVertical: TextAlignVertical.top,
                            style: tt.displayMedium))),
                    SvgPicture.asset("assets/images/chats/alien.svg",
                        height: 24),
                  ])))),
      const SizedBox(width: 8),
      SizedBox(
          width: 24,
          child: TextButton(
              onPressed: () {},
              child: SvgPicture.asset(
                "assets/images/chats/mic.svg",
                height: 20,
                //width: 14,
                colorFilter: ColorFilter.mode(colorChat, BlendMode.srcIn),
              ))),
    ]);
  }
}
