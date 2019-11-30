load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

rules_kotlin_version = "legacy-1.3.0-rc1"
rules_kotlin_sha = "9de078258235ea48021830b1669bbbb678d7c3bdffd3435f4c0817c921a88e42"
http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % rules_kotlin_version],
    type = "zip",
    strip_prefix = "rules_kotlin-%s" % rules_kotlin_version,
    sha256 = rules_kotlin_sha,
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")
kotlin_repositories() # if you want the default. Otherwise see custom kotlinc distribution below
kt_register_toolchains() # to use the default toolchain, otherwise see toolchains below

RULES_JVM_EXTERNAL_TAG = "2.7"

RULES_JVM_EXTERNAL_SHA = "f04b1466a00a2845106801e0c5cec96841f49ea4e7d1df88dc8e4bf31523df74"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
