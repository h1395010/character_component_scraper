# -*- coding: utf-8 -*-

# Scrapy settings for character_component_scraper project
#
# For simplicity, this file contains only the most important settings by
# default. All the other settings are documented here:
#
#     http://doc.scrapy.org/en/latest/topics/settings.html
#

BOT_NAME = 'character_component_scraper'

SPIDER_MODULES = ['character_component_scraper.spiders']
NEWSPIDER_MODULE = 'character_component_scraper.spiders'

ITEM_PIPELINES = {'character_component_scraper.pipelines.CharacterComponentScraperPipeline': 300 }

# Crawl responsibly by identifying yourself (and your website) on the user-agent
#USER_AGENT = 'character_component_scraper (+http://www.yourdomain.com)'
