#!/usr/bin/env python
# -*- coding: utf-8 -*-
import unittest
from pages import basedata
from pages.register import registerpage


class TestRegister(unittest.TestCase):

    def setUp(self):
        self.login_page = registerpage.RegisterPage()

    def tearDown(self):
        self.login_page.quit()

    def test_register(self):
        u"""注册功能测试用例"""
        self.login_page.waitTime(1)
        self.login_page.login_register()
        self.login_page.waitTime(1)
        self.login_page.login_register_input(*basedata.regis_input_text)
        self.login_page.login_register_submit()
