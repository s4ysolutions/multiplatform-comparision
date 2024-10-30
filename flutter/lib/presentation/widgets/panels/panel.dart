import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/states/is_buying_popup.dart';

class Panel1 extends StatelessWidget {
  final Widget child;
  final bool haveAppBar;

  const Panel1({super.key, required this.child, this.haveAppBar = false});

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    //child: Consumer<IsBuyingPopup>(
    return Stack(
      children: <Widget>[
        LayoutBuilder(
            builder: (BuildContext context, BoxConstraints constraints) {
          return Consumer<IsBuyingPopup>(
              builder: (_, isBuyingPopup, __) => Padding(
                  padding: EdgeInsets.only(
                    // top: kToolbarHeight,
                    // 40 - height of temptation counter
                    top: 40 + 16 + 16 * 2 + 12,
                    //top: constraints.maxHeight * 0.2 - (haveAppBar ? 58 : 0),
                    /*
                top: constraints.maxHeight * 0.2 -
                    (haveAppBar ? kToolbarHeight : 0),
                 */
                    left: isBuyingPopup.active ? 16 : 0,
                    right: isBuyingPopup.active ? 16 : 0,
                  ),
                  child: Container(
                      decoration: BoxDecoration(
                        color: cs.surfaceContainerLow,
                        border:
                            Border.all(color: cs.onSurfaceVariant, width: 1),
                        borderRadius: const BorderRadius.only(
                          topLeft: Radius.circular(8.0),
                          topRight: Radius.circular(8.0),
                        ),
                      ),
                      height: constraints.maxHeight, // * 0.8,
                      width: constraints.maxWidth,
                      // 80% of the parent container's height
                      child: Padding(
                        padding: const EdgeInsets.all(16),
                        // should be 10
                        child: child,
                      ))));
        })
      ],
    );
  }
}
