# GitPub
 App ready to pour you all your repositories!
 
 # Description
 
 This app aims to provide a simple way to connect an android app with your github account, showing you all your repositories and some profile information on the logged account.
 
 # Architecture
 For the separation of concerns, the recommendation of UI, Domain and Data layers was followed, so we could follow principles of clean architecture.
 
 ![image](https://user-images.githubusercontent.com/23667489/201109016-061f755b-31f2-4827-8ff1-9ce9335f7192.png)


 The app utilizes a modern MVVM approach as an architecture pattern, basing itself on a multi-module approach that divides modules into features and libraries, basing on the overall operability and connection with other modules. Here is how the structure currently looks:
 
 
![Skärmbild 2022-11-06 011540](https://user-images.githubusercontent.com/23667489/200148233-27039d94-7273-4ab8-b1ea-8c6be947b254.png)

Apart from that, the View layer was done utilizing Jetpack Compose, the mutability of screen state was done following Google guidelines with UiStates, while the state holders were implemented utilizing the Flow library.

On the data layer, the principle of single source of truth was followed when it came to repositories and data transmission, getting a very concise and straightfoward way of consuming and emitting data.

# Libraries

GitPub utilizes a few dependencies that are dear to Android Developers. To avoid conflicts between dependencies and an overall faster building process with Gradle, a buildSrc was created in order to have a single source of truth when it comes to dependencies.

 ## UI:

[Compose](https://developer.android.com/jetpack/compose?gclid=Cj0KCQjwk5ibBhDqARIsACzmgLQmoRGBqjhfIS01MLVLXSMgwhHyuDDprFlVzv2nv-7XbLJoxNiC39oaAr_4EALw_wcB&gclsrc=aw.ds) - Compose is an easy way to build reusable views that are also elegant and adaptable to changes.

[Coil](https://coil-kt.github.io/coil/): Modern image processor with excellent compatibility with Compose.

## Data:

[OkHttp](https://square.github.io/okhttp/) - Practical HTTP client that allow us fetching data with efficiency.

[Retrofit](https://square.github.io/retrofit/) - A safety-wrapper for HTTP calls.

[Moshi](https://github.com/square/moshi) - Library used to parse JSON efficiently.

[DataStore](https://developer.android.com/topic/libraries/architecture/datastore?gclid=CjwKCAiA9qKbBhAzEiwAS4yeDbZ5PodKraD4RLDE8EoFKscwo-WyyrRW3RB09cingsykCaKc1FHAoRoCGFUQAvD_BwE&gclsrc=aw.ds) - Android solution to store data locally in an assynchronous manner.

## Others:

[Koin](https://insert-koin.io/) - The chosen dependency injection framework to avoid work based on tools instead of events.

[MockK](https://mockk.io/) - Library to mock calls and objects with the purpose of making testing easier.

# Future improvements
- Testing capabilities can be improved regarding ComposeTestRule and also MainDispatcherRule for Coroutine operations.
- We receive the duration for the access_token, but at the moment we do not validate that information before making requests.
- Some improvements could be made if repository data sources returned Flows, it could be used on StateHolders to combine data.
- Not satisfied with the navigation, which is currently using a mix of activity navigation and compose native items for navigation. Would like to migrate it fully to ComposeNavigation.
- Currently, there is no friendly error message being delivered to the user when a request goes wrong.
- In the login screen, if we do not receive the code and state on the intent(suddenly leaving authentication), the UiState.IsLoading keeps going on forever.
- There is currently no way to refresh the repositoriesList or the user information.

