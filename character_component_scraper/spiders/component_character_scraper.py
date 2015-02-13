from scrapy.spider import BaseSpider
from scrapy.selector import HtmlXPathSelector
from scrapy.http import Request
from character_component_scraper.items import CharacterComponentScraperItem
from urlparse import urljoin
from collections import OrderedDict

class DmozSpider(BaseSpider):
    name = "character_component_scraper"
    allowed_domains = ["tool.httpcn.com"]
    start_urls = ['http://tool.httpcn.com/Zi/BuShou.html']

    def parse(self, response):
        for url in response.css('td a::attr(href)').extract():
            cb = self.parse if '/zi/bushou' in url.lower() else self.parse_item
            yield Request(urljoin(response.url, url), callback=cb)   

    def parse_item(self, response):
        hxs = HtmlXPathSelector(response)
        item =  CharacterComponentScraperItem()
        item["amalgamated_info"] = hxs.xpath('//*[@id="div_a1"]/table').extract()
        item["delimiter"] = "#######################"
        item["the_strokes"] = hxs.xpath('//*[@id="div_a1"]/div[2]/text()[2]').extract()
        return item