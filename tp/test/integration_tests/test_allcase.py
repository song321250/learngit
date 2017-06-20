import unittest
from comm import html


if __name__ == '__main__':
    discover = unittest.defaultTestLoader.discover('tests', pattern='test_*.py')
    runner = html.HTMLTestRunner(output='html', report_title=u'[接口测试分析平台]自动化测试报告')
    runner.run(discover)