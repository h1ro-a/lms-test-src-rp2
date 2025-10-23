package jp.co.sss.lms.ct.f02_faq;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 結合テスト よくある質問機能
 * ケース04
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース04 よくある質問画面への遷移")
public class Case04 {

	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		goTo("http://localhost:8080/lms/");

		//要素の取得と確認
		WebElement elm = webDriver.findElement(By.xpath("//h2[text()='ログイン']"));
		assertEquals("ログイン", elm.getText());

		//エビデンスを取得
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {

		//要素の取得と確認
		WebElement elm = webDriver.findElement(By.xpath("//h2[text()='ログイン']"));
		assertEquals("ログイン", elm.getText());

		//要素の取得の入力
		WebElement userName = webDriver.findElement(By.name("loginId"));
		WebElement password = webDriver.findElement(By.name("password"));
		userName.sendKeys(ID);
		password.sendKeys(PASSWORD);

		//ログインボタンをクリック
		WebElement doLogin = webDriver.findElement(By.className("btn-primary"));
		doLogin.click();

		//要素の取得と確認（コース詳細画面）
		WebElement elmCourse = webDriver.findElement(By.className("active"));
		assertEquals("コース詳細", elmCourse.getText());

		//エビデンスを取得
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「ヘルプ」リンクからヘルプ画面に遷移")
	void test03() {

		//要素の取得と確認（コース詳細画面）
		WebElement elmCourse = webDriver.findElement(By.className("active"));
		assertEquals("コース詳細", elmCourse.getText());

		//機能ボタンをクリック
		WebElement drpDownBtn = webDriver.findElement(By.className("dropdown-toggle"));
		drpDownBtn.click();
		//ヘルプをクリック
		WebElement helpBtn = webDriver.findElement(By.xpath("//a[text()='ヘルプ']"));
		helpBtn.click();

		//遷移後の画面の要素の取得と確認
		WebElement helpPage = webDriver.findElement(By.xpath("//h2[text()='ヘルプ']"));
		assertEquals("ヘルプ", helpPage.getText());

		//エビデンスを取得
		getEvidence(new Object() {
		});

	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「よくある質問」リンクからよくある質問画面を別タブに開く")
	void test04() {
		//遷移後の画面の要素の取得と確認
		WebElement helpPage = webDriver.findElement(By.xpath("//h2[text()='ヘルプ']"));
		assertEquals("ヘルプ", helpPage.getText());

		//よくある質問をクリック
		WebElement faqBtn = webDriver.findElement(By.xpath("//a[text()='よくある質問']"));
		faqBtn.click();

		//別ウィンドウを認識
		Object[] windowHandles = webDriver.getWindowHandles().toArray();
		webDriver.switchTo().window((String) windowHandles[1]);

		//遷移後の画面の要素の取得と確認
		WebElement faqPage = webDriver.findElement(By.xpath("//h2[text()='よくある質問']"));
		assertEquals("よくある質問", faqPage.getText());

		//エビデンスを取得
		getEvidence(new Object() {
		});

	}

}
