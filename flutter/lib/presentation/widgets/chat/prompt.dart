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
          child: SizedBox(
              height: 34,
              child: TextField(
                  decoration: InputDecoration(
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(8.0),
                      borderSide: BorderSide(
                        color: colorChat,
                        width: 2.0,
                      ),
                    ),
                    enabledBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(8.0),
                      borderSide: BorderSide(
                        color: colorChat,
                        width: 2.0,
                      ),
                    ),
                    focusedBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(8.0),
                      borderSide: BorderSide(
                        color: colorChat,
                        width: 2.0,
                      ),
                    ),
                    // contentPadding: const EdgeInsets.all(0),
                    hintText: l10n.messagePrompt,
                    hintStyle: textStyleChatHint,
                    suffixIcon: Container(
                        padding: const EdgeInsets.all(4),
                        child:
                            SvgPicture.asset("assets/images/chats/alien.svg")),
                  ),
                  textAlignVertical: TextAlignVertical.top,
                  style: tt.displayMedium))),
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
