import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/state/notifiers/buy_incognito_visibility.dart';
import 'package:puretest/presentation/widgets/buy/panel.dart';

class AppWrapper extends StatelessWidget {
  final Widget child;

  const AppWrapper({super.key, required this.child});

  @override
  Widget build(BuildContext context) {
    return Consumer<BuyIncognitoVisibility>(
        builder: (context, buyIncognitoVisibility, _) {
      return Stack(
        children: [
          child,
          if (buyIncognitoVisibility.isVisible)
            Container(
              color: Colors.black.withOpacity(0.5),
            ),
          if (buyIncognitoVisibility.isVisible)
            Positioned(
                bottom: 0,
                height: MediaQuery.of(context).size.height * 0.53,
                width: MediaQuery.of(context).size.width,
                child: BuyIncognito(
                    buyIncognitoVisibility: buyIncognitoVisibility)),
        ],
      );
    });
  }
}
