package xgsHt;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Mytool.Mytool;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.*;

public class Htai {
//	WebDriver driver = new ChromeDriver();
	WebDriver driver = new FirefoxDriver();
//	"firefox","chrome"
	String browse = "firefox";
	
	Date date = new Date();
	Random random = new Random();
	Mytool tool = new Mytool();
	@SuppressWarnings("deprecation")

	 String[] mobile = {"17769990000"
			 ,"17769990001"
			 ,"17769990002"
			 ,"17769990003"
			 ,"17769990004"
			 ,"17769990005"
			 ,"17769990006"
			 ,"17769990007"
			 ,"17769990008"
			 ,"17769990009"
			 ,"17769990010"};//学员手机号码

	String userpass = "测试";// 学员姓名
	String[] phones = {"13457718147"};// 公客手机号码
	String bq = "校门交通拥堵";// 试卷标签
	String path = "C:\\Users\\陆石勤\\Desktop\\";// 文件路径

	@Before
	public void before() throws Exception {
		driver.manage().window().maximize();
	}

	@After
	public void after() {
		driver.close();
	}

	@Test
	public void Test() throws Exception {
		
		int num = mobile.length-1;// 添加的套餐数量
		
		// 后台系统添加套餐订单
		htlogin();
		for (int i = 0; i < num; i++) {
			String time = (date.getMonth() + 1) + "/" + date.getDate() + "" + date.getHours() + ":" + date.getMinutes()
					+ ":" + date.getSeconds();
//			String name = "测试批改流程--" + bq + time + " ";
			String[] name = {"	混合-V50","测试模考更改"};
			// 套餐
//			Tcan(name, bq);
			// 订单 ：1申论，2综合应用能力

			Ddan(1, name, mobile);
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		
		
		// 学员中心提交答案
		int n = 1;
		for (int i = 0; i < mobile.length; i++) {
			xylogin(mobile[i], userpass);
			taoC(path,browse);
			Thread.sleep(2000);
			n++;
		}
		 
		int ran = num * mobile.length * 2;

		// 任务分配
//		 htlogin();
//		 fenpRw(ran,phones);
		//
		// 公客中心
		// gookerLogin(phones);
		// TackList(1*2*6);
		//
		// htlogin();
		// shenh(10*5);
	}

	/**
	 * 后台登陆
	 * 
	 * @throws Exception
	 */
	public void htlogin() throws Exception {
		driver.get("http://examtest.newgs.net/index.php/Admin/Login/index");
		Thread.sleep(1000);
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("ksadmin");
		WebElement userpass = driver.findElement(By.id("password"));
		userpass.clear();
		userpass.sendKeys("ksadmin123");
		WebElement vcode = driver.findElement(By.id("vcode"));
		vcode.sendKeys("123");
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
		Thread.sleep(2000);
	}

	/**
	 * 套餐
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	private void Tcan(String name, String bq) throws Exception {
		WebElement meun = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a"));
		meun.click();
		Thread.sleep(200);
		WebElement tcan = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/ul/li[2]/a"));
		tcan.click();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		WebElement addTc = driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[1]/div[1]/a"));
		addTc.click();
		WebElement tcName = driver.findElement(By.name("name"));
		tcName.sendKeys(name + "套餐");
		WebElement tcMain = driver.findElement(By.name("desc"));
		tcMain.sendKeys(name + ":" + date.getMinutes());
		WebElement closeTime = driver.findElement(By.id("close_time"));
		closeTime.sendKeys("2017-" + (date.getMonth() + 1) + "-" + (date.getDate() + 1) + " 00:00:00");
		int j = 1;
		for (int i = 0; i < 2; i++) {
			WebElement addOption = driver.findElement(By.linkText("新增试卷"));
			addOption.click();
			Thread.sleep(1000);
			WebElement sj = driver.findElement(By.xpath("//*[@id='signupForm']/div[7]/div/div[" + j + "]"));
			WebElement option = sj.findElement(By.xpath("./div[2]/div[1]/div/div"));
			option.click();
			WebElement optionName = sj.findElement(By.xpath("./div[2]/div[1]/div/div/div/div/input"));
			optionName.sendKeys(bq);
			Thread.sleep(300);
			WebElement optionSelect = sj.findElement(By.xpath("./div[2]/div[1]/div/div/div/ul/li"));
			optionSelect.click();

			Select pglx = new Select(sj.findElement(By.xpath("./div[1]/div[2]/div/select")));
			pglx.selectByIndex(i);
			Select ftfs = new Select(sj.findElement(By.xpath("./div[1]/div[3]/div/select")));
			ftfs.selectByIndex(i);

			WebElement optionSort = sj.findElement(By.xpath("./div[2]/div[2]/div/input"));
			optionSort.sendKeys("" + j + "");
			j++;
		}
		WebElement addVideo = driver.findElement(By.linkText("新增视频"));
		addVideo.click();
		WebElement videoSort = driver.findElement(By.name("video_sort[]"));
		videoSort.sendKeys("3");
		WebElement submit = driver.findElement(By.xpath("//*[@id='signupForm']/div[19]/div/button"));
		submit.click();
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		WebElement closeframe = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/nav/div/a[2]/i"));
		closeframe.click();
		WebElement meun1 = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a"));
		meun1.click();
		Thread.sleep(1000);
	}

	/**
	 * @param i
	 * @throws Exception
	 *             订单
	 */
	private void Ddan(int i, String[] name, String[] mobile) throws Exception {
		WebElement meun = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a"));
		meun.click();
		Thread.sleep(1000);
		WebElement Ddan = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/ul/li[7]/a"));
		Ddan.click();
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		for (int j = 0; j < mobile.length; j++) {
			WebElement addDdan = driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[1]/div/a[1]"));
			addDdan.click();
			WebElement phone = driver.findElement(By.name("phone"));
			phone.sendKeys(mobile[j]);
			WebElement shop = driver.findElement(By.xpath("//*[@id='signupForm']/div[2]/div/div"));
			shop.click();
			WebElement shopname = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/form/div[2]/div/div/div/div/input"));
			shopname.sendKeys(name[random.nextInt(2)]);
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/form/div[2]/div/div/div/ul/li[1]")).click();
			Select code = new Select(driver.findElement(By.name("msg_tpl")));
			code.selectByValue("0");
			WebElement orderNum = driver.findElement(By.name("order_id"));
			orderNum.sendKeys(name[random.nextInt(2)] + "订单号");
			WebElement submit = driver.findElement(By.xpath("//*[@id='signupForm']/div[6]/div/button"));
			submit.click();
			Thread.sleep(3000);
		}
		driver.switchTo().parentFrame();
		WebElement closeframe = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/nav/div/a[2]/i"));
		closeframe.click();
		WebElement meun1 = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a"));
		meun1.click();
	}

	/**
	 * @param num
	 * @param phones2
	 * @throws Exception
	 *             手动派单
	 */
	private void fenpRw(int num, String[] phones) throws Exception {
		WebElement shenHe1 = driver.findElement(By.xpath("//*[@id='side-menu']/li[3]"));
		shenHe1.click();
		Thread.sleep(1000);
		WebElement zjRw = driver.findElement(By.xpath("//*[@id='side-menu']/li[3]/ul/li[7]"));
		zjRw.click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		int m = 0;
		for (int i = 0; i < num; i++) {
			if (i == 20) {
				m++;
				driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[2]/div/div/a[" + m + "]"))
						.click();
				Thread.sleep(2000);
				i = 0;
			} else {
			}
			String gooerphone = phones[random.nextInt(phones.length)];
			
			List<WebElement> Rw = driver
					.findElements(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[3]/table/tbody/tr"));
			WebElement rwXq = Rw.get(i).findElement(By.xpath("./td[9]/a"));
			rwXq.click();
			Thread.sleep(200);
			WebElement ueid = driver
					.findElement(By.xpath("//*[@id='bodymain']/div/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]"));
			String ue_id = ueid.getText();

			List<WebElement> tmList = driver
					.findElements(By.xpath("//*[@id='bodymain']/div/div[2]/div/div/div[2]/table/tbody/tr"));
			for (int j = 0; j < tmList.size(); j++) {
				List<WebElement> tm = driver
						.findElements(By.xpath("//*[@id='bodymain']/div/div[2]/div/div/div[2]/table/tbody/tr"));
				System.out.println(tm.get(j).findElement(By.xpath("./td[2]")).getText());
				if (tm.get(j).findElement(By.xpath("./td[2]")).getText().contains("未提交答案")) {
					System.out.println("学员未交卷");
				} else {
					WebElement cktm = tm.get(j).findElement(By.xpath("./td[3]/a"));
					cktm.click();
					Thread.sleep(1000);

					WebElement ecid = driver.findElement(
							By.xpath("//*[@id='bodymain']/div/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]"));
					String ec_id = ecid.getText();
					WebElement status = driver.findElement(
							By.xpath("//*[@id='bodymain']/div/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]"));
					String pgstatus = status.getText();
					System.out.println("ue_id = " + ue_id + " ec_id = " + ec_id + " " + pgstatus);

					try {
						WebElement gooker_phone = driver.findElement(By.className("gooker_phone"));
						gooker_phone.sendKeys(gooerphone);
						WebElement give_gooker = driver.findElement(By.className("give_gooker"));
						give_gooker.click();
						Thread.sleep(500);
					} catch (Exception e) {
						System.out.print("任务已分配");
					}
					Thread.sleep(2000);
					WebElement back2 = driver
							.findElement(By.xpath("//*[@id='bodymain']/div/div[1]/div[1]/div/div/button"));
					back2.click();
					Thread.sleep(1000);

				}
			}
			WebElement back1 = driver.findElement(By.xpath("//*[@id='bodymain']/div/div[1]/div[1]/div/button"));
			back1.click();
			Thread.sleep(200);

		}
		driver.switchTo().parentFrame();
		WebElement closeframe = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/nav/div/a[2]/i"));
		closeframe.click();
		WebElement shenHe2 = driver.findElement(By.xpath("//*[@id='side-menu']/li[3]"));
		shenHe2.click();
	}

	/**
	 * 学员登陆
	 * 
	 * @throws Exception
	 */
	public void xylogin(String phone, String name) throws Exception {
		driver.get("http://examtest.newgs.net/index.php/Ewap/StudIndex/login");
		WebElement username = driver.findElement(By.xpath("//*[@id='login']/div[1]/div[2]/input"));
		WebElement userpass = driver.findElement(By.xpath("//*[@id='login']/div[2]/div[2]/input"));
		username.clear();
		userpass.clear();
		username.sendKeys(phone);
		userpass.sendKeys(name);
		Thread.sleep(100);
		WebElement submit = driver.findElement(By.xpath("//*[@id='login']/div[3]/button"));
		submit.click();
		Thread.sleep(3000);
	}

	private void taoC(String path,String browse) throws Exception {
		Thread.sleep(200);
		List<WebElement> taocNum = driver.findElements(By.xpath("//*[@id='order_list']/div/div[2]/a"));
		int taoNum = taocNum.size();
		for (int i = 0; i < taoNum; i++) {
			List<WebElement> taoClist = driver.findElements(By.xpath("//*[@id='order_list']/div/div[2]/a"));
			System.out.println("套餐:" + taoClist.get(i).findElement(By.xpath("./div/h4")).getText());
			taoClist.get(i).click();
			Thread.sleep(1000);
			List<WebElement> sj1 = driver.findElements(By.className("o_list"));
			for (int j = 0; j < sj1.size(); j++) {
				List<WebElement> sj2 = driver.findElements(By.className("o_list"));
				System.out.println("试卷" + j);
				List<WebElement> button = sj2.get(j).findElements(By.xpath("./div[2]/a"));
				for (int k = 0; k < button.size(); k++) {
					String buttonname = button.get(k).getText();
					switch (buttonname) {
					case "提交答卷":
						button.get(k).click();
						try {
							imginput(path,browse);
						} catch (Exception e) {
							System.out.println("套餐过期");
							Thread.sleep(5000);
						}
						break;
					case "评价":
						button.get(k).click();
						Thread.sleep(1000);
						try {
							driver.findElement(By.xpath("//*[@id='evaluation']/div[1]/div/a[5]/span")).click();
							driver.findElement(By.xpath("//*[@id='add_judge_form']/div/textarea")).sendKeys("这里是评价内容");
							driver.findElement(By.id("do_post_judge")).click();
							Thread.sleep(3000);
						} catch (Exception e) {
							List<WebElement> eval = driver.findElements(By.xpath("//*[@id='evaluation']/div[1]/div/a"));
							int star = 0;
							for (int l = 0; l < 5; l++) {
								String text = eval.get(l).getAttribute("class");
								if (text.contains("checked")) {
									star++;
								}
							}
							System.out.println("学员评价" + star + "星");
						}
						driver.findElement(By.xpath("//*[@id='header']/div")).click();
						Thread.sleep(1000);
						break;
					default:
						break;
					}
				}
			}
			Thread.sleep(2000);
			WebElement back2 = driver.findElement(By.xpath("//*[@id='header']/div"));
			back2.click();
		}
	}

	private void imginput(String path,String browse) throws Exception {
		List<WebElement> tmda = driver.findElements(By.className("topic_form"));
		System.out.println("试卷共" + tmda.size() + "题");
		for (int l = 0; l < tmda.size(); l++) {
			if (l >= 3) {
				// 向下滚动
				tool.html(driver, "scrollTo(0,1000)");
			}
			Thread.sleep(100);
			WebElement daan = tmda.get(l).findElement(By.xpath("./div/div[2]/div/a"));
			try {
				WebElement submit = tmda.get(l).findElement(By.xpath("./div/a"));
				if (submit.getText().equals("提交答案")) {
					daan.click();
					Thread.sleep(500);
					Runtime.getRuntime()
							.exec("C:\\Users\\陆石勤\\Desktop\\FileInput.exe"+" "+browse+ " " + path + "img\\" + l + ".jpg");
					Thread.sleep(3000);
					submit.click();
					Thread.sleep(3000);
				} else {
					System.out.println("已提交答案");
				}
			} catch (Exception e) {
				System.out.println("题目批改中");
			}
		}
		// 向上滚动
		tool.html(driver, "scrollTo(0,1)");
		Thread.sleep(100);
		WebElement back1 = driver.findElement(By.xpath("//*[@id='header']/div"));
		back1.click();
	}

	/**
	 * @param phones
	 * @throws Exception
	 *             公客登陆
	 */
	public void gookerLogin(String[] phones) throws Exception {
		driver.get("http://examtest.newgs.net/gkwap.php/GoogkerApi/WapGongker/login");
		Thread.sleep(100);
		driver.findElement(By.id("mobile")).sendKeys(phones[random.nextInt(phones.length)]);
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='login']/div/div[2]/a")).click();
		Thread.sleep(2000);
	}

	/**
	 * 任务列表
	 * 
	 * @throws Exception
	 */
	public void TackList(int num) throws Exception {
		for (int i = 0; i < num; i++) {
			Thread.sleep(1000);
			WebElement taskListR = driver
					.findElement(By.xpath("//*[@id='main']/table/tbody/tr/td[2]/div/div/table/tbody/tr[2]/td[5]/a"));
			String taskType = taskListR
					.findElement(By.xpath("//*[@id='main']/table/tbody/tr/td[2]/div/div/table/tbody/tr[2]/td[2]"))
					.getText();
			String taskStatus = taskListR
					.findElement(By.xpath("//*[@id='main']/table/tbody/tr/td[2]/div/div/table/tbody/tr[2]/td[4]"))
					.getText();
			if (taskStatus.equals("待接单")) {
				taskListR.click();
				Thread.sleep(4000);
				WebElement jd = driver
						.findElement(By.xpath(".//*[@id='main']/table/tbody/tr/td[2]/div/div/div[2]/button[1]"));
				jd.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/button[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(".//*[@id='nav']/div[2]/ul/li/a")).click();
				Thread.sleep(2000);
			} else if (taskStatus.equals("诊断题目中")) {
				tackCheck(taskListR, taskType);
			} else {
				System.out.println("不需要进行批改");
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='nav']/div[2]/ul/li/a")).click();
			Thread.sleep(1000);
		}
	}

	private void tackCheck(WebElement taskListR, String taskType) throws Exception {
		if (taskType.startsWith("概括题") || taskType.startsWith("对策题")) {
			taskListR.click();
			gkorDc();
		} else if (taskType.startsWith("分析题")) {
			taskListR.click();
			fx();
		} else if (taskType.startsWith("应用文")) {
			taskListR.click();
			yyw();
		} else if (taskType.startsWith("作文题")) {
			taskListR.click();
			zw();
		} else {
			System.out.println("不支持的批改形式");
		}
	}

	private void gkorDc() throws Exception {
		try {
			List<WebElement> xxList = driver.findElements(By.cssSelector(".each_index_of_num"));
			for (int i = 0; i < xxList.size(); i++) {
				Thread.sleep(300);
				xxList.get(i).findElement(By.xpath(".//div[2]/div[1]")).click();
				Thread.sleep(200);
				List<WebElement> yd = xxList.get(i).findElements(By.xpath(".//div[2]/div[2]/table/tr/td[1]/div/a"));
				int num = random.nextInt(yd.size());
				yd.get(num).click();
				Thread.sleep(100);
				if (num == (yd.size() - 1)) {
					xxList.get(i).findElement(By.xpath(".//div[1]/input")).clear();
				} else {
					xxList.get(i).findElement(By.xpath(".//div[1]/input")).sendKeys("" + num + "" + 1);
				}
				xxList.get(i).findElement(By.xpath(".//div[2]/div[2]/table/tr/td[2]/button")).click();
			}
			driver.findElement(By.cssSelector(".btn.btn-info.save_correct_v4")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".to_right_page>a")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btn.btn-info.post_correct_complete")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".top_nav_active>a")).click();
			Thread.sleep(1000);

		} catch (Exception e) {
		}
	}

	private void fx() throws Exception {
		driver.findElement(By.xpath(".//*[@class='chosen-single']/span")).click();
		List<WebElement> options = driver.findElements(By.xpath(".//*[@class='chosen-results']/li"));

		int num = random.nextInt(options.size()) + 1;
		if (num == 0) {
			num++;
			options.get(num).click();
			;
			gkorDc();
		} else if (num == (options.size() + 1)) {
			options.get(num).click();
			driver.findElement(By.cssSelector(".btn.btn-info.save_correct_v4")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".to_right_page>a")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btn.btn-info.post_correct_complete")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".top_nav_active>a")).click();
			Thread.sleep(1000);
		} else {
			options.get(num).click();
			gkorDc();
		}
	}

	private void yyw() throws Exception {
		try {

			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@class='chosen-single']/span")).click();
			List<WebElement> options = driver.findElements(By.xpath(".//*[@class='chosen-results']/li"));

			int num = random.nextInt(options.size()) + 1;
			if (num == 0) {
				num++;
				options.get(num).click();
				yydang(num);
			} else if (num == options.size()) {
				options.get(num).click();
				driver.findElement(By.cssSelector(".btn.btn-info.save_correct_v4")).click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector(".to_right_page>a")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".btn.btn-info.post_correct_complete")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".top_nav_active>a")).click();
				Thread.sleep(1000);
			} else {
				options.get(num).click();
				yydang(num);
			}
		} catch (Exception e) {
			System.out.println("应用文按要点诊断");
			gkorDc();
		}
	}

	private void yydang(int num) throws Exception {
		List<WebElement> list1 = driver.findElements(By.cssSelector(".form-control.readonly.selected_text"));
		for (int i = 0; i < list1.size(); i++) {
			list1.get(i).click();
			Thread.sleep(500);
			List<WebElement> xx = list1.get(i).findElements(By.xpath("..//../div[2]/table/tr/td[1]/div/a"));
			Thread.sleep(100);
			xx.get(random.nextInt(xx.size())).click();
			Thread.sleep(100);
			list1.get(i).findElement(By.xpath("..//../div[2]/table/tr/td[2]/button")).click();
		}
		Select wzjg = new Select(driver
				.findElement(By.xpath(".//*[@id='main_correct_page']/div[2]/div/div/div[3]/div[3]/div[1]/select")));
		wzjg.selectByValue("" + (random.nextInt(3) + 1) + "");
		Select wzbd = new Select(
				driver.findElement(By.xpath(".//*[@id='main_correct_page']/div[2]/div/div/div[3]/div[4]/div/select")));
		wzbd.selectByValue("" + (random.nextInt(3) + 1) + "");
		Select gjyd = new Select(
				driver.findElement(By.xpath(".//*[@id='main_correct_page']/div[2]/div/div/div[3]/div[5]/div/select")));
		gjyd.selectByValue("" + (random.nextInt(3) + 1) + "");

		List<WebElement> inputList = driver.findElements(By.cssSelector(".form-control.inline_input_text"));
		for (int i = 0; i < inputList.size(); i++) {
			if (inputList.get(i).getAttribute("readonly") == "true") {

			} else {
				inputList.get(i).sendKeys("1" + i);
			}
		}
		List<WebElement> textareas = driver.findElements(By.tagName("textarea"));
		for (int i = 0; i < textareas.size(); i++) {
			if (textareas.get(i).getAttribute("readonly") == "true") {

			} else {
				textareas.get(i).sendKeys("点评内容" + i);
			}
		}
		Thread.sleep(2000);

		List<WebElement> scores = driver.findElements(By.xpath(".//*[@class='div_choose_score']/select"));
		for (int i = 0; i < scores.size(); i++) {
			scores.get(i).click();
			List<WebElement> sc = scores.get(i).findElements(By.xpath(".//option"));
			int n = random.nextInt(sc.size());
			if (n == 0) {
				sc.get(sc.size() - 1).click();
			} else {
				sc.get(n).click();
			}
			Thread.sleep(1000);
		}

		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn.btn-info.save_correct_v4")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".to_right_page>a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn.btn-info.post_correct_complete")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".top_nav_active>a")).click();
		Thread.sleep(1000);

	}

	private void zw() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@class='chosen-single']/span")).click();
		List<WebElement> options = driver.findElements(By.xpath(".//*[@class='chosen-results']/li"));

		int num = random.nextInt(options.size()) + 1;
		if (num == 0) {
			num++;
			options.get(num).click();
			zwdang(num);
		} else if (num == options.size()) {
			options.get(num).click();
			driver.findElement(By.cssSelector(".btn.btn-info.save_correct_v4")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".to_right_page>a")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btn.btn-info.post_correct_complete")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".top_nav_active>a")).click();
			Thread.sleep(1000);
		} else {
			options.get(num).click();
			zwdang(num);
		}
	}

	private void zwdang(int num) throws Exception {
		try {
			List<WebElement> list1 = driver.findElements(By.cssSelector(".form-control.readonly.selected_text"));
			for (int i = 0; i < list1.size(); i++) {
				Thread.sleep(100);
				System.out.println("i = " + i);
				list1.get(i).click();
				Thread.sleep(500);
				List<WebElement> xx = list1.get(i).findElements(By.xpath("..//../div[2]/table/tr/td[1]/div/a"));
				Thread.sleep(100);
				xx.get(random.nextInt(xx.size())).click();
				Thread.sleep(100);
				list1.get(i).findElement(By.xpath("..//../div[2]/table/tr/td[2]/button")).click();
			}
			Select wzjg = new Select(driver.findElement(
					By.xpath(".//*[@id='main_correct_page']/div[2]/div/div[1]/div[3]/div[3]/div[1]/select")));
			wzjg.selectByValue("" + (random.nextInt(3) + 1) + "");

			List<WebElement> zd = driver.findElements(By.xpath(".//*[@class='each_point_bp_element']/select"));
			for (int i = 1; i < zd.size(); i++) {
				List<WebElement> opt = zd.get(i).findElements(By.xpath(".//option"));
				int optn = random.nextInt(opt.size());
				if (optn == 0) {
					opt.get(1).click();
				} else {
					opt.get(optn).click();
				}
			}

			List<WebElement> inputs = driver.findElements(By.cssSelector(".form-control.inline_input_text"));
			for (int i = 0; i < inputs.size(); i++) {
				if (inputs.get(i).getAttribute("readonly") == "true") {

				} else {
					inputs.get(i).sendKeys("1" + i);
				}
			}
			List<WebElement> textarea = driver.findElements(By.tagName("textarea"));
			for (int i = 0; i < textarea.size(); i++) {
				if (textarea.get(i).getAttribute("readonly") == "true") {

				} else {
					textarea.get(i).sendKeys("textarea:" + i);
				}
			}

			List<WebElement> scores = driver.findElements(By.xpath(".//*[@class='div_choose_score']/select"));
			for (int i = 0; i < scores.size(); i++) {
				scores.get(i).click();
				Thread.sleep(1000);
				List<WebElement> sc = scores.get(i).findElements(By.xpath(".//option"));
				int n = random.nextInt(sc.size());
				if (n == 0) {
					sc.get(sc.size() - 1).click();
				} else {
					sc.get(n).click();
				}
				Thread.sleep(1000);
			}

			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btn.btn-info.save_correct_v4")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".to_right_page>a")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".btn.btn-info.post_correct_complete")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".top_nav_active>a")).click();
			Thread.sleep(1000);

		} catch (Exception e) {
		}
	}

	private void shenh(int num) throws Exception {
		WebElement shenHe1 = driver.findElement(By.xpath("//*[@id='side-menu']/li[3]"));
		shenHe1.click();
		Thread.sleep(1000);
		WebElement zjRw = driver.findElement(By.xpath("//*[@id='side-menu']/li[3]/ul/li[7]"));
		zjRw.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		int n = 0;
		for (int i = 0; i < num; i++) {
			if (i == 20) {
				n++;
				driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[2]/div/div/a[" + n + "]"))
						.click();
				Thread.sleep(2000);
				i = 0;
			} else {
			}
			System.out.println("i = " + i);
			List<WebElement> Rw = driver
					.findElements(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[3]/table/tbody/tr"));
			WebElement rwXq = Rw.get(i).findElement(By.xpath("./td[9]/a"));
			rwXq.click();
			Thread.sleep(200);
			WebElement ueid = driver
					.findElement(By.xpath("//*[@id='bodymain']/div/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]"));
			String ue_id = ueid.getText();
			List<WebElement> tmList = driver
					.findElements(By.xpath("//*[@id='bodymain']/div/div[2]/div/div/div[2]/table/tbody/tr"));
			for (int j = 0; j < tmList.size(); j++) {
				List<WebElement> tm = driver
						.findElements(By.xpath("//*[@id='bodymain']/div/div[2]/div/div/div[2]/table/tbody/tr"));
				WebElement cktm = tm.get(j).findElement(By.xpath("./td[3]/a"));
				cktm.click();
				Thread.sleep(1000);
				WebElement ecid = driver.findElement(
						By.xpath("//*[@id='bodymain']/div/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]"));
				String ec_id = ecid.getText();
				WebElement status = driver.findElement(
						By.xpath("//*[@id='bodymain']/div/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]"));
				String pgstatus = status.getText();
				System.out.println("ue_id = " + ue_id + " ec_id = " + ec_id + " " + pgstatus);
				if (pgstatus.equals("诊断待审核")) {
					try {
						driver.findElement(By
								.xpath("//*[@id='bodymain']/div/div[1]/div[2]/div/div[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[3]/input"))
								.click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("/html/body/div[5]/div[7]/div/button")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("/html/body/div[5]/div[7]/button")).click();
						Thread.sleep(2000);
					} catch (Exception e) {
						System.out.print("任务已分配");
					}
				} else {
				}
				Thread.sleep(2000);
				WebElement back2 = driver.findElement(By.xpath("//*[@id='bodymain']/div/div[1]/div[1]/div/div/button"));
				back2.click();
				Thread.sleep(1000);
			}
			WebElement back1 = driver.findElement(By.xpath("//*[@id='bodymain']/div/div[1]/div[1]/div/button"));
			back1.click();
			Thread.sleep(200);

		}
		driver.switchTo().parentFrame();
		WebElement closeframe = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/nav/div/a[2]/i"));
		closeframe.click();
		WebElement shenHe2 = driver.findElement(By.xpath("//*[@id='side-menu']/li[3]"));
		shenHe2.click();
	}
}
