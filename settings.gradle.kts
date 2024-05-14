plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "MahjongSpring"

include("business")
include("controller")

include("business:kotlin-common")
include("business:oauth-api")
include("business:discord-logic-main")

include("controller:discord-operation")