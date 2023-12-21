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

rootProject.name = "CoffeeApp"
include(":app")
include(":presentation_coffee")
include(":data_coffee")
include(":domain_coffee")
include(":network_module")
include(":database_module")
include(":logging")
include(":dependency_injection")
