# FloatingMenuDialog
Use this light weight android library to Get a customized floating menu dialog with nice animations looking like IOS dialog to be used as a menu dialog in android.

[![](https://www.jitpack.io/v/JamperCin/FloatingMenuDialog.svg)](https://www.jitpack.io/#JamperCin/FloatingMenuDialog)

![alt text](https://github.com/JamperCin/FloatingMenuDialog/blob/master/sample.png)

**Step 1: Add this to your root build.gradle(Project level) at the end of repositories:**

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  **Step 2: Add the dependency to your dependencies in the build.gradle (Module:App level)**

	dependencies {
	      compile 'com.github.JamperCin:FloatingMenuDialog:1.0.1'
	}
  
 

**Step 3: Just call it from the Activity **
```
 new FloatingMenuDialog(TestAppActivity.this)
                .setDialogTitle("Add Picture")
                .setPositveButtonText("From Camera")
                .setNeutralButtonText("From Gallery")
                .setExtraButtonText("From Google Drive")
                .setNegativeButtonText("Close Dialog")
                .setDismissDialogOnMenuOnClick(false)  //Dismiss the dialog anytime a menu item is clicked
                .setDialogCancelable(true)             // Set dialog cancellable
                .setOnPositiveButtonOnClick(new OnMenuItemClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(TestAppActivity.this, "Positive", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnNegativeButtonOnClick(new OnMenuItemClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(TestAppActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnNeutralButtonOnClick(new OnMenuItemClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(TestAppActivity.this, "Neutral", Toast.LENGTH_SHORT).show();

                    }
                })
                .setOnExtraButtonOnClick(new OnMenuItemClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(TestAppActivity.this, "Extra", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
```
