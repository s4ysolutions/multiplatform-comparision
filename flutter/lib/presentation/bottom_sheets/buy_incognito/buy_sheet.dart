import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:flutter_svg/svg.dart';
import 'package:puretest/presentation/bottom_sheets/buy_incognito/children/product.dart';
import 'package:puretest/presentation/theme/main_theme.dart';

// TODO: theming
class BuyIncognitoBottomSheet extends StatelessWidget {
  const BuyIncognitoBottomSheet({super.key});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;
    final tt = Theme.of(context).textTheme;
    final cs = Theme.of(context).colorScheme;
    return Container(
        decoration: BoxDecoration(
          color: cs.surfaceContainerHigh,
        ),
        padding: const EdgeInsets.only(left:16.0, right: 16.0),
        child: Column(
          children: <Widget>[
            Expanded(
                child: Stack(
              children: [
                Align(
                  alignment: Alignment.center,
                  child: SvgPicture.asset(
                      "assets/images/buy/incognito_mode.svg",
                      fit: BoxFit.cover),
                ),
                Positioned(
                    top: 8,
                    right: -4,
                    child: IconButton(
                      icon: SvgPicture.asset("assets/images/buy/cross.svg",
                          height: 10, width: 10),
                      onPressed: () {
                        Navigator.pop(context);
                        /*
                        buyIncognitoVisibility.toggle();
                    Provider.of<BuyIncognitoVisibility>(context, listen: false)
                        .toggle();
                     */
                      },
                    )),
              ],
            )),
            const SizedBox(height: 16),
            Expanded(
                child: Column(
              children: [
                RichText(
                  text: TextSpan(
                    children: [
                      TextSpan(
                        text: l10n.incognito_mode_24_1.toUpperCase(),
                      ),
                      TextSpan(
                        text: l10n.incognito_mode_24_2.toUpperCase(),
                        style: tt.titleMedium?.copyWith(
                          fontStyle: FontStyle.italic,
                        ),
                      ),
                      TextSpan(
                        text: l10n.incognito_mode_24_3.toUpperCase(),
                      ),
                    ],
                    style: tt.titleMedium,
                  ),
                ),
                const Spacer(),
                Text(
                  l10n.incognito_mode_24_description,
                  style: tt.displayMedium,
                ),
                const Spacer(),
              ],
            )),
            const SizedBox(height: 16),
            Row(
              children: [
                Expanded(child: Product(title: "1", price: 99, currency: "₽")),
                SizedBox(width: 16),
                Expanded(
                    child: Product(
                        title: "3",
                        price: 199,
                        currency: "₽",
                        highlight: "Хит")),
                SizedBox(width: 16),
                Expanded(
                    child: Product(
                  title: "7",
                  price: 399,
                  currency: "₽",
                  highlight: "-42%",
                )),
              ],
            ),
            const SizedBox(height: 16),
            Expanded(
                child: Column(
              children: [
                Container(
                    width: double.infinity,
                    child: SizedBox(
                        height: 50,
                        child: ElevatedButton(
                            style: buyButtonStyle,
                            onPressed: () {},
                            child: Text(
                              l10n.buyLabel,
                              style: const TextStyle(
                                  fontSize: 16.0,
                                  fontWeight: FontWeight.w400,
                                  color: Color(0xFFF6F4F4)),
                            )))),
                const SizedBox(height: 16),
                TextButton(
                    onPressed: () {},
                    child: Text(l10n.termsConditionsLabel.toUpperCase(),
                        style: tt.labelLarge))
              ],
            )),
          ],
        ));
  }
}
