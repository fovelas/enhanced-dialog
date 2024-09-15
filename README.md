### Prerequisites

Add this maven line to root `settings.gradle`

~~~
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
~~~

-----------------------------------------

### Dependency

Lastly add this line to `build.gradle` file in app module.

~~~
dependencies {
    implementation 'com.github.fovelas:enhanced-dialog:1.0.0'
}
~~~

-----------------------------------------

### Create Custom Dialog

```java
public final class ExampleDialog extends EnhancedDialog
{
    public ExampleDialog(@NonNull Context context)
    {
        super(context);
    }

    public void show()
    {
        // your dialog logic start

        DialogExampleBinding binding = DialogExampleBinding.inflate(getInflater());

        binding.exampleDialogBtnClose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss(); // dismiss dialog
            }
        });

        // your dialog logic end

        show(binding.getRoot()); // call super class show() function with view
    }
}
```

-----------------------------------------

### Show Dialog

```java
ExampleDialog exampleDialog = new ExampleDialog(MainActivity.this);
exampleDialog.show();
```

-----------------------------------------

### themes.xml

```xml
<style name="Theme.EnhancedDialog" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
    <item name="colorPrimary">@color/white</item>
    ...
    ...
    ...

    <item name="android:dialogTheme">@style/EnhancedDialog</item>
    <item name="android:windowBackground">@color/black</item>
    <item name="android:windowAnimationStyle">@null</item>
</style>
```