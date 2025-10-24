package jp.co.sss.lms.ct.f02_faq;

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
 * 結合テスト よくある質問機能
 * ケース06
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース06 カテゴリ検索 正常系")
public class Case06 {

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

	@Test
	@Order(5)
	@DisplayName("テスト05 カテゴリ検索で該当カテゴリの検索結果だけ表示")
	void test05() {
		//画面の要素の取得と確認
		WebElement ctgrySearch = webDriver.findElement(By.xpath("//legend[text()='カテゴリ検索']"));
		assertEquals("カテゴリ検索", ctgrySearch.getText());

		//カテゴリ検索のリンクのクリック
		WebElement ctgryLink = webDriver.findElement(By.xpath("//a[text()='【研修関係】]"));
		ctgryLink.click();

		//表示された要素の判定
		List<WebElement> elms = webDriver.findElements(By.className("sorting_1"));
		assertEquals("キャンセル料・途中退校について", elms.get(0).getText());
		assertEquals("研修の申し込みはどのようにすれば良いですか？", elms.get(1).getText());

		//エビデンスを取得
		getEvidence(new Object() {
		});

	}

	@Test
	@Order(6)
	@DisplayName("テスト06 検索結果の質問をクリックしその回答を表示")
	void test06() {
		//
		final String ELMSTRCANCEL = "受講者の退職や解雇等、やむを得ない事情による途中終了に関してなど、事情をお伺いした上で、協議という形を取らせて頂きます。\n"
				+ "弊社営業担当までご相談下さい。";
		final String ELMSTRENTRY = "営業担当がいる場合は、営業担当までご連絡ください。\n"
				+ "申し込み方法についてご案内させていただきます。\n"
				+ "なお、弊社営業営業がいない場合は、東京ITスクール運営事務局までご連絡いただけると幸いです。";

	}

}
