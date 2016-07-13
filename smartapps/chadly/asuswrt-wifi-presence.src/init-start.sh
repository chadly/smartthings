#!/bin/sh
cru a CheckIfHome "* * * * * /jffs/scripts/check-home"
cru a CheckIfHome15 "* * * * * sleep 15; /jffs/scripts/check-home"
cru a CheckIfHome30 "* * * * * sleep 30; /jffs/scripts/check-home"
cru a CheckIfHome45 "* * * * * sleep 45; /jffs/scripts/check-home"
