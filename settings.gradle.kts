plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "MahjongSpring"

include("discord-operation")
include("oauth-api")
include("kotlin-common")