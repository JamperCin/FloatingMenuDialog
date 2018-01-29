# FloatingMenuDialog
Get a customized dialog with nice animations looking like IOS dialog to be used as a menu dialog.
**Step 1: Add this to your root build.gradle(Project level) at the end of repositories:**

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  **Step 2: Add the dependency to your dependencies in the build.gradle (Module:App level)**

	dependencies {
	       compile 'com.github.JamperCin:FloatingSwipeActivity:1.0.1'
	}
  
 

**Step 3: Extend it from the Activity you want to apply it on like below... **

**A. When you want to apply both FLOATING and SWIPING gestures to the same activity, you extend FLoatingSwipeActivity**

```
  public class TestActivity extends FloatingSwipeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
    }
}
