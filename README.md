# Gradient View Pager

GradientViewPager allows you to create view pagers with gradients as a background to each individual fragment, and the gradients transition between themselves as you scroll between pages.

Below is a demo GIF to understand this better. Ofcourse, since it's a GIF, it's laggy. The actual output is extremely smooth.

![alt text](/gif/demo_gif.gif)

<h3>Sample App</h3>

Download the Demo app on Google Play Store:

<a href='https://play.google.com/store/apps/details?id=com.rachitgoyal.gradientviewpagersample'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="160" height="65"></a>

<h2>Installation</h2>

<h3>Gradle</h3>

Add JitPack in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
        ...
		maven { url 'https://jitpack.io' }
    }
}
```

Add it as a dependency in your app's build.gradle file
```
dependencies {
    implementation 'com.github.rayzone107:Gradient-View-Pager:1.0'
}
```

<h2>How to use</h2>

<b>Add a GradientViewPager to your XML layout</b>

Below are the default values for all the properties
```xml
    <com.rachitgoyal.gradientviewpager.GradientViewPager
        android:id="@+id/view_pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior" />
```

This will behave exactly like a ViewPager, and you can use it like any other ViewPager to attach Tabs, or any listeners to it as required.


To give a background gradient to each fragment, create a list of PageColour objects.
Each object needs to properties - colorTop and colorBottom. An additional optional parameter is colorMiddle. If you don't set colorMiddle, a 2 step gradient will be created. With a colorMiddle defined, it will be a three step gradient.
Do note the sequence of parameters - it's <b>colorTop, colorBottom and colorMiddle</b>, not colorTop, colorMiddle, colorBottom.

```kotlin

        val colorArray = mutableListOf<PageColor>()
        colorArray.add(
            PageColor(
                R.color.screen_1_top,
                R.color.screen_1_bottom,
                R.color.screen_1_middle     // Optional Parameter
            )
        )
        colorArray.add(
            PageColor(
                R.color.screen_2_top,
                R.color.screen_2_bottom,
                R.color.screen_2_middle     // Optional Parameter
            )
        )
        colorArray.add(
            PageColor(
                R.color.screen_3_top,
                R.color.screen_3_bottom,
                R.color.screen_3_middle     // Optional Parameter
            )
        )
        viewPager.colorArray = colorArray

```

Programatically you can change the value of any of the items in this list, and update the colorArray to make it reflect on the UI.

<h2>Contribution</h2>

Any kind of contribution will be appreciated; feel free to create a pull request or file issues on the issue tracker.
