# SmartThings Camera LED Controller

Toggle your FOSCAM night vision LEDs on/off in response to a specific light turning on/off.

I wrote this app to solve problems with my FOSCAMs not detecting when they should be using night vision correctly. When the camera was in LED Auto mode, my front door cam would always be in night vision mode even if the front porch light was on. This app now tells the camera when it should be in night mode because it knows when the light is on/off at night.

## Installation

This app makes use of [RBoy's FOSCAM device handler](https://community.smartthings.com/t/release-universal-foscam-camera-device-handler-with-live-video-streaming-motion-sensor-alarm-integration/10695) to control the camera LEDs. Make sure you install that first and have your camera setup in SmartThings.

See the [installation instructions](../../../README.md#installation).

## How to Use

From the SmartThings mobile app:

1. Select `Marketplace` from the bottom navigation
2. Select the `SmartApps` tab
3. Scoll down and select the `My Apps` category
4. Select the `Camera LED Controller` SmartApp
5. Configure your lights & cameras
6. Tap `Done` to complete the setup
