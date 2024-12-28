// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "ComLinaSmsplugin",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "ComLinaSmsplugin",
            targets: ["smspluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "smspluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/smspluginPlugin"),
        .testTarget(
            name: "smspluginPluginTests",
            dependencies: ["smspluginPlugin"],
            path: "ios/Tests/smspluginPluginTests")
    ]
)