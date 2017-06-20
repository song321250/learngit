#!/usr/bin/env python
# -*- coding: utf-8 -*-
from comm import basepage
from pages import basedata


class BaseWebPage(basepage.BasePage):
    baseUrl = 'http://10.10.68.252'
    login_input_els = [('id', 'inputUserName'), ('ID', 'inputPassword')]
    login_submit_els = ('XPATH', "//button[@type='button']")
    login_logout_els = ('LINK_TEXT', '退出')

    def __init__(self, browser='chrome'):
        super().__init__(browser)
        self.open(BaseWebPage.baseUrl)
        self.waitElement()
        self.maximizeWindow()

    def login_input(self, *kw):
        for i in BaseWebPage.login_input_els:
            el = self.findElement(*i)
            self.waitElement()
            self.clear(el)
            self.type(el, kw[BaseWebPage.login_input_els.index(i)])
            self.waitTime()

    def login_submit(self):
        el = self.findElement(*BaseWebPage.login_submit_els)
        self.click(el)

    def login_users_login(self):
        self.login_input(*basedata.login_input_text)
        self.login_submit()

    def login_users_logout(self):
        el = self.findElement(*BaseWebPage.login_logout_els)
        self.click(el)