#!/usr/bin/env python
# -*- coding: utf-8 -*-
import platform
import os
from os.path import dirname, abspath

def driverPath():
    if platform.system() == 'Windows':
        return os.path.join(dirname(dirname(abspath(__file__))), 'tools\win\chromedriver.exe')

    elif platform.system() == "Linux":
        return os.path.join(dirname(dirname(abspath(__file__))), 'tools/linux/chromedriver')

    else:
        return os.path.join(dirname(dirname(abspath(__file__))), 'tools/macos/chromedriver')