import 'package:go_router/go_router.dart';
import 'package:puretest/presentation/router/routes/root.dart';

final routerConfig = GoRouter(
  initialLocation: '/chats',
  routes: [rootRoute],
);
