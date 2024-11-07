package solutions.s4y.puredemo.ui.compose.composables.chats

import android.content.Context
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import solutions.s4y.puredemo.TheApplication
import solutions.s4y.puredemo.R
import java.util.Locale

@RunWith(ParameterizedRobolectricTestRunner::class)
class LikesCountTest(val locale: Locale, val likesCount: Int, val expectedText: String) {
    companion object {
        @Suppress("unused")
        @JvmStatic
        @ParameterizedRobolectricTestRunner.Parameters(name = "{index}: should display text \"{2}\" when input is \"{1}\" for locale \"{0}\"")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(Locale.ENGLISH, 1, "1 person liked you"),
                arrayOf(Locale.ENGLISH, 2, "2 people liked you"),
                arrayOf(Locale.ENGLISH, 5, "5 people liked you"),
                arrayOf(Locale.ENGLISH, 10, "10 people liked you"),
                arrayOf(Locale.ENGLISH, 101, "101 people liked you"),
                arrayOf(Locale("sr"), 1, "1 особа је те лајковала"),
                arrayOf(Locale("sr"), 2, "2 особе су те лајковало"),
                arrayOf(Locale("sr"), 3, "3 особе су те лајковало"),
                arrayOf(Locale("sr"), 4, "4 особе су те лајковало"),
                arrayOf(Locale("sr"), 5, "5 особа су те лајковало"),
                arrayOf(Locale("sr"), 9, "9 особа су те лајковало"),
                arrayOf(Locale("sr"), 10, "10 особа су те лајковало"),
                arrayOf(Locale("sr"), 11, "11 особа су те лајковало"),
                arrayOf(Locale("sr"), 21, "21 особа је те лајковала"),
                arrayOf(Locale("sr"), 101, "101 особа је те лајковала"),
                arrayOf(Locale("ru"), 1, "1 человек тебя лайкнул"),
                arrayOf(Locale("ru"), 2, "2 человека тебя лайкнул"),
                arrayOf(Locale("ru"), 3, "3 человека тебя лайкнул"),
                arrayOf(Locale("ru"), 4, "4 человека тебя лайкнул"),
                arrayOf(Locale("ru"), 5, "5 человек тебя лайкнули"),
                arrayOf(Locale("ru"), 6, "6 человек тебя лайкнули"),
                arrayOf(Locale("ru"), 7, "7 человек тебя лайкнули"),
                arrayOf(Locale("ru"), 8, "8 человек тебя лайкнули"),
                arrayOf(Locale("ru"), 9, "9 человек тебя лайкнули"),
                arrayOf(Locale("ru"), 10, "10 человек тебя лайкнули"),
                arrayOf(Locale("ru"), 11, "11 человек тебя лайкнули"),
                arrayOf(Locale("ru"), 21, "21 человек тебя лайкнул"),
                arrayOf(Locale("ru"), 101, "101 человек тебя лайкнул"),
            )
        }
    }
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldHaveText() {
        val context = contextForLocale(locale)
        composeTestRule.setContent {
            CompositionLocalProvider(LocalContext provides context) {
                LikesCount(likesCount, true)
            }
        }
        composeTestRule.onNodeWithText(expectedText).assertExists()
    }

    @Test
    fun shouldGetResource() {
        val context = contextForLocale(locale)
        val actualResourceText =
          context.resources.getQuantityString(R.plurals.likes_count, likesCount, likesCount)

        var actualComposeText = ""
        composeTestRule.setContent {
            CompositionLocalProvider(LocalContext provides context) {
                actualComposeText = pluralStringResource(id = R.plurals.likes_count, count=likesCount, likesCount)
            }
        }
        assertEquals(expectedText, actualResourceText)
        assertEquals(expectedText, actualComposeText)
    }

    private fun contextForLocale(locale: Locale): Context {
        Locale.setDefault(locale)
        val context = ApplicationProvider.getApplicationContext<TheApplication>()
        val resources = context.resources
        val config = resources.configuration
        config.setLocale(locale)
        return context.createConfigurationContext(config)
    }
}