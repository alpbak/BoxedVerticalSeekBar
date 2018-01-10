# Boxed Vertical SeekBar
This is a vertical seekbar like in the IOS 11 control center with an image at the bottom


# ScreenShot
<img src="https://raw.githubusercontent.com/alpbak/BoxedVerticalSeekBar/master/images/device-2017-10-01-184523.gif" width="350"/>

# Installation:
Add these to your app's build.gradle
<pre>
<code>
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
</code>
</pre>

<pre>
<code>
	dependencies {
	        compile 'com.github.alpbak:BoxedVerticalSeekBar:1b377fd8db'
	}


</code>
</pre>

# Usage

To create a new boxed vertical seekbar

```xml
    <abak.tr.com.boxedverticalseekbar.BoxedVertical
        android:id="@+id/boxed_vertical"
        android:layout_width="60dp"
        android:layout_height="250dp"
        android:layout_gravity="center"
        android:layout_marginBottom="30dp"
        android:layout_marginTop="30dp"
        android:layout_weight="1"
        app:backgroundColor="@color/color_background"
        app:progressColor="@color/color_progress"
        app:textColor="#FF0000"
        app:cornerRadius="20"
        app:defaultValue="140"
        app:imageEnabled="false"
        app:textEnabled="true"
        app:max="300"
        app:step="5"
        app:textBottomPadding="20"
        app:textSize="12sp"
        app:touchDisabled="true" />
```

To use the seekbar in your activity:
```java
        BoxedVertical bv = (BoxedVertical)findViewById(R.id.boxed_vertical);

        bv.setOnBoxedPointsChangeListener(new BoxedVertical.OnValuesChangeListener() {
            @Override
            public void onPointsChanged(BoxedVertical boxedPoints, final int value) {
                System.out.println(value);
            }

            @Override
            public void onStartTrackingTouch(BoxedVertical boxedPoints) {
                Toast.makeText(MainActivity.this, "onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(BoxedVertical boxedPoints) {
                Toast.makeText(MainActivity.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });
```


# Usage Notes

 * You can define images to be displayed at the bottom. If you want to use images you need to define 3 images for default, minimum and maximum values. If all the three images aren't defined image will not be displayed. To define images use:
```xml
  app:imageEnabled="true"
  app:defaultImage="@drawable/ic_volume_down_black_48dp"
  app:maxImage="@drawable/ic_volume_up_black_48dp"
  app:minImage="@drawable/ic_volume_off_black_48dp"
```
* Instead of images you can display the current value as text at the bottom. You can specify the text attributes:
```xml
  app:textEnabled="true"
  app:textBottomPadding="20"
  app:textColor="#FF0000"
  app:textSize="12sp"
```
* If images are enabled the text is automatically disabled
* By default only swipes are enabled which means that in order to move the slider you need to swipe up or down. Single touches are ignored. If you want to allow single touches:
```xml
  app:touchDisabled="false"
```

# License
The library is a free software, you can use it, extended with no requirement to open source your changes. You can also make paid apps using it.

Pull requests are welcomed
