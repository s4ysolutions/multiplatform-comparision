import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/state/notifiers/buy_incognito_visibility.dart';

class ChatsPanel extends StatelessWidget {
  final Widget child;

  const ChatsPanel({super.key, required this.child});

  @override
  Widget build(BuildContext context) {
    return Consumer<BuyIncognitoVisibility>(
        builder: (context, buyIncognitoVisibility, _) {
      return LayoutBuilder(
          builder: (BuildContext context, BoxConstraints constraints) {
        return Padding(
            padding: EdgeInsets.only(
                top: constraints.maxHeight * 0.2,
                left: buyIncognitoVisibility.isVisible ? 16 : 0,
                right: buyIncognitoVisibility.isVisible ? 16 : 0),
            child: Container(
              decoration: BoxDecoration(
                color: Theme.of(context).colorScheme.surfaceContainerLow,
                borderRadius: const BorderRadius.only(
                  topLeft: Radius.circular(8.0),
                  topRight: Radius.circular(8.0),
                ),
              ),
              height: constraints.maxHeight * 0.8,
              width: constraints.maxWidth,
              // 80% of the parent container's height
              child: child,
            ));
      });
    });
  }
}
