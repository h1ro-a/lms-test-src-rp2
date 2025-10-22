package jp.co.sss.lms.ct.f01_login1;

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
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {

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
	void test01() throws Exception {
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
	@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
	void test02() throws Exception {

		//要素の取得と入力
		WebElement userName = webDriver.findElement(By.className("loginId"));
		WebElement password = webDriver.findElement(By.className("password"));
		//存在しない値を入力（入力制限に引っかかるワードなのでログインは不可能）
		userName.clear();
		password.clear();
		userName.sendKeys("hoge");
		password.sendKeys("hoge");

		//ログインボタンをクリック
		WebElement doLogin = webDriver.findElement(By.cssSelector("button[type='submit']"));
		doLogin.click();

		//エラーをキャッチ
		WebElement catchErrorElement = webDriver.findElement(By.className("help-inline error"));
		assertEquals("ログインに失敗しました。", catchErrorElement.getText());
		//エビデンスを取得
		getEvidence(new Object() {
		});

		// 開いたページのキャプチャを取得する

	}

}
