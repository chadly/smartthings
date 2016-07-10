# SmartThings Camera LED Controller

Toggle your FOSCAM night vision LEDs on/off in response to a specific light turning on/off.

I wrote this app to solve problems with my FOSCAMs not detecting when they should be using night vision correctly. When the camera was in LED Auto mode, my front door cam would always be in night vision mode even if the front porch light was on. This app now tells the camera when it should be in night mode because it knows when the light is on/off at night.

## SmartThings Installation

This app makes use of [RBoy's FOSCAM device handler](https://community.smartthings.com/t/release-universal-foscam-camera-device-handler-with-live-video-streaming-motion-sensor-alarm-integration/10695) to control the camera LEDs. Make sure you install that first and have your camera setup in SmartThings.

### Option 1: Github integration

The best way to get updates for this app is to enable GitHub integration and add this repository.

1. Open the IDE and navigate to `My SmartApps`
2. Select `Settings`
3. Select `Add new repository`
4. Enter the following details:
	Owner: `chadly`
	Name: `smartthings-camera-led-controller`
	Branch: `master`

Now whenever you need to update to the latest version, you can choose `↓ Update from Repo`, select `smartthings-camera-led-controller` and get your updates.

### Option 2: Manual Install

While using the GitHub integration is the recommended method for installing this app, you can also install it manually (e.g. copy/paste).

Follow the instructions from the [ThingsThatAreSmart.wiki](http://thingsthataresmart.wiki/index.php?title=Using_Custom_Code#Using_a_Custom_SmartApp) on how to install a SmartApp.

* [Camera LED Controller SmartApp Code](https://raw.githubusercontent.com/chadly/smartthings-camera-led-controller/master/smartapps/chadly/camera-led-controller.src/camera-led-controller.groovy)

## How to Use

From the SmartThings mobile app:

1. Select `Marketplace` from the bottom navigation
2. Select the `SmartApps` tab
3. Scoll down and select the `My Apps` category
4. Select the `Camera LED Controller` SmartApp
5. Configure your lights & cameras
6. Tap `Done` to complete the setup
