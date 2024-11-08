# DEMO Kotlin App for social network

This is a demo application built with Kotlin to showcase essential UI use case,
UI state management, and state-based communication with business logic levels.


## Architecture

The app follows a clean architecture approach, organizing code into modules based on responsibility:

- **Data, Drivers, and Application**: The [ca](app/src/main/java/solutions/s4y/puredemo/ca) package
- contains mocked business logic that simulates two kinds of data:
[database](app/src/main/java/solutions/s4y/puredemo/ca/data) `get`
  **async API** implemented as **SQLite** database with Room ORM and bus pub/sub
  [service](app/src/main/java/solutions/s4y/puredemo/ca/bus) with **Flow** API.
  These data levels are connected through
 [unifying drivers](app/src/main/java/solutions/s4y/puredemo/ca/drivers) to the application
 [level](app/src/main/java/solutions/s4y/puredemo/ca/domain) that provides the domain
 models and services to be used on the 
 [ui(presenter)](app/src/main/java/solutions/s4y/puredemo/ui) level.
- **Use cases**: The [ui.viewmodels](app/src/main/java/solutions/s4y/puredemo/ui)
 directory contains ViewModels classes that either encapsulate business logic for the app's features or
  provide the data from the services to UI components.
- **Presentation**: The [ui.compose](app/src/main/java/solutions/s4y/puredemo/ui/compose)
      package contains the app's UI roughly divided into three parts:
    - **Screens**: The [ui.compose.screens](app/src/main/java/solutions/s4y/puredemo/ui/compose/screens)
    - `ChatsScreen`, `ChatScreen`, `SettingsScreen`, etc. are primary entry points and should be prioritized for review
    by support and development teams during any investigation. These screens serve as essential touch-points
    for diagnosing issues.
    - **Widgets**: The [ui.compose.composables](app/src/main/java/solutions/s4y/puredemo/ui/compose/composables) are
    building blocks for the screens. Some of them may contain bad coding practices and workarounds, but those caveats
    are encapsulated within the widget with the stable API, thus they can be fixed later without affecting
    the rest of the app.
    - **Misc**: The other packages like
      - [ui.compose.bottomsheets](app/src/main/java/solutions/s4y/puredemo/ui/compose/bottomsheets) exposing
        `BottomSheetAware` composable to report other components either bottom sheet is opened or closed
        and `BottomSheetsHost` to be used in conjunction with `Scaffold`,
      - [ui.compose.scaffold](app/src/main/java/solutions/s4y/puredemo/ui/compose/scaffold),
      - [ui.compose.appbars](app/src/main/java/solutions/s4y/puredemo/ui/compose/appbars),
     etc. are for the essential app-wide components and utilities.
    - The **Navigation** is implemented with the
      [ui.compose.navigation](app/src/main/java/solutions/s4y/puredemo/ui/compose/navigation)
      package containing the
      configuration of the app's navigation connecting
      typed with [sealed classes routes](app/src/main/java/solutions/s4y/puredemo/ui/compose/navigation/routes.kt)
      with the [composable destinations](app/src/main/java/solutions/s4y/puredemo/ui/compose/navigation/MainNavHost.kt).
    - The UI is themed with the [ui.theme](app/src/main/java/solutions/s4y/puredemo/ui/theme)
      directory containing the app's color, typography, and other design tokens. The design represents the
      challenging case of not following the Material UI guidelines, so the theme provides extra level
      of abstraction to make the UI consistent.
- **Localization**: Unlike the [Flutter](../flutter) implementation, there's no custom code for localization
  in the Kotlin app. The app uses the standard Android localization mechanism with the
  [res/values/string*](app/src/main/res/values) directories containing the localized strings and resources.

## Side-effect free

  While side-effects are first mentioned in the Compose UI documentation architectural components and sometimes
  they are impossible to avoid, this app demonstrates the approach to get rif of side-effects in the UI code.

  The common approach is to have the data required for the UI pre-fetched and stored in the ViewModel. Their 
  statuses are provided through the `Flow` API.

  This approach leads to a subtle problem when the view model depends on the current UI state: say we need to
  show information about a specific chat by its id: the view model begins to depend on UI which is absolutely
  against the Clean Architecture principles.

  This backward control flow is implemented as a view model's method
  [ui.viewmodels.ChatViewModel::getChat](app/src/main/java/solutions/s4y/puredemo/ui/viewmodels/ChatViewModel.kt)
  which causes terribly ugly usage in the [UI code](app/src/main/java/solutions/s4y/puredemo/ui/appbars/ChatAppBar.kt):
  ```kotlin
   val chatInfoFlow by remember( model, chatId) { model.chatFlow(chatId) }
   val chatInfo = chatInfoFlow.collectAsState(Payload.Loading)
  ```

  At the moment of writing, there's no perfect solution for this problem, and the falling back to the

  ```kotlin
    LaunchedEffect(chatId) {
      model.getChat(chatId)
    }
  ```

  of course, it is not an option. Rather, it should be a ViewModel Factory creating the ViewModel instances accordint to
  the required ID, but even this doesn't answer the question: what is a source of the ID? And even worse: where this
  factory should be located in the architecture? Placing the calling of the factory in the dagger adds the logic to DI
  and makes it even more complicated and non-obvious.
  
## Testing

  This demo-app is not intended to be 100% covered with tests, but it still has
  [a unit test](app/src/test/java/solutions/s4y/puredemo/ui/compose/composables/chats/LikesCountTest.kt) demonstrating a banch ot
    the testing techniques: **Robolectric**, parameterizing, testing Composable against substituted Android context with
    enforced localizations.