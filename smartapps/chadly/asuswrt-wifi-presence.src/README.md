# AsusWRT Wifi Presence

Use your ASUS router to determine presence by who is currently connected to the WIFI. Based off of work by [@fuzzysb](https://github.com/fuzzysb). See [the original discussion](https://community.smartthings.com/t/release-asuswrt-wifi-presence/37802).

The original code was not working for me with my [RT-AC3200 router](https://www.asus.com/us/Networking/RTAC3200/). [With help](https://community.smartthings.com/t/release-asuswrt-wifi-presence/37802/33) from [@jurney](https://github.com/jurney), I changed the code to not use `qcsapi_sockrpc`.

## New Features

For some reason, during the night, the router would periodically detect that my android phone was disconnected from the WIFI, but then less than a minute later, determine it was connected again. This would mark me as _away_ and then immediately _present_ again in SmartThings causing all kinds of havoc.

The app now takes a `timeout` so that once the router says you are away, the app will wait that amount of time before actually marking the presence sensor as _away_. If the app receives a _present_ notification within the timeout window, it will never mark you as _away_.

## Installation

Follow [the original instructions here](https://community.smartthings.com/t/release-asuswrt-wifi-presence/37802), but use the code from this repository [using these instructions](../../../README.md#installation).
