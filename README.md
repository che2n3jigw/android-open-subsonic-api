# android-open-subsonic-api

[![](https://jitpack.io/v/che2n3jigw/android-open-subsonic-api.svg)](https://jitpack.io/#che2n3jigw/android-open-subsonic-api)

An Open-Subsonic API library for Android.

## 添加依赖

settings.gradle
```gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}
```

libs.versions.toml
```toml
[versions]
# open subsonic api库(根据实际版本)
openSubsonicApi = "{latest version}"

[libraries]
android-open-subsonic-api = { module = "com.github.che2n3jigw:android-open-subsonic-api", version.ref = "openSubsonicApi" }
```

build.gradle.kts(module)
```gradle
dependencies {
    implementation(libs.android.open.subsonic.api)
}
```

## Repositories

这个库的核心是 `Repository`，每个 `Repository` 负责与 Open-Subsonic API 的不同部分进行交互。

- **`BookmarksRepository`**: 管理书签和播放队列。
- **`BrowsingRepository`**: 浏览音乐库，包括艺术家、专辑、歌曲和流派。
- **`ChatRepository`**: 管理聊天消息。
- **`InternetRadioRepository`**: 管理网络广播电台。
- **`JukeboxRepository`**: 控制服务器端的音乐播放 (Jukebox)。
- **`ListsRepository`**: 获取各种列表，例如专辑列表、正在播放列表和随机歌曲。
- **`MediaAnnotationRepository`**: 管理媒体注解，例如评级、收藏 (加星) 和播放记录 (scrobbling)。
- **`MediaLibraryScanningRepository`**: 控制媒体库的扫描。
- **`MediaRetrievalRepository`**: 检索媒体文件、封面、歌词等。
- **`PlaylistsRepository`**: 管理播放列表。
- **`PodcastRepository`**: 管理播客频道和单集。
- **`SearchingRepository`**: 提供搜索功能。
- **`SharingRepository`**: 管理媒体文件的分享。
- **`SystemRepository`**: 处理系统级操作，例如 ping 服务器和获取许可证信息。
- **`TranscodingRepository`**: 管理媒体转码。
- **`UserManagementRepository`**: 管理用户帐户。

## 参考

- [OpenSubsonic API Documentation](https://opensubsonic.netlify.app/docs/opensubsonic-api/)
