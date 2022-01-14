package tests;

import libs.Platform;
import ui.*;
import ui.factories.*;

public class ReadingListTests extends CoreTestCase {
    private WelcomePageObject welcomePageObject;
    private MainPageObject mainPageObject;
    private SearchPageObject searchPageObject;
    private ArticlePageObject articlePageObject;
    private ReadingListPageObject readingListPageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        welcomePageObject = WelcomePageObjectFactory.get(this.driver);
        mainPageObject = MainPageObjectFactory.get(this.driver);
        searchPageObject = SearchPageObjectFactory.get(this.driver);
        articlePageObject = ArticlePageObjectFactory.get(this.driver);
        readingListPageObject = ReadingListPageObjectFactory.get(this.driver);
    }

    public void testAddAndDeleteArticlesInReadingList() {
        final String
                searchText = "star wars",
                readingListName = "Star Wars Reading List",
                firstArticleTitle = "Star Wars",
                secondArticleTitle = "Star Wars (film)";

        // Закрываем приветственный экран
        if (Platform.getInstance().isIOS()) {
            welcomePageObject.clickSkipButton();
        }

        // Выполняем поиск и открываем первую статью
        mainPageObject.clickSearchContainer();
        searchPageObject.sendKeysToSearchInputField(searchText);
        searchPageObject.clickArticleTitleInSearchResults(firstArticleTitle);

        // Добавляем открытую статью в новый лист чтения
        articlePageObject.clickSaveToReadingListButton();
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.clickGotItButtonAndroid();
        } else {
            articlePageObject.clickAddToReadingListButtonIos(firstArticleTitle);
            readingListPageObject.clickCreateNewButton();
        }
        readingListPageObject.sendKeysToReadingListNameInputField(readingListName);
        readingListPageObject.clickConfirmCreationButton();

        // Закрываем открытую статью, повторяем поиск и открываем вторую статью
        articlePageObject.clickBackButton();
        if (Platform.getInstance().isAndroid()) {
            // В Android возврат происходит к главному экрану, в iOS - к результатам предыдущешго поиска
            mainPageObject.clickSearchContainer();
            searchPageObject.sendKeysToSearchInputField(searchText);
        }
        searchPageObject.clickArticleTitleInSearchResults(secondArticleTitle);

        // Добавляем вторую статью в уже созданный лист чтения
        articlePageObject.clickSaveToReadingListButton();
        if (Platform.getInstance().isIOS()) {
            articlePageObject.clickAddToReadingListButtonIos(secondArticleTitle);
        }
        readingListPageObject.clickExistingReadingList(readingListName);


        articlePageObject.clickBackButton();

        // Удаляем первую статью из листа чтения, проверяем, что в нем осталась только вторая статья
        readingListPageObject.openMyLists();
        readingListPageObject.removeArticleFromReadingList(readingListName, firstArticleTitle);
        assertFalse(readingListPageObject.isArticlePresentInCurrentReadingList(firstArticleTitle));
        assertTrue(readingListPageObject.isArticlePresentInCurrentReadingList(secondArticleTitle));

        // Открываем вторую статью и проверяем ее заголовок на соответствие ожидаемому значению
        readingListPageObject.openArticleFromCurrentReadingList(secondArticleTitle);
        //final String openArticleTitle = articlePageObject.getArticleTitleText();
        //assertEquals(secondArticleTitle, openArticleTitle);
    }
}
