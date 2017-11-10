package xgsHt;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MS {
	WebDriver driver = new ChromeDriver();
	Date date = new Date();
	String time = (date.getMonth()+1)+"/"+date.getDate()+" "+date.getHours()+" "+date.getSeconds();
	
	String mp3 = "http://resources.newgs.net/mp3/2017/09/04/20/1504529490107.m4a?OSSAccessKeyId=0qzfiBreffBeNSjN&Expires=1819889520&Signature=OF7lHNXsPh%2BcJQBP%2BB3SN6%2B3mH8%3D";
	String mp4 = "http://media.newgs.net/Act-ss-mp4-sd/a46cbafbd7e14c43aac94207787e5e80/2_XDCAM%5B2%5D.mp4";
	String file = "http://sltktest.newgs.net/apk/test.docx";
	String img = "http://mediatransioutput.oss-cn-shenzhen.aliyuncs.com/Act-Snapshot/a46cbafbd7e14c43aac94207787e5e80/1000.jpg";
	
	@Before
	public void begin() throws Exception{
		driver.get("http://examtest.newgs.net/index.php/Admin/Login/index");
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("ksadmin");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("ksadmin123");
		driver.findElement(By.xpath(".//*[@id='vcode']")).sendKeys("123");
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		Thread.sleep(3000);
		 
	}
	@After
	public void after(){
		driver.close();
	}
	@org.junit.Test
	public void Test() throws Exception{
		for (int i = 0; i < 2; i++) {
			mstm();
		}
	}
	
	
	/**
	 * 用例
	 */
	
	
	
	/**
	 * 新增面试题目
	 * @throws Exception
	 */
	public void mstm() throws Exception{
		driver.get("http://examtest.newgs.net/index.php/Admin/Interview/subjectList");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div[1]/div/div/div[2]/div[1]/div/a")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[2]/div/div/ul")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[2]/div/div/div/ul/li[5]")).click();
		driver.findElement(By.xpath(".//*[@id='exam_time']")).sendKeys("2017-09-07 00:00");
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[4]/div/div/ul")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[4]/div/div/div/ul/li[2]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/form/div[5]/div/div/div[2]/iframe")));
		driver.findElement(By.xpath("/html/body")).sendKeys("考情考务 内容");
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath(".//*[@id='province_chosen']/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='province_chosen']/div/ul/li[4]")).click();
		
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[8]/div/a")).click();
		}
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[7]/div/div/div/div[1]/div/div")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[7]/div/div/div/div[1]/div/div/div/ul/li[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[7]/div/div[2]/div/div[1]/div/div")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[7]/div/div[2]/div/div[1]/div/div/div/ul/li[4]")).click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[9]/div/input")).sendKeys("这里是面试题目标题"+time);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[10]/div/input")).sendKeys("这里是面试题目内容");
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[11]/div/input")).sendKeys(mp3);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[14]/div/a")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/form/div[13]/div/div/div[2]/div[1]/div/div[2]/iframe")));
		driver.findElement(By.xpath("/html/body")).sendKeys("材料的内容");
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/form/div[13]/div/div/div[3]/div[1]/div/input")).sendKeys("1");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[16]/div/a")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[15]/div/div/div[1]/div/div/input")).sendKeys("语音的标题内容");
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[15]/div/div/div[2]/div/div[1]/input")).sendKeys(mp3);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[15]/div/div/div[3]/div[1]/div/input")).sendKeys("2");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[18]/div/a")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[17]/div/div/div[1]/div/div/input")).sendKeys("视频的标题内容");
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[17]/div/div/div[2]/div/div[1]/input")).sendKeys(mp4);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[17]/div/div/div[3]/div[1]/div/input")).sendKeys("3");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[20]/div/a")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[19]/div/div/div[1]/div/div/input")).sendKeys("文件的标题内容");
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[19]/div/div/div[2]/div/div[1]/input")).sendKeys(file);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[19]/div/div/div[3]/div[1]/div/input")).sendKeys("4");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[22]/div/a")).click();
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[21]/div/div/div[1]/div/div/input")).sendKeys("图片的标题内容");
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[21]/div/div/div[2]/div/div[1]/input")).sendKeys(img);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[21]/div/div/div[3]/div[1]/div/input")).sendKeys("5");
		
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[26]/div/a")).click();
		}
		Thread.sleep(1000);
		Select s1 = new Select(driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div/div[1]/div/div/select")));
		s1.selectByIndex(0);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div/div[2]/div[1]/div/input")).sendKeys("1");
	
		Select s2 = new Select(driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div[2]/div[1]/div/div/select")));
		s2.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div[2]/div[2]/div[1]/div/input")).sendKeys("2");
		
		Select s3 = new Select(driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div[3]/div[1]/div/div/select")));
		s3.selectByIndex(2);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div[3]/div[2]/div[1]/div/input")).sendKeys("3");
		
		Select s4 = new Select(driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div[4]/div[1]/div/div/select")));
		s4.selectByIndex(3);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div[4]/div[2]/div[1]/div/input")).sendKeys("4");
		
		Select s5 = new Select(driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div[5]/div[1]/div/div/select")));
		s5.selectByIndex(4);
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[25]/div/div[5]/div[2]/div[1]/div/input")).sendKeys("5");
	
		driver.findElement(By.xpath(".//*[@id='bodymain']/div/div/div/div/div[2]/form/div[29]/div/button")).click();
		Thread.sleep(3000);
	}
}
