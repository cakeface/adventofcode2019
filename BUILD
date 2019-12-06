load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library", "kt_jvm_test", "define_kt_toolchain")

KOTLIN_LANGUAGE_LEVEL = "1.3"
KOTLIN_LANGUAGE_LEVEL = "1.3"
JAVA_LANGUAGE_LEVEL = "1.8"

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = KOTLIN_LANGUAGE_LEVEL,  # "1.1", "1.2", or "1.3"
    jvm_target = JAVA_LANGUAGE_LEVEL, # "1.6" or "1.8"
    language_version = KOTLIN_LANGUAGE_LEVEL,  # "1.1", "1.2", or "1.3"
)

kt_jvm_library(
    name = "aoc19_lib",
    srcs = glob(["src/main/kotlin/**"]),
    resources = glob(["src/main/resources/**"]),
    resource_strip_prefix = "src/main/resources",
    deps = [
        "@maven//:org_jetbrains_kotlinx_kotlinx_coroutines_core",
    ],
)

kt_jvm_library(
    name = "unit_tests_lib",
    srcs = glob(["src/test/kotlin/**"]),
    deps = [
        ":aoc19_lib",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)

kt_jvm_test(
    name = "day_1_unit_test",
    size = "small",
    srcs = [
        "src/test/kotlin/com/ckfce/aoc19/day1/Day1UTest.kt",
     ],
    deps = [
        ":unit_tests_lib",
    ],
    test_class = "com.ckfce.aoc19.day1.Day1UTest"
)

kt_jvm_test(
    name = "day_2_unit_test",
    size = "small",
    srcs = [
        "src/test/kotlin/com/ckfce/aoc19/day2/Day2UTest.kt",
        ],
    deps = [
        ":unit_tests_lib",
    ],
    test_class = "com.ckfce.aoc19.day2.Day2UTest"
)

kt_jvm_test(
    name = "day_3_unit_test",
    size = "small",
    srcs = [
        "src/test/kotlin/com/ckfce/aoc19/day3/Day3UTest.kt",
        ],
    deps = [
        ":unit_tests_lib",
    ],
    test_class = "com.ckfce.aoc19.day3.Day3UTest"
)

java_binary(
    name = "aoc19_app",
    main_class = "com.ckfce.aoc19.Runner",
    visibility = ["//visibility:public"],
    runtime_deps = [":aoc19_lib"],
)
