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
	log.debug "Installed with settings: ${settings}"
	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"
	unsubscribe()
	initialize()
}

def initialize() {
	subscribe(light, "switch.on", lightOn)
	subscribe(light, "switch.off", lightOff)
	subscribe(dimmer, "switch.setLevel", dimmerAdjusted)
}

def lightOn(evt) {
	log.info "$evt.displayName was turned on, turning off camera LED"

	led.setWhiteLevel(100)

	def colorRGB = colorNameToRgb(colorName)
	def colorHex = rgbToHex(colorRGB)
	def colorHSL = rgbToHSL(colorRGB)

	def colorData = [:]
		colorData = [h: 0,
		s: 0,
		l: 100,
		r: 255,
		g: 255,
		b: 255,
		rh: hex(255),
		gh: hex(255),
		bh: hex(255),
		hex: "#ffffff",
		alpha: 1]

	led.setAdjustedColor(colorData)
}

def lightOff(evt) {
	log.debug "the light is off: $evt"
	led.setLevel(0)
}

def dimmerAdjusted(evt) {
	if ((evt.value == "on") || (evt.value == "off" ))
		return

	def level = evt.value.toFloat()
	level = level.toInteger()
	log.info "master switch adjusted to level: ${level}"

	led.setWhiteLevel(level)
}