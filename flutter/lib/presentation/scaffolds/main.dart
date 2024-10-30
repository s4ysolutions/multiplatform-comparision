import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:puretest/presentation/widgets/app_bars/chat_app_bar.dart';
import 'package:puretest/presentation/widgets/app_bars/empty_app_bar.dart';
import 'package:puretest/presentation/widgets/bottom_nav.dart';

class MainNavScaffold extends StatelessWidget {
  final Widget child;
  final GoRouterState state;

  const MainNavScaffold({super.key, required this.child, required this.state});

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    final routeState = GoRouterState.of(context);

    final uri = routeState.uri;

    final appBar = routeState.fullPath == '/chats/:chatId'
        ? (routeState.pathParameters['chatId'] != null
            ? chatAppBar(
                context: context, chatId: routeState.pathParameters['chatId']!)
            : null)
        : emptyAppBar(context: context);

    final currentPath = uri.path;
    final bottom = currentPath == '/home' ||
        currentPath == '/chats' ||
        currentPath == '/favorites' ||
        currentPath == '/settings';

    return Scaffold(
      appBar: appBar,
      backgroundColor: cs.surfaceContainerLowest,
      body: child,
      /*
      body: child,
       */
      bottomNavigationBar: bottom ? MainBottomNavBar(state: state) : null,
    );
    /*
    return UIStatesProvider(
        builder: (context, _) =>
            AppWrapper(
                child: Scaffold(
                  appBar: top ? chatAppBar() : null,
                  backgroundColor:
                  cs.surfaceContainerLowest,
                  body: child,
                  bottomNavigationBar:
                  bottom ? MainBottomNavBar(state: state) : null,
                )));
     */
  }
}
