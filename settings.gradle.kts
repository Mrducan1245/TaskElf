pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TaskElf"
include(":app")
include(":core")
include(":core:domain")
include(":core:model")
include(":core:data")
include(":core:datastore")
include(":core:database")
include(":core:common")
include(":core:designsystem")
include(":feature")
