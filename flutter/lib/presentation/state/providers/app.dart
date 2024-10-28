import 'package:flutter/cupertino.dart';
import 'package:provider/provider.dart';

import '../notifiers/buy_incognito_visibility.dart';

class AppProvider extends StatelessWidget {
  final TransitionBuilder builder;

  const AppProvider({super.key, required this.builder});

  @override
  Widget build(BuildContext context) {
    return MultiProvider(builder: builder, providers: [
      ChangeNotifierProvider(create: (context) => BuyIncognitoVisibility()),
    ]);
  }
}
