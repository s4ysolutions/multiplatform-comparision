import 'package:flutter/material.dart';
import 'package:puretest/presentation/router/config.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_gen/gen_l10n/app_l10n.dart';
import 'package:puretest/presentation/states/provider.dart';
import 'package:puretest/presentation/theme/main_theme.dart';

class UI extends StatelessWidget {
  final Locale? locale;

  const UI({super.key, this.locale});

  @override
  Widget build(BuildContext context) {
    return provideStates(
        child: MaterialApp.router(
      localizationsDelegates: const [
        AppLocalizations.delegate,
        ...GlobalMaterialLocalizations.delegates,
      ],
      routerConfig: routerConfig,
      supportedLocales: const [
        Locale('en'),
        Locale('ru'),
      ],
      locale: locale,
      title: 'Demo app',
      theme: appTheme,
    ));
  }
}
