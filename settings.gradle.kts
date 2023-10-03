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

rootProject.name = "Plants"
include(":app")
include(":viewmodel")
include(":usecase")
include(":ui")
include(":repository")
include(":remote")
include(":local")
include(":entities")
