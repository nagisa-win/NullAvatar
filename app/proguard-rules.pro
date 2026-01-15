-keep class me.hd.nullavatar.hook.HookEntry

-keep class java.lang.reflect.** { *; }
-keep class java.lang.annotation.** { *; }

-dontwarn java.lang.reflect.**

-keep class com.highcapable.kavaref.** { *; }
-keep interface com.highcapable.kavaref.** { *; }
-keep enum com.highcapable.kavaref.** { *; }
-keep @com.highcapable.kavaref.** class * { *; }

-dontpreverify
-keepattributes SourceFile,LineNumberTable,InnerClasses,EnclosingMethod,Signature

-obfuscationdictionary obf-dict.txt
-classobfuscationdictionary obf-dict.txt
-packageobfuscationdictionary obf-dict.txt

-allowaccessmodification
-overloadaggressively
-repackageclasses 'me.hd.wauxv.obf'
