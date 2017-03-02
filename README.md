# ThatFont
Being a lazy developer always making and searching new fonts, I thought why not make a library with cool fonts and use it whenever I am working on a new Android project.

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```
dependencies {

		compile 'com.github.divyanshunegi:thatdroidfont:v1.2'
		
	}
	
```
  
  To use this file in your Android layout simply add these views
  
  #OpelFont
  
  ```
      <com.divyanshu.thatfont.OpelFont
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textStyle="normal"      <!--this could be normal,bold or italic-->
        android:layout_margin="20dp"
        android:text="Hello World!" />
  ```
  
  You can set textStyle to normal,bold or italic depending on the availability of font inside the library it will diplay the font. 
  in case you do not define any textstyle it will be normal by default
