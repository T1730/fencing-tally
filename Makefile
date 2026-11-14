SDK=~/android_sdk
PLATFORM=$(SDK)/platforms/android-34
BUILD_TOOLS=$(SDK)/build-tools/34.0.0
KEYSTORE=$(SDK)/keystore.jks
NAME=tally


build:
	@echo "create build directories"
	@mkdir -p build/gen build/obj build/apk
	@echo "generate R.java file"
	@$(BUILD_TOOLS)/aapt package -f -m -J build/gen/ -S res \
	-M AndroidManifest.xml \
	-I $(PLATFORM)/android.jar
	@echo "compile java source code"
	@javac --release 11 -classpath $(PLATFORM)/android.jar -d build/obj \
	build/gen/net/$(NAME)/R.java \
	java/net/$(NAME)/MainActivity.java
	@echo "convert .class files to dalvik byte code"
	@$(BUILD_TOOLS)/d8 --release --lib $(PLATFORM)/android.jar \
	--output build/apk/ build/obj/net/$(NAME)/*.class
	@echo "create apk"
	@$(BUILD_TOOLS)/aapt package -f -S res/ \
	-M AndroidManifest.xml \
	-I $(PLATFORM)/android.jar \
	-F build/$(NAME).unsigned.apk build/apk/
	@echo "align apk"
	@$(BUILD_TOOLS)/zipalign -f -p 4 build/$(NAME).unsigned.apk build/$(NAME).aligned.apk
	@echo "sign apk"
	@$(BUILD_TOOLS)/apksigner sign --ks $(KEYSTORE) \
	--ks-key-alias androidkey --ks-pass pass:android \
	--key-pass pass:android --out build/$(NAME).apk \
	build/$(NAME).aligned.apk

	
