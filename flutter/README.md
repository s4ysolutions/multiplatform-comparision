# DEMO Flutter App for social network

This is a demo application built with Flutter to showcase essential UI use case, UI state management and BLoC based
communication with business logic levels.

## Live demo
[WASM web demo](https://geomax.web.app/#/chats) - to test the localization, change the language in the browser settings or with browser extensions.

## Architecture

The app follows a clean architecture approach, organizing code into modules based on responsibility:

- **Data, Drivers, and Application**: The [lib/services](lib/services) directory contains mocked services that simulate top-level functionalities, including [mention specific functions, like fetching data or handling user inputs]. These services act as drivers for the app's primary features and enable testing without reliance on live data sources.
  The services represent 2 kinds of API:
  - **Future**: The [ChatServie.getChat(chatId)](https://github.com/s4ysolutions/multiplatform-comparision/blob/a7bd87769f5d44d75284fec2b387364b5ff5c48f/flutter/lib/services/chat_service.dart#L84C3-L84C50) returns a chat info model on with a short delay, simulating the latency of a network call.
  - **Stream**: The [LikesCountService.likesStream](https://github.com/s4ysolutions/multiplatform-comparision/blob/a7bd87769f5d44d75284fec2b387364b5ff5c48f/flutter/lib/services/likes_count_service.dart#L13) continuously emits a randomly changing count of likes for the current user.
- **Use cases**: The [lib/block](lib/bloc) directory contains BloC classes that encapsulate business logic for the app's features. Each BloC class exposes a set of streams that emit UI state changes in response to user actions or data updates.
  - **Cubit**: The [LikesCountBloc](https://github.com/s4ysolutions/multiplatform-comparision/blob/a7bd87769f5d44d75284fec2b387364b5ff5c48f/flutter/lib/bloc/likes_count_bloc.dart#L24C1-L24C21) subscribes to the `LikesCountService.likesStream` in the constructor and emits the latest count of likes as a stream of [Initial/Loaded](https://github.com/s4ysolutions/multiplatform-comparision/blob/a7bd87769f5d44d75284fec2b387364b5ff5c48f/flutter/lib/bloc/likes_count_bloc.dart#L8C1-L22C2) wrappers around the int counter.
  - **Cubit**: The [ChatsBloc](https://github.com/s4ysolutions/multiplatform-comparision/blob/a7bd87769f5d44d75284fec2b387364b5ff5c48f/flutter/lib/bloc/chats_bloc.dart#L31) with a method [redresh()](https://github.com/s4ysolutions/multiplatform-comparision/blob/a7bd87769f5d44d75284fec2b387364b5ff5c48f/flutter/lib/bloc/chats_bloc.dart#L38C8-L38C15) to be called on demand (when the specific UI component needs the list chats to be updated) and emits the resulte to a stream of [Loading/Loaded/Error](https://github.com/s4ysolutions/multiplatform-comparision/blob/a7bd87769f5d44d75284fec2b387364b5ff5c48f/flutter/lib/bloc/chats_bloc.dart#L11C1-L29C2) wrappers around the List<Chat> model.
- **Presentation**: The [lib/presentation](lib/presentation) directory contains the app's UI roughly devided into 3 parts:
  - **Screens**: The [lib/presentation/screens](lib/presentation/screens) `ChatsScreen`, `ChatScreen`, `SettingsScreen`, etc are primary entry points and should be prioritized for review by support and development teams during any investigation. These screens serve as essential touchpoints for diagnosing issues.
  - **Widgets**: The [lib/presentation/widgets](lib/presentation/widgets) are building blocks for the screens. Some of them may contain bad coding practices and workarounds, but those caveats are encapsulated within the widget with the stable API, thus they can be fixed later without affecting the rest of the app.
  - **Misc**: The other subdirectories like [lib/presentation/bottom_sheets](lib/presentation/bottom_sheets), [lib/presentation/scaffolds](lib/presentation/scaffolds), [lib/presentation/extensions](lib/presentation/extensions), etc are for the essential app-wide components and utilities.
  - The **Navigation** is implemented with the [lib/presentation/navigation](lib/presentation/navigation) directory containing the configuration of the app's navigation routes.
  - The UI is themed with the [lib/presentation/theme](lib/presentation/theme) directory containing the app's color, typography, and other design tokens. The design represents the hard case of not following the Material UI guidelines, so the theme provides extra level of abstraction to make the UI consistent.
- **Localization**: While the l10n mainly used on the presentation level, it is kept in the top level directory [lib/l10n](lib/l10n) just for convenience. The current locale determined by the system settings, but the app provides a way to fix it with hardcoded [property](https://github.com/s4ysolutions/multiplatform-comparision/blob/a7bd87769f5d44d75284fec2b387364b5ff5c48f/flutter/lib/ui.dart#L9C3-L9C24).
