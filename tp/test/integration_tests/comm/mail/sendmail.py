#!/usr/bin/env python
# -*- coding: utf-8 -*-

import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart


def smail(report_file, to_list):
    msg = MIMEMultipart('alternative')
    msg['Subject'] = "[有路科技]项目测试报告"
    msg['From'] = "admin/user@youlu"
    msg['To'] = ",".join(to_list)
    for files in report_file:
        with open(files, 'rb') as f:
            att = MIMEText(f.read(), 'base64', 'utf-8')
            att["Content-Type"] = 'application/octet-stream'
            att.add_header('content-disposition', 'attachment', filename=files)
            msg.attach(att)
        with open(files, encoding="utf-8") as f:
            content = MIMEText(f.read(), 'html', 'utf-8')
            msg.attach(content)

    s = smtplib.SMTP('10.10.0.6')
    s.send_message(msg)
    s.quit()


if __name__ == '__main__':
    file_new = ["Test_TestStringMethods_2017-05-05_16-17.html", "Test_test_demo.Test_Demo_2017-04-26_15-05.html"]
    to_list = ["zouyu/user@youlu", "zhoulin/user@youlu", "lulanfang/user@youlu"]
    smail(file_new, to_list)
