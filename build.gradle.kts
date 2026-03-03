// Top-level build file where you can add configuration options common to all sub-projects/modules.
<<<<<<< HEAD

=======
>>>>>>> 70cc4ce800e662a0ae26fe0d4cf491791b3dab30
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
<<<<<<< HEAD
        classpath(
            "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1"
        )
    }
}

=======
        classpath (
            "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
        classpath (
            "com.google.gms:google-services:4.4.4"
        )
    }
}
>>>>>>> 70cc4ce800e662a0ae26fe0d4cf491791b3dab30
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    kotlin("plugin.serialization") version "2.2.20" apply false
    alias(libs.plugins.google.gms.google.services) apply false
<<<<<<< HEAD
}
=======
}
>>>>>>> 70cc4ce800e662a0ae26fe0d4cf491791b3dab30
