load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "aoc19_lib",
    srcs = glob(["src/main/kotlin/**"]),
    deps = [
        "@maven//:org_jetbrains_kotlinx_kotlinx_coroutines_core",
    ],
)

java_binary(
    name = "aoc19_app",
    main_class = "com.ckfce.aoc19.Runner",
    visibility = ["//visibility:public"],
    runtime_deps = [":aoc19_lib"],
)
