import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class Product extends StatelessWidget {
  final String title;
  final int price;
  final String currency;
  final String? highlight;

  const Product({
    super.key,
    required this.title,
    required this.price,
    required this.currency,
    this.highlight,
  });

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final cs = theme.colorScheme;
    final tt = theme.textTheme;
    return Stack(
      children: [
        Container(
          decoration: BoxDecoration(
            color: cs.surfaceContainerLow,
            // Set the background color
            border: Border.all(color: cs.onSurfaceVariant),
            // Set the border color
            borderRadius: BorderRadius.circular(8.0), // Set the border radius
          ),
          padding: const EdgeInsets.only(top: 13.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    title,
                    style: tt.labelLarge,
                  ),
                  SizedBox(width: 4),
                  SvgPicture.asset("assets/images/buy/incognito.svg",
                      width: 30),
                ],
              ),
              Text(
                "$price $currency",
                style: tt.labelLarge,
              ),
            ],
          ),
        ),
        if (highlight != null)
          Transform.translate(
            offset: const Offset(0, -12),
            child: Align(
              alignment: Alignment.topCenter,
              child: SvgPicture.asset("assets/images/buy/bulb.svg", height: 25),
            ),
          ),
        if (highlight != null)
          Transform.translate(
            offset: Offset(0, -tt.labelMedium!.fontSize!/2),
            child: Align(
              alignment: Alignment.topCenter,
              child: Text(highlight!, style: tt.labelMedium!.copyWith(color: Colors.black)),
            ),
          )
      ],
    );
  }
}
