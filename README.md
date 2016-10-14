<img  src="https://raw.githubusercontent.com/meeting-room-reservation-group/meeting-room-reservation-group.github.io/master/images/meeting_room_logo.ico" width="64" />
[![Build Status](https://travis-ci.org/dave-clean-coder/meeting-room-reservation-services.svg?branch=master)](https://travis-ci.org/dave-clean-coder/meeting-room-reservation-services)
[![codecov](https://codecov.io/gh/meeting-room-reservation-group/meeting-room-reservation-services/branch/master/graph/badge.svg)](https://codecov.io/gh/meeting-room-reservation-group/meeting-room-reservation-services)

[![slack](https://raw.githubusercontent.com/meeting-room-reservation-group/meeting-room-reservation-group.github.io/master/images/slack_cmyk-112x32.png)](https://mrrs.slack.com)


# Meeting Room Reservation Services

__INFO__ This project is based on the [Meeting Room Reservation System - Blog](http://meeting-room-reservation-group.github.io/)


# Development

## Running on Jetty

	http://localhost:8080/

	http://localhost:8080/api/v1.0/users
	http://localhost:8080/api/v1.0/users/query?name=Tintin
	http://localhost:8080/api/v1.0/users/query?name=captain%20haddock


## Launch WireMock for Recording

[WireMock Record](http://wiremock.org/docs/record-playback/)

	java  -jar wiremock-2.1.12-standalone.jar  --proxy-all="http://localhost:8080"  --record-mappings  --verbose

