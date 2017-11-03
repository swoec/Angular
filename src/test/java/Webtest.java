package test.java;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import main.java.com.angular.util.PageUtils;

public class Webtest {

	@Test
	public void test() throws InterruptedException {
		//1、开启个浏览器并且输入链接
        WebDriver driver = PageUtils.getChromeDriver("https://www.baidu.com/");

        //2、向百度输入框输入需要查询的值
        PageUtils.inputStrByJS(driver, "kw", "月之暗面 博客园");

        
        //3、得到百度一下的标签
        WebElement submitElement = driver.findElement(By.cssSelector("input#su"));

        //4、点击百度一下
        PageUtils.scrollToElementAndClick(submitElement, driver);

        //休息3秒，加载数据
        Thread.sleep(3000);

        //5、首先找到 id 为 content_left 的 div 下面的所有 div
        List<WebElement> divElements = driver.findElements(By.cssSelector("div#content_left div"));
        //6、找到搜索的第一个链接
        WebElement aElement = divElements.get(0).findElement(By.cssSelector("div.f13 a[href]"));

        //7、点击该链接
        PageUtils.scrollToElementAndClick(aElement, driver);
	}

}
