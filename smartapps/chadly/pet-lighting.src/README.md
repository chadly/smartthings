# SmartThings Pet Lighting

Turn on specific lights and set their level when in _Away_ mode at night. This same functionality can be accomplished with multple smart light app instances, however it is a pain in the ass to setup. You also have to watch out for conflicts between a _Goodbye_ routine which turns everything off and then you smart light app turning specific pet lights on. 

This app will wait a couple of minutes after the mode changes to _Away_ at night to turn on the pet lighting to give any _Goodbye_ routine a chance to finish. It will also turn on the pet lighting if sunset happens during _Away_ and turn it off at sunrise if _Away_.

## Installation

See the [installation instructions](../../../README.md#installation).

## How to Use

From the SmartThings mobile app:

1. Select `Marketplace` from the bottom navigation
2. Select the `SmartApps` tab
3. Scoll down and select the `My Apps` category
4. Select the `LED Strip Light Controller` SmartApp
5. Configure your lights
6. Tap `Done` to complete the setup
