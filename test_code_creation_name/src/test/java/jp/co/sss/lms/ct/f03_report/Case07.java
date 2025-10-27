package jp.co.sss.lms.ct.f03_report;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
 * 結合テスト レポート機能
 * ケース07
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース07 受講生 レポート新規登録(日報) 正常系")
public class Case07 {

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
	@DisplayName("テスト03 未提出の研修日の「詳細」ボタンを押下しセクション詳細画面に遷移")
	void test03() {
		//一番上の項目の詳細ボタンをクリック
		List<WebElement> detailBtns = webDriver.findElements(By.className("btn-default"));
		detailBtns.get(0).click();

		//要素の取得と確認（セクション詳細画面)
		WebElement elmCourse = webDriver.findElement(By.className("active"));
		assertEquals("セクション詳細", elmCourse.getText());

	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「提出する」ボタンを押下しレポート登録画面に遷移")
	void test04() {
		// TODO ここに追加
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 報告内容を入力して「提出する」ボタンを押下し確認ボタン名が更新される")
	void test05() {
		// TODO ここに追加
	}

}
