#!/bin/sh

Chad=Away
Alanna=Away

macaddress="`wl -i eth1 assoclist` `wl -i eth2 assoclist` `wl -i eth3 assoclist`"

case "$macaddress" in
	*XX:XX:XX:XX:XX:XX*)
	Chad=Home
	;;
esac

case "$macaddress" in
	*XX:XX:XX:XX:XX:XX*)
	Alanna=Home
	;;
esac

if [ "$Chad" = Home ]
then
	if [ ! -f /jffs/scripts/users/chad ]
	then
		touch /jffs/scripts/users/chad
		curl -H "Authorization: Bearer <ACCESS_TOKEN>" -X POST "https://<BASE_URL>/api/smartapps/installations/<APP_ID>/home"
	fi
else
	if [ -f /jffs/scripts/users/chad ]
	then
		rm -f /jffs/scripts/users/chad
		curl -H "Authorization: Bearer <ACCESS_TOKEN>" -X POST "https://<BASE_URL>/api/smartapps/installations/<APP_ID>/away"
	fi
fi

if [ "$Alanna" = Home ]
then
	if [ ! -f /jffs/scripts/users/alanna ]
	then
		touch /jffs/scripts/users/alanna
		curl -H "Authorization: Bearer <ACCESS_TOKEN>" -X POST "https://<BASE_URL>/api/smartapps/installations/<APP_ID>/home"
	fi
else
	if [ -f /jffs/scripts/users/alanna ]
	then
		rm -f /jffs/scripts/users/alanna
		curl -H "Authorization: Bearer <ACCESS_TOKEN>" -X POST "https://<BASE_URL>/api/smartapps/installations/<APP_ID>/away"
	fi
fi
