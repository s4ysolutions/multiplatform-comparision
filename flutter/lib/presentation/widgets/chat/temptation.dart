import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:puretest/presentation/theme/main_theme.dart';
import 'package:puretest/services/chat_service.dart';

class TemptationInCommonCounter extends StatelessWidget {
  final ChatInfoModel? chat;

  const TemptationInCommonCounter({super.key, required this.chat});

  @override
  Widget build(BuildContext context) {
    final reminder = chat?.temptationsCount ?? 0 % 10;
    final l10n = AppLocalizations.of(context)!;

    final temptation = reminder == 1
        ? l10n.temptationsInCommon1
        : reminder > 1 && reminder < 5
            ? l10n.temptationsInCommon24
            : l10n.temptationsInCommon50;

    return Container(
        decoration: const BoxDecoration(color: colorAttention),
        //Theme.of(context).colorScheme.surfaceContainerLowest),
        child: SizedBox(
            height: 40,
            child: Row(
              children: <Widget>[
                const SizedBox(width: padding),
                Image.asset(
                  "assets/images/chats/rocket.png",
                  height: 21,
                ),
                const SizedBox(width: hspace),
                Expanded(
                    child: Text(
                        chat == null
                            ? ""
                            : "${chat!.temptationsCount} $temptation",
                        style: Theme.of(context).textTheme.headlineSmall)),
                SizedBox(
                    width: 48,
                    child: TextButton(
                        onPressed: () => Navigator.pop(context),
                        child: SvgPicture.asset(
                          "assets/images/buy/cross.svg",
                          height: 8,
                          width: 8,
                          colorFilter:
                              const ColorFilter.mode(colorBody, BlendMode.srcIn),
                        )))
              ],
            )));
  }
}
