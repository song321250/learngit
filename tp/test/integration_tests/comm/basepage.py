#!/usr/bin/env python
# -*- coding: utf-8 -*-
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from comm.config import driverPath


class BasePage(object):
    """
    description of class
    """

    def __init__(self, browser='chrome'):
        if browser == "chrome":
            self.driver = webdriver.Chrome(driverPath())
        else:
            self.driver = webdriver.PhantomJS()


    def findElement(self, *element):
        """
        description of findElement
        
        Usage:
        self.findElement(*element)
        """
        try:
            type = element[0]
            value = element[1]
            if type == "id" or type == "ID" or type == "Id":
                elem = self.driver.find_element_by_id(value)

            elif type == "name" or type == "NAME" or type == "Name":
                elem = self.driver.find_element_by_name(value)

            elif type == "class" or type == "CLASS" or type == "Class":
                elem = self.driver.find_element_by_class_name(value)

            elif type == "link_text" or type == "LINK_TEXT" or type == "Link_text":
                elem = self.driver.find_element_by_link_text(value)

            elif type == "xpath" or type == "XPATH" or type == "Xpath":
                elem = self.driver.find_element_by_xpath(value)

            elif type == "css" or type == "CSS" or type == "Css":
                elem = self.driver.find_element_by_css_selector(value)
            else:
                raise NameError("Please correct the type in function parameter")
        except Exception:
            raise ValueError("No such element found" + str(element))
        return elem

    def findElements(self, *element):
        '''
        Find elements

        element is a set with format (identifier type, value), e.g. ('id','username')

        Usage:
        self.findElements(element)
        '''
        try:
            type = element[0]
            value = element[1]
            if type == "id" or type == "ID" or type == "Id":
                elem = self.driver.find_elements_by_id(value)

            elif type == "name" or type == "NAME" or type == "Name":
                elem = self.driver.find_elements_by_name(value)

            elif type == "class" or type == "CLASS" or type == "Class":
                elem = self.driver.find_elements_by_class_name(value)

            elif type == "link_text" or type == "LINK_TEXT" or type == "Link_text":
                elem = self.driver.find_elements_by_link_text(value)

            elif type == "xpath" or type == "XPATH" or type == "Xpath":
                elem = self.driver.find_elements_by_xpath(value)

            elif type == "css" or type == "CSS" or type == "Css":
                elem = self.driver.find_elements_by_css_selector(value)
            else:
                raise NameError("Please correct the type in function parameter")
        except Exception:
            raise ValueError("No such element found" + str(element))
        return elem

    def open(self, url):
        """
        Open web url
    
        Usage:
        self.open(url)
        """
        if url:
            self.driver.get(url)
        else:
            raise ValueError("please provide a base url")


    def type(self, element, text):
        """
        Operation input box.
    
        Usage:
        self.type(element,text)
        """
        element.send_keys(text)


    def enter(self, element):
        """
        Keyboard: hit return
    
        Usage:
        self.enter(element)
        """
        element.send_keys(Keys.RETURN)

    def click(self, element):
        """
        Click page element, like button, image, link, etc.
        
        Usage:
        self.click(element)
        """
        element.click()

    def clear(self, element):
        """
        Clear page element
        
        Usage:
        self.clear()
        """
        element.clear()

    def quit(self):
        """
        Quit webdriver
        
        Usage:
        self.quit()
        """
        self.driver.quit()

    def getAttribute(self, element, attribute):
        """
        Get element attribute
        
        Usage:
        self.getAttribute(element, attribute)
        """
        return element.get_attribute(attribute)

    def getText(self, element):
        """
        Get text of a web element

        Usage:
        self.getText(element)
        """
        return element.text

    def getTitle(self):
        """
        Get window title
        
        Usage:
        self.getTitle()

        """
        return self.driver.title

    def getCurrentUrl(self):
        """
        Get current url 
        
        Usage:
        self.getCurrentUrl()
        """
        return self.driver.current_url

    def getScreenshot(self, targetpath):
        """
        Get current screenshot and save it to target path
        
        Usage:
        self.getScreenshot(targetpath)
        """
        self.driver.get_screenshot_as_file(targetpath)

    def maximizeWindow(self):
        """
        Maximize current browser window
        
        Usage:
        self.maximizeWindow()
        """
        self.driver.maximize_window()

    def back(self):
        """
        Goes one step backward in the browser history.
        
        Usage:
        self.back()
        """
        self.driver.back()

    def forward(self):
        """
        Goes one step forward in the browser history.
        
        Usage:
        self.forward()
        """
        self.driver.forward()

    def getWindowSize(self):
        """
        Gets the width and height of the current window.
        
        Usage:
        self.getWindowSize()
        """
        return self.driver.get_window_size()

    def refresh(self):
        '''
        Refresh current page
        
        Usage:
        self.refresh()
        '''
        self.driver.refresh()
        self.driver.switch_to()

    def waitElement(self, t=30):
        """
        Default wait for 10s
        
        Usage:
        self.waitElement()
        """
        self.driver.implicitly_wait(t)

    def waitTime(self, t=3):
        """
        Wait for result
        
        Usage:
        self.waitTime()
        """
        time.sleep(t)