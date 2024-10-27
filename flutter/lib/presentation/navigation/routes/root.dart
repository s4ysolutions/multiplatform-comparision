import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:puretest/presentation/scaffolds/bottom_nav.dart';

import '../../screens/chat.dart';
import '../../screens/chats.dart';
import '../../screens/favorites.dart';
import '../../screens/home.dart';
import '../../screens/settings.dart';

final RouteBase rootRoute = ShellRoute(
    builder: (context, state, child) {
      // i prefer to pass down the state to the bottom nav bar
      // over the getting it from the context each time
      return BottomNavScaffold(child: child, state: state);
    },
    routes: <RouteBase>[
      GoRoute(
          path: '/home',
          builder: (BuildContext context, GoRouterState state) {
            return const HomeScreen();
          }),
      GoRoute(
          path: '/chats',
          builder: (BuildContext context, GoRouterState state) {
            return const ChatsScreen();
          },
          routes: <RouteBase>[
            GoRoute(
              path: ':chatId',
              builder: (BuildContext context, GoRouterState state) {
                final chatId = int.parse(state.pathParameters['chatId']!);
                return ChatScreen(id: chatId);
              },
            )
          ]),
      GoRoute(
          path: '/favorites',
          builder: (BuildContext context, GoRouterState state) {
            return const FavoritesScreen();
          }),
      GoRoute(
          path: '/settings',
          builder: (BuildContext context, GoRouterState state) {
            return const SettingsScreen();
          }),
    ]);
