package Manager;

import org.openqa.selenium.WebDriver;

import Pages.Education;
import Pages.HomePage;
import Pages.Languages;
import Pages.Licences;
import Pages.Membership;
import Pages.Qualifications;
import Pages.Skill;
import Pages.adminTab;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homepage;
	private adminTab admin;
	private Qualifications qual;
	private Skill skl;
	private Education edu;
	private Licences lic;
	private Languages lang;
	private Membership member;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public HomePage getHomePage() {

		return (homepage == null) ? homepage = new HomePage(driver) : homepage;

	}

	public adminTab getAdminPage() {

		return (admin == null) ? admin = new adminTab(driver) : admin;

	}

	public Qualifications getQualificationPage() {

		return (qual == null) ? qual = new Qualifications(driver) : qual;

	}

	public Skill getSkillPage() {

		return (skl == null) ? skl = new Skill(driver) : skl;

	}
	public Education getEducationPage() {

		return (edu == null) ? edu = new Education(driver) : edu;

	}

	public Licences getLicencePage() {

		return (lic == null) ?lic = new Licences(driver) : lic;

	}

	public Languages getLanguagePage() {

		return (lang == null) ? lang = new Languages(driver) : lang;

	}

	public Membership getMemberPage() {

		return (member == null) ? member = new Membership(driver) : member;

	}

}
