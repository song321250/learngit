#!/usr/bin/env python
# -*- coding: utf-8 -*-
from pages import basewebpage


class RegisterPage(basewebpage.BaseWebPage):

    register_click_els= ('LINK_TEXT', '立即注册')
    register_input_els = [('id', 'registerName'), ('id', 'registerPwd'), ('name', 'password2'), ('id', 'registerEmail')]
    register_submit_els = ('XPATH', "(//button[@type='submit'])[2]")

    def login_register(self):
        el = self.findElement(*RegisterPage.register_click_els)
        self.click(el)

    def login_register_input(self, *kw):
        for i in RegisterPage.register_input_els:
            el = self.findElement(*i)
            self.waitElement()
            self.clear(el)
            self.type(el, kw[RegisterPage.register_input_els.index(i)])
            self.waitTime()

    def login_register_submit(self):
        el = self.findElement(*RegisterPage.register_submit_els)
        self.click(el)
