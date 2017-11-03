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
		//1�������������������������
        WebDriver driver = PageUtils.getChromeDriver("https://www.baidu.com/");

        //2����ٶ������������Ҫ��ѯ��ֵ
        PageUtils.inputStrByJS(driver, "kw", "��֮���� ����԰");

        
        //3���õ��ٶ�һ�µı�ǩ
        WebElement submitElement = driver.findElement(By.cssSelector("input#su"));

        //4������ٶ�һ��
        PageUtils.scrollToElementAndClick(submitElement, driver);

        //��Ϣ3�룬��������
        Thread.sleep(3000);

        //5�������ҵ� id Ϊ content_left �� div ��������� div
        List<WebElement> divElements = driver.findElements(By.cssSelector("div#content_left div"));
        //6���ҵ������ĵ�һ������
        WebElement aElement = divElements.get(0).findElement(By.cssSelector("div.f13 a[href]"));

        //7�����������
        PageUtils.scrollToElementAndClick(aElement, driver);
	}

}
