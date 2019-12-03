load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library", "kt_jvm_test")

kt_jvm_library(
    name = "aoc19_lib",
    srcs = glob(["src/main/kotlin/**"]),
    resources = glob(["src/main/resources/**"]),
    resource_strip_prefix = "src/main/resources",
    deps = [
        "@maven//:org_jetbrains_kotlinx_kotlinx_coroutines_core",
    ],
)

kt_jvm_test(
    name = "unit_tests",
    size = "small",
    srcs = glob(["src/test/kotlin/**"]),
    deps = [
        ":aoc19_lib",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
    test_class = "com.ckfce.aoc19.day1.Day1UTest"
)


java_binary(
    name = "aoc19_app",
    main_class = "com.ckfce.aoc19.Runner",
    visibility = ["//visibility:public"],
    runtime_deps = [":aoc19_lib"],
)
