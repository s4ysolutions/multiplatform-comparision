import 'package:flutter/widgets.dart';
import 'package:provider/provider.dart';
import 'package:puretest/presentation/states/is_buying_popup.dart';

Widget provideStates({required Widget child}) {
  return MultiProvider(
    providers: [
      ChangeNotifierProvider(create: (_) => IsBuyingPopup()),
    ],
    child: child,
  );
}