import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/bottom_sheets/buy_incognito/buy_sheet.dart';
import 'package:puretest/presentation/states/is_buying_popup.dart';

void showBuyIncognitoBottomSheet(BuildContext context) async {
  final isBuyingPopup = Provider.of<IsBuyingPopup>(context, listen: false);
  isBuyingPopup.active = true;

  await showModalBottomSheet(
    context: context,
    builder: (context) => const BuyIncognitoBottomSheet(),
    useRootNavigator: true,
  );

  isBuyingPopup.active = false;
}
