# GitPub
 App ready to pour you all your repositories!
 
 # Description
 
 This app aims to provide a simple way to connect an android app with your github account, showing you all your repositories and some profile information on the logged account.
 
 # Architecture
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

[DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - Android library that provides the possibility to store data in key-value pairs in a consistent assynchronous way.
