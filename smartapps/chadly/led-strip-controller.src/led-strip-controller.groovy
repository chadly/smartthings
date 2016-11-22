/**
 *  LED Strip Light Controller
 *
 *  Copyright 2016 Chad Lee
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *	2016-11-21: Initial Release
 */
definition(
	name: "LED Strip Light Controller",
	namespace: "chadly",
	author: "Chad Lee",
	description: "Tie the control of LED strip lights to other lights.",
	category: "Convenience",
	iconUrl: "http://cdn.device-icons.smartthings.com/Lighting/light11-icn.png",
	iconX2Url: "http://cdn.device-icons.smartthings.com/Lighting/light11-icn@2x.png",
	iconX3Url: "http://cdn.device-icons.smartthings.com/Lighting/light11-icn@3x.png")


preferences {
	section("When this light is toggled") {
		input "light", "capability.switch", required: true
	}
	section("When this dimmer is changed") {
		input "dimmer", "capability.switchLevel", required: true
	}
	section("Turn on & set level of this LED strip") {
		input "led", "capability.switch", required: true
	}
}

def installed() {
	initialize()
}

def updated() {
	unsubscribe()
	initialize()
}

def initialize() {
	subscribe(light, "switch", lightChanged)
	subscribe(dimmer, "switch", dimmerAdjusted)
	subscribe(dimmer, "level", dimmerAdjusted)
}

def lightChanged(evt) {
	adjustLED()
}

def dimmerAdjusted(evt) {
	adjustLED()
}

def adjustLED() {
	if (!adjustColorFromLight()) {
		adjustWhitesFromDimmer()
	}
}

def adjustColorFromLight() {
	def switchState = light.latestValue("switch")

	if (switchState == "on") {
		def colorData = [:]
			colorData = [h: 0,
			s: 0,
			l: 100,
			r: 255,
			g: 255,
			b: 255,
			rh: "ff",
			gh: "ff",
			bh: "ff",
			hex: "#ffffff",
			alpha: 1]

		led.setAdjustedColor(colorData)

		led.setLevel(100)
		led.setWhiteLevel(100)

		return true
	} else {
		led.setLevel(0)
		return false
	}
}

def adjustWhitesFromDimmer() {
	// match the dimmer switch level for whites
	def dimmerState = dimmer.latestValue("switch")

	if (dimmerState == "on") {
		def dimmerLevel = dimmer.latestValue("level")
		led.setWhiteLevel(dimmerLevel.toInteger())
	} else {
		led.setWhiteLevel(0)
	}
}