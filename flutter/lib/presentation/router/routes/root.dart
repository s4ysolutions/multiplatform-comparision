import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:puretest/presentation/scaffolds/main.dart';
import 'package:puretest/presentation/screens/chat.dart';
import 'package:puretest/presentation/screens/chats.dart';
import 'package:puretest/presentation/screens/favorites.dart';
import 'package:puretest/presentation/screens/home.dart';
import 'package:puretest/presentation/screens/settings.dart';

final RouteBase rootRoute = ShellRoute(
    builder: (context, state, child) {
      // i prefer to pass down the state to the bottom nav bar
      // over the getting it from the context each time
      return MainNavScaffold(child: child, state: state);
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
                final chatId = state.pathParameters['chatId'] ?? '0';
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
